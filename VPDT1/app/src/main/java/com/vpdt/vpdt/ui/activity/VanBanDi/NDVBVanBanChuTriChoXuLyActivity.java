package com.vpdt.vpdt.ui.activity.VanBanDi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
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
import com.vpdt.vpdt.model.VanBanDiChuaXuLy;
import com.vpdt.vpdt.presenter.NDVBVanBanChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChuTriChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanChuTriChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanChuTriChoXuLyActivity extends BaseActivity<NDVBVanBanChuTriChoXuLyPresenter> implements NDVBVanBanChuTriChoXuLyView,
        AdapterTenGiamDoc.OnItemClickListener, AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien {

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
    @BindView(R.id.tvChonLanhDaoXemDeBiet)
    TextView tvChonLanhDaoXemDeBiet;

    @BindView(R.id.btnTralai)
    TextView btnTralai;

    @BindView(R.id.btnGuiLen)
    TextView btnGuiLen;

    @BindView(R.id.edtYkien)
    EditText edtYkien;
    boolean click = false;
    String id_ld;
    int idLanhDao;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    ArrayList<String> stringArrayList = new ArrayList<>();
    RecyclerView rcTenGiamDoc;
    RecyclerView rcTenChuyenVien;
    AlertDialog dialog;
    int id_vb, level;


    private AdapterTenGiamDoc adapterTenGiamDoc;
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_chu_tri_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getCBxem_choxl();
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        if (level == 7 || level == 8) {
            tvChonLanhDaoXemDeBiet.setVisibility(View.GONE);
            btnTralai.setVisibility(View.GONE);
        }
        VanBanDiChuaXuLy vanBanDiChuaXuLy = getIntent().getParcelableExtra("vanBanDiChuaXuLy");
        if (vanBanDiChuaXuLy != null) {
            id_vb = vanBanDiChuaXuLy.getMavb();
            String shortDate = vanBanDiChuaXuLy.getThoigian();
            tvNgay.setText(shortDate.substring(0, 5));
            tvSKH.setText(String.valueOf(vanBanDiChuaXuLy.getKyhieu()));
            tvTrichYeu.setText(String.valueOf(vanBanDiChuaXuLy.getTrichYeu()));
            tvNguoiNhap.setText(String.valueOf(vanBanDiChuaXuLy.getNguoinhap()));
            tvTen.setText(String.valueOf(vanBanDiChuaXuLy.getNguoigui()));
            tvYKien.setText(String.valueOf(vanBanDiChuaXuLy.getYKien()));
            tvNgayGio.setText(String.valueOf(vanBanDiChuaXuLy.getThoigian()));
            if (vanBanDiChuaXuLy.getSodi() > 0) {
                tvDaCapSo.setVisibility(View.VISIBLE);
            } else {
                tvChuaCapSo.setVisibility(View.VISIBLE);
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDiChuaXuLy.getDuongdan()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanChuTriChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet, R.id.btnTralai, R.id.btnGuiLen, R.id.tvChonLanhDao, R.id.tvChonLanhDaoXemDeBiet, R.id.lnNDVB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
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
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Thông báo");
                builder1.setMessage("Bạn muốn trả lại ?");
                builder1.setCancelable(false);
                builder1.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().tralaivanban_tp(id_vb, edtYkien.getText().toString());
                    }
                });
                AlertDialog alertDialog = builder1.create();
                alertDialog.show();

                break;
            case R.id.btnGuiLen:
                if (tvChonLanhDao.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Chưa chọn lãnh đạo", Toast.LENGTH_SHORT).show();
                } else {
                    getPresenter().guilen(id_vb, String.valueOf(idLanhDao), stringArrayList, edtYkien.getText().toString());
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
                btnChuyenPGiamDoc.setText("-- Chọn lãnh đạo --");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChonLanhDao.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvChonLanhDaoXemDeBiet:
                AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(this);
                LayoutInflater inflaterphongphoihop = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphongphoihop = inflaterphongphoihop.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                builderphongphoihop.setView(viewphongphoihop);
                builderphongphoihop.setCancelable(false);
                dialog = builderphongphoihop.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                Button imgCancel = viewphongphoihop.findViewById(R.id.ivCancel);
                Button btnGhiLai = viewphongphoihop.findViewById(R.id.btnGhiLai);
                TextView tvTitle = viewphongphoihop.findViewById(R.id.tvTitle);
                tvTitle.setVisibility(View.INVISIBLE);
                LinearLayoutManager layoutManagerPhoihop = new LinearLayoutManager(getApplicationContext());
                layoutManagerPhoihop.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenChuyenVien = viewphongphoihop.findViewById(R.id.rcTenPhongPhoiHop);
                rcTenChuyenVien.setLayoutManager(layoutManagerPhoihop);
                rcTenChuyenVien.setAdapter(adapterChonChuyenVienPhoiHop);
                adapterChonChuyenVienPhoiHop.notifyDataSetChanged();
                imgCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();
                    }
                });
                btnGhiLai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String chidao2 = " ";
                        int index = 0;
                        id_ld = "";
                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {
                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                id_ld += "" + item.getId();

                                chidao2 += item.getHoTen() + ".";
                            } else {
                                id_ld += item.getId() + ",";
                                chidao2 += item.getHoTen() + ", ";
                            }
                            stringArrayList.add(id_ld);
                        }
                        tvChonLanhDaoXemDeBiet.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.lnNDVB:
                closeKeyboard();
                break;
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetNguoiKySuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void tralaiSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void guilenSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBVanBanChuTriChoXuLyPresenter createPresenter() {
        return new NDVBVanBanChuTriChoXuLyPresenterImpl(this);
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
    public void onItemClickChonChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        if (giamdocVaPhoGiamdocArrayList.contains(giamdocVaPhoGiamdoc)) {
            giamdocVaPhoGiamdocArrayList.remove(giamdocVaPhoGiamdoc);

        } else {
            giamdocVaPhoGiamdocArrayList.add(giamdocVaPhoGiamdoc);
        }
    }
}
