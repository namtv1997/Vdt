package com.vpdt.vpdt.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.ThongBao;
import com.vpdt.vpdt.presenter.ThongBaoPresenter;
import com.vpdt.vpdt.presenter.ThongBaoView;
import com.vpdt.vpdt.presenter.impl.ThongBaoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterThongBao;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThongBaoActivity extends BaseActivity<ThongBaoPresenter> implements ThongBaoView, AdapterThongBao.OnItemClickListener {

    @BindView(R.id.rvThongBao)
    RecyclerView rvThongBao;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;

    @BindView(R.id.imvBack)
    ImageView imvBack;
    AdapterThongBao adapterThongBao;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.activity_thong_bao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllThongBao(true);
        adapterThongBao = new AdapterThongBao(getPresenter().THONG_BAO_ARRAY_LIST(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvThongBao.setLayoutManager(layoutManager);
        rvThongBao.setAdapter(adapterThongBao);
        getPresenter().countThongBao(1);

        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getAllThongBao(true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getAllThongBao(false);
            }
        };
        rvThongBao.addOnScrollListener(scrollListener);

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void getAllThongBaoSuccess() {
        adapterThongBao.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
//    PrefUtil.saveInt(this, Key.NUMBER_NOTIFI, response.getData());
    }


    @Override
    public void UpdateThongBaoSuccess() {
        getPresenter().getAllThongBao(true);
        getPresenter().countThongBao(1);
    }

    @Override
    public ThongBaoPresenter createPresenter() {
        return new ThongBaoPresenterImpl(this);
    }

    @Override
    public void onItemClick(ThongBao thongBao) {
        getPresenter().UpdateThongBao(thongBao.getId());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("key1", thongBao.getKey1());
        intent.putExtra("key2", thongBao.getKey2());
        startActivity(intent);

    }
}
