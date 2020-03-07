package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TraoDoiThongTinNoiBoDetail;

import java.util.ArrayList;

public interface TTVBThongTinMoiView extends BaseView<TTVBThongTinMoiPresenter> {
    Context gContext();

    void onGetDataSuccess(TraoDoiThongTinNoiBoDetail traoDoiThongTinNoiBoDetail);

    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);

    void onGetCanBoByIdPhongBanSuccess(ArrayList<CanBoByidPhongBan> canBoByidPhongBans);
}
