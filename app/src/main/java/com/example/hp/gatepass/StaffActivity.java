package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StaffActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        final EditText name = (EditText) findViewById(R.id.studentnameedt);
        final EditText id = (EditText) findViewById(R.id.studentid);
        Button bt = (Button) findViewById(R.id.loginbt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String names = name.getText().toString();
                String ids = id.getText().toString();
                if ((names.equals("stmsc01")) || (ids.equals("skascst"))) {
                    Intent in = new Intent(StaffActivity.this, StudentListActivity.class);
                    in.putExtra("name", names);
                    in.putExtra("id", ids);
                    startActivity(in);
                } else if ((names.equals("stmsc02")) || (ids.equals("skascst"))) {
                    Intent in = new Intent(StaffActivity.this, StudentListActivity.class);
                    in.putExtra("name", names);
                    in.putExtra("id", ids);
                    startActivity(in);
                } else {
                    Toast.makeText(getApplicationContext(), "Must fill the all Column", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}
