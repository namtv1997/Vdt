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
import com.vpdt.vpdt.model.ToCongTac;
import com.vpdt.vpdt.presenter.ToCongTacView;
import com.vpdt.vpdt.presenter.ToCongTac_Presenter;
import com.vpdt.vpdt.presenter.impl.ToCongTac_PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVB_TongSoLuongToCongtac;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.Adapter_ToCongTac;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TongSoLuongToCongTac_GiaoPhongXuLyFragment extends BaseFragment<ToCongTac_Presenter> implements ToCongTacView,
        Adapter_ToCongTac.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

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
    @BindView(R.id.spnTinhTrangTSLDT)
    TextView tvTinhTrang;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;


    private EndlessRecyclerViewScrollListener scrollListener;
    private Adapter_ToCongTac listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_tong_so_luong_to_cong_tac_giao_phong_xu_ly;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        tvTinhTrang.setText("Đã hoàn thành");
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
            getPresenter().getalltocongtachoanthanh(NamLamViec, true);
        } else if (tvTinhTrang.getText() == "Chưa hoàn thành") {
            getPresenter().getalltocongtacchuahoanthanh(NamLamViec, true);
        }
        listAdapter = new Adapter_ToCongTac(getActivity(), getPresenter().toCongTac(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
                    getPresenter().getalltocongtachoanthanh(NamLamViec, true);
                } else if (tvTinhTrang.getText() == "Chưa hoàn thành") {
                    getPresenter().getalltocongtacchuahoanthanh(NamLamViec, true);
                }
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
                    getPresenter().getalltocongtachoanthanh(NamLamViec, false);

                } else if (tvTinhTrang.getText() == "Chưa hoàn thành") {
                    getPresenter().getalltocongtacchuahoanthanh(NamLamViec, false);
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
        if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
            getPresenter().counttocongtachoanthanh(NamLamViec);
        } else if (tvTinhTrang.getText() == "Chưa hoàn thành") {
            getPresenter().counttocongtacchuahoanthanh(NamLamViec);
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

    @Override
    public ToCongTac_Presenter createPresenter() {
        return new ToCongTac_PresenterImpl(this);
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
                tvDaHoanThanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTinhTrang.setText("Đã hoàn thành");
                        getPresenter().getalltocongtachoanthanh(NamLamViec, true);

                        dialog.dismiss();
                    }
                });
                tvChuaHoanThanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTinhTrang.setText("Chưa hoàn thành");

                        getPresenter().getalltocongtacchuahoanthanh(NamLamViec, true);
                        dialog.dismiss();
                    }
                });
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
            getPresenter().getalltocongtachoanthanh(String.valueOf(integer), true);
        } else {
            getPresenter().getalltocongtacchuahoanthanh(String.valueOf(integer), true);
        }
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }


    @Override
    public void onItemClickXemFile(ToCongTac toCongTac) {
        try {
            if (toCongTac.getTepDinhKems().size() == 0) {
                Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
            } else if (toCongTac.getTepDinhKems().size() == 1) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(toCongTac.getTepDinhKems().get(0).getDuongDan()));
                startActivity(browserIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(toCongTac.getTepDinhKems().get(toCongTac.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXuLy(ToCongTac toCongTac) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVB_TongSoLuongToCongtac.class);
            intent.putExtra("ID_VANBANTOCONGTAC", toCongTac.getId());
            intent.putExtra("PHONGCHUTRI", toCongTac.getPhongChuTri());
            intent.putExtra("NGUOINHAP", toCongTac.getNguoinhap());
            startActivity(intent);
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(ToCongTac toCongTac) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
            intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", toCongTac.getId());
            startActivity(intent);
            click = true;
        }
    }
}
