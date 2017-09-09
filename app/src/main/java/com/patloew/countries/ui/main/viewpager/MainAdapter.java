package com.patloew.countries.ui.main.viewpager;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.patloew.countries.R;
import com.patloew.countries.injection.qualifier.ActivityFragmentManager;
import com.patloew.countries.injection.scopes.PerActivity;
import com.patloew.countries.ui.main.viewpager.all.AllCountriesFragment;
import com.patloew.countries.ui.main.viewpager.favorites.FavoriteCountriesFragment;

import javax.inject.Inject;

/* Copyright 2016 Patrick Löwenstein
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

@PerActivity
public class MainAdapter extends FragmentPagerAdapter {
    
    private final Resources res;

    @Inject
    public MainAdapter(@ActivityFragmentManager FragmentManager fm, Resources res) {
        super(fm);
        this.res = res;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new AllCountriesFragment();
        } else {
            return new FavoriteCountriesFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return res.getString(R.string.tab_title_all);
        } else {
            return res.getString(R.string.tab_title_favorites);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
