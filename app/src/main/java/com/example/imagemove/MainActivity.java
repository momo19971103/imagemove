package com.example.imagemove;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {
    int index = 100;
    Button btn;
    RelativeLayout  MyReLayOut;
    ImageView img;
    int i = 0;
    final int[] chess = {
            R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6,
            R.drawable.b7, R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5,
            R.drawable.r6, R.drawable.r7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(onClickListener);
        MyReLayOut = (RelativeLayout ) findViewById(R.id.test1);//https://blog.csdn.net/fsx_xiaomei/article/details/78386589
    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub
            int mx, my;
            int test = v.getId();
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:

                    RelativeLayout.LayoutParams layoutParams
                            = (RelativeLayout.LayoutParams) v.getLayoutParams();
                    layoutParams.leftMargin = (int) event.getRawX();
                    layoutParams.topMargin = (int) event.getRawY();
                    v.setLayoutParams(layoutParams);
                    break;

            }

            return true;
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            ImageView img1 = new ImageView(MainActivity.this);
            index += 1;
            img1.setId(index);

            int test = img1.getId();
            img1 = new ImageView(getApplicationContext());
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), chess[i]);
            img1.setImageBitmap(bitmap);
            RelativeLayout.LayoutParams param =new RelativeLayout.LayoutParams(115,115);
            MyReLayOut.addView(img1, param);

            img1.setOnTouchListener(touchListener);
            i++;

        }
    };

}