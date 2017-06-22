package com.ldy.main.receiver;

import android.content.Context;

import com.ldy.common.receiver.ModuleInitReceiver;
import com.ldy.main.common.facade.MainFacadeRepository;
import com.ldy.main.facadeimpl.MainFacadeImpl;

public class MainInitReceiver extends ModuleInitReceiver {

    @Override
    protected void init(Context context) {
        MainFacadeRepository.instance().setFacade(MainFacadeImpl.instance());
    }

    @Override
    protected void initFinish(Context context) {

    }
}
