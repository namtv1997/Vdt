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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVanBanQuahan;
import com.vpdt.vpdt.model.GiaHanGiaiQuyet;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVBDuyetDSVBGiaHanGiaiQuyetPresenter;
import com.vpdt.vpdt.presenter.NDVBDuyetDSVBGiaHanGiaiQuyetView;
import com.vpdt.vpdt.presenter.impl.NDVBDuyetDSVBGiaHanGiaiQuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDuyetDSVBGiaHanGiaiQuyetActivity extends BaseActivity<NDVBDuyetDSVBGiaHanGiaiQuyetPresenter> implements NDVBDuyetDSVBGiaHanGiaiQuyetView,
        DatePickerDialog.OnDateSetListener, AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {

    @BindView(R.id.tvSKH)
    TextView tvSKHNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNgay)
    TextView tvNgayNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvSoDen)
    TextView tvSoDenNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGuiNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVBNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvTrichYeuNDVBDuyetDSVBGiaHanGiaiQuyet)
    TextView tvTrichYeuNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNguoiNhap)
    TextView tvTenNguoiNhap;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet)
    TextView tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvLyDoDeXuatNDVBDuyetDSVBGiaHanGiaiQuyet)
    HtmlTextView tvLyDoDeXuatNDVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;

    EditText edtTuChoi;
    int idGiahan;
    String handexuat;
    String lydo;
    AlertDialog.Builder builder;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbduyet_dsvbgia_han_giai_quyet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GiaHanGiaiQuyet hanGiaiQuyet = getIntent().getParcelableExtra("hanGiaiQuyet");
        if (hanGiaiQuyet != null) {
            getPresenter().getbyidvbgiahangiaquyet(hanGiaiQuyet.getIdVanBan());

            idGiahan = hanGiaiQuyet.getIdVanBan();
            tvTenNguoiNhap.setText(String.valueOf(hanGiaiQuyet.getNguoiNhap()));
            tvLyDoDeXuatNDVBDuyetDSVBGiaHanGiaiQuyet.setHtml(hanGiaiQuyet.getLyDoDeXuat(), new HtmlAssetsImageGetter(tvLyDoDeXuatNDVBDuyetDSVBGiaHanGiaiQuyet));
            tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(hanGiaiQuyet.getHanChoDuyet()));
            handexuat = tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet.getText().toString();
            tvPhongChuTri.setText(String.valueOf(hanGiaiQuyet.getPhongChuTri()));

        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailVanBanQuahan dsvbDaChiDao) {
        recyclerviewFileDinhKem((ArrayList<TepDinhKem>) dsvbDaChiDao.getTepDinhKems());
        tvSKHNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getSoKyHieu()));
        tvSoDenNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getSoDen()));
        tvNoiGuiNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getNoiGuiDen()));
        tvLoaiVBNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf("Văn bản thuộc loại: " + dsvbDaChiDao.getLoaiVanBan()));
        tvTrichYeuNDVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getTrichYeu()));
        String shortDate = dsvbDaChiDao.getNgayNhan();
        tvNgayNDVBDuyetDSVBGiaHanGiaiQuyet.setText(shortDate.substring(0, 5));

    }

    @Override
    public void tuChoiHanGiaiQuyet() {
        Toast.makeText(this, "Đã từ chối", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void duyetHanGiaiQuyet() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void duyetVBGiaHanGiaQuyetCB() {

    }

    @Override
    public void duyetVBGiaHanGiaQuyetTP() {

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
            R.id.tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet,
            R.id.tvTuChoiHanNDVBDuyetDSVBGiaHanGiaiQuyet,
            R.id.btnBack,
            R.id.tvDuyetHanNDVBDuyetDSVBGiaHanGiaiQuyet,
            R.id.tvXemChiTietNDVBDuyetDSVBGiaHanGiaiQuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet:
                showDatePickerDialog();
                break;

            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVBDuyetDSVBGiaHanGiaiQuyet:
                if (!click) {
                    Intent intent1 = new Intent(this, TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                    intent1.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", idGiahan);
                    startActivity(intent1);
                    click = true;
                }

                break;
            case R.id.tvDuyetHanNDVBDuyetDSVBGiaHanGiaiQuyet:
                handexuat = tvNgayThangNamNDVBDuyetDSVBGiaHanGiaiQuyet.getText().toString();
                getPresenter().duyetvbgiahangiaquyet(idGiahan, handexuat);

                break;
            case R.id.tvTuChoiHanNDVBDuyetDSVBGiaHanGiaiQuyet:

                builder = new AlertDialog.Builder(this);
                LayoutInflater inflatercanbo = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewcanbo = inflatercanbo.inflate(R.layout.dialog_tuchoi, null);
                builder.setView(viewcanbo);
                Dialog dialog1 = builder.create();
                Objects.requireNonNull(dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtTuChoi = viewcanbo.findViewById(R.id.edtTuChoi);
                lydo = edtTuChoi.getText().toString();
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
                        getPresenter().tuchoihangiaiquetvanban(idGiahan, edtTuChoi.getText().toString());
                    }
                });
                dialog1.show();
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
}
