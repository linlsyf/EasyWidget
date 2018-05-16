package com.easysoft.widgettest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.easysoft.widget.R;
import com.easysoft.widget.imgeview.MultiShapeView;


public  class MainActivity extends AppCompatActivity {

        private MultiShapeView mIvCircleOne;

        private MultiShapeView mIvCircleTwo;


        private MultiShapeView mIvRound;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mIvCircleOne = (MultiShapeView) findViewById(R.id.iv_circle_one);
            mIvCircleTwo = (MultiShapeView) findViewById(R.id.iv_circle_two);
            mIvRound  = (MultiShapeView) findViewById(R.id.iv_round);
            mIvCircleOne.setImageResource(R.drawable.photo_one);
            mIvCircleTwo.setImageResource(R.drawable.photo_two);
            mIvRound.setImageDrawable(getResources().getDrawable(R.drawable.photo_three));


    }
}
