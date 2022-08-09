package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentDashboardActivity extends Activity {
    String names, id;
    LoginDataBaseAdapte loginDataBaseAdapte;
    String getnum;
    String getone,gettwo,getthree,getfour,getfive,getsix,getseven,geteight,getnine;
    final static String DBHELP = "database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        Button req = findViewById(R.id.studentrequestbt);
        final Button status = findViewById(R.id.studentrequeststatusbt);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        names = b.getString("name");
        id = b.getString("id");
        loginDataBaseAdapte = new LoginDataBaseAdapte(this);
        loginDataBaseAdapte = loginDataBaseAdapte.open();

        Intent i = getIntent();
        Bundle bb = i.getExtras();
        String getstatus = bb.getString(StudentLoginActivity.DBB);
        getnum = loginDataBaseAdapte.getSingleEntry1(getstatus);

//
//        getone = loginDataBaseAdapte.getSingleEntry2(getstatus);
//        gettwo = loginDataBaseAdapte.getSingleEntry3(getstatus);
//        getthree = loginDataBaseAdapte.getSingleEntry4(getstatus);
//        getfour = loginDataBaseAdapte.getSingleEntry5(getstatus);
//        getfive = loginDataBaseAdapte.getSingleEntry6(getstatus);
//        getsix = loginDataBaseAdapte.getSingleEntry7(getstatus);
//        getseven = loginDataBaseAdapte.getSingleEntry8(getstatus);
//        geteight = loginDataBaseAdapte.getSingleEntry9(getstatus);
//        getnine = loginDataBaseAdapte.getSingleEntry10(getstatus);


        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(StudentDashboardActivity.this, StudentRequestActivity.class);
                in.putExtra("name", names);
                in.putExtra("id", id);
                in.putExtra("num",getnum);
                startActivity(in);
            }
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(StudentDashboardActivity.this, StudentStatusActivity.class);
//                in.putExtra("1",getone);
//                in.putExtra("2",gettwo);
//                in.putExtra("3",getthree);
//                in.putExtra("4",getfour);
//                in.putExtra("5",getfive);
//                in.putExtra("6",getsix);
//                in.putExtra("7",getseven);
//                in.putExtra("8",geteight);
//                in.putExtra("9",getnine);
                in.putExtra(DBHELP, names);

                startActivity(in);
            }
        });

    }
}
