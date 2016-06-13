package hugomoran.com.pollingapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.SQLException;

public class MainAnswers extends AppCompatActivity {

    TextView txt;
    MyDBManager db;
    LinearLayout container;
    String gender;
    String wage;
    String location;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        button = (Button)findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.answer);
        db = new MyDBManager(this);
        container = (LinearLayout) findViewById(R.id.container);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAnswers.this, MainQuery.class);
                startActivity(intent);
            }
        });
//-----------Bundles the information that you wish to query from MainQuery------
        Bundle bundle = getIntent().getExtras();
        gender = (bundle.getString("gender"));
        wage = (bundle.getString("wage"));
        location = (bundle.getString("location"));

//---------Do a DB Lookup to open the Database
        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//--------Select all male and female with spacific wage and location-----------------------
        if (gender.equals("All") && !wage.equals("All") && !location.equals("All")) {
            getWageLoc(wage, location);
        }
//-----------Select all wage demagaphics with a spacific gender and location-----------------
        if (!gender.equals("All") && wage.equals("All") && !location.equals("All")) {
            getGenderLoc(gender, location);
        }
//----------Selecet all locations with a spacific gender and wage--------------------------
        if (!gender.equals("All") && !wage.equals("All") && location.equals("All")) {
            getGenderPay(gender, wage);
        }
//----------Select all of each choice gender, wage and location---------------------------
        if (gender.equals("All") && wage.equals("All") && location.equals("All")) {
            getRows();
        }
//-----------Select all wage and location with a spacific gender-------------------------
        if (!gender.equals("All") && wage.equals("All") && location.equals("All")) {
            getGender(gender);
        }
//-----------Select all gender and location with a spacific wage--------------------
        if (gender.equals("All") && !wage.equals("All") && location.equals("All")) {
            getWage(wage);
        }
//-----------Select all gender and wage with a spacific location------------------------
        if (gender.equals("All") && wage.equals("All") && !location.equals("All")) {
            getLocation(location);
        } else {
//-------------else it will return a spacific of each gender, location and wage---------------
            getStat();
        }

        db.close();
    }
//--------------Method to get each spacifically--------------------
    public void getStat() {
        Cursor c = db.getStat(gender, wage, location);

        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }
//------------Method to get spacific wage and location--------------
//------------Cursor iterates through each row for the database
//------------while appending to ShowTask to that it can be printed to screen
    public void getWageLoc(String wage, String location) {
        Cursor c = db.getWageLoc(wage, location);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }
    //------------Method to get spacific gender and location--------------
    public void getGenderLoc(String gender, String location) {
        Cursor c = db.getGenderLoc(gender, location);

        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }
//------------Method to get spacific wage and gender--------------
    public void getGenderPay(String gender, String wage) {
        Cursor c = db.getGenderPay(gender, wage);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }
//------------Method to get all wage location and gender--------------
    public void getRows() {
        Cursor c = db.getAllPolled();
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }
//------------Method to get spacific gender--------------
    public void getGender(String gender) {
        Cursor c = db.getGender(gender);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }
//------------Method to get spacific wage--------------
    public void getWage(String wage) {
        Cursor c = db.getWage(wage);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }
//------------Method to get spacific location----------------
    public void getLocation(String location) {
        Cursor c = db.getLocation(location);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }
//------------appending the results of the queried information showing just------------
//------------choice leader, party, concern and candidate-------------------------------
    public void ShowTask(Cursor c) {
        TextView text = new TextView(this);

        txt.append("Row id: " + c.getString(0) + "\n" +
                        "Queried Leader: " + c.getString(9) + "\n" +
                        "Queried Party: " + c.getString(10) + "\n" +
                        "Queried Concern: " + c.getString(11) + "\n" +
                        "Queried Candidate: " + c.getString(12) + "\n"
        );
        container.addView(text);
    }
}
