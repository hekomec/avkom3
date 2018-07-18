package com.avkom.hekotech.avkom.View;


import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentTransaction;


import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.avkom.hekotech.avkom.R;

public class main extends AppCompatActivity {





    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(0);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float v, final int i2) {
            }

            @Override
            public void onPageSelected(final int position) {
                YourFragmentInterface fragment = (YourFragmentInterface) mSectionsPagerAdapter.instantiateItem(mViewPager, position);
                if (fragment != null) {
                    fragment.fragmentBecameVisible();
                }
            }

            @Override
            public void onPageScrollStateChanged(final int position) {
            }
        });


    }


    public class SectionsPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

        public SectionsPagerAdapter(android.support.v4.app.FragmentManager fm) {

            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    FrEleman tab1 = new FrEleman();
                    return tab1;
                case 1:
                    FrStajer tab2 = new FrStajer();
                    return tab2;
                case 2:
                    FrSikayet tab3 = new FrSikayet();
                    return tab3;
                case 3:
                    FrIletisim tab4 = new FrIletisim();
                    return tab4;

                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Eleman";
                case 1:
                    return "Stajer";
                case 2:
                    return "Şikayet";
                case 3:
                    return "İletişim";

            }
            return null;
        }
    }
    public interface YourFragmentInterface {
        void fragmentBecameVisible();
    }
}

