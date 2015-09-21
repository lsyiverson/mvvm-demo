package com.lsyiverson.demo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.lsyiverson.demo.R;
import com.lsyiverson.demo.databinding.MainBinding;
import com.lsyiverson.demo.rest.RestClient;
import com.lsyiverson.demo.rest.service.JuheService;

import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends Activity {

    private JuheService juheService;

    private MainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        juheService = RestClient.getJuheService();
        mainBinding.query.setOnClickListener(this::query);
    }

    private void query(View view) {

        juheService.getMobileAttribute(mainBinding.mobileNumber.getText().toString(), "3cbf0d058323365bc0ddd1f2cb01a770")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mainBinding::setMobileResponse);
    }
}
