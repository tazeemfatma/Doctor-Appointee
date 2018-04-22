package com.example.saumya.doctorsappointee;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saumya.doctorsappointee.dbutil.ClerkConstant;
import com.example.saumya.doctorsappointee.dbutil.ClerkManager;

public class UpdateClerk extends AppCompatActivity {

    EditText uid,uname,uphone,uemail,uaddress,usalary;
    ClerkManager clerkManager;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_clerk);
        uid=findViewById(R.id.uid);
        uname=findViewById(R.id.uname);
        uphone=findViewById(R.id.uphone);
        uemail=findViewById(R.id.uemail);
        uaddress=findViewById(R.id.uaddress);
        usalary=findViewById(R.id.usalary);
        clerkManager=new ClerkManager(this);
        sqLiteDatabase=clerkManager.openDB();
        Intent intent=getIntent();
        String n=intent.getStringExtra("uid");
        populateData(n);
    }

    private void populateData(String n) {
        String[] args={n};
        String[] colnames={ClerkConstant.COL_NAME,ClerkConstant.COL_PHONE,ClerkConstant.COL_EMAIL,ClerkConstant.COL_ADDRESS,ClerkConstant.COL_SALARY};
        Cursor cursor=sqLiteDatabase.query(ClerkConstant.TABLE_NAME,colnames,ClerkConstant.COL_ID+"=?",args,null,null,null);
        if(cursor != null && cursor.moveToFirst()) {
            String nm = cursor.getString(cursor.getColumnIndex(ClerkConstant.COL_NAME));
            String ph = cursor.getString(cursor.getColumnIndex(ClerkConstant.COL_PHONE));
            String em = cursor.getString(cursor.getColumnIndex(ClerkConstant.COL_EMAIL));
            String ad = cursor.getString(cursor.getColumnIndex(ClerkConstant.COL_ADDRESS));
            String sl = cursor.getString(cursor.getColumnIndex(ClerkConstant.COL_SALARY));
            uid.setText(n);
            uname.setText(nm);
            uphone.setText(ph);
            uemail.setText(em);
            uaddress.setText(ad);
            usalary.setText(sl);
        }
    }

    public void UpdateData(View view) {
        String id=uid.getText().toString();
        String n=uname.getText().toString();
        String p=uphone.getText().toString();
        String e=uemail.getText().toString();
        String a=uaddress.getText().toString();
        String s=usalary.getText().toString();
        String[] args={id};
        ContentValues cv=new ContentValues();
        // cv.put(ClerkConstant.COL_ID,id);
        cv.put(ClerkConstant.COL_NAME,n);
        cv.put(ClerkConstant.COL_PHONE,p);
        cv.put(ClerkConstant.COL_EMAIL,e);
        cv.put(ClerkConstant.COL_ADDRESS,a);
        cv.put(ClerkConstant.COL_SALARY,s);
        int rw=sqLiteDatabase.update(ClerkConstant.TABLE_NAME,cv,ClerkConstant.COL_ID+"=?",args);
        if(rw>0)
        {
            Intent intent=new Intent(this,ViewClerk.class);
            startActivity(intent);
            Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show();
        }
    }
}
