package com.lsyiverson.demo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Selection;

import com.jakewharton.rxbinding.view.RxView;
import com.lsyiverson.demo.R;
import com.lsyiverson.demo.databinding.MainBinding;
import com.lsyiverson.demo.ui.viewmodel.MainViewModel;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

public class MainActivity extends Activity {

    private MainBinding mainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel();

        mainBinding.setMainVM(mainViewModel);

        RxView.clicks(mainBinding.queryButton)
                .doOnNext(o -> {
                    String mobileNumber = mainBinding.mobileNumber.getText().toString();
                    mainViewModel.setMobileNumber(mobileNumber);
                    Selection.setSelection(mainBinding.mobileNumber.getText(), mobileNumber.length());
                })
                .subscribe(o -> {
                    mainViewModel.query();
                });
    }
}
