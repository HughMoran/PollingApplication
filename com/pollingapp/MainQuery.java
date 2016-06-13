package hugomoran.com.pollingapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainQuery extends AppCompatActivity {

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Button button;
    private Button btn;

    private String query1;
    private String query2;
    private String query3;
    MyDBManager db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        db = new MyDBManager(this);
        spinner = (Spinner) findViewById(R.id.query);
        spinner2 = (Spinner) findViewById(R.id.query2);
        spinner3 = (Spinner) findViewById(R.id.query3);
        button = (Button) findViewById(R.id.button);
        btn = (Button) findViewById(R.id.button1);

//---------------Query Locations Spinner ----------------------------
        List<String> list = new ArrayList<String>();

        list.add("All");
        list.add("Galway City");
        list.add("Knocknacarra");
        list.add("Bearna");
        list.add("Spiddal");
        list.add("Inverin");
        list.add("Carraroe");
        list.add("Clifden");
        list.add("Recess");
        list.add("Oughterard");
        list.add("Moycullen");

        ArrayAdapter<String> queryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        queryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(queryAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                query1 = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//----------Query Gender Spinner---------------------------
        List<String> list2 = new ArrayList<String>();

        list2.add("All");
        list2.add("Male");
        list2.add("Female");

        ArrayAdapter<String> query3Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        query3Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(query3Adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                query2 = spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//----------------Query Wage Bracket Spinner-----------------------
        List<String> list3 = new ArrayList<String>();

        list3.add("All");
        list3.add("Unemployed");
        list3.add("0 - 19,999");
        list3.add("20,000 - 29,999");
        list3.add("30,000 - 39,999");
        list3.add("40,000 - 49,999");
        list3.add("50,000 plus");

        ArrayAdapter<String> query4Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list3);
        query4Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3.setAdapter(query4Adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                query3 = spinner3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//------------Button to Quit to Home Page--------------------------
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainQuery.this, MainActivity.class);
                startActivity(intent);
            }
        });
//------------Button to send Queries to Next page to display required stats----------
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent queryIntent = new Intent(MainQuery.this, MainAnswers.class);

                queryIntent.putExtra("location", query1);
                queryIntent.putExtra("gender", query2);
                queryIntent.putExtra("wage", query3);

                startActivity(queryIntent);

            }
        });

    }
}
