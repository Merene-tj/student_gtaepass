package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentRequestActivity extends Activity {
    SQLiteDatabase mDatabase;
    public static final String DATABASE_NAMEUP = "mypackageupdatedatabase";
    EditText date, request;
    String names, id, num;

    LoginDataBaseAdapte loginDataBaseAdapte;
    String getnum;

    String number = "8525090828";
    String number2 = "9025821823";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_request);
        mDatabase = openOrCreateDatabase(DATABASE_NAMEUP, MODE_PRIVATE, null);


        loginDataBaseAdapte = new LoginDataBaseAdapte(this);
        loginDataBaseAdapte = loginDataBaseAdapte.open();

        date = (EditText) findViewById(R.id.dateedt);
        request = (EditText) findViewById(R.id.studentrequestedt);
        Button bt = (Button) findViewById(R.id.requestbt);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        names = b.getString("name");
        id = b.getString("id");
        num = b.getString("num");
        updatemethod();
//
//        Intent i = getIntent();
//        Bundle bb = i.getExtras();
//        String getstatus = bb.getString(StudentLoginActivity.DBHELP);
//        getnum = loginDataBaseAdapte.getSingleEntry1(getstatus);
//

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datainsert();
                SMS();
            }
        });
    }

    private void SMS() {
        String content = "Some one of Student ask a GatePass Request Please Visit Your Login";


        try {

            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(number, null, content, null, null);
               sms.sendTextMessage(number2, null, content, null, null);
            Toast.makeText(getApplicationContext(), "SENT", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();

        }
    }

    private void datainsert() {
        String dates = date.getText().toString();
        String req = request.getText().toString();


        if ((dates.equals(""))) {
            Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
        } else {
            String insertSQL = "INSERT INTO RequestDB \n" +
                    "(name,id,date,request,pnum)\n" +
                    "VALUES \n" +
                    "(?,?,?,?,?);";
            mDatabase.execSQL(insertSQL, new String[]{names, id, dates, req, num});


            Toast.makeText(StudentRequestActivity.this, "Request Send Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatemethod() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS RequestDB (\n" + "     name varchar(200) NOT NULL," + "    id varchar(200) NOT NULL\n," +
                        "    date varchar(200) NOT NULL\n," + "    request varchar(200) NOT NULL\n," + "    pnum varchar(200) NOT NULL\n" + ");");
    }
}
