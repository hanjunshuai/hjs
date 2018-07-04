package hjs.zhi.com.wifilist.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class WifiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if (info.getState().equals(NetworkInfo.State.DISCONNECTED)) {
                /**
                 * wifi断开连接
                 */
            } else if (info.getState().equals(NetworkInfo.State.CONNECTED)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                /**
                 * wifi以连接wifiInfo.getSSID();获取连接的wifi名称
                 */
                Log.d("TAG == ", wifiInfo.getSSID());
            }
        } else if (intent.getAction().equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {//wifi打开与否
            int wifistate = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_DISABLED);
            if (wifistate == WifiManager.WIFI_STATE_DISABLED) {
                /**
                 * 系统关闭wifi
                 */
            } else if (wifistate == WifiManager.WIFI_STATE_ENABLED) {
                /**
                 * 系统开启wifi
                 */
            }
        }
    }
}
