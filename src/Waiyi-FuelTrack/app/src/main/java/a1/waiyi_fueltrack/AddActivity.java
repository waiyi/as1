package a1.waiyi_fueltrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.test.ActivityUnitTestCase;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private List<Entry> log;
    private Entry newEntry;
    private EditText addDate;
    private EditText addStation;
    private EditText addOdo;
    private EditText addGrade;
    private EditText addAmt;
    private EditText addUnit;
    private double eachTotal;
    private int logIndex;
    private Gson gson;
    private Log newLog;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

     /*   editDate = (EditText) findViewById(R.id.date);
        editStation = (EditText) findViewById(R.id.station);
        editOdo = (EditText) findViewById(R.id.odometer);
        editAmt = (EditText) findViewById(R.id.amount);
        editUnit = (EditText) findViewById(R.id.unit);
        editTotal = newEntry.getTotal();
*/
        addDate = (EditText) findViewById(R.id.date);
        addStation = (EditText) findViewById(R.id.station);
        addOdo = (EditText) findViewById(R.id.odometer);
        addGrade = (EditText) findViewById(R.id.grade);
        addAmt = (EditText) findViewById(R.id.amount);
        addUnit = (EditText) findViewById(R.id.unit);
//        eachTotal = newEntry.getTotal();
        Button addButton = (Button) findViewById(R.id.save);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                Intent intent = new Intent(AddActivity.this, Entry.class);
                startActivity(intent);
                saveInFile();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancel);

        // once pressed cancel, jump back to menu page without saving.
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        logIndex += 1;

        String textDate = addDate.getText().toString();
        String textStation = addStation.getText().toString();
        String textOdo = addOdo.getText().toString();
        String textGrade = addGrade.getText().toString();
        String textAmt = addAmt.getText().toString();
        String textUnit = addUnit.getText().toString();
        saveInFile();


        //TODO: fix setVariable to aVariable or textVariable??
/*        newEntry.setDate(textDate);
        newEntry.setStation(textStation);
        newEntry.setOdometer(double textOdo);
        newEntry.setAmount(textAmt);
        newEntry.setUnitCost(double textUnit);

        newEntry(logIndex).add(newEntry);
*/    }



    private void saveInFile(){
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(newEntry, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}