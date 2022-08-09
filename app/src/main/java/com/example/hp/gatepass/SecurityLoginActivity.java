package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecurityLoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_login);

        final EditText name = findViewById(R.id.securitymailedt);
        final EditText pass = findViewById(R.id.securitypassedt);
        Button login = findViewById(R.id.securityloginbt);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nn = name.getText().toString();
                String pp = pass.getText().toString();
                if (nn.equals("security") && (pp.equals("security"))){
                    Intent in = new Intent(SecurityLoginActivity.this,HodListActivity.class);
                    startActivity(in);
                }else {
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
