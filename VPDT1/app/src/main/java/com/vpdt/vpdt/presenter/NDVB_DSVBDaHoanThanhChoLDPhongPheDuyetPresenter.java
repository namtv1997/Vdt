package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter extends BasePresenter {
    void duyetVBDaHoanThanhChoLDPheDuyet(int id, boolean vBCoDauRa, boolean coSangtao);

    void tuChoiKetQuaHoanThanhChoLDPheDuyet(int id, String noiDungTuChoi, String idNguoiHoanThanh);
}
