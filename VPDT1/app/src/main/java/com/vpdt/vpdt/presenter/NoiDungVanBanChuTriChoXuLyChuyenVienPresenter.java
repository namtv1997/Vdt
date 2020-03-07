package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungVanBanChuTriChoXuLyChuyenVienPresenter extends BasePresenter {
    void tuChoiVBChuTriChoXuLyCV(int id, String noiDungTuChoi, int idCanBoChuyen);

    void themHanVBChuTriChoXuLy(int id, String hanDeXuat, String lyDo);
}
