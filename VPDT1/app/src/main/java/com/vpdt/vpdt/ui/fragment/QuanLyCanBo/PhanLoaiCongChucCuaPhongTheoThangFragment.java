package com.vpdt.vpdt.ui.fragment.QuanLyCanBo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.PhanLoaiCongChucCuaPhongTheoThang;
import com.vpdt.vpdt.presenter.PhanLoaiCongChucCuaPhongTheoThangPresenter;
import com.vpdt.vpdt.presenter.PhanLoaiCongChucCuaPhongTheoThangView;
import com.vpdt.vpdt.presenter.impl.PhanLoaiCongChucCuaPhongTheoThangPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterPhanLoaiCongChucCuaPhongTheoThang1;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhanLoaiCongChucCuaPhongTheoThangFragment extends BaseFragment<PhanLoaiCongChucCuaPhongTheoThangPresenter> implements PhanLoaiCongChucCuaPhongTheoThangView {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.tvThang)
    TextView tvThang;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    int idphong = 0;
    int thang;
    String NamLamViec;
    AdapterPhanLoaiCongChucCuaPhongTheoThang1 phanLoaiCongChucCuaPhongTheoThang1;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_phan_loai_cong_chuc_cua_phong_theo_thang;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");

        Bundle bundle = getArguments();
        if (bundle != null) {
            idphong = bundle.getInt("idphong");
            thang = bundle.getInt("thang");
            tvThang.setText("Tháng " + thang);
            getPresenter().gettkkehoachcongtacthang_phong(thang, idphong);
        }
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetPhanLoaiCongChucTeoThangSuccess(ArrayList<PhanLoaiCongChucCuaPhongTheoThang> phanLoaiCongChucCuaPhongTheoThangs) {
        phanLoaiCongChucCuaPhongTheoThang1 = new AdapterPhanLoaiCongChucCuaPhongTheoThang1(getActivity(), phanLoaiCongChucCuaPhongTheoThangs);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(phanLoaiCongChucCuaPhongTheoThang1);
        phanLoaiCongChucCuaPhongTheoThang1.notifyDataSetChanged();
    }

    @OnClick({R.id.btnBack, R.id.tvThang, R.id.vKHKQCCT, R.id.rlKHKQCCT, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;

            case R.id.tvThang:
                AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.list_item_thang, null);
                builder.setView(view1);
                AlertDialog dialog = builder.create();
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                Button btnThang1 = view1.findViewById(R.id.btnThang1);
                Button btnThang2 = view1.findViewById(R.id.btnThang2);
                Button btnThang3 = view1.findViewById(R.id.btnThang3);
                Button btnThang4 = view1.findViewById(R.id.btnThang4);
                Button btnThang5 = view1.findViewById(R.id.btnThang5);
                Button btnThang6 = view1.findViewById(R.id.btnThang6);
                Button btnThang7 = view1.findViewById(R.id.btnThang7);
                Button btnThang8 = view1.findViewById(R.id.btnThang8);
                Button btnThang9 = view1.findViewById(R.id.btnThang9);
                Button btnThang10 = view1.findViewById(R.id.btnThang10);
                Button btnThang11 = view1.findViewById(R.id.btnThang11);
                Button btnThang12 = view1.findViewById(R.id.btnThang12);
                btnThang1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvThang.setText("Tháng 1");
                        dialog.dismiss();
                        getPresenter().gettkkehoachcongtacthang_phong(1, idphong);
                    }
                });
                btnThang2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvThang.setText("Tháng 2");
                        dialog.dismiss();
                        getPresenter().gettkkehoachcongtacthang_phong(2, idphong);
                    }
                });
                btnThang3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvThang.setText("Tháng 3");
                        dialog.dismiss();
                        getPresenter().gettkkehoachcongtacthang_phong(3, idphong);
                    }
                });
                btnThang4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvThang.setText("Tháng 4");
                        dialog.dismiss();
                        getPresenter().gettkkehoachcongtacthang_phong(4, idphong);
                    }
                });
                btnThang5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvThang.setText("Tháng 5");
                        dialog.dismiss();
                        getPresenter().gettkkehoachcongtacthang_phong(5, idphong);
                    }
                });
                btnThang6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvThang.setText("Tháng 6");
                        dialog.dismiss();
                        getPresenter().gettkkehoachcongtacthang_phong(6, idphong);
                    }
                });
                btnThang7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().gettkkehoachcongtacthang_phong(7, idphong);
                        tvThang.setText("Tháng 7");
                        dialog.dismiss();
                    }
                });
                btnThang8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().gettkkehoachcongtacthang_phong(8, idphong);
                        tvThang.setText("Tháng 8");
                        dialog.dismiss();
                    }
                });
                btnThang9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().gettkkehoachcongtacthang_phong(9, idphong);
                        tvThang.setText("Tháng 9");
                        dialog.dismiss();
                    }
                });
                btnThang10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().gettkkehoachcongtacthang_phong(10, idphong);
                        tvThang.setText("Tháng 10");
                        dialog.dismiss();
                    }
                });
                btnThang11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().gettkkehoachcongtacthang_phong(11, idphong);
                        tvThang.setText("Tháng 11");
                        dialog.dismiss();
                    }
                });
                btnThang12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().gettkkehoachcongtacthang_phong(12, idphong);
                        tvThang.setText("Tháng 12");
                        dialog.dismiss();
                    }
                });
                break;

        }
    }

    @Override
    public PhanLoaiCongChucCuaPhongTheoThangPresenter createPresenter() {
        return new PhanLoaiCongChucCuaPhongTheoThangPresenterImpl(this);
    }
}