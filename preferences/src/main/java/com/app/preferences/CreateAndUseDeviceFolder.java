package com.app.preferences;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class CreateAndUseDeviceFolder
{
    private File file;
    private Context ct;

    public void initialize(Context ct)
    {
        this.ct=ct;
        file= Environment.getExternalStorageDirectory();
    }
    public boolean createFolder(String foldername)
    {
       if(checkAndRequestPermissions()==0) {
           try {
               File inFile = new File(file + "/" + foldername);
               if (!inFile.exists()) {
                   inFile.createNewFile();
                   return true;
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
           return false;

    }

    public boolean deleteFolder(String foldername)
    {
        if(checkAndRequestPermissions()==0) {
            try {
                File inFile = new File(file + "/" + foldername);
                if (!inFile.exists()) {
                    inFile.delete();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean createFile(String foldername,String filename)
    {
        if(checkAndRequestPermissions()==0) {
            try {
                File root = new File(file.getAbsolutePath() + "/" + foldername);
                if (!root.exists()) {
                    root.mkdirs();
                }
                File f = new File(root.getAbsolutePath() + filename);
                return f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    public boolean deleteFile(String foldername,String filename)
    {
        if(checkAndRequestPermissions()==0) {
            try {
                File root = new File(file.getAbsolutePath() + "/" + foldername);
                File f = new File(root.getAbsolutePath() + filename);
                if (f.exists()) {
                    return f.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private int checkAndRequestPermissions()
    {

        int readExternal = ContextCompat.checkSelfPermission(ct, Manifest.permission.READ_EXTERNAL_STORAGE);
        int writeExternal = ContextCompat.checkSelfPermission(ct, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (readExternal != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (writeExternal != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions((Activity) ct,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
            return 1;
        }

        return 0;
    }
}
