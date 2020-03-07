package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.ThongKeVanBan;

public interface ClickThongKeVBTheoLDChiDaoView extends BaseView<ClickThongKeVBTheoLDChiDaoPresenter> {
    Context gContext();

    void clickThongKeVBTheoLDChiDaoSuccess(ThongKeVanBan thongKeVanBan);
}
