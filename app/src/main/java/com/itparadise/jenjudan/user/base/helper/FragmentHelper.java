package com.itparadise.jenjudan.user.base.helper;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by Gimon on 3/17/2018.
 */

public class FragmentHelper {

    Activity activity;

    public FragmentHelper(Activity activity) {
        this.activity = activity;
    }

    /**
     * change fragment of Tab
     *
     * @param fragment
     * @param parentLayout
     * @param frameLayout
     */
    public void loadFragment(FragmentManager fragmentManager, Fragment fragment, String parentLayout, int frameLayout) {
        Fragment currentFragment = fragmentManager.findFragmentById(frameLayout);

        // create a FragmentManager
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // replace the FrameLayout with new Fragment
        transaction.add(frameLayout, fragment);
        transaction.hide(currentFragment);
        transaction.addToBackStack(parentLayout);
        transaction.commit(); // save the changes
    }

    /**
     * replace current fragment
     *
     * @param fragmentManager
     * @param fragment
     * @param parentLayout
     * @param frameLayout
     */
    public void replaceFragment(FragmentManager fragmentManager, Fragment fragment, String parentLayout, int frameLayout) {
        // create a FragmentManager
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // replace the FrameLayout with new Fragment
        transaction.replace(frameLayout, fragment);
        transaction.commit(); // save the changes
    }

    /**
     * Pop fragment from onBack stack function
     */
    public boolean popFragment(FragmentManager fragmentManager) {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
            return true;
        }
        return false;
    }

    /**
     * Initial fragment for each tab
     *
     * @param fragmentManager
     * @param fragment
     * @param frameLayout
     */
    public void initFragment(FragmentManager fragmentManager, Fragment fragment, int frameLayout) {
        // create a FragmentManager
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        // add the FrameLayout with new Fragment
        transaction.add(frameLayout, fragment);
        transaction.commit(); // save the changes
    }

    /**
     * show dialog fragment
     *
     * @param fragmentManager
     * @param dialogFragment
     * @param tag
     */
    public void showDialogFragment(FragmentManager fragmentManager, Fragment dialogFragment, String tag) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(dialogFragment, tag);
        ft.commit();
    }

    /**
     * change fragment of Tab
     *
     * @param fragmentManager
     * @param frameLayout
     */
    public String getCurrentFragmentName(FragmentManager fragmentManager, int frameLayout) {
        Fragment currentFragment = fragmentManager.findFragmentById(frameLayout);
        if (currentFragment == null) {
            return "";
        }
        return currentFragment.getClass().getSimpleName();
    }
}
