package com.vpdt.vpdt.ui.fragment.XuLyGiayMoi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.vpdt.vpdt.model.BaoCaoKetQuaDaGuiDi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.BaoCaoKetQuaCuocHopDaGuiDiView;
import com.vpdt.vpdt.presenter.BaoCaoKetQuaCuocHopDaGuiDi_Presenter;
import com.vpdt.vpdt.presenter.impl.BaoCaoKetQuaCuocHopDaGuiDi_PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.NDVBBaoCaoKetQuaCuocHopDaGuiDiActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.TTVBBaoCaoCuocHopChoPheDuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.Adapter_BaoCaoKetQuaCuocHopDaGuiDi;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaoCaoKetQuaCuocHopDaGuiDiFragment extends BaseFragment<BaoCaoKetQuaCuocHopDaGuiDi_Presenter> implements BaoCaoKetQuaCuocHopDaGuiDiView,
        Adapter_BaoCaoKetQuaCuocHopDaGuiDi.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViecBCKQCHDGD)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTongSoVanBan)
    TextView tvTSVB;
    boolean click = false;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;

    private EndlessRecyclerViewScrollListener scrollListener;
    private Adapter_BaoCaoKetQuaCuocHopDaGuiDi listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_bao_cao_ket_qua_cuoc_hop_da_gui_di;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getallbaocaosoanthaodagui(NamLamViec, true);

        listAdapter = new Adapter_BaoCaoKetQuaCuocHopDaGuiDi(getActivity(), getPresenter().baoCaoKetQuaDaGuiDis(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getallbaocaosoanthaodagui(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getallbaocaosoanthaodagui(NamLamViec, false);
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countbaocaosoanthaodagui(NamLamViec);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public BaoCaoKetQuaCuocHopDaGuiDi_Presenter createPresenter() {
        return new BaoCaoKetQuaCuocHopDaGuiDi_PresenterImpl(this);
    }

    @OnClick({R.id.btnNamLamViecBCKQCHDGD, R.id.btnBack, R.id.vbckqdgd, R.id.lnbckqdgd, R.id.rlbckqdgd, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecBCKQCHDGD:
                android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getallbaocaosoanthaodagui(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(BaoCaoKetQuaDaGuiDi baoCaoKetQuaDaGuiDi) {
//        if (baoCaoKetQuaDaGuiDi.getUrlFile().isEmpty()||baoCaoKetQuaDaGuiDi.get()==null) {
//            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
//        } else {
//            try {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(baoCaoKetQuaDaGuiDi.getUrlFile()));
//                startActivity(browserIntent);
//            } catch (Exception e) {
//                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    @Override
    public void onItemClickXuLy(BaoCaoKetQuaDaGuiDi baoCaoKetQuaDaGuiDi) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBBaoCaoKetQuaCuocHopDaGuiDiActivity.class);
            intent.putExtra("ID_VANBANBCKQCHDAGUIDI", baoCaoKetQuaDaGuiDi.getIdVb());
            intent.putExtra("SKH", baoCaoKetQuaDaGuiDi.getSoKyHieu());
            intent.putExtra("SD", baoCaoKetQuaDaGuiDi.getSoDen());
            intent.putExtra("MT", baoCaoKetQuaDaGuiDi.getMota());
            intent.putExtra("NG", baoCaoKetQuaDaGuiDi.getNoiGui());
            intent.putExtra("NN", baoCaoKetQuaDaGuiDi.getNgayPhap());
            startActivity(intent);
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(BaoCaoKetQuaDaGuiDi baoCaoKetQuaDaGuiDi) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
            intent.putExtra("idvb", baoCaoKetQuaDaGuiDi.getIdVb());
            startActivity(intent);
            click = true;
        }

    }
}
