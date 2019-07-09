package com.qgestures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.carouselRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        CarouselAdapter carouselAdapter = new CarouselAdapter();
        recyclerView.setAdapter(carouselAdapter);

        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                Rect boundingBox = new Rect();
                List<Rect> exclusions = Collections.singletonList(boundingBox);
                boundingBox.set(recyclerView.getLeft(), recyclerView.getTop(), recyclerView.getRight(), recyclerView.getBottom());
                ViewCompat.setSystemGestureExclusionRects(recyclerView, exclusions);
            }
        });


        RecyclerView recyclerView2 = findViewById(R.id.carouselRecyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        CarouselAdapter carouselAdapter2 = new CarouselAdapter();
        recyclerView2.setAdapter(carouselAdapter2);

        Button immersiveButton = findViewById(R.id.buttonImmersiveMode);
        immersiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImmersiveMode();
            }
        });

    }

    private void setImmersiveMode() {
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        // Use 'SYSTEM_UI_FLAG_IMMERSIVE_STICKY' instead of 'SYSTEM_UI_FLAG_IMMERSIVE',
        // if you want to re-enable the immersive mode, when user tap anywhere in the screen or wait for some time.
        int stickyImmersiveModeUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        viewGroup.setSystemUiVisibility(stickyImmersiveModeUiVisibility);

    }
}
