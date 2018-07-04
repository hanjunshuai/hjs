package hjs.zhi.com.myapplication.model;

import static android.os.AsyncTask.execute;

public class Model implements IModel {
    public void getData(final ICallback callback) {
        execute(new Runnable() {
            public void run() {             //ugly
                //这里是耗时操作
                callback.onResult("hello world");    //10 返回数据
            }
        });
    }
}
