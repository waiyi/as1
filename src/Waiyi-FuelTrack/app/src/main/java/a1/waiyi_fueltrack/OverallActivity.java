package a1.waiyi_fueltrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OverallActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall);

        Intent intent = getIntent();

        // quoted DateFormat from:
        // http://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd\n HH:mm a");
        Date date = new Date();
        String message = ("As of " + (dateFormat.format(date)));

        TextView textDate = new TextView(this);
  //      textDate.setTextSize(20);
        textDate.setText(message);

        TextView textTotal = (TextView) findViewById(R.id.textTotal);
 //       textTotal.setTextSize(20);
        //TODO: Fix accumulative total -- how to call from LogList class
        String df = new DecimalFormat("#0.00").format(DisplayActivity.getLogList().getAccumTotal());
        textTotal.setText(df);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content_overall);
        layout.addView(textDate);

        Button backButton = (Button) findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(OverallActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }

}
