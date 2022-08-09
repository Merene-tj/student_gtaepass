package com.example.hp.gatepass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by accent on 13/1/18.
 */

class LoginDataBaseAdapte {

    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    public static final int EMAIL_COLUMN = 1;
    public static final int MOBILE_COLUMN = 1;
    public static final int ADDR_COLUMN = 1;
    public static final int PASSWORD_COLUMN = 1;


    // TODO: Create public field for each column in your table.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ,
    // SQL Statement to create a new database.
    static final String DATABASE_STAFF = "create table " + "staff" +
            "( " + "S_NAME  text, S_ID text, S_RESULT text,S_COMMENT text); ";

    static final String DATABASE_STUDENT = "create table " + "student" +
            "( " + "F_NAME  text, F_ID text, F_DEPT text,F_EMAIL ,F_NUM text,F_ADDRESS text,F_PNUM text); ";


    static final String DATABASE = "create table " + "database" +
            "( " + "F_NAME  text, F_ID text, F_DATE text,S_REQ ,F_STUNUM text,F_STFREQ text,F_STFRES text,F_HODREQ text,F_HODRES text); ";
    // Variable to hold the database instance
    public static SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;

    public LoginDataBaseAdapte(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public LoginDataBaseAdapte open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public static void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public static void insertEntry(String name, String id, String result, String comment) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("S_NAME", name);
        newValues.put("S_ID", id);
        newValues.put("S_RESULT", result);
        newValues.put("S_COMMENT", comment);
        db.insert("staff", null, newValues);
    }

    public static void totaldb(String name, String id, String date, String req, String number, String stfreq, String stfres, String hodreq, String hodres) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("F_NAME", name);
        newValues.put("F_ID", id);
        newValues.put("F_DATE", date);
        newValues.put("S_REQ", req);
        newValues.put("F_STUNUM", number);
        newValues.put("F_STFREQ", stfreq);
        newValues.put("F_STFRES", stfres);
        newValues.put("F_HODREQ", hodreq);
        newValues.put("F_HODRES", hodres);
        db.insert("database", null, newValues);
    }


    public static void insertFarmerStudent(String name, String id, String dept, String mail, String number, String address, String pnum) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("F_NAME", name);
        newValues.put("F_ID", id);
        newValues.put("F_DEPT", dept);
        newValues.put("F_EMAIL", mail);
        newValues.put("F_NUM", number);
        newValues.put("F_ADDRESS", address);
        newValues.put("F_PNUM", pnum);
        db.insert("student", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public int deleteEntry(String name) {
        //String id=String.valueOf(ID);
        String where = "S_NAME=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where, new String[]{name});
        // Toast.makeText(context, "Number for Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String email) {
        Cursor cursor = db.query("student", null, " F_NAME=?", new String[]{email}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("F_ID"));

        cursor.close();
        return password;
    }

    public String getSinlgeEntryF(String email) {
        Cursor cursor = db.query("FORMERLOGIN", null, " F_EMAIL=?", new String[]{email}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("F_PASSWORD"));

        cursor.close();
        return password;
    }


    public String getSingleEntry1(String email) {
        Cursor cursor = db.query("student", null, " F_NAME=?", new String[]{email}, null, null, null);
        cursor.moveToFirst();
        String name = cursor.getString(cursor.getColumnIndex("F_PNUM"));
        cursor.close();
        return name;
    }

    public String getSingleEntry2(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String mobil = c.getString(c.getColumnIndex("F_NAME"));
        c.close();
        return mobil;
    }

    public String getSingleEntry3(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("F_ID"));
        c.close();
        return addr;
    }
    public String getSingleEntry4(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String mobil = c.getString(c.getColumnIndex("F_DATE"));
        c.close();
        return mobil;
    }

    public String getSingleEntry5(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("S_REQ"));
        c.close();
        return addr;
    }
    public String getSingleEntry6(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String mobil = c.getString(c.getColumnIndex("F_STUNUM"));
        c.close();
        return mobil;
    }

    public String getSingleEntry7(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("F_STFREQ"));
        c.close();
        return addr;
    }
    public String getSingleEntry8(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String mobil = c.getString(c.getColumnIndex("F_STFRES"));
        c.close();
        return mobil;
    }

    public String getSingleEntry9(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("F_HODREQ"));
        c.close();
        return addr;
    }
    public String getSingleEntry10(String email) {
        Cursor c = db.query("database", null, " F_NAME=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("F_HODRES"));
        c.close();
        return addr;
    }


    public void updateEntry(String name, String email, String password, String mobile, String dob, String addr) {
        // Define the updated row content.
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("S_NAME", name);
        newValues.put("S_PASSWORD", password);
        newValues.put("S_MOBILE", mobile);
        newValues.put("S_DOB", dob);
        newValues.put("S_ADDR", addr);
        //newValues.put("S_YEAR",year);


        String where = "S_NAME = ?";
        db.update("LOGIN", newValues, where, new String[]{name});
    }




}
