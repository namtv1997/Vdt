package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBBaoCaoCuocHopChoPheDuyetPresenter extends BasePresenter {
    void duyetBaoCaoCuocHopChoDuyet(int IdVB, String IdNoiDung);

    void tuChoiBaoCaoCuocHopChoDuyet(int IdVB, String IdNoiDung, String noiDung);
}
