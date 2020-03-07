package com.vpdt.vpdt.ui.activity.VanBanDi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLyCC;
import com.vpdt.vpdt.model.VanBanDiChuaXuLy;
import com.vpdt.vpdt.presenter.NDVBVanBanChuTriChoXuLyCCPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChuTriChoXuLyCCView;
import com.vpdt.vpdt.presenter.NDVBVanBanChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChuTriChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanChuTriChoXuLyCCPresenterImpl;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanChuTriChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanChuTriChoXuLyCCActivity extends BaseActivity<NDVBVanBanChuTriChoXuLyCCPresenter> implements NDVBVanBanChuTriChoXuLyCCView,
        AdapterTenGiamDoc.OnItemClickListener {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvTen)
    TextView tvTen;
    @BindView(R.id.tvYKien)
    TextView tvYKien;
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvChuaCapSo)
    TextView tvChuaCapSo;
    @BindView(R.id.tvDaCapSo)
    TextView tvDaCapSo;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;
    @BindView(R.id.tvChonLanhDao)
    TextView tvChonLanhDao;

    @BindView(R.id.edtYkien)
    EditText edtYkien;
    boolean click = false;
    int idLanhDao;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    RecyclerView rcTenGiamDoc;
    AlertDialog dialog;
    int id_vb;


    private AdapterTenGiamDoc adapterTenGiamDoc;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_chu_tri_cho_xu_ly_cc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllTruongPhongBan(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        VanBanChuTriChoXuLyCC vanBanDiChuaXuLy = getIntent().getParcelableExtra("vanBanChuTriChoXuLyCC");
        if (vanBanDiChuaXuLy != null) {
            id_vb = vanBanDiChuaXuLy.getId();
            tvNgay.setText(String.valueOf(vanBanDiChuaXuLy.getThoiGian()));
            tvSKH.setText(String.valueOf(vanBanDiChuaXuLy.getSoKyHieu()));
            tvTrichYeu.setText(String.valueOf(vanBanDiChuaXuLy.getMoTa()));
            tvNguoiNhap.setText(String.valueOf(vanBanDiChuaXuLy.getNguoiNhap()));
            tvTen.setText(String.valueOf(vanBanDiChuaXuLy.getNguoiGui()));
            tvYKien.setText(String.valueOf(vanBanDiChuaXuLy.getYKien()));
            tvNgayGio.setText(String.valueOf(vanBanDiChuaXuLy.getThoiGian()));
            if (vanBanDiChuaXuLy.getSoVBDi() > 0) {
                tvDaCapSo.setVisibility(View.VISIBLE);
            } else {
                tvChuaCapSo.setVisibility(View.VISIBLE);
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDiChuaXuLy.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanChuTriChoXuLyCCActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet, R.id.btnTralai, R.id.btnGuiLen, R.id.tvChonLanhDao, R.id.lnNDVB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.lnNDVB:
                closeKeyboard();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBVanBanTrinhKyActivity.class);
                    intent.putExtra("ID_VANBAN_DI", id_vb);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnTralai:
                if (tvChonLanhDao.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Chưa chọn trưởng phòng", Toast.LENGTH_SHORT).show();
                } else {
                    getPresenter().traLaiVBChuTriChoXuLyCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), id_vb, edtYkien.getText().toString());
                }
                break;
            case R.id.btnGuiLen:
                if (tvChonLanhDao.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Chưa chọn trưởng phòng", Toast.LENGTH_SHORT).show();
                } else {
                    getPresenter().guiLenVBChuTriChoXuLyCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), id_vb, idLanhDao, edtYkien.getText().toString());
                }
                break;
            case R.id.tvChonLanhDao:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_ten_giam_doc, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenGiamDoc = view1.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManager);
                rcTenGiamDoc.setAdapter(adapterTenGiamDoc);
                adapterTenGiamDoc.notifyDataSetChanged();
                dialog.show();
                TextView btnChuyenPGiamDoc = view1.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setText("Chọn trưởng phòng");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChonLanhDao.setText("");
                        dialog.dismiss();
                    }
                });
                break;
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetTruongPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void tralaiSuccess() {
        Toast.makeText(this, "Đã trả lại", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void guilenSuccess() {
        Toast.makeText(this, "Đã gửi lên", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idLanhDao = giamdocVaPhoGiamdoc.getId();
        tvChonLanhDao.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        dialog.dismiss();
    }


    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public NDVBVanBanChuTriChoXuLyCCPresenter createPresenter() {
        return new NDVBVanBanChuTriChoXuLyCCPresenterImpl(this);
    }
}