package com.helloworldproject;

import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class PageModule extends ReactContextBaseJavaModule {

    public PageModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "PageModule";
    }

    @ReactMethod
    public void startMyActivity() {
        getCurrentActivity().startActivity(new Intent(getCurrentActivity(), MyActivity.class));
    }
}
