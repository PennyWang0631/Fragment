package com.cst2335.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BlankFragment2 extends Fragment {

    private View root;
    private TextView textView;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //onCreateView是一个生命周期函数，首先要判断
        if(root==null){
            //解析fragment，使用根view解析
            //inflater是一个解析器
            root = inflater.inflate(R.layout.fragment_blank1,container,false);
        }
        //为了证明---->fragment是一个子activity，所以可以响应点击的活动
        textView = root.findViewById(R.id.textview);
        button = root.findViewById(R.id.btn);
        //button的点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Fine,and you?");
            }
        });


        //View 有返回值
        return root;
    }
}