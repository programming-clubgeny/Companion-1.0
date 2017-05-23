package gas.geny.com.companion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RehabCenter extends AppCompatActivity {
    EditText textview,textview2,text4,text5;
    Button button;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public boolean already = false;
    public static final String Name = "nameKey";
    public static final String Address = "address";
    SharedPreferences sharedpreferences;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_center);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();
        boolean value = sharedpreferences.getBoolean("already",false);

        if(value==true){

            Intent i = new Intent(this,RehabFirst.class);
            startActivity(i);
        }
        else {

            button = (Button) findViewById(R.id.submit);
            textview = (EditText) findViewById(R.id.editText);
            textview2 = (EditText) findViewById(R.id.editText3);
            text4 = (EditText)findViewById(R.id.editText4);
            text5 = (EditText)findViewById(R.id.editText5);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String n = textview.getText().toString();
                    String a = textview2.getText().toString();
                    String e = text4.getText().toString();
                    String p = text5.getText().toString();


                    boolean b = true;

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean("already", b);
                    editor.putString("Name", n);
                    editor.putString("Address", a);
                    editor.commit();

                    data d =new data(n,a,e,p);
                    myRef.child("centers").push().setValue(d);

                    mAuth.createUserWithEmailAndPassword(e, p);


                    Intent x = new Intent(getApplicationContext(),RehabFirst.class);
                    startActivity(x);

                }
            });

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
