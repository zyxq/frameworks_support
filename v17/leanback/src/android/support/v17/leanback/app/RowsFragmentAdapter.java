/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package android.support.v17.leanback.app;

import android.app.Fragment;
import android.support.v17.leanback.widget.ObjectAdapter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;

/**
 * {@link BrowseFragment.AbstractMainFragmentAdapter} implementation for representing
 * {@link android.support.v17.leanback.widget.ListRow}. It uses {@link RowsFragment} to
 * render individual rows.
 */
public class RowsFragmentAdapter extends BrowseFragment.AbstractMainFragmentAdapter {
    private RowsFragment mFragment;

    public RowsFragmentAdapter() {
        setScalingEnabled(true);
    }

    protected Fragment createFragment() {
        return new RowsFragment();
    }

    @Override
    public Fragment getFragment() {
        if (mFragment == null) {
            mFragment = (RowsFragment) createFragment();
        }

        return mFragment;
    }

    @Override
    public boolean isScrolling() {
        return mFragment.isScrolling();
    }

    @Override
    public void setExpand(boolean expand) {
        mFragment.setExpand(expand);
    }

    @Override
    public void setEntranceTransitionState(boolean state) {
        mFragment.setEntranceTransitionState(state);
    }

    @Override
    public void setAlignment(int windowAlignOffsetFromTop) {
        mFragment.setAlignment(windowAlignOffsetFromTop);
    }

    @Override
    public boolean onTransitionPrepare() {
        return mFragment.onTransitionPrepare();
    }

    @Override
    public void onTransitionStart() {
        mFragment.onTransitionStart();
    }

    @Override
    public void onTransitionEnd() {
        mFragment.onTransitionEnd();
    }

    @Override
    public BrowseFragment.MainFragmentRowsAdapter getRowsAdapter() {
        return mMainFragmentRowsAdapter;
    }

    BrowseFragment.MainFragmentRowsAdapter mMainFragmentRowsAdapter
            = new BrowseFragment.MainFragmentRowsAdapter() {
        public void setAdapter(ObjectAdapter adapter) {
            mFragment.setAdapter(adapter);
        }

        /**
         * Sets an item clicked listener on the fragment.
         */
        public void setOnItemViewClickedListener(OnItemViewClickedListener listener) {
            mFragment.setOnItemViewClickedListener(listener);
        }

        public void setOnItemViewSelectedListener(OnItemViewSelectedListener listener) {
            mFragment.setOnItemViewSelectedListener(listener);
        }

        public void setSelectedPosition(int rowPosition,
                                        boolean smooth,
                                        final Presenter.ViewHolderTask rowHolderTask) {
            mFragment.setSelectedPosition(rowPosition, smooth, rowHolderTask);
        }


        public void setSelectedPosition(int rowPosition, boolean smooth) {
            mFragment.setSelectedPosition(rowPosition, smooth);
        }

        public int getSelectedPosition() {
            return mFragment.getSelectedPosition();
        }
    };
}