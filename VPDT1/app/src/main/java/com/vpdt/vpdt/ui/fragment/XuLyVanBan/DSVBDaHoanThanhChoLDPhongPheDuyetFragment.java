package com.vpdt.vpdt.ui.fragment.XuLyVanBan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
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
import com.vpdt.vpdt.model.VanBanHoanThanhChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.presenter.DSVBDaHoanThanhChoLDPhongPheDuyetPresenter;
import com.vpdt.vpdt.presenter.DSVBDaHoanThanhChoLDPhongPheDuyetView;
import com.vpdt.vpdt.presenter.impl.DSVBDaHoanThanhChoLDPhongPheDuyetPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBVanBanHoanThanhDaDuyetActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDSVBDaHoanThanhChoLDPhongPheDuyet;
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

public class DSVBDaHoanThanhChoLDPhongPheDuyetFragment extends BaseFragment<DSVBDaHoanThanhChoLDPhongPheDuyetPresenter> implements DSVBDaHoanThanhChoLDPhongPheDuyetView,
        AdapterDSVBDaHoanThanhChoLDPhongPheDuyet.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerviewTSLDT)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViecTongSoLuongDonThuKNTC)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layoutTSLDT)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;
    @BindView(R.id.spnTinhTrangTSLDT)
    TextView tvTinhTrang;
    @BindView(R.id.tvTitle)
    TextView tvTitle;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year, level;
    boolean click = false;


    private EndlessRecyclerViewScrollListener scrollListener;
    private AdapterDSVBDaHoanThanhChoLDPhongPheDuyet listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dsvb_da_hoan_thanh_cho_ld_phong_phe_duyet;
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
        String key;
        Bundle bundle = getArguments();
        if (bundle != null) {
            key = bundle.getString("keyvb");
            if (key != null) {
                if (key.equals(Key.vBHoanThanhDaPheDuyetCV)) {
                    tvTinhTrang.setText("Đã phê duyệt");
                } else {
                    tvTinhTrang.setText("Chưa phê duyệt");
                }
            }
        }
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        level = PrefUtil.getInt(getActivity(), Key.LEVEL, 0);
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + "   ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        if (level == 8) {
            tvTitle.setText("DS VĂN BẢN HOÀN THÀNH");
        }
        if (tvTinhTrang.getText().equals("Chưa phê duyệt")) {
            getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 1, true);
        } else if (tvTinhTrang.getText() == "Đã phê duyệt") {
            getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 2, true);
        }
        listAdapter = new AdapterDSVBDaHoanThanhChoLDPhongPheDuyet(getPresenter().VAN_BAN_HOAN_THANH_CHO_LANH_DAO_PHONG_PHE_DUYET_ARRAY_LIST(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (tvTinhTrang.getText().equals("Chưa phê duyệt")) {
                    getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 1, true);
                } else if (tvTinhTrang.getText() == "Đã phê duyệt") {
                    getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 2, true);
                }
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (tvTinhTrang.getText().equals("Chưa phê duyệt")) {
                    getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 1, false);
                } else if (tvTinhTrang.getText() == "Đã phê duyệt") {
                    getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 2, false);
                }
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
        if (tvTinhTrang.getText().equals("Chưa phê duyệt")) {
            getPresenter().countAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 1);
        } else if (tvTinhTrang.getText() == "Đã phê duyệt") {
            getPresenter().countAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 2);
        }

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


    @OnClick({R.id.btnNamLamViecTongSoLuongDonThuKNTC, R.id.btnBackTongSoLuongDonThuKNTC, R.id.spnTinhTrangTSLDT,
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
            case R.id.spnTinhTrangTSLDT:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view2 = inflater1.inflate(R.layout.list_item_don_thu_kntc, null);
                builder1.setView(view2);
                dialog = builder1.create();
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView tvDaHoanThanh = view2.findViewById(R.id.tvDaHoanThanh);
                TextView tvChuaHoanThanh = view2.findViewById(R.id.tvChuaHoanThanh);
                tvDaHoanThanh.setText("Đã phê duyệt");
                tvChuaHoanThanh.setText("Chưa phê duyệt");
                tvDaHoanThanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTinhTrang.setText("Đã phê duyệt");
                        getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 2, true);
                        dialog.dismiss();
                    }
                });
                tvChuaHoanThanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTinhTrang.setText("Chưa phê duyệt");
                        getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(NamLamViec, 1, true);
                        dialog.dismiss();
                    }
                });
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + "   ");
        if (tvTinhTrang.getText().equals("Chưa phê duyệt")) {
            getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(String.valueOf(integer), 1, true);
        } else if (tvTinhTrang.getText() == "Đã phê duyệt") {
            getPresenter().getAllVBDaHoanThanhChoLDPheDuyet(String.valueOf(integer), 2, true);
        }
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }


    @Override
    public DSVBDaHoanThanhChoLDPhongPheDuyetPresenter createPresenter() {
        return new DSVBDaHoanThanhChoLDPhongPheDuyetPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(VanBanHoanThanhChoLanhDaoPhongPheDuyet vanBanHoanThanhChoLanhDaoPhongPheDuyet) {
        if (vanBanHoanThanhChoLanhDaoPhongPheDuyet.getUrlFile().isEmpty() || vanBanHoanThanhChoLanhDaoPhongPheDuyet.getUrlFile() == null) {
            Toast.makeText(getActivity(), "Không có file đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getUrlFile()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(VanBanHoanThanhChoLanhDaoPhongPheDuyet vanBanHoanThanhChoLanhDaoPhongPheDuyet) {
        if (!click) {
            if (level == 8) {
                Intent intent = new Intent(getActivity(), NDVBVanBanHoanThanhDaDuyetActivity.class);
                intent.putExtra("vanBanHoanThanhChoLanhDaoPhongPheDuyet", vanBanHoanThanhChoLanhDaoPhongPheDuyet);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getActivity(), NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity.class);
                intent.putExtra("vanBanHoanThanhChoLanhDaoPhongPheDuyet", vanBanHoanThanhChoLanhDaoPhongPheDuyet);
                startActivity(intent);
            }
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(VanBanHoanThanhChoLanhDaoPhongPheDuyet vanBanHoanThanhChoLanhDaoPhongPheDuyet) {
        if (!click) {
            if (level == 8) {
                Intent intent = new Intent(getActivity(), TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity.class);
                intent.putExtra("id_vb", vanBanHoanThanhChoLanhDaoPhongPheDuyet.getId());
                startActivity(intent);
            } else {
                Intent intent = new Intent(getActivity(), TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity.class);
                intent.putExtra("id_vb", vanBanHoanThanhChoLanhDaoPhongPheDuyet.getId());
                startActivity(intent);
            }
            click = true;
        }

    }
}
