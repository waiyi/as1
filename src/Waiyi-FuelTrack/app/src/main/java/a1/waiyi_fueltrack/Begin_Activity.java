package a1.waiyi_fueltrack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
// source of fuel image from
// http://worldartsme.com/fuel-clipart.html#gal_post_110822_fuel-clipart-1.jpg

public class Begin_Activity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "a1.waiyi_fueltrack.MESSAGE";
    int secondsDelayed = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_);

        int secondsDelayed = 2;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Begin_Activity.this, DisplayActivity.class);
                startActivity(intent);
            }
        }, secondsDelayed * 1000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_begin_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

 //   public void beginApp(View view) {
   //     Intent intent = new Intent(this, DisplayActivity.class);
     //   startActivity(intent);
   // }
}
