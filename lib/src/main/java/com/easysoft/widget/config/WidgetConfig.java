package com.easysoft.widget.config;

/**
 * Created by Administrator on 2019/5/23 0023.
 */

public class WidgetConfig implements IWidgetConfig {
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

    public WidgetConfig setBgColor(int bgColor) {
        this.bgColor = bgColor; return  this;
    }

    public int getTextSize() {
        return textSize;
    }

    public WidgetConfig setTextSize(int textSize) {
        this.textSize = textSize; return  this;
    }

    public int getTextColor() {
        return textColor;
    }

    public WidgetConfig setTextColor(int textColor) {
        this.textColor = textColor; return  this;
    }

    public int getSelectedTextColor() {
        return selectedTextColor;
    }

    public WidgetConfig setSelectedTextColor(int selectedTextColor) {
        this.selectedTextColor = selectedTextColor; return  this;
    }

    public int getDrawablePadding() {
        return drawablePadding;
    }

    public WidgetConfig setDrawablePadding(int drawablePadding) {
        this.drawablePadding = drawablePadding;
        return  this;
    }

    public int getIconHeight() {
        return iconHeight;
    }

    public WidgetConfig setIconHeight(int iconHeight) {
        this.iconHeight = iconHeight; return  this;
    }

    public int getIconWidth() {
        return iconWidth;
    }

    public WidgetConfig setIconWidth(int iconWidth) {
        this.iconWidth = iconWidth; return  this;
    }

    public int getDivideLineColor() {
        return divideLineColor;
    }

    public WidgetConfig setDivideLineColor(int divideLineColor) {
        this.divideLineColor = divideLineColor; return  this;
    }

    public int getDivideLineHeight() {
        return divideLineHeight;
    }

    public WidgetConfig setDivideLineHeight(int divideLineHeight) {
        this.divideLineHeight = divideLineHeight; return  this;
    }
}
