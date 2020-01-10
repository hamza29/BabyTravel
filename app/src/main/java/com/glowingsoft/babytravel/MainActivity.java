package com.glowingsoft.babytravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cunoraz.gifview.library.GifView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GifView gifView1 = (GifView) findViewById(R.id.gif1);
        btn = findViewById(R.id.btnClick);
        gifView1.setVisibility(View.VISIBLE);
        gifView1.setGifResource(R.drawable.mennuanim);
        gifView1.play();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });


    }
}
