package com.lsyiverson.demo.ui.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.lsyiverson.demo.BR;
import com.lsyiverson.demo.rest.RestClient;
import com.lsyiverson.demo.rest.model.juhe.MobileResult;
import com.lsyiverson.demo.rest.service.JuheService;

import rx.android.schedulers.AndroidSchedulers;

public class MainViewModel extends BaseObservable {
    private MobileResult result;
    private String mobileNumber;

    private JuheService juheService;

    public MainViewModel() {
        juheService = RestClient.getJuheService();
    }

    @Bindable
    public MobileResult getResult() {
        return result;
    }

    public void setResult(MobileResult result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    @Bindable
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        notifyPropertyChanged(BR.mobileNumber);
    }

    public void onQuery(View view) {
        juheService.getMobileAttribute(mobileNumber, "3cbf0d058323365bc0ddd1f2cb01a770")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> setResult(response.getResult()));
    }
}
