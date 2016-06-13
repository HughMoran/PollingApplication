package hugomoran.com.pollingapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity5 extends AppCompatActivity {
    private ListView list;
    private String itemValue;
    private Button btn;

    MyDBManager db;

    private String party_db;
    private String leader_db;
    private String concern_db;
    private String age_db;
    private String sex_db;
    private String area_db;
    private String local_db;
    private String marrige_db;
    private String child_db;
    private String wage_db;
    private String vote_db;

    TextView txt;
    String[] tds = {
            "Trevor O’ Clochartaigh",
            "Tommy Roddy",
            "Catherine Connolly",
            "Noel Grealish",
            "Fidelma Healy Eames",
            "James Charity",
            "Mike Cubbard",
            "John Connolly",
            "Eamon O’ Cuiv",
            "Mary Hoade",
            "Nicola Daveron",
            "Tommy Holohan",
            "Sean Kyne",
            "John O’ Mahony",
            "Hildegarde Naughton",
            "Derek Nolan",
            "Niall O’ Tuathail",
            "Seamus Sheridan"
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
//---------call an instance of MyDBManager to be able to --------------------
// --------call the method to input the poll to the database-------------------
        db = new MyDBManager(this);
        txt = (TextView) findViewById(R.id.result);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(new MyCustomAdapter(MainActivity5.this, R.layout.activity_main6, tds));

//------------creat an onitemclicklistener to add the selected candidate to a string------------
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemValue = list.getItemAtPosition(position).toString();

            }
        });
//------------Bundle through the remaining data------------
        Bundle bundle = getIntent().getExtras();

        party_db = (bundle.getString("party"));
        leader_db = (bundle.getString("leader"));
        concern_db = (bundle.getString("concern"));
        age_db = (bundle.getString("textage"));
        sex_db = (bundle.getString("textsex"));
        area_db = (bundle.getString("textar"));
        local_db = (bundle.getString("textloc"));
        marrige_db = (bundle.getString("martext"));
        child_db = (bundle.getString("childtext"));
        wage_db = (bundle.getString("wagetext"));
        vote_db = (bundle.getString("radiotext"));
//---------------------------------------
        btn = (Button) findViewById(R.id.button6);

//---------Button to add information to the Database-----------------
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db.open();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                db.insertPoll(age_db, sex_db, area_db, local_db, marrige_db, child_db, wage_db,
                        vote_db, leader_db, party_db, concern_db, itemValue);

                db.close();
                finish();
            }
        });
    }
//------------Custom Adapter to create a custom ListView of all the candidate------------

    public class MyCustomAdapter extends ArrayAdapter<String> {

        String[] names;

        public MyCustomAdapter(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
            names = objects;
        }
//--------------inflator creates all the require rows and columns for the layout-------------
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.activity_main6, parent, false);
            }

            // LayoutInflater inflater = getLayoutInflater();
            // View row = inflater.inflate(R.layout.activity_main6, parent, false);
            TextView label = (TextView) row.findViewById(R.id.candidates);
            label.setText(names[position]);
            ImageView icon = (ImageView) row.findViewById(R.id.electionimage);
            ImageView icon2 = (ImageView) row.findViewById(R.id.partyimage);
//------------if statement to add pictures to each side of the text on the tablelayout---------------
            if (tds[position] == "Trevor O’ Clochartaigh") {
                icon.setImageResource(R.drawable.trevor);
                icon2.setImageResource(R.drawable.sinn);
            } else if (tds[position] == "Tommy Roddy") {
                icon.setImageResource(R.drawable.ruddy);
                icon2.setImageResource(R.drawable.independent);
            } else if (tds[position] == "Catherine Connolly") {
                icon.setImageResource(R.drawable.catherine);
                icon2.setImageResource(R.drawable.independent);
            } else if (tds[position] == "Noel Grealish") {
                icon.setImageResource(R.drawable.noelg);
                icon2.setImageResource(R.drawable.independent);
            } else if (tds[position] == "Fidelma Healy Eames") {
                icon.setImageResource(R.drawable.fidelma);
                icon2.setImageResource(R.drawable.independent);
            } else if (tds[position] == "James Charity") {
                icon.setImageResource(R.drawable.charity);
                icon2.setImageResource(R.drawable.independent);
            } else if (tds[position] == "Mike Cubbard") {
                icon.setImageResource(R.drawable.cubard);
                icon2.setImageResource(R.drawable.independent);
            } else if (tds[position] == "John Connolly") {
                icon.setImageResource(R.drawable.johnc);
                icon2.setImageResource(R.drawable.fianna);
            } else if (tds[position] == "Eamon O’ Cuiv") {
                icon.setImageResource(R.drawable.eamon);
                icon2.setImageResource(R.drawable.fianna);
            } else if (tds[position] == "Mary Hoade") {
                icon.setImageResource(R.drawable.hoade);
                icon2.setImageResource(R.drawable.fianna);
            } else if (tds[position] == "Nicola Daveron") {
                icon.setImageResource(R.drawable.dav);
                icon2.setImageResource(R.drawable.renua);
            } else if (tds[position] == "Tommy Holohan") {
                icon.setImageResource(R.drawable.hoolihan);
                icon2.setImageResource(R.drawable.aaa);
            } else if (tds[position] == "Sean Kyne") {
                icon.setImageResource(R.drawable.kyne);
                icon2.setImageResource(R.drawable.finn);
            } else if (tds[position] == "John O’ Mahony") {
                icon.setImageResource(R.drawable.johno);
                icon2.setImageResource(R.drawable.finn);
            } else if (tds[position] == "Hildegarde Naughton") {
                icon.setImageResource(R.drawable.naughton);
                icon2.setImageResource(R.drawable.finn);
            } else if (tds[position] == "Derek Nolan") {
                icon.setImageResource(R.drawable.nolan);
                icon2.setImageResource(R.drawable.labour);
            } else if (tds[position] == "Niall O’ Tuathail") {
                icon.setImageResource(R.drawable.nial);
                icon2.setImageResource(R.drawable.sdems);
            } else if (tds[position] == "Seamus Sheridan") {
                icon.setImageResource(R.drawable.seamus);
                icon2.setImageResource(R.drawable.green);
            }
            return row;
        }
    }
}