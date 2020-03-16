package com.example.datastructurevisualisationapp.PrimsClasses;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**Class which represents a DrawView of the edges.**/
public class DrawView extends View {

    Paint paint = new Paint();

    Vertex vertex1 = null;
    Vertex vertex2 = null;

    /**Method which sets the colour and width of displayed edge.**/
    private void init(){
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
    }

    public DrawView(Context context) {
        super(context);
        init();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /**Method which sets the vertex at the start of the edge.**/
    public void setVertex1(Vertex vertex1) {
        this.vertex1 = vertex1;
    }

    /**Method which sets the vertex at the end of the edge.**/
    public void setVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
    }

    /**Method which draws a line between coordinate of one vertex to another.**/
    @Override
    public void onDraw(Canvas canvas){
        canvas.drawLine(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(), paint);
    }
}
