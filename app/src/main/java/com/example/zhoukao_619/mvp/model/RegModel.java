package com.example.zhoukao_619.mvp.model;

import android.util.Log;

import com.example.zhoukao_619.http.OkHttpUtils;
import com.example.zhoukao_619.mvp.model.bean.RegBean;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨运泽 on 2018/6/19.
 */

public class RegModel {
    public void login(String account, String password, final ILoginModelCallBace iLoginModelCallBace){
        String url="https://www.zhaoapi.cn/user/reg";
        Map<String,String> map=new HashMap<>();
        map.put("mobile",account);
        map.put("password",password);
        OkHttpUtils.getInstance().doPost(url, map, new OkHttpUtils.OkCallback() {
            @Override
            public void getFailure(Exception e) {

            }

            @Override
            public void getResponse(String josn) {
                RegBean regBean = new Gson().fromJson(josn, RegBean.class);
                String code = regBean.getCode();
                String msg = regBean.getMsg();
                if (code.equals("0")){
                    if (iLoginModelCallBace!=null){
                        iLoginModelCallBace.onMainSuccess(regBean);
                    }
                }else{
                    if (iLoginModelCallBace!=null){
                        iLoginModelCallBace.onMainFaild(msg);
                    }
                }
            }
        });
    }
    public interface ILoginModelCallBace{
        void onMainSuccess(RegBean loginBean);
        void onMainFaild(String error);
    }


}
