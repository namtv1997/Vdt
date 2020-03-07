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
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.GiayMoiChoLanhDaoXuLy;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVBGiayMoiChoLDXLPresenter;
import com.vpdt.vpdt.presenter.NDVBGiayMoiChoLDXLView;
import com.vpdt.vpdt.presenter.impl.NDVBGiayMoiChoLDXLPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhong;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhongPhoiHop;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBGiayMoiChoLDXLActivity extends BaseActivity<NDVBGiayMoiChoLDXLPresenter> implements NDVBGiayMoiChoLDXLView,
        AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem, DatePickerDialog.OnDateSetListener,
        AdapterTenGiamDoc.OnItemClickListener,
        AdapterTenPhong.OnItemClickListener,
        AdapterTenPhongPhoiHop.OnItemClickListener1 {

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

    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;

    @BindView(R.id.btnChonPhoiHop)
    Button btnChonPhoiHop;
    @BindView(R.id.btnDuyet)
    Button btnDuyet;

    @BindView(R.id.cbVBQuanTrong)
    CheckBox cbVBQuanTrong;
    @BindView(R.id.cbGiamDocDuHop)
    CheckBox cbGiamDocDuHop;
    @BindView(R.id.cbPhongDuHop)
    CheckBox cbPhongDuHop;

    @BindView(R.id.btnBack)
    ImageView btnBack;

    @BindView(R.id.rcvFileDinhKem)
    RecyclerView rcvFileDinhKem;

    private AdapterTenPhong adapterTenPhong;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;

    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;

    AlertDialog dialog;
    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();
    String id_phongphoihop = "";
    boolean click = false;
    int id_phogiamdoc;
    int id_phongchutri;
    int idgiaymoi;
    String chidao_phogiamdoc;
    String chidao_phongchutri;
    String han_giai_quyet;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbgiay_moi_cho_ldxl;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GiayMoiChoLanhDaoXuLy giayMoiChoLanhDaoXuLy = getIntent().getParcelableExtra("giayMoiChoLanhDao");
        if (giayMoiChoLanhDaoXuLy != null) {
            idgiaymoi = giayMoiChoLanhDaoXuLy.getId();
            if (giayMoiChoLanhDaoXuLy.getIdPhoGiamdoc() != null) {
                id_phogiamdoc = giayMoiChoLanhDaoXuLy.getIdPhoGiamdoc();
            }
            if (giayMoiChoLanhDaoXuLy.getIdPhongChutri() != null) {
                id_phongchutri = giayMoiChoLanhDaoXuLy.getIdPhongChutri();
            }
            getPresenter().getgiaymoicholanhdaoxulybyid(giayMoiChoLanhDaoXuLy.getId());
            if (giayMoiChoLanhDaoXuLy.getNoidungChidaoPhoGd() != null) {
                edtChiDao1.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getNoidungChidaoPhoGd()));
            }
            if (giayMoiChoLanhDaoXuLy.getNoidungChidaoPhongChutri() != null) {
                edtChiDao2.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getNoidungChidaoPhongChutri()));
            }
            if (giayMoiChoLanhDaoXuLy.getTenPhoGiamdoc() != null) {
                tvTenGD.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getTenPhoGiamdoc()));
            }
            if (giayMoiChoLanhDaoXuLy.getTenPhongChutri() != null) {
                tvPhong.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getTenPhongChutri()));
            }
            if (giayMoiChoLanhDaoXuLy.getHanGiaquyet() != null) {
                tvNgayThangNam.setText(String.valueOf(giayMoiChoLanhDaoXuLy.getHanGiaquyet()));
            }
            if (giayMoiChoLanhDaoXuLy.getGiamdocDuhop()) {
                cbGiamDocDuHop.setChecked(true);
            }
            if (giayMoiChoLanhDaoXuLy.getPhongDuhop()) {
                cbPhongDuHop.setChecked(true);
            }
        }
//        edtChiDao2.addTextChangedListener(loginTextWatcher);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        getPresenter().getAllPhongBan();
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
        adapterTenPhong = new AdapterTenPhong(this, phongBan, this);
        adapterTenPhongPhoiHop = new AdapterTenPhongPhoiHop(this, phongBan, this);
    }

    @Override
    public void duyetgiaymoicholanhdaoxulySucsess() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onGetDataSuccess(DetailGiayMoi detailGiayMoi) {
        getPresenter().getAllPhoGiamDoc();
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
    public NDVBGiayMoiChoLDXLPresenter createPresenter() {
        return new NDVBGiayMoiChoLDXLPresenterImpl(this);
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

    void RecyclerViewTepTinDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvFileDinhKem.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
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

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.tvTenGD, R.id.tvPhong,
            R.id.btnChonPhoiHop,
            R.id.tvNgayThangNam, R.id.lnNoiDungVB,
            R.id.btnBack,
            R.id.btnDuyet, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTenGD:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_ten_giam_doc, null);
                builder.setView(view1);
                dialog = builder.create();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = view1.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManager);
                rcTenGiamDoc.setAdapter(adapterTenGiamDoc);
                adapterTenGiamDoc.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDoc = view1.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTenGD.setText("");
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

                LinearLayoutManager layoutManagerphong = new LinearLayoutManager(getApplicationContext());
                layoutManagerphong.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenPhong = viewphong.findViewById(R.id.rcTenPhong);
                rcTenPhong.setLayoutManager(layoutManagerphong);
                rcTenPhong.setAdapter(adapterTenPhong);
                adapterTenPhong.notifyDataSetChanged();
                dialog.show();
                TextView tvChonChuTri = viewphong.findViewById(R.id.tvChonChuTri);
                tvChonChuTri.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvPhong.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnChonPhoiHop:
                if (tvTenGD.getText().equals("")) {
                    Toast.makeText(this, "Chưa chuyền P.Giám đốc", Toast.LENGTH_SHORT).show();
                } else if (tvPhong.getText().equals("")) {
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
            case R.id.btnBack:
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
                chidao_phogiamdoc = edtChiDao1.getText().toString();
                chidao_phongchutri = edtChiDao2.getText().toString();
                han_giai_quyet = tvNgayThangNam.getText().toString();
                if (cbGiamDocDuHop.isChecked() && cbPhongDuHop.isChecked() && cbVBQuanTrong.isChecked()) {
                    getPresenter().duyetgiaymoicholanhdaoxuly(idgiaymoi, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            chidao_phogiamdoc, chidao_phongchutri, true, true,
                            han_giai_quyet, true);
                } else if (cbGiamDocDuHop.isChecked() && cbPhongDuHop.isChecked()) {
                    getPresenter().duyetgiaymoicholanhdaoxuly(idgiaymoi, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            chidao_phogiamdoc, chidao_phongchutri, true, true,
                            han_giai_quyet, false);
                } else if (cbGiamDocDuHop.isChecked() && cbVBQuanTrong.isChecked()) {
                    getPresenter().duyetgiaymoicholanhdaoxuly(idgiaymoi, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            chidao_phogiamdoc, chidao_phongchutri, true, false,
                            han_giai_quyet, true);
                } else if (cbPhongDuHop.isChecked() && cbVBQuanTrong.isChecked()) {
                    getPresenter().duyetgiaymoicholanhdaoxuly(idgiaymoi, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            chidao_phogiamdoc, chidao_phongchutri, false, true,
                            han_giai_quyet, true);
                } else if (cbGiamDocDuHop.isChecked()) {
                    getPresenter().duyetgiaymoicholanhdaoxuly(idgiaymoi, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            chidao_phogiamdoc, chidao_phongchutri, true, false,
                            han_giai_quyet, false);
                } else if (cbVBQuanTrong.isChecked()) {
                    getPresenter().duyetgiaymoicholanhdaoxuly(idgiaymoi, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            chidao_phogiamdoc, chidao_phongchutri, false, false,
                            han_giai_quyet, true);
                } else if (cbPhongDuHop.isChecked()) {
                    getPresenter().duyetgiaymoicholanhdaoxuly(idgiaymoi, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            chidao_phogiamdoc, chidao_phongchutri, false, true,
                            han_giai_quyet, false);
                } else {
                    getPresenter().duyetgiaymoicholanhdaoxuly(idgiaymoi, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            chidao_phogiamdoc, chidao_phongchutri, false, false,
                            han_giai_quyet, false);
                }
                break;
        }
    }

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        id_phogiamdoc = giamdocVaPhoGiamdoc.getId();
        chidao_phogiamdoc = edtChiDao1.getText().toString();
        tvTenGD.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }

    @Override
    public void onItemClick(PhongBan phongBan) {
        id_phongchutri = phongBan.getId();
        chidao_phongchutri = edtChiDao2.getText().toString();
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
}
