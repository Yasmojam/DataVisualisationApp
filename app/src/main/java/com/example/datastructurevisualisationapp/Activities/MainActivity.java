package com.example.datastructurevisualisationapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.datastructurevisualisationapp.R;

/**Class which represents the main activity.**/
public class MainActivity extends AppCompatActivity {
    private Button stackButton;
    private Button queueButton;
    private Button primsButton;

    /**Method which initialises stack/queue/prims buttons.**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stackButton = findViewById(R.id.stackButton);
        queueButton = findViewById(R.id.queueButton);
        primsButton = findViewById(R.id.primButton); //define button


        stackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStackVis();
            }
        });

        queueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQueueVis();
            }
        });

        //set click listener
        primsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrimsAlgVis();
            }
        });


    }

    /**Method which opens the stack visualisation activity.**/
    public void openStackVis(){
        Intent intent = new Intent(this, StackActivity.class);
        startActivity(intent);
    }


    /**Method which opens the queue visualisation activity.**/
    public void openQueueVis(){
        Intent intent = new Intent(this, QueueActivity.class);
        startActivity(intent);
    }


    /**Method which opens the Prim's algorithm visualisation activity.**/
    public void openPrimsAlgVis(){
        Intent intent = new Intent(this, PrimsActivity.class);
        startActivity(intent);
    }
}

