package a1.waiyi_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;

// should have an select button to allow user for editing a selected entry
public class EditActivity extends AppCompatActivity {

    private Entry editEntry;
    private EditText editDate;
    private EditText editStation;
    private EditText editOdo;
    private EditText editGrade;
    private EditText editAmt;
    private EditText editUnit;
    private double eachTotal;
    private Gson gson;



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


        editDate.setText(DisplayActivity.getLogList().get(ViewLogActivity.getLogIndex()).getDate());
        editStation.setText(DisplayActivity.getLogList().get(ViewLogActivity.getLogIndex()).getStation());
        editOdo.setText(new DecimalFormat("#0.0").format(DisplayActivity.getLogList().
                get(ViewLogActivity.getLogIndex()).getOdometer()));
        editGrade.setText(DisplayActivity.getLogList().get(ViewLogActivity.getLogIndex()).getGrade());
        editAmt.setText(new DecimalFormat("#0.0").format(DisplayActivity.getLogList().
                get(ViewLogActivity.getLogIndex()).getAmount()));
        editUnit.setText(new DecimalFormat("#0.0").format(DisplayActivity.getLogList().
                get(ViewLogActivity.getLogIndex()).getUnitCost()));

        Button saveButton = (Button) findViewById(R.id.saveUpdate);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: assign editVariables to indexed item
                String textDate = editDate.getText().toString();
                String textStation = editStation.getText().toString();
                double textOdo = Double.parseDouble(editOdo.getText().toString());
                String textGrade = editGrade.getText().toString();
                double textAmt = Double.parseDouble(editAmt.getText().toString());
                double textUnit = Double.parseDouble(editUnit.getText().toString());
               // double textTotal = textAmt * textUnit / 100;
                editEntry = new Entry(textDate, textStation, textOdo, textGrade, textAmt, textUnit);
                if (ViewLogActivity.getLogIndex() == -1) {
                    DisplayActivity.getLogList().add(editEntry);
                } else {
                    DisplayActivity.getLogList().setLog(ViewLogActivity.getLogIndex(), editEntry);
                }
                Intent intent = new Intent(EditActivity.this, ViewLogActivity.class);
                saveInFile();
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
        });
    }
    public void saveInFile(){
        try {
            FileOutputStream fos = openFileOutput(DisplayActivity.FILENAME,
                    0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(DisplayActivity.getLogList().getLog(), out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
