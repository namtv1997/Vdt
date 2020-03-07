package com.vpdt.vpdt.ui.activity.TraoDoiThongTinNoiBo;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.FileDinhKem;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TraoDoiThongTinNoiBoDetail;
import com.vpdt.vpdt.presenter.TTVBThongTinMoiPresenter;
import com.vpdt.vpdt.presenter.TTVBThongTinMoiView;
import com.vpdt.vpdt.presenter.impl.TTVBThongTinMoiPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachDonViNhanVanBan;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachFileDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterTenCanBo;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChuyenTiepActivity extends BaseActivity<TTVBThongTinMoiPresenter> implements TTVBThongTinMoiView,
        AdapterDanhSachDonViNhanVanBan.OnItemClickListener, AdapterTenCanBo.OnItemClickListener {

    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvYKienChiDao)
    HtmlTextView tvYKienChiDao;
    @BindView(R.id.etThemYKienChiDao)
    EditText etThemYKienChiDao;
    @BindView(R.id.rcvDanhSachFileDinhKem)
    RecyclerView rcvDanhSachFileDinhKem;
    @BindView(R.id.rcvDanhSachDonViNhanVanBan)
    RecyclerView rcvDanhSachDonViNhanVanBan;
    @BindView(R.id.rcvPhongQuanHuyen)
    RecyclerView rcvPhongQuanHuyen;
    @BindView(R.id.cbPhongTCKHQuanHuyen)
    CheckBox cbPhongTCKHQuanHuyen;

    AdapterDanhSachFileDinhKem adapterDanhSachFileDinhKem;
    AdapterDanhSachDonViNhanVanBan adapterDanhSachDonViNhanVanBan;
    AdapterTenCanBo adapterTenCanBo;
    int idvb, idphong;
    String idcanbo;
    AlertDialog dialog;
    RecyclerView rcvTenCanBo;
    TextView tencanbo;

    @Override
    public int getContentViewId() {
        return R.layout.activity_chuyen_tiep;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                idvb = intent.getIntExtra("idvb", 0);
                getPresenter().getdetailvanbanbyidThongTinNoiBo(idvb);
            }
        }
        getPresenter().getAllPhongBan();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(TraoDoiThongTinNoiBoDetail traoDoiThongTinNoiBoDetail) {
        RecyclerViewFileDinhKem((ArrayList<FileDinhKem>) traoDoiThongTinNoiBoDetail.getFileDinhKems());
        tvNgayNhap.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getNgayNhap()));
        tvNgayKy.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getNgayKy()));
        tvTrichYeu.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getTrichYeu()));
        tvYKienChiDao.setHtml(traoDoiThongTinNoiBoDetail.getYkienChidao(), new HtmlAssetsImageGetter(tvYKienChiDao));
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
        adapterDanhSachDonViNhanVanBan = new AdapterDanhSachDonViNhanVanBan(phongBan, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDanhSachDonViNhanVanBan.setLayoutManager(layoutManager);
        rcvDanhSachDonViNhanVanBan.setAdapter(adapterDanhSachDonViNhanVanBan);
        adapterDanhSachDonViNhanVanBan.notifyDataSetChanged();
    }


    @Override
    public TTVBThongTinMoiPresenter createPresenter() {
        return new TTVBThongTinMoiPresenterImpl(this);
    }

    @OnClick({R.id.imvBack, R.id.btnChuyenTiep})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.btnChuyenTiep:
                Toast.makeText(this, idcanbo, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Chức năng đang phát triển", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    void RecyclerViewFileDinhKem(ArrayList<FileDinhKem> fileDinhKems) {
        adapterDanhSachFileDinhKem = new AdapterDanhSachFileDinhKem(fileDinhKems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDanhSachFileDinhKem.setLayoutManager(layoutManager);
        rcvDanhSachFileDinhKem.setAdapter(adapterDanhSachFileDinhKem);
        adapterDanhSachFileDinhKem.notifyDataSetChanged();
    }

    @Override
    public void onItemClickcbChon(PhongBan phongBan) {

    }

    @Override
    public void onItemClickNguoiNhan(PhongBan phongBan, View v) {
        idphong = phongBan.getId();
        tencanbo = v.findViewById(R.id.tvNguoiNhan);
        getPresenter().getAllCanBoByIdPhongBan(idphong);
    }

    @Override
    public void onGetCanBoByIdPhongBanSuccess(ArrayList<CanBoByidPhongBan> canBoByidPhongBans) {
        adapterTenCanBo = new AdapterTenCanBo(this, canBoByidPhongBans, this);
        AlertDialog.Builder builderanhDaoPhong = new AlertDialog.Builder(this);
        LayoutInflater inflateranhDaoPhong = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View viewanhDaoPhong = inflateranhDaoPhong.inflate(R.layout.dialog_ten_giam_doc, null);
        builderanhDaoPhong.setView(viewanhDaoPhong);
        dialog = builderanhDaoPhong.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rcvTenCanBo = viewanhDaoPhong.findViewById(R.id.rcTenGiamDoc);
        rcvTenCanBo.setLayoutManager(layoutManager);
        rcvTenCanBo.setAdapter(adapterTenCanBo);
        adapterTenCanBo.notifyDataSetChanged();

        dialog.show();
        TextView btnChuyenPGiamDoc = viewanhDaoPhong.findViewById(R.id.btnChuyenPGiamDoc);
        btnChuyenPGiamDoc.setText("Chọn người nhận");
        btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tencanbo.setText("");
                idcanbo = "";
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onItemClick(CanBoByidPhongBan canBoByidPhongBan) {
        if (tencanbo.getText().toString().isEmpty()) {
            tencanbo.setText(String.valueOf(canBoByidPhongBan.getHoTen()));
            dialog.dismiss();
            idcanbo = String.valueOf(canBoByidPhongBan.getId());
        } else {
            tencanbo.setText(String.valueOf(tencanbo.getText().toString() + ", " + canBoByidPhongBan.getHoTen()));
            dialog.dismiss();
            idcanbo = idcanbo + String.valueOf(canBoByidPhongBan.getId());
        }
    }
}
