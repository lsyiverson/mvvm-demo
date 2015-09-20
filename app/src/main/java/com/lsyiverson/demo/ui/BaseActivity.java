package com.lsyiverson.demo.ui;

import android.app.Activity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
