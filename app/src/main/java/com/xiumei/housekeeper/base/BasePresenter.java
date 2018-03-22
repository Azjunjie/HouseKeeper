package com.xiumei.housekeeper.base;

/**
 * @des Presenter的基类
 * Created by zjj on 2018/3/20 16:16.
 */
public abstract class BasePresenter<V extends IBaseView> {

    /**
     * 绑定的view
     */
    public V mvpView;

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        subscribe();
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mvpView = null;
        unSubscribe();
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isAttachView() {
        return mvpView != null;
    }

    /**
     * 获取连接的view
     */
    public V getView() {
        return mvpView;
    }

    /**
     * 数据加载逻辑
     */
    public abstract void subscribe();

    /**
     * 业务逻辑取消操作
     */
    public abstract void unSubscribe();

}
