package com.cst2335.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn1);
        //两种设置button点击事件的方法，一种是setOnClickListener(new 内部类 )，第二种implements
        button.setOnClickListener(this);//面向对象原则，自动与onClickListener进行匹配
        Button btn2 =  findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                //进行一个fragment的切换
                //传进BlankFragment1这个函数
                replaceFragment(new BlankFragment1());
                break;
            case R.id.btn2:
                replaceFragment(new ItemFragment());
        }

    }
    //传进一个Fragment fragment的函数
    //动态切换fragment
    private void replaceFragment(Fragment fragment) {
        //fragment有一个自己的管理类FragmentManager,专门用于管理fragment
        //通过getSupportFragmentManager获得一个fragment管理类
        FragmentManager fragmentManager = getSupportFragmentManager();
        // FragmentManager不是自己管理，而是拿到一个触发器Transaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //把BlankFragment1替换到framelayout
        transaction.replace(R.id.framelayout,fragment);
        //执行
        transaction.commit();
    }
}