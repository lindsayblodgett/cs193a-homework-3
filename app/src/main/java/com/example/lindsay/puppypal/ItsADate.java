package com.example.lindsay.puppypal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class ItsADate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_its_a_date);
        displayConfirmation();
        loadSelectedPuppy();
    }

    private void displayConfirmation(){
        YoYo.with(Techniques.Tada)
                //.delay(100)
                .duration(5000)
                .playOn(findViewById(R.id.confirmation_message));
    }
    private void loadSelectedPuppy() {
        Intent intent = getIntent();
        Bitmap imageBitMap = (Bitmap) intent.getParcelableExtra("puppy_bitmap");
        ImageView selectedPuppy = (ImageView) findViewById(R.id.selected_puppy_image);
        selectedPuppy.setImageBitmap(imageBitMap);
    }

    public void backToBrowsing(View view) {
        Intent intent = new Intent(this, BrowsePuppies.class);
        startActivity(intent);
    }
}
