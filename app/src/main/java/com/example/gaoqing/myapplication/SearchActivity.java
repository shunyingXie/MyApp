package com.example.gaoqing.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class SearchActivity extends AppCompatActivity {
    private SearchView mSearchView = null;
    private ListView mListView = null;
    private String[] mDates = {"aaa", "bbb", "ccc","ddd"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //透明度
        View v1 = findViewById(R.id.search);
        v1.getBackground().setAlpha(30);
        View v2 = findViewById(R.id.SearchText);
        v2.getBackground().setAlpha(210);

        mSearchView = (SearchView) findViewById(R.id.search);
        mListView = (ListView) findViewById(R.id.SearchText);
        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDates));
        mListView.setTextFilterEnabled(true);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            //点击搜索框
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            //改变搜索框
            @Override
            public boolean onQueryTextChange(String s) {
                if (!TextUtils.isEmpty(s)) {
                    mListView.setFilterText(s);
                }else {
                    mListView.clearTextFilter();
                }

                return false;
            }



        });


    }
}
