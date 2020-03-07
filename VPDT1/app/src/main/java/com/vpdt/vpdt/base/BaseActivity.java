package com.vpdt.vpdt.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<BPresenter extends BasePresenter>
        extends AppCompatActivity
        implements BaseView<BPresenter> {
    private BPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int contentViewId = getContentViewId();
        if (contentViewId <= 0) {
            return;
        }
        setContentView(contentViewId);
        presenter = createPresenter();
        initializeComponents();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            finish();
            return;
        }

        super.onBackPressed();
    }

    @Override
    public BPresenter getPresenter() {
        return presenter;
    }

    public abstract int getContentViewId();

    public abstract void initializeComponents();

}
