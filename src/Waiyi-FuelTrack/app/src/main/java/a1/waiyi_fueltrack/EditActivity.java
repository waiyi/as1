package a1.waiyi_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

// should have an select button to allow user for editing a selected entry
public class EditActivity extends AppCompatActivity {
    //TODO: confirm whether editLog and editIndex if they are correct
    //TODO: call adapter to get clickable index number
    private int editIndex;
//    private String totalCost;
    private ListView editListView;
    private LogList editLog;
    private Entry editEntry;

    private EditText editDate;
    private EditText editStation;
    private EditText editOdo;
    private EditText editGrade;
    private EditText editAmt;
    private EditText editUnit;
    private double eachTotal;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editDate = (EditText) findViewById(R.id.date);
        editStation = (EditText) findViewById(R.id.station);
        editOdo = (EditText) findViewById(R.id.odometer);
        editGrade = (EditText) findViewById(R.id.grade);
        editAmt = (EditText) findViewById(R.id.amount);
        editUnit = (EditText) findViewById(R.id.unit);

        //eachTotal = editLog.getTotal();

        Button saveButton = (Button) findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: assign editVariables to indexed item
                String textDate = editDate.getText().toString();
                String textStation = editStation.getText().toString();
                double textOdo = Double.parseDouble(editOdo.getText().toString());
                String textGrade = editGrade.getText().toString();
                double textAmt = Double.parseDouble(editAmt.getText().toString());
                double textUnit = Double.parseDouble(editUnit.getText().toString());
                double textTotal = textAmt * textUnit / 100;

                editEntry = new Entry(textDate, textStation, textOdo, textGrade, textAmt, textUnit,
                        textTotal);

                //   if (ViewLogActivity.getLogIndex()== -1){
                //     DisplayActivity.getLogList().add(editEntry);
                // }
                // else{
                DisplayActivity.getLogList().setLog(ViewLogActivity.getLogIndex(), editEntry);
                // }

                Intent intent = new Intent(EditActivity.this, ViewLogActivity.class);
                updateInFile();
                ((ArrayAdapter) DisplayActivity.getAdapter()).notifyDataSetChanged();
                startActivity(intent);
            }
        });

        Button backButton = (Button) findViewById(R.id.back);
        // if cancel editing, jump back to ViewLog page without saving.
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(EditActivity.this, ViewLogActivity.class);
                startActivity(intent);
            }
        });}

        // TODO: loadEntry by indexed item retrieve from Log

    private void loadEntry() {
    }

    //TODO: save updated data to the same indexed entry to the LogList
    private void updateInFile() {
    }
}
/*
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            //Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/java 01-19
            Type listType = new TypeToken<ArrayList<Entry>>() {
            }.getType();
            logList = new LogList((ArrayList<Entry>)gson.fromJson(in, listType));

        } catch (FileNotFoundException e) {
            logList = new LogList();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static ListAdapter getAdapter() {
        return adapter;
    }*/


//TODO: code below might be helpful for itemselected
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
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
}
*/