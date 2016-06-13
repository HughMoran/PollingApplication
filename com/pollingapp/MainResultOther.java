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


public class MainResultOther extends AppCompatActivity {

    String[] candidate = {
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
//------Add each candidate to a string to allow them to be queried-------------
    String A = "Trevor O’ Clochartaigh";
    String B = "Tommy Roddy";
    String C = "Catherine Connolly";
    String D = "Noel Grealish";
    String E = "Fidelma Healy Eames";
    String F = "James Charity";
    String G = "Mike Cubbard";
    String H = "John Connolly";
    String I = "Eamon O’ Cuiv";
    String J = "Mary Hoade";
    String K = "Nicola Daveron";
    String L = "Tommy Holohan";
    String M = "Sean Kyne";
    String N = "John O’ Mahony";
    String O = "Hildegarde Naughton";
    String P = "Derek Nolan";
    String Q = "Niall O’ Tuathail";
    String S = "Seamus Sheridan";

    Integer[] candRes = new Integer[18];
    ListView list;
    Button btn;
    MyDBManager db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_result);

        list = (ListView) findViewById(R.id.list);
        btn = (Button) findViewById(R.id.button6);
//---------Button to finish and quit back to last page----------------
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//--------------list adapter to create a CustomAdapter for custom list
        list.setAdapter(new MyCustomAdapter(this, R.layout.activity_other_result, candidate, candRes));

        db = new MyDBManager(this);

        try {
//------------Database lookup-------------------------------
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//------------calls a method to query each candidate in the DB----------------
        getCanA();
        getCanB();
        getCanC();
        getCanD();
        getCanE();
        getCanF();
        getCanG();
        getCanH();
        getCanI();
        getCanJ();
        getCanK();
        getCanL();
        getCanM();
        getCanN();
        getCanO();
        getCanP();
        getCanQ();
        getCanS();

        db.close();

    }
//------------Candidate Result------------------------
    public void getCanA() {
        Cursor c = db.getCandidateVotes(A);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[0] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanB() {
        Cursor c = db.getCandidateVotes(B);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[1] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }
    public void getCanC() {
        Cursor c = db.getCandidateVotes(C);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[2] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }
    public void getCanD() {
        Cursor c = db.getCandidateVotes(D);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[3] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanE() {
        Cursor c = db.getCandidateVotes(E);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[4] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanF() {
        Cursor c = db.getCandidateVotes(F);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[5] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanG() {
        Cursor c = db.getCandidateVotes(G);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[6] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }
    public void getCanH() {
        Cursor c = db.getCandidateVotes(H);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[7] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanI() {
        Cursor c = db.getCandidateVotes(I);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[8] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanJ() {
        Cursor c = db.getCandidateVotes(J);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[9] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanK() {
        Cursor c = db.getCandidateVotes(K);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[10] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanL() {
        Cursor c = db.getCandidateVotes(L);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[11] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanM() {
        Cursor c = db.getCandidateVotes(M);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[12] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanN() {
        Cursor c = db.getCandidateVotes(N);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[13] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanO() {
        Cursor c = db.getCandidateVotes(O);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[14] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanP() {
        Cursor c = db.getCandidateVotes(P);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[15] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanQ() {
        Cursor c = db.getCandidateVotes(Q);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[16] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }

    public void getCanS() {
        Cursor c = db.getCandidateVotes(S);
        Cursor c2 = db.getAllPolled();
        int totalRow = c2.getCount();
        int totalParty = c.getCount();
        candRes[17] = ( ( (int) totalParty* 100) / (int) totalRow);

        c.close();
    }
//---------CustomAdapter to inflate or create the table-----------------------
    public class MyCustomAdapter extends ArrayAdapter<String> {


        String[] names;
        Integer[] values;

        public MyCustomAdapter(Context context, int textViewResourceId, String[] objects, Integer[] results) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
            names = objects;
            values = results;

        }
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.activity_row_other, parent, false);
            }

            // LayoutInflater inflater = getLayoutInflater();
            // View row = inflater.inflate(R.layout.activity_main6, parent, false);
            TextView label = (TextView) row.findViewById(R.id.candidates);
            label.setText(names[position]);
            ImageView icon = (ImageView) row.findViewById(R.id.electionimage);
            TextView text = (TextView) row.findViewById(R.id.result);

            if (candidate[position] == "Trevor O’ Clochartaigh") {
                icon.setImageResource(R.drawable.trevor);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Tommy Roddy") {
                icon.setImageResource(R.drawable.ruddy);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Catherine Connolly") {
                icon.setImageResource(R.drawable.catherine);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Noel Grealish") {
                icon.setImageResource(R.drawable.noelg);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Fidelma Healy Eames") {
                icon.setImageResource(R.drawable.fidelma);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "James Charity") {
                icon.setImageResource(R.drawable.charity);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Mike Cubbard") {
                icon.setImageResource(R.drawable.cubard);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "John Connolly") {
                icon.setImageResource(R.drawable.johnc);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Eamon O’ Cuiv") {
                icon.setImageResource(R.drawable.eamon);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Mary Hoade") {
                icon.setImageResource(R.drawable.hoade);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Nicola Daveron") {
                icon.setImageResource(R.drawable.dav);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Tommy Holohan") {
                icon.setImageResource(R.drawable.hoolihan);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Sean Kyne") {
                icon.setImageResource(R.drawable.kyne);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "John O’ Mahony") {
                icon.setImageResource(R.drawable.johno);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Hildegarde Naughton") {
                icon.setImageResource(R.drawable.naughton);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Derek Nolan") {
                icon.setImageResource(R.drawable.nolan);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Niall O’ Tuathail") {
                icon.setImageResource(R.drawable.nial);
                text.setText(String.valueOf(values[position]));
            } else if (candidate[position] == "Seamus Sheridan") {
                icon.setImageResource(R.drawable.seamus);
                text.setText(String.valueOf(values[position]));
            }
            return row;
        }

    }
}