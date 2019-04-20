package me.bzcoder.cityservice.data;

/**
 * @author : BaoZhou
 * @date : 2019/1/7 9:34
 */
public class CityServiceDateFactory {
    public static CityData CityServiceDateFactory(String city) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (CityData) Class.forName(CityServiceDateFactory.class.getPackage().getName() + "." + city + "CityServiceData").newInstance();
    }
}
