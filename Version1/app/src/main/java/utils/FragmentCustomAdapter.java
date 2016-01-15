package utils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.pamela.zeballos.version1.HomeFragment;

/**
 * Created by Zeballos on 11/3/15.
 */

public class FragmentCustomAdapter extends FragmentPagerAdapter {

    public FragmentCustomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return  new HomeFragment();
            case 1:
                return  new HomeFragment();
            case 2:
                return  new HomeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

}
