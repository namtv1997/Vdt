package com.vpdt.vpdt.ui.fragment.VanBanDi;

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
import com.vpdt.vpdt.model.DataVanBanDi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.VanBanTrinhKyPresenter;
import com.vpdt.vpdt.presenter.VanBanTrinhKyView;
import com.vpdt.vpdt.presenter.impl.VanBanTrinhKyPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.NDVBVanBanTrinhKyActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.TTVBVanBanTrinhKyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuKy;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VanBanTrinhKyFragment extends BaseFragment<VanBanTrinhKyPresenter> implements VanBanTrinhKyView,
        AdapterTrinhTuKy.OnItemClickListener,
        AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerviewGiayMoiLanhDaoDaChiDao)
    RecyclerView recyclerviewGiayMoiLanhDaoDaChiDao;
    @BindView(R.id.btnNamLamViecGiayMoiLanhDaoDaChiDao)
    Button btnNamLamViecGiayMoiLanhDaoDaChiDao;
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
    boolean click = false;

    boolean isVbTrinhky;
    boolean isVbDaTraLai;
    boolean isVbDaKy;

    private EndlessRecyclerViewScrollListener scrollListener;
    private AdapterTrinhTuKy listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_van_ban_trinh_ky;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        isVbTrinhky = true;
        isVbDaTraLai = false;
        isVbDaKy = false;
        //1 : Văn bản trình ký | 2: Văn bản đã trả lại | 3 : Văn bản đã ký
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).checkFragment(this);
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViecGiayMoiLanhDaoDaChiDao.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        if (isVbTrinhky) {
            getPresenter().getallvanban(NamLamViec, 1, true);
        } else if (isVbDaTraLai) {
            getPresenter().getallvanban(NamLamViec, 2, true);
        } else if (isVbDaKy) {
            getPresenter().getallvanban(NamLamViec, 3, true);
        }

        listAdapter = new AdapterTrinhTuKy(getActivity(), getPresenter().dataVanBanDiArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewGiayMoiLanhDaoDaChiDao.setLayoutManager(layoutManager);
        recyclerviewGiayMoiLanhDaoDaChiDao.setAdapter(listAdapter);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (isVbTrinhky) {
                    getPresenter().getallvanban(NamLamViec, 1, false);
                } else if (isVbDaTraLai) {
                    getPresenter().getallvanban(NamLamViec, 2, false);

                } else if (isVbDaKy) {
                    getPresenter().getallvanban(NamLamViec, 3, false);
                }

            }
        };
        recyclerviewGiayMoiLanhDaoDaChiDao.addOnScrollListener(scrollListener);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isVbTrinhky) {
                    getPresenter().getallvanban(NamLamViec, 1, true);
                } else if (isVbDaTraLai) {
                    getPresenter().getallvanban(NamLamViec, 2, true);
                } else if (isVbDaKy) {
                    getPresenter().getallvanban(NamLamViec, 3, true);
                }
            }
        });
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        if (isVbTrinhky) {
            getPresenter().countvanban(NamLamViec, 1);
        } else if (isVbDaTraLai) {
            getPresenter().countvanban(NamLamViec, 2);
        } else if (isVbDaKy) {
            getPresenter().countvanban(NamLamViec, 3);
        }
    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerviewGiayMoiLanhDaoDaChiDao.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerviewGiayMoiLanhDaoDaChiDao.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public VanBanTrinhKyPresenter createPresenter() {
        return new VanBanTrinhKyPresenterImpl(this);
    }

    @OnClick({R.id.btnNamLamViecGiayMoiLanhDaoDaChiDao, R.id.btnBackGiayMoiLanhDaoDaChiDao, R.id.btnVanBanTrinhKy,
            R.id.btnVanBanDaTralai, R.id.btnVanBanDaKy, R.id.vvbtk, R.id.lnvbbtk, R.id.vbtk, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecGiayMoiLanhDaoDaChiDao:
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
            case R.id.btnBackGiayMoiLanhDaoDaChiDao:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnVanBanTrinhKy:
                isVbTrinhky = true;
                getPresenter().getallvanban(NamLamViec, 1, true);
                isVbDaKy = false;
                isVbDaTraLai = false;
                break;
            case R.id.btnVanBanDaTralai:
                isVbDaTraLai = true;
                isVbDaKy = false;
                isVbTrinhky = false;
                getPresenter().getallvanban(NamLamViec, 2, true);
                break;
            case R.id.btnVanBanDaKy:
                isVbDaKy = true;
                isVbDaTraLai = false;
                isVbTrinhky = false;
                getPresenter().getallvanban(NamLamViec, 3, true);
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecGiayMoiLanhDaoDaChiDao.setText("Năm làm việc: " + integer + " ");
        if (isVbTrinhky) {
            getPresenter().getallvanban(String.valueOf(integer), 1, true);
        } else if (isVbDaTraLai) {
            getPresenter().getallvanban(String.valueOf(integer), 2, true);
        } else if (isVbDaKy) {
            getPresenter().getallvanban(String.valueOf(integer), 3, true);
        }
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(DataVanBanDi dataVanBanDi) {
        if (dataVanBanDi.getDuongDanFile().isEmpty() || dataVanBanDi.getDuongDanFile() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataVanBanDi.getDuongDanFile()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(DataVanBanDi dataVanBanDi) {
        if (!click) {
            Intent intent1 = new Intent(getActivity(), NDVBVanBanTrinhKyActivity.class);
            intent1.putExtra("ID_VANBAN_DI", dataVanBanDi.getId());
            startActivity(intent1);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(DataVanBanDi dataVanBanDi) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBVanBanTrinhKyActivity.class);
            intent.putExtra("ID_VANBAN_DI", dataVanBanDi.getId());
            startActivity(intent);
            click = true;
        }

    }
}