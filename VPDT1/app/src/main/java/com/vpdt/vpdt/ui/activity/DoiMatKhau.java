package com.vpdt.vpdt.ui.activity;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.presenter.DoiMatKhauPresenter;
import com.vpdt.vpdt.presenter.DoiMatKhauView;
import com.vpdt.vpdt.presenter.impl.DoiMatKhauPresenterImpl;
import com.vpdt.vpdt.util.PrefUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoiMatKhau extends BaseActivity<DoiMatKhauPresenter> implements DoiMatKhauView {
    @BindView(R.id.etMatKhauCu)
    EditText etMatKhauCu;
    @BindView(R.id.etMatKhauMoi)
    EditText etMatKhauMoi;
    @BindView(R.id.etXacNhanMk)
    EditText etXacNhanMk;

    @BindView(R.id.tvSaiXacNhanMatKhau)
    TextView tvSaiXacNhanMatKhau;
    @BindView(R.id.tvSaiMatKhauCu)
    TextView tvSaiMatKhauCu;

    @BindView(R.id.btnHienMKCu)
    Button btnHienMKCu;
    @BindView(R.id.btnHienMKMoi)
    Button btnHienMKMoi;
    @BindView(R.id.btnXacNhanMk)
    Button btnXacNhanMk;
    @BindView(R.id.btDoiMatKhau)
    Button btDoiMatKhau;

    private int passwordNotVisible = 1;
    private int passwordNotVisible1 = 1;
    private int passwordNotVisible2 = 1;

    @Override
    public int getContentViewId() {
        return R.layout.activity_doi_mat_khau;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        etMatKhauCu.addTextChangedListener(loginTextWatcher);
        etMatKhauMoi.addTextChangedListener(loginTextWatcher);
        etXacNhanMk.addTextChangedListener(loginTextWatcher);
    }

    @OnClick({R.id.btnHienMKCu, R.id.btnHienMKMoi, R.id.btnXacNhanMk, R.id.imvBack, R.id.btDoiMatKhau, R.id.vDoiMatKhau})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHienMKCu:
                if (passwordNotVisible == 1) {
                    etMatKhauCu.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible = 0;
                } else {
                    etMatKhauCu.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 1;
                }
                etMatKhauCu.setSelection(etMatKhauCu.length());
                break;
            case R.id.btnHienMKMoi:
                if (passwordNotVisible1 == 1) {
                    etMatKhauMoi.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible1 = 0;
                } else {
                    etMatKhauMoi.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible1 = 1;
                }
                etMatKhauMoi.setSelection(etMatKhauMoi.length());
                break;
            case R.id.btnXacNhanMk:
                if (passwordNotVisible2 == 1) {
                    etXacNhanMk.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible2 = 0;
                } else {
                    etXacNhanMk.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible2 = 1;
                }
                etXacNhanMk.setSelection(etXacNhanMk.length());
                break;
            case R.id.imvBack:
                finish();
                break;
            case R.id.btDoiMatKhau:
                String mkcu = etMatKhauCu.getText().toString();
                String mkmoi = etMatKhauMoi.getText().toString();
                String xnmk = etXacNhanMk.getText().toString();
                if (!mkmoi.equals(xnmk)) {
                    tvSaiXacNhanMatKhau.setVisibility(View.VISIBLE);
                } else {
                    getPresenter().doiMatKhau(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""),
                            mkcu, xnmk);
                }
                break;
            case R.id.vDoiMatKhau:
                closeKeyboard();
                break;
        }
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String MKCu = etMatKhauCu.getText().toString().trim();
            String MKMoi = etMatKhauMoi.getText().toString().trim();
            String XacNhanMk = etXacNhanMk.getText().toString().trim();
            btDoiMatKhau.setEnabled(!MKCu.isEmpty() && !MKMoi.isEmpty() && !XacNhanMk.isEmpty());
            btnHienMKCu.setEnabled(!MKCu.isEmpty());
            btnHienMKMoi.setEnabled(!MKMoi.isEmpty());
            btnXacNhanMk.setEnabled(!XacNhanMk.isEmpty());
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

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onFailure() {
        tvSaiMatKhauCu.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
        getPresenter().logOut();
    }

    @Override
    public void onLogOutSuccess() {
        startActivity(LoginActivity.getCallingIntent(this));
    }

    @Override
    public DoiMatKhauPresenter createPresenter() {
        return new DoiMatKhauPresenterImpl(this);
    }
}
