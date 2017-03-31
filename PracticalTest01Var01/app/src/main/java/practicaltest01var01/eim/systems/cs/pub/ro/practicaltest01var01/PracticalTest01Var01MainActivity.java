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

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private EditText leftEditText = null;
    private Button topButton = null;
    private Button downButton = null;
    private Button rightButton = null;
    private Button leftButton = null;
    private Button navigateToSecondaryActivityButton = null;
    int leftNumberOfClicks = 0;

    //private int serviceStatus = Constants.SERVICE_STOPPED;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String textul = leftEditText.getText().toString();
            String both;

            switch(view.getId()) {
                case R.id.button5:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                    int numberOfClicks = 0;
                    leftEditText.setText(String.valueOf(""));
                    intent.putExtra("apasat", numberOfClicks);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;

                case R.id.button:
                    leftNumberOfClicks++;
                    both = textul + ", EAST";
                    leftEditText.setText(String.valueOf(both));
                    break;
                case R.id.button2:
                    leftNumberOfClicks++;
                    both = textul + ", NORTH";
                    leftEditText.setText(String.valueOf(both));
                    break;
                case R.id.button3:
                    leftNumberOfClicks++;
                    both = textul + ", WEST";
                    leftEditText.setText(String.valueOf(both));
                    break;
                case R.id.button4:
                    leftNumberOfClicks++;
                    both = textul + ", SOUTH";
                    leftEditText.setText(String.valueOf(both));
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        leftEditText = (EditText)findViewById(R.id.left_edit_text);
        //leftEditText.setText(String.valueOf(0));

        leftButton = (Button)findViewById(R.id.button);
        topButton = (Button)findViewById(R.id.button2);
        rightButton = (Button)findViewById(R.id.button3);
        downButton = (Button)findViewById(R.id.button4);

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.button5);
        leftButton.setOnClickListener(buttonClickListener);
        rightButton.setOnClickListener(buttonClickListener);
        topButton.setOnClickListener(buttonClickListener);
        downButton.setOnClickListener(buttonClickListener);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

        SharedPreferences settings;
        settings = getSharedPreferences("INT_SAVING", MODE_PRIVATE);


        leftNumberOfClicks = settings.getInt("FIRST_INT", 0);

        Log.d("test", "---" +leftNumberOfClicks);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "S-a apasat  Register", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this, "S-a apasat  Cancel", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //pastrez vechile valori
        SharedPreferences settings;
        settings = getSharedPreferences("INT_SAVING", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("FIRST_INT", leftNumberOfClicks);
        editor.commit();
        //////
    }
}
