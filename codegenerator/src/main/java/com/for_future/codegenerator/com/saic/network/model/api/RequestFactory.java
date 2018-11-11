package com.saic.network.model.api;

// THIS CODE IS GENERATED BY unknown, DO NOT EDIT

import com.saic.network.demo.model.request.LoginRequest;
import com.saic.network.demo.constant.AppUrl;
import com.saic.network.demo.model.response.R_CommonResource;
import com.saic.network.demo.model.response.R_DriverActivate;
import com.saic.network.demo.model.response.R_Login;
import com.saic.network.demo.model.response.R_ModeStatus;
import com.saic.network.demo.model.response.R_UploadFile;
import com.saic.network.http.SCHttpCallback;
import com.saic.network.http.SCHttpRequest;
import com.saic.network.http.SCRequestAccessory;
import com.saic.network.http.SCRequestMethod;
import com.saic.network.http.SCRequestWrapper;
import com.saic.network.http.model.SCBaseResponse;
import java.io.File;

import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
public final class RequestFactory {

    public Disposable phoneLogin(LoginRequest loginRequest, SCRequestAccessory requestAccessory, SCHttpCallback<com.saic.network.model.response.LoginResponse> httpCallback) {
        SCRequestWrapper requestWrapper = new SCRequestWrapper((AppUrl.LOGIN_URL, SCRequestMethod.POST);
        requestWrapper.setRequestEntity(saicNetApiBean.request.value);
        SCHttpRequest request = new SCHttpRequest();
        request.addAccessory(requestAccessory);
        return request.sendRequest(requestWrapper, httpCallback)
               .subscribe();
        }


}