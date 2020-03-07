package com.vpdt.vpdt.ui.activity.VanBanDen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DanhSachCongTacDangPresenter;
import com.vpdt.vpdt.presenter.DanhSachCongTacDangView;
import com.vpdt.vpdt.presenter.impl.DanhSachCongTacDangPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.TTVBGiayMoiChoLDXLActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBDSVBQuaHanActivity;
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


public class VanBanUBNDHaNoiActivity extends BaseActivity<DanhSachCongTacDangPresenter>
        implements DanhSachCongTacDangView, AdapterDanhSachCongTacDang.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {


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
    @BindView(R.id.tvTenVanban)
    TextView tvTenVanban;

    String NamLamViec;
    AdapterDanhSachCongTacDang adapterDanhSachCongTacDang;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog1;
    int year;
    boolean click = false;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.activity_van_ban_stcchu_tri;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        TenVB.setText("-- Tất cả --");
        tvTenVanban.setText("Văn bản UBND Thành phố Hà Nội");
    }


    @Override
    public void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(this, Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        if (TenVB.getText() == "-- Tất cả --") {
            getPresenter().getallvbdentongthe(6, 0, NamLamViec, true);
        } else if (TenVB.getText() == "Văn bản mới nhập") {
            getPresenter().getallvbdentongthe(6, 1, NamLamViec, true);
        } else if (TenVB.getText() == "Đã giải quyết") {
            getPresenter().getallvbdentongthe(6, 2, NamLamViec, true);
        }
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(this, integerArrayList, this);
        }
        adapterDanhSachCongTacDang = new AdapterDanhSachCongTacDang(this, getPresenter().detailVanBanDenTongTheArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachCongTacDang);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (TenVB.getText() == "-- Tất cả --") {
                    getPresenter().getallvbdentongthe(6, 0, NamLamViec, false);
                } else if (TenVB.getText() == "Văn bản mới nhập") {
                    getPresenter().getallvbdentongthe(6, 1, NamLamViec, false);
                } else if (TenVB.getText() == "Đã giải quyết") {
                    getPresenter().getallvbdentongthe(6, 2, NamLamViec, false);
                }

            }
        };
        recyclerview.addOnScrollListener(scrollListener);
        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (TenVB.getText() == "-- Tất cả --") {
                    getPresenter().getallvbdentongthe(6, 0, NamLamViec, true);
                } else if (TenVB.getText() == "Văn bản mới nhập") {
                    getPresenter().getallvbdentongthe(6, 1, NamLamViec, true);
                } else if (TenVB.getText() == "Đã giải quyết") {
                    getPresenter().getallvbdentongthe(6, 2, NamLamViec, true);
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
        return this;
    }

    @Override
    public void onGetDataSuccess() {
        adapterDanhSachCongTacDang.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
        if (TenVB.getText() == "-- Tất cả --") {
            getPresenter().countvbden(6, 0, NamLamViec);
        } else if (TenVB.getText() == "Văn bản mới nhập") {
            getPresenter().countvbden(6, 1, NamLamViec);
        } else if (TenVB.getText() == "Đã giải quyết") {
            getPresenter().countvbden(6, 2, NamLamViec);
        }
    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0) {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", this);
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public DanhSachCongTacDangPresenter createPresenter() {
        return new DanhSachCongTacDangPresenterImpl(this);
    }

    @OnClick({R.id.TenVB, R.id.btnBack, R.id.vvbstc, R.id.lnvbstc, R.id.rlvbstc, R.id.btnNamLamViec, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(this));
                Objects.requireNonNull(this).onBackPressed();
                break;
            case R.id.TenVB:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                        getPresenter().getallvbdentongthe(6, 0, NamLamViec, true);
                        TenVB.setText("-- Tất cả --");
                        dialog.dismiss();
                    }
                });
                btnVanbanMoiNhap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallvbdentongthe(6, 1, NamLamViec, true);
                        TenVB.setText("Văn bản mới nhập");
                        dialog.dismiss();
                    }
                });
                btnDaGiaiQuyet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().getallvbdentongthe(6, 2, NamLamViec, true);
                        TenVB.setText("Đã giải quyết");
                        dialog.dismiss();
                    }
                });

                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnNamLamViec:
                AlertDialog.Builder builderNamLamViec = new AlertDialog.Builder(this);
                LayoutInflater inflaterNamLamViec = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNamLamViec = inflaterNamLamViec.inflate(R.layout.recyclerview_nam_selected, null);
                builderNamLamViec.setView(viewNamLamViec);
                dialog1 = builderNamLamViec.create();
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
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
            getPresenter().getallvbdentongthe(6, 0, NamLamViec, true);
        } else if (TenVB.getText() == "Văn bản mới nhập") {
            getPresenter().getallvbdentongthe(6, 1, NamLamViec, true);
        } else if (TenVB.getText() == "Đã giải quyết") {
            getPresenter().getallvbdentongthe(6, 2, NamLamViec, true);
        }
        PrefUtil.saveString(this, Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog1.dismiss();
    }

    @Override
    public void onItemClickXemFile(DetailVanBanDenTongThe detailVanBanDenTongThe) {

    }

    @Override
    public void onItemClickXuLy(DetailVanBanDenTongThe detailVanBanDenTongThe) {

    }

    @Override
    public void onItemClickXemChiTiet(DetailVanBanDenTongThe detailVanBanDenTongThe) {
        if (!click) {
            if (detailVanBanDenTongThe.getTrichYeu().getIGiayMoi() == 1) {
                Intent intent = new Intent(this, TTVBGiayMoiChoLDXLActivity.class);
                intent.putExtra("ID_GIAYMOI_CHO_LANHDAO_XULY", detailVanBanDenTongThe.getPKIMaVBDen());
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, TTVBDSVBQuaHanActivity.class);
                intent.putExtra("ID_VANBAN_QUAHAN", detailVanBanDenTongThe.getPKIMaVBDen());
                startActivity(intent);
            }
            click = true;
        }
    }
}
