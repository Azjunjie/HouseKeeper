package com.xiumei.housekeeper.base;

/**
 * @des Mvp中view的基类
 * Created by zjj on 2018/3/20 16:12.
 */
public interface IBaseView {

    /**
     * 显示正在加载view
     */
    void showLoadView();

    /**
     * 关闭正在加载view
     */
    void hideLoadView();

    /**
     * 显示加载错误
     */
    void showLoadErr(String err);

}
