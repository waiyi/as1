package a1.waiyi_fueltrack;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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

public class EditActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private List<Entry> log;
    private Entry newEntry;
    private EditText editDate;
    private EditText editStation;
    private EditText editOdo;
    private EditText editGrade;
    private EditText editAmt;
    private EditText editUnit;
    private double eachTotal;
    private int logIndex;
    private Gson gson;
    private Log oldLogList;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        editDate = (EditText) findViewById(R.id.date);
        editStation = (EditText) findViewById(R.id.station);
        editOdo = (EditText) findViewById(R.id.odometer);
        editAmt = (EditText) findViewById(R.id.amount);
        editUnit = (EditText) findViewById(R.id.unit);
        eachTotal = newEntry.getTotal();

    }

    private void saveInFile() {
        try {
            FileInputStream fis = openFileInput(ViewEntryActivity.FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
            Type listType = new TypeToken<Log>() {
            }.getType();
            oldLogList = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            oldLogList = new Log();
        }
    }
}
