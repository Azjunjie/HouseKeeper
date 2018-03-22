package com.xiumei.housekeeper.base;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment的基类，封装公共的内容
 * Created by zjj on 2018/3/20 14:35.
 */
public abstract class BaseMvpFragment<P extends BasePresenter<V>, V extends IBaseView>
        extends BaseFragment
        implements IBaseView {

    private P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 生成Presenter实例
     */
    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        if (this.mPresenter != null) {
            this.mPresenter.detachView();
        }
        super.onDestroyView();
    }

}
