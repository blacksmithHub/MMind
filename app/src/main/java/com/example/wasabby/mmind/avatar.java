package com.example.wasabby.mmind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class avatar extends AppCompatActivity {

    ImageView frame, avatars, bg;
    ImageButton back;
    RadioButton halloween, emoji, variety;
    RadioGroup radios;
    int val,avt;
    Intent menu;
    Bundle bundle;
    private boolean isSpeakButtonLongPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        menu = new Intent(avatar.this, MainActivity.class);

        frame = (ImageView) findViewById(R.id.frame);
        avatars = (ImageView) findViewById(R.id.avatars);
        bg = (ImageView)findViewById(R.id.bg);

        back = (ImageButton)findViewById(R.id.btnBack);

        radios = (RadioGroup)findViewById(R.id.RadioGroup);

        halloween = (RadioButton) findViewById(R.id.halloween);
        emoji = (RadioButton) findViewById(R.id.emoji);
        variety = (RadioButton) findViewById(R.id.variety);

        frame.setOnLongClickListener(HoldListener);
        frame.setOnTouchListener(TouchListener);

        val = 1;
        halloween.setChecked(true);

        halloween();
        emoji();
        variety();
        back();

        try
        {
            bundle = getIntent().getExtras();
            avt = bundle.getInt("setAvatar");

            if(avt == 0)
            {
                halloween.setChecked(true);
                frame.setImageResource(R.drawable.halloween);
                avatars.setImageResource(R.drawable.halloweenpreview1);
            }
            else if(avt == 1)
            {
                emoji.setChecked(true);
                frame.setImageResource(R.drawable.emojis);
                avatars.setImageResource(R.drawable.emojipreview);
            }
            else if(avt == 2)
            {
                variety.setChecked(true);
                frame.setImageResource(R.drawable.variety);
                avatars.setImageResource(R.drawable.varietypreview);
            }

        }
        catch (Exception e)
        {

        }

    }

    private void back()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menu.putExtra("setAvatar", val);
                startActivity(menu);
            }
        });
    }

    private void halloween() {

        halloween.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (halloween.isChecked() == true) {
                    frame.setImageResource(R.drawable.halloween);
                    avatars.setImageResource(R.drawable.halloweenpreview1);
                    val = 0;
                }
            }
        });

    }

    private void emoji() {

        emoji.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (emoji.isChecked() == true) {
                    frame.setImageResource(R.drawable.emojis);
                    avatars.setImageResource(R.drawable.emojipreview);
                    val = 1;
                }
            }
        });

    }

    private void variety() {

        variety.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (variety.isChecked() == true) {
                    frame.setImageResource(R.drawable.variety);
                    avatars.setImageResource(R.drawable.varietypreview);
                    val = 2;
                }
            }
        });



    }

    private View.OnLongClickListener HoldListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View pView) {
            avatars.setVisibility(View.VISIBLE);
            frame.setAlpha(100);
            bg.setAlpha(100);
            back.setAlpha(100);
            radios.setAlpha(0);
            isSpeakButtonLongPressed = true;
            return true;
        }
    };

    private View.OnTouchListener TouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View pView, MotionEvent pEvent) {
            pView.onTouchEvent(pEvent);
            if (pEvent.getAction() == MotionEvent.ACTION_UP) {
                if (isSpeakButtonLongPressed) {
                    avatars.setVisibility(View.INVISIBLE);
                    frame.setAlpha(255);
                    bg.setAlpha(255);
                    back.setAlpha(255);
                    radios.setAlpha(1);
                    isSpeakButtonLongPressed = false;
                }
            }
            return false;
        }
    };

}
