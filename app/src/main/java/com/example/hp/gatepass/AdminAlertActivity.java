package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminAlertActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_alert);


        final EditText content = findViewById(R.id.contentedt);
        Button bt = findViewById(R.id.adminsendbt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = content.getText().toString();
                String mail = "jeevanandhamjd@gmail.com";

                Intent in = new Intent(Intent.ACTION_SEND);
                in.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
                in.putExtra(Intent.EXTRA_SUBJECT, "Hostel Students");
                in.putExtra(Intent.EXTRA_TEXT, msg);
                in.setType("message/rfc882");
                startActivity(Intent.createChooser(in, "Choose option"));

            }
        });


    }
}
