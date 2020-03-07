package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.GiayMoiChoLanhDaoXuLy;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVBGiayMoiLanhDaoDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVBGiayMoiLanhDaoDaChiDaoView;
import com.vpdt.vpdt.presenter.impl.NDVBGiayMoiLanhDaoDaChiDaoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTenCuaPhoGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhong;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhongPhoiHop;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBGiayMoiLanhDaoDaChiDaoActivity extends BaseActivity<NDVBGiayMoiLanhDaoDaChiDaoPresenter> implements NDVBGiayMoiLanhDaoDaChiDaoView,
        AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem, DatePickerDialog.OnDateSetListener,
        AdapterTenGiamDoc.OnItemClickListener,
        AdapterTenPhong.OnItemClickListener,
        AdapterTenPhongPhoiHop.OnItemClickListener1, AdapterTenCuaPhoGiamDoc.OnItemTenCuaPhoGiamDocClickListener {

    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvTenGD)
    TextView tvTenGD;
    @BindView(R.id.tvPhong)
    TextView tvPhong;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;
    @BindView(R.id.tvChuyenGiamDoc)
    TextView tvChuyenGiamDoc;

    @BindView(R.id.edtChiDao)
    TextView edtChiDao;
    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;

    @BindView(R.id.btnChonPhoiHop)
    Button btnChonPhoiHop;
    @BindView(R.id.btnDuyet)
    Button btnDuyet;

    @BindView(R.id.cbGiamDocDuHop)
    CheckBox cbGiamDocDuHop;

    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;

    @BindView(R.id.rlChuyenGiamDoc)
    RelativeLayout rlChuyenGiamDoc;

    private AdapterTenCuaPhoGiamDoc adapterTenCuaPhoGiamDoc;
    private AdapterTenPhong adapterTenPhong;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    boolean click = false;
    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;

    @BindView(R.id.rcvFileDinhKem)
    RecyclerView rcvFileDinhKem;

    AlertDialog dialog;
    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();

    int idGiamDoc;
    int idPhoGiamDoc;
    int idPhongChuTri;
    String id_phongphoihop = "";
    String chidao_phogiamdoc;
    String chidao_giamdoc;
    String chidao_phongchutri;
    String han_giai_quyet;

    AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;

    int idgiaymoi, level;


    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbgiay_moi_lanh_dao_da_chi_dao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GiayMoiChoLanhDaoXuLy giayMoiChoLanhDaoXuLy = getIntent().getParcelableExtra("giayMoiLanhDaodachidao");
        if (giayMoiChoLanhDaoXuLy != null) {
            level = PrefUtil.getInt(this, Key.LEVEL, 0);
            idgiaymoi = giayMoiChoLanhDaoXuLy.getId();
            idPhoGiamDoc = giayMoiChoLanhDaoXuLy.getIdPhoGiamdoc();
            if (giayMoiChoLanhDaoXuLy.getIdGiamdoc() != null)
                idGiamDoc = giayMoiChoLanhDaoXuLy.getIdGiamdoc();
            idPhongChuTri = giayMoiChoLanhDaoXuLy.getIdPhongChutri();
            getPresenter().getgiaymoilanhdaodachidaobyid(giayMoiChoLanhDaoXuLy.getId());
            if (giayMoiChoLanhDaoXuLy.getNoidungChidaoPhoGd() != null) {
                edtChiDao1.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getNoidungChidaoPhoGd()));
            }
//            tvTenGD.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getTenPhoGiamdoc()));
            if (giayMoiChoLanhDaoXuLy.getNoidungChidaoPhoGd().length()>11){
                String pgd = giayMoiChoLanhDaoXuLy.getNoidungChidaoPhoGd();
                tvTenGD.setText(String.valueOf(pgd.substring(11, pgd.length()-7)));
            }
            if (giayMoiChoLanhDaoXuLy.getNoidungChidaoGd() != null) {
                edtChiDao.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getNoidungChidaoGd()));
                if (giayMoiChoLanhDaoXuLy.getNoidungChidaoGd().length() > 10) {
                    tvChuyenGiamDoc.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getNoidungChidaoGd().substring(10,
                            giayMoiChoLanhDaoXuLy.getNoidungChidaoGd().length() - 7)));
                }
            }
            if (giayMoiChoLanhDaoXuLy.getNoidungChidaoPhongChutri() != null) {
                edtChiDao2.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getNoidungChidaoPhongChutri()));
                String[] phong = giayMoiChoLanhDaoXuLy.getNoidungChidaoPhongChutri().split("tham");
                if (phong[0].length() > 7) {
                    tvPhong.setText(String.valueOf(phong[0].substring(7, phong[0].length() - 8)));
                }
            }
            if (giayMoiChoLanhDaoXuLy.getHanGiaquyet() != null) {
                tvNgayThangNam.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getHanGiaquyet()));
            }
            if (giayMoiChoLanhDaoXuLy.getNoiDung() != null) {
                tvNoiDung.setText(String.valueOf("Nội dung: " + giayMoiChoLanhDaoXuLy.getNoiDung()));
            } else {
                tvNoiDung.setVisibility(View.GONE);
            }
            if (level == 5) {
                rlChuyenGiamDoc.setVisibility(View.GONE);
                edtChiDao.setVisibility(View.GONE);
            }
            if (giayMoiChoLanhDaoXuLy.getGiamdocDuhop() == true) {
                cbGiamDocDuHop.setChecked(true);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
        edtChiDao2.addTextChangedListener(loginTextWatcher);
        String edtChiDao = edtChiDao2.getText().toString().trim();
        if (edtChiDao.isEmpty()) {
            btnChonPhoiHop.setEnabled(false);
        } else {
            btnChonPhoiHop.setEnabled(true);
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailGiayMoi detailGiayMoi) {
        getPresenter().getAllPhoGiamDoc();
        getPresenter().getAllGiamDoc();
        getPresenter().getAllPhongBan();
        RecyclerViewTepTinDinhKem((ArrayList<TepDinhKem>) detailGiayMoi.getTepDinhKems());
        String shortdate = detailGiayMoi.getNgayNhan();
        tvNgay.setText(shortdate.substring(0, 5));
        tvNoiGui.setText(detailGiayMoi.getNoiGuiDen());
        tvLoaiVanban.setText(detailGiayMoi.getLoaiVanban());
        tvTrichYeu.setText(detailGiayMoi.getTrichYeu());
        tvSKH.setText(String.valueOf(detailGiayMoi.getSoKyhieu()));
        tvSoDen.setText(String.valueOf(detailGiayMoi.getSoDen()));
        tvDiaDiem.setText(String.valueOf("Vào hồi "
                + detailGiayMoi.getGiayMoiGio() + " ngày "
                + detailGiayMoi.getGiayMoiNgay() + ", tại "
                + detailGiayMoi.getGiayDiaDiem()));
    }

    @Override
    public void onGetGiamdoccSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenCuaPhoGiamDoc = new AdapterTenCuaPhoGiamDoc(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
        adapterTenPhong = new AdapterTenPhong(this, phongBan, this);
        adapterTenPhongPhoiHop = new AdapterTenPhongPhoiHop(this, phongBan, this);
    }

    @Override
    public void onGetDuyetGiayMoiLanhDaoDaChiDao() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public NDVBGiayMoiLanhDaoDaChiDaoPresenter createPresenter() {
        return new NDVBGiayMoiLanhDaoDaChiDaoPresenterImpl(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year,
                          int monthOfYear, int dayOfMonth) {
        String date;
        if (monthOfYear + 1 < 10) {
            if (dayOfMonth < 10) {
                date = "0" + dayOfMonth + "/" + "0" + (monthOfYear + 1) + "/" + year;
            } else {
                date = dayOfMonth + "/" + "0" + (monthOfYear + 1) + "/" + year;
            }
        } else {
            if (dayOfMonth < 10) {
                date = "0" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
            } else {
                date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
            }
        }
        tvNgayThangNam.setText(date);
    }

    @OnClick({R.id.tvTenGD, R.id.tvPhong, R.id.btnChonPhoiHop, R.id.tvNgayThangNam, R.id.lnNoiDungVB,
            R.id.imvBack, R.id.tvChuyenGiamDoc, R.id.btnDuyet, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvChuyenGiamDoc:
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
                btnChuyenPGiamDoc.setText("Chuyển giám đốc");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChuyenGiamDoc.setText("");
                        edtChiDao.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvTenGD:
                AlertDialog.Builder builderPGiamDoc = new AlertDialog.Builder(this);
                LayoutInflater inflaterPGiamDoc = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewPGiamDoc = inflaterPGiamDoc.inflate(R.layout.dialog_ten_giam_doc, null);
                builderPGiamDoc.setView(viewPGiamDoc);
                dialog = builderPGiamDoc.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerPGiamDoc = new LinearLayoutManager(getApplicationContext());
                layoutManagerPGiamDoc.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewPGiamDoc.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerPGiamDoc);
                rcTenGiamDoc.setAdapter(adapterTenCuaPhoGiamDoc);
                adapterTenCuaPhoGiamDoc.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDocPGiamDoc = viewPGiamDoc.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDocPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTenGD.setText("");
                        edtChiDao1.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvPhong:
                AlertDialog.Builder builderphong = new AlertDialog.Builder(this);
                LayoutInflater inflaterphong = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphong = inflaterphong.inflate(R.layout.dialog_ten_phong, null);
                builderphong.setView(viewphong);
                dialog = builderphong.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerphong = new LinearLayoutManager(getApplicationContext());
                layoutManagerphong.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenPhong = viewphong.findViewById(R.id.rcTenPhong);
                rcTenPhong.setLayoutManager(layoutManagerphong);
                rcTenPhong.setAdapter(adapterTenPhong);
                adapterTenPhong.notifyDataSetChanged();
                dialog.show();
                TextView tvChonChuTri1 = viewphong.findViewById(R.id.tvChonChuTri);
                tvChonChuTri1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvPhong.setText("");
                        edtChiDao2.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnChonPhoiHop:
                if (tvPhong.getText().equals("")) {
                    Toast.makeText(this, "Chưa chọn chủ trì", Toast.LENGTH_SHORT).show();
                } else {
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
                    LinearLayoutManager layoutManagerPhoihop = new LinearLayoutManager(getApplicationContext());
                    layoutManagerPhoihop.setOrientation(LinearLayoutManager.VERTICAL);
                    rcTenPhongPhoiHop = viewphongphoihop.findViewById(R.id.rcTenPhongPhoiHop);
                    rcTenPhongPhoiHop.setLayoutManager(layoutManagerPhoihop);
                    rcTenPhongPhoiHop.setAdapter(adapterTenPhongPhoiHop);
                    adapterTenPhongPhoiHop.notifyDataSetChanged();
                    imgCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            phongBansSelected.clear();
                            dialog.dismiss();
                        }
                    });
                    btnGhiLai.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String chidao2 = "Chuyển " + tvPhong.getText() + " chủ trì tham mưu. ";
                            int index = 0;
                            for (PhongBan item : phongBansSelected) {

                                index++;
                                if (index == phongBansSelected.size()) {
                                    id_phongphoihop += "" + item.getId();
                                    chidao2 += item.getTenPhongBan() + " phối hợp.";
                                } else {
                                    id_phongphoihop += item.getId() + ",";
                                    chidao2 += item.getTenPhongBan() + ", ";
                                }
                            }
                            edtChiDao2.setText(chidao2);
                            dialog.dismiss();
                            phongBansSelected.clear();
                        }
                    });
                }
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, ThongTinGiayMoiDaXuLyActivity.class);
                    intent.putExtra("idvb", idgiaymoi);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnDuyet:
                chidao_giamdoc = edtChiDao.getText().toString();
                chidao_phogiamdoc = edtChiDao1.getText().toString();
                chidao_phongchutri = edtChiDao2.getText().toString();
                han_giai_quyet = tvNgayThangNam.getText().toString();
                if (level == 4) {
                    if (cbGiamDocDuHop.isChecked()) {
                        getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, idGiamDoc, idPhoGiamDoc, idPhongChuTri,
                                id_phongphoihop, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
                                true, false, han_giai_quyet, false);
                    } else {
                        getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, idGiamDoc, idPhoGiamDoc, idPhongChuTri,
                                id_phongphoihop, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
                                false, false, han_giai_quyet, false);
                    }
                } else {
                    if (cbGiamDocDuHop.isChecked()) {
                        getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, 0, idPhoGiamDoc, idPhongChuTri,
                                id_phongphoihop, chidao_phogiamdoc, "", chidao_phongchutri,
                                true, false, han_giai_quyet, false);
                    } else {
                        getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, 0, idPhoGiamDoc, idPhongChuTri,
                                id_phongphoihop, chidao_phogiamdoc, "", chidao_phongchutri,
                                false, false, han_giai_quyet, false);
                    }
                }

//                if (cbGiamDocDuHop.isChecked() && cbVBQuanTrong.isChecked()) {
//                    getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, idGiamDoc, idPhoGiamDoc, idPhongChuTri,
//                            id_phongphoihop, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
//                            true, true, han_giai_quyet, true);
//                } else if (cbGiamDocDuHop.isChecked()) {
//                    getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, idGiamDoc, idPhoGiamDoc, idPhongChuTri,
//                            id_phongphoihop, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
//                            false, true, han_giai_quyet, true);
//                } else if (cbGiamDocDuHop.isChecked()) {
//                    getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, idGiamDoc, idPhoGiamDoc, idPhongChuTri,
//                            id_phongphoihop, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
//                            true, false, han_giai_quyet, true);
//                } else if (cbVBQuanTrong.isChecked()) {
//                    getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, idGiamDoc, idPhoGiamDoc, idPhongChuTri,
//                            id_phongphoihop, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
//                            true, false, han_giai_quyet, false);
//                } else if (cbVBQuanTrong.isChecked()) {
//                    getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, idGiamDoc, idPhoGiamDoc, idPhongChuTri,
//                            id_phongphoihop, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
//                            false, true, han_giai_quyet, false);
//                } else {
//                    getPresenter().duyetgiaymoilanhdaodaxuly(idgiaymoi, idGiamDoc, idPhoGiamDoc, idPhongChuTri,
//                            id_phongphoihop, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
//                            false, false, han_giai_quyet, false);
//                }
                break;
        }
    }

    @Override
    public void onItemClickFileDinhKem(TepDinhKem dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idGiamDoc = giamdocVaPhoGiamdoc.getId();
        tvChuyenGiamDoc.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao.setText("Chuyển GĐ " + giamdocVaPhoGiamdoc.getHoTen());
        dialog.dismiss();
    }

    @Override
    public void onItemClick(PhongBan phongBan) {
        idPhongChuTri = phongBan.getId();
        tvPhong.setText(String.valueOf(phongBan.getTenPhongBan()));
        edtChiDao2.setText("Chuyển " + phongBan.getTenPhongBan() + " chủ trì tham mưu.");
        dialog.dismiss();
    }

    @Override
    public void onItemClick1(PhongBan phongBan) {
        if (phongBansSelected.contains(phongBan)) {
            phongBansSelected.remove(phongBan);
        } else {

            phongBansSelected.add(phongBan);
        }
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvFileDinhKem.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onItemTenCuaPhoGiamDocClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idPhoGiamDoc = giamdocVaPhoGiamdoc.getId();
        tvTenGD.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển PGĐ " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String chidao2 = edtChiDao2.getText().toString().trim();

            btnChonPhoiHop.setEnabled(!chidao2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
