package com.ldy.im;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldy.common.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class IMFragment extends BaseFragment {


    public IMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.im_fragment_im, container, false);
    }

}
