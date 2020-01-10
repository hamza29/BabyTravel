package com.glowingsoft.babytravel;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    ArrayList<GameModel> arrayList = new ArrayList<>();
    ImageAdapter imageAdapter;
    GridView gridview;
    Integer random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gridview = (GridView) findViewById(R.id.gridview);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                arrayList.clear();

                arrayList.add(new GameModel(false, R.drawable.blue));
                arrayList.add(new GameModel(false, R.drawable.orng));
                arrayList.add(new GameModel(false, R.drawable.pink));
                arrayList.add(new GameModel(false, R.drawable.purpl));
                arrayList.add(new GameModel(false, R.drawable.green));
                arrayList.add(new GameModel(false, R.drawable.blue));
                arrayList.add(new GameModel(false, R.drawable.orng));
                arrayList.add(new GameModel(false, R.drawable.pink));
                arrayList.add(new GameModel(false, R.drawable.purpl));
                arrayList.add(new GameModel(false, R.drawable.green));
                arrayList.add(new GameModel(false, R.drawable.blue));
                arrayList.add(new GameModel(false, R.drawable.orng));
                arrayList.add(new GameModel(false, R.drawable.pink));
                arrayList.add(new GameModel(false, R.drawable.purpl));
                arrayList.add(new GameModel(false, R.drawable.green));
                arrayList.add(new GameModel(false, R.drawable.blue));
                arrayList.add(new GameModel(false, R.drawable.orng));
                arrayList.add(new GameModel(false, R.drawable.pink));
                arrayList.add(new GameModel(false, R.drawable.purpl));
                arrayList.add(new GameModel(false, R.drawable.green));
                arrayList.add(new GameModel(false, R.drawable.blue));
                arrayList.add(new GameModel(false, R.drawable.orng));
                arrayList.add(new GameModel(false, R.drawable.pink));
                arrayList.add(new GameModel(false, R.drawable.purpl));
                arrayList.add(new GameModel(false, R.drawable.green));

                List<Integer> list = new ArrayList<Integer>();
                list.add(R.drawable.orng);
                list.add(R.drawable.blue);
                list.add(R.drawable.green);
                list.add(R.drawable.pink);
                Random rand = new Random();
                Random r1 = new Random();
                int i2 = r1.nextInt(8 - 3) + 3;
//                Toast.makeText(GameActivity.this, "" + i2, Toast.LENGTH_SHORT).show();
                for (int i = 0; i < i2; i++) {
                    Random r = new Random();
                    int i1 = r.nextInt(24 - 0) + 0;
                    random = list.get(rand.nextInt(list.size()));
                    arrayList.set(i1, new GameModel(true, random));

                }
                imageAdapter = new ImageAdapter(GameActivity.this, arrayList, gridview);
                gridview.setAdapter(imageAdapter);
                handler.postDelayed(this, 3000);
//                gridview.setAdapter(null);

            }
        }, 3000);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                // Send intent to SingleViewActivity
                Toast.makeText(GameActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.aus), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.bal), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.braz), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.chna), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.egy), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.grndcann), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.inda), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.itly), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.jpn), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.pars), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.psa), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.san), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.turk), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.u_s), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.u_k), 5000);
        animation.setOneShot(false);

        ImageView imageAnim = (ImageView) findViewById(R.id.image);
        imageAnim.setBackgroundDrawable(animation);

        // start the animation!
        animation.start();
    }

    public static class GameModel {

        boolean check;
        Integer img;


        public GameModel(boolean check, Integer img) {
            this.check = check;
            this.img = img;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public Integer getImg() {
            return img;
        }

        public void setImg(Integer img) {
            this.img = img;
        }
    }
}
