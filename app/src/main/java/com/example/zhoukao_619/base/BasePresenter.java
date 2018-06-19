package com.example.zhoukao_619.base;

public abstract class BasePresenter<V extends IView> {
    protected V view;
    public BasePresenter(V view){
        this.view=view;
        initModel();
    }

    protected abstract void initModel();
    void onDestroy(){
        view=null;
    }
}
