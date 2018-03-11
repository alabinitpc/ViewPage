package com.bincomputer.viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        // set action bar
        setSupportActionBar(toolbar);
        // settup viewpager
        setupViewPager(viewPager);
        // setup tablayout with viewpager
        tabLayout.setupWithViewPager(viewPager);
    }

    // setup viewpager
    private void setupViewPager(ViewPager viewPager) {
        //add fragment to adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragment1(), "TAB 1");
        adapter.addFragment(new TabFragment2(), "TAB 2");
        adapter.addFragment(new TabFragment3(), "TAB 3");
        // set adapter for viewpager
        viewPager.setAdapter(adapter);
    }
    // callback method that switch tab when click item in tab 1.
    public void switchTab(View v){
        TabLayout tabHost = (TabLayout) findViewById(R.id.tabs);
        tabHost.getTabAt(1).select();
    }
}
