package com.example.utsav.blurdialog;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
Button button;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         linearLayout = (LinearLayout) findViewById(R.id.llmain);
        button=findViewById(R.id.button);
        final ImageView  imageView=findViewById(R.id.ivphoto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap b = getScreenShot(linearLayout);
                b=BlurBuilder.blur(MainActivity.this,b);
                Drawable drawable = new BitmapDrawable(getResources(), b);
                linearLayout.setBackground(drawable);
              //  imageView.setImageBitmap(b);
            }
        });



    }
    public static Bitmap getScreenShot(View view) {
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
    }
}
