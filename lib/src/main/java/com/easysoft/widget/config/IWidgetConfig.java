package com.easysoft.widget.config;

/**
 * Created by Administrator on 2019/6/22 0022.
 */

public interface IWidgetConfig {


    public int getBgColor();


    public int getTextSize();



    public int getTextColor() ;


    public int getSelectedTextColor();



    public int getDrawablePadding();


    public int getIconHeight();


    public int getIconWidth();


    public int getDivideLineColor();


    public int getDivideLineHeight();


    public IWidgetConfig setBgColor(int bgColor);
    public IWidgetConfig setTextSize(int textSize);
    public IWidgetConfig setTextColor(int textColor);


    public IWidgetConfig setSelectedTextColor(int selectedTextColor);
    public IWidgetConfig setDrawablePadding(int drawablePadding) ;
    public IWidgetConfig setIconHeight(int iconHeight);
    public IWidgetConfig setIconWidth(int iconWidth);
    public IWidgetConfig setDivideLineColor(int divideLineColor);

    public IWidgetConfig setDivideLineHeight(int divideLineHeight) ;

}
