package com.vpdt.vpdt.ui.activity.VanBanDen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.TTVBBaoCaoCuocHopChoPheDuyetActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDanhSachCongTacDangActivity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvSoTrang)
    TextView tvSoTrang;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvKetQuaThucHien)
    TextView tvKetQuaThucHien;
    @BindView(R.id.tvCoVanBanTraLoi)
    TextView tvCoVanBanTraLoi;

    @BindView(R.id.btnTraLai)
    Button btnTraLai;
    @BindView(R.id.btnXoa)
    Button btnXoa;

    String tvFileDinhKem;
    boolean click = false;
    int id, check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbdanh_sach_cong_tac_dang);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DetailVanBanDenTongThe detailVanBanDenTongThe = getIntent().getParcelableExtra("detailVanBanDenTongThe");
        if (detailVanBanDenTongThe != null) {
            id = detailVanBanDenTongThe.getPKIMaVBDen();
            String shortDate = detailVanBanDenTongThe.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            if (detailVanBanDenTongThe.getTraLai() == 1) {
                tvCoVanBanTraLoi.setVisibility(View.VISIBLE);
                btnTraLai.setVisibility(View.VISIBLE);
            }
//            if (detailVanBanDenTongThe.getXoa() == 1) {
//                btnXoa.setVisibility(View.VISIBLE);
//            }
            tvSKH.setText(String.valueOf(detailVanBanDenTongThe.getKyhieu()));
            tvSoDen.setText(String.valueOf(detailVanBanDenTongThe.getSoden()));
            tvNoiGui.setText(String.valueOf(detailVanBanDenTongThe.getNoiGui()));
            tvLoaiVanBan.setText(String.valueOf(detailVanBanDenTongThe.getTenlvb()));
            tvTrichYeu.setText(String.valueOf(detailVanBanDenTongThe.getTrichYeu().getMota1()));
            tvNguoiNhap.setText("Người nhập: " + String.valueOf(detailVanBanDenTongThe.getTrichYeu().getNguoinhap()));
            tvNoiDung.setText(String.valueOf(detailVanBanDenTongThe.getTrichYeu().getNoidung()));
            tvPhongChuTri.setText(String.valueOf(detailVanBanDenTongThe.getPhongCT()));
            tvKetQuaThucHien.setText(String.valueOf(detailVanBanDenTongThe.getKetqua()));
            if (!detailVanBanDenTongThe.getTrichYeu().getGiomoi().isEmpty()) {
                tvSoTrang.setText(String.valueOf("(Số trang: "
                        + detailVanBanDenTongThe.getTrichYeu().getSotrang()
                        + ") "
                        + detailVanBanDenTongThe.getTrichYeu().getMota2()
                        + " (Vào hồi "
                        + detailVanBanDenTongThe.getTrichYeu().getGiomoi()
                        + " ngày "
                        + detailVanBanDenTongThe.getTrichYeu().getNgaymoi()
                        + ", tại "
                        + detailVanBanDenTongThe.getTrichYeu().getDiadiemMoi()
                        + ")"));
            } else {
                tvSoTrang.setText(String.valueOf("( Số trang: " + detailVanBanDenTongThe.getTrichYeu().getSotrang() + ")" + detailVanBanDenTongThe.getTrichYeu().getMota2()));
            }
            tvFileDinhKem = detailVanBanDenTongThe.getTrichYeu().getDuongdan();
            check = detailVanBanDenTongThe.getTrichYeu().getIGiayMoi();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemFileDinhKem, R.id.tvXemChiTiet, R.id.btnTraLai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    if (check == 1) {
                        Intent intent = new Intent(this, TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
                        intent.putExtra("idvb", id);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(this, TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                        intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", id);
                        startActivity(intent);
                    }
                    click = true;
                }
                break;
            case R.id.tvXemFileDinhKem:
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvFileDinhKem));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnTraLai:
                Toast.makeText(this, "Đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.btnXoa:
//                Toast.makeText(this, "Đang hoàn thiện", Toast.LENGTH_SHORT).show();
//                break;
        }
    }
}
