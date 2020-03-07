package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface DoiMatKhauPresenter extends BasePresenter {
    void doiMatKhau(String nam, String currenPassword, String newPassword);
    void logOut();
}
