package com.vpdt.vpdt.network;


import android.support.annotation.Nullable;
import android.util.Log;
import com.vpdt.vpdt.App;
import com.vpdt.vpdt.Token;
import com.vpdt.vpdt.ui.activity.LoginActivity;
import com.vpdt.vpdt.util.PrefUtil;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TokenAuthenticator implements Authenticator {

    @Nullable
    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        String refreshToken = PrefUtil.getToken(App.getAppContext()).getRefreshToken();
        synchronized (this) {
            String newRefreshToken = PrefUtil.getToken(App.getAppContext()).getRefreshToken();
            // Access token is refreshed in another thread.
            if (!refreshToken.equals(newRefreshToken)) {
                String accessToken = "Bearer " + PrefUtil.getToken(App.getAppContext()).getAccessToken();
                // thuc hien request hien tai khi da lay duoc token moi
                return response.request().newBuilder().header("Authorization", accessToken).build();
            }
            // Need to refresh an access token
            boolean refreshResult = refreshToken(refreshToken);
            Log.d("RefreshToken", "authenticate: " + refreshResult);
            if (refreshResult) {
                //token moi cua ban day
                String accessToken = "Bearer " + PrefUtil.getToken(App.getAppContext()).getAccessToken();
                // thuc hien request hien tai khi da lay duoc token moi
                return response.request().newBuilder().header("Authorization", accessToken).build();
            } else {
                //Khi refresh token failed ban co the thuc hien action refresh lan tiep theo
                App.getAppContext().startActivity(LoginActivity.getCallingIntent(App.getAppContext()));
                return null;
            }

        }
    }

  /*  @Nullable
    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        String refreshToken = PrefUtil.getToken(App.getAppContext()).getRefreshToken();

        boolean refreshResult = refreshToken(refreshToken);
        Log.d("RefreshToken", "authenticate: " + refreshResult);
        if (refreshResult) {
            //token moi cua ban day
            String accessToken = "Bearer " + PrefUtil.getToken(App.getAppContext()).getAccessToken();

            // thuc hien request hien tai khi da lay duoc token moi
            return response.request().newBuilder().header("Authorization", accessToken).build();
        } else {
            //Khi refresh token failed ban co the thuc hien action refresh lan tiep theo
            App.getAppContext().startActivity(LoginActivity.getCallingIntent(App.getAppContext()));
            return null;
        }
    }*/

    private  Boolean refreshToken(String refresh)
            throws IOException {
        URL refreshUrl = new URL(BuildConfig.BASEURL + "/token");
        HttpURLConnection urlConnection = (HttpURLConnection) refreshUrl.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        urlConnection.setUseCaches(false);
        String urlParameters = "grant_type=refresh_token"
                + "&refresh_token="
                + refresh;

        urlConnection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = urlConnection.getResponseCode();
        Log.d("RefreshToken", "refreshToken: " + responseCode);

        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // this gson part is optional , you can read response directly from Json too\
            Log.d("RefreshToken", "refreshToken: " + response.toString());
            Gson gson = new Gson();
            Token refreshTokenResult = gson.fromJson(response.toString(), Token.class);
            // handle new token ...
            // save it to the sharedpreferences, storage bla bla ...
            Log.d("RefreshToken", "onNext: " + refreshTokenResult);
            PrefUtil.saveToken(refreshTokenResult,  App.getAppContext());

            return true;
        } else {
            //cannot refresh
            return false;
        }
    }
}
