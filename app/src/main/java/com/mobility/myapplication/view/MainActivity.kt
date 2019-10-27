package com.mobility.myapplication.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobility.myapplication.R
import com.mobility.myapplication.adapter.RequestListAdapter
import com.mobility.myapplication.model.ResultJoinData
import com.mobility.myapplication.model.Results
import com.mobility.myapplication.showMessage
import com.mobility.myapplication.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RequestListAdapter.OnItemClickListener {

    private var userViewModel: UserViewModel? = null
    private var recyclerView: RecyclerView? = null
    private var requestListAdapter: RequestListAdapter? = null

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
        const val ACCEPT: String = "accepted"
        const val REJECT: String = "rejected"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRecycleView()
        requestListAdapter = RequestListAdapter()
        recyclerView!!.adapter = requestListAdapter
        requestListAdapter!!.setOnItemClickListener(this)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel?.getResultList()?.observe(this,
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
                    userViewModel?.deleteResult(result)
                    showMessage(resources.getString(R.string.delete_success))
                }
            }
        }).attachToRecyclerView(recyclerView)
    }

    override fun updateUser(results: ResultJoinData, viewType: Int) {
        val result = Results()
        result.result_id = results.result_id!!
        result.email = results.email!!
        result.gender = results.gender!!
        when (viewType) {
            R.id.addFloatingActionButton -> {
                showMessage(resources.getString(R.string.update_success))
                userViewModel?.let {
                    result.messageStatus = ACCEPT
                    it.updateResult(result)
                }
            }
            R.id.removeFloatingActionButton -> {
                showMessage(resources.getString(R.string.update_success))
                userViewModel?.let {
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

}
