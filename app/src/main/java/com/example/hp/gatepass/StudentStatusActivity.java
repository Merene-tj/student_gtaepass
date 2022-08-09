package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentStatusActivity extends Activity {
    String getone,gettwo,getthree,getfour,getfive,getsix,getseven,geteight,getnine;
    LoginDataBaseAdapte loginDataBaseAdapte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_status);
        TextView one = findViewById(R.id.viewone);
        TextView two = findViewById(R.id.viewtwo);
        TextView three = findViewById(R.id.viewthree);
        TextView four = findViewById(R.id.viewfour);
        TextView five = findViewById(R.id.viewfive);
        TextView six = findViewById(R.id.viewsix);
        TextView seven = findViewById(R.id.viewseven);
        TextView eight = findViewById(R.id.vieweight);
        TextView nine = findViewById(R.id.viewnine);

        loginDataBaseAdapte = new LoginDataBaseAdapte(this);
        loginDataBaseAdapte = loginDataBaseAdapte.open();

        Intent i = getIntent();
        Bundle bb = i.getExtras();
        String getstatus = bb.getString(StudentDashboardActivity.DBHELP);
      //  getnum = loginDataBaseAdapte.getSingleEntry1(getstatus);
        getone = loginDataBaseAdapte.getSingleEntry2(getstatus);
        gettwo = loginDataBaseAdapte.getSingleEntry3(getstatus);
        getthree = loginDataBaseAdapte.getSingleEntry4(getstatus);
        getfour = loginDataBaseAdapte.getSingleEntry5(getstatus);
        getfive = loginDataBaseAdapte.getSingleEntry6(getstatus);
        getsix = loginDataBaseAdapte.getSingleEntry7(getstatus);
        getseven = loginDataBaseAdapte.getSingleEntry8(getstatus);
        geteight = loginDataBaseAdapte.getSingleEntry9(getstatus);
        getnine = loginDataBaseAdapte.getSingleEntry10(getstatus);

        one.setText(getone);
        two.setText(gettwo);
        three.setText(getthree);
        four.setText(getfour);
        five.setText(getfive);
        six.setText(getsix);
        seven.setText(getseven);
        eight.setText(geteight);
        nine.setText(getnine);


    }
}
