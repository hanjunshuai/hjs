package hjs.zhi.com.myapplication.presenter;

import android.util.Log;

import hjs.zhi.com.myapplication.model.IModel;
import hjs.zhi.com.myapplication.model.Model;
import hjs.zhi.com.myapplication.view.IView;

public class Presenter implements IPresenter {
    private IView view;   //6 拥有View与Model
    private IModel model;

    public Presenter(IView view) {
        this.view = view;
        model = new Model();
    }

    @Override
    public void onCreate() {
        Log.e("Presenter--->", " onCreate");
    }

    @Override
    public void performOnClick() {
        model.getData(new IModel.ICallback() {    //7  传接口给Model
            public void onResult(String data) {
                String dataFromPresenter = data + " from presenter"; //8 加工数据
                view.setData(dataFromPresenter);
            }
        });
    }
}
