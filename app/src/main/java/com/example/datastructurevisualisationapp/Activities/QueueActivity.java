package com.example.datastructurevisualisationapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.datastructurevisualisationapp.R;
import com.example.datastructurevisualisationapp.QueueClasses.QueueElement;
import com.example.datastructurevisualisationapp.QueueClasses.QueueStructure;
import com.google.android.material.textfield.TextInputEditText;

/**Class which represents the queue activity.**/
public class QueueActivity extends AppCompatActivity {

    private RelativeLayout queueLayout = null;

    private TextInputEditText inputTextBox = null;

    private Button enqueueButton;
    private Button dequeueButton;
    private Button clearButton;

    QueueStructure queue = new QueueStructure();

    /**
     * Method which initialises textviews representing empty queue elements,
     * the activity layout, the input textbox, and the enqueue/dequeue/clear buttons.
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        final TextView[] displayedElements = {
                (TextView) findViewById(R.id.elementQView0),
                (TextView) findViewById(R.id.elementQView1),
                (TextView) findViewById(R.id.elementQView2),
                (TextView) findViewById(R.id.elementQView3),
                (TextView) findViewById(R.id.elementQView4),
                (TextView) findViewById(R.id.elementQView5),
                (TextView) findViewById(R.id.elementQView6),
                (TextView) findViewById(R.id.elementQView7),
                (TextView) findViewById(R.id.elementQView8),
                (TextView) findViewById(R.id.elementQView9),
                (TextView) findViewById(R.id.elementQView10),
                (TextView) findViewById(R.id.elementQView11)}; //list of displayed elements

        //LAYOUT
        queueLayout = (RelativeLayout) findViewById(R.id.queueLayout);

        //INPUT TEXT
        inputTextBox = (TextInputEditText) findViewById(R.id.addQueueInput);

        //ENQUEUE BUTTON
        enqueueButton = findViewById(R.id.enqueueButton);
        updateEnqueueButton();
        enqueueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**Method which enqueuees element to queue and displays it on clicking enqueue button.**/
            public void onClick(View v) {
                //if input isn't empty and queue has space...go!
                if (!getInput().matches("") && !queue.queueFull()) {
                    int i = queue.getQueueSize();
                    displayedElements[i].setText(getInput());

                    queue.enqueueElement(new QueueElement(getInput()));

                    inputTextBox.setText("");

                    updateAllButtons();


                } else {
                    return;
                }

            }
        });


        //DEQUEUE BUTTON
        dequeueButton = findViewById(R.id.dequeueButton);
        updateDequeueButton();
        dequeueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**Method which dequeues last element in queue and erases the displayed element
             * on clicking dequeue button.**/
            public void onClick(View v) {
                if (queue.getQueueSize() > 0) {
                    for (TextView elementText : displayedElements){
                        if (elementText.getText() != ""){
                            elementText.setText("");
                            break;
                        }
                        else{
                            continue;
                        }
                    }

                    queue.dequeueElement();

                    updateAllButtons();

                } else {
                    return;
                }
            }
        });

        //CLEAR BUTTON
        clearButton = findViewById(R.id.clearQueueButton);
        updateClearButton();
        clearButton.setOnClickListener(new View.OnClickListener() {
            /**Method which clears queue and all its displayed elements on clicking the clear
             * button.**/
            @Override
            public void onClick(View v) {
                for (TextView textView : displayedElements) {
                    textView.setText("");
                }
                queue.clearqueue();

                updateAllButtons();
            }
        });
    }


    /**Method which returns a string of the text inputed to editable text box.**/
    public String getInput() {
        return inputTextBox.getText().toString();
    }

    /**Method which updates the dequeue button's state of clickability.**/
    public void updateDequeueButton() {
        if (queue.getQueueSize() < 1) {
            dequeueButton.setAlpha(0.5f);
            dequeueButton.setClickable(false);
        } else {
            dequeueButton.setAlpha(1f);
            dequeueButton.setClickable(true);
        }
    }


    /**Method which updates the enqueue button's state of clickability.**/
    public void updateEnqueueButton() {
        if (queue.queueFull()) {
            enqueueButton.setAlpha(0.5f);
            enqueueButton.setClickable(false);
        } else {
            enqueueButton.setAlpha(1f);
            enqueueButton.setClickable(true);
        }
    }

    public void updateClearButton(){
        if(queue.getQueueSize() < 1){
            clearButton.setAlpha(0.5f);
            clearButton.setClickable(false);
        } else {
            clearButton.setAlpha(1f);
            clearButton.setClickable(true);
        }
    }


    /**Method which updates all buttons**/
    public void updateAllButtons(){
        updateDequeueButton();
        updateEnqueueButton();
        updateClearButton();
    }
}

