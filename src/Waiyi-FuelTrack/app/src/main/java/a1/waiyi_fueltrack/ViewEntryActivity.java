package a1.waiyi_fueltrack;

import android.app.LauncherActivity;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
//TODO: // FIXME: ViewEntryActivity
/**
 * Created by Fisherman on 2016-01-27.
 */
public class ViewEntryActivity extends AppCompatActivity {
    public final static String FILENAME = "file.sav";
    public int logIndex = 0;
    private ListAdapter adapter;
    private RadioGroup radioList;
    private String totalCost;
    private Log log;
    private ListView logListView;
    private Gson gson;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        Button newButton = (Button) findViewById(R.id.newEntry);
        Button editButton = (Button) findViewById(R.id.edit);

        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewEntryActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewEntryActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart() {
        super.onStart();

        logListView = (ListView) findViewById(R.id.log_layout);

//        loadListFromFile();

        /* Display total cost
        String accumTotalCost = getString(R.string.total_overall) +
                getString(R.string.total) + log.getAccumTotal();
        totalCost.setText(accumTotalCost);
    }
*/

/*    private void loadListFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
        private void loadListFromFile () {
            public static oldLogList getLog () {
                return log;
            }
        }}
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        throw new RuntimeException();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        throw new RuntimeException();
    }
}*/
}}