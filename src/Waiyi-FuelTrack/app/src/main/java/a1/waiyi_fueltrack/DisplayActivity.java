package a1.waiyi_fueltrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Fisherman on 2016-01-18.
 */
public class DisplayActivity extends AppCompatActivity {

    public static final String FILENAME = "a1.waiyi_fueltrack.file.sav";
    private static LogList logList;

    public static LogList getLogList() {
        return logList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadFromFile();

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
                Intent intent = new Intent(DisplayActivity.this, ViewLogActivity.class);
                startActivity(intent);
            }
        });
        //TODO: Fix this edit activity later, thanks
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
    private void loadFromFile(){
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
        //return tweets.toArray(new String[tweets.size()]);
    }


}


