package com.easysoft.widget.config;

/**
 * Created by Administrator on 2019/5/23 0023.
 */

public class WidgetConfig {
    private  static WidgetConfig config;


    public  static  WidgetConfig getInstance(){
        if(config==null){
            config=new WidgetConfig();

        }
        return  config;
    }

    private int bgColor;
    private int textSize;
    private int textColor;
    private int selectedTextColor;
    private int drawablePadding;

    private int iconHeight;
    private int iconWidth;


    private int divideLineColor;
    private int divideLineHeight;

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getSelectedTextColor() {
        return selectedTextColor;
    }

    public void setSelectedTextColor(int selectedTextColor) {
        this.selectedTextColor = selectedTextColor;
    }

    public int getDrawablePadding() {
        return drawablePadding;
    }

    public void setDrawablePadding(int drawablePadding) {
        this.drawablePadding = drawablePadding;
    }

    public int getIconHeight() {
        return iconHeight;
    }

    public void setIconHeight(int iconHeight) {
        this.iconHeight = iconHeight;
    }

    public int getIconWidth() {
        return iconWidth;
    }

    public void setIconWidth(int iconWidth) {
        this.iconWidth = iconWidth;
    }

    public int getDivideLineColor() {
        return divideLineColor;
    }

    public void setDivideLineColor(int divideLineColor) {
        this.divideLineColor = divideLineColor;
    }

    public int getDivideLineHeight() {
        return divideLineHeight;
    }

    public void setDivideLineHeight(int divideLineHeight) {
        this.divideLineHeight = divideLineHeight;
    }
}
