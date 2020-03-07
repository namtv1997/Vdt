package com.vpdt.vpdt.ui.fragment.XuLyGiayMoi;

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

public class XuLyGiayMoiFragment extends BaseFragment<MainPresenter> implements MainView,
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
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            key = bundle.getString("key2");
            if (key != null) {
                switchKey(key);

            }
        }

        NamLamViec = PrefUtil.getString(getActivity(), Key.NAM_LAM_VIEC, "");
        level = PrefUtil.getInt(getActivity(), Key.LEVEL, 0);
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec);

        getPresenter().getMenu(NamLamViec, Key.XLGM, String.valueOf(false));
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

//    @Override
//    public void ons() {
//        super.onStart();
//        integerArrayList.clear();
//    }

    @Override
    public Context gContext() {
        return getActivity();
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
    public void onGetDataSuccess(ArrayList<Contact> contacts) {
        listAdapter = new AdapterMeNu(getContext(), contacts, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
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

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        Util.checkConnection(getActivity());
        btnNamLamViec.setText("Năm làm việc: " + integer);
        getPresenter().getMenu(String.valueOf(integer), Key.XLGM, String.valueOf(false));
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    private void switchKey(String key) {
        switch (key) {
            case Key.GiayMoiChoLanhDaoXL:
                GiayMoiChoLanhDaoXuLyFragment giayMoiChoLanhDaoXuLyFragment = new GiayMoiChoLanhDaoXuLyFragment();
                replaceFragment(giayMoiChoLanhDaoXuLyFragment, R.id.fl);
                break;
            case Key.GiayMoiLDChiDao:
                GiayMoiLanhDaoDaChiDaoFragment giayMoiLanhDaoDaChiDaoFragment = new GiayMoiLanhDaoDaChiDaoFragment();
                replaceFragment(giayMoiLanhDaoDaChiDaoFragment, R.id.fl);
                break;
            case Key.XemLichCongTac:
            case Key.xemLichCongTacLanhDaoSo:
            case Key.xemLichCongTacCuaPhong:
                XemLichCongTacFragment xemLichCongTacFragment = new XemLichCongTacFragment();
                replaceFragment(xemLichCongTacFragment, R.id.fl);
                break;
            case Key.DanhSach_GiayMoiDen_CS:
                DSGiayMoiDenCuaSoFragment dsGiayMoiDenCuaSoFragment = new DSGiayMoiDenCuaSoFragment();
                replaceFragment(dsGiayMoiDenCuaSoFragment, R.id.fl);
                break;
            case Key.BC_KetQuaCuocHopDaGuiDi:
                BaoCaoKetQuaCuocHopDaGuiDiFragment baoCaoKetQuaCuocHopDaGuiDiFragment = new BaoCaoKetQuaCuocHopDaGuiDiFragment();
                replaceFragment(baoCaoKetQuaCuocHopDaGuiDiFragment, R.id.fl);
                break;
            case Key.BC_KetQuaCuocHopMoi:
                BaoCaoKetQuaCuocHopMoiFragment baoCaoKetQuaCuocHopMoiFragment = new BaoCaoKetQuaCuocHopMoiFragment();
                replaceFragment(baoCaoKetQuaCuocHopMoiFragment, R.id.fl);
                break;
            case Key.BC_KetQuaCuocHopDaXem:
                BaoCaoKetQuaCuocHopDaXemFragment baoCaoKetQuaCuocHopDaXemFragment = new BaoCaoKetQuaCuocHopDaXemFragment();
                replaceFragment(baoCaoKetQuaCuocHopDaXemFragment, R.id.fl);
                break;
            case Key.GiayMoi_XemDeBiet:
                GiayMoiXemDeBietFragment giayMoiXemDeBietFragment = new GiayMoiXemDeBietFragment();
                replaceFragment(giayMoiXemDeBietFragment, R.id.fl);
                break;
            case Key.dSGMPhongChuTriXuLy:
                GiayMoiPhongChuTriChoXuLyFragment giayMoiPhongChuTriChoXuLyFragment = new GiayMoiPhongChuTriChoXuLyFragment();
                replaceFragment(giayMoiPhongChuTriChoXuLyFragment, R.id.fl);
                break;
            case Key.dSGMGiaoPhongChuTriDaChiDao:
                GiayMoiGiaoPhongChuTriDaChiDaoFragment giayMoiGiaoPhongChuTriDaChiDaoFragment = new GiayMoiGiaoPhongChuTriDaChiDaoFragment();
                replaceFragment(giayMoiGiaoPhongChuTriDaChiDaoFragment, R.id.fl);
                break;
            case Key.sDGiayMoiPhongPhoiHopChoXuLy:
                GiayMoiPhongPhoiHopChoXuLyFragment giayMoiPhongPhoiHopChoXuLyFragment = new GiayMoiPhongPhoiHopChoXuLyFragment();
                replaceFragment(giayMoiPhongPhoiHopChoXuLyFragment, R.id.fl);
                break;
            case Key.dSGiayMoiGiaoPhongPhoiHopDaChiDao:
                GiayMoiGiaoPhongPhoiHopDaChiDaoFragment giayMoiGiaoPhongPhoiHopDaChiDaoFragment = new GiayMoiGiaoPhongPhoiHopDaChiDaoFragment();
                replaceFragment(giayMoiGiaoPhongPhoiHopDaChiDaoFragment, R.id.fl);
                break;
            case Key.gMDaHTChoLDPhongPD:
                GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetFragment giayMoiDaHoanThanhChoLanhDaoPhongPheDuyetFragment = new GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetFragment();
                replaceFragment(giayMoiDaHoanThanhChoLanhDaoPhongPheDuyetFragment, R.id.fl);
                break;
            case Key.gMPhoiHopTL:
                GiayMoiPhoiHopTraLaiFragment giayMoiPhoiHopTraLaiFragment = new GiayMoiPhoiHopTraLaiFragment();
                replaceFragment(giayMoiPhoiHopTraLaiFragment, R.id.fl);
                break;
            case Key.sDGiayMoiGiaoPhongChuTriDaHoanThanh:
                GiayMoiGiaoPhongChuTriDaHoanThanhFragment giayMoiGiaoPhongChuTriDaHoanThanhFragment = new GiayMoiGiaoPhongChuTriDaHoanThanhFragment();
                replaceFragment(giayMoiGiaoPhongChuTriDaHoanThanhFragment, R.id.fl);
                break;
            case Key.bCCuocHopChoPD:
                BaoCaoCuocHopChoPheDuyetFragment baoCaoCuocHopChoPheDuyetFragment = new BaoCaoCuocHopChoPheDuyetFragment();
                replaceFragment(baoCaoCuocHopChoPheDuyetFragment, R.id.fl);
                break;
            case Key.giayMoiChuTriChoXuLy:
                if (level == 8) {
                    GiayMoiGiaoChuTriChoXuLyFragment giayMoiGiaoChuTriChoXuLyFragment = new GiayMoiGiaoChuTriChoXuLyFragment();
                    replaceFragment(giayMoiGiaoChuTriChoXuLyFragment, R.id.fl);
                } else {
                    GiayMoiChuTriChoXuLyFragment giayMoiChuTriChoXuLyFragment = new GiayMoiChuTriChoXuLyFragment();
                    replaceFragment(giayMoiChuTriChoXuLyFragment, R.id.fl);
                }
                break;
            case Key.giayMoiPhoPhongPhoiHopChoXuLy:
                GiayMoiPhoPhongPhoiHopChoXuLyFragment giayMoiPhoPhongPhoiHopChoXuLyFragment = new GiayMoiPhoPhongPhoiHopChoXuLyFragment();
                replaceFragment(giayMoiPhoPhongPhoiHopChoXuLyFragment, R.id.fl);
                break;
            case Key.giayMoiPhoiHopChoXuLy:
                if (level == 8) {
                    GiayMoiGiaoPhoiHopChoXuLyFragment giayMoiGiaoPhoiHopChoXuLyFragment = new GiayMoiGiaoPhoiHopChoXuLyFragment();
                    replaceFragment(giayMoiGiaoPhoiHopChoXuLyFragment, R.id.fl);
                } else {
                    GiayMoiPhoiHopChoXuLyFragment giayMoiPhoiHopChoXuLyFragment = new GiayMoiPhoiHopChoXuLyFragment();
                    replaceFragment(giayMoiPhoiHopChoXuLyFragment, R.id.fl);
                }
                break;
            case Key.giayMoiDaChiDao:
                GiayMoiDaChiDaoFragment giayMoiDaChiDaoFragment = new GiayMoiDaChiDaoFragment();
                replaceFragment(giayMoiDaChiDaoFragment, R.id.fl);
                break;
            case Key.giayMoiPhoiHopDaChiDao:
                GiayMoiPhoiHopDaChiDaoFragment giayMoiPhoiHopDaChiDaoFragment = new GiayMoiPhoiHopDaChiDaoFragment();
                replaceFragment(giayMoiPhoiHopDaChiDaoFragment, R.id.fl);
                break;
            case Key.giayMoiDaGiaiQuyet:
                GiayMoiDaXulyFragment giayMoiDaXulyFragment = new GiayMoiDaXulyFragment();
                replaceFragment(giayMoiDaXulyFragment, R.id.fl);
                break;
            case Key.giayMoiChoPhanLoai:
                GiayMoiChoPhanLoaiFragment giayMoiChoPhanLoaiFragment = new GiayMoiChoPhanLoaiFragment();
                replaceFragment(giayMoiChoPhanLoaiFragment, R.id.fl);
                break;
            case Key.giayMoiDaPhanLoai:
                GiayMoiDaPhanLoaiFragment giayMoiDaPhanLoaiFragment = new GiayMoiDaPhanLoaiFragment();
                replaceFragment(giayMoiDaPhanLoaiFragment, R.id.fl);
                break;
            case Key.giayMoiChoXuLyCC:
                GiayMoiChoXuLyFragment giayMoiChoXuLyFragment = new GiayMoiChoXuLyFragment();
                replaceFragment(giayMoiChoXuLyFragment, R.id.fl);
                break;
            case Key.giayMoiDaXuLyCC:
                GiayMoiDaXuLyCCFragment giayMoiDaXuLyCCFragment = new GiayMoiDaXuLyCCFragment();
                replaceFragment(giayMoiDaXuLyCCFragment, R.id.fl);
                break;
            case Key.giayMoiPhoiHopDaXuLyCC:
                GiayMoiPhoiHopDaXuLyTPCCFragment giayMoiPhoiHopDaXuLyTPCCFragment = new GiayMoiPhoiHopDaXuLyTPCCFragment();
                replaceFragment(giayMoiPhoiHopDaXuLyTPCCFragment, R.id.fl);
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
