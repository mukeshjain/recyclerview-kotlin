package ninja.mkj.recyclerviewkt.utils

import android.support.v7.app.AppCompatActivity

/**
 * Created by mukesh on 5/25/17.
 */

class ActionBarView(internal var activity: AppCompatActivity) {

    fun setActionBar() {
        // Enable action bar as toggle Home Button
        val actionBar = activity.supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayShowCustomEnabled(true)
    }

}
