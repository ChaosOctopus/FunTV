package com.example.administrator.funtv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.administrator.funtv.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13 0013.
 * 首页Fragment滑动的适配器
 */

public class PindaoFragmentAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> fragments;
    private List<String> tabs;
    public PindaoFragmentAdapter(FragmentManager fm,List<BaseFragment> fragments,List<String> tabs) {
        super(fm);
        this.fragments = fragments;
        this.tabs=tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    //指定tab文言
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
    //动态添加Fragment

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
