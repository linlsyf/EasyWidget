package com.easysoft.widget.tabview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


/**
 * Created by chengxi on 17/4/26.
 */
public class MainViewAdapter extends BaseAdapter {

    private Fragment[] fragmentArray;
    private FragmentManager fragmentManager;
    private int hasMsgIndex=0;
    int[]  iconImageArray  ;
    int[]  selectedIconImageArray;
    String[]  tabNameArray;

    public void setHasMsgIndex(int hasMsgIndex) {
        this.hasMsgIndex = hasMsgIndex;
    }

    public MainViewAdapter(FragmentManager fragmentManager, Fragment[] fragmentArray) {
        this.fragmentManager = fragmentManager;
        this.fragmentArray = fragmentArray;
    }

    @Override
    public int getCount() {
        return 4;
//        return 5;
    }

    @Override
    public int hasMsgIndex() {
        return hasMsgIndex;
    }


    @Override
    public String[] getTextArray() {
        return tabNameArray;
//        return new String[] {"首页", "订单","资讯","设置"};
//        return new String[] {"首页", "分类", "惊喜", "购物车","我的"};
    }

    @Override
    public Fragment[] getFragmentArray() {
        return fragmentArray;
    }

    @Override
    public int[] getIconImageArray() {
        return  iconImageArray;
//        return new int[] {R.drawable.new_life_icon_grey, R.drawable.new_shoppingcar_icon_grey,R.drawable.new_find_icon_grey,R.drawable.new_myhome_icon_grey};
//        return new int[] {R.drawable.new_life_icon_grey, R.drawable.new_find_icon_grey, R.drawable.new_fininal_icon_grey, R.drawable.new_shoppingcar_icon_grey,R.drawable.new_myhome_icon_grey};
    }

    @Override
    public int[] getSelectedIconImageArray() {
        return selectedIconImageArray;
//        return new int[] {R.drawable.new_life_icon, R.drawable.new_shoppingcar_icon,R.drawable.new_find_icon,R.drawable.new_myhome_icon};
//        return new int[] {R.drawable.new_life_icon, R.drawable.new_find_icon, R.drawable.new_finial_icon, R.drawable.new_shoppingcar_icon,R.drawable.new_myhome_icon};
    }

    public void setIconImageArray(int[] iconImageArray) {
        this.iconImageArray = iconImageArray;
    }

    public void setSelectedIconImageArray(int[] selectedIconImageArray) {
        this.selectedIconImageArray = selectedIconImageArray;
    }

    public String[] getTabNameArray() {
        return tabNameArray;
    }

    public void setTabNameArray(String[] tabNameArray) {
        this.tabNameArray = tabNameArray;
    }

    @Override
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }
}
