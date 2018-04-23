package bdnath.lictproject.info.restaurantmanagement;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import bdnath.lictproject.info.restaurantmanagement.FoodPackage.DessertsFragment;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.DrinksFragment;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.HeveFragment;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.SnacksFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    ViewPager tabViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabLayout);
        tabViewPager=findViewById(R.id.tabViewPage);

        tabLayout.addTab(tabLayout.newTab().setText("Snacks").setIcon(R.mipmap.ic_launcher_round));
        tabLayout.addTab(tabLayout.newTab().setText("Have").setIcon(R.mipmap.ic_launcher_round));
        tabLayout.addTab(tabLayout.newTab().setText("Drinks").setIcon(R.mipmap.ic_launcher_round));
        tabLayout.addTab(tabLayout.newTab().setText("Desserts").setIcon(R.mipmap.ic_launcher_round));

        FoodPageAdapter adapter=new FoodPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        tabViewPager.setAdapter(adapter);

        tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    //this adapter will help to set the fragment according to tab
    private class FoodPageAdapter extends FragmentPagerAdapter{
        private int tabCount;

        public FoodPageAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.tabCount=tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new SnacksFragment();
                case 1:
                    return  new HeveFragment();
                case 2:
                    return new DessertsFragment();
                case 3:
                    return new DrinksFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabCount;
        }
    }
//////////////////.............Menu operation Start................./////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuAddItem:
                startActivity(new Intent(MainActivity.this, FoodItemAddActivity.class));

                break;

            case R.id.menuLogout:

                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //////////////////.............Menu operation End................./////////////////////
}