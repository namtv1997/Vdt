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
import com.vpdt.vpdt.model.DSVB_QuanTrong;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DSVB_QuanTrongView;
import com.vpdt.vpdt.presenter.DSVB_QuanTrong_Presenter;
import com.vpdt.vpdt.presenter.impl.DSVB_QuanTrong_PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVB_DSVB_QuanTrong;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.Adapter_DSVB_QuanTrong;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DSVB_QuanTrongCuaSoFragment extends BaseFragment<DSVB_QuanTrong_Presenter> implements DSVB_QuanTrongView,
        Adapter_DSVB_QuanTrong.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {
    @BindView(R.id.recyclerviewQuanTrong)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViecDSVBQuanTrongCuaSo)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layoutQuanTrong)
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
    private Adapter_DSVB_QuanTrong listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dsvb_quantrong;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        tvTinhTrang.setText("Đã hoàn thành");
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
            getPresenter().getallvbquantronghoanthanh(NamLamViec, true);
        } else if (tvTinhTrang.getText().equals("Chưa hoàn thành")) {
            getPresenter().getallvbquantrongchuahoanthanh(NamLamViec, true);
        }

        listAdapter = new Adapter_DSVB_QuanTrong(getActivity(), getPresenter().dsvb_quanTrong(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
                    getPresenter().getallvbquantronghoanthanh(NamLamViec, true);
                } else if (tvTinhTrang.getText().equals("Chưa hoàn thành")) {
                    getPresenter().getallvbquantrongchuahoanthanh(NamLamViec, true);
                }
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
                    getPresenter().getallvbquantronghoanthanh(NamLamViec, false);
                } else if (tvTinhTrang.getText().equals("Chưa hoàn thành")) {
                    getPresenter().getallvbquantrongchuahoanthanh(NamLamViec, false);
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

    @OnClick({R.id.btnNamLamViecDSVBQuanTrongCuaSo, R.id.btnBackDSVBQuanTrongCuaSo, R.id.spnTinhTrangTSLDT,
            R.id.vqt, R.id.lnqt, R.id.rlqt, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecDSVBQuanTrongCuaSo:
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
            case R.id.btnBackDSVBQuanTrongCuaSo:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;
            case R.id.spnTinhTrangTSLDT:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view2 = inflater1.inflate(R.layout.list_item_don_thu_kntc, null);
                builder1.setView(view2);
                final AlertDialog dialog = builder1.create();
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView tvDaHoanThanh = view2.findViewById(R.id.tvDaHoanThanh);
                TextView tvChuaHoanThanh = view2.findViewById(R.id.tvChuaHoanThanh);
                tvDaHoanThanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallvbquantronghoanthanh(NamLamViec, true);
                        tvTinhTrang.setText("Đã hoàn thành");
                        dialog.dismiss();
                    }
                });
                tvChuaHoanThanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallvbquantrongchuahoanthanh(NamLamViec, true);
                        tvTinhTrang.setText("Chưa hoàn thành");
                        dialog.dismiss();
                    }
                });
                break;
        }
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
            getPresenter().countvbquantronghoanthanh(NamLamViec);
        } else if (tvTinhTrang.getText().equals("Chưa hoàn thành")) {
            getPresenter().countvbquantrongchuahoanthanh(NamLamViec);
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
    public DSVB_QuanTrong_Presenter createPresenter() {
        return new DSVB_QuanTrong_PresenterImpl(this);
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        if (tvTinhTrang.getText().equals("Đã hoàn thành")) {
            getPresenter().getallvbquantronghoanthanh(String.valueOf(integer), true);
        } else if (tvTinhTrang.getText().equals("Chưa hoàn thành")) {
            getPresenter().getallvbquantrongchuahoanthanh(String.valueOf(integer), true);
        }
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(DSVB_QuanTrong dsvb_quanTrong) {
        try {
            if (dsvb_quanTrong.getTepDinhKems().size() == 0) {
                Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
            } else if (dsvb_quanTrong.getTepDinhKems().size() == 1) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsvb_quanTrong.getTepDinhKems().get(0).getDuongDan()));
                startActivity(browserIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsvb_quanTrong.getTepDinhKems().get(dsvb_quanTrong.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXuLy(DSVB_QuanTrong dsvb_quanTrong) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVB_DSVB_QuanTrong.class);
            intent.putExtra("ID_VANBANQUANTRONG", dsvb_quanTrong.getId());
            intent.putExtra("PHONGCHUTRI", dsvb_quanTrong.getPhongChuTri());
            intent.putExtra("NGUOINHAP", dsvb_quanTrong.getNguoiNhap());
            startActivity(intent);
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(DSVB_QuanTrong dsvb_quanTrong) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
            intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", dsvb_quanTrong.getId());
            startActivity(intent);
            click = true;
        }
    }
}