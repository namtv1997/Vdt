package com.vpdt.vpdt.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.presenter.LoginPresenter;
import com.vpdt.vpdt.presenter.impl.LoginPresenterImpl;
import com.vpdt.vpdt.presenter.LoginView;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView,
        AdapterNamLamViec.OnItemClickListenerNamLamViec {
    @BindView(R.id.etMatKhau)
    EditText etMatKhau;
    @BindView(R.id.etTaiKhoan)
    EditText etTaiKhoan;

    @BindView(R.id.btnHienMK)
    Button btnHienMK;
    @BindView(R.id.btnDangnhap)
    Button btnDangNhap;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.tvError)
    TextView tvError;
    private int passwordNotVisible = 1;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);

        etMatKhau.addTextChangedListener(loginTextWatcher);
        etTaiKhoan.addTextChangedListener(loginTextWatcher);

        btnHienMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText paswword = findViewById(R.id.etMatKhau);
                if (passwordNotVisible == 1) {
                    paswword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible = 0;
                } else {
                    paswword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 1;
                }
                paswword.setSelection(paswword.length());
            }
        });

        LinearLayout linearLayout = findViewById(R.id.vvv);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(this, integerArrayList, this);
        }
        btnNamLamViec.setText("Năm làm việc: " + year);
        PrefUtil.saveString(LoginActivity.this, Key.NAM_LAM_VIEC, String.valueOf(year));
    }

    @Override
    protected void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onFailure(String s) {
        tvError.setText(s);
        tvError.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoginSuccess() {
        startActivity(MainActivity.getCallingIntent(this));
        LoginActivity.this.finish();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.btnDangnhap})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnDangnhap:
                Util.checkConnection(this);
                String username = etTaiKhoan.getText().toString();
                String password = etMatKhau.getText().toString();
                getPresenter().login(username, password, Key.NAM_LAM_VIEC);
                break;

        }
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String tk = etTaiKhoan.getText().toString().trim();
            String mk = etMatKhau.getText().toString().trim();
            btnDangNhap.setEnabled(!tk.isEmpty() && !mk.isEmpty());
            btnHienMK.setEnabled(!mk.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showDialogListView(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view1 = inflater.inflate(R.layout.recyclerview_nam_selected, null);
        builder.setView(view1);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvSelectNam = view1.findViewById(R.id.rvSelectNam);
        rvSelectNam.setLayoutManager(layoutManager);
        rvSelectNam.setAdapter(adapterNamLamViec);
        adapterNamLamViec.notifyDataSetChanged();

    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer);
        PrefUtil.saveString(LoginActivity.this, Key.NAM_LAM_VIEC, String.valueOf(integer));
        dialog.dismiss();
    }
}


