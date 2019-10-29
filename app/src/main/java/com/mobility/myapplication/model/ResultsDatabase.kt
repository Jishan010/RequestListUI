package com.mobility.myapplication.model

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mobility.myapplication.network.ServiceBuilder
import com.mobility.myapplication.network.ServiceInterface
import retrofit2.Call
import retrofit2.Response

/**
 *
 * Created By J7202687 On 10/22/2019
 */

@Database(
    entities = [Results::class, Name::class, Location::class, Dob::class, Picture::class],
    version = 1
)
abstract class ResultsDatabase : RoomDatabase() {

    abstract fun getResultDao(): ResultDao

    fun cleanUp() {
        resultsDataBaseInstance = null
    }


    companion object {

        private var resultsDataBaseInstance: ResultsDatabase? = null

        fun getInstance(context: Context): ResultsDatabase? {
            if (resultsDataBaseInstance == null) {
                resultsDataBaseInstance =
                    Room.databaseBuilder(context, ResultsDatabase::class.java, "ResultsDatabase")
                        .addCallback(roomCallback).build()
            }
            return resultsDataBaseInstance
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                getUserList(resultsDataBaseInstance)
            }
        }


        //getting initial data from web server
        private fun getUserList(resultsDataBaseInstance: ResultsDatabase?) {
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
                            responseBody.results?.let {
                                for (results in it) {
                                    resultsDataBaseInstance!!.getResultDao().addResult(results)
                                    resultsDataBaseInstance.getResultDao().addName(results.name!!)
                                    resultsDataBaseInstance!!.getResultDao()
                                        .addLocation(results.location!!)
                                    resultsDataBaseInstance!!.getResultDao()
                                        .addPicture(results.picture!!)
                                    resultsDataBaseInstance!!.getResultDao()
                                        .addDob(results.dob!!)
                                }
                            }
                        }.start()
                    }
                }
            })
        }
    }


}
