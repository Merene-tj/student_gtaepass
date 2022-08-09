package com.example.hp.gatepass;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends Activity {
    List<OneClass> employeeList;
    SQLiteDatabase mDatabase;
    ListView listViewEmployees;
    OneClassAdapter adapter;
    LoginDataBaseAdapte loginDataBaseAdapte;
    TextView name, mail, num;
    String names,mails,nums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        listViewEmployees = (ListView) findViewById(R.id.studentlist);
        employeeList = new ArrayList<>();
        //opening the database
        mDatabase = openOrCreateDatabase(StudentRequestActivity.DATABASE_NAMEUP, MODE_PRIVATE, null);
        //this method will display the employees in the list
        showEmployeesFromDatabase();
    }

    private void showEmployeesFromDatabase() {
        Cursor cursorEmployees = mDatabase.rawQuery("SELECT * FROM RequestDB", null);
        //if the cursor has some data
        if (cursorEmployees.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                employeeList.add(new OneClass(
                        cursorEmployees.getString(0),
                        cursorEmployees.getString(1),
                        cursorEmployees.getString(2),
                        cursorEmployees.getString(3),
                        cursorEmployees.getString(4)
                ));
            } while (cursorEmployees.moveToNext());
        }
        cursorEmployees.close();
        //creting the adapter object
        adapter = new OneClassAdapter(this, R.layout.studentlist, employeeList, mDatabase);
        //adding the adapter to listview
        listViewEmployees.setAdapter(adapter);
    }
}
