
/*
 * Copyright (C) 2016-2017 Predictive Fitness, LLC. All Rights Reserved.
 *
 * NOTICE: All information contained herein is and remains the property of Predictive Fitness, LLC. The intellectual
 * and technical concepts contained herein are proprietary to Predictive Fitness, LLC and may be covered by U.S. and
 * Foreign Patents, patents in process, and are protected by trade secret or copyright law. Dissemination of this
 * information or reproduction of this material as a whole or in part is strictly forbidden unless prior written
 * permission is obtained from Predictive Fitness, LLC.
 */

package ninja.mkj.recyclerviewkt.utils;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mukesh on 12/8/16.
 * This is custom action bar to set on any activity.
 */
public class ActionBarView {

    AppCompatActivity activity;

    public ActionBarView(AppCompatActivity activity){
        this.activity = activity;
    }

    /**
     * This will set same type of custom action bar for any activity.
     * @param title
     */
    public void setActionBar() {
        // Enable action bar as toggle Home Button
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
    }//end initActionBar

}
