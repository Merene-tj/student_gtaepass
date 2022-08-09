package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminDashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);



        Button alert = findViewById(R.id.adminalertbt);
        Button request = findViewById(R.id.admingatepassrequestbt);


        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(AdminDashboardActivity.this,AdminAlertActivity.class);
                startActivity(in);

            }
        });
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(AdminDashboardActivity.this,HodListActivity.class);
                startActivity(in);
            }
        });





    }
}
