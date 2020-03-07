package com.vpdt.vpdt.ui.fragment.VanBanDen;

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
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DanhSachCongTacDangPresenter;
import com.vpdt.vpdt.presenter.DanhSachCongTacDangView;
import com.vpdt.vpdt.presenter.impl.DanhSachCongTacDangPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.NDVBDanhSachCongTacDangActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.TTVBBaoCaoCuocHopChoPheDuyetActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachCongTacDang;
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

public class DanhSachGiayMoiFragment extends BaseFragment<DanhSachCongTacDangPresenter> implements DanhSachCongTacDangView,
        AdapterDanhSachCongTacDang.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

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
    boolean click = false;

    String NamLamViec;
    AdapterDanhSachCongTacDang adapterDanhSachCongTacDang;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    int year;
    AlertDialog dialog1;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_giay_moi;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        TenVB.setText("-- Tất cả --");
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).checkFragment(this);
        click = false;
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getContext(), integerArrayList, this);
        }
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        if (TenVB.getText() == "-- Tất cả --") {
            getPresenter().getallvbdentongthe(2, 0, NamLamViec, true);
        } else if (TenVB.getText() == "Văn bản mới nhập") {
            getPresenter().getallvbdentongthe(2, 1, NamLamViec, true);
        } else if (TenVB.getText() == "Đã giải quyết") {
            getPresenter().getallvbdentongthe(2, 2, NamLamViec, true);
        }

        adapterDanhSachCongTacDang = new AdapterDanhSachCongTacDang(getContext(), getPresenter().detailVanBanDenTongTheArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachCongTacDang);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (TenVB.getText() == "-- Tất cả --") {
                    getPresenter().getallvbdentongthe(2, 0, NamLamViec, false);
                } else if (TenVB.getText() == "Văn bản mới nhập") {
                    getPresenter().getallvbdentongthe(2, 1, NamLamViec, false);
                } else if (TenVB.getText() == "Đã giải quyết") {
                    getPresenter().getallvbdentongthe(2, 2, NamLamViec, false);
                }
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (TenVB.getText() == "-- Tất cả --") {
                    getPresenter().getallvbdentongthe(2, 0, NamLamViec, true);
                } else if (TenVB.getText() == "Văn bản mới nhập") {
                    getPresenter().getallvbdentongthe(2, 1, NamLamViec, true);
                } else if (TenVB.getText() == "Đã giải quyết") {
                    getPresenter().getallvbdentongthe(2, 2, NamLamViec, true);
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
        adapterDanhSachCongTacDang.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
        if (TenVB.getText() == "-- Tất cả --") {
            getPresenter().countvbden(2, 0, NamLamViec);
        } else if (TenVB.getText() == "Văn bản mới nhập") {
            getPresenter().countvbden(2, 1, NamLamViec);
        } else if (TenVB.getText() == "Đã giải quyết") {
            getPresenter().countvbden(2, 2, NamLamViec);
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
    public DanhSachCongTacDangPresenter createPresenter() {
        return new DanhSachCongTacDangPresenterImpl(this);
    }

    @OnClick({R.id.TenVB, R.id.btnBack, R.id.vdsgm, R.id.lndsgm, R.id.rldsgm, R.id.btnNamLamViec, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.TenVB:
                AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.list_item_vanban, null);
                builder.setView(view1);
                final AlertDialog dialog = builder.create();
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView btnTatCa = view1.findViewById(R.id.btnTatCa);
                TextView btnVanbanMoiNhap = view1.findViewById(R.id.btnVanbanMoiNhap);
                TextView btnDaGiaiQuyet = view1.findViewById(R.id.btnDaGiaiQuyet);
                btnTatCa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallvbdentongthe(2, 0, NamLamViec, true);
                        TenVB.setText("-- Tất cả --");
                        dialog.dismiss();
                    }
                });
                btnVanbanMoiNhap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallvbdentongthe(2, 1, NamLamViec, true);
                        TenVB.setText("Văn bản mới nhập");
                        dialog.dismiss();
                    }
                });
                btnDaGiaiQuyet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallvbdentongthe(2, 2, NamLamViec, true);
                        TenVB.setText("Đã giải quyết");
                        dialog.dismiss();
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
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
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
        if (TenVB.getText() == "-- Tất cả --") {
            getPresenter().getallvbdentongthe(2, 0, String.valueOf(integer), true);
        } else if (TenVB.getText() == "Văn bản mới nhập") {
            getPresenter().getallvbdentongthe(2, 1, String.valueOf(integer), true);
        } else if (TenVB.getText() == "Đã giải quyết") {
            getPresenter().getallvbdentongthe(2, 2, String.valueOf(integer), true);
        }
        PrefUtil.saveString(getContext(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog1.dismiss();
    }

    @Override
    public void onItemClickXemFile(DetailVanBanDenTongThe detailVanBanDenTongThe) {
        if (detailVanBanDenTongThe.getTrichYeu().getDuongdan().isEmpty() || detailVanBanDenTongThe.getTrichYeu().getDuongdan() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailVanBanDenTongThe.getTrichYeu().getDuongdan()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(DetailVanBanDenTongThe detailVanBanDenTongThe) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBDanhSachCongTacDangActivity.class);
            intent.putExtra("detailVanBanDenTongThe", detailVanBanDenTongThe);
            startActivity(intent);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(DetailVanBanDenTongThe detailVanBanDenTongThe) {
        if (!click) {
            if (detailVanBanDenTongThe.getTrichYeu().getIGiayMoi() == 1) {
                Intent intent = new Intent(getActivity(), TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
                intent.putExtra("idvb", detailVanBanDenTongThe.getPKIMaVBDen());
                startActivity(intent);
            } else {
                Intent intent = new Intent(getActivity(), TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", detailVanBanDenTongThe.getPKIMaVBDen());
                startActivity(intent);
            }
            click = true;
        }

    }
}
