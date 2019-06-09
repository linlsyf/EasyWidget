package com.easysoft.widget.tabview.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public abstract class BaseAdapter {

    public abstract int getCount();
    public abstract int hasMsgIndex();

    public abstract String[] getTextArray();


    public abstract int[] getIconImageArray();


    public abstract int[] getSelectedIconImageArray();


    public abstract Fragment[] getFragmentArray();

    public abstract FragmentManager getFragmentManager();



}
