package com.nextstyle.ICAI.casansaar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Admin on 12/7/2017.
 */

public class Directory extends Fragment{
    public TabLayout tablayout;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    public Directory() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_directory,container,false);
       tablayout=view.findViewById(R.id.tabLayout);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        mViewPager = view.findViewById(R.id.directoryContainer);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(0);
        tablayout.setupWithViewPager(mViewPager);

       return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            directoryView d=new directoryView();
            switch (position)
            {
                case 0:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","A" );
                    d.setArguments(bundle);
                     return d;
                }
                case 1:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","B" );
                    d.setArguments(bundle);
                    return d;
                }
                case 2:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","C" );
                    d.setArguments(bundle);
                    return d;
                }
                case 3:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","D" );
                    d.setArguments(bundle);
                    return d;
                }
                case 4:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","E" );
                    d.setArguments(bundle);
                    return d;
                }
                case 5:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","F" );
                    d.setArguments(bundle);
                    return d;
                }
                case 6:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","G" );
                    d.setArguments(bundle);
                    return d;
                }
                case 7:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","H" );
                    d.setArguments(bundle);
                    return d;
                } case 8:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","I" );
                    d.setArguments(bundle);
                    return d;
                }
                case 9:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","J" );
                    d.setArguments(bundle);
                    return d;
                }
                case 10:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","K" );
                    d.setArguments(bundle);
                    return d;
                }
                case 11:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","L" );
                    d.setArguments(bundle);
                    return d;
                }
                case 12:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","M" );
                    d.setArguments(bundle);
                    return d;
                }
                case 13:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","N" );
                    d.setArguments(bundle);
                    return d;
                }
                case 14:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","O" );
                    d.setArguments(bundle);
                    return d;
                } case 15:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","P" );
                    d.setArguments(bundle);
                    return d;
                }
                case 16:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","Q" );
                    d.setArguments(bundle);
                    return d;
                }
                case 17:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","R" );
                    d.setArguments(bundle);
                    return d;
                }
                case 18:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","S" );
                    d.setArguments(bundle);
                    return d;
                }
                case 19:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","T" );
                    d.setArguments(bundle);
                    return d;
                }
                case 20:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","U" );
                    d.setArguments(bundle);
                    return d;
                }
                case 21:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","V" );
                    d.setArguments(bundle);
                    return d;
                }case 22:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","W" );
                    d.setArguments(bundle);
                    return d;
                }
                case 23:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","X" );
                    d.setArguments(bundle);
                    return d;
                }
                case 24:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","Y" );
                    d.setArguments(bundle);
                    return d;
                }
                case 25:
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg","Z" );
                    d.setArguments(bundle);
                    return d;
                }

            }
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 26;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            switch (position)
            {
                case 0:
                    return "A";
                case 1:
                    return "B";
                case 2:
                    return "C";
                case 3:
                    return "D";
                case 4:
                    return "E";
                case 5:
                    return "F";
                case 6:
                    return "G";
                case 7:
                    return "H";
                case 8:
                    return "I";
                case 9:
                    return "J";
                case 10:
                    return "K";
                case 11:
                    return "L";
                case 12:
                    return "M";
                case 13:
                    return "N";
                case 14:
                    return "O";
                case 15:
                    return "P";
                case 16:
                    return "Q";
                case 17:
                    return "R";
                case 18:
                    return "S";
                case 19:
                    return "T";
                case 20:
                    return "U";
                case 21:
                    return "V";
                case 22:
                    return "W";
                case 23:
                    return "X";
                case 24:
                    return "Y";
                case 25:
                    return "Z";
            }
            return null;
        }
    }
}
