package android.com.toolbartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import test.yyg.com.titlebar.TitleBar;

public class MainActivity extends AppCompatActivity {

    TitleBar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView drawerLeft;
    TextView drawerRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        //            setTranslucentStatus(true);
        //}
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        drawerLeft = (TextView) findViewById(R.id.drawer_left);
        drawerRight = (TextView) findViewById(R.id.drawer_right);
        initToolBar();
        setDrawerLayoutStyle();

//        initStatusBar();
        findViewById(R.id.btn_activity01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity01.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_activity02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity02.class);
                startActivity(intent);
            }
        });
    }

    private void initToolBar() {
        toolbar = (TitleBar) findViewById(R.id.main_toolbar);
        toolbar.setMyCenterIcon(R.drawable.support);
        toolbar.setMySettingIcon(R.drawable.selector_setting);
        setSupportActionBar(toolbar);
        //左侧Navigation显示为返回图标
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setDrawerLayoutStyle() {
        //设置左边侧滑只能通过按扭点开
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.START);
        //将navigationButton采用系统默认图标，与drawablelayout绑定(含动画)
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.open, R.string.close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }

    private void initStatusBar() {
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintResource(android.R.color.transparent);
        tintManager.setStatusBarTintResource(android.R.color.transparent);
    }

    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
