package hugomoran.com.pollingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//------call widgets to create--------------
    private EditText age_db;
    private RadioGroup group;
    private Spinner spin;
    private RadioGroup arGroup;
    private Button btn;
//----variables to save selected info to String-----------
    private String sex_db;
    private String area_db;
    private String local_db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//-----------finding the widgets from the XML page activity_main2-------------
        age_db = (EditText) findViewById(R.id.age);
        group = (RadioGroup) findViewById(R.id.radiosex);
        spin = (Spinner) findViewById(R.id.areaspinner);
        arGroup = (RadioGroup) findViewById(R.id.radiolocation);
        btn = (Button) findViewById(R.id.button3);

//--------------------------- Edit Text  -----------------------------------
        age_db.getText().toString();


//------------------------------ Sex Radio Group ------------------------------

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = (RadioButton) findViewById(checkedId);
                sex_db = checked.getText().toString();
            }
        });
//------------------------------ Area Radio Group ------------------------------

        arGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arGroup, int checkedId) {
                RadioButton check = (RadioButton) findViewById(checkedId);
                area_db = check.getText().toString();
            }
        });
//--------------------- Button with an intent to add information to next page------------------

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("textage", age_db.getText().toString());
                intent.putExtra("textsex", sex_db);
                intent.putExtra("textar", area_db);
                intent.putExtra("textloc", local_db);
                finish();
                startActivity(intent);


            }
        });
//--------------------------- Area Spinner ----------------------------------
        List<String> list = new ArrayList<String>();

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

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(dataAdapter);
        spin.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        local_db = spin.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}


