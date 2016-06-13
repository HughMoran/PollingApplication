package hugomoran.com.pollingapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;


public class MainResult extends AppCompatActivity {

    String[] party = {
            "Fianna Fail",
            "Sinn Fein",
            "Fine Gael",
            "Labour",
            "Renua",
            "Social Democrats",
            "Green Party",
            "AAA-PBP"
    };
    //--------Construct an Array to store the precentages of each party--------------
    Integer[] parRes = new Integer[8];

    String A1 = "Fianna Fail";
    String B1 = "Sinn Fein";
    String C1 = "Fine Gael";
    String D1 = "Labour";
    String E1 = "Renua";
    String F1 = "Social Democrats";
    String G1 = "Green Party";
    String H1 = "AAA-PBP";

    String[] leader = {
            "Enda Kenny",
            "Joan Burton",
            "Micheál Martin",
            "Gerry Adams",
            "Lucinda Creighton",
            "Stephen Donnelly",
            "Eamon Ryan"
    };
    //----Construct an Array so store the precentages for each candidate----------------------
    Integer[] leaResult = new Integer[7];

    String A = "Enda Kenny";
    String B = "Joan Burton";
    String C = "Micheál Martin";
    String D = "Gerry Adams";
    String E = "Lucinda Creighton";
    String F = "Stephen Donnelly";
    String G = "Eamon Ryan";

    MyDBManager db;
    ListView lst;
    ListView lst2;
    Button btn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        db = new MyDBManager(this);

        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//------------Party Results------------------------
        getPartA();
        getPartB();
        getPartC();
        getPartD();
        getPartE();
        getPartF();
        getPartG();
        getPartH();

//------------Candidate Results--------------------
        getCandA();
        getCandB();
        getCandC();
        getCandD();
        getCandE();
        getCandF();
        getCandG();

        db.close();

        lst = (ListView) findViewById(R.id.list);
        lst2 = (ListView) findViewById(R.id.list2);
        btn = (Button) findViewById(R.id.button6);
//-----------an adapter to create one Custom list---------------
        lst.setAdapter(new MyCustomAdapter(this, R.layout.row, party, parRes));
//-----------an adapter to create a second custom list----------
        lst2.setAdapter(new MyOtherCustomAdapter(this, R.layout.row2, leader, leaResult));
//-------Button to move to the Second results page--------------------------
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainResult.this, MainResultOther.class);
                finish();
                startActivity(intent);
            }
        });

    }

    //-------Calling the methods to return the Result
//-------for each party and storing the results to parRes array at each index
    public void getPartA() {
        Cursor c = db.getPartyVotes(A1);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        parRes[0] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getPartB() {
        Cursor c = db.getPartyVotes(B1);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        parRes[1] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getPartC() {
        Cursor c = db.getPartyVotes(C1);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        parRes[2] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getPartD() {
        Cursor c = db.getPartyVotes(D1);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        parRes[3] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getPartE() {
        Cursor c = db.getPartyVotes(E1);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        parRes[4] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getPartF() {
        Cursor c = db.getPartyVotes(F1);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        parRes[5] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getPartG() {
        Cursor c = db.getPartyVotes(G1);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        parRes[6] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getPartH() {
        Cursor c = db.getPartyVotes(H1);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        parRes[7] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

//-------Calling Methods to Return Leader Results
//-------for each party and storing the results to leaResult array at each index
    public void getCandA() {
        Cursor c = db.getTotalVote(A);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        leaResult[0] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getCandB() {
        Cursor c = db.getTotalVote(B);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        leaResult[1] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getCandC() {
        Cursor c = db.getTotalVote(C);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        leaResult[2] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getCandD() {
        Cursor c = db.getTotalVote(D);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        leaResult[3] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getCandE() {
        Cursor c = db.getTotalVote(E);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        leaResult[4] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getCandF() {
        Cursor c = db.getTotalVote(F);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        leaResult[5] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    public void getCandG() {
        Cursor c = db.getTotalVote(G);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        leaResult[6] = (((int) totalParty * 100) / (int) totalRow);

        c.close();
    }

    //-------CustomAdapter for the partys------------
    public class MyCustomAdapter extends ArrayAdapter<String> {

        String[] names;
        Integer[] values;

        public MyCustomAdapter(Context context, int textViewResourceId, String[] objects, Integer[] results) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
            names = objects;
            values = results;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);
            }
            TextView label = (TextView) row.findViewById(R.id.textEile);
            label.setText(names[position]);
            ImageView icon = (ImageView) row.findViewById(R.id.image);
            TextView text = (TextView) row.findViewById(R.id.result);

            if (party[position] == "Fianna Fail") {
                icon.setImageResource(R.drawable.fianna);
                text.setText(String.valueOf(values[position]));
            } else if (party[position] == "Sinn Fein") {
                icon.setImageResource(R.drawable.sinn);
                text.setText(String.valueOf(values[position]));
            } else if (party[position] == "Fine Gael") {
                icon.setImageResource(R.drawable.finn);
                text.setText(String.valueOf(values[position]));
            } else if (party[position] == "Labour") {
                icon.setImageResource(R.drawable.labour);
                text.setText(String.valueOf(values[position]));
            } else if (party[position] == "Renua") {
                icon.setImageResource(R.drawable.renua);
                text.setText(String.valueOf(values[position]));
            } else if (party[position] == "Social Democrats") {
                icon.setImageResource(R.drawable.sdems);
                text.setText(String.valueOf(values[position]));
            } else if (party[position] == "Green Party") {
                icon.setImageResource(R.drawable.green);
                text.setText(String.valueOf(values[position]));
            } else if (party[position] == "AAA-PBP") {
                icon.setImageResource(R.drawable.aaa);
                text.setText(String.valueOf(values[position]));
            }
            return row;

        }

    }

    //-----------CustomAdapter for the party leaders-------------
    public class MyOtherCustomAdapter extends ArrayAdapter<String> {

        String[] names;
        Integer[] values;

        public MyOtherCustomAdapter(Context context, int textViewResourceId, String[] objects, Integer[] results) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
            names = objects;
            values = results;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row2 = convertView;

            if (row2 == null) {
                LayoutInflater inflater = getLayoutInflater();
                row2 = inflater.inflate(R.layout.row2, parent, false);
            }

            // LayoutInflater inflater = getLayoutInflater();
            // View row = inflater.inflate(R.layout.activity_main6, parent, false);
            TextView label = (TextView) row2.findViewById(R.id.text);
            label.setText(names[position]);
            ImageView icon2 = (ImageView) row2.findViewById(R.id.imageEile);
            TextView text = (TextView) row2.findViewById(R.id.resultEile);


            if (leader[position] == "Enda Kenny") {
                icon2.setImageResource(R.drawable.finn);
                text.setText(String.valueOf(values[position]));
            } else if (leader[position] == "Joan Burton") {
                icon2.setImageResource(R.drawable.labour);
                text.setText(String.valueOf(values[position]));
            } else if (leader[position] == "Micheál Martin") {
                icon2.setImageResource(R.drawable.fianna);
                text.setText(String.valueOf(values[position]));
            } else if (leader[position] == "Gerry Adams") {
                icon2.setImageResource(R.drawable.sinn);
                text.setText(String.valueOf(values[position]));
            } else if (leader[position] == "Lucinda Creighton") {
                icon2.setImageResource(R.drawable.renua);
                text.setText(String.valueOf(values[position]));
            } else if (leader[position] == "Stephen Donnelly") {
                icon2.setImageResource(R.drawable.sdems);
                text.setText(String.valueOf(values[position]));
            } else if (leader[position] == "Eamon Ryan") {
                icon2.setImageResource(R.drawable.green);
                text.setText(String.valueOf(values[position]));
            }
            return row2;

        }
    }
}