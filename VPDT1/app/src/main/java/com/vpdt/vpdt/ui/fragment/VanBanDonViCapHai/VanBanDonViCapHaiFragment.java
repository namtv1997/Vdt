package com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai;


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

public class VanBanDonViCapHaiFragment extends BaseFragment<MainPresenter> implements MainView,
        AdapterMeNu.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.rcvDanhSachDeMuc)
    RecyclerView rcvDanhSachDeMuc;
    String NamLamViec;
    int level;

    private AdapterMeNu listAdapter;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
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
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().getMenu(NamLamViec, Key.vanBanDonViCapHai, String.valueOf(false));
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
            case Key.danhSachVanBanTongThe:
                DanhSachVanBanTongTheFragment danhSachVanBanTongTheFragment = new DanhSachVanBanTongTheFragment();
                replaceFragment(danhSachVanBanTongTheFragment, R.id.fl);
                break;
            case Key.vanBanChoChiDaoDonViCapHai:
            case Key.vanBanChoChiDaoDonViCapHaiPhong:
                VanBanChoChiDaoLV1Fragment vanBanChoChiDaoLV1Fragment = new VanBanChoChiDaoLV1Fragment();
                replaceFragment(vanBanChoChiDaoLV1Fragment, R.id.fl);
                break;
            case Key.vanBanDaChiDaoPhongChuaXuLyDonViCapHai:
            case Key.vanBanDaChiDaoPhongChuaXuLyDonViCapHaiPhong:
                VanBanDaChiDaoPhongChuaXuLyFragment vanBanDaChiDaoPhongChuaXuLyFragment = new VanBanDaChiDaoPhongChuaXuLyFragment();
                replaceFragment(vanBanDaChiDaoPhongChuaXuLyFragment, R.id.fl);
                break;
            case Key.vanBanChoXuLyVBTPChuTriDonViCapHai:
                VanBanChoXuLyVBChuTriLV3Fragment vanBanChoXuLyVBChuTriLV3Fragment = new VanBanChoXuLyVBChuTriLV3Fragment();
                replaceFragment(vanBanChoXuLyVBChuTriLV3Fragment, R.id.fl);
                break;
            case Key.vanBanChoXuLyVBTPPhoiHopDonViCapHai:
                VanBanChoXuLyVBPhoiHopLV3Fragment vanBanChoXuLyVBPhoiHopLV3Fragment = new VanBanChoXuLyVBPhoiHopLV3Fragment();
                replaceFragment(vanBanChoXuLyVBPhoiHopLV3Fragment, R.id.fl);
                break;
            case Key.vanBanDaXuLyVBTPchuTriChuaKetThucDonViCapHai:
                VanBanDaXuLyVBChuTriChuaKetThucLV3Fragment vanBanDaXuLyVBChuTriChuaKetThucLV3Fragment = new VanBanDaXuLyVBChuTriChuaKetThucLV3Fragment();
                replaceFragment(vanBanDaXuLyVBChuTriChuaKetThucLV3Fragment, R.id.fl);
                break;
            case Key.vanBanDaXuLyVBTPPhoiHopChuKetThucDonViCapHai:
                VanBanDaXuLyVBPhoiHopChuaKetThucLV3Fragment vanBanDaXuLyVBPhoiHopChuaKetThucLV3Fragment = new VanBanDaXuLyVBPhoiHopChuaKetThucLV3Fragment();
                replaceFragment(vanBanDaXuLyVBPhoiHopChuaKetThucLV3Fragment, R.id.fl);
                break;
            case Key.vanBanChoDuyetDonViCapHai:
                VanBanChoDuyetLV3Fragment vanBanChoDuyetLV3Fragment = new VanBanChoDuyetLV3Fragment();
                replaceFragment(vanBanChoDuyetLV3Fragment, R.id.fl);
                break;
            case Key.danhSachVanBanPhongChuTriDonViCapHai:
                DanhSachVanBanPhongChuTriLV3Fragment danhSachVanBanPhongChuTriLV3Fragment = new DanhSachVanBanPhongChuTriLV3Fragment();
                replaceFragment(danhSachVanBanPhongChuTriLV3Fragment, R.id.fl);
                break;
            case Key.danhSachVanBanPhongPhoiHopDonViCapHai:
                DanhSachVanBanPhongPhoiHopLV3Fragment danhSachVanBanPhongPhoiHopLV3Fragment = new DanhSachVanBanPhongPhoiHopLV3Fragment();
                replaceFragment(danhSachVanBanPhongPhoiHopLV3Fragment, R.id.fl);
                break;
            case Key.vanBanChoXuLyVBPPChuTriDonViCapHai:
                VanBanChoXuLyVBChuTriLV4Fragment vanBanChoXuLyVBChuTriLV4Fragment = new VanBanChoXuLyVBChuTriLV4Fragment();
                replaceFragment(vanBanChoXuLyVBChuTriLV4Fragment, R.id.fl);
                break;
            case Key.vanBanChoXuLyVBPPPhoiHopDonViCapHai:
                VanBanChoXuLyVBPhoiHopLV4Fragment vanBanChoXuLyVBPhoiHopLV4Fragment = new VanBanChoXuLyVBPhoiHopLV4Fragment();
                replaceFragment(vanBanChoXuLyVBPhoiHopLV4Fragment, R.id.fl);
                break;
            case Key.vanBanPhoiHopChoXuLyPPDonViCapHai:
                VanBanPhoiHopChoXuLyLV4Fragment vanBanPhoiHopChoXuLyLV4Fragment = new VanBanPhoiHopChoXuLyLV4Fragment();
                replaceFragment(vanBanPhoiHopChoXuLyLV4Fragment, R.id.fl);
                break;
            case Key.vanBanDaXuLyVBPPchuTriChuaKetThucDonViCapHai:
                VanBanDaXuLyVBChuTriChuaKetThucLV4Fragment vanBanDaXuLyVBChuTriChuaKetThucLV4Fragment = new VanBanDaXuLyVBChuTriChuaKetThucLV4Fragment();
                replaceFragment(vanBanDaXuLyVBChuTriChuaKetThucLV4Fragment, R.id.fl);
                break;
            case Key.vanBanDaXuLyVBPPPhoiHopChuKetThucDonViCapHai:
                VanBanDaXuLyVBPhoiHopChuaKetThucLV4Fragment vanBanDaXuLyVBPhoiHopChuaKetThucLV4Fragment = new VanBanDaXuLyVBPhoiHopChuaKetThucLV4Fragment();
                replaceFragment(vanBanDaXuLyVBPhoiHopChuaKetThucLV4Fragment, R.id.fl);
                break;
            case Key.vanBanPhoiHopDaXuLyPPDonViCapHai:
                VanBanPhoiHopDaXuLyLV4Fragment vanBanPhoiHopDaXuLyLV4Fragment = new VanBanPhoiHopDaXuLyLV4Fragment();
                replaceFragment(vanBanPhoiHopDaXuLyLV4Fragment, R.id.fl);
                break;
            case Key.vanBanChoXuLyVBCVChuTriDonViCapHai:
                VanBanChoXuLyVBChuTriLV5Fragment vanBanChoXuLyVBChuTriLV5Fragment = new VanBanChoXuLyVBChuTriLV5Fragment();
                replaceFragment(vanBanChoXuLyVBChuTriLV5Fragment, R.id.fl);
                break;
            case Key.vanBanChoXuLyVBCVPhoiHopDonViCapHai:
                VanBanChoXuLyVBPhoiHopLV5Fragment vanBanChoXuLyVBPhoiHopLV5Fragment = new VanBanChoXuLyVBPhoiHopLV5Fragment();
                replaceFragment(vanBanChoXuLyVBPhoiHopLV5Fragment, R.id.fl);
                break;
            case Key.vanBanPhoiHopChoXuLyCVDonViCapHai:
                VanBanPhoiHopChoXuLyLV5Fragment vanBanPhoiHopChoXuLyLV5Fragment = new VanBanPhoiHopChoXuLyLV5Fragment();
                replaceFragment(vanBanPhoiHopChoXuLyLV5Fragment, R.id.fl);
                break;
            case Key.vanBanDaXuLyVBCVChuTriChuaKetThucDonViCapHai:
                VanBanDaXuLyVBChuTriLV5Fragment vanBanDaXuLyVBChuTriLV5Fragment = new VanBanDaXuLyVBChuTriLV5Fragment();
                replaceFragment(vanBanDaXuLyVBChuTriLV5Fragment, R.id.fl);
                break;
            case Key.vanBanDaXuLyVBCVPhoiHopChuKetThucDonViCapHai:
                VanBanDaXuLyVBPhoiHopLV5Fragment vanBanDaXuLyVBPhoiHopLV5Fragment = new VanBanDaXuLyVBPhoiHopLV5Fragment();
                replaceFragment(vanBanDaXuLyVBPhoiHopLV5Fragment, R.id.fl);
                break;
            case Key.vanBanPhoiHopDaXuLyCVDonViCapHai:
                VanBanPhoiHopDaXuLyLV5Fragment vanBanPhoiHopDaXuLyLV5Fragment = new VanBanPhoiHopDaXuLyLV5Fragment();
                replaceFragment(vanBanPhoiHopDaXuLyLV5Fragment, R.id.fl);
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        Util.checkConnection(getActivity());
        btnNamLamViec.setText("Năm làm việc: " + integer);
        getPresenter().getMenu(String.valueOf(integer), Key.vanBanDonViCapHai, String.valueOf(false));
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
