package me.bzcoder.cityservice.mainpage;

import java.util.ArrayList;

/**
 * 
 * @author : BaoZhou
 * @date : 2018/12/20 15:13
 */
public class TabItem {
    private String tabName="";
    private ArrayList<FunctionItem> functionItems;

    public TabItem(String tabName, ArrayList<FunctionItem> functionItems) {
        this.tabName = tabName;
        this.functionItems = functionItems;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public ArrayList<FunctionItem> getFunctionItems() {
        return functionItems;
    }

    public void setFunctionItems(ArrayList<FunctionItem> functionItems) {
        this.functionItems = functionItems;
    }
}
