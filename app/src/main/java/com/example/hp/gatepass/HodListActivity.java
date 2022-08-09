package com.example.hp.gatepass;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HodListActivity extends Activity {
    List<OneClassHod> employeeList;
    SQLiteDatabase mDatabase;
    ListView listViewEmployees;
    OneClassHodAdapter adapter;
    LoginDataBaseAdapte loginDataBaseAdapte;
    TextView name, mail, num;
    String names, mails, nums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod_list);

        listViewEmployees = (ListView) findViewById(R.id.hodlist);
        employeeList = new ArrayList<>();
        //opening the database
        mDatabase = openOrCreateDatabase(HODRequestActivity.DATABASE_NAMEUP, MODE_PRIVATE, null);
        //this method will display the employees in the list
        showEmployeesFromDatabase();
    }

    private void showEmployeesFromDatabase() {
        Cursor cursorEmployees = mDatabase.rawQuery("SELECT * FROM HODRequestDB", null);
        //if the cursor has some data
        if (cursorEmployees.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                employeeList.add(new OneClassHod(
                        cursorEmployees.getString(0),
                        cursorEmployees.getString(1),
                        cursorEmployees.getString(2),
                        cursorEmployees.getString(3),
                        cursorEmployees.getString(4),
                        cursorEmployees.getString(5),
                        cursorEmployees.getString(6),
                        cursorEmployees.getString(7),
                        cursorEmployees.getString(8)
                ));
            } while (cursorEmployees.moveToNext());
        }
        cursorEmployees.close();
        //creting the adapter object
        adapter = new OneClassHodAdapter(this, R.layout.hodlist, employeeList, mDatabase);
        //adding the adapter to listview
        listViewEmployees.setAdapter(adapter);
    }
}