package com.vpdt.vpdt.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.CanBo;
import com.vpdt.vpdt.model.MenuLeft;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanTheoLoaiNoiDen;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.Contact;
import com.vpdt.vpdt.presenter.MainPresenter;
import com.vpdt.vpdt.presenter.MainView;
import com.vpdt.vpdt.presenter.impl.MainPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterMeNu;
import com.vpdt.vpdt.ui.adapter.AdapterMeNuLeft1;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.DanhGiaChamDiemPhanLoaiPGDTruongPhongFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.DanhGiaPheDuyetKetQuaPhanLoaiThangCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.GDSoTuNhanXetDanhGiaKetQuaThangFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.NhanXetChamDiemCongViecTuanCuaCapDuoiFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.PhanLoaiCongChucCuaPhongTheoThangFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.QuanLyCanBoFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.ThongKeKetQuaCongTacThangTrongToanSoFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.ThongKeKetQuaCongTacTuanTrongToanSoFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.XemKeHoachKetQuaCongTacThangCuaCacPhongFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyCanBo.XemKeHoachKetQuaCongTacTuanCuaCacPhongFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DSDauViecPhongChuTriDaXuLyCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DSDauViecPhongPhoiHopDaXuLyCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DSKienNghiHDNDFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DSTaiLieuHopHDNDCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DSTaiLieuHopHDNDCuaTongHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDaChiDaoTruongPhongPhoiHopTPCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDeXuatGiaHanChuyenVienFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDeXuatGiaHanDaXuLyChuyenVienFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDeXuatGiaHanDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDeXuatGiaHanFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecPhongChuTriFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecQuaHanCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachPhongChuTriDaChiDaoChuaHTTPCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachPhongPhoiHopDaChiDaoTPCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecChuyenVienXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecHoanThanhBiTraLaiFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecHoanThanhChoLanhDaoPhongDuyetFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriChoXuLyCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriChoXuLyPhoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriChoXuLyTPCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriChuyenVienChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriDaChiDaoChuaHTFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriDaXuLyPhoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyCVPHFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyChuyenVienFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyPhoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyTPCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopDaChiDaoChuaHTFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopDaXuLyPhoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecTruongPhongPhoiHopPhongCTTPCCFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.QuanLyDauViecFragment;
import com.vpdt.vpdt.ui.fragment.TraoDoiThongTinNoiBo.ThongTinDaGuiDiFragment;
import com.vpdt.vpdt.ui.fragment.TraoDoiThongTinNoiBo.ThongTinDaXemFragment;
import com.vpdt.vpdt.ui.fragment.TraoDoiThongTinNoiBo.ThongTinMoiFragment;
import com.vpdt.vpdt.ui.fragment.TraoDoiThongTinNoiBo.TraoDoiThongTinNoiBoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.BaoCaoTongHopFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.DanhSachCongTacDangFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.DanhSachGiayMoiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.DanhSachTongTheFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.InSoLuuTruVanBanDenFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.ThongKeVBTheoLDChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.ThongKeVanBanTheoPGDFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.ThongKeVanBanTheoPhoGiamDocFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.ThongKeVanBanTheoPhongFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.VanBanDenFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.VanBanSTCChuTriFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachGiayMoiCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachGiayMoiCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachVBSoThamMuuTrinhTPFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachVanBanChoSoCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachVanBanCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachVanBanCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.InSoLuuTruVanBanDiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.LichHopCuaSoChuTriFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanChuTriChoXuLyCCFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanChuTriDaXuLyCCFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanChuTriDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanDaTrinhKyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanDiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanTrinhKyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanXemDeBietFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDiDonViCapHai.DanhSachVanBanChoSoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDiDonViCapHai.DanhSachVanBanCuaPhongLV3Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDiDonViCapHai.DanhSachVanBanDiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDiDonViCapHai.VanBanDiDonViCapHaiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.DanhSachVanBanPhongChuTriLV3Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.DanhSachVanBanPhongPhoiHopLV3Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.DanhSachVanBanTongTheFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoChiDaoLV1Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoChiDaoLV2Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoDuyetLV3Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoXuLyVBChuTriLV3Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoXuLyVBChuTriLV4Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoXuLyVBChuTriLV5Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoXuLyVBPhoiHopLV3Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoXuLyVBPhoiHopLV4Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanChoXuLyVBPhoiHopLV5Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDaChiDaoPhongChuaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDaChiDaoPhongChuaXuLyLV2Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDaXuLyVBChuTriChuaKetThucLV3Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDaXuLyVBChuTriChuaKetThucLV4Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDaXuLyVBChuTriLV5Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDaXuLyVBPhoiHopChuaKetThucLV3Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDaXuLyVBPhoiHopChuaKetThucLV4Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDaXuLyVBPhoiHopLV5Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanDonViCapHaiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanPhoiHopChoXuLyLV4Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanPhoiHopChoXuLyLV5Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanPhoiHopDaXuLyLV4Fragment;
import com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai.VanBanPhoiHopDaXuLyLV5Fragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.BaoCaoCuocHopChoPheDuyetFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.BaoCaoKetQuaCuocHopDaGuiDiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.BaoCaoKetQuaCuocHopDaXemFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.BaoCaoKetQuaCuocHopMoiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.DSGiayMoiDenCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiChoLanhDaoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiChoPhanLoaiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiDaPhanLoaiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiDaXuLyCCFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiDaXulyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiGiaoChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiGiaoPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiGiaoPhongChuTriDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiGiaoPhongChuTriDaHoanThanhFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiGiaoPhongPhoiHopDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiLanhDaoDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiPhoPhongPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiPhoiHopDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiPhoiHopDaXuLyTPCCFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiPhoiHopTraLaiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiPhongChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiPhongPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.GiayMoiXemDeBietFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.XemLichCongTacFragment;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.XuLyGiayMoiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.CongViecPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSPGDBietDeDonDocFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVBCongTacDangChoLDXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVBDaDeXuatGiaHanGiaiQuyetFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVBDaHoanThanhChoLDPhongPheDuyetFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVBXemDeBietFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVB_ChoLanhDaoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVB_DaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVB_QuaHanCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVB_QuaHanDoLanhDaoChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVB_QuanTrongCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DSVB_TheoPhongFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DeXuatCongViecPhoiHopChoDuyetFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.DuyetDSVB_GiaHanGiaiQuyetFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.PhanLoaiVanBanCongTacDangFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.PhanLoaiVanBanFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.SoLuongVanBanGiaoChiCucPhoChuTriFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.SoLuongVanBanGiaoPhongCap2ChuTriFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.SoLuongVanBanGiaoPhongChuTriFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.SoLuongVanBanGiaoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.TongSoLuongDonThuKNTC_GiaoPhongXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.TongSoLuongToCongTac_GiaoPhongXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VB_CongTacDangChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanCacPhongChuyenLaiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanChuTriChoXuLyChuyenVienFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanChuTriChoXuLyPhoPhongFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanChuTriDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanDaChiDaoChuaHoanThanhFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanDaChiDaoSTCPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanDaPhanLoaiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanGiaoPhongChuChiChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanGiaoPhongChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanGiaoPhongPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanNguoiDungPhoiHopXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanNguoiDungXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanPhoPhongBietDeDonDocFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanPhoPhongPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanPhoiHopChoXuLyChuyenVienFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanPhoiHopDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanPhoiHopTraLaiFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanPhongChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanPhongChuTriDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.VanBanSTCPhoiHopDaChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.XuLyVanBan.XulyVanBanFragment;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView,
        AdapterNamLamViec.OnItemClickListenerNamLamViec, AdapterMeNu.OnItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rcvMenu)
    RecyclerView rcvMenu;

    @BindView(R.id.tvNameCanBo)
    TextView tvNameCanBo;
    @BindView(R.id.tvNotifi)
    TextView tvNotifi;
    @BindView(R.id.tvTenDinhDanh)
    TextView tvTenDinhDanh;
    @BindView(R.id.tvTieuDe)
    TextView tvTieuDe;

    @BindView(R.id.fl)
    FrameLayout frameConTent;

    @BindView(R.id.ivMenu)
    ImageView ivMenu;
    @BindView(R.id.imSearch)
    ImageView imSearch;

    @BindView(R.id.btnNamLamViecTrangChu)
    Button btnNamLamViecTrangChu;

    @BindView(R.id.rcvTC)
    RecyclerView recycler;
    @BindView(R.id.tvTextRun)
    TextView tvTextRun;

    RecyclerView rvSelectNam;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    int year;
    AlertDialog dialog;
    String key1, key2;
    String NamLamViec;
    String title;
    Fragment frg;
    AdapterMeNuLeft1 listAdapter;
    AdapterMeNu listAdapter1;
    AdapterNamLamViec adapterNamLamViec;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getCanBoDetail();

        getPresenter().countThongBao(1);
        getPresenter().getMenuLeft(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        setSupportActionBar(toolbar);
        if (PrefUtil.getDataCanBo(this) != null) {
            String namecanBo = PrefUtil.getDataCanBo(this).getSHoTen();
            tvNameCanBo.setText(namecanBo);
        }
        year = Calendar.getInstance().get(Calendar.YEAR);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("key1")) {
                key1 = intent.getStringExtra("key1");
            }
            if (intent.hasExtra("key2")) {
                key2 = intent.getStringExtra("key2");
            }
        }
        setToolbarTitle();
    }

    //    @Override
//    protected void onResume() {
//        super.onResume();
//        getPresenter().countThongBao(1);
//        click = false;
//        PeriodicWorkRequest simpleRequest = new PeriodicWorkRequest.Builder(MyRequestTokenWorker.class, 16, TimeUnit.MINUTES)
//                .build();
//        WorkManager.getInstance().enqueue(simpleRequest);
//    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onStart() {
        super.onStart();
        tvTextRun.setSelected(true);

        click = false;

        title=PrefUtil.getString(this,Key.TITLE,"");
        if (frg ==null){
            tvTieuDe.setText("TRANG CHỦ");
        }else {
            tvTieuDe.setText(title);
        }

        imSearch.setVisibility(View.INVISIBLE);

        NamLamViec = PrefUtil.getString(this, Key.NAM_LAM_VIEC, "");
        btnNamLamViecTrangChu.setText("Năm làm việc: " + NamLamViec + "   ");
        getPresenter().getMenu(NamLamViec, "", String.valueOf(false));
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(this, integerArrayList, this);
        }
        if (key1 != null) {
            switch (key1) {
                case Key.XLVB:
                    XulyVanBanFragment xulyVanBanFragment = new XulyVanBanFragment();
                    Bundle bundle7 = new Bundle();
                    bundle7.putString("key2", key2);
                    xulyVanBanFragment.setArguments(bundle7);
                    replaceFragment(xulyVanBanFragment, R.id.fl);
                    click = true;
                    break;
                case Key.XLGM:
                    XuLyGiayMoiFragment xuLyGiayMoiFragment = new XuLyGiayMoiFragment();
                    Bundle bundle6 = new Bundle();
                    bundle6.putString("key2", key2);
                    xuLyGiayMoiFragment.setArguments(bundle6);
                    replaceFragment(xuLyGiayMoiFragment, R.id.fl);
                    click = true;
                    break;
                case Key.VBDen:
                    VanBanDenFragment vanBanDenFragment = new VanBanDenFragment();
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("key2", key2);
                    vanBanDenFragment.setArguments(bundle5);
                    replaceFragment(vanBanDenFragment, R.id.fl);
                    click = true;
                    break;
                case Key.VBDi:
                    VanBanDiFragment vanBanDiFragment = new VanBanDiFragment();
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("key2", key2);
                    vanBanDiFragment.setArguments(bundle4);
                    replaceFragment(vanBanDiFragment, R.id.fl);
                    click = true;
                    break;
                case Key.TDTTNB:
                    TraoDoiThongTinNoiBoFragment traoDoiThongTinNoiBoFragment = new TraoDoiThongTinNoiBoFragment();
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("key2", key2);
                    traoDoiThongTinNoiBoFragment.setArguments(bundle3);
                    replaceFragment(traoDoiThongTinNoiBoFragment, R.id.fl);
                    click = true;
                    break;
                case Key.QLDV:
                    QuanLyDauViecFragment quanLyDauViecFragment = new QuanLyDauViecFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key2", key2);
                    quanLyDauViecFragment.setArguments(bundle2);
                    replaceFragment(quanLyDauViecFragment, R.id.fl);
                    click = true;
                    break;
                case Key.QLCB:
                    QuanLyCanBoFragment quanLyCanBoFragment = new QuanLyCanBoFragment();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("key2", key2);
                    quanLyCanBoFragment.setArguments(bundle1);
                    replaceFragment(quanLyCanBoFragment, R.id.fl);
                    click = true;
                    break;
                case Key.vanBanDonViCapHai:
                    VanBanDonViCapHaiFragment vanBanDonViCapHaiFragment = new VanBanDonViCapHaiFragment();
                    Bundle bundle8 = new Bundle();
                    bundle8.putString("key2", key2);
                    vanBanDonViCapHaiFragment.setArguments(bundle8);
                    replaceFragment(vanBanDonViCapHaiFragment, R.id.fl);
                    click = true;
                    break;
                case Key.vanBanDiDonViCapHai:
                    VanBanDiDonViCapHaiFragment vanBanDiDonViCapHaiFragment = new VanBanDiDonViCapHaiFragment();
                    Bundle bundle9 = new Bundle();
                    bundle9.putString("key2", key2);
                    vanBanDiDonViCapHaiFragment.setArguments(bundle9);
                    replaceFragment(vanBanDiDonViCapHaiFragment, R.id.fl);
                    click = true;
                    break;
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        drawerLayout.closeDrawers();
        integerArrayList.clear();
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(ArrayList<Contact> contacts) {
        listAdapter1 = new AdapterMeNu(this, contacts, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(listAdapter1);
        listAdapter1.notifyDataSetChanged();
        getPresenter().getThongBaoHome();
    }

    @Override
    public void onGetMenuLeftSuccess(ArrayList<MenuLeft> menuLefts) {
        listAdapter = new AdapterMeNuLeft1(this, menuLefts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvMenu.setLayoutManager(layoutManager);
        rcvMenu.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetThongBaoSuccess(String s) {
        tvTextRun.setText(s);
    }

    @Override
    public void ongetAllTK_noidenSuccess(ArrayList<VanBanTheoLoaiNoiDen> vanBanTheoLoaiNoiDenArrayList) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onGetDataCanBoSuccess(CanBo canBo) {
        tvNameCanBo.setText(String.valueOf(canBo.getSHoTen()));
        if (canBo.getTendinhdanh() == null) {
            tvTenDinhDanh.setText("Tài khoản");
        } else {
            tvTenDinhDanh.setText(String.valueOf(canBo.getTendinhdanh()));
        }
    }

    @Override
    public void onLogOutSuccess() {
        this.startActivity(LoginActivity.getCallingIntent(this));
    }


    @Override
    public void onGetDataFail() {

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() > 0) {
            tvNotifi.setVisibility(View.VISIBLE);
            tvNotifi.setText(String.valueOf(response.getData()));
        }
    }

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @OnClick({R.id.btnDoiMatKhau, R.id.btnDangXuat, R.id.ivMenu, R.id.lnHuongDan, R.id.lnThongbao,
            R.id.lnmain, R.id.rlmain, R.id.lnmain1, R.id.imSearch, R.id.btnNamLamViecTrangChu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivMenu:
                Util.checkConnection(this);
                getPresenter().countThongBao(1);
                getPresenter().getMenuLeft(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.imSearch:
                Intent inten2 = new Intent(this, SearchActivity.class);
                startActivity(inten2);
                break;
            case R.id.lnHuongDan:
                Toast.makeText(this, "Đang hoàn thiện", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                break;
            case R.id.lnThongbao:
                Intent inten = new Intent(this, ThongBaoActivity.class);
                startActivity(inten);
                break;
            case R.id.btnDoiMatKhau:
                Intent inten1 = new Intent(this, DoiMatKhau.class);
                startActivity(inten1);
                break;
            case R.id.btnDangXuat:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Đăng xuất");
                builder1.setMessage("Bạn có muốn đăng xuất tài khoản?");
                builder1.setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialogInterface, int i) {
                        getPresenter().logOut();
                        dialogInterface.dismiss();
                    }
                });
                builder1.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.btnNamLamViecTrangChu:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_nam_selected, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvSelectNam = view1.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();
                break;
        }
    }

    public void setToolbarTitle() {
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_symbol);
    }

    public void replaceFragment(Fragment fragment, int replace) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(replace, fragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    @SuppressLint("SetTextI18n")
    public void checkFragment(Fragment fragment) {
        frg = fragment;
        if (fragment instanceof QuanLyCanBoFragment || fragment instanceof QuanLyDauViecFragment
                || fragment instanceof TraoDoiThongTinNoiBoFragment || fragment instanceof VanBanDiFragment || fragment instanceof XuLyGiayMoiFragment
                || fragment instanceof XulyVanBanFragment || fragment instanceof VanBanDonViCapHaiFragment
                || fragment instanceof VanBanDiDonViCapHaiFragment || fragment instanceof VanBanDenFragment) {
            imSearch.setVisibility(View.INVISIBLE);
        } else {
            imSearch.setVisibility(View.VISIBLE);
        }

        if (fragment instanceof CongViecPhoiHopChoXuLyFragment || fragment instanceof DeXuatCongViecPhoiHopChoDuyetFragment ||
                fragment instanceof DSPGDBietDeDonDocFragment || fragment instanceof DSVB_ChoLanhDaoXuLyFragment ||
                fragment instanceof DSVB_DaChiDaoFragment || fragment instanceof DSVB_QuaHanCuaPhongFragment ||
                fragment instanceof DSVB_QuaHanDoLanhDaoChiDaoFragment || fragment instanceof DSVB_QuanTrongCuaSoFragment ||
                fragment instanceof DSVB_TheoPhongFragment || fragment instanceof DSVBCongTacDangChoLDXuLyFragment ||
                fragment instanceof DSVBDaDeXuatGiaHanGiaiQuyetFragment || fragment instanceof DSVBDaHoanThanhChoLDPhongPheDuyetFragment ||
                fragment instanceof DSVBXemDeBietFragment || fragment instanceof DuyetDSVB_GiaHanGiaiQuyetFragment ||
                fragment instanceof PhanLoaiVanBanCongTacDangFragment || fragment instanceof PhanLoaiVanBanFragment ||
                fragment instanceof SoLuongVanBanGiaoChiCucPhoChuTriFragment || fragment instanceof SoLuongVanBanGiaoPhongCap2ChuTriFragment ||
                fragment instanceof SoLuongVanBanGiaoPhongChuTriFragment || fragment instanceof SoLuongVanBanGiaoPhongPhoiHopFragment ||
                fragment instanceof TongSoLuongDonThuKNTC_GiaoPhongXuLyFragment || fragment instanceof TongSoLuongToCongTac_GiaoPhongXuLyFragment ||
                fragment instanceof VanBanCacPhongChuyenLaiFragment || fragment instanceof VanBanChuTriChoXuLyChuyenVienFragment ||
                fragment instanceof VanBanChuTriChoXuLyPhoPhongFragment || fragment instanceof VanBanChuTriDaChiDaoFragment ||
                fragment instanceof VanBanDaChiDaoChuaHoanThanhFragment || fragment instanceof VanBanDaChiDaoSTCPhoiHopFragment ||
                fragment instanceof VanBanDaPhanLoaiFragment || fragment instanceof VanBanGiaoPhongChuChiChoXuLyFragment ||
                fragment instanceof VanBanGiaoPhongChuTriChoXuLyFragment || fragment instanceof VanBanGiaoPhongPhoiHopChoXuLyFragment ||
                fragment instanceof VanBanNguoiDungPhoiHopXuLyFragment || fragment instanceof VanBanNguoiDungXuLyFragment ||
                fragment instanceof VanBanPhoiHopChoXuLyChuyenVienFragment || fragment instanceof VanBanPhoiHopChoXuLyFragment ||
                fragment instanceof VanBanPhoiHopDaChiDaoFragment || fragment instanceof VanBanPhoiHopTraLaiFragment ||
                fragment instanceof VanBanPhongChuTriChoXuLyFragment || fragment instanceof VanBanPhongChuTriDaChiDaoFragment ||
                fragment instanceof VanBanPhoPhongBietDeDonDocFragment || fragment instanceof VanBanPhoPhongPhoiHopChoXuLyFragment ||
                fragment instanceof VanBanSTCPhoiHopDaChiDaoFragment || fragment instanceof VB_CongTacDangChoXuLyFragment ||
                fragment instanceof XulyVanBanFragment) {
            tvTieuDe.setText("XỬ LÝ VĂN BẢN");
            PrefUtil.saveString(this,Key.TITLE,"XỬ LÝ VĂN BẢN");
        }
        if (fragment instanceof BaoCaoCuocHopChoPheDuyetFragment || fragment instanceof BaoCaoKetQuaCuocHopDaGuiDiFragment ||
                fragment instanceof BaoCaoKetQuaCuocHopDaXemFragment || fragment instanceof BaoCaoKetQuaCuocHopMoiFragment ||
                fragment instanceof DSGiayMoiDenCuaSoFragment || fragment instanceof GiayMoiChoLanhDaoXuLyFragment ||
                fragment instanceof GiayMoiChoPhanLoaiFragment || fragment instanceof GiayMoiChoXuLyFragment ||
                fragment instanceof GiayMoiChuTriChoXuLyFragment || fragment instanceof GiayMoiDaChiDaoFragment ||
                fragment instanceof GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetFragment || fragment instanceof GiayMoiDaPhanLoaiFragment ||
                fragment instanceof GiayMoiDaXuLyCCFragment || fragment instanceof GiayMoiDaXulyFragment ||
                fragment instanceof GiayMoiGiaoChuTriChoXuLyFragment || fragment instanceof GiayMoiGiaoPhoiHopChoXuLyFragment ||
                fragment instanceof GiayMoiGiaoPhongChuTriDaChiDaoFragment || fragment instanceof GiayMoiGiaoPhongChuTriDaHoanThanhFragment ||
                fragment instanceof GiayMoiGiaoPhongPhoiHopDaChiDaoFragment || fragment instanceof GiayMoiLanhDaoDaChiDaoFragment ||
                fragment instanceof GiayMoiPhoiHopChoXuLyFragment || fragment instanceof GiayMoiPhoiHopDaChiDaoFragment ||
                fragment instanceof GiayMoiPhoiHopDaXuLyTPCCFragment || fragment instanceof GiayMoiPhoiHopTraLaiFragment ||
                fragment instanceof GiayMoiPhongChuTriChoXuLyFragment || fragment instanceof GiayMoiPhongPhoiHopChoXuLyFragment ||
                fragment instanceof GiayMoiPhoPhongPhoiHopChoXuLyFragment || fragment instanceof GiayMoiXemDeBietFragment ||
                fragment instanceof XemLichCongTacFragment || fragment instanceof XuLyGiayMoiFragment) {
            tvTieuDe.setText("XỬ LÝ GIẤY MỜI");
            PrefUtil.saveString(this,Key.TITLE,"XỬ LÝ GIẤY MỜI");
        }
        if (fragment instanceof VanBanDonViCapHaiFragment || fragment instanceof DanhSachVanBanPhongChuTriLV3Fragment ||
                fragment instanceof DanhSachVanBanPhongPhoiHopLV3Fragment || fragment instanceof DanhSachVanBanTongTheFragment ||
                fragment instanceof VanBanChoChiDaoLV1Fragment || fragment instanceof VanBanChoChiDaoLV2Fragment ||
                fragment instanceof VanBanChoDuyetLV3Fragment || fragment instanceof VanBanChoXuLyVBChuTriLV5Fragment ||
                fragment instanceof VanBanChoXuLyVBPhoiHopLV3Fragment || fragment instanceof VanBanChoXuLyVBPhoiHopLV4Fragment ||
                fragment instanceof VanBanChoXuLyVBPhoiHopLV5Fragment || fragment instanceof VanBanDaChiDaoPhongChuaXuLyFragment ||
                fragment instanceof VanBanDaChiDaoPhongChuaXuLyLV2Fragment || fragment instanceof VanBanDaXuLyVBChuTriChuaKetThucLV3Fragment ||
                fragment instanceof VanBanPhoiHopDaXuLyLV4Fragment || fragment instanceof VanBanPhoiHopChoXuLyLV5Fragment ||
                fragment instanceof VanBanPhoiHopChoXuLyLV4Fragment || fragment instanceof VanBanDaXuLyVBPhoiHopLV5Fragment ||
                fragment instanceof VanBanDaXuLyVBPhoiHopChuaKetThucLV4Fragment || fragment instanceof VanBanDaXuLyVBPhoiHopChuaKetThucLV3Fragment ||
                fragment instanceof VanBanDaXuLyVBChuTriLV5Fragment || fragment instanceof VanBanDaXuLyVBChuTriChuaKetThucLV4Fragment ||
                fragment instanceof VanBanPhoiHopDaXuLyLV5Fragment || fragment instanceof VanBanChoXuLyVBChuTriLV4Fragment ||
                fragment instanceof VanBanChoXuLyVBChuTriLV3Fragment) {
            tvTieuDe.setText("VĂN BẢN ĐƠN VỊ CẤP HAI");
            PrefUtil.saveString(this,Key.TITLE,"VĂN BẢN ĐƠN VỊ CẤP HAI");
        }
        if (fragment instanceof VanBanDiDonViCapHaiFragment || fragment instanceof DanhSachVanBanChoSoFragment ||
                fragment instanceof DanhSachVanBanCuaPhongLV3Fragment || fragment instanceof DanhSachVanBanDiFragment) {
            tvTieuDe.setText("VĂN BẢN ĐI ĐƠN VỊ CẤP HAI");
            PrefUtil.saveString(this,Key.TITLE,"VĂN BẢN ĐI ĐƠN VỊ CẤP HAI");
        }
        if (fragment instanceof VanBanDenFragment || fragment instanceof DanhSachCongTacDangFragment ||
                fragment instanceof DanhSachTongTheFragment || fragment instanceof DanhSachGiayMoiFragment ||
                fragment instanceof VanBanSTCChuTriFragment || fragment instanceof ThongKeVBTheoLDChiDaoFragment ||
                fragment instanceof ThongKeVanBanTheoPhongFragment || fragment instanceof ThongKeVanBanTheoPGDFragment ||
                fragment instanceof BaoCaoTongHopFragment || fragment instanceof InSoLuuTruVanBanDenFragment ||
                fragment instanceof ThongKeVanBanTheoPhoGiamDocFragment) {
            tvTieuDe.setText("VĂN BẢN ĐẾN");
            PrefUtil.saveString(this,Key.TITLE,"VĂN BẢN ĐẾN");
            drawerLayout.closeDrawers();
        }
        if (fragment instanceof VanBanTrinhKyFragment || fragment instanceof VanBanDaTrinhKyFragment ||
                fragment instanceof VanBanXemDeBietFragment || fragment instanceof LichHopCuaSoChuTriFragment ||
                fragment instanceof DanhSachVanBanCuaSoFragment || fragment instanceof DanhSachGiayMoiCuaSoFragment ||
                fragment instanceof DanhSachVBSoThamMuuTrinhTPFragment || fragment instanceof DanhSachVanBanChoSoCuaSoFragment ||
                fragment instanceof InSoLuuTruVanBanDiFragment || fragment instanceof VanBanChuTriChoXuLyFragment ||
                fragment instanceof VanBanChuTriDaXuLyFragment || fragment instanceof DanhSachVanBanCuaPhongFragment ||
                fragment instanceof DanhSachGiayMoiCuaPhongFragment || fragment instanceof VanBanDiFragment ||
                fragment instanceof VanBanChuTriDaXuLyCCFragment || fragment instanceof VanBanChuTriChoXuLyCCFragment) {
            drawerLayout.closeDrawers();
            tvTieuDe.setText("VĂN BẢN ĐI");
            PrefUtil.saveString(this,Key.TITLE,"VĂN BẢN ĐI");
        }
        if (fragment instanceof DauViecPhongPhoiHopChoXuLyCVPHFragment || fragment instanceof DauViecPhongPhoiHopDaXuLyFragment ||
                fragment instanceof DauViecChuyenVienXuLyFragment || fragment instanceof DauViecHoanThanhBiTraLaiFragment ||
                fragment instanceof DauViecPhongPhoiHopDaXuLyPhoPhongPhoiHopFragment || fragment instanceof DauViecPhongChuTriDaXuLyPhoPhongPhoiHopFragment ||
                fragment instanceof DauViecPhongChuTriDaXuLyFragment || fragment instanceof DauViecPhongPhoiHopChoXuLyPhoPhongPhoiHopFragment ||
                fragment instanceof DauViecPhongChuTriChoXuLyPhoPhongPhoiHopFragment || fragment instanceof DauViecHoanThanhChoLanhDaoPhongDuyetFragment ||
                fragment instanceof DanhSachDauViecPhongPhoiHopFragment || fragment instanceof DanhSachDauViecPhongChuTriFragment ||
                fragment instanceof DauViecPhongPhoiHopDaChiDaoChuaHTFragment || fragment instanceof DauViecPhongChuTriDaChiDaoChuaHTFragment ||
                fragment instanceof DauViecPhongPhoiHopChoXuLyFragment || fragment instanceof DauViecPhongPhoiHopChoXuLyChuyenVienFragment ||
                fragment instanceof DauViecPhongChuTriChoXuLyFragment || fragment instanceof DauViecPhongChuTriChuyenVienChoXuLyFragment ||
                fragment instanceof DanhSachDauViecQuaHanCuaPhongFragment || fragment instanceof DanhSachDauViecDeXuatGiaHanDaXuLyFragment ||
                fragment instanceof DanhSachDauViecDeXuatGiaHanDaXuLyChuyenVienFragment || fragment instanceof DanhSachDauViecDeXuatGiaHanFragment ||
                fragment instanceof DanhSachDauViecDeXuatGiaHanChuyenVienFragment || fragment instanceof DSTaiLieuHopHDNDCuaTongHopFragment ||
                fragment instanceof DanhSachDauViecCuaSoFragment || fragment instanceof DSKienNghiHDNDFragment ||
                fragment instanceof DauViecDaXuLyFragment || fragment instanceof DSTaiLieuHopHDNDCuaPhongFragment ||
                fragment instanceof DauViecChoXuLyFragment || fragment instanceof QuanLyDauViecFragment ||
                fragment instanceof DanhSachDauViecDaChiDaoTruongPhongPhoiHopTPCCFragment || fragment instanceof DSDauViecPhongPhoiHopDaXuLyCCFragment ||
                fragment instanceof DSDauViecPhongChuTriDaXuLyCCFragment || fragment instanceof DauViecTruongPhongPhoiHopPhongCTTPCCFragment ||
                fragment instanceof DanhSachPhongChuTriDaChiDaoChuaHTTPCCFragment || fragment instanceof DanhSachPhongPhoiHopDaChiDaoTPCCFragment ||
                fragment instanceof DauViecPhongChuTriChoXuLyCCFragment || fragment instanceof DauViecPhongChuTriChoXuLyTPCCFragment ||
                fragment instanceof DauViecPhongPhoiHopChoXuLyCCFragment || fragment instanceof DauViecPhongPhoiHopChoXuLyTPCCFragment) {
            drawerLayout.closeDrawers();
            tvTieuDe.setText("QUẢN LÝ ĐẦU VIỆC");
            PrefUtil.saveString(this,Key.TITLE,"QUẢN LÝ ĐẦU VIỆC");
        }
        if (fragment instanceof QuanLyCanBoFragment || fragment instanceof DanhGiaChamDiemPhanLoaiPGDTruongPhongFragment ||
                fragment instanceof DanhGiaPheDuyetKetQuaPhanLoaiThangCuaSoFragment || fragment instanceof GDSoTuNhanXetDanhGiaKetQuaThangFragment ||
                fragment instanceof NhanXetChamDiemCongViecTuanCuaCapDuoiFragment || fragment instanceof PhanLoaiCongChucCuaPhongTheoThangFragment ||
                fragment instanceof ThongKeKetQuaCongTacThangTrongToanSoFragment || fragment instanceof XemKeHoachKetQuaCongTacTuanCuaCacPhongFragment ||
                fragment instanceof XemKeHoachKetQuaCongTacThangCuaCacPhongFragment || fragment instanceof ThongKeKetQuaCongTacTuanTrongToanSoFragment) {
            tvTieuDe.setText("QUẢN LÝ CÁN BỘ");
            PrefUtil.saveString(this,Key.TITLE,"VĂN BẢN ĐI");
        }
        if (fragment instanceof TraoDoiThongTinNoiBoFragment || fragment instanceof ThongTinDaGuiDiFragment ||
                fragment instanceof ThongTinDaXemFragment || fragment instanceof ThongTinMoiFragment) {
            tvTieuDe.setText("TRAO ĐỔI THÔNG TIN NỘI BỘ");
            PrefUtil.saveString(this,Key.TITLE,"TRAO ĐỔI THÔNG TIN NỘI BỘ");
        }
    }

    @Override
    public void onBackPressed() {
        try {
            if (MainActivity.class.getSimpleName().equals("MainActivity")) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClickNamLamViec(Integer integer) {
        Util.checkConnection(this);
        btnNamLamViecTrangChu.setText("Năm làm việc: " + integer + "   ");
        PrefUtil.saveString(this, Key.NAM_LAM_VIEC, String.valueOf(integer));
        getPresenter().getMenu(String.valueOf(integer), "", String.valueOf(false));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClick(Contact contact) {
        if (!click) {
            switch (contact.getKey()) {
                case Key.XLVB:
                    XulyVanBanFragment xulyVanBanFragment = new XulyVanBanFragment();
                    Bundle bundle7 = new Bundle();
                    bundle7.putString("key2", key2);
                    xulyVanBanFragment.setArguments(bundle7);
                    replaceFragment(xulyVanBanFragment, R.id.fl);
                    click = true;
                    break;
                case Key.XLGM:
                    XuLyGiayMoiFragment xuLyGiayMoiFragment = new XuLyGiayMoiFragment();
                    Bundle bundle6 = new Bundle();
                    bundle6.putString("key2", key2);
                    xuLyGiayMoiFragment.setArguments(bundle6);
                    replaceFragment(xuLyGiayMoiFragment, R.id.fl);
                    click = true;
                    break;
                case Key.VBDen:
                    VanBanDenFragment vanBanDenFragment = new VanBanDenFragment();
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("key2", key2);
                    vanBanDenFragment.setArguments(bundle5);
                    replaceFragment(vanBanDenFragment, R.id.fl);
                    click = true;
                    break;
                case Key.VBDi:
                    VanBanDiFragment vanBanDiFragment = new VanBanDiFragment();
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("key2", key2);
                    vanBanDiFragment.setArguments(bundle4);
                    replaceFragment(vanBanDiFragment, R.id.fl);
                    click = true;
                    break;
                case Key.TDTTNB:
                    TraoDoiThongTinNoiBoFragment traoDoiThongTinNoiBoFragment = new TraoDoiThongTinNoiBoFragment();
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("key2", key2);
                    traoDoiThongTinNoiBoFragment.setArguments(bundle3);
                    replaceFragment(traoDoiThongTinNoiBoFragment, R.id.fl);
                    click = true;
                    break;
                case Key.QLDV:
                    QuanLyDauViecFragment quanLyDauViecFragment = new QuanLyDauViecFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key2", key2);
                    quanLyDauViecFragment.setArguments(bundle2);
                    replaceFragment(quanLyDauViecFragment, R.id.fl);
                    click = true;
                    break;
                case Key.QLCB:
                    QuanLyCanBoFragment quanLyCanBoFragment = new QuanLyCanBoFragment();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("key2", key2);
                    quanLyCanBoFragment.setArguments(bundle1);
                    replaceFragment(quanLyCanBoFragment, R.id.fl);
                    click = true;
                    break;
                case Key.vanBanDonViCapHai:
                    VanBanDonViCapHaiFragment vanBanDonViCapHaiFragment = new VanBanDonViCapHaiFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("key2", key2);
                    vanBanDonViCapHaiFragment.setArguments(bundle);
                    replaceFragment(vanBanDonViCapHaiFragment, R.id.fl);
                    click = true;
                    break;
                case Key.vanBanDiDonViCapHai:
                    VanBanDiDonViCapHaiFragment vanBanDiDonViCapHaiFragment = new VanBanDiDonViCapHaiFragment();
                    Bundle bundle9 = new Bundle();
                    bundle9.putString("key2", key2);
                    vanBanDiDonViCapHaiFragment.setArguments(bundle9);
                    replaceFragment(vanBanDiDonViCapHaiFragment, R.id.fl);
                    click = true;
                    break;
            }
        }
    }
}
