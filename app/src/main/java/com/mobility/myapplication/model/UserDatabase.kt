package com.mobility.myapplication.model

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mobility.myapplication.network.ServiceBuilder
import com.mobility.myapplication.network.ServiceInterface
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Response

/**
 *
 * Created By J7202687 On 10/22/2019
 */

@Database(entities = [Results::class, Name::class, Location::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getNameDao(): NameDao

    abstract fun getResultDao(): ResultDao

    fun cleanUp() {
        userDataBaseInstance = null
    }


    companion object {

        private var userDataBaseInstance: UserDatabase? = null

        internal fun getInstance(context: Context): UserDatabase? {
            if (userDataBaseInstance == null) {
                userDataBaseInstance =
                    Room.databaseBuilder(context, UserDatabase::class.java, "UserDatabase")
                        .addCallback(roomCallback).build()


            }
            return userDataBaseInstance
        }


        private val roomCallback = object : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                getUserList(userDataBaseInstance)
            }
        }


        //getting initial data from web server
        private fun getUserList(userDataBaseInstance: UserDatabase?) {
            val serviceInterface =
                ServiceBuilder.getRetrofitInstance()!!.create(ServiceInterface::class.java)
            val callUserList = serviceInterface!!.getFriendRequestsList("10")
            callUserList.enqueue(object : retrofit2.Callback<Example> {

                override fun onFailure(call: Call<Example>, t: Throwable) {
                }

                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    if (response.isSuccessful) {
                        Thread {
                            val responseBody = response.body()!!
                            Log.d("Response", responseBody.results.toString())
                            for (results in responseBody.results) {
                                userDataBaseInstance!!.getResultDao().addResult(results)
                                userDataBaseInstance.getNameDao().addName(results.name!!)
                                userDataBaseInstance!!.getResultDao()
                                    .addLocation(results.location!!)
                            }

                        }.start()
                    }
                }
            })
        }

        /*  fun isNetworkAvailable(): Boolean {
              val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
              val activeNetworkInfo = connectivityManager.activeNetworkInfo
              return activeNetworkInfo != null && activeNetworkInfo.isConnected
          }*/


    }


}
