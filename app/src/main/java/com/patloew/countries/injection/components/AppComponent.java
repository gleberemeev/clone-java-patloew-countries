package com.patloew.countries.injection.components;

import android.content.Context;
import android.content.res.Resources;

import com.patloew.countries.data.local.CountryRepo;
import com.patloew.countries.data.remote.CountryApi;
import com.patloew.countries.injection.modules.AppModule;
import com.patloew.countries.injection.modules.DataModule;
import com.patloew.countries.injection.modules.NetModule;
import com.patloew.countries.injection.qualifier.AppContext;
import com.patloew.countries.injection.scopes.PerApplication;
import com.squareup.leakcanary.RefWatcher;

import dagger.Component;
import io.realm.Realm;

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
@PerApplication
@Component(modules={AppModule.class, NetModule.class, DataModule.class})
public interface AppComponent {
    @AppContext Context appContext();
    Resources resources();
    RefWatcher refWatcher();

    Realm realm();
    CountryRepo countryRepo();
    CountryApi countryApi();
}
