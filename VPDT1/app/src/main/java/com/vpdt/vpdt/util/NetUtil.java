package com.vpdt.vpdt.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

/**
 * Created by HP on 7/20/2017.
 */

public class NetUtil {

    private static final String TAG = "NETUTIL";
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public boolean isReallyOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e)          {
            Log.i(TAG, "isReallyOnline: "+e);
        }
        catch (InterruptedException e) {
            Log.i(TAG, "isReallyOnline: "+e);
            Thread.currentThread().interrupt();
        }
        return false;
    }
}
