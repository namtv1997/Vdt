package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.presenter.SoanBaoCaoPresenter;
import com.vpdt.vpdt.presenter.SoanBaoCaoView;
import com.vpdt.vpdt.presenter.impl.SoanBaoCaoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachVanBanCanNhanVanBan;
import com.vpdt.vpdt.ui.adapter.AdapterTenCanBo;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoanBaoCaoActivity extends BaseActivity<SoanBaoCaoPresenter> implements SoanBaoCaoView,
        AdapterDanhSachVanBanCanNhanVanBan.OnItemClickListenerDanhSachVanBanCanNhanVanBan,
        AdapterTenCanBo.OnItemClickListener {

//    @BindView(R.id.rvSoanBaoCao)
//    RecyclerView rvSoanBaoCao;

    RecyclerView rcTenPhong;
    AlertDialog dialog4;
    AdapterDanhSachVanBanCanNhanVanBan adapterDanhSachVanBanCanNhanVanBan;
    AdapterTenCanBo adapterTenCanBo;

    ArrayList<CanBoByidPhongBan> canBoByidPhongBanArrayList = new ArrayList<>();
    ArrayList<PhongBan> phongBanArrayList = new ArrayList<>();

    String idNguoinhan;
    String idPhongban;

    TextView tvNguoiNhan;
    CheckBox cbChon;
    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_soan_bao_cao;
    }

    @Override
    public void initializeComponents() {
        Util.checkConnection(this);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_GIAYMOI_CHO_LANHDAO_XULY")) {
                id = intent.getIntExtra("ID_GIAYMOI_CHO_LANHDAO_XULY", 0);

            }
        }
        getPresenter().getAllPhongBan();
        getPresenter().getAllCanBoByIdPhongBan(73);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetCanBoByidPhongBanSuccess(ArrayList<CanBoByidPhongBan> canBoByidPhongBans) {
        adapterTenCanBo = new AdapterTenCanBo(this, canBoByidPhongBans, this);
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
//        adapterDanhSachVanBanCanNhanVanBan = new AdapterDanhSachVanBanCanNhanVanBan(this, phongBan, this);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        rvSoanBaoCao.setLayoutManager(linearLayoutManager);
//        rvSoanBaoCao.setAdapter(adapterDanhSachVanBanCanNhanVanBan);
//        adapterDanhSachVanBanCanNhanVanBan.notifyDataSetChanged();

    }


    @Override
    public void duyetSoanBaoCaoSuccess() {
        Util.showMessenger("Thêm mới thành công", this);
        finish();
    }

    @Override
    public SoanBaoCaoPresenter createPresenter() {
        return new SoanBaoCaoPresenterImpl(this);
    }

    @Override
    public void onItemClick(PhongBan phongBan, int position, View v) {
        cbChon = v.findViewById(R.id.cbChon);
        cbChon.setChecked(true);

        if (phongBanArrayList.contains(phongBan)) {
            phongBanArrayList.remove(phongBan);
        } else {
            phongBanArrayList.add(phongBan);

            int index = 0;
            for (PhongBan item : phongBanArrayList) {
                index++;
                if (index == phongBanArrayList.size()) {
                    idPhongban += "" + item.getId();

                } else {
                    idPhongban += item.getId() + ",";

                }
            }
        }
    }

    @Override
    public void onNguoiNhanClick(PhongBan phongBan, int position, View v) {
        tvNguoiNhan = v.findViewById(R.id.tvNguoiNhan);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflatercanbo = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View viewcanbo = inflatercanbo.inflate(R.layout.dialog_ten_phong, null);
        builder.setView(viewcanbo);
        dialog4 = builder.create();
        Objects.requireNonNull(dialog4.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        LinearLayoutManager layoutManagercanbo = new LinearLayoutManager(this);
        layoutManagercanbo.setOrientation(LinearLayoutManager.VERTICAL);
        rcTenPhong = viewcanbo.findViewById(R.id.rcTenPhong);
        rcTenPhong.setLayoutManager(layoutManagercanbo);
        rcTenPhong.setAdapter(adapterTenCanBo);
        adapterTenCanBo.notifyDataSetChanged();
        dialog4.show();

    }

    @Override
    public void onCheckBoxClick(PhongBan phongBan, int position, View v) {

    }

    @Override
    public void onItemClick(CanBoByidPhongBan canBoByidPhongBan) {
        if (canBoByidPhongBanArrayList.contains(canBoByidPhongBan)) {
            canBoByidPhongBanArrayList.remove(canBoByidPhongBan);
        } else {
            canBoByidPhongBanArrayList.add(canBoByidPhongBan);
        }
        String nguoiNhan = "";
        int index = 0;
        for (CanBoByidPhongBan item : canBoByidPhongBanArrayList) {
            index++;
            if (index == canBoByidPhongBanArrayList.size()) {
                idNguoinhan += "" + item.getId();
                nguoiNhan += item.getHoTen();
            } else {
                idNguoinhan += item.getId() + ",";
                nguoiNhan += item.getHoTen() + ",";
            }
        }
        tvNguoiNhan.setText(nguoiNhan);
        dialog4.dismiss();
    }
}
