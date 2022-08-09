package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLoginActivity extends Activity {

    LoginDataBaseAdapte loginDataBaseAdapte;

final static String DBB="database";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        Button reg = (Button) findViewById(R.id.forregbt);
        Button login = (Button) findViewById(R.id.stdentloginbt);
        final EditText name = (EditText) findViewById(R.id.studentnamelogin);
        final EditText id = (EditText) findViewById(R.id.studentidlogin);

        loginDataBaseAdapte = new LoginDataBaseAdapte(this);
        loginDataBaseAdapte = loginDataBaseAdapte.open();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(StudentLoginActivity.this, StudentActivity.class);
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String names = name.getText().toString();
                String ids = id.getText().toString();

                String temp = loginDataBaseAdapte.getSinlgeEntry(names);

                if (ids.equals(temp)) {
                    Toast.makeText(getApplicationContext(), "Login Sucess", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(StudentLoginActivity.this, StudentDashboardActivity.class);
                    in.putExtra("name", names);
                    in.putExtra("id", ids);
                    in.putExtra(DBB,names);
                    startActivity(in);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
