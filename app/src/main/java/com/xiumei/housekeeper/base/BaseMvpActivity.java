package com.xiumei.housekeeper.base;

import android.os.Bundle;

/**
 * activity的基类，封装公共的内容
 * Created by zjj on 2018/3/20 14:30.
 */
public abstract class BaseMvpActivity<P extends BasePresenter<V>, V extends IBaseView>
        extends BaseActivity
        implements IBaseView {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    /**
     * 生成Presenter实例
     */
    protected abstract P createPresenter();

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
        if (this.mPresenter != null) {
            this.mPresenter.detachView();
        }
        super.onDestroy();
    }

}
