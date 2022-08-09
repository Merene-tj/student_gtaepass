package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class HODRequestActivity extends Activity {

    String name, id, date, request, pnum, four, five;
    Spinner sp;
    EditText req;
    Button bt;

    String result[] = {"Approved", "Not Approved"};
    String getsp;
    public static final String DATABASE_NAMEUP = "mypackageupdatedatabase";
    SQLiteDatabase mDatabase;
    LoginDataBaseAdapte loginDataBaseAdapte;

    String getreq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodrequest);

        mDatabase = openOrCreateDatabase(DATABASE_NAMEUP, MODE_PRIVATE, null);

        Intent in = getIntent();
        Bundle bb = in.getExtras();
        name = bb.getString("1");
        id = bb.getString("2");
        date = bb.getString("3");
        request = bb.getString("4");
        pnum = bb.getString("5");
        four = bb.getString("6");
        five = bb.getString("7");

        loginDataBaseAdapte = new LoginDataBaseAdapte(this);
        loginDataBaseAdapte = loginDataBaseAdapte.open();

        updatemethod();

        sp = (Spinner) findViewById(R.id.hodopenion);
        req = (EditText) findViewById(R.id.hodrequestedt);
        bt = (Button) findViewById(R.id.hodsubmit);

        ArrayAdapter aa = new ArrayAdapter(HODRequestActivity.this, R.layout.support_simple_spinner_dropdown_item, result);
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(aa);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getsp = sp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datainsert();
            }
        });
    }

    private void datainsert() {

        getreq = req.getText().toString();
        if ((getreq.equals(""))) {
            Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
        } else {
            String insertSQL = "INSERT INTO HODRequestDB \n" +
                    "(name,id,date,stureq,stupnum,stfreq,comment,hodreq,hodcomment)\n" +
                    "VALUES \n" +
                    "(?,?,?,?,?,?,?,?,?);";
            mDatabase.execSQL(insertSQL, new String[]{name, id, date, request, pnum, four, five, getsp, getreq});
            loginDataBaseAdapte.totaldb(name, id, date, request, pnum, four, five, getsp, getreq);
            Toast.makeText(HODRequestActivity.this, "Request Send Successfully", Toast.LENGTH_SHORT).show();
            message();
        }
    }

    private void message() {
        String text = "Your ward Permission was granted for gatepass on "+date;
        try {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(pnum, null, text, null, null);
            Toast.makeText(getApplicationContext(), "SMS SENT", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }

    private void updatemethod() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS HODRequestDB (\n" + "     name varchar(200) NOT NULL," + "   " +
                        " id varchar(200) NOT NULL\n," + "    date varchar(200) NOT NULL\n," +
                        "    stureq varchar(200) NOT NULL\n," + "    stupnum varchar(200) NOT NULL\n," + "    " + "stfreq varchar(200) NOT NULL\n," +
                        "comment varchar(200) NOT NULL\n," +
                        "hodreq varchar(200) NOT NULL\n," + "    hodcomment varchar(200) NOT NULL\n" + ");");
    }
}

