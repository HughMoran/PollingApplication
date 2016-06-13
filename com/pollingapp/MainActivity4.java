package hugomoran.com.pollingapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private Spinner spinner;
    private Spinner spinner1;
    private Spinner spinner2;
    private Button btn;

    private String party_db;
    private String leader_db;
    private String concern_db;
//--------variables from MainActivity2 and MainActivity3-----------
    String age_db;
    String sex_db;
    String area_db;
    String local_db;
    String marrige_db;
    String child_db;
    String wage_db;
    String vote_db;
//--------------------------------------------

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        spinner = (Spinner) findViewById(R.id.partyspinner);
        spinner1 = (Spinner) findViewById(R.id.leaderspinner);
        spinner2 = (Spinner) findViewById(R.id.concernspinner);
        btn = (Button) findViewById(R.id.button5);
//-----------Bundle to extract the variables from previous pages ------------------------------
        Bundle bundle = getIntent().getExtras();
        age_db = (bundle.getString("textage"));
        sex_db = (bundle.getString("textsex"));
        area_db = (bundle.getString("textar"));
        local_db = (bundle.getString("textloc"));
        marrige_db = (bundle.getString("martext"));
        child_db = (bundle.getString("childtext"));
        wage_db = (bundle.getString("wagetext"));
        vote_db = (bundle.getString("radiotext"));

//---------------------------  Party Spinner  ------------------------------
        List<String> list = new ArrayList<String>();

        list.add("None");
        list.add("Fianna Fail");
        list.add("Sinn Fein");
        list.add("Fine Gael");
        list.add("Labour");
        list.add("Renua");
        list.add("Social Democrats");
        list.add("Green Party");
        list.add("AAA-PBP");

        ArrayAdapter<String> partyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        partyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(partyAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                party_db = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//----------------------------------  Leader Spinner  ---------------------------------------

        List<String> list1 = new ArrayList<String>();

        list1.add("Enda Kenny");
        list1.add("Joan Burton");
        list1.add("Micheál Martin");
        list1.add("Gerry Adams");
        list1.add("Lucinda Creighton");
        list1.add("Stephen Donnelly");
        list1.add("Eamon Ryan");

        ArrayAdapter<String> leaderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);
        leaderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(leaderAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                leader_db = spinner1.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//------------------------------------  Concerns Spinner  -----------------------------------------

        List<String> list2 = new ArrayList<String>();

        list2.add("Health Care");
        list2.add("Water Charges");
        list2.add("Rural Community");
        list2.add("Closure of Garda Stations");
        list2.add("USC Charges");
        list2.add("Flooding");
        list2.add("Road Conditions");

        ArrayAdapter<String> concAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        concAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(concAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                concern_db = spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//-----------------Button to put variables through to the next page--------------------------------

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);

                intent.putExtra("party", party_db);
                intent.putExtra("leader", leader_db);
                intent.putExtra("concern", concern_db);
                intent.putExtra("textage", age_db);
                intent.putExtra("textsex", sex_db);
                intent.putExtra("textar", area_db);
                intent.putExtra("textloc", local_db);
                intent.putExtra("martext", marrige_db);
                intent.putExtra("childtext", child_db);
                intent.putExtra("wagetext", wage_db);
                intent.putExtra("radiotext",vote_db );

                finish();
                startActivity(intent);

            }
        });
    }
}
