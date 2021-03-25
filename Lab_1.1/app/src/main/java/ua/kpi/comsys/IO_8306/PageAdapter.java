package ua.kpi.comsys.IO_8306;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;

    public PageAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm, totalTabs);
        context = c;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Lab1Fragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}