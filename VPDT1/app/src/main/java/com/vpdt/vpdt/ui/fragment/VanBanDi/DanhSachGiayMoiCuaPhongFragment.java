package com.vpdt.vpdt.ui.fragment.VanBanDi;

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
import com.vpdt.vpdt.model.GiayMoiCuaPhong;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DSGiayMoiCuaPhongView;
import com.vpdt.vpdt.presenter.DSGiayMoiCuaPhong_Presenter;
import com.vpdt.vpdt.presenter.impl.DSGiayMoiCuaPhong_PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.NDVBDanhSachGiayMoiCuaPhongActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.TTVBDanhSachGiayMoiCuaPhongActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachGiayMoiCuaPhong;
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

public class DanhSachGiayMoiCuaPhongFragment extends BaseFragment<DSGiayMoiCuaPhong_Presenter> implements DSGiayMoiCuaPhongView,
        AdapterDanhSachGiayMoiCuaPhong.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.tvTSVB)
    TextView tvTSVB;
    @BindView(R.id.TenVB)
    TextView TenVB;

    String NamLamViec;
    AdapterDanhSachGiayMoiCuaPhong adapterDanhSachGiayMoiCuaPhong;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog1;
    int year;
    boolean click = false;

    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_giay_moi_cua_phong;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        TenVB.setText("Văn bản đã nhập");
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).checkFragment(this);
        click = false;
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        if (TenVB.getText() == "Văn bản đã nhập") {
            getPresenter().getDSGM_cuaPhong(NamLamViec, 0, true);
        } else if (TenVB.getText() == "Đã gửi mail") {
            getPresenter().getDSGM_cuaPhong(NamLamViec, 1, true);
        } else if (TenVB.getText() == "Chưa gửi mail") {
            getPresenter().getDSGM_cuaPhong(NamLamViec, 2, true);
        }

        adapterDanhSachGiayMoiCuaPhong = new AdapterDanhSachGiayMoiCuaPhong(getPresenter().dsvbCuaPhongs(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachGiayMoiCuaPhong);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (TenVB.getText() == "Văn bản đã nhập") {
                    getPresenter().getDSGM_cuaPhong(NamLamViec, 0, false);
                } else if (TenVB.getText() == "Đã gửi mail") {
                    getPresenter().getDSGM_cuaPhong(NamLamViec, 1, false);
                } else if (TenVB.getText() == "Chưa gửi mail") {
                    getPresenter().getDSGM_cuaPhong(NamLamViec, 2, false);
                }

            }
        };
        recyclerview.addOnScrollListener(scrollListener);
        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (TenVB.getText() == "Văn bản đã nhập") {
                    getPresenter().getDSGM_cuaPhong(NamLamViec, 0, true);
                } else if (TenVB.getText() == "Đã gửi mail") {
                    getPresenter().getDSGM_cuaPhong(NamLamViec, 1, true);
                } else if (TenVB.getText() == "Chưa gửi mail") {
                    getPresenter().getDSGM_cuaPhong(NamLamViec, 2, true);
                }
            }
        });
    }


    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetDataSuccess() {
        adapterDanhSachGiayMoiCuaPhong.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
        if (TenVB.getText() == "Văn bản đã nhập") {
            getPresenter().countDSGM_cuaPhong(NamLamViec, 0);
        } else if (TenVB.getText() == "Đã gửi mail") {
            getPresenter().countDSGM_cuaPhong(NamLamViec, 1);
        } else if (TenVB.getText() == "Chưa gửi mail") {
            getPresenter().countDSGM_cuaPhong(NamLamViec, 2);
        }
    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0) {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public DSGiayMoiCuaPhong_Presenter createPresenter() {
        return new DSGiayMoiCuaPhong_PresenterImpl(this);
    }

    @OnClick({R.id.TenVB, R.id.btnBack, R.id.vdsgmcs, R.id.lndsgmcs, R.id.rldsgmcs, R.id.btnNamLamViec, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.TenVB:
                AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.list_item_van_ban_cua_so, null);
                builder.setView(view1);
                dialog1 = builder.create();
                Objects.requireNonNull(dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
                TextView btnTatCa = view1.findViewById(R.id.btnTatCa);
                TextView btnVanbanMoiNhap = view1.findViewById(R.id.btnVanbanMoiNhap);
                TextView btnDaGiaiQuyet = view1.findViewById(R.id.btnDaGiaiQuyet);

                btnTatCa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getDSGM_cuaPhong(NamLamViec, 0, true);
                        TenVB.setText("Văn bản đã nhập");
                        dialog1.dismiss();
                    }
                });
                btnVanbanMoiNhap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getDSGM_cuaPhong(NamLamViec, 1, true);
                        TenVB.setText("Đã gửi mail");
                        dialog1.dismiss();
                    }
                });
                btnDaGiaiQuyet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getDSGM_cuaPhong(NamLamViec, 2, true);
                        TenVB.setText("Chưa gửi mail");
                        dialog1.dismiss();
                    }
                });

                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;
            case R.id.btnNamLamViec:
                AlertDialog.Builder builderNamLamViec = new AlertDialog.Builder(getContext());
                LayoutInflater inflaterNamLamViec = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNamLamViec = inflaterNamLamViec.inflate(R.layout.recyclerview_nam_selected, null);
                builderNamLamViec.setView(viewNamLamViec);
                dialog1 = builderNamLamViec.create();
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rvSelectNam = viewNamLamViec.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        NamLamViec = String.valueOf(integer);
        if (TenVB.getText() == "Văn bản đã nhập") {
            getPresenter().getDSGM_cuaPhong(String.valueOf(integer), 0, true);
        } else if (TenVB.getText() == "Đã gửi mail") {
            getPresenter().getDSGM_cuaPhong(String.valueOf(integer), 1, true);
        } else if (TenVB.getText() == "Chưa gửi mail") {
            getPresenter().getDSGM_cuaPhong(String.valueOf(integer), 2, true);
        }
        PrefUtil.saveString(getContext(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog1.dismiss();
    }


    @Override
    public void onItemClickXemFile(GiayMoiCuaPhong dGiayMoiCuaPhong) {
        if (dGiayMoiCuaPhong.getDuongdan().isEmpty() || dGiayMoiCuaPhong.getDuongdan() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dGiayMoiCuaPhong.getDuongdan()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(GiayMoiCuaPhong dGiayMoiCuaPhong) {
        if (!click) {
            Intent i = new Intent(getContext(), NDVBDanhSachGiayMoiCuaPhongActivity.class);
            i.putExtra("dsGiayMoiCuaPhong", dGiayMoiCuaPhong);
            startActivity(i);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(GiayMoiCuaPhong dGiayMoiCuaPhong) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBDanhSachGiayMoiCuaPhongActivity.class);
            intent.putExtra("dsGiayMoiCuaPhong", dGiayMoiCuaPhong.getMavb());
            startActivity(intent);
            click = true;
        }

    }
}