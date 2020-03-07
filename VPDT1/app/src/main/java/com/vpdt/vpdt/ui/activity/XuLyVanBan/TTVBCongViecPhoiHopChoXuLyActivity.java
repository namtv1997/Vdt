package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailDeXuatCongViecPhoiHopChoDuyet;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongPP;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongTL;
import com.vpdt.vpdt.model.QuaTrinhChuyenNhanPH;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.presenter.TTVB_DeXuatCongViecPhoiHopChoDuyetPresenter;
import com.vpdt.vpdt.presenter.TTVB_DeXuatCongViecPhoiHopChoDuyetView;
import com.vpdt.vpdt.presenter.impl.TTVB_DeXuatCongViecPhoiHopChoDuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongTL;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet;
import com.vpdt.vpdt.ui.adapter.Adapter_QuaTrinhChuyenNhanPhoiHop;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBCongViecPhoiHopChoXuLyActivity extends BaseActivity<TTVB_DeXuatCongViecPhoiHopChoDuyetPresenter> implements
        TTVB_DeXuatCongViecPhoiHopChoDuyetView, AdapterTepTinDinhKemPhongPH.OnItemClickListener,
        AdapterKetQuaGiaiQuyetPhongPH.OnItemketquaGiaiquyetClickListener, AdapterKetQuaGiaiQuyetPhongTL.OnItemketquaGiaiquyetPhongThulyClickListener, Adapter_QuaTrinhChuyenNhanPhoiHop.OnItemClickListener {

    @BindView(R.id.imDownThongTinVanBan)
    ImageView imDownTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpThongTinVanBan)
    ImageView imUpTTVBTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownTrinhTuGiaiQuyet)
    ImageView imDownTTGQTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTrinhTuGiaiQuyet)
    ImageView imUpTTGQTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownTepDinhKem)
    ImageView imDownTTDKTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTepDinhKem)
    ImageView imUpTTDKTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownTruyenNhanLuuViet)
    ImageView imDownTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTruyenNhanLuuViet)
    ImageView imUpTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownKetQuaGiaiQuyetPPH)
    ImageView imDownKetQuaGiaiQuyetPPH;
    @BindView(R.id.imUpKetQuaGiaiQuyetPPH)
    ImageView imUpKetQuaGiaiQuyetPPH;

    @BindView(R.id.imDownKetQuaGiaiQuyetPThuLy)
    ImageView imDownKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.imUpKetQuaGiaiQuyetPThuLy)
    ImageView imUpKetQuaGiaiQuyetPThuLy;

    @BindView(R.id.imDownTrinhTuGiaiQuyetPPH)
    ImageView imDownTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTrinhTuGiaiQuyetPPH)
    ImageView imUpTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownQuaTrinhChuyenNhanPhoiHop)
    ImageView imDownQuaTrinhChuyenNhanPhoiHop;
    @BindView(R.id.imUpQuaTrinhChuyenNhanPhoiHop)
    ImageView imUpQuaTrinhChuyenNhanPhoiHop;


    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnTTVBTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTTGQTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKemTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTruyenNhanLuuViet)
    LinearLayout lnTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTrinhTuGiaiQuyetPPH)
    LinearLayout lnTrinhTuGiaiQuyetPPHTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnKetQuaGiaiQuyetPPH)
    LinearLayout lnKetQuaGiaiQuyetPPH;
    @BindView(R.id.lnKetQuaGiaiQuyetPThuLy)
    LinearLayout lnKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.lnQuaTrinhChuyenNhanPhoiHop)
    LinearLayout lnQuaTrinhChuyenNhanPhoiHop;


    @BindView(R.id.tvSoDen)
    TextView tvSoDenTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvKhuVuc)
    TextView tvKhuVucTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieuTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBanTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeuTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKyTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNgayNhan)
    TextView tvNgayNhanTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvSoTrang)
    TextView tvSoTrangTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvDoMat)
    TextView tvDoMatTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNoiGuiDen)
    TextView tvNoiGuiDenTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKyTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvChucVu)
    TextView tvChucVuTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyetTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvDoKhan)
    TextView tvDoKhanTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNgayPhanLoai)
    TextView tvNgayPhanLoaiTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTTGQTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rcvTruyenNhanLuuViet)
    RecyclerView rcvTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rcvTTGQPPH)
    RecyclerView rcvTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rcvKetQuaGiaiQuyetPPH)
    RecyclerView rcvKetQuaGiaiQuyetPPH;
    @BindView(R.id.rcvKetQuaGiaiQuyetPThuLy)
    RecyclerView rcvKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.rcvQuaTrinhChuyenNhanPhoiHop)
    RecyclerView rcvQuaTrinhChuyenNhanPhoiHop;


    @BindView(R.id.cbVBQPPL)
    CheckBox cbVBQPPL;
    @BindView(R.id.cbSTCChuTri)
    CheckBox cbSTCChuTri;
    @BindView(R.id.cbTBKL)
    CheckBox cbTBKL;

    @BindView(R.id.lnGiamDoc)
    LinearLayout lnGiamDoc;

    @BindView(R.id.rdVBChiDeLuuTTVBDSVBDenChoLDXL)
    RadioButton rdVBChiDeLuuTTVBDSVBDenChoLDXL;
    @BindView(R.id.rdVBYeuCauTraLoiTTVBDSVBDenChoLDXL)
    RadioButton rdVBYeuCauTraLoiTTVBDSVBDenChoLDXL;

    @BindView(R.id.tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL)
    EditText tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL;

    @BindView(R.id.rlTrinhTuGiaiQuyet)
    RelativeLayout rlTrinhTuGiaiQuyet;
    @BindView(R.id.rlTepDinhKem)
    RelativeLayout rlTepDinhKem;
    @BindView(R.id.rlTrinhTuTruyenNhanLuuVet)
    RelativeLayout rlTrinhTuTruyenNhanLuuVet;
    @BindView(R.id.rlTrinhTuGiaiQuyetPhongPhoiHop)
    RelativeLayout rlTrinhTuGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rlKetQuaGiaiQuyetPhongThuLy)
    RelativeLayout rlKetQuaGiaiQuyetPhongThuLy;
    @BindView(R.id.rlQuaTrinhChuyenNhanPhoiHop)
    RelativeLayout rlQuaTrinhChuyenNhanPhoiHop;
    @BindView(R.id.rlKetQuaGiaiQuyetPhongPhoiHop)
    RelativeLayout rlKetQuaGiaiQuyetPhongPhoiHop;

    int level;

    private AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet adapterTrinhTuGiaiQuyet;
    private AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet adapterTrinhTuChuyenNhanLuuVet;
    private AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet adapterTrinhTuGiaiQuyetPhongPhoiHop;
    private AdapterTepTinDinhKemPhongPH adapterTepTinDinhKem;
    private AdapterKetQuaGiaiQuyetPhongPH adapterKetQuaGiaiQuyetPhongPH;
    private AdapterKetQuaGiaiQuyetPhongTL adapterKetQuaGiaiQuyetPhongTL;
    private Adapter_QuaTrinhChuyenNhanPhoiHop adapter_quaTrinhChuyenNhanPhoiHop;

    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbcong_viec_phoi_hop_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY")) {
                id = intent.getIntExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", 0);
                getPresenter().getDetailVBChuyenVienChuTriXuLy(id);

            }
        }
        if (level == 4 || level == 5 || level == 10) {
            lnGiamDoc.setVisibility(View.VISIBLE);
        }

    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan, R.id.lnTTVB,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvTruyenNhanLuuViet, R.id.tvTrinhTuGiaiQuyetPPH,
            R.id.tvKetQuaGiaiQuyetPPH, R.id.tvKetQuaGiaiQuyetPThuLy, R.id.tvQuaTrinhChuyenNhanPhoiHop,
            R.id.btnCVDangThucHienTTVBDSVBDenChoLDXL, R.id.btnCVDaHoanThanhTTVBDSVBDenChoLDXL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvThongTinVanBan:
                Expand(lnTTVBTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTVBTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTrinhTuGiaiQuyet:
                Expand(lnTTGQTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTGQTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTGQTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTepDinhKem:
                Expand(lnTepDinhKemTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTDKTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTDKTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTruyenNhanLuuViet:
                Expand(lnTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTrinhTuGiaiQuyetPPH:
                Expand(lnTrinhTuGiaiQuyetPPHTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvKetQuaGiaiQuyetPPH:
                Expand(lnKetQuaGiaiQuyetPPH, imUpKetQuaGiaiQuyetPPH, imDownKetQuaGiaiQuyetPPH);
                break;
            case R.id.tvKetQuaGiaiQuyetPThuLy:
                Expand(lnKetQuaGiaiQuyetPThuLy, imUpKetQuaGiaiQuyetPThuLy, imDownKetQuaGiaiQuyetPThuLy);
                break;
            case R.id.tvQuaTrinhChuyenNhanPhoiHop:
                Expand(lnQuaTrinhChuyenNhanPhoiHop, imUpQuaTrinhChuyenNhanPhoiHop, imDownQuaTrinhChuyenNhanPhoiHop);
                break;
            case R.id.btnCVDangThucHienTTVBDSVBDenChoLDXL:
                if (rdVBChiDeLuuTTVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().luuketqua(id, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 1, "", 0);
                } else if (rdVBYeuCauTraLoiTTVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().luuketqua(id, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 2, "", 0);
                }
                break;

            case R.id.btnCVDaHoanThanhTTVBDSVBDenChoLDXL:
                getPresenter().luuketqua(id, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 0, "", 1);
                break;
            case R.id.lnTTVB:
                closeKeyboard();
                break;
        }
    }

    void Expand(LinearLayout linearLayout, ImageView imgGone, ImageView imgVisible) {
        if (linearLayout.getVisibility() == View.GONE) {
            imgGone.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            imgVisible.setVisibility(View.GONE);
        } else {
            linearLayout.setVisibility(View.GONE);
            imgGone.setVisibility(View.GONE);
            imgVisible.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDaTaSuccess(DetailDeXuatCongViecPhoiHopChoDuyet detailDeXuatCongViecPhoiHopChoDuyet) {
        RecyclerViewTrinhTuGiaiQuyet((ArrayList<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet>) detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuGiaiQuyets());
        RecyclerViewTrinhTuChuyenNhanLuuVet((ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet>) detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuChuyenNhanLuuVets());
        RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop((ArrayList<TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet>) detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuGiaiQuyetPhongPHs());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) detailDeXuatCongViecPhoiHopChoDuyet.getTepTinDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongPhoiHop((ArrayList<KetQuaGiaiQuyetPhongPP>) detailDeXuatCongViecPhoiHopChoDuyet.getketQuaGiaiQuyetPhongPHs());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetQuaGiaiQuyetPhongTL>) detailDeXuatCongViecPhoiHopChoDuyet.getKetQuaGiaiQuyetPhongTLs());
        RecyclerViewQuaTrinhChuyenNhanPhoiHop((ArrayList<QuaTrinhChuyenNhanPH>) detailDeXuatCongViecPhoiHopChoDuyet.getQuaTrinhChuyenNhanPHs());

        tvSoDenTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getSoDen()));
        tvKhuVucTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getKhuVuc()));
        tvSoKyHieuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getSoKyHieu()));
        tvLoaiVanBanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getLoaiVanBan()));
        tvTrichYeuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getMoTa()));
        tvNguoiKyTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getTenNguoiKy()));
        tvNgayNhanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getNgayNhan()));
        tvSoTrangTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getSoTrang()));
        tvDoMatTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getDoMat()));
        tvNoiGuiDenTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getNoiGuiDen()));
        tvNgayKyTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getNgayKy()));
        tvChucVuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getChucVu()));
        tvHanGiaiQuyetTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getHanGiaiQuyet()));
        tvDoKhanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getDoKhan()));
//        tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.get));
        tvNgayPhanLoaiTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getNgayPhanLoai()));
        if (detailDeXuatCongViecPhoiHopChoDuyet.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getVBQPPL() == 1) {
            cbVBQPPL.setChecked(true);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuGiaiQuyets().size() == 0) {
            rlTrinhTuGiaiQuyet.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyetPPHTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getTepTinDinhKems().size() == 0) {
            rlTepDinhKem.setVisibility(View.GONE);
            lnTepDinhKemTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getQuaTrinhChuyenNhanPHs().size() == 0) {
            rlQuaTrinhChuyenNhanPhoiHop.setVisibility(View.GONE);
            lnQuaTrinhChuyenNhanPhoiHop.setVisibility(View.GONE);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuChuyenNhanLuuVets().size() == 0) {
            rlTrinhTuTruyenNhanLuuVet.setVisibility(View.GONE);
            lnTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuGiaiQuyetPhongPHs().size() == 0) {
            rlTrinhTuGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyetPPHTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getKetQuaGiaiQuyetPhongTLs().size() == 0) {
            rlKetQuaGiaiQuyetPhongThuLy.setVisibility(View.GONE);
            lnKetQuaGiaiQuyetPThuLy.setVisibility(View.GONE);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getketQuaGiaiQuyetPhongPHs().size() == 0) {
            rlKetQuaGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            lnKetQuaGiaiQuyetPPH.setVisibility(View.GONE);
        }
    }

    @Override
    public void xoaKQPhongTLSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        getPresenter().getDetailVBChuyenVienChuTriXuLy(id);
    }

    @Override
    public void onGetCongViecSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public TTVB_DeXuatCongViecPhoiHopChoDuyetPresenter createPresenter() {
        return new TTVB_DeXuatCongViecPhoiHopChoDuyetPresenterImpl(this);
    }

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyet = new AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManager);
        rcvTTGQTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyet);
        adapterTrinhTuGiaiQuyet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuChuyenNhanLuuVet(ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet> trinhTuChuyenNhanLuuVets) {
        adapterTrinhTuChuyenNhanLuuVet = new AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet(trinhTuChuyenNhanLuuVets);
        LinearLayoutManager layoutManagerTrinhTuChuyenNhanLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuChuyenNhanLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManagerTrinhTuChuyenNhanLuuVet);
        rcvTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTrinhTuChuyenNhanLuuVet);
        adapterTrinhTuChuyenNhanLuuVet.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinDinhKemPPH> tepDinhKems) {
        adapterTepTinDinhKem = new AdapterTepTinDinhKemPhongPH(tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTDKTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTepTinDinhKem);
        adapterTepTinDinhKem.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop(ArrayList<TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyetPhongPhoiHops) {
        adapterTrinhTuGiaiQuyetPhongPhoiHop = new AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet(trinhTuGiaiQuyetPhongPhoiHops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetPhongPhoiHop);
        adapterTrinhTuGiaiQuyetPhongPhoiHop.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongPhoiHop(ArrayList<KetQuaGiaiQuyetPhongPP> ketquaGiaiquyetPhongPhoihops) {
        adapterKetQuaGiaiQuyetPhongPH = new AdapterKetQuaGiaiQuyetPhongPH(ketquaGiaiquyetPhongPhoihops, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPPH.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPPH.setAdapter(adapterKetQuaGiaiQuyetPhongPH);
        adapterKetQuaGiaiQuyetPhongPH.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongThuLy(ArrayList<KetQuaGiaiQuyetPhongTL> ketquaGiaiquyetPhongThulies) {
        adapterKetQuaGiaiQuyetPhongTL = new AdapterKetQuaGiaiQuyetPhongTL(ketquaGiaiquyetPhongThulies, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPThuLy.setAdapter(adapterKetQuaGiaiQuyetPhongTL);
        adapterKetQuaGiaiQuyetPhongTL.notifyDataSetChanged();
    }

    void RecyclerViewQuaTrinhChuyenNhanPhoiHop(ArrayList<QuaTrinhChuyenNhanPH> quaTrinhChuyenNhanPHS) {
        adapter_quaTrinhChuyenNhanPhoiHop = new Adapter_QuaTrinhChuyenNhanPhoiHop(quaTrinhChuyenNhanPHS, this);
        LinearLayoutManager layoutManagerTrinhTuHoanThanhLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuHoanThanhLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvQuaTrinhChuyenNhanPhoiHop.setLayoutManager(layoutManagerTrinhTuHoanThanhLuuVet);
        rcvQuaTrinhChuyenNhanPhoiHop.setAdapter(adapter_quaTrinhChuyenNhanPhoiHop);
        adapter_quaTrinhChuyenNhanPhoiHop.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(TepTinDinhKemPPH tepTinDinhKemPPH) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tepTinDinhKemPPH.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemketquaGiaiquyetClick(KetQuaGiaiQuyetPhongPP ketquaGiaiquyetPhongPhoihop) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongPhoihop.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemketquaGiaiquyetPhongThulyClick(KetQuaGiaiQuyetPhongTL ketquaGiaiquyetPhongThuly) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongThuly.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemTacVuClick(KetQuaGiaiQuyetPhongTL ketquaGiaiquyetPhongThuly) {
        getPresenter().xoaKQPhongTL(ketquaGiaiquyetPhongThuly.getId());
    }

    @Override
    public void onItemClicktvRCVFileYeuCau(QuaTrinhChuyenNhanPH quaTrinhChuyenNhanPH) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(quaTrinhChuyenNhanPH.getUrlFileYeuCau()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClicktvRCVFileTraLoi(QuaTrinhChuyenNhanPH quaTrinhChuyenNhanPH) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(quaTrinhChuyenNhanPH.getUrlFileTraLoi()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
