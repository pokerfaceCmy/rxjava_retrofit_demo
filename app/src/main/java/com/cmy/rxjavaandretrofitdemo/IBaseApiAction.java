package com.cmy.rxjavaandretrofitdemo;

/**
 * 文 件 名: IBaseApiAction<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/9/28 15:41<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:定义了三个最基础的view需要展示用到的方法<p>
 */
public interface IBaseApiAction {
    /**
     *展示一个正在加载的Loading
     */
    void showLoading();

    /**
     * 取消展示Loading
     */
    void dismissLoading();

    /**
     * 弹出一个Toast提示
     * @param msg 提示的内容
     */
    void showToast(String msg);
}
