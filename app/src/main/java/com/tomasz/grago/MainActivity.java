package com.tomasz.grago;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    static TextView textPunkty1;
    static TextView textPunkty2;
    static int dimension = 7;

    static int pointBialy = 0, pointCzarny = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();


        textPunkty1 = (TextView) findViewById(R.id.text1);
        textPunkty2 = (TextView) findViewById(R.id.text2);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setNumColumns(dimension);
        gridview.setAdapter(new PlaneAdapter(this));

        final Plane plansza = new Plane();
        final PointsAdapter pointsAdapter = new PointsAdapter(this);

        final GridView pointsView = (GridView) findViewById(R.id.dots_view);
        pointsView.setNumColumns(dimension);
        pointsView.setAdapter(pointsAdapter);

        //ruch gracza jesli prawda, gra czarny
        final boolean[] ruch = {true};

        pointsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                if (ruch[0]) {
                    Point mPoint = new Point(position, R.drawable.czarny);
                    if (plansza.putPoint(mPoint)) {
                        pointsAdapter.setmThumbIds(plansza.getPoint_pos());
                        textPunkty2.setTextSize(42);
                        textPunkty1.setTextSize(34);
                        ruch[0] = false;
                        pointCzarny += 1;
                    }
                } else {
                    Point mPoint = new Point(position, R.drawable.bialy);
                    if (plansza.putPoint(mPoint)) {
                        pointsAdapter.setmThumbIds(plansza.getPoint_pos());
                        ruch[0] = true;
                        textPunkty2.setTextSize(34);
                        textPunkty1.setTextSize(42);
                        pointBialy += 1;
                    }
                }

                setText(pointBialy, pointCzarny);
                pointsView.setAdapter(pointsAdapter);
            }
        });
    }

    public static void setText(int pointsBialy, int pointsCzarny){
        textPunkty2.setText("" + pointsBialy);
        textPunkty1.setText("" + pointsCzarny);
    }
}
