package gas.geny.com.companion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by garvi on 3/11/2017.
 */

public class post extends AppCompatActivity {
    TextView textView ;
    ListView listView;

    Button b;
    EditText e;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    String group;
    ArrayList<String> ch=new ArrayList<String>();
    fire2 fr = new fire2(myRef);



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Bundle extras = getIntent().getExtras();
        e = (EditText)findViewById(R.id.editText6);

        textView = (TextView)findViewById(R.id.textView3);
        b = (Button)findViewById(R.id.button3);
        ch = fr.retrieve();
        listView = (ListView)findViewById(R.id.xf);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,ch);
       listView.setAdapter(adap);
        if (extras != null) {
            group = extras.getString("group");
            // and get whatever type user account id is
            textView.setText(group);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String msg = e.getText().toString();

                    msg g = new msg(msg);
                    myRef.child("messages").push().setValue(g);
                    e.setText("");

                }
            });





        }



    }


}
