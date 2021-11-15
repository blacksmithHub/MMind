package com.example.wasabby.mmind;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class mastermind extends AppCompatActivity {
    Bundle bundle;
    int obj, stg, diff, clue, design, row, choice;
    int bot1, bot2, bot3, bot4, bot5;
    int tries = 1;
    int slot = 1;
    int player1, player2, player3, player4, player5;
    int hint1, hint2, hint3, hint4, hint5;
    int hintimg [] = {R.drawable.clueclear,R.drawable.clueblack, R.drawable.cluewhite};
    ImageView Column1dot1, Column1dot2, Column1dot3, Column1dot4, Column1dot5, Column1dot6;
    ImageView Column2dot1, Column2dot2, Column2dot3, Column2dot4, Column2dot5, Column2dot6;
    ImageView Column3dot1, Column3dot2, Column3dot3, Column3dot4, Column3dot5, Column3dot6;
    ImageView Column4dot1, Column4dot2, Column4dot3, Column4dot4, Column4dot5, Column4dot6;
    ImageView Column5dot1, Column5dot2, Column5dot3, Column5dot4, Column5dot5, Column5dot6;
    ImageView hint11, hint12, hint13, hint14, hint15;
    ImageView hint21, hint22, hint23, hint24, hint25;
    ImageView hint31, hint32, hint33, hint34, hint35;
    ImageView hint41, hint42, hint43, hint44, hint45;
    ImageView hint51, hint52, hint53, hint54, hint55;
    ImageView hint61, hint62, hint63, hint64, hint65;
    ImageView try6, try5;
    ImageButton choice1, choice2, choice3, choice4, choice5,choice6, reveal1, reveal2, reveal3, reveal4, reveal5;
    ImageView surrenderbtn, playagainbtn;
    public int avatars[][] = {{R.drawable.horror1,R.drawable.horror2,R.drawable.horror3,R.drawable.horror4,R.drawable.horror5,R.drawable.horror6},
            {R.drawable.emoji1,R.drawable.emoji2,R.drawable.emoji3,R.drawable.emoji4,R.drawable.emoji5,R.drawable.emoji6},
            {R.drawable.variety1,R.drawable.variety2,R.drawable.variety3,R.drawable.variety4,R.drawable.variety5,R.drawable.variety6}};

    public int pictureset[][] = {{R.drawable.horrordot1,R.drawable.horrordot2,R.drawable.horrordot3,R.drawable.horrordot4,R.drawable.horrordot5,R.drawable.horrordot6},
            {R.drawable.emojidot1,R.drawable.emojidot2,R.drawable.emojidot3,R.drawable.emojidot4,R.drawable.emojidot5,R.drawable.emojidot6},
            {R.drawable.varietydot1,R.drawable.varietydot2,R.drawable.varietydot3,R.drawable.varietydot4,R.drawable.varietydot5,R.drawable.varietydot6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastermind);

        try6 = (ImageView)findViewById(R.id.try6);
        try5 = (ImageView)findViewById(R.id.try5);

        hint11 = (ImageView)findViewById(R.id.stage1dot1);
        hint12 = (ImageView)findViewById(R.id.stage1dot2);
        hint13 = (ImageView)findViewById(R.id.stage1dot3);
        hint14 = (ImageView)findViewById(R.id.stage1dot4);
        hint15 = (ImageView)findViewById(R.id.stage1dot5);

        hint21 = (ImageView)findViewById(R.id.stage2dot1);
        hint22 = (ImageView)findViewById(R.id.stage2dot2);
        hint23 = (ImageView)findViewById(R.id.stage2dot3);
        hint24 = (ImageView)findViewById(R.id.stage2dot4);
        hint25 = (ImageView)findViewById(R.id.stage2dot5);

        hint31 = (ImageView)findViewById(R.id.stage3dot1);
        hint32 = (ImageView)findViewById(R.id.stage3dot2);
        hint33 = (ImageView)findViewById(R.id.stage3dot3);
        hint34 = (ImageView)findViewById(R.id.stage3dot4);
        hint35 = (ImageView)findViewById(R.id.stage3dot5);

        hint41 = (ImageView)findViewById(R.id.stage4dot1);
        hint42 = (ImageView)findViewById(R.id.stage4dot2);
        hint43 = (ImageView)findViewById(R.id.stage4dot3);
        hint44 = (ImageView)findViewById(R.id.stage4dot4);
        hint45 = (ImageView)findViewById(R.id.stage4dot5);

        hint51 = (ImageView)findViewById(R.id.stage5dot1);
        hint52 = (ImageView)findViewById(R.id.stage5dot2);
        hint53 = (ImageView)findViewById(R.id.stage5dot3);
        hint54 = (ImageView)findViewById(R.id.stage5dot4);
        hint55 = (ImageView)findViewById(R.id.stage5dot5);

        hint61 = (ImageView)findViewById(R.id.stage6dot1);
        hint62 = (ImageView)findViewById(R.id.stage6dot2);
        hint63 = (ImageView)findViewById(R.id.stage6dot3);
        hint64 = (ImageView)findViewById(R.id.stage6dot4);
        hint65 = (ImageView)findViewById(R.id.stage6dot5);


        Column1dot1 = (ImageView) findViewById(R.id.Column1dot1);
        Column1dot2 = (ImageView) findViewById(R.id.Column1dot2);
        Column1dot3 = (ImageView) findViewById(R.id.Column1dot3);
        Column1dot4 = (ImageView) findViewById(R.id.Column1dot4);
        Column1dot5 = (ImageView) findViewById(R.id.Column1dot5);
        Column1dot6 = (ImageView) findViewById(R.id.Column1dot6);

        Column2dot1 = (ImageView) findViewById(R.id.Column2dot1);
        Column2dot2 = (ImageView) findViewById(R.id.Column2dot2);
        Column2dot3 = (ImageView) findViewById(R.id.Column2dot3);
        Column2dot4 = (ImageView) findViewById(R.id.Column2dot4);
        Column2dot5 = (ImageView) findViewById(R.id.Column2dot5);
        Column2dot6 = (ImageView) findViewById(R.id.Column2dot6);

        Column3dot1 = (ImageView) findViewById(R.id.Column3dot1);
        Column3dot2 = (ImageView) findViewById(R.id.Column3dot2);
        Column3dot3 = (ImageView) findViewById(R.id.Column3dot3);
        Column3dot4 = (ImageView) findViewById(R.id.Column3dot4);
        Column3dot5 = (ImageView) findViewById(R.id.Column3dot5);
        Column3dot6 = (ImageView) findViewById(R.id.Column3dot6);

        Column4dot1 = (ImageView) findViewById(R.id.Column4dot1);
        Column4dot2 = (ImageView) findViewById(R.id.Column4dot2);
        Column4dot3 = (ImageView) findViewById(R.id.Column4dot3);
        Column4dot4 = (ImageView) findViewById(R.id.Column4dot4);
        Column4dot5 = (ImageView) findViewById(R.id.Column4dot5);
        Column4dot6 = (ImageView) findViewById(R.id.Column4dot6);

        Column5dot1 = (ImageView) findViewById(R.id.Column5dot1);
        Column5dot2 = (ImageView) findViewById(R.id.Column5dot2);
        Column5dot3 = (ImageView) findViewById(R.id.Column5dot3);
        Column5dot4 = (ImageView) findViewById(R.id.Column5dot4);
        Column5dot5 = (ImageView) findViewById(R.id.Column5dot5);
        Column5dot6 = (ImageView) findViewById(R.id.Column5dot6);

        choice1 = (ImageButton)findViewById(R.id.btn1);
        choice2 = (ImageButton)findViewById(R.id.btn2);
        choice3 = (ImageButton)findViewById(R.id.btn3);
        choice4 = (ImageButton)findViewById(R.id.btn4);
        choice5 = (ImageButton)findViewById(R.id.btn5);
        choice6 = (ImageButton)findViewById(R.id.btn6);

        reveal1 = (ImageButton)findViewById(R.id.Genbtn1);
        reveal2 = (ImageButton)findViewById(R.id.Genbtn2);
        reveal3 = (ImageButton)findViewById(R.id.Genbtn3);
        reveal4 = (ImageButton)findViewById(R.id.Genbtn4);
        reveal5 = (ImageButton)findViewById(R.id.Genbtn5);
        playagainbtn = (ImageView)findViewById(R.id.btnPlayAgain);
        surrenderbtn = (ImageView)findViewById(R.id.BtnSurrender);
        newGame();
    }
    public void newGame(){
        try
        {
            bundle = getIntent().getExtras();
            obj = getIntent().getIntExtra("objects", 4);
            clue = getIntent().getIntExtra("clues", 1);
            diff = getIntent().getIntExtra("random", 2);
            stg = getIntent().getIntExtra("stages", 4);
            design = getIntent().getIntExtra("circle", 0);
            if(design == 0)
            {
                choice1.setImageResource(avatars[design][0]);
                choice2.setImageResource(avatars[design][1]);
                choice3.setImageResource(avatars[design][2]);
                choice4.setImageResource(avatars[design][3]);
                choice5.setImageResource(avatars[design][4]);
                choice6.setImageResource(avatars[design][5]);
            }
            else if (design == 1)
            {
                choice1.setImageResource(avatars[design][0]);
                choice2.setImageResource(avatars[design][1]);
                choice3.setImageResource(avatars[design][2]);
                choice4.setImageResource(avatars[design][3]);
                choice5.setImageResource(avatars[design][4]);
                choice6.setImageResource(avatars[design][5]);
            }
            else if (design == 2)
            {
                choice1.setImageResource(avatars[design][0]);
                choice2.setImageResource(avatars[design][1]);
                choice3.setImageResource(avatars[design][2]);
                choice4.setImageResource(avatars[design][3]);
                choice5.setImageResource(avatars[design][4]);
                choice6.setImageResource(avatars[design][5]);
            }

        }
        catch(Exception e)
        {

        }

        choice1.setClickable(true);
        choice2.setClickable(true);
        choice3.setClickable(true);
        choice4.setClickable(true);
        choice5.setClickable(true);
        hint11.setImageResource(hintimg[0]);
        hint12.setImageResource(hintimg[0]);
        hint13.setImageResource(hintimg[0]);
        hint14.setImageResource(hintimg[0]);
        hint15.setImageResource(hintimg[0]);

        hint21.setImageResource(hintimg[0]);
        hint22.setImageResource(hintimg[0]);
        hint23.setImageResource(hintimg[0]);
        hint24.setImageResource(hintimg[0]);
        hint25.setImageResource(hintimg[0]);

        hint31.setImageResource(hintimg[0]);
        hint32.setImageResource(hintimg[0]);
        hint33.setImageResource(hintimg[0]);
        hint34.setImageResource(hintimg[0]);
        hint35.setImageResource(hintimg[0]);

        hint41.setImageResource(hintimg[0]);
        hint42.setImageResource(hintimg[0]);
        hint43.setImageResource(hintimg[0]);
        hint44.setImageResource(hintimg[0]);
        hint45.setImageResource(hintimg[0]);

        hint51.setImageResource(hintimg[0]);
        hint52.setImageResource(hintimg[0]);
        hint53.setImageResource(hintimg[0]);
        hint54.setImageResource(hintimg[0]);
        hint55.setImageResource(hintimg[0]);

        hint61.setImageResource(hintimg[0]);
        hint62.setImageResource(hintimg[0]);
        hint63.setImageResource(hintimg[0]);
        hint64.setImageResource(hintimg[0]);
        hint65.setImageResource(hintimg[0]);

        reveal1.setImageResource(R.drawable.question);
        reveal2.setImageResource(R.drawable.question);
        reveal3.setImageResource(R.drawable.question);
        reveal4.setImageResource(R.drawable.question);
        reveal5.setImageResource(R.drawable.question);
        Column1dot1.setImageResource(R.drawable.dot);
        Column1dot2.setImageResource(R.drawable.dot);
        Column1dot3.setImageResource(R.drawable.dot);
        Column1dot4.setImageResource(R.drawable.dot);
        Column1dot5.setImageResource(R.drawable.dot);
        Column1dot6.setImageResource(R.drawable.dot);

        Column2dot1.setImageResource(R.drawable.dot);
        Column2dot2.setImageResource(R.drawable.dot);
        Column2dot3.setImageResource(R.drawable.dot);
        Column2dot4.setImageResource(R.drawable.dot);
        Column2dot5.setImageResource(R.drawable.dot);
        Column2dot6.setImageResource(R.drawable.dot);

        Column3dot1.setImageResource(R.drawable.dot);
        Column3dot2.setImageResource(R.drawable.dot);
        Column3dot3.setImageResource(R.drawable.dot);
        Column3dot4.setImageResource(R.drawable.dot);
        Column3dot5.setImageResource(R.drawable.dot);
        Column3dot6.setImageResource(R.drawable.dot);

        Column4dot1.setImageResource(R.drawable.dot);
        Column4dot2.setImageResource(R.drawable.dot);
        Column4dot3.setImageResource(R.drawable.dot);
        Column4dot4.setImageResource(R.drawable.dot);
        Column4dot5.setImageResource(R.drawable.dot);
        Column4dot6.setImageResource(R.drawable.dot);

        Column5dot1.setImageResource(R.drawable.dot);
        Column5dot2.setImageResource(R.drawable.dot);
        Column5dot3.setImageResource(R.drawable.dot);
        Column5dot4.setImageResource(R.drawable.dot);
        Column5dot5.setImageResource(R.drawable.dot);
        Column5dot6.setImageResource(R.drawable.dot);
        playagainbtn.setAlpha(0);
        checkstg();
        checkclue();
        checkObj();
        Randomize();
        tries = 1;
        row = 1;
        slot = 1;
        Guess();
        surrenderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mastermind.this);
                builder.setTitle("You Surrendered!");
                builder.setMessage("Perhaps, it was too hard for you!");
                builder.setNegativeButton("Continue", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                reveal1.setImageResource(pictureset[design][bot1]);
                reveal2.setImageResource(pictureset[design][bot2]);
                reveal3.setImageResource(pictureset[design][bot3]);
                reveal4.setImageResource(pictureset[design][bot4]);
                reveal5.setImageResource(pictureset[design][bot5]);
                choice1.setClickable(false);
                choice2.setClickable(false);
                choice3.setClickable(false);
                choice4.setClickable(false);
                choice5.setClickable(false);
                playagainbtn.setAlpha(255);
                playagainbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        newGame();
                    }
                });
            }
        });


    }
    public void Guess(){
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 1;
                rowsandstages();
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 2;
                rowsandstages();
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 3;
                rowsandstages();
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 4;
                rowsandstages();
            }
        });

        choice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 5;
                rowsandstages();
            }
        });

        choice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 6;
                rowsandstages();
            }
        });
    }
    public void Check(){
        if(player1 == bot1 && player2 == bot2 && player3 == bot3 && player4 == bot4){
            AlertDialog.Builder builder = new AlertDialog.Builder(mastermind.this);
            builder.setTitle("You Won!");
            builder.setMessage("You guessed Correctly!");
            builder.setNegativeButton("Continue", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            reveal1.setImageResource(pictureset[design][bot1]);
            reveal2.setImageResource(pictureset[design][bot2]);
            reveal3.setImageResource(pictureset[design][bot3]);
            reveal4.setImageResource(pictureset[design][bot4]);
            reveal5.setImageResource(pictureset[design][bot5]);
            choice1.setClickable(false);
            choice2.setClickable(false);
            choice3.setClickable(false);
            choice4.setClickable(false);
            choice5.setClickable(false);
            playagainbtn.setAlpha(255);
            playagainbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    newGame();
                }
            });

        }
        else {
            slot = 1;
            row ++;
            if(tries != stg) {
                Toast.makeText(getApplicationContext(), "Try Again!", Toast.LENGTH_LONG).show();
                hints();
                tries++;
                Guess();
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(mastermind.this);
                builder.setTitle("You Lost!");
                builder.setMessage("You guessed wrong!");
                builder.setNegativeButton("Continue", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                reveal1.setImageResource(pictureset[design][bot1]);
                reveal2.setImageResource(pictureset[design][bot2]);
                reveal3.setImageResource(pictureset[design][bot3]);
                reveal4.setImageResource(pictureset[design][bot4]);
                reveal5.setImageResource(pictureset[design][bot5]);
                choice1.setClickable(false);
                choice2.setClickable(false);
                choice3.setClickable(false);
                choice4.setClickable(false);
                choice5.setClickable(false);
                playagainbtn.setAlpha(255);
                playagainbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        newGame();
                    }
                });

            }
        }
    }
    public void hints(){
        //0 Wrong
        // 1 Right position Right Color
        // 2 Right color only
        if(player1 == bot1){
            hint1 = 1;
        }
        else if (player1 == bot2 || player1 == bot3 || player1 == bot4 || player1 == bot5){
            hint1 = 2;
        }
        else{
            hint1 = 0;
        }

        if(player2 == bot2){
            hint2 = 1;
        }
        else if (player2 == bot1 || player2 == bot3 || player2 == bot4 || player2 == bot5){
            hint2 = 2;
        }
        else{
            hint2 = 0;
        }

        if(player3 == bot3){
            hint3 = 1;
        }
        else if (player3 == bot1 || player3 == bot2 || player3 == bot4 || player3 == bot5){
            hint3 = 2;
        }
        else{
            hint3 = 0;
        }

        if(player4 == bot4){
            hint4 = 1;
        }
        else if (player4 == bot1 || player4 == bot2 || player4 == bot3 || player4 == bot5){
            hint4 = 2;
        }
        else{
            hint4 = 0;
        }

        if(player5 == bot5){
            hint5 = 1;
        }
        else if (player5 == bot1 || player5 == bot2 || player5 == bot3 || player5 == bot4){
            hint5 = 2;
        }
        else{
            hint5 = 0;
        }


        if (row == 2){
            hint11.setImageResource(hintimg[hint1]);
            hint12.setImageResource(hintimg[hint2]);
            hint13.setImageResource(hintimg[hint3]);
            hint14.setImageResource(hintimg[hint4]);
            hint15.setImageResource(hintimg[hint5]);
        }
       else if (row == 3){
            hint21.setImageResource(hintimg[hint1]);
            hint22.setImageResource(hintimg[hint2]);
            hint23.setImageResource(hintimg[hint3]);
            hint24.setImageResource(hintimg[hint4]);
            hint25.setImageResource(hintimg[hint5]);
        }
      else  if (row == 4){
            hint31.setImageResource(hintimg[hint1]);
            hint32.setImageResource(hintimg[hint2]);
            hint33.setImageResource(hintimg[hint3]);
            hint34.setImageResource(hintimg[hint4]);
            hint35.setImageResource(hintimg[hint5]);
        }
       else if (row == 5){
            hint41.setImageResource(hintimg[hint1]);
            hint42.setImageResource(hintimg[hint2]);
            hint43.setImageResource(hintimg[hint3]);
            hint44.setImageResource(hintimg[hint4]);
            hint45.setImageResource(hintimg[hint5]);
        }
      else  if (row == 6){
            hint51.setImageResource(hintimg[hint1]);
            hint52.setImageResource(hintimg[hint2]);
            hint53.setImageResource(hintimg[hint3]);
            hint54.setImageResource(hintimg[hint4]);
            hint55.setImageResource(hintimg[hint5]);
        }
     else   if (row == 7){
            hint61.setImageResource(hintimg[hint1]);
            hint62.setImageResource(hintimg[hint2]);
            hint63.setImageResource(hintimg[hint3]);
            hint64.setImageResource(hintimg[hint4]);
            hint65.setImageResource(hintimg[hint5]);
        }


    }
    public void rowsandstages(){
        if (row == 1){
            switch (slot) {
                case 1:
                    player1 = choice;
                    Column1dot1.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 2:
                    player2 = choice;
                    Column2dot1.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 3:
                    player3 = choice;
                    Column3dot1.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 4:
                    player4 = choice;
                    Column4dot1.setImageResource(pictureset[design][choice]);
                    if(obj == 4) {
                        player5 = bot5;
                        Check();
                    }
                    else{
                        slot++;
                    }
                    break;
                case 5:
                    player5 = choice;
                    Column5dot1.setImageResource(pictureset[design][choice]);
                    Check();
                    break;
            }
        }
        else if (row == 2){
            switch (slot) {
                case 1:
                    player1 = choice;
                    Column1dot2.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 2:
                    player2 = choice;
                    Column2dot2.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 3:
                    player3 = choice;
                    Column3dot2.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 4:
                    player4 = choice;
                    Column4dot2.setImageResource(pictureset[design][choice]);
                    if(obj == 4) {
                        player5 = bot5;
                        Check();
                    }
                    else{
                        slot++;
                    }
                    break;
                case 5:
                    player5 = choice;
                    Column5dot2.setImageResource(pictureset[design][choice]);
                    Check();
                    break;
            }
        }
        else if (row == 3){
            switch (slot) {
                case 1:
                    player1 = choice;
                    Column1dot3.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 2:
                    player2 = choice;
                    Column2dot3.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 3:
                    player3 = choice;
                    Column3dot3.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 4:
                    player4 = choice;
                    Column4dot3.setImageResource(pictureset[design][choice]);
                    if(obj == 4) {
                        player5 = bot5;
                        Check();
                    }
                    else{
                        slot++;
                    }
                    break;
                case 5:
                    player5 = choice;
                    Column5dot3.setImageResource(pictureset[design][choice]);
                    Check();
                    break;
            }

        }
        else if (row == 4){
            switch (slot) {
                case 1:
                    player1 = choice;
                    Column1dot4.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 2:
                    player2 = choice;
                    Column2dot4.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 3:
                    player3 = choice;
                    Column3dot4.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 4:
                    player4 = choice;
                    Column4dot4.setImageResource(pictureset[design][choice]);
                    if(obj == 4) {
                        player5 = bot5;
                        Check();
                    }
                    else{
                        slot++;
                    }
                    break;
                case 5:
                    player5 = choice;
                    Column5dot4.setImageResource(pictureset[design][choice]);
                    Check();
                    break;
            }

        }
        else if (row == 5){
            switch (slot) {
                case 1:
                    player1 = choice;
                    Column1dot5.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 2:
                    player2 = choice;
                    Column2dot5.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 3:
                    player3 = choice;
                    Column3dot5.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 4:
                    player4 = choice;
                    Column4dot5.setImageResource(pictureset[design][choice]);
                    if(obj == 4) {
                        player5 = bot5;
                        Check();
                    }
                    else{
                        slot++;
                    }
                    break;
                case 5:
                    player5 = choice;
                    Column5dot5.setImageResource(pictureset[design][choice]);
                    Check();
                    break;
            }

        }
        else if (row == 6){
            switch (slot) {
                case 1:
                    player1 = choice;
                    Column1dot6.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 2:
                    player2 = choice;
                    Column2dot6.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 3:
                    player3 = choice;
                    Column3dot6.setImageResource(pictureset[design][choice]);
                    slot++;
                    break;
                case 4:
                    player4 = choice;
                    Column4dot6.setImageResource(pictureset[design][choice]);
                    if(obj == 4) {
                        player5 = bot5;
                        Check();
                    }
                    else{
                        slot++;
                    }
                    break;
                case 5:
                    player5 = choice;
                    Column5dot6.setImageResource(pictureset[design][choice]);
                    Check();
                    break;
            }

        }

    }
    public void checkclue(){

        if(clue == 0){
            hint11.setAlpha(0);
            hint12.setAlpha(0);
            hint13.setAlpha(0);
            hint14.setAlpha(0);
            hint15.setAlpha(0);

            hint21.setAlpha(0);
            hint22.setAlpha(0);
            hint23.setAlpha(0);
            hint24.setAlpha(0);
            hint25.setAlpha(0);

            hint31.setAlpha(0);
            hint32.setAlpha(0);
            hint33.setAlpha(0);
            hint34.setAlpha(0);
            hint35.setAlpha(0);

            hint41.setAlpha(0);
            hint42.setAlpha(0);
            hint43.setAlpha(0);
            hint44.setAlpha(0);
            hint45.setAlpha(0);

            hint51.setAlpha(0);
            hint52.setAlpha(0);
            hint53.setAlpha(0);
            hint54.setAlpha(0);
            hint55.setAlpha(0);

            hint61.setAlpha(0);
            hint62.setAlpha(0);
            hint63.setAlpha(0);
            hint64.setAlpha(0);
            hint65.setAlpha(0);

        }
        else{
            hint11.setAlpha(255);
            hint12.setAlpha(255);
            hint13.setAlpha(255);
            hint14.setAlpha(255);
            hint15.setAlpha(255);

            hint21.setAlpha(255);
            hint22.setAlpha(255);
            hint23.setAlpha(255);
            hint24.setAlpha(255);
            hint25.setAlpha(255);

            hint31.setAlpha(255);
            hint32.setAlpha(255);
            hint33.setAlpha(255);
            hint34.setAlpha(255);
            hint35.setAlpha(255);

            hint41.setAlpha(255);
            hint42.setAlpha(255);
            hint43.setAlpha(255);
            hint44.setAlpha(255);
            hint45.setAlpha(255);

            hint51.setAlpha(255);
            hint52.setAlpha(255);
            hint53.setAlpha(255);
            hint54.setAlpha(255);
            hint55.setAlpha(255);

            hint61.setAlpha(255);
            hint62.setAlpha(255);
            hint63.setAlpha(255);
            hint64.setAlpha(255);
            hint65.setAlpha(255);

        }

    }
    public void checkstg(){
        if(stg == 4){
            hint51.setAlpha(0);
            hint52.setAlpha(0);
            hint53.setAlpha(0);
            hint54.setAlpha(0);
            hint55.setAlpha(0);

            hint61.setAlpha(0);
            hint62.setAlpha(0);
            hint63.setAlpha(0);
            hint64.setAlpha(0);
            hint65.setAlpha(0);

            Column1dot6.setAlpha(0);
            Column2dot6.setAlpha(0);
            Column3dot6.setAlpha(0);
            Column4dot6.setAlpha(0);
            Column5dot6.setAlpha(0);
            try6.setAlpha(0);

            Column1dot5.setAlpha(0);
            Column2dot5.setAlpha(0);
            Column3dot5.setAlpha(0);
            Column4dot5.setAlpha(0);
            Column5dot5.setAlpha(0);
            try5.setAlpha(0);

        }
        else if (stg == 5){
            hint51.setAlpha(255);
            hint52.setAlpha(255);
            hint53.setAlpha(255);
            hint54.setAlpha(255);
            hint55.setAlpha(255);

            hint61.setAlpha(0);
            hint61.setAlpha(0);
            hint61.setAlpha(0);
            hint61.setAlpha(0);
            hint61.setAlpha(0);

            Column1dot6.setAlpha(0);
            Column2dot6.setAlpha(0);
            Column3dot6.setAlpha(0);
            Column4dot6.setAlpha(0);
            Column5dot6.setAlpha(0);
            try6.setAlpha(0);

            Column1dot5.setAlpha(255);
            Column2dot5.setAlpha(255);
            Column3dot5.setAlpha(255);
            Column4dot5.setAlpha(255);
            Column5dot5.setAlpha(255);
            try5.setAlpha(255);

        }
        else{
            hint51.setAlpha(255);
            hint52.setAlpha(255);
            hint53.setAlpha(255);
            hint54.setAlpha(255);
            hint55.setAlpha(255);

            hint61.setAlpha(255);
            hint61.setAlpha(255);
            hint61.setAlpha(255);
            hint61.setAlpha(255);
            hint61.setAlpha(255);

            Column1dot6.setAlpha(255);
            Column2dot6.setAlpha(255);
            Column3dot6.setAlpha(255);
            Column4dot6.setAlpha(255);
            Column5dot6.setAlpha(255);
            try6.setAlpha(255);

            Column1dot5.setAlpha(255);
            Column2dot5.setAlpha(255);
            Column3dot5.setAlpha(255);
            Column4dot5.setAlpha(255);
            Column5dot5.setAlpha(255);
            try5.setAlpha(255);

        }
    }

    public void checkObj(){
        if(obj == 4){

            Column5dot1.setAlpha(0);
            Column5dot2.setAlpha(0);
            Column5dot3.setAlpha(0);
            Column5dot4.setAlpha(0);
            Column5dot5.setAlpha(0);
            Column5dot6.setAlpha(0);
            reveal5.setAlpha(0);
            hint15.setAlpha(0);
            hint25.setAlpha(0);
            hint35.setAlpha(0);
            hint45.setAlpha(0);
            hint55.setAlpha(0);


        }
        else if (obj==5){
            Column5dot1.setAlpha(255);
            Column5dot2.setAlpha(255);
            Column5dot3.setAlpha(255);
            Column5dot4.setAlpha(255);
            Column5dot5.setAlpha(255);
            Column5dot6.setAlpha(255);
            reveal5.setAlpha(255);
            hint15.setAlpha(255);
            hint25.setAlpha(255);
            hint35.setAlpha(255);
            hint45.setAlpha(255);
            hint55.setAlpha(255);


        }
    }

    public void Randomize(){
        final Random rand = new Random();
        if(diff == 1){
            bot1 =rand.nextInt(6)+1;
            bot2 =rand.nextInt(6)+1;
            bot3 =rand.nextInt(6)+1;
            bot4 =rand.nextInt(6)+1;
            bot5 =rand.nextInt(6)+1;
        }
        else if (diff == 2){
            ArrayList list = new ArrayList();
            int array[] = new int[5];
            for (int i=0; i < 6; i++){
                list.add(i+1);
            }
            Collections.shuffle(list);
            for(int a = 0; a < 5;a ++){
                array[a] = (int) list.get(a);
            }
            bot1 = array[0];
            bot2 = array[1];
            bot3 = array[2];
            bot4 = array[3];
            bot5 = array[4];

            Toast.makeText(getApplicationContext(),bot1 + " "  + bot2 + " "+ bot3 + " " + bot4 + " " +bot5, Toast.LENGTH_SHORT).show();
        }
        else{
            diff = (int) Math.random() * 2;
            Randomize();
        }
    }

}
