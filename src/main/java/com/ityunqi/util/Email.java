package com.ityunqi.util;

import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class Email {

    //接收的有两个参数
    //手机号

    //调用第三方的一个类，传递两个参数 手机号和验证码，暂时没有设置返回值
    public void sendSms(String phone, String code){
        String host = "https://gyytz.market.alicloudapi.com";
        String path = "/sms/smsSend";
        String method = "POST";
        String appcode = "37b5fcdb97584d40b7a345cb68359e8c";
        //设置一个响应头，map集合
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        //将Authorization头加入集合中，到时候放到http的响应头中
        headers.put("Authorization", "APPCODE " + appcode);


        //相当于请求参数，四个表单数据
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        String a = "**code**:";
        String b = ",**minute**:5";
        String param = a + code + b;
        querys.put("param", param);
        //smsSignId（短信前缀）和templateId（短信模板），可登录国阳云控制台自助申请。参考文档：http://help.guoyangyun.com/Problem/Qm.html
        querys.put("smsSignId", "6970a4c1216b4d15999971e998fa7574");//短信前缀
        querys.put("templateId", "a09602b817fd47e59e7c6e603d3f088d");//短信模板


        //这又是什么，好像是请求体
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从\r\n\t    \t* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java\r\n\t    \t* 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //                                    这两个是第三方网址    请求头(Authorization)   不知道
            //                                                    请求方法         表单数据
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
