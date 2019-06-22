package com.easysoft.widgettest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.easysoft.widget.R;
import com.easysoft.widget.banner.BannerView;
import com.easysoft.widget.config.IWidgetConfig;
import com.easysoft.widget.config.WidgetConfigManger;
import com.easysoft.widget.imgeview.MultiShapeView;
import com.easysoft.widget.search.SearchHeadView;
import com.easysoft.widget.tabview.widget.TabContainerView;
import com.easysoft.widget.toolbar.NavigationBar;
import com.easysoft.widget.toolbar.TopBarBuilder;

import java.util.List;

import fragmenttrasitionextend.FragmentDyActivity;


public  class MainActivity extends Activity {

        private MultiShapeView mIvCircleOne;

        private MultiShapeView mIvCircleTwo;

    private int[] imgs = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
    private String[] nameArrayList = new String[] {"首页", "订单","资讯","设置"};

        private MultiShapeView mIvRound;
    private List<View> viewList;
    BannerView bannerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//


            IWidgetConfig configTab=   WidgetConfigManger.getInstance().getiWidgetConfig();
            configTab.setTextColor(getResources().getColor(R.color.black));
            configTab.setBgColor(getResources().getColor(R.color.black));
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.toolbar);
            TabContainerView containerView = (TabContainerView) findViewById(R.id.tabView);
            SearchHeadView searchHeadView = (SearchHeadView) findViewById(R.id.searchHead);
            Button btnTest = (Button) findViewById(R.id.btnTest);

            TopBarBuilder.buildCenterTextTitle(navigationBar, this, "this is title", 0);

            TopBarBuilder.buildOnlyText(navigationBar,this, NavigationBar.Location.RIGHT_FIRST,"change",0);


            navigationBar.setTextColorByLocation(NavigationBar.Location.CENTER,getResources().getColor(R.color.context_bg_blue));

            containerView.setBackgroundColor(getResources().getColor(R.color.black));
            containerView.resetConfig();



            btnTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this, FragmentDyActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            });

    }

}
