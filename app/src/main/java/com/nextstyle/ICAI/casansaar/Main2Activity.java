package com.nextstyle.ICAI.casansaar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    int prev;
    public TabLayout tablayout;
    public int test=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tablayout = findViewById(R.id.tab);
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
            mViewPager = findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);
            mViewPager.setCurrentItem(Integer.parseInt(getIntent().getStringExtra("id")));
            tablayout.setupWithViewPager(mViewPager);

                tablayout.getTabAt(0).setIcon(R.drawable.about_thumb);
                tablayout.getTabAt(1).setIcon(R.drawable.motto_thumb);
                tablayout.getTabAt(2).setIcon(R.drawable.management_thumb);
                tablayout.getTabAt(3).setIcon(R.drawable.stu_thumb);
                tablayout.getTabAt(4).setIcon(R.drawable.directory_thumb);
                tablayout.getTabAt(5).setIcon(R.drawable.cpe_thumb);
                tablayout.getTabAt(6).setIcon(R.drawable.gallery_thumb);
                tablayout.getTabAt(7).setIcon(R.drawable.events_thumb);
                tablayout.getTabAt(8).setIcon(R.drawable.contact_thumb);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_motto, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
             switch (position)
            {
                case 0:
                {
                    About a=new About();
                    return  a;
                }
                case 1:
                {
                    Motto m = new Motto();
                    return m;
                }
                case 2:
                {
                    Committee c=new Committee();
                    return c;
                }
                case 3:
                {
                    Wicasa w=new Wicasa();
                    return  w;
                }
                case 4:
                {
                    Directory d=new Directory();
                    Bundle bundle=new Bundle();
                    bundle.putString("id","0");
                    d.setArguments(bundle);
                    return d;
                }
                case 5:
                {
                    CPE cp=new CPE();
                    return cp;
                }
                case 6:
                {
                  Gallery g=new Gallery();
                          return g;
                }
                case 7:
                {
                   Event e=new Event();
                   return e;
                }
                case 8:
                {
                    contact co=new contact();
                    return co;
                }

            }
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return null;
        }

        @Override
        public int getCount() {
            return 9;
        }


        @Override
        public CharSequence getPageTitle(int position) {

           switch (position)
            {
                case 0:
                    return "About";
                case 1:
                    return "Motto";
                case 2:
                    return "Committee";
                case 3:
                    return "WICASA";
                case 4:
                    return "Directory";
                case 5:
                    return "CPE";
                case 6:
                    return "Gallery";
                case 7:
                    return "Events";
                case 8:
                    return "Contact";
            }
                return null;
        }
    }
}
