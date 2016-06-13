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

public class MainActivityStats extends AppCompatActivity {

    TextView results;
    MyDBManager db;
    LinearLayout container;
    Button btn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stats);

        container = (LinearLayout) findViewById(R.id.database);
        results = (TextView) findViewById(R.id.results);

        btn = (Button)findViewById(R.id.button);
//---------------Button to Bring you back to the MainQuery page to continue----------------
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityStats.this, MainQuery.class);
                startActivity(intent);
            }
        });

        db = new MyDBManager(this);
//------------Do a DB Lookup to open the database------------
        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//----------Calls the method getRows();----------------
        getRows();

        db.close();
    }

//-----------Method to return all the information from the Database---------------
    public void getRows() {
//-----------db.getAllPolled(); to call the method in MyDBManager--------------
        Cursor c = db.getAllPolled();

        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }
//------------Prints out the information to a Text view container---------
    public void ShowTask(Cursor c) {

        TextView text = new TextView(this);

        results.append("id: " + c.getString(0) + "\n" +
                "Poll Age: " + c.getString(1) + "\n" +
                "Poll Sex: " + c.getString(2) + "\n" +
                "Poll Area: " + c.getString(3) + "\n" +
                "Poll Location: " + c.getString(4) + "\n" +
                "Poll Marital: " + c.getString(5) + "\n" +
                "Poll Children: " + c.getString(6) + "\n" +
                "Poll Wage: " + c.getString(7) + "\n" +
                "Poll Vote: " + c.getString(8) + "\n" +
                "Poll Leader: " + c.getString(9) + "\n" +
                "Poll Party: " + c.getString(10) + "\n" +
                "Poll Concern: " + c.getString(11) + "\n" +
                "Poll Choice: " + c.getString(12) + "\n");

        container.addView(text);

    }

}