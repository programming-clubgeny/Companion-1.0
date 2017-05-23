package gas.geny.com.companion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by garvi on 3/11/2017.
 */

public class CreateGroup extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
        Button button ;
        EditText editText;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_creategroup);

            button=(Button)findViewById(R.id.button2);
            editText=(EditText)findViewById(R.id.editText2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = editText.getText().toString();

                    group g = new group(name);
                    myRef.child("groups").push().setValue(g);
                    Intent i = new Intent(getApplicationContext(),RehabFirst.class);
                    startActivity(i);

                }
            });



        }
    }


