package com.vpdt.vpdt.network;

/**
 * Created by HP on 7/24/2017.
 */

public class NetworkModule {
    private NetworkModule() {
    }

    public static NetworkService getService() {
        return RetrofitClient.getClient(BuildConfig.BASEURL).create(NetworkService.class);
    }

}
