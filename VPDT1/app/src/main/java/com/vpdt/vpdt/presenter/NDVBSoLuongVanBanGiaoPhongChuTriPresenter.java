package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBSoLuongVanBanGiaoPhongChuTriPresenter extends BasePresenter {
    void tuChoiVBGiaoPhongChuTri(int id, String noiDungTuChoi, String ghiChu);

    void tuChoiVBGiaoPhongChuTriTruongPhong(int id, String noiDungTuChoi, String ghiChu);

    void themHanVBPhongChuTriChoXuLy(int id, String hanDeXuat, String lyDo);
}
