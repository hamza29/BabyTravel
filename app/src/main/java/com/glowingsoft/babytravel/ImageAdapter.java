package com.glowingsoft.babytravel;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Activity mContext;
    ArrayList<GameActivity.GameModel> arrayList;
    GridView gridView;
    ImageAdapter imageAdapter;

    // Constructor
    public ImageAdapter(Activity c, ArrayList<GameActivity.GameModel> arrayList, GridView gridView) {
        mContext = c;
        this.arrayList = arrayList;
        this.gridView = gridView;
    }

    public int getCount() {
        return arrayList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;

        }
//        if (arrayList.get(position).check == false) {
//            imageView.clearAnimation();
//            imageView.setAnimation(null);
//        }
//        else{
//            imageView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.woble));
//
//        }
        if (arrayList.get(position).check) {
//            imageView.clearAnimation();
//            imageView.setAnimation(null);
            imageView.setImageResource(arrayList.get(position).getImg());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    imageView.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.woble));

                    Toast.makeText(mContext, "Poped", Toast.LENGTH_SHORT).show();
                    arrayList.remove(position);
                    ImageAdapter imageAdapter = new ImageAdapter(mContext, arrayList, gridView);

                    gridView.setAdapter(imageAdapter);
                    final MediaPlayer mp = MediaPlayer.create(mContext, R.raw.bubble_blast);
                    mp.start();


                }
            });
        }

        return imageView;
    }

}