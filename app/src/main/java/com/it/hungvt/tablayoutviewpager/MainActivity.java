package com.it.hungvt.tablayoutviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private int[] tabIcons = {
            R.drawable.ic_tab_favorite,
            R.drawable.ic_tab_contact,
            R.drawable.ic_tab_call
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Mui ten trai ActionBar

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();
    }

    private void setupTabIcons() {
//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        tabThree.setText(R.string.tab_contact);
        tabThree.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.ic_tab_contact,0,0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        tabTwo.setText(R.string.tab_call);
        tabTwo.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.ic_tab_call,0,0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        tabOne.setText(R.string.tab__favourite);
        tabOne.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.ic_tab_favorite,0,0);
        tabLayout.getTabAt(0).setCustomView(tabOne);




    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new OneFragment(),"ONE");
        viewPagerAdapter.addFragment(new TwoFragment(),"TWO");
        viewPagerAdapter.addFragment(new ThreeFragment(),"THREE");
        viewPager.setAdapter(viewPagerAdapter);
    }


}
