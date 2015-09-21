package com.lsyiverson.demo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import com.lsyiverson.demo.R;
import com.lsyiverson.demo.databinding.MainBinding;
import com.lsyiverson.demo.ui.viewmodel.MainViewModel;

public class MainActivity extends Activity {

    private MainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setMainVM(new MainViewModel());

        mainBinding.mobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.equals(mainBinding.getMainVM().getMobileNumber(), s.toString())) {
                    mainBinding.getMainVM().setMobileNumber(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                mainBinding.mobileNumber.setSelection(s.length());
            }
        });
    }
}
