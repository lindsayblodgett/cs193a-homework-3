package com.example.lindsay.puppypal;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import java.util.Random;
import android.graphics.Bitmap;

public class BrowsePuppies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_puppies);
        loadPuppy();
    }

    public void loadPuppy() {
        TextView dateActivity= (TextView) findViewById(R.id.introMessage);
        dateActivity.setText(loadDateActivity());
        loadPhoto();
    }

    private String loadDateActivity() {
        String[] messageArray = getResources().getStringArray(R.array.date_activities);
        Random random = new Random();
        int activityIndex = random.nextInt(messageArray.length);
        return messageArray[activityIndex];
    }

    private void loadPhoto() {
        ImageView puppyImage = (ImageView) findViewById(R.id.puppy_image);
        String[] puppyImageIds = getResources().getStringArray(R.array.puppy_photo_urls);
        Random random = new Random();
        int puppyIndex = random.nextInt(puppyImageIds.length);
        String selectedPuppy = puppyImageIds[puppyIndex];
        Picasso.with(this)
                .load("http://cdn.cutestpaw.com/wp-content/uploads/2011/11/" + selectedPuppy)
                .into(puppyImage);
    }

    public void refresh(View view) {
        loadPuppy();
    }

    public void beginDate(View view) {
        Intent intent = new Intent(this, ItsADate.class);
        ImageView selected = (ImageView) findViewById(R.id.puppy_image);
        Bitmap imageBitMap = selected.getDrawingCache();
        intent.putExtra("puppy_bitmap", imageBitMap);
        startActivity(intent);
    }
}
