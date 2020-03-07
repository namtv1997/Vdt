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
import com.vpdt.vpdt.model.DetailVanBanDiTongThe;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DanhSachVanBanCuaSoPresenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanCuaSoView;
import com.vpdt.vpdt.presenter.impl.DanhSachVanBanCuaSoPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.NDVBDSVBCuaSoActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.TTVBVanBanXemDeBietActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachVanbanCuaSo;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DanhSachVanBanCuaSoFragment extends BaseFragment<DanhSachVanBanCuaSoPresenter> implements DanhSachVanBanCuaSoView,
        AdapterDanhSachVanbanCuaSo.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.tvTSVB)
    TextView tvTSVB;
    @BindView(R.id.TenVB)
    TextView TenVB;

    String NamLamViec;
    boolean isDaNhap = false;
    boolean isDaGuiMail = false;
    boolean isChuaGuimail = false;
    AdapterDanhSachVanbanCuaSo adapterDanhSachVanbanCuaSo;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog1;
    int year;
    boolean click = false;

    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_van_ban_cua_so;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        TenVB.setText("Văn bản đã nhập");
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).checkFragment(this);
        click = false;
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getContext(), integerArrayList, this);
        }
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        if (TenVB.getText().toString().equals("Văn bản đã nhập")) {
            getPresenter().getallvbditongthe(0, 0, NamLamViec, true);
        } else if (TenVB.getText().toString().equals("Đã gửi mail")) {
            getPresenter().getallvbditongthe(1, 0, NamLamViec, true);
        } else if (TenVB.getText().toString().equals("Chưa gửi mail")) {
            getPresenter().getallvbditongthe(2, 0, NamLamViec, true);
        }
        adapterDanhSachVanbanCuaSo = new AdapterDanhSachVanbanCuaSo(getContext(), getPresenter().detailVanBanDiTongTheArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachVanbanCuaSo);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (TenVB.getText().toString().equals("Văn bản đã nhập")) {
                    getPresenter().getallvbditongthe(0, 0, NamLamViec, false);
                } else if (TenVB.getText().toString().equals("Đã gửi mail")) {
                    getPresenter().getallvbditongthe(1, 0, NamLamViec, false);
                } else if (TenVB.getText().toString().equals("Chưa gửi mail")) {
                    getPresenter().getallvbditongthe(2, 0, NamLamViec, false);
                }
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (TenVB.getText().toString().equals("Văn bản đã nhập")) {
                    getPresenter().getallvbditongthe(0, 0, NamLamViec, true);
                } else if (TenVB.getText().toString().equals("Đã gửi mail")) {
                    getPresenter().getallvbditongthe(1, 0, NamLamViec, true);
                } else if (TenVB.getText().toString().equals("Chưa gửi mail")) {
                    getPresenter().getallvbditongthe(2, 0, NamLamViec, true);
                }
            }
        });
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
    public void onGetDataSuccess() {
        adapterDanhSachVanbanCuaSo.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
        if (TenVB.getText().toString().equals("Văn bản đã nhập")) {
            getPresenter().countvbditongthe(0, 0, NamLamViec);
        } else if (TenVB.getText().toString().equals("Đã gửi mail")) {
            getPresenter().countvbditongthe(0, 1, NamLamViec);
        } else if (TenVB.getText().toString().equals("Chưa gửi mail")) {
            getPresenter().countvbditongthe(0, 2, NamLamViec);
        }
    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0) {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public DanhSachVanBanCuaSoPresenter createPresenter() {
        return new DanhSachVanBanCuaSoPresenterImpl(this);
    }


    @OnClick({R.id.TenVB, R.id.btnBack, R.id.vdsvbcs, R.id.lndsvbcs, R.id.rldsvbcs, R.id.btnNamLamViec, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.TenVB:
                AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.list_item_van_ban_cua_so, null);
                builder.setView(view1);
                final AlertDialog dialog = builder.create();
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView btnTatCa = view1.findViewById(R.id.btnTatCa);
                TextView btnVanbanMoiNhap = view1.findViewById(R.id.btnVanbanMoiNhap);
                TextView btnDaGiaiQuyet = view1.findViewById(R.id.btnDaGiaiQuyet);

                btnTatCa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isDaNhap = true;
                        getPresenter().getallvbditongthe(0, 0, NamLamViec, true);
                        TenVB.setText("Văn bản đã nhập");
                        dialog.dismiss();
                    }
                });
                btnVanbanMoiNhap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isDaGuiMail = true;
                        getPresenter().getallvbditongthe(1, 0, NamLamViec, true);
                        TenVB.setText("Đã gửi mail");
                        dialog.dismiss();
                    }
                });
                btnDaGiaiQuyet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isChuaGuimail = true;
                        getPresenter().getallvbditongthe(2, 0, NamLamViec, true);
                        TenVB.setText("Chưa gửi mail");
                        dialog.dismiss();
                    }
                });

                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;

            case R.id.btnNamLamViec:
                AlertDialog.Builder builderNamLamViec = new AlertDialog.Builder(getContext());
                LayoutInflater inflaterNamLamViec = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNamLamViec = inflaterNamLamViec.inflate(R.layout.recyclerview_nam_selected, null);
                builderNamLamViec.setView(viewNamLamViec);
                dialog1 = builderNamLamViec.create();
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvSelectNam = viewNamLamViec.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        if (TenVB.getText().toString().equals("Văn bản đã nhập")) {
            getPresenter().getallvbditongthe(0, 0, String.valueOf(integer), true);
        } else if (TenVB.getText().toString().equals("Đã gửi mail")) {
            getPresenter().getallvbditongthe(1, 0, String.valueOf(integer), true);
        } else if (TenVB.getText().toString().equals("Chưa gửi mail")) {
            getPresenter().getallvbditongthe(2, 0, String.valueOf(integer), true);
        }
        PrefUtil.saveString(getContext(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        dialog1.dismiss();
    }

    @Override
    public void onItemClickXemFile(DetailVanBanDiTongThe detailVanBanDiTongThe) {
        if (detailVanBanDiTongThe.getTy().getDuongdan().isEmpty() || detailVanBanDiTongThe.getTy().getDuongdan() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailVanBanDiTongThe.getTy().getDuongdan()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(DetailVanBanDiTongThe detailVanBanDiTongThe) {
        if (!click) {
            Intent i = new Intent(getContext(), NDVBDSVBCuaSoActivity.class);
            i.putExtra("detailVanBanDiTongThe", detailVanBanDiTongThe);
            startActivity(i);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(DetailVanBanDiTongThe detailVanBanDiTongThe) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBVanBanXemDeBietActivity.class);
            intent.putExtra("ID_VANBAN_XEM_DE_BIET", detailVanBanDiTongThe.getPKIMaVBDi());
            startActivity(intent);
            click = true;
        }

    }
}