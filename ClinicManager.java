package com.example.saumya.doctorsappointee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by saumya on 12-04-2018.
 */

public class ClinicManager
{
    ClinicHelper clinicHelper;
    SQLiteDatabase sqLiteDatabase;
    public  ClinicManager(Context context)
    {
        clinicHelper=new ClinicHelper(context,ClinicConstant.DBNAME,null,ClinicConstant.DBVERSION);
    }
    public SQLiteDatabase openDB()
    {
        sqLiteDatabase=clinicHelper.getWritableDatabase();
        return  sqLiteDatabase;
    }
    public  void closeDB()
    {
        clinicHelper.close();
    }
}
