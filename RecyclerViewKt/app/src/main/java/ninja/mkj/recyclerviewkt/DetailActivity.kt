package ninja.mkj.recyclerviewkt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ml.myfirstkotlineapp.models.Employee
import ninja.mkj.recyclerviewkt.utils.ActionBarView

class DetailActivity : AppCompatActivity() {

    private val TAG = DetailActivity::class.java.simpleName

    private var idTv: TextView? = null
    private var nameTv: TextView? = null
    private var desgTv: TextView? = null
    private var salTv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
        initObj()
    }

    fun initViews(){
        val ab = ActionBarView(this).setActionBar()
        idTv = findViewById(R.id.tv_id) as TextView
        nameTv = findViewById(R.id.tv_name) as TextView
        desgTv = findViewById(R.id.tv_desg) as TextView
        salTv = findViewById(R.id.tv_sal) as TextView
    }

    fun initObj(){
        val gson = Gson()
        val strObj = intent.getStringExtra("Emp")
        val type = object : TypeToken<Employee>() {}.getType()
        val fromJson: Employee?  = gson.fromJson(strObj, type)
        logDebuge(fromJson.toString())
        showEmpDetail(fromJson)
    }

    fun showEmpDetail(emp: Employee?){
        idTv!!.text = emp?.id.toString()
        nameTv!!.text = emp?.name.toString()
        desgTv!!.text = emp?.desg.toString()
        salTv!!.text = "$"+emp?.salary.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return true
    }

    fun logDebuge(message: String) {
        Log.d(TAG, message)
    }

}
