package com.vpdt.vpdt.ui.activity.XuLyVanBan;

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
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.FileXemDeBiet;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TheoDoiDonDoc;
import com.vpdt.vpdt.presenter.ThongTinBietDeDonDocPresenter;
import com.vpdt.vpdt.presenter.ThongTinBietDeDonDocView;
import com.vpdt.vpdt.presenter.impl.ThongTinBietDeDonDocPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileXemDeBiet;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhongPhoiHop;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThongTinBietDeDonDocActivity extends BaseActivity<ThongTinBietDeDonDocPresenter> implements ThongTinBietDeDonDocView,
        DatePickerDialog.OnDateSetListener, AdapterFileXemDeBiet.OnItemClickListener, AdapterTenPhongPhoiHop.OnItemClickListener1 {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvPhong)
    TextView tvPhong;
    @BindView(R.id.tvTenPhoGiamDoc)
    TextView tvTenPhoGiamDoc;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayThangNamNDVB_DSVB_DaChiDao)
    TextView tvNgayThangNamNDVB_DSVB_DaChiDao;


    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;
    RecyclerView rcTenPhongPhoiHop;

    AdapterFileXemDeBiet adapterFileXemDeBiet;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    AlertDialog dialog;
    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();
    int id;

    @BindView(R.id.edtChiDao1)
    TextView edtChiDao1;
    @BindView(R.id.edtChiDao2)
    TextView edtChiDao2;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_thong_tin_biet_de_don_doc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllPhongBan();
        TheoDoiDonDoc xemDeBiet = getIntent().getParcelableExtra("theoDoiDonDoc");
        if (xemDeBiet != null) {
            recyclerviewFileXemDeBiet((ArrayList<FileXemDeBiet>) xemDeBiet.getFiles());
            id = xemDeBiet.getId();
            String shortDate = xemDeBiet.getNgayNhap();
            tvNgay.setText(String.valueOf(shortDate.substring(0, 5)));
            tvSoDen.setText(String.valueOf(xemDeBiet.getSoDen()));
            tvSKH.setText(String.valueOf(xemDeBiet.getSoKyHieu()));
            tvNoiGui.setText(String.valueOf(xemDeBiet.getNoiGui()));
            tvTenPhoGiamDoc.setText(String.valueOf(xemDeBiet.getPhoGiamDoc()));
            tvPhong.setText(String.valueOf(xemDeBiet.getPhongChuTri()));
            tvTrichYeu.setText(String.valueOf(xemDeBiet.getMota()));
            tvNgayThangNamNDVB_DSVB_DaChiDao.setText(String.valueOf(xemDeBiet.getHanGiaiQuyet()));
            edtChiDao1.setText(String.valueOf(xemDeBiet.getChiDaoPhong()));
            edtChiDao2.setText(String.valueOf(xemDeBiet.getChiDaoGiamdoc()));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({
            R.id.btnChonPhoiHop,
            R.id.tvNgayThangNamNDVB_DSVB_DaChiDao,
            R.id.lnNDVB_DSVB_DaChiDao,
            R.id.btnBack, R.id.tvXemChiTietNDVB_DSVB_DaChiDao})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnChonPhoiHop:
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
//                                id_phongphoihop += "" + item.getId();
                                chidao2 += item.getTenPhongBan() + " phối hợp.";
                            } else {
//                                id_phongphoihop += item.getId() + ",";
                                chidao2 += item.getTenPhongBan() + ", ";
                            }

                        }
                        edtChiDao2.setText(chidao2);

                        dialog.dismiss();
                        phongBansSelected.clear();
                    }
                });
                break;

            case R.id.tvNgayThangNamNDVB_DSVB_DaChiDao:
                showDatePickerDialog();
                break;

            case R.id.lnNDVB_DSVB_DaChiDao:
                closeKeyboard();
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVB_DSVB_DaChiDao:
                if (!click) {
                    Intent intent1 = new Intent(this, TTVBCongViecPhoiHopChoXuLyActivity.class);
                    intent1.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", id);
                    startActivity(intent1);
                    click = true;
                }

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
        tvNgayThangNamNDVB_DSVB_DaChiDao.setText(date);
    }

    @Override
    public void onItemClickFileDinhKem(FileXemDeBiet fileXemDeBiet) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileXemDeBiet.getUrl()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void recyclerviewFileXemDeBiet(ArrayList<FileXemDeBiet> fileXemDeBiets) {
        adapterFileXemDeBiet = new AdapterFileXemDeBiet(fileXemDeBiets, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManager);
        rvFileDinhKem.setAdapter(adapterFileXemDeBiet);
        adapterFileXemDeBiet.notifyDataSetChanged();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
        adapterTenPhongPhoiHop = new AdapterTenPhongPhoiHop(this, phongBan, this);
    }

    @Override
    public ThongTinBietDeDonDocPresenter createPresenter() {
        return new ThongTinBietDeDonDocPresenterImpl(this);
    }

    @Override
    public void onItemClick1(PhongBan phongBan) {
        if (phongBansSelected.contains(phongBan)) {
            phongBansSelected.remove(phongBan);
        } else {

            phongBansSelected.add(phongBan);
        }
    }
}
