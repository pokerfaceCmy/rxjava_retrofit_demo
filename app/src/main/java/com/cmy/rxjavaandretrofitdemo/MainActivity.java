package com.cmy.rxjavaandretrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements LoginView {
    private LoginView mLoginView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mLoginView = this;
        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpFactory.getInstance().getRetrofitService(ApiServer.class)
                        .getLogin("")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ObserverWrapper<BaseResponse<Model>>(mLoginView) {
                            @Override
                            protected void success(BaseResponse<Model> model) {
                                textView.setText(model.getData().getGanmao());
                            }
                        });
            }
        });
    }


    @Override
    public void showLoading() {
        textView.setText("正在加载");
    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
