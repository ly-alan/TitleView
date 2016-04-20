package android.com.toolbartest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import test.yyg.com.titlebar.TitleBar;

/**
 * Created by liaoyong on 2016/4/19.
 */
public class Activity01 extends AppCompatActivity {

    TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity01);
        titleBar = (TitleBar) findViewById(R.id.titleView);
        init();
    }

    private void init() {
        titleBar.setMyCenterTitle("设置");
        titleBar.setMySettingText("完成");
        titleBar.setSettingTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setSupportActionBar(titleBar);
        //左侧Navigation显示为返回图标
        if (getSupportActionBar() == null) {
            return;
        }
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
