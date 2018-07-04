package hjs.zhi.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import hjs.zhi.com.myapplication.presenter.IPresenter;
import hjs.zhi.com.myapplication.presenter.Presenter;
import hjs.zhi.com.myapplication.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    @butterknife.BindView(R.id.text)
    TextView text;
    @butterknife.BindView(R.id.btn)
    Button btn;


    private IPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);
        presenter = new Presenter(this); //2 Presenter初始化
        presenter.onCreate();   //3 将生命周期回调传给Presenter

    }

    @Override
    public void setData(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(data);
            }
        });
    }

    @butterknife.OnClick(R.id.btn)
    public void onViewClicked() {
        presenter.performOnClick(); //4 用户输入
    }
}
