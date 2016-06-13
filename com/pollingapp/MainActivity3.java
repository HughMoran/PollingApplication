package hugomoran.com.pollingapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private RadioGroup groupvote;
    private Button btn;

    private String marrige_db;
    private String child_db;
    private String wage_db;
    private String vote_db;
//----------Strings for the variables taken from MainActivity2---------------
    String age_db;
    String sex_db;
    String area_db;
    String local_db;
//--------------------------------------

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        spinner = (Spinner) findViewById(R.id.maritalspinner);
        spinner2 = (Spinner) findViewById(R.id.childspinner);
        spinner3 = (Spinner) findViewById(R.id.wagespinner);
        groupvote = (RadioGroup) findViewById(R.id.radiovote);
        btn = (Button) findViewById(R.id.button4);
//------------ Bundle to unpack the variables onto this page ----------------------------------
        Bundle bundle = getIntent().getExtras();
        age_db = (bundle.getString("textage"));
        sex_db = (bundle.getString("textsex"));
        area_db = (bundle.getString("textar"));
        local_db = (bundle.getString("textloc"));
//------------Marrige Spinner-------------------------------
        List<String> list = new ArrayList<String>();


        list.add("Single");
        list.add("Married");
        list.add("Divorced");
        list.add("Widowed");
        list.add("Other");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                marrige_db = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//----------------------  Child Spinner   ------------------------
        List<String> list2 = new ArrayList<String>();

        list2.add("0");
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5 or more");

        ArrayAdapter<String> childAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        childAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(childAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                child_db = spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//----------------------  Wages Spinner  ----------------------------------

        List<String> list3 = new ArrayList<String>();

        list3.add("Unemployed");
        list3.add("0 - 19,999");
        list3.add("20,000 - 29,999");
        list3.add("30,000 - 39,999");
        list3.add("40,000 - 49,999");
        list3.add("50,000 plus");

        ArrayAdapter<String> wageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list3);
        wageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3.setAdapter(wageAdapter);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                wage_db = spinner3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//---------------------------------  Radio Group Vote  --------------------------------------------
        groupvote.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup groupvote, int checkedId) {
                RadioButton checked = (RadioButton) findViewById(checkedId);
                vote_db = checked.getText().toString();
            }
        });
// ---------------Button with putExtra to send info to next page --------------------------------------------------

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("martext", marrige_db);
                intent.putExtra("childtext", child_db);
                intent.putExtra("wagetext", wage_db);
                intent.putExtra("radiotext", vote_db);
                intent.putExtra("textage", age_db);
                intent.putExtra("textsex", sex_db);
                intent.putExtra("textar", area_db);
                intent.putExtra("textloc", local_db);

                finish();
                startActivity(intent);


            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}


