package me.bzcoder.cityservice.mainpage;

/**
 * 
 * @author : BaoZhou
 * @date : 2019/1/7 11:27
 */
public class FunctionItem {
    private String name;
    private String url;
    private int res;

    private ServiceEnum serviceEnum;

    public FunctionItem(String name, String url, int res, ServiceEnum serviceEnum) {
        this.name = name;
        this.url = url;
        this.res = res;
        this.serviceEnum = serviceEnum;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getRes() {
        return res;
    }

    public ServiceEnum getServiceEnum() {
        return serviceEnum;
    }


}
