package com.app.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SavePreferences
{

    private String prefName;

    public void savePreferencesData(Context ct, Object data, String sharekey,String PrefrenceName)
    {
        prefName=PrefrenceName;
        SharedPreferences sharedpreferences = ct.getSharedPreferences(prefName, ct.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(sharekey, data+"");

        editor.commit();
    }

    public Object reterivePreference(Context ct, String shareKey)
    {
        if(ct != null)
        {
            SharedPreferences prefs = ct.getSharedPreferences(prefName, ct.MODE_PRIVATE);
            if (prefs.contains("device_token")) {
                return prefs.getString(shareKey, "");
            }
            else
            {
                return "";
            }
        }

        return "";
    }



}
