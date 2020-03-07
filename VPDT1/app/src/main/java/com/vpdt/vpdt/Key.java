package com.vpdt.vpdt;

import java.util.Locale;

public interface Key {

    String APP_PREFERENCE = "app_preference";
    Locale LOCALE_VN = new Locale("vi", "VN");
    String DATA_USER = "dataUser";
    String TOKEN = "token";
    String TOKEN_FIRE = "token_fire";
    String TITLE = "TITLE";

    int CHANH_VP = 3;
    int GIAMDOC = 4;
    int PHO_GIAMDOC = 5;
    int TRUONG_PHONG = 6;
    int PHO_PHONG = 7;
    int CHUYEN_VIEN = 8;
    int CHI_CUC_PHO = 10;
    int TRUONG_PHONG_TCDN = 11;

    String LEVEL = "LEVEl_ACCOUNT";
    String Refresh_token = "refresh_token";

    //key trang chu
    String NAM_LAM_VIEC = "2019";
    String TU_NGAY = "05/03/1997";
    String DEN_NGAY = "09/03/1997";
    String XLVB = "XLVB";
    String XLGM = "XLGM";
    String VBDen = "VBDen";
    String VBDi = "VBDi";
    String TDTTNB = "TDTTNB";
    String QLDV = "QLDV";
    String QLCB = "QLCB";
    String VBDiLeft = "VBDiLeft";
    String QLDVLeft = "QLDVLeft";
    String vanBanDiDonViCapHai = "vanBanDiDonViCapHai";
    String vanBanDonViCapHai = "vanBanDonViCapHai";

    //xử lý văn bản
    String dSVB_QuaHanDoLanhDaoChiDao = "dSVBQuaHanDoLanhDaoChiDao";
    String dSVB_DenChoXuLy = "dSVBDenChoXuLy";
    String dSVB_CongTacDangChoXuLy = "dSVBCongTacDangChoXuLy";
    String dSVB_LanhDaoDaChiDao = "dSVBLanhDaoDaChiDao";
    String duyet_DSVB_GiaHanGiaiQuyet = "duyetDSVBGiaHanGiaQuyet";
    String tong_SoLuongToCongTacGiaoPhongXuLy = "tongSoLuongToCongTacGiaoPhongXuLy";
    String tong_SoLuongDonThuKNTCGiaoPhongXuLy = "toSoLuongDonThuKNTCGiaoPhongXuLy";
    String dSVB_QuanTrongCuaSo = "dSVBQuanTrongCuaSo";
    String dSVB_TheoPhong = "dSVBTheoPhong";
    String dSVB_XemDeBiet = "dSVBXemDeBiet";
    String dSVB_BietdedonDoc = "dSVBBietDeDonDoc";
    String dSVB_QuaHanCuaPhong = "dSVBQuaHanCuaPhong";
    String dSVB_GiaoPhongChoXuly = "dSVBGiaoPhongChuTriChoXuLy";
    String dSVB_GiaoPhongPhoiHopChoXuly = "dSVBGiaoPhongPhoiHopChoXuLy";
    String dSVB_PhongChuTriDaChiDao = "dSVBPhongChuTriDaChiDao";
    String dSVB_PhoiHopDaChidao = "dsVBPhoiHopDaChiDao";
    String dSVB_PhoiHopTraLai = "dSVBPhoiHopTraLai";
    String dSVB_DaDeXuatGiaHanGiaiQuyet = "dSVBDaDeXuatGiaHanGiaiQuyet";
    String dXCongViecPhoiHopChoDuyet = "dXCongViecPhoiHopChoDuyet";
    String dSVB_STCPhoiHopDaChiDao = "dSVBSTCPhoiHopDaChiDao";
    String cVPhoiHopChoXuLy = "cVPhoiHopChoXuLy";
    String dSVB_DaHoanThanhChoLDPhongPheDuyet = "dSVBDaHoanThanhChoLDPhongPheDuyet";
    String tSVanBanGiaoPhongPhoiHop = "tSVanBanGiaoPhongPhoiHop";
    String tSVanBanGiaoPhongChuTri = "tSVanBanGiaoPhongChuTri";
    String danhSachVanBanQuahanPhoPhong = "danhSachVanBanQuahan";
    String vanBanChuTrichoXuLyPhoPhong = "vanBanChuTrichoXuLy";
    String vanBanPhoPhongPhoiHopChoXuLyPhoPhong = "vanBanPhoPhongPhoiHopChoXuLy";
    String vanBanPhoPhongPhoiHopDeDonDocPhoPhong = "vanBanPhoPhongPhoiHopDeDonDoc";
    String vanBanPhoiHopChoXuLyPhoPhong = "vanBanPhoiHopChoXuLy";
    String vanBanChuTriDaChiDaoPhoPhong = "vanBanChuTriDaChiDao";
    String vanBanPhoiHopDaChiDaoPhoPhong = "vanBanPhoiHopDaChiDao";
    String vanBanNguoiDungXuLyPhoPhong = "vanBanNguoiDungXuLy";
    String vanBanNguoiDungPhoiHopXuLyPhoPhong = "vanBanNguoiDungPhoiHopXuLy";
    String vBHoanThanhChoPheDuyetCV = "vBHoanThanhChoPheDuyetCV";
    String vBHoanThanhDaPheDuyetCV = "vBHoanThanhDaPheDuyetCV";
    String phanLoaiVanBan = "phanLoaiVanBan";
    String vanBanDaPhanLoai = "vanBanDaPhanLoai";
    String vanBanCacPhongChuyenLai = "vanBanCacPhongChuyenLai";
    String phanLoaiVanBanCTD = "phanLoaiVanBanCTD";
    String vanBanPhongChuTriChoXuLyCC = "vanBanPhongChuTriChoXuLyCC";
    String vanBanDaChiDaoChuaHoanThanhCC = "vanBanDaChiDaoChuaHoanThanhCC";
    String soLuongVBGiaoChiCucPhoChuTri = "soLuongVBGiaoChiCucPhoChuTri";
    String vanBanDaChiDaoSTCPhoiHopCC = "vanBanDaChiDaoSTCPhoiHopCC";
    String tongSoLuongVanBanGiaoPhongCapHaiChuTri = "tongSoLuongVanBanGiaoPhongCapHaiChuTri";
    String deXuatCongViecPhoiHopChoDuyetCC = "deXuatCongViecPhoiHopChoDuyetCC";
    String congViecPhoiHopChoXuLyCC = "congViecPhoiHopChoXuLyCC";

    //xử lý giay mời
    String GiayMoiChoLanhDaoXL = "giayMoiChoLanhDaoXuLy";
    String GiayMoiLDChiDao = "giayMoiLanhDaoDaChiDao";
    String XemLichCongTac = "xemLichCongTac";
    String DanhSach_GiayMoiDen_CS = "danhSachGiayMoiDenCuaSo";
    String BC_KetQuaCuocHopMoi = "baoCaoKetQuaCuocHopMoi";
    String BC_KetQuaCuocHopDaXem = "baoCaoKetQuaCuocHopDaXem";
    String BC_KetQuaCuocHopDaGuiDi = "baoCaoKetQuaCuocHopDaGuiDi";
    String GiayMoi_XemDeBiet = "danhSachGiayMoiXemDeBiet";
    String dSGMPhongChuTriXuLy = "dSGMPhongChuTriXuLy";
    String dSGMGiaoPhongChuTriDaChiDao = "dSGMGiaoPhongChuTriDaChiDao";
    String sDGiayMoiPhongPhoiHopChoXuLy = "sDGiayMoiPhongPhoiHopChoXuLy";
    String dSGiayMoiGiaoPhongPhoiHopDaChiDao = "dSGiayMoiGiaoPhongPhoiHopDaChiDao";
    String gMDaHTChoLDPhongPD = "GMDaHoanThanhChoLDPhongPheDuyet";
    String gMPhoiHopTL = "GMPhoiHopTraLai";
    String sDGiayMoiGiaoPhongChuTriDaHoanThanh = "sDGiayMoiGiaoPhongChuTriDaHoanThanh";
    String bCCuocHopChoPD = "baoCaoCuocHopChoPheDuyet";
    String giayMoiChuTriChoXuLy = "giayMoiChuTriChoXuLy";
    String giayMoiPhoPhongPhoiHopChoXuLy = "giayMoiPhoPhongPhoiHopChoXuLy";
    String giayMoiPhoiHopChoXuLy = "giayMoiPhoiHopChoXuLy";
    String giayMoiDaChiDao = "giayMoiDaChiDao";
    String giayMoiPhoiHopDaChiDao = "giayMoiPhoiHopDaChiDao";
    String xemLichCongTacCuaPhong = "xemLichCongTacCuaPhong";
    String giayMoiDaGiaiQuyet = "giayMoiDaGiaiQuyet";
    String giayMoiChoPhanLoai = "giayMoiChoPhanLoai";
    String giayMoiDaPhanLoai = "giayMoiDaPhanLoai";
    String xemLichCongTacLanhDaoSo = "xemLichCongTacLanhDaoSo";
    String giayMoiChoXuLyCC = "giayMoiChoXuLyCC";
    String giayMoiDaXuLyCC = "giayMoiDaXuLyCC";
    String giayMoiPhoiHopDaXuLyCC = "giayMoiPhoiHopDaXuLyCC";


    //van ban đi
    String VB_TrinhKy = "vanBanTrinhKy";
    String VB_XemDeBiet = "vanBanXemDeBiet";
    String LichHop_CuaSoCT = "lichHopCuaSoChuTri";
    String DS_VB_CUA_SO = "danhSachVanBanCuaSo";
    String DS_GMOI_CUA_SO = "danhSachGiayMoiCuaSo";
    String DS_VB_SO_THAM_MUU_TRINH_THANH_PHO = "danhSachVanBanSoThamMuuTrinhTP";
    String DS_VB_CHO_SO_CUA_SO = "danhSachVanBanChoSoCuaSo";
    String IN_SO_LUU_TRU = "inSoLuuTru";
    String vBCT_Cho_XL = "vanBanChuTriChoXuLy";
    String vBCT_Da_XL = "vanBanChuTriDaXuLy";
    String dSVB_cuaPhong = "danhSachVanBanCuaPhong";
    String dSGM_cuaPhong = "danhSachGiayMoiCuaPhong";
    String NVBDi = "nhapVanBanDi";
    String vBDaTrinhKy = "vBDaTrinhKy";
    String vanBanChuTriChoXuLyCC = "vanBanChuTriChoXuLyCC";
    String vanBanChuTriDaXuLyCC = "vanBanChuTriDaXuLyCC";

    //trao đổi thông tin nội bộ
    String ThongTin_Moi = "thongTinMoi";
    String TT_DaGuiDi = "thongTinDaGuiDi";
    String TT_DaXem = "thongTinDaXem";
    String SoanThao_ThongTin = "soanThaoThongTin";

    //quản lý đầu việc
    String DV_ChoXuLy = "dauViecChoXuLy";
    String DS_TaiLieuHop_HDND_CuaPhong = "danhSachTaiLieuHopHDNDCuaPhong";
    String DV_DaXuLy = "dauViecDaXuLyChuaHoanThanh";
    String DS_KienNghi_HDND = "danhSachKienNghiHDND";
    String DS_DauViec_CuaSo = "danhSachDauViecCuaSo";
    String DS_TaiLieuHop_HDND_CuaTongHop = "danhSachTaiLieuHopHDNDCuaTongHop";
    String DS_DauViec_DeXuatGiaHan = "dSDVDeXuatGiaHan";
    String DS_DauViec_DeXuatGiaHanDaXuLy = "dSDVDeXuatGiahanDaXuLy";
    String dSDaiViecQuaHanCuaPhong = "dSDaiViecQuaHanCuaPhong";
    String dauViecPhongChuTriChoXuLy = "dauViecPhongChuTriChoXuLy";
    String dauViecPhongPhoiHopChoXuLy = "dauViecPhongPhoiHopChoXuLy";
    String dauViecPhongChuTriDaChiDaoChuaHoanThanh = "dauViecPhongChuTriDaChiDaoChuaHoanThanh";
    String dauViecPhongPhoiHopDaChiDaoChuaHoanThanh = "dauViecPhongPhoiHopDaChiDaoChuaHoanThanh";
    String dSDauViecPhongChuTri = "dSDauViecPhongChuTri";
    String dSDauViecPhongPhoiHop = "dSDauViecPhongPhoiHop";
    String dSDauViecHoanThanhChoLDPhongDuyet = "dSDauViecHoanThanhChoLDPhongDuyet";
    String dViecPhongChuTriChoXuLyPhoPhongPH = "dViecPhongChuTriChoXuLyPhoPhongPH";
    String dViecPhongPhoiHopChoXuLyPhoPhongPH = "dViecPhongPhoiHopChoXuLyPhoPhongPH";
    String dauViecPhongChuTriDaXuLy = "dauViecPhongChuTriDaXuLy";
    String dauViecPhongPhoiHopDaXuLy = "dauViecPhongPhoiHopDaXuLy";
    String dViecPhongChuTriDaXuLyPhoPhongPH = "dViecPhongChuTriDaXuLyPhoPhongPH";
    String dViecPhongPhoiHopDaXuLyPhoPhongPH = "dViecPhongPhoiHopDaXuLyPhoPhongPH";
    String dauViecBiTraLai = "dauViecBiTraLai";
    String dauViecChuyenVienPhoiHopPhongCT = "dauViecChuyenVienPhoiHopPhongCT";
    String dauViecPhongPhoiHopChoXuLyCVPP = "dauViecPhongPhoiHopChoXuLyCVPP";
    String dauViecPhongChuTriChoXuLyCC = "dauViecPhongChuTriChoXuLyCC";
    String dauViecPhongPhoiHopChoXuLyCC = "dauViecPhongPhoiHopChoXuLyCC";
    String dSDauViecPhongChuTriDaXuLyCC = "dSDauViecPhongChuTriDaXuLyCC";
    String dSDauViecPhongPhoiHopDaXuLyCC = "dSDauViecPhongPhoiHopDaXuLyCC";
    String dauViecPhongChuTriChoXuLyTPCC = "dauViecPhongChuTriChoXuLyTPCC";
    String dauViecPhongPhoiHopChoXuLyTPCC = "dauViecPhongPhoiHopChoXuLyTPCC";
    String dauViecTruongPhongPhoiHopPhongCT = "dauViecTruongPhongPhoiHopPhongCT";
    String dsPhongChuTriDaChiDaoChuaHoanThanhCC = "dsPhongChuTriDaChiDaoChuaHoanThanhCC";
    String dSPhongPhoiHopDaChiDaoCC = "dSPhongPhoiHopDaChiDaoCC";
    String dSDauViecDaChiDaoTruongPhongPPCC = "dSDauViecDaChiDaoTruongPhongPPCC";

    // QUAN LY CAN BO
    String GĐ_soTuNhanXet = "GDSoTuNhanXetDanhGiaKetQuaThang";
    String XemKeHoachKetQua = "xemKetHoachKetQuaCongTacTuanCuaCacPhong";
    String XemKetQuaPhanLoai = "xemKetQuaPhanLoaiThangCuaCacPhong";
    String DanhGiaChamDiem = "danhGiaChamDiemPhanLoaiPGDTruongPhong";
    String ThongKeKetQuaCongTacTuan = "thongKeKetQuaCongTacTuanTrongToanSo";
    String ThongKeKetQuaCongTacThang = "thongKeKetQuaCongTacThangTrongToanSo";
    String danhGiaPheDuyetKetQuaPhanLoaiThangCuaSo = "danhGiaPheDuyetKetQuaPhanLoaiThangCuaSo";
    String dGKH_DG_CVtuan = "duyetGiaoKHDanhGiaCongViecTuanCuaCapDuoi";
    String nX_CD_Cvtuan = "nhanXetChamDiemCongViecTuanCuaCapDuoi";
    String pLCVCPhongThang = "phanLoaiCongChucCuaPHongTheoThang";
    String tPTDG_CDThang = "truongPhongTuDanhGiaChamDiemThangCuaCaNhan";
    String PGDS_NXTHKQT_CGDS = "PGDSoNhanXetThucHienKetQuaThangCuaGDSo";
    String PDG_TCDTCCN = "phoGiamdocTuChamDiemThangCuaCaNhan";
    String nhapGiaoNhanXetKeHoachKetQuaCongTacTuan = "nhapGiaoNhanXetKeHoachKetQuaCongTacTuan";
    String tuDanhGiaKetQuaCongTacTuanCuaCaNhan = "tuDanhGiaKetQuaCongTacTuanCuaCaNhan";
    String tuDanhGiaKetQuaCongTacThangCuaCaNhan = "tuDanhGiaKetQuaCongTacThangCuaCaNhan";
    String xemNhanXetKetQuaCongTacTuanCuaChuyenVien = "xemNhanXetKetQuaCongTacTuanCuaChuyenVien";
    String xemKetQuaPhanLoaiThangCuaPhong = "xemKetQuaPhanLoaiThangCuaPhong";
    String PGDNhanXetThangDoiVoiCacPGDVaTruongPhong = "PGDNhanXetThangDoiVoiCacPGDVaTruongPhong";
    String XemKetQuaPhanLoaiCuaCacTruongPhong = "XemKetQuaPhanLoaiCuaCacTruongPhong";
    String XemKetQuaCongTacTuanCuaCacPhongTrongSo = "XemKetQuaCongTacTuanCuaCacPhongTrongSo";


    // van ban den
    String DANH_SACH_CONG_TAC_DANG = "danhSachCongTacDang";
    String DANH_SACH_TONG_THE = "danhSachTongThe";
    String DANH_SACH_GIAY_MOI = "danhSachGiayMoi";
    String VAN_BAN_STC_CHU_TRI = "vanBanSTCChuTri";
    String THONG_KE_VB_THEO_LANH_DAO_CHI_DA0 = "thongKeVBTheoLDChiDao";
    String THONG_KE_VB_THEO_PHONG = "thongKeVBTheoPhong";
    String THONG_KE_VB_THEO_PHO_GIAM_DOC = "thongKeVBTheoPhoGiamDoc";
    String THONG_KE_VB_THEO_LOAI_NOI_DEN = "thongKeVBTheoLoaiNoiDen";
    String BAO_CAO_TONG_HOP = "baoCaoTongHop";
    String IN_SO_LUU_TRU_IN_LICH = "inSoLuuTruLich";

    //Van ban don vi cap hai
    String danhSachVanBanTongThe = "danhSachVanBanTongThe";
    String vanBanChoChiDaoDonViCapHai = "vanBanChoChiDaoDonViCapHai";
    String vanBanDaChiDaoPhongChuaXuLyDonViCapHai = "vanBanDaChiDaoPhongChuaXuLyDonViCapHai";
    String vanBanChoXuLyVBTPChuTriDonViCapHai = "vanBanChoXuLyVBTPChuTriDonViCapHai";
    String vanBanChoXuLyVBTPPhoiHopDonViCapHai = "vanBanChoXuLyVBTPPhoiHopDonViCapHai";
    String vanBanDaXuLyVBTPchuTriChuaKetThucDonViCapHai = "vanBanDaXuLyVBTPchuTriChuaKetThucDonViCapHai";
    String vanBanDaXuLyVBTPPhoiHopChuKetThucDonViCapHai = "vanBanDaXuLyVBTPPhoiHopChuKetThucDonViCapHai";
    String vanBanChoDuyetDonViCapHai = "vanBanChoDuyetDonViCapHai";
    String danhSachVanBanPhongChuTriDonViCapHai = "danhSachVanBanPhongChuTriDonViCapHai";
    String danhSachVanBanPhongPhoiHopDonViCapHai = "danhSachVanBanPhongPhoiHopDonViCapHai";
    String vanBanChoXuLyVBPPChuTriDonViCapHai = "vanBanChoXuLyVBPPChuTriDonViCapHai";
    String vanBanChoXuLyVBPPPhoiHopDonViCapHai = "vanBanChoXuLyVBPPPhoiHopDonViCapHai";
    String vanBanPhoiHopChoXuLyPPDonViCapHai = "vanBanPhoiHopChoXuLyPPDonViCapHai";
    String vanBanDaXuLyVBPPchuTriChuaKetThucDonViCapHai = "vanBanDaXuLyVBPPchuTriChuaKetThucDonViCapHai";
    String vanBanDaXuLyVBPPPhoiHopChuKetThucDonViCapHai = "vanBanDaXuLyVBPPPhoiHopChuKetThucDonViCapHai";
    String vanBanPhoiHopDaXuLyPPDonViCapHai = "vanBanPhoiHopDaXuLyPPDonViCapHai";
    String vanBanChoXuLyVBCVChuTriDonViCapHai = "vanBanChoXuLyVBCVChuTriDonViCapHai";
    String vanBanChoXuLyVBCVPhoiHopDonViCapHai = "vanBanChoXuLyVBCVPhoiHopDonViCapHai";
    String vanBanPhoiHopChoXuLyCVDonViCapHai = "vanBanPhoiHopChoXuLyCVDonViCapHai";
    String vanBanDaXuLyVBCVChuTriChuaKetThucDonViCapHai = "vanBanDaXuLyVBCVChuTriChuaKetThucDonViCapHai";
    String vanBanDaXuLyVBCVPhoiHopChuKetThucDonViCapHai = "vanBanDaXuLyVBCVPhoiHopChuKetThucDonViCapHai";
    String vanBanPhoiHopDaXuLyCVDonViCapHai = "vanBanPhoiHopDaXuLyCVDonViCapHai";
    String vanBanChoChiDaoDonViCapHaiPhong = "vanBanChoChiDaoDonViCapHaiPhong";
    String vanBanDaChiDaoPhongChuaXuLyDonViCapHaiPhong = "vanBanDaChiDaoPhongChuaXuLyDonViCapHaiPhong";

    //Van ban di don vi cap hai
    String danhSachVanBanDiDonViCapHai = "danhSachVanBanDiDonViCapHai";
    String danhSachVanBanChoSo = "danhSachVanBanChoSo";
    String NhapMoiVanBanDiDonViCapHai = "NhapMoiVanBanDiDonViCapHai";
    String danhSachVanBanCuaPhongDonViCapHai = "danhSachVanBanCuaPhongDonViCapHai";
}
