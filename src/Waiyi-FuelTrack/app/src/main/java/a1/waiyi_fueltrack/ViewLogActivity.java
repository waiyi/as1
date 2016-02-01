package a1.waiyi_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.google.gson.Gson;

// view log is to view a list of entries
public class ViewLogActivity extends AppCompatActivity {

    private static int logIndex = -1;
    private String totalCost;
    private ListView logListView;
    private Gson gson;
    public int editIndex;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_log);

        Button newButton = (Button) findViewById(R.id.newEntry);
  //      Button editButton = (Button) findViewById(R.id.edit);
        Button backButton = (Button) findViewById(R.id.back);

        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewLogActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        //TODO: change this to return clickable index instead of editbutton
        // TODO: use the returned index to load that entry to EditActivity
     /*   editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewLogActivity.this, EditActivity.class);
                //TODO: FIXME
             //   editIndex.getLogIndex();
                startActivity(intent);
            }
        });
*/        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewLogActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart() {
        super.onStart();

        logListView = (ListView) findViewById(R.id.listView2);

        logListView.setAdapter(DisplayActivity.getAdapter());
    }

    public static int getLogIndex() { return logIndex; }

    //TODO: fix code properly for clickable
    // source from http://docs.oracle.com/javase/tutorial/uiswing/components/list.html
    // tutorial for selecting an item from the ListView to edit
  //  public ListSelectionModel
/*    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                fireButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                fireButton.setEnabled(true);
            }
        }
    }*/
}