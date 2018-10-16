package com.example.administrator.commentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CommentView lvPl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPl = findViewById(R.id.lv_pl);
        List<Comment> list = new ArrayList();
        for(int i =0;i<10;i++){
            Comment com;
            if(i%2==0) {
                com = new Comment(i + "", "用户" + i, (i + 10) + "", "用户" + (i + 10),"测试回复" ,"true");
            }else{
                com = new Comment(i + "", "用户" + i, (i + 10) + "", "用户" + (i + 10),"测试评论" ,"false");
            }
            list.add(com);
        }
        lvPl.bindData(list);
        lvPl.notifyDataSetChanged();
    }
}
