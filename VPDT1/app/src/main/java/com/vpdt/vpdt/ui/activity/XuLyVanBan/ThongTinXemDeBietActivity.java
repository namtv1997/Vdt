package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.FileXemDeBiet;
import com.vpdt.vpdt.model.XemDeBiet;
import com.vpdt.vpdt.ui.adapter.AdapterFileXemDeBiet;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThongTinXemDeBietActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterFileXemDeBiet.OnItemClickListener {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayThangNamNDVB_DSVB_DaChiDao)
    TextView tvNgayThangNamNDVB_DSVB_DaChiDao;

    @BindView(R.id.tvLuuY)
    TextView tvLuuY;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;

    AdapterFileXemDeBiet adapterFileXemDeBiet;
    int id;
    boolean click = false;

    @BindView(R.id.edtChiDao1)
    TextView edtChiDao1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_xem_de_biet);
        ButterKnife.bind(this);
        Util.checkConnection(this);

        XemDeBiet xemDeBiet = getIntent().getParcelableExtra("xemDeBiet");
        if (xemDeBiet != null) {
            recyclerviewFileXemDeBiet((ArrayList<FileXemDeBiet>) xemDeBiet.getFiles());
            id = xemDeBiet.getId();
            String shortDate = xemDeBiet.getNgayNhap();
            tvNgay.setText(String.valueOf(shortDate.substring(0, 5)));
            tvSoDen.setText(String.valueOf(xemDeBiet.getSoDen()));
            tvSKH.setText(String.valueOf(xemDeBiet.getSoKyHieu()));
            tvNoiGui.setText(String.valueOf(xemDeBiet.getNoiGui()));
            tvLoaiVanban.setText(String.valueOf(xemDeBiet.getThuocLoai()));
            tvTrichYeu.setText(String.valueOf(xemDeBiet.getMota()));
            tvNgayThangNamNDVB_DSVB_DaChiDao.setText(String.valueOf(xemDeBiet.getHanGiaQuyet()));
            edtChiDao1.setText(String.valueOf(xemDeBiet.getChiDao()));
            tvLuuY.setText(String.valueOf("Lưu ý: " + xemDeBiet.getLuuY()));
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
}
