package com.vpdt.vpdt.ui.fragment.XuLyVanBan;

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
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBDSVBDaChiDao2Activity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVB_DSVB_DaChiDaoActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBCongViecPhoiHopChoXuLyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.Adapter_DSVB_DaChiDao;
import com.vpdt.vpdt.model.DSVB_DaChiDao;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.presenter.DSVBDaChiDaoView;
import com.vpdt.vpdt.presenter.DSVB_DaChiDao_Presenter;
import com.vpdt.vpdt.presenter.impl.DSVB_DaChiDao_PresenterImpl;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DSVB_DaChiDaoFragment extends BaseFragment<DSVB_DaChiDao_Presenter> implements DSVBDaChiDaoView, Adapter_DSVB_DaChiDao.OnItemClickListener,
        AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerviewDSVBDaChiDao)
    RecyclerView recyclerview;

    @BindView(R.id.btnNamLamViecDSVBDaChiDao)
    Button btnNamLamViecDSVBDaChiDao;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;
    @BindView(R.id.TenNDVBDSVBCongTacDangChoLDXL)
    TextView TenNDVBDSVBCongTacDangChoLDXL;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    private EndlessRecyclerViewScrollListener scrollListener;
    private Adapter_DSVB_DaChiDao listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dsvb__da_chi_dao;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        TenNDVBDSVBCongTacDangChoLDXL.setText("Văn bản lãnh đạo đã chỉ đạo");
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViecDSVBDaChiDao.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn Bản STC Phối Hợp đã chỉ đạo") {
            getPresenter().getallvbstcphoihopdachidao(NamLamViec, true);
        } else if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn bản lãnh đạo đã chỉ đạo") {
            getPresenter().getallvblanhdaodachidao(NamLamViec, true);
        }
        listAdapter = new Adapter_DSVB_DaChiDao(getActivity(), getPresenter().dsvbDaChiDao(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn Bản STC Phối Hợp đã chỉ đạo") {
                    getPresenter().getallvbstcphoihopdachidao(NamLamViec, true);
                } else if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn bản lãnh đạo đã chỉ đạo") {
                    getPresenter().getallvblanhdaodachidao(NamLamViec, true);
                }
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn Bản STC Phối Hợp đã chỉ đạo") {
                    getPresenter().getallvbstcphoihopdachidao(NamLamViec, false);
                } else if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn bản lãnh đạo đã chỉ đạo") {
                    getPresenter().getallvblanhdaodachidao(NamLamViec, false);
                }
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
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn Bản STC Phối Hợp đã chỉ đạo") {
            getPresenter().countvbstcphoihopdachidao(NamLamViec);
        } else if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn bản lãnh đạo đã chỉ đạo") {
            getPresenter().countvblanhdaodachidao(NamLamViec);
        }
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
    public DSVB_DaChiDao_Presenter createPresenter() {
        return new DSVB_DaChiDao_PresenterImpl(this);
    }

    @OnClick({R.id.btnNamLamViecDSVBDaChiDao, R.id.btnBackDaChiDao, R.id.TenNDVBDSVBCongTacDangChoLDXL,
            R.id.rldcd, R.id.lndcd, R.id.vDSVBDaChiDao, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecDSVBDaChiDao:
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
            case R.id.btnBackDaChiDao:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.TenNDVBDSVBCongTacDangChoLDXL:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view2 = inflater1.inflate(R.layout.list_item_dsvb_dachidao, null);
                builder1.setView(view2);
                dialog = builder1.create();
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView btnbtnVanBanLanhDaoDaChiDao = view2.findViewById(R.id.btnVanBanLanhDaoDaChiDao);
                TextView btnbtnVanBanSTCPhoiHopDaChiDao = view2.findViewById(R.id.btnVanBanSTCPhoiHopDaChiDao);
                btnbtnVanBanLanhDaoDaChiDao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TenNDVBDSVBCongTacDangChoLDXL.setText("Văn bản lãnh đạo đã chỉ đạo");
                        getPresenter().getallvblanhdaodachidao(NamLamViec, true);
                        dialog.dismiss();
                    }
                });
                btnbtnVanBanSTCPhoiHopDaChiDao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TenNDVBDSVBCongTacDangChoLDXL.setText("Văn Bản STC Phối Hợp đã chỉ đạo");
                        getPresenter().getallvbstcphoihopdachidao(NamLamViec, true);
                        dialog.dismiss();
                    }
                });
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecDSVBDaChiDao.setText("Năm làm việc: " + integer + " ");
        if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn Bản STC Phối Hợp đã chỉ đạo") {
            getPresenter().getallvbstcphoihopdachidao(String.valueOf(integer), true);
        } else if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn bản lãnh đạo đã chỉ đạo") {
            getPresenter().getallvblanhdaodachidao(String.valueOf(integer), true);
        }
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(DSVB_DaChiDao dsvbDaChiDao) {
        try {
            if (dsvbDaChiDao.getTepDinhKems().size() == 0) {
                Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
            } else if (dsvbDaChiDao.getTepDinhKems().size() == 1) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsvbDaChiDao.getTepDinhKems().get(0).getDuongDan()));
                startActivity(browserIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsvbDaChiDao.getTepDinhKems().get(dsvbDaChiDao.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXuLy(DSVB_DaChiDao dsvbDaChiDao) {
        if (!click) {
            if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn Bản STC Phối Hợp đã chỉ đạo") {
                Intent intent1 = new Intent(getActivity(), NDVBDSVBDaChiDao2Activity.class);
                intent1.putExtra("ID_VANBAN_STC", dsvbDaChiDao.getIdVanBan());
                startActivity(intent1);
            } else if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn bản lãnh đạo đã chỉ đạo") {
                Intent intent = new Intent(getActivity(), NDVB_DSVB_DaChiDaoActivity.class);
                intent.putExtra("ID_VANBAN", dsvbDaChiDao.getIdVanBan());
                startActivity(intent);
            }
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(DSVB_DaChiDao dsvbDaChiDao) {
        if (!click) {
            if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn Bản STC Phối Hợp đã chỉ đạo") {
                Intent intent1 = new Intent(getActivity(), TTVBCongViecPhoiHopChoXuLyActivity.class);
                intent1.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", dsvbDaChiDao.getIdVanBan());
                startActivity(intent1);
            } else if (TenNDVBDSVBCongTacDangChoLDXL.getText() == "Văn bản lãnh đạo đã chỉ đạo") {
                Intent intent1 = new Intent(getActivity(), TTVBCongViecPhoiHopChoXuLyActivity.class);
                intent1.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", dsvbDaChiDao.getIdVanBan());
                startActivity(intent1);
            }
            click = true;
        }
    }
}
