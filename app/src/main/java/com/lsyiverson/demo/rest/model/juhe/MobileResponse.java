package com.lsyiverson.demo.rest.model.juhe;

import com.google.gson.annotations.SerializedName;

public class MobileResponse {
    @SerializedName("resultcode")
    private String resultCode;

    private String reason;

    private MobileResult result;

    @SerializedName("error_code")
    private Integer errorCode;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public MobileResult getResult() {
        return result;
    }

    public void setResult(MobileResult result) {
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
