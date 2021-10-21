package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment = new ArrayList<>();
    private List<String> listFragmentTitle = new ArrayList<>();

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title){
        listFragment.add(fragment);
        listFragmentTitle.add(title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listFragmentTitle.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
