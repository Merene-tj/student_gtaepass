package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class StaffRequestActivity extends Activity {

    String name, id, date, request, pnum;
    Spinner sp;
    EditText req;
    Button bt;

    String result[] = {"Approved", "Not Approved"};
    String getsp;
    public static final String DATABASE_NAMEUP = "mypackageupdatedatabase";
    SQLiteDatabase mDatabase;
    String getreq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_request);
        mDatabase = openOrCreateDatabase(DATABASE_NAMEUP, MODE_PRIVATE, null);

        Intent in = getIntent();
        Bundle bb = in.getExtras();
        name = bb.getString("1");
        id = bb.getString("2");
        date = bb.getString("3");
        request = bb.getString("4");
        pnum = bb.getString("5");

        updatemethod();

        sp = (Spinner) findViewById(R.id.staffopenion);
        req = (EditText) findViewById(R.id.staffrequestedt);
        bt = (Button) findViewById(R.id.staffsubmit);

        ArrayAdapter aa = new ArrayAdapter(StaffRequestActivity.this, R.layout.support_simple_spinner_dropdown_item, result);
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
            String insertSQL = "INSERT INTO StaffRequestDB \n" +
                    "(name,id,date,stureq,stupnum,stfreq,comment)\n" +
                    "VALUES \n" +
                    "(?,?,?,?,?,?,?);";
            mDatabase.execSQL(insertSQL, new String[]{name, id, date, request, pnum, getsp, getreq});
            Toast.makeText(StaffRequestActivity.this, "Request Send Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatemethod() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS StaffRequestDB (\n" + "     name varchar(200) NOT NULL," + "    id varchar(200) NOT NULL\n," +
                        "    date varchar(200) NOT NULL\n," + "    stureq varchar(200) NOT NULL\n," + "    stupnum varchar(200) NOT NULL\n," + "    stfreq varchar(200) NOT NULL\n," + "    comment varchar(200) NOT NULL\n" + ");");
    }


}
