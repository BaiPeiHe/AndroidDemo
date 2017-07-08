package com.example.baihe.myapplication.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baihe.myapplication.R;
import com.example.baihe.myapplication.view.fragment.BaseFragment;

/**
 * Created by baihe on 2017/7/6.
 */

public class HomeFragment extends BaseFragment {

    private View mContentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {

        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);

        initView();
        return mContentView;
    }

    private void initView(){

    }

}
