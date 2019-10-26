package com.mobility.myapplication.view

//import com.mobility.myapplication.adapter.UserListAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobility.myapplication.R
import com.mobility.myapplication.model.Results
import com.mobility.myapplication.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userViewModel: UserViewModel? = null
    private var userList: List<Results>? = null
    private var recyclerView: RecyclerView? = null
//    private var userListAdapter: UserListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRecycleView()
//        userListAdapter = UserListAdapter()
//        recyclerView!!.adapter = userListAdapter

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel?.getUserList()?.observe(this,
            Observer<List<Results>> { users ->
                Log.d("MainActivity", users.toString())

                Thread {
                    for ((index, user) in users.withIndex()) {
                        val id = user.result_id
                        val firstName = userViewModel?.getUserName(id)
                        Log.d("MainActivity", firstName.toString())
                    }

                }.start()

//                userListAdapter!!.submitList(users)
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
              /*  userListAdapter?.getUsers(viewHolder.adapterPosition)?.let {
                    //                    userViewModel?.deleteUser(it)
                    showMessage(resources.getString(R.string.delete_success))
                }*/
            }
        }).attachToRecyclerView(recyclerView)


      /*  userListAdapter?.setOnItemClickListener(object : UserListAdapter.OnItemClickListener {
            override fun updateUser(user: User) {
                val intent = Intent(this@MainActivity, FullImageScreen::class.java)
                intent.putExtra(ID, user.id)
                intent.putExtra(LOGIN_USER, user.login)
                intent.putExtra(TYPE_USER, user.type)
                intent.putExtra(AVATAR_URL_USER, user.avatarUrl)
                startActivityForResult(intent, UPDATE_REQUEST_CODE!!)
            }
        })*/

        fab.setOnClickListener {
       /*     startActivityForResult(
                Intent(this@MainActivity, AddUserActivity::class.java),
                INSERT_REQUEST_CODE!!
            )*/
        }
    }

    private fun initRecycleView() {
        recyclerView = findViewById(R.id.recycle_view)
        recyclerView?.layoutManager = (LinearLayoutManager(this, RecyclerView.VERTICAL, false))
        recyclerView?.hasFixedSize()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
/*
        if (requestCode == INSERT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val user = User()
            data?.let {
                user.login = it.getStringExtra(LOGIN_USER)
                user.type = it.getStringExtra(TYPE_USER)
                user.avatarUrl = it.getStringExtra(AVATAR_URL_USER)
                //adding the new user locally
//                userViewModel?.insertUser(user)
                showMessage(resources.getString(R.string.insert_success))
            }


        } else if (requestCode == UPDATE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val user = User()
            data?.let {
                user.id = it.getIntExtra(ID, -1)
                if (user.id != -1) {
                    user.login = it.getStringExtra(LOGIN_USER)
                    user.type = it.getStringExtra(TYPE_USER)
                    user.avatarUrl = it.getStringExtra(AVATAR_URL_USER)
                    //deleting the user locally
//                    userViewModel?.deleteUser(user)
                    showMessage(resources.getString(R.string.delete_success))
                }
            }
        }*/
    }

}