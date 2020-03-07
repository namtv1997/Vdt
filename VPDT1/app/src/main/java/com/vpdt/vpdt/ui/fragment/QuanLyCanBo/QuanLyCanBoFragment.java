package com.vpdt.vpdt.ui.fragment.QuanLyCanBo;


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
import android.widget.Toast;

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

public class QuanLyCanBoFragment extends BaseFragment<MainPresenter> implements MainView,
        AdapterMeNu.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.rcvDanhSachDeMuc)
    RecyclerView rcvDanhSachDeMuc;

    private AdapterMeNu listAdapter;
    String NamLamViec;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    android.support.v7.app.AlertDialog dialog;
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
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec);
        getPresenter().getMenu(NamLamViec, Key.QLCB, String.valueOf(false));
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

    @Override
    public void onItemClick(Contact contact) {
        switchKey(contact.getKey());
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
    public void onItemClickNamLamViec(Integer integer) {
        Util.checkConnection(getActivity());
        btnNamLamViec.setText("Năm làm việc: " + integer);
        getPresenter().getMenu(String.valueOf(integer), Key.QLCB, String.valueOf(false));
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    private void switchKey(String key) {
        switch (key) {
            case Key.GĐ_soTuNhanXet:
                GDSoTuNhanXetDanhGiaKetQuaThangFragment gdSoTuNhanXetDanhGiaKetQuaThangFragment = new GDSoTuNhanXetDanhGiaKetQuaThangFragment();
                replaceFragment(gdSoTuNhanXetDanhGiaKetQuaThangFragment, R.id.fl);
                break;
            case Key.XemKeHoachKetQua:
                XemKeHoachKetQuaCongTacTuanCuaCacPhongFragment xemKeHoachKetQuaCongTacTuanCuaCacPhongFragment = new XemKeHoachKetQuaCongTacTuanCuaCacPhongFragment();
                replaceFragment(xemKeHoachKetQuaCongTacTuanCuaCacPhongFragment, R.id.fl);
                break;
            case Key.XemKetQuaPhanLoai:
                XemKeHoachKetQuaCongTacThangCuaCacPhongFragment xemKeHoachKetQuaCongTacThangCuaCacPhongFragment = new XemKeHoachKetQuaCongTacThangCuaCacPhongFragment();
                replaceFragment(xemKeHoachKetQuaCongTacThangCuaCacPhongFragment, R.id.fl);
                break;
            case Key.DanhGiaChamDiem:
                DanhGiaChamDiemPhanLoaiPGDTruongPhongFragment danhGiaChamDiemPhanLoaiPGDTruongPhongFragment = new DanhGiaChamDiemPhanLoaiPGDTruongPhongFragment();
                replaceFragment(danhGiaChamDiemPhanLoaiPGDTruongPhongFragment, R.id.fl);
                break;
            case Key.ThongKeKetQuaCongTacTuan:
                ThongKeKetQuaCongTacTuanTrongToanSoFragment thongKeKetQuaCongTacTuanTrongToanSoFragment = new ThongKeKetQuaCongTacTuanTrongToanSoFragment();
                replaceFragment(thongKeKetQuaCongTacTuanTrongToanSoFragment, R.id.fl);
                break;
            case Key.ThongKeKetQuaCongTacThang:
                ThongKeKetQuaCongTacThangTrongToanSoFragment thongKeKetQuaCongTacThangTrongToanSoFragment = new ThongKeKetQuaCongTacThangTrongToanSoFragment();
                replaceFragment(thongKeKetQuaCongTacThangTrongToanSoFragment, R.id.fl);
                break;
            case Key.danhGiaPheDuyetKetQuaPhanLoaiThangCuaSo:
                DanhGiaPheDuyetKetQuaPhanLoaiThangCuaSoFragment danhGiaPheDuyetKetQuaPhanLoaiThangCuaSoFragment = new DanhGiaPheDuyetKetQuaPhanLoaiThangCuaSoFragment();
                replaceFragment(danhGiaPheDuyetKetQuaPhanLoaiThangCuaSoFragment, R.id.fl);
                break;
            case Key.dGKH_DG_CVtuan:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.nX_CD_Cvtuan:
                NhanXetChamDiemCongViecTuanCuaCapDuoiFragment nhanXetChamDiemCongViecTuanCuaCapDuoiFragment = new NhanXetChamDiemCongViecTuanCuaCapDuoiFragment();
                replaceFragment(nhanXetChamDiemCongViecTuanCuaCapDuoiFragment, R.id.fl);
                break;
            case Key.pLCVCPhongThang:
                PhanLoaiCongChucCuaPhongTheoThangFragment phanLoaiCongChucCuaPhongTheoThangFragment = new PhanLoaiCongChucCuaPhongTheoThangFragment();
                replaceFragment(phanLoaiCongChucCuaPhongTheoThangFragment, R.id.fl);
                break;
            case Key.tPTDG_CDThang:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.PGDS_NXTHKQT_CGDS:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.PDG_TCDTCCN:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.nhapGiaoNhanXetKeHoachKetQuaCongTacTuan:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.tuDanhGiaKetQuaCongTacTuanCuaCaNhan:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.tuDanhGiaKetQuaCongTacThangCuaCaNhan:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.xemNhanXetKetQuaCongTacTuanCuaChuyenVien:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.xemKetQuaPhanLoaiThangCuaPhong:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.PGDNhanXetThangDoiVoiCacPGDVaTruongPhong:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.XemKetQuaPhanLoaiCuaCacTruongPhong:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
                break;
            case Key.XemKetQuaCongTacTuanCuaCacPhongTrongSo:
                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
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
