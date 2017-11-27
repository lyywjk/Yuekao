package net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by peng on 2017/9/27.
 */

public class NetWorkUtil {
    // check all network connect, WIFI or mobile
    public static boolean isNetworkAvailable(final Context context){
        boolean hasWifoCon = false;
        boolean hasMobileCon = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfo = cm.getAllNetworkInfo();
        for (NetworkInfo net:networkInfo){
            String typeName = net.getTypeName();
            if(typeName.equalsIgnoreCase("WIFI")){
                if(net.isConnected()){
                    hasWifoCon=true;
                }
            }
            if(typeName.equalsIgnoreCase("MOBILE")){
                if(net.isConnected()){
                    hasWifoCon=true;
                }
            }
        }
        return hasWifoCon || hasMobileCon;
    }

}
