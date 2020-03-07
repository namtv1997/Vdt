package com.vpdt.vpdt.ui.fragment.QuanLyCanBo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vpdt.vpdt.R;

public class DanhGiaPheDuyetKetQuaPhanLoaiThangCuaSoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_danh_gia_phe_duyet_ket_qua_phan_loai_thang_cua_so, container, false);
        return view;
    }
}