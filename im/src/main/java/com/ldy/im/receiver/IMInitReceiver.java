package com.ldy.im.receiver;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.ldy.common.base.ComparableWrapper;
import com.ldy.common.factor.Factory;
import com.ldy.common.modulecommunication.event.EventControl;
import com.ldy.common.receiver.ModuleInitReceiver;
import com.ldy.im.IMFragment;
import com.ldy.im.config.IMConfig;
import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.event.GetMainPageEvent;

import org.greenrobot.eventbus.Subscribe;

public class IMInitReceiver extends ModuleInitReceiver {

    @Override
    public void init(Context context) {
        Log.d("IMInitReceiver", "imInit:"+this);
        EventControl.instance().register(this);
    }

    @Override
    public void initFinish(Context context) {
        Log.d("IMInitReceiver", "imInitFinish:"+this);
    }

    @Subscribe
    public void initMainPage(GetMainPageEvent event) {
        event.add(ComparableWrapper.buildFirst(
                new MainPageEntity(
                        new Factory<Fragment>() {
                            @Override
                            public Fragment build() {
                                return new IMFragment();
                            }
                        },
                        IMConfig.MAIN_TITLE,
                        IMConfig.MAIN_ICON_NORMAL,
                        IMConfig.MAIN_ICON_SELECT
                )
        ));

    }

}
