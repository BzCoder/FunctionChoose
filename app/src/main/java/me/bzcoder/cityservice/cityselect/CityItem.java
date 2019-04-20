package me.bzcoder.cityservice.cityselect;

/**
 * @author : BaoZhou
 * @date : 2019/1/7 14:27
 */
public class CityItem {
    String cityName;
    String cityNameCN;
    CityEnum cityEnum;

    public CityItem(String cityName, String cityNameCN, CityEnum cityEnum) {
        this.cityName = cityName;
        this.cityNameCN = cityNameCN;
        this.cityEnum = cityEnum;
    }

    public CityEnum getCityEnum() {
        return cityEnum;
    }

    public void setCityEnum(CityEnum cityEnum) {
        this.cityEnum = cityEnum;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNameCN() {
        return cityNameCN;
    }

    public void setCityNameCN(String cityNameCN) {
        this.cityNameCN = cityNameCN;
    }
}
