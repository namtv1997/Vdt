package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVanBanQuahan;
import com.vpdt.vpdt.model.GiaHanGiaiQuyet;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVBDuyetDSVBGiaHanGiaiQuyetPresenter;
import com.vpdt.vpdt.presenter.NDVBDuyetDSVBGiaHanGiaiQuyetView;
import com.vpdt.vpdt.presenter.impl.NDVBDuyetDSVBGiaHanGiaiQuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity extends BaseActivity<NDVBDuyetDSVBGiaHanGiaiQuyetPresenter> implements NDVBDuyetDSVBGiaHanGiaiQuyetView,
        DatePickerDialog.OnDateSetListener, AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {

    @BindView(R.id.tvSKH)
    TextView tvSKHNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNgay)
    TextView tvNgayNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvSoDen)
    TextView tvSoDenNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGuiNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiNhap)
    TextView tvTenNguoiNhap;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvLyDoDeXuatNDVBDuyetDSVBGiaHanGiaiQuyet)
    HtmlTextView tvLyDoDeXuatNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;

    @BindView(R.id.etLyDoDeXuat)
    EditText etLyDoDeXuat;
    @BindView(R.id.btnGuiLanhDao)
    Button btnGuiLanhDao;

    EditText edtTuChoi;
    int idGiahan, level;
    String handexuat;
    String lydo;
    AlertDialog.Builder builder;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbduyet_dsvbgia_han_giai_quyet_truong_phong;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        if (level == 7) {
            btnGuiLanhDao.setText("Gửi Trưởng Phòng");
        }
        GiaHanGiaiQuyet hanGiaiQuyet = getIntent().getParcelableExtra("hanGiaiQuyetTruongPhong");
        if (hanGiaiQuyet != null) {
            getPresenter().getbyidvbgiahangiaquyet(hanGiaiQuyet.getIdVanBan());
            idGiahan = hanGiaiQuyet.getIdVanBan();
            tvTenNguoiNhap.setText(String.valueOf(hanGiaiQuyet.getNguoiNhap()));
            tvLyDoDeXuatNDVBDuyetDSVBGiaHanGiaiQuyet.setHtml(hanGiaiQuyet.getLyDoDeXuat(), new HtmlAssetsImageGetter(tvLyDoDeXuatNDVBDuyetDSVBGiaHanGiaiQuyet));
            tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(hanGiaiQuyet.getHanChoDuyet()));
            handexuat = tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet.getText().toString();
            tvPhongChuTri.setText(String.valueOf(hanGiaiQuyet.getPhongChuTri()));
            tvSKHNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(hanGiaiQuyet.getKyHieu()));
            tvSoDenNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(hanGiaiQuyet.getSoDen()));
            tvNoiGuiNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(hanGiaiQuyet.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(hanGiaiQuyet.getMoTa()));
            String shortDate = hanGiaiQuyet.getNgayNhap();
            tvNgayNDVBDuyetDSVBGiaHanGiaiQuyet.setText(shortDate.substring(0, 5));
            recyclerviewFileDinhKem((ArrayList<TepDinhKem>) hanGiaiQuyet.getTepDinhKems());
            if (hanGiaiQuyet.getChiDao() == null) {
                btnGuiLanhDao.setText("GỬI LÃNH ĐẠO ()");
            } else {
                btnGuiLanhDao.setText("GỬI LÃNH ĐẠO (" + hanGiaiQuyet.getChiDao() + ")");
            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailVanBanQuahan dsvbDaChiDao) {
    }

    @Override
    public void tuChoiHanGiaiQuyet() {
        try {
            Toast.makeText(this, "Đã từ chối", Toast.LENGTH_LONG).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Đã có lỗi!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void duyetHanGiaiQuyet() {

    }

    @Override
    public void duyetVBGiaHanGiaQuyetCB() {
        try {
            Toast.makeText(this, "Gửi thành công", Toast.LENGTH_LONG).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Đã có lỗi!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void duyetVBGiaHanGiaQuyetTP() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBDuyetDSVBGiaHanGiaiQuyetPresenter createPresenter() {
        return new NDVBDuyetDSVBGiaHanGiaiQuyetPresenterImpl(this);
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
        tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet.setText(date);
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({
            R.id.tvNgayThangNam,
            R.id.btnTuChoiHan,
            R.id.imvBack,
            R.id.btnGuiLanhDao,
            R.id.lnNoiDungVB,
            R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent1 = new Intent(this, TTVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity.class);
                    intent1.putExtra("hanGiaiQuyetTruongPhong", idGiahan);
                    startActivity(intent1);
                    click = true;
                }

                break;
            case R.id.btnGuiLanhDao:
                handexuat = tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet.getText().toString();
                try {
                    if (etLyDoDeXuat.getText().toString().trim().equals("")) {
                        Toast.makeText(this, "Chưa nhập 'Lý do đề xuất' ", Toast.LENGTH_SHORT).show();
                    } else {
                        if (level == 7) {
                            getPresenter().duyetVBGiaHanGiaQuyetTP(idGiahan, etLyDoDeXuat.getText().toString(), handexuat);
                        } else {

                            getPresenter().duyetVBGiaHanGiaQuyetCB(idGiahan, etLyDoDeXuat.getText().toString(), handexuat);
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "Đã có lỗi!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnTuChoiHan:
                try {
                    builder = new AlertDialog.Builder(this);
                    LayoutInflater inflatercanbo = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View viewcanbo = inflatercanbo.inflate(R.layout.dialog_tuchoi, null);
                    builder.setView(viewcanbo);
                    Dialog dialog1 = builder.create();
                    Objects.requireNonNull(dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    edtTuChoi = viewcanbo.findViewById(R.id.edtTuChoi);
                    LinearLayout lndialog = viewcanbo.findViewById(R.id.lndialog);
                    lndialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            closeKeyboard();
                        }
                    });
                    Button btnHuy = viewcanbo.findViewById(R.id.btnHuy);
                    Button btnTuChoi = viewcanbo.findViewById(R.id.btnTuChoi);
                    btnHuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog1.dismiss();
                        }
                    });
                    btnTuChoi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            lydo = edtTuChoi.getText().toString().trim();
                            try {
                                if (lydo.equals("")) {
                                    Toast.makeText(NDVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity.this, "Chưa nhập lý do từ chối", Toast.LENGTH_SHORT).show();
                                } else {
                                    getPresenter().tuchoihangiaiquetvanban(idGiahan, edtTuChoi.getText().toString());
                                }
                            } catch (Exception e) {
                                Toast.makeText(NDVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity.this, "Đã có lỗi!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    dialog1.show();
                } catch (Exception e) {
                    Toast.makeText(this, "Đã có lỗi!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    void recyclerviewFileDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManager);
        rvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
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
}