package com.rq.net.manager;

import androidx.fragment.app.*;
import android.content.*;
import java.util.*;
import androidx.appcompat.app.*;

public class FragmentViewManager
{
    private static final String TAG = "FragmentViewManager";
    private List<Fragment> hideFragments;
    public boolean isShowFragment;
    private Context mContext;
    private Boolean siHide;
    
    public FragmentViewManager(final Context mContext) {
        this.hideFragments = new ArrayList<Fragment>();
        this.siHide = false;
        this.isShowFragment = false;
        this.mContext = mContext;
    }
    
    public Boolean getState() {
        return this.siHide;
    }
    
    public void hideFragment() {
        try {
            if (this.hideFragments.size() > 0) {
                for (int i = 0; i < this.hideFragments.size(); ++i) {
                    ((AppCompatActivity)this.mContext).getSupportFragmentManager().beginTransaction().hide((Fragment)this.hideFragments.get(i)).commit();
                }
                this.isShowFragment = false;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.siHide = false;
    }
    
    public void showFragment(final Fragment fragment, final String s, final int n) {
        // monitorenter(this)
        if (fragment == null) {
            // monitorexit(this)
            return;
        }
        try {
            try {
                this.hideFragment();
                if (((AppCompatActivity)this.mContext).getSupportFragmentManager().findFragmentByTag(s) == null && !fragment.isAdded()) {
                    if (!this.hideFragments.contains(fragment)) {
                        ((AppCompatActivity)this.mContext).getSupportFragmentManager().beginTransaction().add(n, fragment, s).commit();
                    }
                }
                else {
                    ((AppCompatActivity)this.mContext).getSupportFragmentManager().beginTransaction().show(fragment).commit();
                }
                this.hideFragments.add(fragment);
                this.isShowFragment = true;
                this.siHide = true;
            }
            finally {}
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        // monitorexit(this)
        return;
    }
    // monitorexit(this)
}
