package com.example.baihe.myapplication.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.annotation.Nullable;

import com.example.baihe.myapplication.R;
import com.example.baihe.myapplication.activity.base.BaseActivity;
import com.example.baihe.myapplication.view.fragment.home.HomeFragment;
import com.example.baihe.myapplication.view.fragment.home.MessageFragment;
import com.example.baihe.myapplication.view.fragment.home.MineFragment;

/**
 * Created by baihe on 2017/7/6.
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener{

    /**/
    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        // 初始化
        initView();

        // 默认 Fragment
        mHomeFragment = new HomeFragment();
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();

    }

    private void initView(){
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);


        mHomeView = (TextView)findViewById(R.id.home_image_view);
        mPondView = (TextView)findViewById(R.id.fish_image_view);
        mMessageView = (TextView)findViewById(R.id.message_image_view);
        mMineView = (TextView)findViewById(R.id.mine_image_view);

        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void hideFragment(Fragment fragment, FragmentTransaction ft){
        if(fragment != null){
            ft.hide(fragment);
        }
    }

    @Override
    public void onClick(View v) {

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (v.getId()){
            case R.id.home_layout_view:

                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                // 隐藏
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                // 显示
                if(mHomeFragment == null){
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout,mHomeFragment);
                }
                else {
                    mCurrent = mHomeFragment;
                    fragmentTransaction.show(mHomeFragment);
                }

                break;
            case R.id.message_layout_view:

                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);


                // 隐藏
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                // 显示
                if(mMessageFragment == null){
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout,mMessageFragment);
                }
                else {
                    mCurrent = mMessageFragment;
                    fragmentTransaction.show(mMessageFragment);
                }

                break;
            case R.id.mine_layout_view:

                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);


                // 隐藏
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);
                // 显示
                if(mMineFragment == null){
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout,mMineFragment);
                }
                else {
                    mCurrent = mMineFragment;
                    fragmentTransaction.show(mMineFragment);
                }

                break;
        }
        fragmentTransaction.commit();
    }
}
