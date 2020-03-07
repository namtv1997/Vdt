package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Contact;
import com.vpdt.vpdt.model.MenuLeft;
import com.vpdt.vpdt.model.VanBanTheoLoaiNoiDen;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.ThongBaoKetLuanActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanHDNDHaNoiActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanKhacActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanSTCChuTriActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanThanhUyHaNoiActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VanBanUBNDHaNoiActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.VnBanToCongTacActivity;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DSKienNghiHDNDFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DSTaiLieuHopHDNDCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DSTaiLieuHopHDNDCuaTongHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDeXuatGiaHanChuyenVienFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDeXuatGiaHanDaXuLyChuyenVienFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDeXuatGiaHanDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecDeXuatGiaHanFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecPhongChuTriFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DanhSachDauViecQuaHanCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecChuyenVienXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecHoanThanhBiTraLaiFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecHoanThanhChoLanhDaoPhongDuyetFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriChoXuLyPhoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriChuyenVienChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriDaChiDaoChuaHTFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongChuTriDaXuLyPhoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyCVPHFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyChuyenVienFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopChoXuLyPhoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopDaChiDaoChuaHTFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.QuanLyDauViec.DauViecPhongPhoiHopDaXuLyPhoPhongPhoiHopFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.BaoCaoTongHopFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.DanhSachCongTacDangFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.DanhSachGiayMoiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.DanhSachTongTheFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.InSoLuuTruVanBanDenFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.ThongKeVBTheoLDChiDaoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.ThongKeVanBanTheoPGDFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.ThongKeVanBanTheoPhongFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.VanBanDenFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDen.VanBanSTCChuTriFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachGiayMoiCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachGiayMoiCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachVBSoThamMuuTrinhTPFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachVanBanChoSoCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachVanBanCuaPhongFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.DanhSachVanBanCuaSoFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.InSoLuuTruVanBanDiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.LichHopCuaSoChuTriFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.NhapVanBanDiFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanChuTriChoXuLyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanChuTriDaXuLyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanDaTrinhKyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanTrinhKyFragment;
import com.vpdt.vpdt.ui.fragment.VanBanDi.VanBanXemDeBietFragment;
import com.vpdt.vpdt.util.PrefUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterMeNuLeft1 extends RecyclerView.Adapter<AdapterMeNuLeft1.ViewHolder> implements AdapterMeNuLeft.OnItemClickListener, AdapterThongKeTheoLoaiVanBanNoiDen.OnItemClickListenerThongKeTheoLoaiVanBanNoiDen {

    private ArrayList<MenuLeft> contactsList;
    private Context mContext;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    ArrayList<Integer> counter = new ArrayList<Integer>();
    int level;
    AlertDialog dialog;

    public AdapterMeNuLeft1(Context mContext, ArrayList<MenuLeft> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
        for (int i = 0; i < contactsList.size(); i++) {
            counter.add(0);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_menu1, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        level = PrefUtil.getInt(mContext, Key.LEVEL, 0);
        MenuLeft contact = contactsList.get(position);

        Glide.with(mContext)
                .load(contact.getIcon())
                .into(viewHolder.ivIcon);
//        Glide.with(mContext)
//                .load(contact.getIcon())
//                .into(viewHolder.ivRight);
        if (contact.getKey().equals(Key.VBDiLeft) || contact.getKey().equals(Key.QLDVLeft) || contact.getKey().equals(Key.VBDen)) {
            viewHolder.ivRight.setVisibility(View.VISIBLE);
        } else {
            viewHolder.ivRight.setVisibility(View.GONE);
        }
        viewHolder.tvTenDeMuc.setText(contact.getName());
        if (contact.getShowTotal()) {
            viewHolder.tvNotifiContact.setVisibility(View.VISIBLE);
            viewHolder.tvNotifiContact.setText(String.valueOf(contact.getSoluong()));
            if (contact.getKey().equals(Key.dSVB_QuaHanDoLanhDaoChiDao)) {
                viewHolder.tvTinQuaHan.setVisibility(View.VISIBLE);
                viewHolder.tvTinQuaHan.setText(String.valueOf(contact.getSoluong()));
                viewHolder.tvNotifiContact.setVisibility(View.GONE);
            }
        }

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.rcvMenu1.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(contact.getMenus().size());

        // Create sub item view adapter
        AdapterMeNuLeft adapterMeNuLeft = new AdapterMeNuLeft(mContext, (ArrayList<Contact>) contact.getMenus(), this);

        viewHolder.rcvMenu1.setLayoutManager(layoutManager);
        viewHolder.rcvMenu1.setAdapter(adapterMeNuLeft);
        viewHolder.rcvMenu1.setRecycledViewPool(viewPool);
        viewHolder.lnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter.get(position) % 2 == 0) {
                    viewHolder.rcvMenu1.setVisibility(View.VISIBLE);
                } else {
                    viewHolder.rcvMenu1.setVisibility(View.GONE);
                }

                counter.set(position, counter.get(position) + 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    @Override
    public void onItemClick(Contact contact, View v) {
        switch (contact.getKey()) {
            //vb den
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
                    VanBanDenFragment vanBanDenFragment = new VanBanDenFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("THONG_KE_VB_THEO_PHONG", "THONG_KE_VB_THEO_PHONG");
                    vanBanDenFragment.setArguments(bundle);
                    replaceFragment(vanBanDenFragment, R.id.fl);
//                    Intent intent = new Intent(mContext, BaoCaoDauCongViecCaNhanActivity.class);
//                    mContext.startActivity(intent);
                } else if (level == 4 || level == 5) {
                    ThongKeVanBanTheoPhongFragment thongKeVanBanTheoPhongFragment = new ThongKeVanBanTheoPhongFragment();
                    replaceFragment(thongKeVanBanTheoPhongFragment, R.id.fl);
                }else {
                    ThongKeVanBanTheoPhongFragment thongKeVanBanTheoPhongFragment = new ThongKeVanBanTheoPhongFragment();
                    replaceFragment(thongKeVanBanTheoPhongFragment, R.id.fl);
                }
                break;
            case Key.THONG_KE_VB_THEO_PHO_GIAM_DOC:
                ThongKeVanBanTheoPGDFragment thongKeVanBanTheoPGDFragment = new ThongKeVanBanTheoPGDFragment();
                replaceFragment(thongKeVanBanTheoPGDFragment, R.id.fl);
                break;
            case Key.THONG_KE_VB_THEO_LOAI_NOI_DEN:
                VanBanDenFragment vanBanDenFragment = new VanBanDenFragment();
                Bundle bundle = new Bundle();
                bundle.putString("THONG_KE_VB_THEO_LOAI_NOI_DEN", "THONG_KE_VB_THEO_LOAI_NOI_DEN");
                vanBanDenFragment.setArguments(bundle);
                replaceFragment(vanBanDenFragment, R.id.fl);
//                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                final View view1 = inflater.inflate(R.layout.recyclerview_vanban_select, null);
//                builder.setView(view1);
//                dialog = builder.create();
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
//                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//                rvSelectVanban = view1.findViewById(R.id.rvSelectVanBan);
//                rvSelectVanban.setLayoutManager(layoutManager);
//                rvSelectVanban.setAdapter(adapterThongKeTheoLoaiVanBanNoiDen);
//                adapterThongKeTheoLoaiVanBanNoiDen.notifyDataSetChanged();
                break;
            case Key.BAO_CAO_TONG_HOP:
                BaoCaoTongHopFragment baoCaoTongHopFragment = new BaoCaoTongHopFragment();
                replaceFragment(baoCaoTongHopFragment, R.id.fl);
                break;
            case Key.IN_SO_LUU_TRU_IN_LICH:
                InSoLuuTruVanBanDenFragment inSoLuuTruVanBanDenFragment = new InSoLuuTruVanBanDenFragment();
                replaceFragment(inSoLuuTruVanBanDenFragment, R.id.fl);
                break;


            // vb di
            case Key.VB_TrinhKy:
                VanBanTrinhKyFragment vanBanTrinhKyFragment = new VanBanTrinhKyFragment();
                replaceFragment(vanBanTrinhKyFragment, R.id.fl);
                break;
            case Key.VB_XemDeBiet:
                VanBanXemDeBietFragment vanBanXemDeBietFragment = new VanBanXemDeBietFragment();
                replaceFragment(vanBanXemDeBietFragment, R.id.fl);
                break;
            case Key.LichHop_CuaSoCT:
                LichHopCuaSoChuTriFragment lichHopCuaSoChuTriFragment = new LichHopCuaSoChuTriFragment();
                replaceFragment(lichHopCuaSoChuTriFragment, R.id.fl);
                break;
            case Key.DS_VB_CUA_SO:
                DanhSachVanBanCuaSoFragment danhSachVanBanCuaSoFragment = new DanhSachVanBanCuaSoFragment();
                replaceFragment(danhSachVanBanCuaSoFragment, R.id.fl);
                break;
            case Key.DS_GMOI_CUA_SO:
                DanhSachGiayMoiCuaSoFragment danhSachGiayMoiCuaSoFragment = new DanhSachGiayMoiCuaSoFragment();
                replaceFragment(danhSachGiayMoiCuaSoFragment, R.id.fl);
                break;
            case Key.DS_VB_SO_THAM_MUU_TRINH_THANH_PHO:
                DanhSachVBSoThamMuuTrinhTPFragment danhSachVBSoThamMuuTrinhTPFragment = new DanhSachVBSoThamMuuTrinhTPFragment();
                replaceFragment(danhSachVBSoThamMuuTrinhTPFragment, R.id.fl);
                break;
            case Key.DS_VB_CHO_SO_CUA_SO:
                DanhSachVanBanChoSoCuaSoFragment danhSachVanBanChoSoCuaSoFragment = new DanhSachVanBanChoSoCuaSoFragment();
                replaceFragment(danhSachVanBanChoSoCuaSoFragment, R.id.fl);
                break;
            case Key.IN_SO_LUU_TRU:
                InSoLuuTruVanBanDiFragment inSoLuuTruVanBanDiFragment = new InSoLuuTruVanBanDiFragment();
                replaceFragment(inSoLuuTruVanBanDiFragment, R.id.fl);
                break;
            case Key.vBCT_Cho_XL:
                VanBanChuTriChoXuLyFragment vanBanChuTriChoXuLyFragment = new VanBanChuTriChoXuLyFragment();
                replaceFragment(vanBanChuTriChoXuLyFragment, R.id.fl);
                break;
            case Key.vBCT_Da_XL:
                VanBanChuTriDaXuLyFragment vanBanChuTriDaXuLyFragment = new VanBanChuTriDaXuLyFragment();
                replaceFragment(vanBanChuTriDaXuLyFragment, R.id.fl);
                break;
            case Key.dSVB_cuaPhong:
                DanhSachVanBanCuaPhongFragment danhSachVanBanCuaPhongFragment = new DanhSachVanBanCuaPhongFragment();
                replaceFragment(danhSachVanBanCuaPhongFragment, R.id.fl);
                break;
            case Key.dSGM_cuaPhong:
                DanhSachGiayMoiCuaPhongFragment danhSachGiayMoiCuaPhongFragment = new DanhSachGiayMoiCuaPhongFragment();
                replaceFragment(danhSachGiayMoiCuaPhongFragment, R.id.fl);
                break;
            case Key.NVBDi:
                NhapVanBanDiFragment nhapVanBanDiFragment = new NhapVanBanDiFragment();
                replaceFragment(nhapVanBanDiFragment, R.id.fl);
                break;
            case Key.vBDaTrinhKy:
                VanBanDaTrinhKyFragment vanBanDaTrinhKyFragment = new VanBanDaTrinhKyFragment();
                replaceFragment(vanBanDaTrinhKyFragment, R.id.fl);
                break;


            //qly dau viec
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
        }
    }

    public void replaceFragment(Fragment fragment, int replace) {
        FragmentManager fragmentManager = ((MainActivity) mContext).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(replace, fragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemClickThongKeTheoLoaiVanBanNoiDen(VanBanTheoLoaiNoiDen vanBanTheoLoaiNoiDen) {
        switch (vanBanTheoLoaiNoiDen.getId()) {
            //Văn bản Sở Tài chính Chủ Trì
            case 4:
                Intent intent = new Intent(mContext, VanBanSTCChuTriActivity.class);
                mContext.startActivity(intent);
                break;

            //Văn bản Thành ủy Hà Nội
            case 5:
                Intent intent1 = new Intent(mContext, VanBanThanhUyHaNoiActivity.class);
                mContext.startActivity(intent1);
                break;
            //Văn bản UBND Thành phố Hà Nội
            case 6:
                Intent intent2 = new Intent(mContext, VanBanUBNDHaNoiActivity.class);
                mContext.startActivity(intent2);
                break;
            //Thông Báo kết luận
            case 7:
                Intent intent3 = new Intent(mContext, ThongBaoKetLuanActivity.class);
                mContext.startActivity(intent3);
                break;
            //Văn bản HĐND Thành Phố HN
            case 8:
                Intent intent4 = new Intent(mContext, VanBanHDNDHaNoiActivity.class);
                mContext.startActivity(intent4);
                break;
            //Văn bản Khác
            case 9:
                Intent intent5 = new Intent(mContext, VanBanKhacActivity.class);
                mContext.startActivity(intent5);
                break;
            //Văn bản Tổ công tác
            case 10:
                Intent intent6 = new Intent(mContext, VnBanToCongTacActivity.class);
                mContext.startActivity(intent6);
                break;
        }
        dialog.dismiss();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivIcon)
        ImageView ivIcon;
        @BindView(R.id.ivRight)
        ImageView ivRight;

        @BindView(R.id.tvTenDeMuc)
        TextView tvTenDeMuc;
        @BindView(R.id.tvNotifiContact)
        TextView tvNotifiContact;
        @BindView(R.id.tvTinQuaHan)
        TextView tvTinQuaHan;
        @BindView(R.id.rcvMenu1)
        RecyclerView rcvMenu1;
        @BindView(R.id.lnmenu)
        LinearLayout lnmenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}