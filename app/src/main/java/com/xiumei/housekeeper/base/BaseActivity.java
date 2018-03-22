package com.xiumei.housekeeper.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * activity的基类，封装公共的内容
 * Created by zjj on 2018/3/20 14:30.
 */
public abstract class BaseActivity
        extends AppCompatActivity{
    public final String TAG = this.getClass().getSimpleName();

    private Unbinder mUnbinder;
    protected BaseActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        this.mUnbinder = ButterKnife.bind(this);
        this.mActivity = this;
        initView();
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
    protected abstract void initView();

    @Override
    protected void onDestroy() {
        if (this.mUnbinder != null) {
            this.mUnbinder.unbind();
        }
        super.onDestroy();
    }

}
