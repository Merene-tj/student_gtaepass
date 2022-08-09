package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        final EditText mail = (EditText) findViewById(R.id.adminemail);
        final EditText pass = (EditText) findViewById(R.id.adminpass);
        Button login = (Button) findViewById(R.id.adminloginbt);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mail.getText().toString();
                String pas = pass.getText().toString();

                if (email.equals("") || (pas.equals(""))) {
                    Toast.makeText(getApplicationContext(),"Field Vagent",Toast.LENGTH_SHORT).show();
                }else {
                    Intent in = new Intent(AdminActivity.this,AdminDashboardActivity.class);
                    startActivity(in);
                }

            }
        });


    }
}
