package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class year1_mgmtActivity extends AppCompatActivity implements year1_Term1.OnFragmentInteractionListener, year1_Term2.OnFragmentInteractionListener, year1_Term3.OnFragmentInteractionListener{
    Toast toast;
    TabLayout tabLayout;
    static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year1_mgmt);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Term 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Term 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Term 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final year1_pageAdapter adapter = new year1_pageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                position = tab.getPosition();
                viewPager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                viewPager.getAdapter().notifyDataSetChanged();


            }
        });

        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(year1_mgmtActivity.this, ManagementActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override public void onBackPressed() {
        startActivity(new Intent(year1_mgmtActivity.this, ManagementActivity.class));
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }

    public static int getTabNumber(){
        return position;
    }

}
