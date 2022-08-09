package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HODActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod);

        final EditText name = (EditText) findViewById(R.id.hstudentnameedt);
        final EditText id = (EditText) findViewById(R.id.hstudentid);
        Button bt = (Button) findViewById(R.id.hloginbt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String names = name.getText().toString();
                String ids = id.getText().toString();
                if ((names.equals("hodmsc01")) || (ids.equals("skaschod"))) {
                    Intent in = new Intent(HODActivity.this, StaffListActivity.class);
                    in.putExtra("name", names);
                    in.putExtra("id", ids);
                    startActivity(in);
                } else if ((names.equals("hodmsc02")) || (ids.equals("skaschod"))) {
                    Intent in = new Intent(HODActivity.this, StaffListActivity.class);
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
