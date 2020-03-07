package com.vpdt.vpdt.ui.fragment.QuanLyDauViec;


import android.content.Context;
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
import com.vpdt.vpdt.ui.adapter.AdapterMeNu;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuanLyDauViecFragment extends BaseFragment<MainPresenter> implements MainView,
        AdapterMeNu.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.rcvDanhSachDeMuc)
    RecyclerView rcvDanhSachDeMuc;

    String NamLamViec;
    private AdapterMeNu listAdapter;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    android.support.v7.app.AlertDialog dialog;
    int year, level;
    String key = "";

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_de_muc;
    }

    @Override
    public void initializeComponents(View view) {
        Util.checkConnection(getActivity());
        ButterKnife.bind(this, view);
        ((MainActivity) getActivity()).checkFragment(this);
        level = PrefUtil.getInt(getActivity(), Key.LEVEL, 0);
        Bundle bundle = getArguments();
        if (bundle != null) {
            key = bundle.getString("key2");
            if (key != null) {
                switchKey(key);

            }
        }
        NamLamViec = PrefUtil.getString(getActivity(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec);
        getPresenter().getMenu(NamLamViec, Key.QLDV, String.valueOf(false));
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
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

    private void switchKey(String key) {
        switch (key) {
            case Key.DV_ChoXuLy:
                DauViecChoXuLyFragment dauViecChoXuLyFragment = new DauViecChoXuLyFragment();
                replaceFragment(dauViecChoXuLyFragment, R.id.fl);
                break;
            case Key.DS_TaiLieuHop_HDND_CuaPhong:
                DSTaiLieuHopHDNDCuaPhongFragment dsTaiLieuHopHDNDCuaPhongFragment = new DSTaiLieuHopHDNDCuaPhongFragment();
                replaceFragment(dsTaiLieuHopHDNDCuaPhongFragment, R.id.fl);
                break;
            case Key.DV_DaXuLy:
                DauViecDaXuLyFragment dauViecDaXuLyFragment = new DauViecDaXuLyFragment();
                replaceFragment(dauViecDaXuLyFragment, R.id.fl);
                break;
            case Key.DS_KienNghi_HDND:
                DSKienNghiHDNDFragment dsKienNghiHDNDFragment = new DSKienNghiHDNDFragment();
                replaceFragment(dsKienNghiHDNDFragment, R.id.fl);
                break;
            case Key.DS_DauViec_CuaSo:
                DanhSachDauViecCuaSoFragment danhSachDauViecCuaSoFragment = new DanhSachDauViecCuaSoFragment();
                replaceFragment(danhSachDauViecCuaSoFragment, R.id.fl);
                break;
            case Key.DS_TaiLieuHop_HDND_CuaTongHop:
                DSTaiLieuHopHDNDCuaTongHopFragment dsTaiLieuHopHDNDCuaTongHopFragment = new DSTaiLieuHopHDNDCuaTongHopFragment();
                replaceFragment(dsTaiLieuHopHDNDCuaTongHopFragment, R.id.fl);
                break;

            case Key.DS_DauViec_DeXuatGiaHan:
                if (level == 8) {
                    DanhSachDauViecDeXuatGiaHanChuyenVienFragment danhSachDauViecDeXuatGiaHanChuyenVienFragment = new DanhSachDauViecDeXuatGiaHanChuyenVienFragment();
                    replaceFragment(danhSachDauViecDeXuatGiaHanChuyenVienFragment, R.id.fl);
                } else {
                    DanhSachDauViecDeXuatGiaHanFragment danhSachDauViecDeXuatGiaHanFragment = new DanhSachDauViecDeXuatGiaHanFragment();
                    replaceFragment(danhSachDauViecDeXuatGiaHanFragment, R.id.fl);
                }
                break;
            case Key.DS_DauViec_DeXuatGiaHanDaXuLy:
                if (level == 8) {
                    DanhSachDauViecDeXuatGiaHanDaXuLyChuyenVienFragment danhSachDauViecDeXuatGiaHanDaXuLyChuyenVienFragment = new DanhSachDauViecDeXuatGiaHanDaXuLyChuyenVienFragment();
                    replaceFragment(danhSachDauViecDeXuatGiaHanDaXuLyChuyenVienFragment, R.id.fl);
                } else {
                    DanhSachDauViecDeXuatGiaHanDaXuLyFragment danhSachDauViecDeXuatGiaHanDaXuLyFragment = new DanhSachDauViecDeXuatGiaHanDaXuLyFragment();
                    replaceFragment(danhSachDauViecDeXuatGiaHanDaXuLyFragment, R.id.fl);
                }
                break;
            case Key.dSDaiViecQuaHanCuaPhong:
                DanhSachDauViecQuaHanCuaPhongFragment danhSachDauViecQuaHanCuaPhongFragment = new DanhSachDauViecQuaHanCuaPhongFragment();
                replaceFragment(danhSachDauViecQuaHanCuaPhongFragment, R.id.fl);
                break;
            case Key.dauViecPhongChuTriChoXuLy:
                if (level == 8) {
                    DauViecPhongChuTriChuyenVienChoXuLyFragment dauViecPhongChuTriChuyenVienChoXuLyFragment = new DauViecPhongChuTriChuyenVienChoXuLyFragment();
                    replaceFragment(dauViecPhongChuTriChuyenVienChoXuLyFragment, R.id.fl);
                } else {
                    DauViecPhongChuTriChoXuLyFragment dauViecPhongChuTriChoXuLyFragment = new DauViecPhongChuTriChoXuLyFragment();
                    replaceFragment(dauViecPhongChuTriChoXuLyFragment, R.id.fl);
                }
                break;
            case Key.dauViecPhongPhoiHopChoXuLy:
                if (level == 8) {
                    DauViecPhongPhoiHopChoXuLyChuyenVienFragment dauViecPhongPhoiHopChoXuLyChuyenVienFragment = new DauViecPhongPhoiHopChoXuLyChuyenVienFragment();
                    replaceFragment(dauViecPhongPhoiHopChoXuLyChuyenVienFragment, R.id.fl);
                } else {
                    DauViecPhongPhoiHopChoXuLyFragment dauViecPhongPhoiHopChoXuLyFragment = new DauViecPhongPhoiHopChoXuLyFragment();
                    replaceFragment(dauViecPhongPhoiHopChoXuLyFragment, R.id.fl);
                }
                break;
            case Key.dauViecPhongChuTriDaChiDaoChuaHoanThanh:
                DauViecPhongChuTriDaChiDaoChuaHTFragment dauViecPhongChuTriDaChiDaoChuaHTFragment = new DauViecPhongChuTriDaChiDaoChuaHTFragment();
                replaceFragment(dauViecPhongChuTriDaChiDaoChuaHTFragment, R.id.fl);
                break;
            case Key.dauViecPhongPhoiHopDaChiDaoChuaHoanThanh:
                DauViecPhongPhoiHopDaChiDaoChuaHTFragment dauViecPhongPhoiHopDaChiDaoChuaHTFragment = new DauViecPhongPhoiHopDaChiDaoChuaHTFragment();
                replaceFragment(dauViecPhongPhoiHopDaChiDaoChuaHTFragment, R.id.fl);
                break;
            case Key.dSDauViecPhongChuTri:
                DanhSachDauViecPhongChuTriFragment danhSachDauViecPhongChuTriFragment = new DanhSachDauViecPhongChuTriFragment();
                replaceFragment(danhSachDauViecPhongChuTriFragment, R.id.fl);
                break;
            case Key.dSDauViecPhongPhoiHop:
                DanhSachDauViecPhongPhoiHopFragment danhSachDauViecPhongPhoiHopFragment = new DanhSachDauViecPhongPhoiHopFragment();
                replaceFragment(danhSachDauViecPhongPhoiHopFragment, R.id.fl);
                break;
            case Key.dSDauViecHoanThanhChoLDPhongDuyet:
                DauViecHoanThanhChoLanhDaoPhongDuyetFragment dauViecHoanThanhChoLanhDaoPhongDuyetFragment = new DauViecHoanThanhChoLanhDaoPhongDuyetFragment();
                replaceFragment(dauViecHoanThanhChoLanhDaoPhongDuyetFragment, R.id.fl);
                break;
            case Key.dViecPhongChuTriChoXuLyPhoPhongPH:
                DauViecPhongChuTriChoXuLyPhoPhongPhoiHopFragment dauViecPhongChuTriChoXuLyPhoPhongPhoiHopFragment = new DauViecPhongChuTriChoXuLyPhoPhongPhoiHopFragment();
                replaceFragment(dauViecPhongChuTriChoXuLyPhoPhongPhoiHopFragment, R.id.fl);
                break;
            case Key.dViecPhongPhoiHopChoXuLyPhoPhongPH:
                DauViecPhongPhoiHopChoXuLyPhoPhongPhoiHopFragment dauViecPhongPhoiHopChoXuLyPhoPhongPhoiHopFragment = new DauViecPhongPhoiHopChoXuLyPhoPhongPhoiHopFragment();
                replaceFragment(dauViecPhongPhoiHopChoXuLyPhoPhongPhoiHopFragment, R.id.fl);
                break;
            case Key.dauViecPhongChuTriDaXuLy:
                DauViecPhongChuTriDaXuLyFragment dauViecPhongChuTriDaXuLyFragment = new DauViecPhongChuTriDaXuLyFragment();
                replaceFragment(dauViecPhongChuTriDaXuLyFragment, R.id.fl);
                break;
            case Key.dViecPhongChuTriDaXuLyPhoPhongPH:
                DauViecPhongChuTriDaXuLyPhoPhongPhoiHopFragment dauViecPhongChuTriDaXuLyPhoPhongPhoiHopFragment = new DauViecPhongChuTriDaXuLyPhoPhongPhoiHopFragment();
                replaceFragment(dauViecPhongChuTriDaXuLyPhoPhongPhoiHopFragment, R.id.fl);
                break;
            case Key.dViecPhongPhoiHopDaXuLyPhoPhongPH:
                DauViecPhongPhoiHopDaXuLyPhoPhongPhoiHopFragment dauViecPhongPhoiHopDaXuLyPhoPhongPhoiHopFragment = new DauViecPhongPhoiHopDaXuLyPhoPhongPhoiHopFragment();
                replaceFragment(dauViecPhongPhoiHopDaXuLyPhoPhongPhoiHopFragment, R.id.fl);
                break;
            case Key.dauViecBiTraLai:
                DauViecHoanThanhBiTraLaiFragment dauViecHoanThanhBiTraLaiFragment = new DauViecHoanThanhBiTraLaiFragment();
                replaceFragment(dauViecHoanThanhBiTraLaiFragment, R.id.fl);
                break;
            case Key.dauViecChuyenVienPhoiHopPhongCT:
                DauViecChuyenVienXuLyFragment dauViecChuyenVienXuLyFragment = new DauViecChuyenVienXuLyFragment();
                replaceFragment(dauViecChuyenVienXuLyFragment, R.id.fl);
                break;
            case Key.dauViecPhongPhoiHopChoXuLyCVPP:
                DauViecPhongPhoiHopChoXuLyCVPHFragment dauViecPhongPhoiHopChoXuLyCVPHFragment = new DauViecPhongPhoiHopChoXuLyCVPHFragment();
                replaceFragment(dauViecPhongPhoiHopChoXuLyCVPHFragment, R.id.fl);
                break;
            case Key.dauViecPhongPhoiHopDaXuLy:
                DauViecPhongPhoiHopDaXuLyFragment dauViecPhongPhoiHopDaXuLyFragment = new DauViecPhongPhoiHopDaXuLyFragment();
                replaceFragment(dauViecPhongPhoiHopDaXuLyFragment, R.id.fl);
                break;
            case Key.dauViecPhongChuTriChoXuLyCC:
                DauViecPhongChuTriChoXuLyCCFragment dauViecPhongChuTriChoXuLyCCFragment = new DauViecPhongChuTriChoXuLyCCFragment();
                replaceFragment(dauViecPhongChuTriChoXuLyCCFragment, R.id.fl);
                break;
            case Key.dauViecPhongPhoiHopChoXuLyCC:
                DauViecPhongPhoiHopChoXuLyCCFragment dauViecPhongPhoiHopChoXuLyCCFragment = new DauViecPhongPhoiHopChoXuLyCCFragment();
                replaceFragment(dauViecPhongPhoiHopChoXuLyCCFragment, R.id.fl);
                break;
            case Key.dSDauViecPhongChuTriDaXuLyCC:
                DSDauViecPhongChuTriDaXuLyCCFragment dsDauViecPhongChuTriChoXuLyCCFragment = new DSDauViecPhongChuTriDaXuLyCCFragment();
                replaceFragment(dsDauViecPhongChuTriChoXuLyCCFragment, R.id.fl);
                break;
            case Key.dSDauViecPhongPhoiHopDaXuLyCC:
                DSDauViecPhongPhoiHopDaXuLyCCFragment dsDauViecPhongPhoiHopDaXuLyCCFragment = new DSDauViecPhongPhoiHopDaXuLyCCFragment();
                replaceFragment(dsDauViecPhongPhoiHopDaXuLyCCFragment, R.id.fl);
                break;
            case Key.dauViecPhongChuTriChoXuLyTPCC:
                DauViecPhongChuTriChoXuLyTPCCFragment dauViecPhongChuTriChoXuLyTPCCFragment = new DauViecPhongChuTriChoXuLyTPCCFragment();
                replaceFragment(dauViecPhongChuTriChoXuLyTPCCFragment, R.id.fl);
                break;
            case Key.dauViecPhongPhoiHopChoXuLyTPCC:
                DauViecPhongPhoiHopChoXuLyTPCCFragment dauViecPhongPhoiHopChoXuLyTPCCFragment = new DauViecPhongPhoiHopChoXuLyTPCCFragment();
                replaceFragment(dauViecPhongPhoiHopChoXuLyTPCCFragment, R.id.fl);
                break;
            case Key.dauViecTruongPhongPhoiHopPhongCT:
                DauViecTruongPhongPhoiHopPhongCTTPCCFragment dauViecTruongPhongPhoiHopPhongCTTPCCFragment = new DauViecTruongPhongPhoiHopPhongCTTPCCFragment();
                replaceFragment(dauViecTruongPhongPhoiHopPhongCTTPCCFragment, R.id.fl);
                break;
            case Key.dsPhongChuTriDaChiDaoChuaHoanThanhCC:
                DanhSachPhongChuTriDaChiDaoChuaHTTPCCFragment danhSachPhongChuTriDaChiDaoChuaHTTPCCFragment = new DanhSachPhongChuTriDaChiDaoChuaHTTPCCFragment();
                replaceFragment(danhSachPhongChuTriDaChiDaoChuaHTTPCCFragment, R.id.fl);
                break;
            case Key.dSPhongPhoiHopDaChiDaoCC:
                DanhSachPhongPhoiHopDaChiDaoTPCCFragment danhSachPhongPhoiHopDaChiDaoTPCCFragment = new DanhSachPhongPhoiHopDaChiDaoTPCCFragment();
                replaceFragment(danhSachPhongPhoiHopDaChiDaoTPCCFragment, R.id.fl);
                break;
            case Key.dSDauViecDaChiDaoTruongPhongPPCC:
                DanhSachDauViecDaChiDaoTruongPhongPhoiHopTPCCFragment danhSachDauViecDaChiDaoTruongPhongPhoiHopTPCCFragment = new DanhSachDauViecDaChiDaoTruongPhongPhoiHopTPCCFragment();
                replaceFragment(danhSachDauViecDaChiDaoTruongPhongPhoiHopTPCCFragment, R.id.fl);
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        Util.checkConnection(getActivity());
        btnNamLamViec.setText("Năm làm việc: " + integer);
        getPresenter().getMenu(String.valueOf(integer), Key.QLDV, String.valueOf(false));
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
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
