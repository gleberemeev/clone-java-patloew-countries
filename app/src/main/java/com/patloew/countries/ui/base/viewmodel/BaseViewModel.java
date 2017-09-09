package com.patloew.countries.ui.base.viewmodel;

import android.databinding.BaseObservable;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.patloew.countries.ui.base.MvvmViewNotAttachedException;
import com.patloew.countries.ui.base.view.MvvmView;

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
/**
 * Base class that implements the ViewModel interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvvmView that
 * can be accessed from the children classes by calling getMvpView().
 *
 * When saving state is required, restoring is handled automatically when calling attachView().
 * However, saveInstanceState() must still be called in the corresponding lifecycle callback.
 *
 * ------
 *
 * FILE MODIFIED 2017 Tailored Media GmbH
 */
public abstract class BaseViewModel<V extends MvvmView> extends BaseObservable implements MvvmViewModel<V> {

    private V mvvmView;

    @Override
    @CallSuper
    public void attachView(V mvvmView, @Nullable Bundle savedInstanceState) {
        this.mvvmView = mvvmView;
        if(savedInstanceState != null) { restoreInstanceState(savedInstanceState); }
    }

    @Override
    @CallSuper
    public void detachView() {
        mvvmView = null;
    }

    protected void restoreInstanceState(@NonNull Bundle savedInstanceState) { }

    public void saveInstanceState(Bundle outState) { }

    public final boolean isViewAttached() {
        return mvvmView != null;
    }

    public final V getView() {
        return mvvmView;
    }

    public final void checkViewAttached() {
        if (!isViewAttached()) throw new MvvmViewNotAttachedException();
    }
}
