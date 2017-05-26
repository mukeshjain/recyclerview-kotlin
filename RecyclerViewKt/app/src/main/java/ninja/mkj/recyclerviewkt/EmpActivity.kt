package ninja.mkj.recyclerviewkt

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.ml.myfirstkotlineapp.adapters.EmpViewAdapter
import com.ml.myfirstkotlineapp.dao.CustomItemClickListener
import com.ml.myfirstkotlineapp.models.Employee
import java.util.*

/**
 * Created by mukesh on 5/25/17.
 */

class EmpActivity : AppCompatActivity() {

    private val TAG = EmpActivity::class.java.simpleName

    /* A variable that can hold null, need to add a ? after the variable’s type */
    private var mRecyclerView: RecyclerView? = null
    private var mLayoutManager: LinearLayoutManager? = null
    private var mEmpViewAdapter: EmpViewAdapter? = null
    private var mEmpList: MutableList<Employee>? = null
    private val mEmpIdList: List<Long> = listOf(89454644, 89454645, 89454646, 89454647, 89454648)
    private val mEmpNameList: List<String> = listOf("Jems", "Noah", "Jacob", "Adam", "Zomba")
    private val mEmpDesgList: List<String> = listOf("SSE", "SSE", "SE", "TL", "SSE")
    private val mEmpSalList: List<Double> = listOf(3400.0, 4500.56, 2400.89, 7500.56, 5500.67)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emp)
        initObj()
    }

    fun initObj(){
        mRecyclerView = findViewById(R.id.rv_emp) as RecyclerView
        mEmpList = loadEmp()

        mEmpViewAdapter = EmpViewAdapter(this, mEmpList!!, object : CustomItemClickListener {
            override fun onItemClick(v: View, position: Int) {
                startHomeActivity(position)
            }
        })
        mLayoutManager = LinearLayoutManager(applicationContext)
        /* !! sure if it is not null */
        mRecyclerView!!.layoutManager = mLayoutManager
        mRecyclerView!!.itemAnimator = DefaultItemAnimator()
        mRecyclerView!!.adapter = mEmpViewAdapter
    }

    fun loadEmp(): MutableList<Employee> {

        mEmpList = ArrayList<Employee>()
        var emp: Employee?

        logDebuge(mEmpIdList.indices.toString())

        for (i in mEmpIdList.indices) {
            emp = Employee(mEmpIdList[i], mEmpNameList[i], mEmpDesgList[i], mEmpSalList[i])
            mEmpList!!.add(emp)
        }
        return mEmpList!!
    }

    fun startHomeActivity(po: Int) {
        val intent  = Intent(this@EmpActivity, DetailActivity::class.java)
        val gson: Gson = Gson()
        intent.putExtra("Emp", gson.toJson(mEmpList!!.get(po)))
        startActivity(intent)
    }

    private fun logDebuge(message: String) {
        Log.d(TAG, message)
    }

}
