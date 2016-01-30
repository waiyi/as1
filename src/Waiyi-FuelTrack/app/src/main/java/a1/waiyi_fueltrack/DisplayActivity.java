package a1.waiyi_fueltrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by Fisherman on 2016-01-18.
 */
public class DisplayActivity extends AppCompatActivity {

    public static final String FILENAME = "file.sav";
    private ListView oldLogList;
    private ArrayList<Log> logs;
    private Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addButton = (Button) findViewById(R.id.add);

        Button viewButton = (Button) findViewById(R.id.view);

        Button editButton = (Button) findViewById(R.id.edit);

        Button overallButton = (Button) findViewById(R.id.overall);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(DisplayActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


        viewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(DisplayActivity.this, Log.class);
                startActivity(intent);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });

        overallButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this, OverallActivity.class);
                startActivity(intent);
            }
        });
    }
}


