package com.xiumei.housekeeper.base;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * fragment的基类，封装公共的内容
 * Created by zjj on 2018/3/20 14:35.
 */
public abstract class BaseFragment
        extends Fragment {
    public final String TAG = this.getClass().getSimpleName();

    protected FragmentActivity mActivity;
    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    /**
     * 获取页面布局资源ID
     *
     * @return 布局资源ID
     */
    protected abstract int getLayoutId();

    /**
     * 初始化控件
     */
    protected abstract void initView(View view);

    @Override
    public void onDestroyView() {
        if (this.mUnbinder != null) {
            this.mUnbinder.unbind();
        }
        super.onDestroyView();
    }

}
