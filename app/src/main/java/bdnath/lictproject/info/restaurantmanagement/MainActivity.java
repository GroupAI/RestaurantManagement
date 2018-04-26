package bdnath.lictproject.info.restaurantmanagement;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import bdnath.lictproject.info.restaurantmanagement.FoodPackage.DessertsFragment;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.DrinksFragment;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.FoodClass;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.FoodListAdapter;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.HeveFragment;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.SnacksFragment;
import bdnath.lictproject.info.restaurantmanagement.Preference.LoginPreferences;
import bdnath.lictproject.info.restaurantmanagement.database.FoodDatabaseHelper;

public class MainActivity extends AppCompatActivity implements FoodListAdapter.OnItemClickedListener{

    private TabLayout tabLayout;
    ViewPager tabViewPager;
    private FoodDatabaseHelper databaseHelper;
    private LoginPreferences loginPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginPreferences=new LoginPreferences(this);
        databaseHelper=new FoodDatabaseHelper(this);

        tabLayout=findViewById(R.id.tabLayout);
        tabViewPager=findViewById(R.id.tabViewPage);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.snacks));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.lunch));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.drinks));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.dessert));

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

/*
    public void addItem(View view) {
        Intent intent=new Intent(MainActivity.this, FoodItemAddActivity.class);
        startActivity(intent);
    }
*/

    @Override
    public void onItemClick(int position,FoodClass employee) {
        Intent intent = new Intent(MainActivity.this,FoodDetailActivity.class);
        //intent.putExtra("msg", (Serializable) employee);
        startActivity(intent);
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
                    return new DrinksFragment();
                case 3:
                    return new DessertsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabCount;
        }
    }

    ///////////////////////Menu Option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add:
                startActivity(new Intent(MainActivity.this,FoodItemAddActivity.class));
                break;
            case R.id.item_logout:
                loginPreferences.setStatus(false);
                startActivity(new Intent(MainActivity.this,AdminLoginActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    
}