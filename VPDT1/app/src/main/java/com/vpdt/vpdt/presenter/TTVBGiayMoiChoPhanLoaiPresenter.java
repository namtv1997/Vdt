package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVBGiayMoiChoPhanLoaiPresenter extends BasePresenter {
    void getGMCapNhat(int id);

    void getAllDoKhan();

    void getAllDoMat();

    void getAllKhuVuc();

    void getAllLoaiVanBan();

    void getAllChucVu();

    void getAllNguoiKyVB();

    void getAllLinhVuc();

    void getAllDonVi();

    void getduyetGMCapNhat(int id, int idkhuVuc,
                           String soKyHieu,
                           String noiGuiDen, String loaiVanBan,
                           String ngayKy, String trichYeu, String nguoiKy,
                           String gioHop, String ngayHop, String noiDung, String diaDiem,
                           String nguoiChuTri, String chucVu,
                           String hanGiaiQuyet,
                           String soTrang,
                           String soDen,
                           String ngayNhan, int idDoMat,
                           int idDoKhan,
                           int vBQPPL, int STC_CT, int TBKL);
}
