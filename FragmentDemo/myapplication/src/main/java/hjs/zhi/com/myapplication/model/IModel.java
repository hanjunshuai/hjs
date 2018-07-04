package hjs.zhi.com.myapplication.model;

public interface IModel {
    void getData(ICallback callback);

    public interface ICallback {
        public void onResult(String data);
    }
}
