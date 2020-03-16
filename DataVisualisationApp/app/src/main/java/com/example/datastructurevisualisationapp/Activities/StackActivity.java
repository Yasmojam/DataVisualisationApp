package com.example.datastructurevisualisationapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.datastructurevisualisationapp.R;
import com.example.datastructurevisualisationapp.StackClasses.StackElement;
import com.example.datastructurevisualisationapp.StackClasses.StackStructure;
import com.google.android.material.textfield.TextInputEditText;

/**Class which represents the stack activity.**/
public class StackActivity extends AppCompatActivity {

    private RelativeLayout stackLayout = null;

    private TextInputEditText inputTextBox = null;

    private Button pushButton;
    private Button popButton;
    private Button clearButton;

    StackStructure stack = new StackStructure();

    /**
     * Method which initialises textviews representing empty stack elements,
     * the activity layout, the input textbox, and the push/pop/clear buttons.
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        final TextView[] displayedElements = {
                (TextView) findViewById(R.id.elementView0),
                (TextView) findViewById(R.id.elementView1),
                (TextView) findViewById(R.id.elementView2),
                (TextView) findViewById(R.id.elementView3),
                (TextView) findViewById(R.id.elementView4),
                (TextView) findViewById(R.id.elementView5),
                (TextView) findViewById(R.id.elementView6),
                (TextView) findViewById(R.id.elementView7),
                (TextView) findViewById(R.id.elementView8),
                (TextView) findViewById(R.id.elementView9),
                (TextView) findViewById(R.id.elementView10),
                (TextView) findViewById(R.id.elementView11)}; //list of displayed elements

        //LAYOUT
        stackLayout = (RelativeLayout) findViewById(R.id.stackLayout);

        //INPUT TEXT
        inputTextBox = (TextInputEditText) findViewById(R.id.addStackInput);

        //PUSH BUTTON
        pushButton = findViewById(R.id.pushButton);
        updatePushButton();
        pushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**Method which pushes element to stack and displays it on clicking push button.**/
            public void onClick(View v) {
                //if input isnt empty and stack has space...go!
                if (!getInput().matches("") && !stack.stackFull()) {
                    int i = stack.getStackSize();
                    displayedElements[i].setText(getInput());

                    stack.pushElement(new StackElement(getInput()));

                    inputTextBox.setText("");

                    updateAllButtons();


                } else {
                    return;
                }

            }
        });


        //POP BUTTON
        popButton = findViewById(R.id.popButton);
        updatePopButton();
        popButton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**Method which pops last element in stack and erases the displayed element
             * on clicking pop button.**/
            public void onClick(View v) {
                if (stack.getStackSize() > 0) {
                    int i = stack.getlastStackElementIndex();
                    displayedElements[i].setText("");

                    stack.popElement();

                    updateAllButtons();

                } else {
                    return;
                }
            }
        });

        //CLEAR BUTTON
        clearButton = findViewById(R.id.clearButton);
        updateClearButton();
        clearButton.setOnClickListener(new View.OnClickListener() {
            /**Method which clears stack and all its displayed elements on clicking the clear
             * button.**/
            @Override
            public void onClick(View v) {
                for (TextView textView : displayedElements) {
                    textView.setText("");
                }
                stack.clearStack();

                updateAllButtons();
            }
        });
    }


    /**Method which returns a string of the text inputed to editable text box.**/
    public String getInput() {
        return inputTextBox.getText().toString();
    }

    /**Method which updates the pop button's state of clickability.**/
    public void updatePopButton() {
        if (stack.getStackSize() < 1) {
            popButton.setAlpha(0.5f);
            popButton.setClickable(false);
        } else {
            popButton.setAlpha(1f);
            popButton.setClickable(true);
        }
    }


    /**Method which updates the push button's state of clickability.**/
    public void updatePushButton() {
        if (stack.stackFull()) {
            pushButton.setAlpha(0.5f);
            pushButton.setClickable(false);
        } else {
            pushButton.setAlpha(1f);
            pushButton.setClickable(true);
        }
    }

    public void updateClearButton(){
        if(stack.getStackSize() < 1){
            clearButton.setAlpha(0.5f);
            clearButton.setClickable(false);
        } else {
            clearButton.setAlpha(1f);
            clearButton.setClickable(true);
        }
    }


    /**Method which updates all buttons**/
    public void updateAllButtons(){
        updatePopButton();
        updatePushButton();
        updateClearButton();
    }
}

