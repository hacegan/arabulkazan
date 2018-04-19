package arabulkazan.albatros.com.arabulkazan;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import arabulkazan.albatros.com.arabulkazan.Fragments.Main;
import arabulkazan.albatros.com.arabulkazan.Fragments.MyWallet;
import arabulkazan.albatros.com.arabulkazan.Fragments.Register;
import arabulkazan.albatros.com.arabulkazan.Fragments.Revenues;
import arabulkazan.albatros.com.arabulkazan.Fragments.Settings;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;

import static arabulkazan.albatros.com.arabulkazan.R.string.drawer_close;
import static arabulkazan.albatros.com.arabulkazan.R.string.drawer_open;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   static SliderLayout sliderShow;

private static DrawerLayout mDrawerLayout;
private static  ActionBarDrawerToggle mToggle;
private static ImageView imageView;

    @Override
    protected void onStop() {
        super.onStop();
       // sliderShow.stopAutoCycle();
    }

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_mywallet:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    Main mainFrag;
    Revenues revenuesFrag;
    MyWallet myWalletFrag;
    private ViewPager viewPager;
    MenuItem prevMenuItem;
    FrameLayout frameAnaSayfa;
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mainFrag=new Main();
        revenuesFrag=new Revenues();
        myWalletFrag=new MyWallet();

        adapter.addFragment(mainFrag);
        adapter.addFragment(revenuesFrag);
        adapter.addFragment(myWalletFrag);
        viewPager.setAdapter(adapter);
    }

    private void setupActionBar()
    {
        final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(
                R.layout.action_bar,
                null);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
       // actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
        actionBar.setCustomView(actionBarLayout);



        // You customization

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // if not registered
//        if (UI.getString(this,"pass")==null) {
//            getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//            getSupportActionBar().hide();
//        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        frameAnaSayfa=(FrameLayout)findViewById(R.id.frameLayout);
        frameAnaSayfa.setVisibility(View.VISIBLE);



        // mTextMessage = (TextView) findViewById(R.id.message);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setVisibility(View.GONE);

        if (UI.getString(this,"pass")!=null) {
            setupViewPager(viewPager);
            frameAnaSayfa.setVisibility(View.GONE);
            navigation.setVisibility(View.VISIBLE);
            setupActionBar();
        }
       else
        {
           /*Register register=new Register();
            android.support.v4.app.FragmentTransaction  transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout,register);
            transaction.commit();*/



            setupViewPager(viewPager);
            frameAnaSayfa.setVisibility(View.GONE);
            navigation.setVisibility(View.VISIBLE);



            setupActionBar();



        mDrawerLayout= (DrawerLayout) findViewById(R.id.container);




getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            imageView= (ImageView) findViewById(R.id.imageView);

            imageView.setOnClickListener(this);







        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
return  true;
        }

     if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
         mDrawerLayout.closeDrawer(GravityCompat.START);
     }
     else{
         mDrawerLayout.openDrawer(GravityCompat.START);
     }


          //mToggle.syncState();

        return  super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {


        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            mDrawerLayout.openDrawer(GravityCompat.START);
        }


    }
}
