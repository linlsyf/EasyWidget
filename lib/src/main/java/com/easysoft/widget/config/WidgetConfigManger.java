package com.easysoft.widget.config;

/**
 * Created by Administrator on 2019/6/22 0022.
 */

public class WidgetConfigManger {

    private  static WidgetConfigManger config;
    IWidgetConfig iWidgetConfig;

    public  static  WidgetConfigManger getInstance(){
        if(config==null){
            config=new WidgetConfigManger();

        }
        return  config;
    }

    public IWidgetConfig getiWidgetConfig() {
        if (iWidgetConfig==null){
            iWidgetConfig=new WidgetConfig();
        }
        return iWidgetConfig;
    }

    public void setiWidgetConfig(IWidgetConfig iWidgetConfig) {
        this.iWidgetConfig = iWidgetConfig;
    }
}
