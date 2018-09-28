package com.cmy.rxjavaandretrofitdemo;

import com.orhanobut.logger.Logger;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 文 件 名: HttpLogger<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/9/28 15:27<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:<p>
 */
public class HttpLogger implements HttpLoggingInterceptor.Logger {
    private StringBuilder mMessage = new StringBuilder();

    @Override
    public void log(String message) {
        // 请求或者响应开始
        if (message.startsWith("--> POST")) {
            mMessage.setLength(0);
        }
        mMessage.append(message.concat("\n"));
        // 响应结束，打印整条日志
        if (message.startsWith("<-- END HTTP")) {
            Logger.i("开始打印Request信息--->" + "\n\n" +
                    mMessage.toString()
                    + "\n" + "Request信息打印结束<---");
        }
    }

}
