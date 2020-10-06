package app.dam2.fje.edu.puzzle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btJugar;
    private Button btMusicaON;
    private Button btMusicaOFF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        btJugar = (Button) findViewById(R.id.btJugar);
        btJugar.setOnClickListener(this);
        btMusicaON = (Button) findViewById(R.id.btMusicaON);
        btMusicaON.setOnClickListener(this);
        btMusicaOFF = (Button) findViewById(R.id.btMusicaOFF);
        btMusicaOFF.setOnClickListener(this);

        btMusicaON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainMenuActivity.this, R.anim.bounce);
                btMusicaON.startAnimation(animation);
                startService(new Intent(MainMenuActivity.this, MusicService.class));
            }
        });
        btMusicaOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainMenuActivity.this, R.anim.bounce);
                btMusicaOFF.startAnimation(animation);
                stopService(new Intent(MainMenuActivity.this, MusicService.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == btJugar){
            Intent intent = new Intent(this, PartidaActivity.class);
            startActivity(intent);
        }
    }
}
