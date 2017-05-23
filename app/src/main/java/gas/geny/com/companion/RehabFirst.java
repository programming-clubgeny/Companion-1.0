package gas.geny.com.companion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * Created by garvit on 3/11/2017.
 */

public class RehabFirst extends AppCompatActivity {
    Button button ;
    ListView listView;
    ImageButton home;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("groups");
    firebase fr = new firebase(myRef);
    ArrayList<String> chu=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehabfirst);
        chu = fr.retrieve();
        button=(Button)findViewById(R.id.buttonadd);
        listView = (ListView)findViewById(R.id.list);
        home = (ImageButton) findViewById(R.id.compHome);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(getApplicationContext(), Home.class);
                startActivity(out);
            }
        });

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,chu);
        listView.setAdapter(adap);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent d = new Intent(getApplicationContext(),post.class);
                String we= (chu.get(position)).toString();
                d.putExtra("group",we);
                startActivity(d);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s = new Intent(getApplicationContext(),CreateGroup.class);
                startActivity(s);

            }
        });


    }
}
