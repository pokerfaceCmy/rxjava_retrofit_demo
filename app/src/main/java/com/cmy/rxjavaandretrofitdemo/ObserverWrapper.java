package com.cmy.rxjavaandretrofitdemo;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import io.reactivex.observers.DisposableObserver;

/**
 * 文 件 名: ObserverWrapper<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/9/28 15:39<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:RX java Observer的包装类<p>
 */
public abstract class ObserverWrapper<T extends BaseResponse> extends DisposableObserver<T> {
    private IBaseApiAction apiAction;

    protected ObserverWrapper(IBaseApiAction apiAction) {
        this.apiAction = apiAction;
    }

    @Override
    protected void onStart() {
        super.onStart();
        apiAction.showLoading();
    }


    @Override
    public void onNext(T t) {
        if (t.isSuccess()) {
            Gson gson = new Gson();
            success(t);
            Logger.i("开始打印服务器返回信息--->"
                    + "\n" +
                    "接口请求成功返回码--->"
                    + "\n" +
                    t.getCode()
                    + "\n" +
                    "接口请求成功返回信息--->"
                    + "\n" +
                    t.getMessage()
                    + "\n" +
                    "接口请求成功返回数据--->"
                    + "\n" +
                    gson.toJson(t)
            );
        } else {
            apiAction.showToast(t.getMessage());
            onFailure(t.getCode(), t.getMessage());
        }
        apiAction.dismissLoading();
    }

    @Override
    public void onError(Throwable e) {
        apiAction.dismissLoading();
        onFailure(200, e.getMessage());
    }

    @Override
    public void onComplete() {
        apiAction.dismissLoading();
        complete();
    }

    protected abstract void success(T t);

    private void onFailure(int code, String errorMsg) {
        apiAction.showToast(errorMsg);
        Logger.d("接口请求错误返回码--->" + "\n" +
                code);
        Logger.d("接口请求错误信息--->" + "\n" +
                errorMsg);
    }

    private void complete() {

    }

}
