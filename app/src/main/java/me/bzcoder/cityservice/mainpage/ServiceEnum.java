package me.bzcoder.cityservice.mainpage;
/**
 * 类型
 * @author : BaoZhou
 * @date : 2018/12/20 11:04
 */
public enum ServiceEnum {
    TITLE(0),
    FOUR_ONE_LINE(1),
    TWO_ONE_LINE(2),
    BLANK(3);
    int type;


    ServiceEnum(int type) {
        this.type = type;
    }


    public int getType() {
        return type;
    }

}
