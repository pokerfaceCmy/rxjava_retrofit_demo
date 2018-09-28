package com.cmy.rxjavaandretrofitdemo;

import java.util.List;

/**
 * 文 件 名: UserModel<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/9/28 15:49<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:<p>
 */
public class Model {

    /**
     * yesterday : {"date":"27日星期四","high":"高温 20℃","fx":"无持续风向","low":"低温 15℃","fl":"<![CDATA[<3级]]>","type":"小雨"}
     * city : 成都
     * aqi : 36
     * forecast : [{"date":"28日星期五","high":"高温 24℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"无持续风向","type":"晴"},{"date":"29日星期六","high":"高温 24℃","fengli":"<![CDATA[<3级]]>","low":"低温 17℃","fengxiang":"无持续风向","type":"阵雨"},{"date":"30日星期天","high":"高温 22℃","fengli":"<![CDATA[<3级]]>","low":"低温 15℃","fengxiang":"无持续风向","type":"阵雨"},{"date":"1日星期一","high":"高温 23℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"无持续风向","type":"阴"},{"date":"2日星期二","high":"高温 20℃","fengli":"<![CDATA[<3级]]>","low":"低温 15℃","fengxiang":"无持续风向","type":"小雨"}]
     * ganmao : 昼夜温差大，且空气湿度较大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
     * wendu : 27
     */

    private YesterdayBean yesterday;
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private List<ForecastBean> forecast;

    public YesterdayBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayBean yesterday) {
        this.yesterday = yesterday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public static class YesterdayBean {
        /**
         * date : 27日星期四
         * high : 高温 20℃
         * fx : 无持续风向
         * low : 低温 15℃
         * fl : <![CDATA[<3级]]>
         * type : 小雨
         */

        private String date;
        private String high;
        private String fx;
        private String low;
        private String fl;
        private String type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class ForecastBean {
        /**
         * date : 28日星期五
         * high : 高温 24℃
         * fengli : <![CDATA[<3级]]>
         * low : 低温 16℃
         * fengxiang : 无持续风向
         * type : 晴
         */

        private String date;
        private String high;
        private String fengli;
        private String low;
        private String fengxiang;
        private String type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getFengli() {
            return fengli;
        }

        public void setFengli(String fengli) {
            this.fengli = fengli;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getFengxiang() {
            return fengxiang;
        }

        public void setFengxiang(String fengxiang) {
            this.fengxiang = fengxiang;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
