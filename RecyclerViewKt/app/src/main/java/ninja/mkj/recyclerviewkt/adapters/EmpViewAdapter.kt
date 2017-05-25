package com.ml.myfirstkotlineapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.ml.myfirstkotlineapp.dao.CustomItemClickListener
import com.ml.myfirstkotlineapp.models.Employee
import ninja.mkj.recyclerviewkt.R

/**
 * Created by mukesh on 5/23/17.
 */

class EmpViewAdapter(private val context: Context, private val empList: List<Employee>, private val listener:
CustomItemClickListener) : RecyclerView
.Adapter<EmpViewAdapter.EmpViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EmpViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_view, viewGroup, false)
        val holder = EmpViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(empViewHolder: EmpViewHolder, i: Int) {
        val emp = empList[i]
        empViewHolder.idTV.text = emp.id.toString()
        empViewHolder.nameTV.text = emp.name
        empViewHolder.desgTV.text = emp.desg
        empViewHolder.salTV.text = "$"+emp.salary.toString()

        empViewHolder.parentFL.setOnClickListener{v ->
            listener.onItemClick(v, i)
        }

    }

    override fun getItemCount(): Int {
        return empList.size
    }

    inner class EmpViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var idTV: TextView
        var nameTV: TextView
        var desgTV: TextView
        var salTV: TextView
        var parentFL: FrameLayout

        init {
            parentFL = view.findViewById(R.id.fl_parent) as FrameLayout
            idTV = view.findViewById(R.id.tv_empId) as TextView
            nameTV = view.findViewById(R.id.tv_empname) as TextView
            desgTV = view.findViewById(R.id.tv_empdesg) as TextView
            salTV = view.findViewById(R.id.tv_empsal) as TextView
        }

    }

    private fun logDebuge(message: String) {
        Log.d(TAG, message)
    }

    companion object {

        private val TAG = EmpViewAdapter::class.java.simpleName

    }

}
