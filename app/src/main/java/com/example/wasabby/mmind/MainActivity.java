package com.example.wasabby.mmind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPlay, btnOptions, btnExit, btnCredits, btnAvatar;
    Intent game,option,avatar;
    Bundle bundle;
    int randomize = 2; int clues = 1; int stages = 4; int object = 4; int circledesign = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Intent(MainActivity.this, mastermind.class);
        option = new Intent(MainActivity.this, options.class);
        avatar = new Intent(MainActivity.this, avatar.class);
        btnPlay = (ImageButton)findViewById(R.id.btnPlay);
        btnOptions = (ImageButton)findViewById(R.id.btnOptions);
        btnExit = (ImageButton)findViewById(R.id.btnExit);
        btnAvatar = (ImageButton)findViewById(R.id.btnAvatar);
        btnCredits = (ImageButton)findViewById(R.id.btnCredits);
        try{
            bundle = getIntent().getExtras();
            stages = bundle.getInt("getStage");
            object = bundle.getInt("getObject");
            randomize = bundle.getInt("getDiff");
            clues = bundle.getInt("getClue");
        }catch (Exception e){

        }
        btnAvatar();
        btnPlay();
        btnOptions();


    }

    private void btnAvatar()
    {
        btnAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(avatar);
            }
        });
    }


    private void btnPlay()
    {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.putExtra("random",randomize);
                game.putExtra("clues", clues);
                game.putExtra("stages", stages);
                game.putExtra("objects", object);
                startActivity(game);
            }
        });
    }
    private void btnOptions()
    {
        btnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option.putExtra("random",randomize);
                option.putExtra("clues", clues);
                option.putExtra("stages", stages);
                option.putExtra("objects", object);
                option.putExtra("circle", circledesign);
                startActivity(option);

            }
        });
    }
}

