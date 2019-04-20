package me.bzcoder.cityservice.data;

import me.bzcoder.app.R;
import me.bzcoder.cityservice.mainpage.FunctionItem;
import me.bzcoder.cityservice.mainpage.ServiceEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 温州数据
 *
 * @author : BaoZhou
 * @date : 2019/1/7 11:22
 */
public class WenZhouCityServiceData implements CityData {
    private List<FunctionItem> data;

    public WenZhouCityServiceData() {
        data = new ArrayList<>();
        data.add(new FunctionItem("自然气象", "", 0, ServiceEnum.TITLE));
        data.add(new FunctionItem("天气预报", "https://app.zjzwfw.gov.cn/zjjssdk/tqyb/weather.jsp?citycode=101210701&123", R.mipmap.city_service_weather_forecast, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("台风时报", "https://typhoon.yyhj.zjzwfw.gov.cn", R.mipmap.city_service_typhoon_report, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("交通出行", "", 0, ServiceEnum.TITLE));
        data.add(new FunctionItem("汽车档案", "https://zjqcdacx.yyhj.zjzwfw.gov.cn/repair/records", R.mipmap.city_service_car_file, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("违章查询", "http://www.zjsgat.gov.cn:8087/was/phone/carIllegalQuery.jsp", R.mipmap.city_service_violation_query, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("罚款缴纳", "http://mpay.zjzwfw.gov.cn/jtwfjk/jjlist.html?PAYSOURCE=004", R.mipmap.city_service_fine_payment, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("车票查询", "http://mobile.12306.cn/weixin/wxcore/init", R.mipmap.city_service_ticket_inquiry, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("党政服务", "", 0, ServiceEnum.TITLE));
        data.add(new FunctionItem("法务咨询", "http://www.lvqilian.com/#/login/zjxw", R.mipmap.city_service_legal_advice, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("工商查询", "https://gsqcdzhdjpt.yyhj.zjzwfw.gov.cn/pda.do?method=enterPdajdcx", R.mipmap.city_service_business_inquiry, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("党费计算", "http://service.html5.8531.cn/dwz/CuH0CO", R.mipmap.city_service_party_fee_calculation, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("法院公开", "http://gov.zjqq.mobi/view/?cityid=330800", R.mipmap.city_service_court_open, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("平安鹿城", "http://lcga.yougoo.cn/mobile/index.html?zjxw_control=1101", R.mipmap.city_service_peaceful_lucheng, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("生活服务", "", 0, ServiceEnum.TITLE));
        data.add(new FunctionItem("身份证进度查询", "http://sfzjdcx.zjsgat.gov.cn:8080/jmzz/JdcxQqb/ggSearchResultForWechat", R.mipmap.city_service_id_card_inquiry, ServiceEnum.TWO_ONE_LINE));
        data.add(new FunctionItem("建设厅考试查询", "https://zjjslkscj.yyhj.zjzwfw.gov.cn", R.mipmap.city_service_construction_hall_examination_enquiry, ServiceEnum.TWO_ONE_LINE));
        data.add(new FunctionItem("结婚登记", "https://zjjhdj.yyhj.zjzwfw.gov.cn/", R.mipmap.city_service_marriage_registration, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("诊疗挂号", "http://guahao.zj186.com/WeChat/ddys-yygh/#/bookHosList/330100/yygh?patientId=1", R.mipmap.city_service_medical_registration, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("缴款查询", "https://mpay.zjzwfw.gov.cn/searchCertificateByCertificateNo.html", R.mipmap.city_service_payment_inquiry, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("教育学费", "http://mpay.zjzwfw.gov.cn/jyjk/regionList.html?PAYSOURCE=007", R.mipmap.city_service_education_fee, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("财政票据", "http://mpay.zjzwfw.gov.cn/searchByBillNo.html", R.mipmap.city_service_financial_instrument, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("查询快递", "http://m.kuaidi100.com/index.jsp", R.mipmap.city_service_express_inquiry, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("景点门票", "https://market.m.taobao.com/apps/market/travelticket/index.html?wh_weex=true&spm=181.7474825.entry.d5&ttid=12mtb0000155", R.mipmap.city_service_attractions_tickets, ServiceEnum.FOUR_ONE_LINE));
        data.add(new FunctionItem("空", "", 0, ServiceEnum.BLANK));
    }

    @Override
    public List<FunctionItem> getData() {
        return data;
    }


}
