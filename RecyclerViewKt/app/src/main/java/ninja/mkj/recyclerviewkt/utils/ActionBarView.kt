package ninja.mkj.recyclerviewkt.utils

import android.support.v7.app.AppCompatActivity

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
