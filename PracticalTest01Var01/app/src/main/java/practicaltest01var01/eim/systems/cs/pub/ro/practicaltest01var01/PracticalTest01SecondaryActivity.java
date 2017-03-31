package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    private TextView numberOfClicksTextView = null;
    private Button okButton = null;
    private Button cancelButton = null;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ok_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01MainActivity.class);
                    //intent.putExtra("OK", "REGISTER");
                    //startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    setResult(RESULT_OK, intent);
                    break;
                case R.id.cancel_button:
                    Intent intent2 = new Intent(getApplicationContext(), PracticalTest01Var01MainActivity.class);
                    //intent2.putExtra("CAN", "CANSEL");
                    //startActivityForResult(intent2, SECONDARY_ACTIVITY_REQUEST_CODE);
                    setResult(RESULT_CANCELED, intent2);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        numberOfClicksTextView = (TextView) findViewById(R.id.number_of_clicks_text_view);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("numberOfClicks")) {
            int numberOfClicks = intent.getIntExtra("numberOfClicks", -1);
            numberOfClicksTextView.setText(String.valueOf(numberOfClicks));
        }

        okButton = (Button) findViewById(R.id.ok_button);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }

}
