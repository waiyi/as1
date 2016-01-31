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

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

public class AddActivity extends AppCompatActivity {


    private Entry newEntry;

    private EditText addDate;
    private EditText addStation;
    private EditText addOdo;
    private EditText addGrade;
    private EditText addAmt;
    private EditText addUnit;
    private double eachTotal;
    private Gson gson;

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

                String textDate = addDate.getText().toString();
                String textStation = addStation.getText().toString();
                double textOdo =  Double.parseDouble(addOdo.getText().toString());
                String textGrade = addGrade.getText().toString();
                double textAmt =  Double.parseDouble(addAmt.getText().toString());
                double textUnit =  Double.parseDouble(addUnit.getText().toString());

                newEntry = new Entry(textDate, textStation, textOdo, textGrade, textAmt, textUnit);


                if (ViewLogActivity.getLogIndex()== -1){
                    DisplayActivity.getLogList().add(newEntry);
                }
                else{
                    DisplayActivity.getLogList().setLog(ViewLogActivity.getLogIndex(), newEntry);
                }

                Intent intent = new Intent(AddActivity.this, ViewLogActivity.class);
                saveInFile();
                ((ArrayAdapter)DisplayActivity.getAdapter()).notifyDataSetChanged();
                startActivity(intent);

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

    private void saveInFile(){
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