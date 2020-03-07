package com.vpdt.vpdt.ui.fragment.QuanLyDauViec;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.DSKienNghiHDND;
import com.vpdt.vpdt.model.File;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DSKienNghiHDNDView;
import com.vpdt.vpdt.presenter.DSKienNghiHDND_Presenter;
import com.vpdt.vpdt.presenter.impl.DSKienNghiHDND_PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterXemFile;
import com.vpdt.vpdt.ui.adapter.Adapter_QuanLyDauViec;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DSTaiLieuHopHDNDCuaTongHopFragment extends BaseFragment<DSKienNghiHDND_Presenter> implements DSKienNghiHDNDView,
        Adapter_QuanLyDauViec.OnItemClickListener, AdapterXemFile.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;

    private EndlessRecyclerViewScrollListener scrollListener;
    private Adapter_QuanLyDauViec listAdapter;
    private AdapterXemFile adapterXemFile;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_ds_tai_lieu_hop_hdnd_cua_tong_hop;
    }

    @Override
    public void initializeComponents(View view) {
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        ButterKnife.bind(this, view);

        listAdapter = new Adapter_QuanLyDauViec(getActivity(), getPresenter().dsKienNghiHDNDS(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getalltaileuhop(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getalltaileuhop(NamLamViec, false);
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getalltaileuhop(NamLamViec, true);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countalltaileuhop(NamLamViec);

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
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public DSKienNghiHDND_Presenter createPresenter() {
        return new DSKienNghiHDND_PresenterImpl(this);
    }

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.rldstlh, R.id.vDSTLH, R.id.lnDSTLH, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViec:
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
        getPresenter().getalltaileuhop(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickFileDinhKem(File file) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(file.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Lỗi hệ thống", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXemFile(DSKienNghiHDND dsKienNghiHDND) {
        if (dsKienNghiHDND.getFiles().size() < 1) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else if (dsKienNghiHDND.getFiles().size() == 1) {
            String dinhkem = String.valueOf(dsKienNghiHDND.getFiles());
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhkem.substring(1, dinhkem.length() - 1)));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        } else {
            String dinhkem = String.valueOf(dsKienNghiHDND.getFiles().indexOf(dsKienNghiHDND.getFiles().size() - 1));
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhkem.substring(1, dinhkem.length() - 1)));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(DSKienNghiHDND dsKienNghiHDND) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view1 = inflater.inflate(R.layout.dialog_ndvb_quan_ly_dau_viec, null);
        builder.setView(view1);
        dialog = builder.create();
        dialog.show();
        TextView tvPhongPhoiHop = view1.findViewById(R.id.tvPhongPhoiHop);
        TextView tvNoiDung = view1.findViewById(R.id.tvNoiDung);
        TextView tvPhuLuc = view1.findViewById(R.id.tvPhuLuc);
        TextView tvPhongChuTri = view1.findViewById(R.id.tvPhongChuTri);
        RecyclerView rcvXemFile = view1.findViewById(R.id.rcvXemFile);
        Button btnDong = view1.findViewById(R.id.btnDong);

        if (String.valueOf(dsKienNghiHDND.getPhongPhohops()).trim() != "null") {
            tvPhongPhoiHop.setText(String.valueOf(dsKienNghiHDND.getPhongPhohops()));
        }
        if (String.valueOf(dsKienNghiHDND.getNoiDung()).trim() != "null") {
            tvNoiDung.setText(String.valueOf(dsKienNghiHDND.getNoiDung()));
        }
        if (String.valueOf(dsKienNghiHDND.getPhuLuc()).trim() != "null") {
            tvPhuLuc.setText(String.valueOf(dsKienNghiHDND.getPhuLuc()));
        }
        if (String.valueOf(dsKienNghiHDND.getPhuLuc()).trim() != "null") {
            tvPhongChuTri.setText(String.valueOf(dsKienNghiHDND.getPhongChutri()));
        }
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        adapterXemFile = new AdapterXemFile(getActivity(), (ArrayList<File>) dsKienNghiHDND.getFiles(), this::onItemClickFileDinhKem);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvXemFile.setLayoutManager(layoutManager);
        rcvXemFile.setAdapter(adapterXemFile);
        adapterXemFile.notifyDataSetChanged();
    }

    @Override
    public void onItemClickXemChiTiet(DSKienNghiHDND dsKienNghiHDND) {

    }
}