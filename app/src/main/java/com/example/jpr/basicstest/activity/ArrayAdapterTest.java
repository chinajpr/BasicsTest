package com.example.jpr.basicstest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jpr.basicstest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:arrayadapter练习
 * 显示比较简单,内容比较简单的情况下,可以使用ArrayAdaper,如果有点复杂的页面,直接使用lisview
 * 创建日期:2017/11/21 on 14:06
 * 作者:JiaoPeiRong
 */

public class ArrayAdapterTest extends BaseActivity {
    private ListView mLv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_arraylist);
        mLv = (ListView) findViewById(R.id.lv);
        usage0();
//        usage1();
    }

    /**
     * 用法一
     * 格式非常简单,显示内容非常简单
     * android.R.layout.simple_expandable_list_item_1是android里已提供的样式，我们也可换成自己的xml。
     * 但是需要注意的是这个xml文件仅能有一个textview。连Layout也不能有。否则会报错：
     * ArrayAdapter requires the resource ID to be a TextView
     */
    private void usage0(){
//        List<String> list = new ArrayList<>();
//        list.add("1111");
//        list.add("2222");
//        list.add("3333");

        List<Student> list = new ArrayList<>();
        Student s0 = new Student("大明","12");
        Student s1 = new Student("小明","11");
        list.add(s0);
        list.add(s1);
        ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1,list);
        mLv.setAdapter(adapter);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ArrayAdapterTest.this , "---" ,Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 用法二
     * 显示内容非常简单,格式稍微复杂
     */
    private void usage1(){
        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("3333");

        ArrayAdapter adapter = new ArrayAdapter(this , R.layout.view_arrayadapter , R.id.tv , list);
        mLv.setAdapter(adapter);
    }

    class Student{
        private  String name;
        private  String age;

        public Student(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
