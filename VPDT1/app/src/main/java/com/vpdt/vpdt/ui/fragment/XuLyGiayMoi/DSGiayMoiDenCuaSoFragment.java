package com.vpdt.vpdt.ui.fragment.XuLyGiayMoi;

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
import com.vpdt.vpdt.model.DSGiayMoiDenCuaSo;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DSGiayMoiDenCuaSoPresenter;
import com.vpdt.vpdt.presenter.DSGiayMoiDenCuaSoView;
import com.vpdt.vpdt.presenter.impl.DSGiayMoiDenCuaSoPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.NDVBDanhSachGiayMoiDenCuaSoActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.TTVBBaoCaoCuocHopChoPheDuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDSGiayMoiDenCuaSo;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
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

public class DSGiayMoiDenCuaSoFragment extends BaseFragment<DSGiayMoiDenCuaSoPresenter> implements DSGiayMoiDenCuaSoView,
        AdapterDSGiayMoiDenCuaSo.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTongSoVanBan)
    TextView tvTongSoVanBan;
    @BindView(R.id.tvTinhTrang)
    TextView tvTinhTrang;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    AdapterDSGiayMoiDenCuaSo adapterDSGiayMoiDenCuaSo;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;

    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_giay_moi_den_cua_so;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        tvTinhTrang.setText("-- Tất cả --");
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
        if (tvTinhTrang.getText() == "-- Tất cả --") {
            getPresenter().getallgiaymoi(NamLamViec, true, 0);
        } else if (tvTinhTrang.getText() == "Văn bản mới nhập") {
            getPresenter().getallgiaymoi(NamLamViec, true, 1);
        } else if (tvTinhTrang.getText() == "Đã giải quyết") {
            getPresenter().getallgiaymoi(NamLamViec, true, 2);
        }
        adapterDSGiayMoiDenCuaSo = new AdapterDSGiayMoiDenCuaSo(getActivity(), getPresenter().dsGiayMoiDenCuaSoArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDSGiayMoiDenCuaSo);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (tvTinhTrang.getText() == "-- Tất cả --") {
                    getPresenter().getallgiaymoi(NamLamViec, true, 0);
                } else if (tvTinhTrang.getText() == "Văn bản mới nhập") {
                    getPresenter().getallgiaymoi(NamLamViec, true, 1);
                } else if (tvTinhTrang.getText() == "Đã giải quyết") {
                    getPresenter().getallgiaymoi(NamLamViec, true, 2);
                }
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (tvTinhTrang.getText() == "-- Tất cả --") {
                    getPresenter().getallgiaymoi(NamLamViec, false, 0);
                } else if (tvTinhTrang.getText() == "Văn bản mới nhập") {
                    getPresenter().getallgiaymoi(NamLamViec, false, 1);
                } else if (tvTinhTrang.getText() == "Đã giải quyết") {
                    getPresenter().getallgiaymoi(NamLamViec, false, 2);
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

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.vgmdcs, R.id.lngmdcs, R.id.rlgmdcs, R.id.tvTinhTrang, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViec:
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
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;
            case R.id.tvTinhTrang:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view2 = inflater1.inflate(R.layout.list_item_vanban, null);
                builder1.setView(view2);
                final AlertDialog dialog = builder1.create();
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView btnTatCa = view2.findViewById(R.id.btnTatCa);
                TextView btnVanbanMoiNhap = view2.findViewById(R.id.btnVanbanMoiNhap);
                TextView btnDaGiaiQuyet = view2.findViewById(R.id.btnDaGiaiQuyet);

                btnTatCa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallgiaymoi(NamLamViec, true, 0);
                        tvTinhTrang.setText("-- Tất cả --");
                        dialog.dismiss();
                    }
                });
                btnVanbanMoiNhap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallgiaymoi(NamLamViec, true, 1);
                        tvTinhTrang.setText("Văn bản mới nhập");
                        dialog.dismiss();
                    }
                });
                btnDaGiaiQuyet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallgiaymoi(NamLamViec, true, 2);
                        tvTinhTrang.setText("Đã giải quyết");
                        dialog.dismiss();
                    }
                });
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        if (tvTinhTrang.getText() == "-- Tất cả --") {
            getPresenter().getallgiaymoi(String.valueOf(integer), true, 0);
        } else if (tvTinhTrang.getText() == "Văn bản mới nhập") {
            getPresenter().getallgiaymoi(String.valueOf(integer), true, 1);
        } else if (tvTinhTrang.getText() == "Đã giải quyết") {
            getPresenter().getallgiaymoi(String.valueOf(integer), true, 2);
        }
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetDataSuccess() {
        adapterDSGiayMoiDenCuaSo.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        if (tvTinhTrang.getText() == "-- Tất cả --") {
            getPresenter().countgiaymoi(NamLamViec, 0);
        } else if (tvTinhTrang.getText() == "Văn bản mới nhập") {
            getPresenter().countgiaymoi(NamLamViec, 1);
        } else if (tvTinhTrang.getText() == "Đã giải quyết") {
            getPresenter().countgiaymoi(NamLamViec, 2);
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
        tvTongSoVanBan.setText(String.valueOf(response.getData()));
    }

    @Override
    public DSGiayMoiDenCuaSoPresenter createPresenter() {
        return new DSGiayMoiDenCuaSoPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(DSGiayMoiDenCuaSo dsGiayMoiDenCuaSo) {
        try {
            if (dsGiayMoiDenCuaSo.getTepDinhKems().size() == 0) {
                Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
            } else if (dsGiayMoiDenCuaSo.getTepDinhKems().size() == 1) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsGiayMoiDenCuaSo.getTepDinhKems().get(0).getDuongDan()));
                startActivity(browserIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsGiayMoiDenCuaSo.getTepDinhKems().get(dsGiayMoiDenCuaSo.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXuLy(DSGiayMoiDenCuaSo dsGiayMoiDenCuaSo) {
        if (!click) {
            Intent i = new Intent(getContext(), NDVBDanhSachGiayMoiDenCuaSoActivity.class);
            i.putExtra("DanhSachGiayMoiDenCuaSo", dsGiayMoiDenCuaSo);
            startActivity(i);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(DSGiayMoiDenCuaSo dsGiayMoiDenCuaSo) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
            intent.putExtra("idvb", dsGiayMoiDenCuaSo.getId());
            startActivity(intent);
            click = true;
        }

    }
}
