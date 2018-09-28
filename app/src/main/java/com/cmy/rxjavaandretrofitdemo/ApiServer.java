package com.cmy.rxjavaandretrofitdemo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 文 件 名: ApiServer<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/9/28 15:48<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:<p>
 */
public interface ApiServer {
    /**
     * 登录接口
     *
     * @param json json
     * @return Login
     */
    @POST("weatherApi")
    Observable<BaseResponse<Model>> getLogin(@Body String json);
}
