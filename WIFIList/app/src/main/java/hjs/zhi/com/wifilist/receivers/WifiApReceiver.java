package hjs.zhi.com.wifilist.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WifiApReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.wifi.WIFI_AP_STATE_CHANGED".equals(action)) {
            //便携式热点的状态为：10---正在关闭；11---已关闭；12---正在开启；13---已开启
            int state = intent.getIntExtra("wifi_state", 0);
            Log.d("TAG", state + "---");
        }
    }
}
