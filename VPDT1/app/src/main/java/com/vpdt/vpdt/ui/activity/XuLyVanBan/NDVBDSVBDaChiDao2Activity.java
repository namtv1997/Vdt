package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DSVB_DaChiDao;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.presenter.NDVB_DSVB_DaChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVB_DSVB_DaChiDaoView;
import com.vpdt.vpdt.presenter.impl.NDVB_DSVB_DaChiDaoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhong;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhongPhoiHop;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDSVBDaChiDao2Activity extends BaseActivity<NDVB_DSVB_DaChiDaoPresenter> implements NDVB_DSVB_DaChiDaoView,
        DatePickerDialog.OnDateSetListener,
        AdapterTenGiamDoc.OnItemClickListener,
        AdapterTenPhong.OnItemClickListener,
        AdapterTenPhongPhoiHop.OnItemClickListener1 {
    @BindView(R.id.tvNgay)
    TextView tvNgayDaChiDao2;
    @BindView(R.id.tvSoDen)
    TextView tvSoDenDaChiDao2;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeuDaChiDao2)
    TextView tvTrichYeuDaChiDao2;
    @BindView(R.id.tvTenDaChiDao2)
    TextView tvTenDaChiDao2;
    @BindView(R.id.tvPhongDaChiDao2)
    TextView tvPhongDaChiDao2;
    @BindView(R.id.tvNgayThangNamDaChiDao2)
    TextView tvNgayThangNamDaChiDao2;
//    @BindView(R.id.tvXemChiTietDaChiDao2)
//    TextView tvXemChiTietDaChiDao2;

    @BindView(R.id.edtChiDao1DaChiDao2)
    EditText edtChiDao1DaChiDao2;
    @BindView(R.id.edtChiDao2DaChiDao2)
    EditText edtChiDao2DaChiDao2;

    @BindView(R.id.btnChonPhoiHopDaChiDao2)
    Button btnChonPhoiHopDaChiDao2;
    @BindView(R.id.btnDuyetDaChiDao2)
    Button btnDuyetDaChiDao2;

    @BindView(R.id.lnNDVB_DSVB_DaChiDao2)
    LinearLayout lnNDVB_DSVB_DaChiDao2;

    @BindView(R.id.cbGDDUHopDaChiDao2)
    CheckBox cbGDDUHopDaChiDao2;

    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;
    boolean click = false;
    DSVB_DaChiDao daChiDao;
    String id_phongphoihop = "";
    private AdapterTenPhong adapterTenPhong;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    AlertDialog dialog;
    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();
    int id;
    int id_phogiamdoc;
    int id_phongchutri;
    String chidao_phogiamdoc;
    String chidao_phongchutri;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdsvbda_chi_dao2;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_STC")) {
                id = intent.getIntExtra("ID_VANBAN_STC", 0);

                getPresenter().getbyidvbstcphoihopdachidao(id);
            }
        }
        edtChiDao2DaChiDao2.addTextChangedListener(loginTextWatcher);
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
        tvNgayThangNamDaChiDao2.setText(date);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DSVB_DaChiDao dsvbDaChiDao) {
    }

    @Override
    public void onGetDataPhongSTCSuccess(DSVB_DaChiDao dsvbDaChiDao) {
        getPresenter().getAllPhoGiamDoc();

        id_phogiamdoc = dsvbDaChiDao.getYKien().getIdGiamDoc();
        id_phongchutri = dsvbDaChiDao.getYKien().getIdChuTri();
        tvNoiGui.setText(String.valueOf(dsvbDaChiDao.getNoiGuiDen()));
        tvSKH.setText(String.valueOf(dsvbDaChiDao.getSoKyHieu()));
        tvLoaiVanban.setText(String.valueOf(dsvbDaChiDao.getLoaiVanBan()));
        tvNgayDaChiDao2.setText(String.valueOf(dsvbDaChiDao.getNgayNhan()));
        tvSoDenDaChiDao2.setText(String.valueOf(dsvbDaChiDao.getSoDen()));
        tvNgayThangNamDaChiDao2.setText(String.valueOf(dsvbDaChiDao.getHanGiaiQuyet()));
        tvTrichYeuDaChiDao2.setText(String.valueOf(dsvbDaChiDao.getTrichYeu()));
        tvTenDaChiDao2.setText(String.valueOf(dsvbDaChiDao.getYKien().getPhoGiamDoc()));
        tvPhongDaChiDao2.setText(String.valueOf(dsvbDaChiDao.getYKien().getPhoGiamDoc()));
        if (dsvbDaChiDao.getChiDao1() != null) {
            chidao_phogiamdoc = edtChiDao1DaChiDao2.getText().toString();
            edtChiDao1DaChiDao2.setText(String.valueOf(dsvbDaChiDao.getChiDao1()));
        }
        if (dsvbDaChiDao.getChiDao2() != null) {
            chidao_phongchutri = edtChiDao2DaChiDao2.getText().toString();
            edtChiDao2DaChiDao2.setText(String.valueOf(dsvbDaChiDao.getChiDao2()));
        }

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
    public void onGetDuyetVanBanLanhDaoDaChiDao() {

    }

    @Override
    public void onGetDuyetduyetvbstcphoihopdachidao() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onGetCongViecSuccess() {

    }

    @Override
    public NDVB_DSVB_DaChiDaoPresenter createPresenter() {
        return new NDVB_DSVB_DaChiDaoPresenterImpl(this);
    }

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        id_phogiamdoc = giamdocVaPhoGiamdoc.getId();
        chidao_phogiamdoc = edtChiDao1DaChiDao2.getText().toString();
        tvTenDaChiDao2.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1DaChiDao2.setText("Chuyển " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }

    @Override
    public void onItemClick(PhongBan phongBan) {
        id_phongchutri = phongBan.getId();
        chidao_phongchutri = edtChiDao2DaChiDao2.getText().toString();
        tvPhongDaChiDao2.setText(String.valueOf(phongBan.getTenPhongBan()));
        edtChiDao2DaChiDao2.setText("Chuyển " + phongBan.getTenPhongBan() + " chủ trì tham mưu.");
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

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.tvTenDaChiDao2, R.id.tvPhongDaChiDao2,
            R.id.btnChonPhoiHopDaChiDao2,
            R.id.tvNgayThangNamDaChiDao2, R.id.lnNDVB_DSVB_DaChiDao2,
            R.id.btnBack,
            R.id.btnDuyetDaChiDao2, R.id.tvXemChiTietDaChiDao2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTenDaChiDao2:
                AlertDialog.Builder builder = new AlertDialog.Builder(NDVBDSVBDaChiDao2Activity.this);
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
                adapterTenPhong.notifyDataSetChanged();
                dialog.show();
                TextView btnChuyenPGiamDoc = view1.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTenDaChiDao2.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvPhongDaChiDao2:
                AlertDialog.Builder builderphong = new AlertDialog.Builder(NDVBDSVBDaChiDao2Activity.this);
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
                TextView tvChonChuTri = viewphong.findViewById(R.id.tvChonChuTri);
                tvChonChuTri.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvPhongDaChiDao2.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnChonPhoiHopDaChiDao2:
                if (tvTenDaChiDao2.getText().equals("")) {
                    Toast.makeText(this, "Chưa chuyền P.Giám đốc", Toast.LENGTH_SHORT).show();
                } else if (tvPhongDaChiDao2.getText().equals("")) {
                    Toast.makeText(this, "Chưa chọn chủ trì", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(NDVBDSVBDaChiDao2Activity.this);
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
                            String chidao2 = "Chuyển " + tvPhongDaChiDao2.getText() + " chủ trì tham mưu. ";
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
                            edtChiDao2DaChiDao2.setText(chidao2);
                            dialog.dismiss();
                            phongBansSelected.clear();
                        }
                    });
                }
                break;
            case R.id.tvNgayThangNamDaChiDao2:
                showDatePickerDialog();
                break;
            case R.id.lnNDVB_DSVB_DaChiDao2:
                closeKeyboard();
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietDaChiDao2:
                if (!click) {
                    Intent intent1 = new Intent(this, TTVBCongViecPhoiHopChoXuLyActivity.class);
                    intent1.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", id);
                    startActivity(intent1);
                    click = true;
                }
                break;
            case R.id.btnDuyetDaChiDao2:
                chidao_phogiamdoc = edtChiDao1DaChiDao2.getText().toString();
                chidao_phongchutri = edtChiDao2DaChiDao2.getText().toString();
                getPresenter().duyetvbstcphoihopdachidao(id, id_phogiamdoc, id_phongchutri,
                        id_phongphoihop,
                        chidao_phogiamdoc, chidao_phongchutri, true,
                        tvNgayThangNamDaChiDao2.getText().toString(), true);
                break;
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

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String chidao2 = edtChiDao2DaChiDao2.getText().toString().trim();

            btnChonPhoiHopDaChiDao2.setEnabled(!chidao2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
