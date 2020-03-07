package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DauViecChoXuLy;
import com.vpdt.vpdt.model.Item;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DauViecChoXuLyPresenter;
import com.vpdt.vpdt.presenter.DauViecChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DauViecChoXuLyPresenterImpl extends BasePresenterImpl<DauViecChoXuLyView> implements DauViecChoXuLyPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    DauViecChoXuLy model = new DauViecChoXuLy();
    ArrayList<DauViecChoXuLy> dauViecChoXuLyArrayList = new ArrayList<>();
    ArrayList<Item> ITEM_ARRAY_LIST = new ArrayList<>();

    public DauViecChoXuLyPresenterImpl(DauViecChoXuLyView view) {
        super(view);
        model.setItems(ITEM_ARRAY_LIST);
    }

    @Override
    public void getalldauviec(String nam, int trang_thai, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            model.getItems().clear();
            dauViecChoXuLyArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getalldauviec(token, nam, trang_thai)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DauViecChoXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<DauViecChoXuLy>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {
                            if (arrayListResponse.getStatus() == 1) {
                                dauViecChoXuLyArrayList.addAll(arrayListResponse.getData());
                                if (dauViecChoXuLyArrayList.size() == 0) {
                                    getView().onGetDataSuccess();
                                } else {
//                                    dauViecChoXuLyArrayList.addAll(arrayListResponse.getData());
                                    for (int i = 0; i <= arrayListResponse.getData().size(); i++) {
                                        model.setFile(arrayListResponse.getData().get(i).getFile());
                                        model.setNoiDung(arrayListResponse.getData().get(i).getNoiDung());
                                        model.getItems().addAll(arrayListResponse.getData().get(i).getItems());
                                        getView().onGetDataSuccess();
                                        page++;
                                        if (arrayListResponse.getData().get(i).getItems().size() < size) {
                                            isLoadmore = false;
                                        }
                                    }
                                }
                            }
                        }

                    }
                });
    }

    @Override
    public void countalldauviec(String nam, int trang_thai) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countalldauviec(token, nam, uid, trang_thai)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Integer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Integer> response) {
                        Util.getIns().hideLoadding();
                        getView().onGetCountVBSuccess(response);

                    }
                });
    }

    @Override
    public ArrayList<DauViecChoXuLy> DAU_VIEC_CHO_XU_LY_ARRAY_LIST() {
        return dauViecChoXuLyArrayList;
    }
}
