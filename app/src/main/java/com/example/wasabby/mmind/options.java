package com.example.wasabby.mmind;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;

public class options extends AppCompatActivity {
    Spinner spinObject, spinStage, diff;
    ImageButton back;
    int getObject, getStage;
    Intent menu;
    int cluevalue, diffvalue;
    Switch clue;
    Bundle bundle;
    int stage, object, diffs, clues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        menu = new Intent(options.this, MainActivity.class);
        spinObject = (Spinner)findViewById(R.id.object);
        spinStage = (Spinner)findViewById(R.id.stage);
        back = (ImageButton)findViewById(R.id.btnBack);
        clue = (Switch)findViewById(R.id.clue);
        diff = (Spinner)findViewById(R.id.diff);
        try{
            stage = getIntent().getIntExtra("stages", 4);
            object = getIntent().getIntExtra("objects", 4);
            diffs = getIntent().getIntExtra("random", 2);
            clues = getIntent().getIntExtra("clues", 1);
            if(stage == 4){
                spinStage.setSelection(0);
            }
            else if (stage == 5){
                spinStage.setSelection(1);
            }
            else if (stage == 6){
                spinStage.setSelection(2);
            }

            if(object == 4){
                spinObject.setSelection(0);
            }
            else if (object == 5){
                spinObject.setSelection(1);
            }

            if(diffs == 1){
                diff.setSelection(0);
            }
            else if (diffs == 2){
                diff.setSelection(1);
            }
            else if (diffs == 3){
                diff.setSelection(2);
            }

            if(clues == 0){
                clue.setChecked(false);
            }
            else if (clues == 1){
                clue.setChecked(true);
            }
        }catch (Exception e){

        }

        spindiff();
        spinObject();
        spinStage();
        back();
    }
    private void spindiff(){
    diff.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            diffvalue = i+1;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
    }
    private void back()
    {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clue.isChecked()){
                cluevalue = 1;
                }
                else{
                    cluevalue = 0;
                }
                menu.putExtra("getObject", getObject);
                menu.putExtra("getStage", getStage);
                menu.putExtra("getClue", cluevalue);
                menu.putExtra("getDiff", diffvalue);
                startActivity(menu);
            }
        });
    }
    private void spinObject()
    {
        spinObject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getObject = i+4;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void spinStage()
    {
        spinStage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getStage = i+4;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}