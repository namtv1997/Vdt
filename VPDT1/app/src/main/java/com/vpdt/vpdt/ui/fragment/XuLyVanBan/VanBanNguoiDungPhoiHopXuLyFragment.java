package com.vpdt.vpdt.ui.fragment.XuLyVanBan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanNguoiDungPhoiHopXuLy;
import com.vpdt.vpdt.presenter.VanBanNguoiDungPhoiHopXuLyPresenter;
import com.vpdt.vpdt.presenter.VanBanNguoiDungPhoiHopXuLyView;
import com.vpdt.vpdt.presenter.impl.VanBanNguoiDungPhoiHopXuLyPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBVanBanNguoiDungPhoiHopXuLyActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterVanBanNguoiDungPhoiHopXuLy;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VanBanNguoiDungPhoiHopXuLyFragment extends BaseFragment<VanBanNguoiDungPhoiHopXuLyPresenter> implements VanBanNguoiDungPhoiHopXuLyView,
        AdapterVanBanNguoiDungPhoiHopXuLy.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerviewTSLDT)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViecTongSoLuongDonThuKNTC)
    Button btnNamLamViec;
    @BindView(R.id.btnBackTongSoLuongDonThuKNTC)
    Button btnBack;
    @BindView(R.id.swipe_layoutTSLDT)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;


    private EndlessRecyclerViewScrollListener scrollListener;
    private AdapterVanBanNguoiDungPhoiHopXuLy listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_van_ban_nguoi_dung_phoi_hop_xu_ly;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + "   ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getAllVBNguoiDungPhoiHopXuLy(NamLamViec, true);

        listAdapter = new AdapterVanBanNguoiDungPhoiHopXuLy(getPresenter().VAN_BAN_NGUOI_DUNG_PHOI_HOP_XU_LY_ARRAY_LIST(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getAllVBNguoiDungPhoiHopXuLy(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getAllVBNguoiDungPhoiHopXuLy(NamLamViec, false);

            }
        };
        recyclerview.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countAllVBNguoiDungPhoiHopXuLy(NamLamViec);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }


    @OnClick({R.id.btnNamLamViecTongSoLuongDonThuKNTC, R.id.btnBackTongSoLuongDonThuKNTC,
            R.id.lntsvb, R.id.rltsltct, R.id.vDSVBDaChiDao, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecTongSoLuongDonThuKNTC:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_nam_selected, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rvSelectNam = view1.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();

                break;
            case R.id.btnBackTongSoLuongDonThuKNTC:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;

        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + "   ");
        getPresenter().getAllVBNguoiDungPhoiHopXuLy(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public VanBanNguoiDungPhoiHopXuLyPresenter createPresenter() {
        return new VanBanNguoiDungPhoiHopXuLyPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(VanBanNguoiDungPhoiHopXuLy vanBanNguoiDungXuLy) {
        if (vanBanNguoiDungXuLy.getUrlFile().isEmpty() || vanBanNguoiDungXuLy.getUrlFile() == null) {
            Toast.makeText(getActivity(), "Không có file đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanNguoiDungXuLy.getUrlFile()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(VanBanNguoiDungPhoiHopXuLy vanBanNguoiDungXuLy) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBVanBanNguoiDungPhoiHopXuLyActivity.class);
            intent.putExtra("vanBanNguoiDungXuLy", vanBanNguoiDungXuLy);
            startActivity(intent);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(VanBanNguoiDungPhoiHopXuLy vanBanNguoiDungXuLy) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity.class);
            intent.putExtra("id_vb", vanBanNguoiDungXuLy.getId());
            startActivity(intent);
            click = true;
        }

    }
}
