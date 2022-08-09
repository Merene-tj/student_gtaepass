package com.example.hp.gatepass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class StaffResultActivity extends Activity {

    String getsp;
    LoginDataBaseAdapte loginDataBaseAdapte;
    String name, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_result);


        String result[] = {"Approval", "Not Approval"};

        final Spinner sp = (Spinner) findViewById(R.id.staffoption);
        final EditText cmt = (EditText) findViewById(R.id.extraedt);
        Button bt = (Button) findViewById(R.id.staffsubmitbt);

        loginDataBaseAdapte = new LoginDataBaseAdapte(this);
        loginDataBaseAdapte = loginDataBaseAdapte.open();

        Intent in = getIntent();
        Bundle b = in.getExtras();
        name = b.getString("name");
        id = b.getString("id");

        ArrayAdapter aa = new ArrayAdapter(StaffResultActivity.this, R.layout.support_simple_spinner_dropdown_item, result);
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(aa);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getsp = sp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = cmt.getText().toString();
                if ((name.equals("")) || (id.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Not Valid ID", Toast.LENGTH_SHORT).show();
                } else {
                    loginDataBaseAdapte.insertEntry(name, id, getsp, comment);
                    Toast.makeText(getApplicationContext(), "Stored Student Gate Pass Information", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(StaffResultActivity.this, StaffActivity.class);
                    startActivity(in);
                }
            }
        });
    }
}
