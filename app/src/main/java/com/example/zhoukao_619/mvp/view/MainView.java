package com.example.zhoukao_619.mvp.view;

import com.example.zhoukao_619.base.IView;
import com.example.zhoukao_619.mvp.model.bean.RegBean;

/**
 * Created by 杨运泽 on 2018/6/19.
 */

public interface MainView extends IView {
    void onSuccess(RegBean loginBean);
    void onFaild(String error);
}
