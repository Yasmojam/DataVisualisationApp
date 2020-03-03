package com.example.datastructurevisualisationapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.datastructurevisualisationapp.PrimsClasses.DrawView;
import com.example.datastructurevisualisationapp.PrimsClasses.Edge;
import com.example.datastructurevisualisationapp.PrimsClasses.PrimsAlg;
import com.example.datastructurevisualisationapp.PrimsClasses.Vertex;
import com.example.datastructurevisualisationapp.R;

import java.util.ArrayList;

/**Class which represents Prim's algorithm activity page**/
public class PrimsActivity extends AppCompatActivity {

    private RelativeLayout primsLayout = null;

    private Button resetButton;
    private Button startButton;
    int touchNum = 0;
    private boolean primHasRun = false;

    PrimsAlg primsAlg = new PrimsAlg();
    DrawView drawView; //drawn edges view
    TextView textView; //Weight text view

    ArrayList<ImageView> vertexImages = new ArrayList<ImageView>(); //list of drawn vertices
    ArrayList<DrawView> drawnEdges = new ArrayList<DrawView>(); //list of drawn edges
    ArrayList<TextView> displayedWeights = new ArrayList<TextView>(); //list of displayed weights

    /**Method which initialises relative layout, reset/start buttons, and touch listener for
     * vertex image creation.**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prims);

        //LAYOUT
        primsLayout = (RelativeLayout) findViewById(R.id.primsLayout);



        //RESET BUTTON
        resetButton = findViewById(R.id.resetButton); //define button
        updateResetButton();
        resetButton.setOnClickListener(new View.OnClickListener() { //set click listener
            @Override
            /**Method which calls reset on click.**/
            public void onClick(View v) {
                resetAlg();
                updateAllButtons();
            }
        });

        //START BUTTON
        startButton = findViewById(R.id.startButton);
        updateStartButton();
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            /**Method which starts Prim's Algorithm on clicking start button.**/
            public void onClick(View v){
                if (primsAlg.getUnvisitedSize() > 0){
                    primsAlg.runPrims();
                    setPrimHasRun(true);
                    drawEdges();
                    updateAllButtons();
                }
            }
        });


        primsLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            /**Method which creates a vertex in unvisited arraylist and an image on screen when tapped tap.*/
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN && !getPrimHasRun()) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    touchNum++; //add a touch counter to use for vertex ids

                    RelativeLayout.LayoutParams frame = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    ImageView vertexPng = new ImageView((getApplicationContext()));
                    frame.setMargins(x-32, y-32, 0, 0);  //-32 makes it centred
                    vertexPng.setLayoutParams(frame);
                    vertexPng.setImageDrawable(getResources().getDrawable(R.drawable.vertex));
                    ((ViewGroup) v).addView(vertexPng);

                    addPng(vertexPng);

                    primsAlg.addUnvisited(new Vertex(touchNum, x, y));

                    //check coords
                    System.out.println(String.valueOf(x));
                    System.out.println(String.valueOf(y));

                    updateAllButtons();
                }
                return false;
            }
        });
    }

    /**Method which returns true if Prim's algorithm has been run on the onscreen vertices.**/
    public boolean getPrimHasRun(){
        return primHasRun;
    }

    /**Method which sets if Prim's algorithm has been run on the onscreen vetices.**/
    public void setPrimHasRun(Boolean bool){
        primHasRun = bool;
    }

    /**Method which displays calculated edges**/
    public void drawEdges(){
        for (Edge edge : primsAlg.getEdges()){
            //DRAW VIEW
            drawView = new DrawView(this);
            drawView.setVertex1(edge.getVertex1());
            drawView.setVertex2(edge.getVertex2());
            primsLayout.addView(drawView);

            addEdge(drawView);

            showWeight(edge);

        }
    }

    /**Method which displays the weight of each edge at its midpoint.**/
    public void showWeight(Edge edge){
        textView = new TextView(this);
        textView.setX(edge.getMidX());
        textView.setY(edge.getMidY());
        textView.setBackgroundColor(Color.WHITE);
        textView.setText(String.valueOf(Math.round(edge.getWeight()))); //round weight to display ints
        primsLayout.addView(textView);

        addWeight(textView);
    }

    /**Method which adds ImageView of vertex png to list of vertex images.**/
    public void addPng(ImageView png){
        vertexImages.add(png);
    }

    /**Method which adds DrawView of edges to list of displayed edges.**/
    public void addEdge(DrawView edge){
        drawnEdges.add(edge);
    }

    /**Method which adds TextView of weight of drawn edges to list of displayed weights.**/
    public void addWeight(TextView weight){
        displayedWeights.add(weight);
    }

    /**Method which calls clears unvisited, visited, edges, and Views: ImageViews,
     * DrawViews, TextViews from display and thier corresponding array lists.
     * Sets the status of has Prim's run to false.
     * Updates all buttons.**/
    public void resetAlg(){
        //clear prims presets
        primsAlg.clearUnvisited();
        primsAlg.clearVisited();
        primsAlg.clearEdges();

        //delete vertex images in arraylist
        for (ImageView vertex : vertexImages){
            primsLayout.removeView(vertex);
        }

        //delete drawn edge in arraylist
        for (DrawView drawnEdge : drawnEdges){
            primsLayout.removeView(drawnEdge);
        }

        //delete displayed weight in arraylist
        for (TextView displayWeight : displayedWeights){
            primsLayout.removeView(displayWeight);
        }

        //clear vertex images arrayList
        vertexImages.clear();

        //clear lines arrayList
        drawnEdges.clear();

        //clear weights arrayList
        displayedWeights.clear();

        //set prims run status
        setPrimHasRun(false);

        updateAllButtons();
    }

    /**Method which updates the start button's state of clickability**/
    public void updateStartButton(){
        if (getPrimHasRun() == true){
            startButton.setAlpha(0.5f);
            startButton.setClickable(false);
        } else {
            startButton.setAlpha(1f);
            startButton.setClickable(true);
        }
    }

    /**Method which updates the reset button's state of clickability**/
    public void updateResetButton(){
        if (vertexImages.size() < 1){
            resetButton.setAlpha(0.5f);
            resetButton.setClickable(false);
        }
        else {
            resetButton.setAlpha(1f);
            resetButton.setClickable(true);
        }
    }

    /**Updates the clickability of all buttons**/
    public void updateAllButtons(){
        updateStartButton();
        updateResetButton();
    }
}
