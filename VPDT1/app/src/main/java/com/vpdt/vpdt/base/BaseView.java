package com.vpdt.vpdt.base;

public interface BaseView<BPresenter extends BasePresenter> {
    BPresenter getPresenter();

    BPresenter createPresenter();

}
