package gas.geny.com.companion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ImageButton agaHome;
    ImageButton reha;
    Button dona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        agaHome = (ImageButton)findViewById(R.id.chatAga);
        dona = (Button) findViewById(R.id.donatebut);
        reha = (ImageButton) findViewById(R.id.buttonRehabCen);

        dona.setOnClickListener(this);
        agaHome.setOnClickListener(this);
        reha.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==agaHome){
            Intent in = new Intent(Home.this,Aga.class);
            startActivity(in);
        }
        else if(v==dona){
            Intent in = new Intent(Home.this,Donate.class);
            startActivity(in);
        }
        else if(v==reha){
            Intent in = new Intent(Home.this,RehabCenter.class);
            startActivity(in);
        }
    }
}
