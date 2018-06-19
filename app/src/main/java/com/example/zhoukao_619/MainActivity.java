package com.example.zhoukao_619;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhoukao_619.base.BaseActivity;
import com.example.zhoukao_619.mvp.model.bean.RegBean;
import com.example.zhoukao_619.mvp.presenter.RegPresenter;
import com.example.zhoukao_619.mvp.view.MainView;

public class MainActivity extends BaseActivity<RegPresenter> implements View.OnClickListener,MainView {

   private EditText name,pass;
   private Button reg;
    @Override
    public void onClick(View v) {
        String m = name.getText().toString();
        String p = pass.getText().toString();
         presenter.reg(m,p);
    }

    @Override
    protected RegPresenter providePresenter() {
        return new RegPresenter(this);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initListener() {
       reg.setOnClickListener(this);
    }

    @Override
    protected void initViews() {
      name= findViewById(R.id.name);
      pass=findViewById(R.id.pass);
      reg=findViewById(R.id.reg);
    }

    @Override
    public void onSuccess(RegBean loginBean) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
            });
    }

    @Override
    public void onFaild(String error) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public Context context() {
        return this;
    }
}
