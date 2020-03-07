package com.vpdt.vpdt.ui.fragment.VanBanDen;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.CanBo;
import com.vpdt.vpdt.model.Contact;
import com.vpdt.vpdt.model.MenuLeft;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanTheoLoaiNoiDen;
import com.vpdt.vpdt.presenter.MainPresenter;
import com.vpdt.vpdt.presenter.MainView;
import com.vpdt.vpdt.presenter.impl.MainPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.BaoCaoDauCongViecCaNhanActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.ThongBaoKetLuanActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanHDNDHaNoiActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanKhacActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanSTCChuTriActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanThanhUyHaNoiActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanUBNDHaNoiActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VnBanToCongTacActivity;
import com.vpdt.vpdt.ui.adapter.AdapterMeNu;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterThongKeTheoLoaiVanBanNoiDen;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VanBanDenFragment extends BaseFragment<MainPresenter> implements MainView,
        AdapterMeNu.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec,
        AdapterThongKeTheoLoaiVanBanNoiDen.OnItemClickListenerThongKeTheoLoaiVanBanNoiDen {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.rcvDanhSachDeMuc)
    RecyclerView rcvDanhSachDeMuc;

    private AdapterMeNu listAdapter;
    AdapterThongKeTheoLoaiVanBanNoiDen adapterThongKeTheoLoaiVanBanNoiDen;

    String NamLamViec;
    RecyclerView rvSelectNam;
    RecyclerView rvSelectVanban;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    int level;
    String key = "";
    String check, check1;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_de_muc;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            key = bundle.getString("key2");
            check = bundle.getString("THONG_KE_VB_THEO_PHONG");
            check1 = bundle.getString("THONG_KE_VB_THEO_LOAI_NOI_DEN");
            if (key != null) {
                switchKey(key);
            }
        }

        NamLamViec = PrefUtil.getString(getActivity(), Key.NAM_LAM_VIEC, "");
        level = PrefUtil.getInt(getActivity(), Key.LEVEL, 0);
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec);
        getPresenter().getMenu(NamLamViec, Key.VBDen, String.valueOf(false));
        getPresenter().countThongBao(1);
        getPresenter().getAllTK_noiden();
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        if (check != null && level == 6 && check.equals("THONG_KE_VB_THEO_PHONG")) {
            Intent intent = new Intent(getActivity(), BaoCaoDauCongViecCaNhanActivity.class);
            intent.putExtra("THONG_KE_VB_THEO_PHONG", check);
            startActivity(intent);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetDataSuccess(ArrayList<Contact> contacts) {
        listAdapter = new AdapterMeNu(getActivity(), contacts, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDanhSachDeMuc.setLayoutManager(layoutManager);
        rcvDanhSachDeMuc.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetMenuLeftSuccess(ArrayList<MenuLeft> menuLefts) {

    }

    @Override
    public void onGetThongBaoSuccess(String s) {

    }

    @OnClick({R.id.btnHome, R.id.btnNamLamViec})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                getActivity().onBackPressed();
                break;
            case R.id.btnNamLamViec:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_nam_selected, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvSelectNam = view1.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();
                break;

        }
    }

    @Override
    public void ongetAllTK_noidenSuccess(ArrayList<VanBanTheoLoaiNoiDen> vanBanTheoLoaiNoiDenArrayList) {
        adapterThongKeTheoLoaiVanBanNoiDen = new AdapterThongKeTheoLoaiVanBanNoiDen(vanBanTheoLoaiNoiDenArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDanhSachDeMuc.setLayoutManager(layoutManager);
        rcvDanhSachDeMuc.setAdapter(adapterThongKeTheoLoaiVanBanNoiDen);
        adapterThongKeTheoLoaiVanBanNoiDen.notifyDataSetChanged();
//        if (check1 != null && check1.equals("THONG_KE_VB_THEO_LOAI_NOI_DEN")) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            final View view1 = inflater.inflate(R.layout.recyclerview_vanban_select, null);
//            builder.setView(view1);
//            dialog = builder.create();
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            dialog.show();
//            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//            rvSelectVanban = view1.findViewById(R.id.rvSelectVanBan);
//            rvSelectVanban.setLayoutManager(layoutManager);
//            rvSelectVanban.setAdapter(adapterThongKeTheoLoaiVanBanNoiDen);
//            adapterThongKeTheoLoaiVanBanNoiDen.notifyDataSetChanged();
//        }
    }

    @Override
    public void onGetDataCanBoSuccess(CanBo canBo) {

    }

    @Override
    public void onLogOutSuccess() {

    }

    @Override
    public void onGetDataFail() {

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {

    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenterImpl(this);
    }

    @Override
    public void onItemClick(Contact contact) {
        switchKey(contact.getKey());
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        Util.checkConnection(getActivity());
        btnNamLamViec.setText("Năm làm việc: " + integer);
//        getPresenter().getMenu(String.valueOf(integer), Key.VBDen, String.valueOf(false));
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickThongKeTheoLoaiVanBanNoiDen(VanBanTheoLoaiNoiDen vanBanTheoLoaiNoiDen) {
        switch (vanBanTheoLoaiNoiDen.getId()) {
            //Văn bản Sở Tài chính Chủ Trì
            case 4:
                Intent intent = new Intent(getActivity(), VanBanSTCChuTriActivity.class);
                startActivity(intent);
                break;

            //Văn bản Thành ủy Hà Nội
            case 5:
                Intent intent1 = new Intent(getActivity(), VanBanThanhUyHaNoiActivity.class);
                startActivity(intent1);
                break;
            //Văn bản UBND Thành phố Hà Nội
            case 6:
                Intent intent2 = new Intent(getActivity(), VanBanUBNDHaNoiActivity.class);
                startActivity(intent2);
                break;
            //Thông Báo kết luận
            case 7:
                Intent intent3 = new Intent(getActivity(), ThongBaoKetLuanActivity.class);
                startActivity(intent3);
                break;
            //Văn bản HĐND Thành Phố HN
            case 8:
                Intent intent4 = new Intent(getActivity(), VanBanHDNDHaNoiActivity.class);
                startActivity(intent4);
                break;
            //Văn bản Khác
            case 9:
                Intent intent5 = new Intent(getActivity(), VanBanKhacActivity.class);
                startActivity(intent5);
                break;
            //Văn bản Tổ công tác
            case 10:
                Intent intent6 = new Intent(getActivity(), VnBanToCongTacActivity.class);
                startActivity(intent6);
                break;
        }
//        dialog.dismiss();
    }

    private void switchKey(String key) {
        switch (key) {
            case Key.DANH_SACH_CONG_TAC_DANG:
                DanhSachCongTacDangFragment danhSachCongTacDangFragment = new DanhSachCongTacDangFragment();
                replaceFragment(danhSachCongTacDangFragment, R.id.fl);
                break;
            case Key.DANH_SACH_TONG_THE:

                DanhSachTongTheFragment danhSachTongTheFragment = new DanhSachTongTheFragment();
                replaceFragment(danhSachTongTheFragment, R.id.fl);
                break;
            case Key.DANH_SACH_GIAY_MOI:
                DanhSachGiayMoiFragment danhSachGiayMoiFragment = new DanhSachGiayMoiFragment();
                replaceFragment(danhSachGiayMoiFragment, R.id.fl);
                break;

            case Key.VAN_BAN_STC_CHU_TRI:
                VanBanSTCChuTriFragment vanBanSTCChuTriFragment = new VanBanSTCChuTriFragment();
                replaceFragment(vanBanSTCChuTriFragment, R.id.fl);
                break;
            case Key.THONG_KE_VB_THEO_LANH_DAO_CHI_DA0:
                ThongKeVBTheoLDChiDaoFragment thongKeVBTheoLDChiDaoFragment = new ThongKeVBTheoLDChiDaoFragment();
                replaceFragment(thongKeVBTheoLDChiDaoFragment, R.id.fl);
                break;
            case Key.THONG_KE_VB_THEO_PHONG:
                if (level == 6) {
                    Intent intent = new Intent(getActivity(), BaoCaoDauCongViecCaNhanActivity.class);
                    startActivity(intent);
                } else if (level == 4 || level == 5) {
                    ThongKeVanBanTheoPhongFragment thongKeVanBanTheoPhongFragment = new ThongKeVanBanTheoPhongFragment();
                    replaceFragment(thongKeVanBanTheoPhongFragment, R.id.fl);
                }
                break;
            case Key.THONG_KE_VB_THEO_PHO_GIAM_DOC:

                ThongKeVanBanTheoPGDFragment thongKeVanBanTheoPGDFragment = new ThongKeVanBanTheoPGDFragment();
                replaceFragment(thongKeVanBanTheoPGDFragment, R.id.fl);
                break;
            case Key.THONG_KE_VB_THEO_LOAI_NOI_DEN:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_vanban_select, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvSelectVanban = view1.findViewById(R.id.rvSelectVanBan);
                rvSelectVanban.setLayoutManager(layoutManager);
                rvSelectVanban.setAdapter(adapterThongKeTheoLoaiVanBanNoiDen);
                adapterThongKeTheoLoaiVanBanNoiDen.notifyDataSetChanged();
                break;
            case Key.BAO_CAO_TONG_HOP:
                BaoCaoTongHopFragment baoCaoTongHopFragment = new BaoCaoTongHopFragment();
                replaceFragment(baoCaoTongHopFragment, R.id.fl);
                break;
            case Key.IN_SO_LUU_TRU_IN_LICH:

                InSoLuuTruVanBanDenFragment inSoLuuTruVanBanDenFragment = new InSoLuuTruVanBanDenFragment();
                replaceFragment(inSoLuuTruVanBanDenFragment, R.id.fl);
                break;
        }
    }

    public void replaceFragment(Fragment fragment, int replace) {
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(replace, fragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
