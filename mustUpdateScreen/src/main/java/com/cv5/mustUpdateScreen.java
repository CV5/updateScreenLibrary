package com.cv5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mustUpdateScreen extends AsyncTask<String, Void, String> {
    @SuppressLint("StaticFieldLeak")
    private final Context mContext;
    @SuppressLint("StaticFieldLeak")
    private final Activity goToActivity;
    private final String PACKAGES_NAME;
    private final String VERSION_CODE;
    private final int VERSION_APP;

    public mustUpdateScreen(Context mContext, Activity goToActivity, String packages_name, String version_code, int version_app) {
        this.mContext = mContext;
        this.goToActivity = goToActivity;
        this.PACKAGES_NAME = packages_name;
        VERSION_CODE = version_code;
        VERSION_APP = version_app;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        getConfiguracion(mContext);
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if (mContext != null) {

            if (!this.mContext.getApplicationContext().getPackageName().equals(Contantes.LINK_NUEVA_APP)) {
                Intent intent = new Intent(mContext, ThereIsNewApp.class);
                intent.putExtra("newAppLink", Contantes.LINK_NUEVA_APP);
                mContext.startActivity(intent);
                ((Activity) mContext).finish();
            } else if (this.VERSION_APP < Contantes.VERSION_APP) {
                Intent intent = new Intent(mContext, ThereIsNewApp.class);
                intent.putExtra("newAppLink", Contantes.LINK_NUEVA_APP);
                mContext.startActivity(intent);
                ((Activity) mContext).finish();
            } else {
                new Handler().postDelayed(() -> {

                    if(goToActivity != null) {
                        mContext.startActivity(new Intent(mContext, goToActivity.getClass()));
                        ((Activity) mContext).finish();
                    }
                }, 1);
            }
        }


    }

    public void getConfiguracion(Context context) {
        try {
            try {
                // Getting JSON string from URL ------ Used JSON Array froam Android
//                JSONArray json = Funciones.getJSONFromUrlBlogger("https://ecappspro.blogspot.com/2019/03/tumusic-todas-apps-configuracion.html");
//                JSONArray json = Funciones.getJSONFromUrlBlogger("https://configuraciomaxplayer.blogspot.com/2020/12/config-diego.html");
//                JSONArray json = Funciones.getJSONFromUrlBlogger("https://configuraciomaxplayer.blogspot.com/2020/12/config.html");
                JSONArray json = Funciones.getJSONFromUrlBlogger(Contantes.URL_MAIN_BLOGGER);
//                JSONArray json = Funciones.getJSONFromUrlBlogger("https://iptvconfigcine.blogspot.com");
                for (int i = 0; i < json.length(); i++) {
                    JSONObject c = json.getJSONObject(i);
                    Log.v("jsonconfi", c.toString());
                    //*****Mis variables******//
                    Contantes.LINK_NUEVA_APP = c.getString(this.PACKAGES_NAME);
                    Contantes.VERSION_APP = Integer.parseInt(c.getString(this.VERSION_CODE));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.v("variablesConf", "error" + e.getMessage());
//                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.v("variablesConf", "error" + e.getMessage());
//            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}