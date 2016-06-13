package hugomoran.com.pollingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Owner on 21-Mar-16.
 */
public class MainOption extends AppCompatActivity {

    Button btn;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
//-------------Button to Query page-----------------
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainOption.this, MainQuery.class);
                finish();
                startActivity(intent);
            }
        });
//-------------Button to View Results of Poll in %-----------------
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainOption.this, MainResult.class);
                finish();
                startActivity(intent);
            }
        });
//-------------Button to View Full DataBase-----------------------
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainOption.this, MainActivityStats.class);
                finish();
                startActivity(intent);

            }
        });
    }
}
