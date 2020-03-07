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
import com.vpdt.vpdt.model.VanBanDenChoXuLy;
import com.vpdt.vpdt.presenter.DSVB_ChoLanhDaoXuLyView;
import com.vpdt.vpdt.presenter.DSVB_ChoLanhDaoXuLy_Presenter;
import com.vpdt.vpdt.presenter.impl.DSVB_ChoLanhDaoXuLy_PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBDSVBDenChoLDXLActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBDSVBDenChoLDXLPhoGiamDocActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBCongViecPhoiHopChoXuLyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDSVB_ChoLanhDaoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DSVB_ChoLanhDaoXuLyFragment extends BaseFragment<DSVB_ChoLanhDaoXuLy_Presenter> implements DSVB_ChoLanhDaoXuLyView,
        AdapterDSVB_ChoLanhDaoXuLy.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {
    @BindView(R.id.recyclerviewChoXuLy)
    RecyclerView recyclerviewChoXuLy;

    @BindView(R.id.btnNamLamViecChoXuLy)
    Button btnNamLamViecChoXuLy;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;

    String NamLamViec;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year, level;
    boolean click = false;

    private EndlessRecyclerViewScrollListener scrollListener;
    private AdapterDSVB_ChoLanhDaoXuLy listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dsvb_cholanhdaoxuly;
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
        level = PrefUtil.getInt(getActivity(), Key.LEVEL, 0);
        btnNamLamViecChoXuLy.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getallvbdenchoxuly(NamLamViec, true);
        listAdapter = new AdapterDSVB_ChoLanhDaoXuLy(getActivity(), getPresenter().dsvbDaChiDao(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewChoXuLy.setLayoutManager(layoutManager);
        recyclerviewChoXuLy.setAdapter(listAdapter);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getallvbdenchoxuly(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getallvbdenchoxuly(NamLamViec, false);
            }
        };
        recyclerviewChoXuLy.addOnScrollListener(scrollListener);
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
        getPresenter().countvbvbdenchoxuly(NamLamViec);
    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0) {
            recyclerviewChoXuLy.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerviewChoXuLy.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }


    @Override
    public DSVB_ChoLanhDaoXuLy_Presenter createPresenter() {
        return new DSVB_ChoLanhDaoXuLy_PresenterImpl(this);
    }

    @OnClick({R.id.btnNamLamViecChoXuLy, R.id.btnBackChoXuLy,
            R.id.vcldxl, R.id.rlcldxl, R.id.lncldxl1, R.id.lncldxl, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecChoXuLy:
                android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
            case R.id.btnBackChoXuLy:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecChoXuLy.setText("Năm làm việc: " + integer + " ");
        getPresenter().getallvbdenchoxuly(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(VanBanDenChoXuLy vanBanDenChoXuLy) {
        if (vanBanDenChoXuLy.getTepDinhKems().size() == 0) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else if (vanBanDenChoXuLy.getTepDinhKems().size() == 1) {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDenChoXuLy.getTepDinhKems().get(0).getDuongDan()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDenChoXuLy.getTepDinhKems().get(vanBanDenChoXuLy.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onItemClickXuLy(VanBanDenChoXuLy vanBanDenChoXuLy) {
        if (level == 5) {
            if (!click) {
                Intent intent = new Intent(getActivity(), NDVBDSVBDenChoLDXLPhoGiamDocActivity.class);
                intent.putExtra("ID_VANBAN_CHOLANHDAOXULY", vanBanDenChoXuLy.getIdVanBan());
                startActivity(intent);
                click = true;
            }
        } else {
            if (!click) {
                Intent intent = new Intent(getActivity(), NDVBDSVBDenChoLDXLActivity.class);
                intent.putExtra("ID_VANBAN_CHOLANHDAOXULY", vanBanDenChoXuLy.getIdVanBan());
                startActivity(intent);
                click = true;
            }
        }
    }

    @Override
    public void onItemClickXemChiTiet(VanBanDenChoXuLy vanBanDenChoXuLy) {
        if (level == 5) {
            if (!click) {
                Intent intent = new Intent(getActivity(), TTVBCongViecPhoiHopChoXuLyActivity.class);
                intent.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", vanBanDenChoXuLy.getIdVanBan());
                startActivity(intent);
                click = true;
            }
        } else {
            if (!click) {
                Intent intent = new Intent(getActivity(), TTVBCongViecPhoiHopChoXuLyActivity.class);
                intent.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", vanBanDenChoXuLy.getIdVanBan());
                startActivity(intent);
                click = true;
            }
        }
    }
}