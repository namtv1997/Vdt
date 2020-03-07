package com.vpdt.vpdt.ui.fragment.XuLyVanBan;


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

public class XulyVanBanFragment extends BaseFragment<MainPresenter> implements MainView,
        AdapterMeNu.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.btnHome)
    Button btnHome;

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

       getPresenter().getMenu(NamLamViec, Key.XLVB, String.valueOf(false));
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
            case Key.dSVB_QuaHanDoLanhDaoChiDao:
                DSVB_QuaHanDoLanhDaoChiDaoFragment dsvb_quaHanDoLanhDaoChiDaoFragment = new DSVB_QuaHanDoLanhDaoChiDaoFragment();
                replaceFragment(dsvb_quaHanDoLanhDaoChiDaoFragment, R.id.fl);
                break;
            case Key.dSVB_DenChoXuLy:
                DSVB_ChoLanhDaoXuLyFragment dsvb_choLanhDaoXuLyFragment = new DSVB_ChoLanhDaoXuLyFragment();
                replaceFragment(dsvb_choLanhDaoXuLyFragment, R.id.fl);
                break;
            case Key.dSVB_CongTacDangChoXuLy:
                if (level == 6) {
                    VB_CongTacDangChoXuLyFragment vb_congTacDangChoXuLyFragment = new VB_CongTacDangChoXuLyFragment();
                    replaceFragment(vb_congTacDangChoXuLyFragment, R.id.fl);
                } else if (level == 4 || level == 5) {
                    DSVBCongTacDangChoLDXuLyFragment dsvbCongTacDangChoLDXuLyFragment = new DSVBCongTacDangChoLDXuLyFragment();
                    replaceFragment(dsvbCongTacDangChoLDXuLyFragment, R.id.fl);
                }
                break;
            case Key.dSVB_LanhDaoDaChiDao:
                DSVB_DaChiDaoFragment dsvb_daChiDaoFragment = new DSVB_DaChiDaoFragment();
                replaceFragment(dsvb_daChiDaoFragment, R.id.fl);
                break;
            case Key.duyet_DSVB_GiaHanGiaiQuyet:
                DuyetDSVB_GiaHanGiaiQuyetFragment duyetDSVB_giaHanGiaiQuyetFragment = new DuyetDSVB_GiaHanGiaiQuyetFragment();
                replaceFragment(duyetDSVB_giaHanGiaiQuyetFragment, R.id.fl);
                break;
            case Key.tong_SoLuongToCongTacGiaoPhongXuLy:
                TongSoLuongToCongTac_GiaoPhongXuLyFragment tongSoLuongToCongTac_giaoPhongXuLyFragment = new TongSoLuongToCongTac_GiaoPhongXuLyFragment();
                replaceFragment(tongSoLuongToCongTac_giaoPhongXuLyFragment, R.id.fl);
                break;
            case Key.tong_SoLuongDonThuKNTCGiaoPhongXuLy:
                TongSoLuongDonThuKNTC_GiaoPhongXuLyFragment tongSoLuongDonThuKNTC_giaoPhongXuLyFragment = new TongSoLuongDonThuKNTC_GiaoPhongXuLyFragment();
                replaceFragment(tongSoLuongDonThuKNTC_giaoPhongXuLyFragment, R.id.fl);
                break;
            case Key.dSVB_QuanTrongCuaSo:
                DSVB_QuanTrongCuaSoFragment dsvb_quanTrongCuaSoFragment = new DSVB_QuanTrongCuaSoFragment();
                replaceFragment(dsvb_quanTrongCuaSoFragment, R.id.fl);
                break;
            case Key.dSVB_TheoPhong:
                DSVB_TheoPhongFragment dsvb_theoPhongFragment = new DSVB_TheoPhongFragment();
                replaceFragment(dsvb_theoPhongFragment, R.id.fl);
                break;
            case Key.dSVB_XemDeBiet:
                DSVBXemDeBietFragment dsvbXemDeBietFragment = new DSVBXemDeBietFragment();
                replaceFragment(dsvbXemDeBietFragment, R.id.fl);
                break;
            case Key.dSVB_BietdedonDoc:
                DSPGDBietDeDonDocFragment dspgdBietDeDonDocFragment = new DSPGDBietDeDonDocFragment();
                replaceFragment(dspgdBietDeDonDocFragment, R.id.fl);
                break;
            case Key.dSVB_QuaHanCuaPhong:
            case Key.danhSachVanBanQuahanPhoPhong:
                DSVB_QuaHanCuaPhongFragment dsvb_quaHanCuaPhongFragment = new DSVB_QuaHanCuaPhongFragment();
                replaceFragment(dsvb_quaHanCuaPhongFragment, R.id.fl);
                break;
            case Key.dSVB_GiaoPhongChoXuly:
                VanBanGiaoPhongChuTriChoXuLyFragment vanBanGiaoPhongChuTriChoXuLyFragment = new VanBanGiaoPhongChuTriChoXuLyFragment();
                replaceFragment(vanBanGiaoPhongChuTriChoXuLyFragment, R.id.fl);
                break;
            case Key.dSVB_GiaoPhongPhoiHopChoXuly:
                VanBanGiaoPhongPhoiHopChoXuLyFragment vanBanGiaoPhongPhoiHopChoXuLyFragment = new VanBanGiaoPhongPhoiHopChoXuLyFragment();
                replaceFragment(vanBanGiaoPhongPhoiHopChoXuLyFragment, R.id.fl);
                break;
            case Key.dSVB_PhongChuTriDaChiDao:
                VanBanPhongChuTriDaChiDaoFragment vanBanPhongChuTriDaChiDaoFragment = new VanBanPhongChuTriDaChiDaoFragment();
                replaceFragment(vanBanPhongChuTriDaChiDaoFragment, R.id.fl);
                break;
            case Key.dSVB_PhoiHopDaChidao:
            case Key.vanBanPhoiHopDaChiDaoPhoPhong:
                VanBanPhoiHopDaChiDaoFragment vanBanPhoiHopDaChiDaoFragment = new VanBanPhoiHopDaChiDaoFragment();
                replaceFragment(vanBanPhoiHopDaChiDaoFragment, R.id.fl);
                break;
            case Key.dSVB_PhoiHopTraLai:
                VanBanPhoiHopTraLaiFragment vanBanPhoiHopTraLaiFragment = new VanBanPhoiHopTraLaiFragment();
                replaceFragment(vanBanPhoiHopTraLaiFragment, R.id.fl);
                break;
            case Key.dSVB_DaHoanThanhChoLDPhongPheDuyet:
            case Key.vBHoanThanhChoPheDuyetCV:
            case Key.vBHoanThanhDaPheDuyetCV:
                DSVBDaHoanThanhChoLDPhongPheDuyetFragment dsvbDaHoanThanhChoLDPhongPheDuyetFragment = new DSVBDaHoanThanhChoLDPhongPheDuyetFragment();
                Bundle bundle7 = new Bundle();
                bundle7.putString("keyvb", key);
                dsvbDaHoanThanhChoLDPhongPheDuyetFragment.setArguments(bundle7);
                replaceFragment(dsvbDaHoanThanhChoLDPhongPheDuyetFragment, R.id.fl);
                break;
            case Key.dSVB_DaDeXuatGiaHanGiaiQuyet:
                DSVBDaDeXuatGiaHanGiaiQuyetFragment dsvbDaDeXuatGiaHanGiaiQuyetFragment = new DSVBDaDeXuatGiaHanGiaiQuyetFragment();
                replaceFragment(dsvbDaDeXuatGiaHanGiaiQuyetFragment, R.id.fl);
                break;
            case Key.cVPhoiHopChoXuLy:
            case Key.congViecPhoiHopChoXuLyCC:
                CongViecPhoiHopChoXuLyFragment congViecPhoiHopChoXuLyFragment = new CongViecPhoiHopChoXuLyFragment();
                replaceFragment(congViecPhoiHopChoXuLyFragment, R.id.fl);
                break;
            case Key.dXCongViecPhoiHopChoDuyet:
            case Key.deXuatCongViecPhoiHopChoDuyetCC:
                DeXuatCongViecPhoiHopChoDuyetFragment deXuatCongViecPhoiHopChoDuyetFragment = new DeXuatCongViecPhoiHopChoDuyetFragment();
                replaceFragment(deXuatCongViecPhoiHopChoDuyetFragment, R.id.fl);
                break;
            case Key.dSVB_STCPhoiHopDaChiDao:
                VanBanSTCPhoiHopDaChiDaoFragment vanBanSTCPhoiHopDaChiDaoFragment = new VanBanSTCPhoiHopDaChiDaoFragment();
                replaceFragment(vanBanSTCPhoiHopDaChiDaoFragment, R.id.fl);
                break;
            case Key.tSVanBanGiaoPhongPhoiHop:
                SoLuongVanBanGiaoPhongPhoiHopFragment soLuongVanBanGiaoPhongPhoiHopFragment = new SoLuongVanBanGiaoPhongPhoiHopFragment();
                replaceFragment(soLuongVanBanGiaoPhongPhoiHopFragment, R.id.fl);
                break;
            case Key.tSVanBanGiaoPhongChuTri:
                SoLuongVanBanGiaoPhongChuTriFragment soLuongVanBanGiaoPhongChuTriFragment = new SoLuongVanBanGiaoPhongChuTriFragment();
                replaceFragment(soLuongVanBanGiaoPhongChuTriFragment, R.id.fl);
                break;
            case Key.vanBanChuTrichoXuLyPhoPhong:
                if (level == 8) {
                    VanBanChuTriChoXuLyChuyenVienFragment vanBanChuTriChoXuLyChuyenVienFragment = new VanBanChuTriChoXuLyChuyenVienFragment();
                    replaceFragment(vanBanChuTriChoXuLyChuyenVienFragment, R.id.fl);
                } else {
                    VanBanChuTriChoXuLyPhoPhongFragment vanBanChuTriChoXuLyPhoPhongFragment = new VanBanChuTriChoXuLyPhoPhongFragment();
                    replaceFragment(vanBanChuTriChoXuLyPhoPhongFragment, R.id.fl);
                }
                break;
            case Key.vanBanPhoPhongPhoiHopChoXuLyPhoPhong:
                VanBanPhoPhongPhoiHopChoXuLyFragment vanBanPhoPhongPhoiHopChoXuLyFragment = new VanBanPhoPhongPhoiHopChoXuLyFragment();
                replaceFragment(vanBanPhoPhongPhoiHopChoXuLyFragment, R.id.fl);
                break;
            case Key.vanBanPhoPhongPhoiHopDeDonDocPhoPhong:
                VanBanPhoPhongBietDeDonDocFragment vanBanPhoPhongBietDeDonDocFragment = new VanBanPhoPhongBietDeDonDocFragment();
                replaceFragment(vanBanPhoPhongBietDeDonDocFragment, R.id.fl);
                break;
            case Key.vanBanPhoiHopChoXuLyPhoPhong:
                if (level == 8) {
                    VanBanPhoiHopChoXuLyChuyenVienFragment vanBanPhoiHopChoXuLyChuyenVienFragment = new VanBanPhoiHopChoXuLyChuyenVienFragment();
                    replaceFragment(vanBanPhoiHopChoXuLyChuyenVienFragment, R.id.fl);
                } else {
                    VanBanPhoiHopChoXuLyFragment vanBanPhoiHopChoXuLyFragment = new VanBanPhoiHopChoXuLyFragment();
                    replaceFragment(vanBanPhoiHopChoXuLyFragment, R.id.fl);
                }
                break;
            case Key.vanBanChuTriDaChiDaoPhoPhong:
                VanBanChuTriDaChiDaoFragment vanBanChuTriDaChiDaoFragment = new VanBanChuTriDaChiDaoFragment();
                replaceFragment(vanBanChuTriDaChiDaoFragment, R.id.fl);
                break;
            case Key.vanBanNguoiDungXuLyPhoPhong:
                VanBanNguoiDungXuLyFragment vanBanNguoiDungXuLyFragment = new VanBanNguoiDungXuLyFragment();
                replaceFragment(vanBanNguoiDungXuLyFragment, R.id.fl);
                break;
            case Key.vanBanNguoiDungPhoiHopXuLyPhoPhong:
                VanBanNguoiDungPhoiHopXuLyFragment vanBanNguoiDungPhoiHopXuLyFragment = new VanBanNguoiDungPhoiHopXuLyFragment();
                replaceFragment(vanBanNguoiDungPhoiHopXuLyFragment, R.id.fl);
                break;
            case Key.phanLoaiVanBan:
                PhanLoaiVanBanFragment phanLoaiVanBanFragment = new PhanLoaiVanBanFragment();
                replaceFragment(phanLoaiVanBanFragment, R.id.fl);
                break;
            case Key.vanBanDaPhanLoai:
                VanBanDaPhanLoaiFragment vanBanDaPhanLoaiFragment = new VanBanDaPhanLoaiFragment();
                replaceFragment(vanBanDaPhanLoaiFragment, R.id.fl);
                break;
            case Key.vanBanCacPhongChuyenLai:
                VanBanCacPhongChuyenLaiFragment vanBanCacPhongChuyenLaiFragment = new VanBanCacPhongChuyenLaiFragment();
                replaceFragment(vanBanCacPhongChuyenLaiFragment, R.id.fl);
                break;
            case Key.phanLoaiVanBanCTD:
                PhanLoaiVanBanCongTacDangFragment phanLoaiVanBanCongTacDangFragment = new PhanLoaiVanBanCongTacDangFragment();
                replaceFragment(phanLoaiVanBanCongTacDangFragment, R.id.fl);
                break;
            case Key.vanBanPhongChuTriChoXuLyCC:
                VanBanPhongChuTriChoXuLyFragment vanBanPhongChuTriChoXuLyFragment = new VanBanPhongChuTriChoXuLyFragment();
                replaceFragment(vanBanPhongChuTriChoXuLyFragment, R.id.fl);
                break;
            case Key.vanBanDaChiDaoChuaHoanThanhCC:
                VanBanDaChiDaoChuaHoanThanhFragment vanBanDaChiDaoChuaHoanThanhFragment = new VanBanDaChiDaoChuaHoanThanhFragment();
                replaceFragment(vanBanDaChiDaoChuaHoanThanhFragment, R.id.fl);
                break;
            case Key.soLuongVBGiaoChiCucPhoChuTri:
                SoLuongVanBanGiaoChiCucPhoChuTriFragment soLuongVanBanGiaoChiCucPhoChuTriFragment = new SoLuongVanBanGiaoChiCucPhoChuTriFragment();
                replaceFragment(soLuongVanBanGiaoChiCucPhoChuTriFragment, R.id.fl);
                break;
            case Key.vanBanDaChiDaoSTCPhoiHopCC:
                VanBanDaChiDaoSTCPhoiHopFragment vanBanDaChiDaoSTCPhoiHopFragment = new VanBanDaChiDaoSTCPhoiHopFragment();
                replaceFragment(vanBanDaChiDaoSTCPhoiHopFragment, R.id.fl);
                break;
            case Key.tongSoLuongVanBanGiaoPhongCapHaiChuTri:
                SoLuongVanBanGiaoPhongCap2ChuTriFragment soLuongVanBanGiaoPhongCap2ChuTriFragment = new SoLuongVanBanGiaoPhongCap2ChuTriFragment();
                replaceFragment(soLuongVanBanGiaoPhongCap2ChuTriFragment, R.id.fl);
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        Util.checkConnection(getActivity());
        btnNamLamViec.setText("Năm làm việc: " + integer);
        getPresenter().getMenu(String.valueOf(integer), Key.XLVB, String.valueOf(false));
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
