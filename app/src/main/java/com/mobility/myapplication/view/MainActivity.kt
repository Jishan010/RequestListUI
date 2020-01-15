package com.mobility.myapplication.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crashlytics.android.Crashlytics
import com.google.android.material.snackbar.Snackbar
import com.mobility.myapplication.Constants.ACCEPT
import com.mobility.myapplication.Constants.REJECT
import com.mobility.myapplication.Constants.UNDO
import com.mobility.myapplication.R
import com.mobility.myapplication.adapter.RequestListAdapter
import com.mobility.myapplication.model.*
import com.mobility.myapplication.showMessage
import com.mobility.myapplication.viewmodel.ResultsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RequestListAdapter.OnItemClickListener {

    private var resultsViewModel: ResultsViewModel? = null
    private var recyclerView: RecyclerView? = null
    private var requestListAdapter: RequestListAdapter? = null

    companion object {
        val TAG: String = MainActivity::class.java.simpleName

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRecycleView()
        requestListAdapter = RequestListAdapter()
        recyclerView!!.adapter = requestListAdapter
        requestListAdapter!!.setOnItemClickListener(this)

        resultsViewModel = ViewModelProviders.of(this).get(ResultsViewModel::class.java)
        resultsViewModel?.getResultList()?.observe(this,
            Observer<List<ResultJoinData>> { users ->
                Log.d(TAG, users.toString())
                requestListAdapter!!.submitList(users)
            })



        //swipe to delete functionality starts from here
        ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                requestListAdapter?.getUsers(viewHolder.adapterPosition)?.let {
                    val result = Results()
                    result.result_id = it.result_id!!
                    resultsViewModel?.deleteResult(result)
                    setSnackBar(
                        viewHolder.itemView,
                        resources.getString(R.string.delete_success),
                        it
                    )
                }
            }
        }).attachToRecyclerView(recyclerView)


        /*
        * below code snippet helps to force you a crash so that we can test it on firebase*/

       /* val crashButton = Button(this@MainActivity)
        crashButton.text = "Crash!"
        crashButton.setOnClickListener {
            Crashlytics.getInstance().crash() // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT))*/

    }



    override fun updateUser(results: ResultJoinData, viewType: Int) {
        val result = Results()
        result.result_id = results.result_id!!
        result.email = results.email!!
        result.gender = results.gender!!
        when (viewType) {
            R.id.addFloatingActionButton -> {
                showMessage(resources.getString(R.string.update_success))
                resultsViewModel?.let {
                    result.messageStatus = ACCEPT
                    it.updateResult(result)
                }
            }
            R.id.removeFloatingActionButton -> {
                showMessage(resources.getString(R.string.update_success))
                resultsViewModel?.let {
                    result.messageStatus = REJECT
                    it.updateResult(result)
                }
            }
            else -> showMessage(resources.getString(R.string.default_result))
        }
    }

    private fun initRecycleView() {
        recyclerView = findViewById(R.id.recycle_view)
        recyclerView?.layoutManager = (LinearLayoutManager(this, RecyclerView.VERTICAL, false))
        recyclerView?.hasFixedSize()
    }

    private fun setSnackBar(view: View, message: String, results: ResultJoinData) {
        val snack = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snack.setAction(UNDO) {
            resultsViewModel?.restoreResults(results)
        }
        snack.show()
    }

}
