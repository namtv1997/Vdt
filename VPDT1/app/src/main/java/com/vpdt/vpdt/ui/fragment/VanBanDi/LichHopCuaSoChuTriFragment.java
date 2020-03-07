package com.vpdt.vpdt.ui.fragment.VanBanDi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.vpdt.vpdt.model.DetailLichHop;
import com.vpdt.vpdt.model.ItemLichHop;
import com.vpdt.vpdt.presenter.LichHopCuaSoChuTriPresenter;
import com.vpdt.vpdt.presenter.LichHopCuaSoChuTriView;
import com.vpdt.vpdt.presenter.impl.LichHopCuaSoChuTriPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterLichHopSoChuTri;
import com.vpdt.vpdt.ui.adapter.AdapterTuan;
import com.vpdt.vpdt.ui.fragment.XuLyGiayMoi.XemLichCongTacFragment;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LichHopCuaSoChuTriFragment extends BaseFragment<LichHopCuaSoChuTriPresenter> implements LichHopCuaSoChuTriView,
        AdapterTuan.OnItemClickListener {

    @BindView(R.id.tvTuan)
    TextView tvTuan;
    @BindView(R.id.rvLichHop)
    RecyclerView rvLichHop;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    RecyclerView rvTuan;
    AlertDialog dialog;
    String NamLamViec;
    AdapterTuan adapterTuan;
    private AdapterLichHopSoChuTri adapterLichHopSoChuTri;
    int week;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_lich_hop_cua_so_chu_tri;
    }

    @Override
    public void initializeComponents(View view) {
        Util.checkConnection(getActivity());
        ButterKnife.bind(this, view);
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        getPresenter().getlichhoplanhdao();
        getPresenter().getAllTuan(NamLamViec);
    }

    @OnClick({R.id.tvTuan, R.id.btnLichHopCuaSoChuTri, R.id.btnBack, R.id.rlLichHop, R.id.vlhcsct, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.tvTuan:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflaterTuan = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewTuan = inflaterTuan.inflate(R.layout.dialog_tuan, null);
                builder.setView(viewTuan);
                dialog = builder.create();
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
                layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                rvTuan = viewTuan.findViewById(R.id.rcTuan);
                rvTuan.setLayoutManager(layoutManager1);
                rvTuan.setAdapter(adapterTuan);
                adapterTuan.notifyDataSetChanged();
                dialog.show();
                break;
            case R.id.btnLichHopCuaSoChuTri:
                XemLichCongTacFragment fragment2 = new XemLichCongTacFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (this.getActivity().getClass().getSimpleName().equals(("XuLyGiayMoiActivity"))) {
                    fragmentTransaction.replace(R.id.fl, fragment2);
                } else {
                    fragmentTransaction.replace(R.id.fl, fragment2);
                }
                fragmentTransaction.addToBackStack("XemLichCongTacFragment");
                fragmentTransaction.commit();
                break;
            case R.id.rlLichHop:
                break;
        }
    }

    @Override
    public Context gContext() {

        return getActivity();
    }

    @Override
    public void onGetDataSuccess(DetailLichHop detailLichHop) {
        adapterLichHopSoChuTri = new AdapterLichHopSoChuTri(getActivity(), (ArrayList<ItemLichHop>) detailLichHop.getItems());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvLichHop.setLayoutManager(layoutManager);
        rvLichHop.setAdapter(adapterLichHopSoChuTri);
        adapterLichHopSoChuTri.notifyDataSetChanged();
        tvTuan.setText(String.valueOf(detailLichHop.getNgayBatDau() + "-" + detailLichHop.getNgayKetThuc()));
    }

    @Override
    public void onGetTuanSuccess(ArrayList<String> stringArrayList) {
        adapterTuan = new AdapterTuan(getActivity(), stringArrayList, this);
    }

    @Override
    public LichHopCuaSoChuTriPresenter createPresenter() {
        return new LichHopCuaSoChuTriPresenterImpl(this);
    }

    @Override
    public void onItemClick(String s, int position) {
        week = (position + 1);
        tvTuan.setText("Tuần: " + (position + 1) + " ( " + s + " )");
        dialog.dismiss();
    }
}
