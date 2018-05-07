package arabulkazan.albatros.com.arabulkazan;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
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
import android.util.Size;
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
import android.widget.Toast;


import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import arabulkazan.albatros.com.arabulkazan.Fragments.Main;
import arabulkazan.albatros.com.arabulkazan.Fragments.MyWallet;
import arabulkazan.albatros.com.arabulkazan.Fragments.Register;
import arabulkazan.albatros.com.arabulkazan.Fragments.Revenues;
import arabulkazan.albatros.com.arabulkazan.Fragments.Settings;
import arabulkazan.albatros.com.arabulkazan.Fragments.SizeOzel;
import arabulkazan.albatros.com.arabulkazan.Fragments.Update_Pass;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;

import static arabulkazan.albatros.com.arabulkazan.R.string.drawer_close;
import static arabulkazan.albatros.com.arabulkazan.R.string.drawer_open;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   static SliderLayout sliderShow;

private static DrawerLayout mDrawerLayout;
private static  ActionBarDrawerToggle mToggle;
private static ImageView imageView;
private NavigationView nav_drawer;

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
    SizeOzel sizeOzelFrag;
    Update_Pass updatePassFrag;
    public static ViewPager viewPager;
    MenuItem prevMenuItem;
    FrameLayout frameAnaSayfa;
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

    private void setupViewPager(ViewPager viewPager)
    {
        mainFrag=new Main();
        revenuesFrag=new Revenues();
        myWalletFrag=new MyWallet();
        sizeOzelFrag=new SizeOzel();
        updatePassFrag=new Update_Pass();
        adapter.addFragment(mainFrag);
        adapter.addFragment(revenuesFrag);
        adapter.addFragment(myWalletFrag);
        adapter.addFragment(sizeOzelFrag);
        adapter.addFragment(updatePassFrag);
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


        mDrawerLayout= (DrawerLayout) findViewById(R.id.container);





        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        imageView= (ImageView) findViewById(R.id.imageView);

        imageView.setOnClickListener(this);

        nav_drawer= (NavigationView) findViewById(R.id.nav_drawer);
        nav_drawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.logoutbtn:
                        UI.showConfirmation(MainActivity.this,"Çıkış","Çıkış Yapmak İstediğinize emin misiniz?",
                                new UI.onClick() {
                                    @Override
                                    public void onFinishedDialog() {
                                        UI.logout(MainActivity.this);


                                        Anasayfa_Giris_Kaydol nextFrag= new Anasayfa_Giris_Kaydol();
                                        MainActivity.this.getSupportFragmentManager().beginTransaction()
                                                .replace(R.id.frameLayout, nextFrag,"findThisFragment")
                                                .commit();

                                        Intent i = MainActivity.this.getPackageManager()
                                                .getLaunchIntentForPackage(MainActivity.this.getPackageName() );

                                        startActivity(i);



                                    }
                                }, new UI.onClick() {
                                    @Override
                                    public void onFinishedDialog() {

                                    }
                                }



                        );

                        break;


                    case R.id.isletmemagazambtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show(); break;
                    case R.id.emlakalsatkiralabtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;
                    case R.id.alisverisbtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;
                    case R.id.toplusmsbtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;
                    case R.id.onlinerentacarbtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;
                    case R.id.onlineegitimbtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;
                    case R.id.onlinefaturabtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;
                    case R.id.onlinesigortabtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;
                    case R.id.onlinebiletbtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;
                    case R.id.duyurularbtn:
                        Toast.makeText(getApplicationContext(),"Yakında...",Toast.LENGTH_SHORT).show();break;



                }



                return false;
            }
        });


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


           /* setupViewPager(viewPager);
            frameAnaSayfa.setVisibility(View.GONE);
            navigation.setVisibility(View.VISIBLE);*/





           Anasayfa_Giris_Kaydol fragmentAnaSayfa=new Anasayfa_Giris_Kaydol();

            frameAnaSayfa.setVisibility(View.VISIBLE);
            navigation.setVisibility(View.GONE);

            android.support.v4.app.FragmentTransaction  transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout,fragmentAnaSayfa,"Anasayfa_Giris_Kaydol");
            transaction.commit();


         /*   Revenues fragmentAnaSayfa=new Revenues();

            frameAnaSayfa.setVisibility(View.VISIBLE);
            navigation.setVisibility(View.GONE);

            android.support.v4.app.FragmentTransaction  transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout,fragmentAnaSayfa);
            transaction.commit();*/


            //setupActionBar();
            //zen koin area visible false



    /*    mDrawerLayout= (DrawerLayout) findViewById(R.id.container);




getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            imageView= (ImageView) findViewById(R.id.imageView);

            imageView.setOnClickListener(this);*/







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
                if (position<3) {
                    navigation.getMenu().getItem(position).setChecked(true);
                    prevMenuItem = navigation.getMenu().getItem(position);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      //  System.out.println("Girdi "+item+"item id "+item.getItemId());

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


//    @Override
//    protected void onResume() {
//        super.onResume();
//        adapter.notifyDataSetChanged();
//        System.out.println("Main aCTİVİTY ONRESUMEDE");
//    }


    @Override
    public void onBackPressed() {

        //android.support.v4.app.Fragment sizeOzel=getSupportFragmentManager().findFragmentByTag("SizeOzel");




//        if (getFragmentManager().getBackStackEntryCount() == 0) {
//            // add your code here
//this.finish();
//        }
//
//        else {
//            getFragmentManager().popBackStack();
//        }



//            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);//if main fragment currently displayed.Check it!
//
//
//            // Setting Dialog Title
//
//            alertDialog.setTitle("Uygulamadan ayrılıyor musun?");
//
//            // Setting Dialog Message
//
//            alertDialog.setMessage("Uygulamadan ayrılmak istiyor musunuz?");
//
//            // Setting Icon to Dialog
//
//            //  alertDialog.setIcon(R.layout.);
//
//            // Setting Positive "Yes" Button
//
//            alertDialog.setPositiveButton("EVET",
//
//                    new DialogInterface.OnClickListener() {
//
//                        public void onClick(DialogInterface dialog, int which) {
//
//                            finishAffinity();
//
//                        }
//
//                    });
//
//            // Setting Negative "NO" Button
//
//            alertDialog.setNegativeButton("HAYIR",
//
//                    new DialogInterface.OnClickListener() {
//
//                        public void onClick(DialogInterface dialog, int which) {
//
//                            // Write your code here to invoke NO event
//
//                            dialog.cancel();
//
//                        }
//
//                    });
//
//            // Showing Alert Message
//
//            alertDialog.show();



       // return;
    }





}
