package a1.waiyi_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.google.gson.Gson;

// view log is to view a list of entries
public class ViewLogActivity extends AppCompatActivity {

    private static int logIndex = -1;
    private ListAdapter adapter;
    private RadioGroup radioList;
    private String totalCost;

    private ListView logListView;
    private Gson gson;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_log);

        Button newButton = (Button) findViewById(R.id.newEntry);
        Button editButton = (Button) findViewById(R.id.edit);

        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewLogActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewLogActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart() {
        super.onStart();

        logListView = (ListView) findViewById(R.id.log_layout);

    }

    public static int getLogIndex() {
        return logIndex;
    }
}
