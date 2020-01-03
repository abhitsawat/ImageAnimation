package com.example.teraterah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    //Array of image Ids to show in imgeshowe
    int img[] = {R.drawable.image_one, R.drawable.image_two, R.drawable.image_three, R.drawable.image_four};
    int cont = img.length;
    // to current index of index IDs
    int currentIndex = -1;
    ImageSwitcher imageSwitcher;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = findViewById(R.id.imageSwiter);
        b = findViewById(R.id.button);
        // set the ViewFactory of the ImageSwiter that will create ImageView object when asked
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                // TODO Auto-generted method stub
                // Create a new ImageView and set It's proprties
                ImageView imageView = new ImageView(getApplicationContext());
                //set Scale type of ImageView to fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //set the hight and width of Imageview to fill PARENT
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                return imageView;
            }
        });
        Animation in= AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        Animation out=AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setInAnimation(out);






        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                //Cheak If index reaches maximum then reset it
                if (currentIndex == cont) {
                    currentIndex = 0;
                }
                imageSwitcher.setImageResource(img[currentIndex]);
            }
        });

    }

}
