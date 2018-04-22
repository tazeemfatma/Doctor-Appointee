package com.example.saumya.doctorsappointee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.saumya.doctorsappointee.dbutil.ClerkConstant;

/**
 * Created by saumya on 12-04-2018.
 */

public class ClinicHelper extends SQLiteOpenHelper
{
    Context context;

    public ClinicHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ClinicConstant.PAT_SQL);
        sqLiteDatabase.execSQL(ClinicConstant.clerk_SQL);
        Toast.makeText(context,"table created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
