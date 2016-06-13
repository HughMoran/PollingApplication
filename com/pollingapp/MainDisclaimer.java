package hugomoran.com.pollingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Owner on 22-Mar-16.
 */
public class MainDisclaimer extends AppCompatActivity {

    CheckBox checkBox;
    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        checkBox = (CheckBox)findViewById(R.id.checkbox1);
//----------addListenercheck to create listener  for checkbox
        addListenercheck1();
//---------------Button to finish to home page-----------------
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDisclaimer.this, MainActivity.class);
                finish();
                startActivity(intent);

            }
        });
//---------------Button to begin the polling app-----------------
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anotherIntent = new Intent(MainDisclaimer.this, MainActivity2.class);
                finish();
                startActivity(anotherIntent);

            }
        });

    }
//--------Listener that when the check box is checked it makes the button visible------------
    private void addListenercheck1() {
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()){
                    btn2.setVisibility(View.VISIBLE);
                }
            }
        });

    }


}
