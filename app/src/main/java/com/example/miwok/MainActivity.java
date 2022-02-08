package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import Adapter.ViewpagerAdapeter;

public class MainActivity extends AppCompatActivity {


    ViewpagerAdapeter adapterr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.viewPager2);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        FragmentManager fm = getSupportFragmentManager();
        adapterr=new ViewpagerAdapeter(fm,getLifecycle());
        viewPager2.setAdapter(adapterr);

        tabLayout.addTab(tabLayout.newTab().setText("Numbers"));
        tabLayout.addTab(tabLayout.newTab().setText("Phrases"));
        tabLayout.addTab(tabLayout.newTab().setText("Colors"));
        tabLayout.addTab(tabLayout.newTab().setText("Family members"));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });




//        TextView txt_numbers = findViewById(R.id.txt_numbers);
//        TextView txt_familyMembers = findViewById(R.id.txt_familyMembers);
//        TextView txt_colors = findViewById(R.id.txt_colors);
//        TextView txt_phrases = findViewById(R.id.txt_phrases);
//
//
//
//        txt_numbers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,NumbersActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//        txt_familyMembers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,FamilyActivity.class);
//                startActivity(intent);
//
//
//            }
//        });
//
//        txt_colors.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,ColorActivity.class);
//                startActivity(intent);
//
//
//            }
//        });
//
//        txt_phrases.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,PhrasesActivity.class);
//                startActivity(intent);
//
//
//            }
//        });
//
   }

}
