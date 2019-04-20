package me.bzcoder.cityservice.cityselect;

/**
 * 类型
 *
 * @author : BaoZhou
 * @date : 2018/12/20 11:04
 */
public enum CityEnum {
    TITLE(0),
    ITEM(1),
    CHOOSE(2);
    int type;
    CityEnum(int type) {
        this.type = type;
    }


    public int getType() {
        return type;
    }

}
