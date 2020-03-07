package com.vpdt.vpdt.presenter.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.TTVBGiayMoiLanhDaoDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.TTVBGiayMoiLanhDaoDaChiDaoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import okhttp3.MultipartBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TTVBGiayMoiLanhDaoDaChiDaoPresenterImpl extends BasePresenterImpl<TTVBGiayMoiLanhDaoDaChiDaoView> implements TTVBGiayMoiLanhDaoDaChiDaoPresenter {
    public TTVBGiayMoiLanhDaoDaChiDaoPresenterImpl(TTVBGiayMoiLanhDaoDaChiDaoView view) {
        super(view);
    }

    @Override
    public void getgiaylanhdaodachidaobyid(int id_giaymoi) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getgiaymoilanhdaodaxulybyid(token, id_giaymoi, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailGiayMoi>>() {
                    @Override
                    public void onCompleted() {
                        // Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailGiayMoi> detailGiayMoiResponse) {
                        Util.getIns().hideLoadding();
                        if (detailGiayMoiResponse.getData() != null) {

                            if (detailGiayMoiResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(detailGiayMoiResponse.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void xacnhanhoanthanhcv(int id_vb, String id_tk, String ketqua, ArrayList<String> linkfile) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        ArrayList<MultipartBody.Part> listFile = new ArrayList<>();
        if (linkfile.size() == 1) {
            MultipartBody.Part body;
            File file = saveBitmapToFile(new File(linkfile.get(0)));
            body = MultipartBody.Part.createFormData("fileName", file.getName());
            listFile.add(body);

        } else {
            MultipartBody.Part body;
            File file;
            for (int i = 0; i < linkfile.size(); i++) {
                file = saveBitmapToFile(new File(linkfile.get(i)));
                body = MultipartBody.Part.createFormData("fileName" + (i + 1), file.getName());
                listFile.add(body);
            }
        }
        NetworkModule.getService().xacnhanhoanthanhcv(token, id_vb, uid, ketqua, listFile, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {

                    }
                });
    }

    public File saveBitmapToFile(File file) {
        try {

            // BitmapFactory options to downsize the image
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            o.inSampleSize = 6;
            // factor of downsizing the image

            FileInputStream inputStream = new FileInputStream(file);
            //Bitmap selectedBitmap = null;
            BitmapFactory.decodeStream(inputStream, null, o);
            inputStream.close();

            // The new size we want to scale to
            final int REQUIRED_SIZE = 75;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE &&
                    o.outHeight / scale / 2 >= REQUIRED_SIZE) {
                scale *= 2;
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            inputStream = new FileInputStream(file);

            Bitmap selectedBitmap = BitmapFactory.decodeStream(inputStream, null, o2);
            inputStream.close();

            // here i override the original image file
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);

            selectedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

            return file;
        } catch (Exception e) {
            return null;
        }
    }
}
