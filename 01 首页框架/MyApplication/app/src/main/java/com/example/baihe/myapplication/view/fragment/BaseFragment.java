package com.example.baihe.myapplication.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;

/**
 * Created by baihe on 2017/7/6.
 */

public class BaseFragment extends Fragment {

    protected Activity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
