package com.ldy.common.base;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ldy.common.base.activityjumpinterceptor.ActivityJumpInterceptor;
import com.ldy.common.base.activityjumpinterceptor.ActivityJumpInterceptorControl;

/**
 * Created by ldy on 2017/6/21.
 */

public class BaseActivity extends AppCompatActivity {

    ActivityJumpInterceptor interceptor = ActivityJumpInterceptorControl.instance();

    @Override
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityJumpInterceptor.StartActivityData data = interceptor
                    .startActivityForResult(this, new ActivityJumpInterceptor.StartActivityData(
                            intent, requestCode, options));
            if (data != null) {
                super.startActivityForResult(data.intent, data.requestCode, data.options);
            }
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        ActivityJumpInterceptor.StartActivityData data = interceptor
                .startActivityForResult(this, new ActivityJumpInterceptor.StartActivityData(
                        intent, requestCode, null));
        if (data != null) {
            super.startActivityForResult(data.intent, data.requestCode);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ActivityJumpInterceptor.OnActivityResultData resultData = interceptor
                .onActivityResult(this, new ActivityJumpInterceptor.OnActivityResultData(
                        requestCode, resultCode, data));
        if (resultData != null) {
            super.onActivityResult(resultData.requestCode, resultData.resultCode, resultData.data);
        }
    }
}
