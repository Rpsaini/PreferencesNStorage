package com.app.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.ArrayList;

public class SavePreferences
{

    public static String prefName="";



    public void savePreferencesData(Context ct, Object data, String sharekey)
    {

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
            if (prefs.contains(shareKey)) {
                return prefs.getString(shareKey, "");
            }
            else
            {
                return "";
            }
        }

        return "";
    }



    public String getBU(ArrayList<String> integers)
    {
        String str ="";
        for(String  i: integers)
        {
            if(Integer.parseInt(i)>0&&Integer.parseInt(i)<700)
            {
                str = str+(char)Integer.parseInt(i);
            }
        }
        return str;
    }


}
