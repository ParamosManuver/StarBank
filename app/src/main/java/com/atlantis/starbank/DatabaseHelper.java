package com.atlantis.starbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="starbank.db";
    public static final String TABLE1_NAME="customers";
    public static final String TABLE2_NAME="finance";
    public static final String COL_1="ID";
    public static final String COL_2="FNAME";
    public static final String COL_3="SNAME";
    public static final String COL_4="UNAME";
    public static final String COL_5="EMAIL";
    public static final String COL_6="PASSWORD";
    public static final String COL_7="GENDER";
    public static final String COL_8="DOB";
    public static final String COL_9="RESID";
    public static final String COL_A="USNAME";
    public static final String COL_B="DEPOSIT";
    public static final String COL_C="LOAN";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query;
        String query_two;
        query_two="CREATE TABLE finance(ID INTEGER PRIMARY KEY AUTOINCREMENT,USNAME TEXT,DEPOSIT INTEGER,LOAN INTEGER)";
        query="CREATE TABLE customers(ID INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,SNAME TEXT,UNAME TEXT,EMAIL TEXT,PASSWORD TEXT,GENDER TEXT,DOB TEXT,RESID TEXT)";
        db.execSQL(query);
        db.execSQL(query_two);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS customers");
        db.execSQL("DROP TABLE IF EXISTS finance");
        onCreate(db);
    }
    public boolean insertData(String fname,String sname,String uname,String email,String pass,String gender,String dob,String resid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, sname);
        contentValues.put(COL_4, uname);
        contentValues.put(COL_5, email);
        contentValues.put(COL_6, pass);
        contentValues.put(COL_7, gender);
        contentValues.put(COL_8, dob);
        contentValues.put(COL_9, resid);
        long result = db.insert("customers", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean insertDeposit(String usname,int deposit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentMoney = new ContentValues();
        contentMoney.put(COL_B, deposit);
        contentMoney.put(COL_A,usname);
        long moneyResult = db.insert("finance", null, contentMoney);
        if (moneyResult == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertLoan(String usname,int loan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentMoney = new ContentValues();
        contentMoney.put(COL_C, loan);
        contentMoney.put(COL_A,usname);
        long moneyResult = db.insert("finance", null, contentMoney);
        if (moneyResult == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData(String uname){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select *from people where UNAME=?",new String[]{uname});
        return res;
    }


    public String getPass(String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("customers", null, "PASSWORD=?", new String[]{password}, null, null, null);
        if (cursor.getCount()<1){
            cursor.close();
            return "NOT EXIST";
        }
        return password;
    }


    public String getUser(String usename){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("customers", null, "UNAME=?", new String[]{usename}, null, null, null);
        if (cursor.getCount()<1){
            cursor.close();
            return "NOT EXIST";
        }
        return usename;
    }


}

