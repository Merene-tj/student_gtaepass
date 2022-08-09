package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button admin = (Button) findViewById(R.id.adminbt);
        Button hod = (Button) findViewById(R.id.hodbt);
        Button staff = (Button) findViewById(R.id.staffbt);
        Button student = (Button) findViewById(R.id.studentbt);
        Button security = (Button) findViewById(R.id.Securitybt);


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, StudentLoginActivity.class);
                startActivity(in);
            }
        });

        hod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, HODActivity.class);
                startActivity(in);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(in);
            }
        });

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, StaffActivity.class);
                startActivity(in);
            }
        });
        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, SecurityLoginActivity.class);
                startActivity(in);
            }
        });
    }
}
