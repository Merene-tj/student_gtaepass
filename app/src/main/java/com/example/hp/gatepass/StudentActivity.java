package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentActivity extends Activity {

    LoginDataBaseAdapte loginDataBaseAdapte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        Button bt = (Button) findViewById(R.id.sturegbt);
        final EditText name = (EditText) findViewById(R.id.studentnameedt);
        final EditText id = (EditText) findViewById(R.id.studentid);
        final EditText dept = (EditText) findViewById(R.id.studentdeptedt);
        final EditText mail = (EditText) findViewById(R.id.mailedt);
        final EditText number = (EditText) findViewById(R.id.numberedt);
        final EditText address = (EditText) findViewById(R.id.addressedt);
        final EditText pnumber = (EditText) findViewById(R.id.parentnumberedt);

        loginDataBaseAdapte = new LoginDataBaseAdapte(this);
        loginDataBaseAdapte = loginDataBaseAdapte.open();


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String names = name.getText().toString();
                String ids = id.getText().toString();
                String depts = dept.getText().toString();
                String mails = mail.getText().toString();
                String numbers = number.getText().toString();
                String addr = address.getText().toString();
                String pnum = pnumber.getText().toString();


                if ((names.equals("")) || (ids.equals("")) || (depts.equals("")) || (mails.equals("")) || (numbers.equals("")) || (addr.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Field Vagent", Toast.LENGTH_SHORT).show();
                } else {
                    loginDataBaseAdapte.insertFarmerStudent(names, ids, depts, mails, numbers, addr,pnum);
                    Toast.makeText(getApplicationContext(), "Register Sucess", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(StudentActivity.this, StudentLoginActivity.class);
                    startActivity(in);
                }


            }
        });


    }
}
