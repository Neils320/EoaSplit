package com.ldy.setting.receiver;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.ldy.common.base.ComparableWrapper;
import com.ldy.common.factor.Factory;
import com.ldy.common.modulecommunication.event.EventControl;
import com.ldy.common.receiver.ModuleInitReceiver;
import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.event.GetMainPageEvent;
import com.ldy.setting.R;
import com.ldy.setting.SettingFragment;

import org.greenrobot.eventbus.Subscribe;

public class SettingInitReceiver extends ModuleInitReceiver {

    @Override
    public void init(Context context) {
        Log.d("SettingInitReceiver", "settingInit");
        EventControl.instance().register(this);
    }

    @Override
    public void initFinish(Context context) {

    }

    @Subscribe
    public void initMainPage(GetMainPageEvent event) {
        event.add(ComparableWrapper.buildSecond(
                new MainPageEntity(
                        new Factory<Fragment>() {
                            @Override
                            public Fragment build() {
                                return new SettingFragment();
                            }
                        },
                        R.string.setting_mine,
                        R.drawable.setting_ic_mine_normal,
                        R.drawable.setting_ic_mine_selected
                )
        ));

    }


}
