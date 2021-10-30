package com.example.kazim.mohaqeqkabuli;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Bundle extra1;
    ArrayList<String> titleArrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("زندگی نامه");

        context=MainActivity.this;

        titleArrayList=new ArrayList<String>();
        titleArrayList.add(Constants.PREFACE);
        titleArrayList.add(Constants.BORN);
        titleArrayList.add(Constants.PRIMARY_EDUCATION);
        titleArrayList.add(Constants.TRAVELLING_TO_NAJAF);
        titleArrayList.add(Constants.HIGHER_EDUCATION);
        titleArrayList.add(Constants.TEACHING_IN_NAJAF_AND_EJTEHAD);
        titleArrayList.add(Constants.RETURNING_TO_THE_COUNDTRY);
        titleArrayList.add(Constants.STAYING_IN_KABUL);
        titleArrayList.add(Constants.TRAVELLING_AND_HOLYWAR);
        titleArrayList.add(Constants.RETURNING_TO_KABUL);
        titleArrayList.add(Constants.AGAIN_TRAVELLING_TO_IRAN);
        titleArrayList.add(Constants.MARJAEIAT);

        extra1=getIntent().getExtras();

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter=new TitleAdapter(context, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Intent intent=new Intent(context,DescriptionActivity.class);
                intent.putExtra("titles",titleArrayList.get(position));
                startActivity(intent);

            }
        });

        recyclerView.setAdapter(adapter);
        setupToolbar();


    }
    public void setupToolbar(){
        final DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        setSupportActionBar(toolbar);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()){
                    case R.id.kabuli_site_nav:

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://mohaqeq.org"));
                        startActivity(intent);
                        break;
                    case R.id.setting_nav:
                        startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                        break;
                    case R.id.about_nav:
                        startActivity(new Intent(MainActivity.this,AboutActivity.class));
                }
                drawerLayout.closeDrawers();

                return true;

            }
        });

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


    }
}
