package me.bzcoder.cityservice.data;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import me.bzcoder.cityservice.cityselect.CityEnum;
import me.bzcoder.cityservice.cityselect.CityItem;

/**
 * @author : BaoZhou
 * @date : 2019/1/7 11:22
 */
public class CityNameData {
    private List<CityItem> data;
    static public Map<String, String> cityMap;

    static {
        cityMap = new LinkedHashMap<>();
        cityMap.put("HangZhou", "杭州");
        cityMap.put("NingBo", "宁波");
        cityMap.put("WenZhou", "温州");
        cityMap.put("HuZhou", "湖州");
        cityMap.put("ShaoXing", "绍兴");
        cityMap.put("JiaXing", "嘉兴");
        cityMap.put("WenZhou", "温州");
        cityMap.put("JinHua", "金华");
        cityMap.put("QuZhou", "衢州");
        cityMap.put("TaiZhou", "台州");
        cityMap.put("LiShui", "丽水");
        cityMap.put("ZhouShan", "舟山");
    }

    /**
     * 初始化
     *
     * @param currCity
     */
    public CityNameData(String currCity) {
        data = new ArrayList<>();
        data.add(new CityItem("", "当前城市", CityEnum.TITLE));
        data.add(new CityItem("", currCity, CityEnum.CHOOSE));
        data.add(new CityItem("", "选择城市", CityEnum.TITLE));
        for (String cityName : cityMap.keySet()) {
            //map.keySet()返回的是所有key的值
            data.add(new CityItem(cityName, cityMap.get(cityName), CityEnum.ITEM));
        }

    }

    /**
     * 搜索
     *
     * @param currCity
     * @param key
     */
    public static List<CityItem> getSearchData(String currCity, String key) {
        List<CityItem> result = new ArrayList<>();
        result.add(new CityItem("", "当前城市", CityEnum.TITLE));
        result.add(new CityItem("", currCity, CityEnum.CHOOSE));
        result.add(new CityItem("", "选择城市", CityEnum.TITLE));
        for (String cityName : cityMap.keySet()) {
            //map.keySet()返回的是所有key的值
            if (cityMap.get(cityName).contains(key))
                result.add(new CityItem(cityName, cityMap.get(cityName), CityEnum.ITEM));
        }
        return result;
    }

    public List<CityItem> getData() {
        return data;
    }

}
