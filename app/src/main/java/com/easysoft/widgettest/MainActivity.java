package com.easysoft.widgettest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.easysoft.widget.R;
import com.easysoft.widget.banner.BannerView;
import com.easysoft.widget.imgeview.MultiShapeView;

import java.util.ArrayList;
import java.util.List;


public  class MainActivity extends AppCompatActivity {

        private MultiShapeView mIvCircleOne;

        private MultiShapeView mIvCircleTwo;

    private int[] imgs = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};

        private MultiShapeView mIvRound;
    private List<View> viewList;
    BannerView bannerView;

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


            viewList = new ArrayList<View>();
            for (int i = 0; i < imgs.length; i++) {
                ImageView image = new ImageView(this);
                image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                //璁剧疆鏄剧ず鏍煎紡
                image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                image.setImageResource(imgs[i]);
                viewList.add(image);
            }
            bannerView = (BannerView) findViewById(R.id.banner);
            bannerView.startLoop(true);

            bannerView.setViewList(viewList);
//        bannerView.setTransformAnim(true);

    }

}
