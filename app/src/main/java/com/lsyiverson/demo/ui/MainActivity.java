package com.lsyiverson.demo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

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
    }
}
