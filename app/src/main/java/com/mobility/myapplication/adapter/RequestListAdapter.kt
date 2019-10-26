package com.mobility.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.mobility.myapplication.R
import com.mobility.myapplication.model.ResultNameData

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

class RequestListAdapter : ListAdapter<ResultNameData, RequestListAdapter.MyUserViewHolder>(diffCallback) {

    //    private List<Note> notes = new ArrayList<>();
    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.request_list_adapter, null)
        return MyUserViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyUserViewHolder, position: Int) {
        val user = getItem(position)
        holder.onBind(user)
    }


    fun getUsers(position: Int): ResultNameData? {
        return getItem(position)
    }


    inner class MyUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val userNameTextView: TextView = itemView.findViewById(R.id.userNameTextView)
        private val userTypeTextView: TextView = itemView.findViewById(R.id.userTypeTextView)
        private var imageView: ImageView = itemView.findViewById(R.id.imageView)

        init {
            itemView.setOnClickListener { onItemClickListener!!.updateUser(getUsers(adapterPosition)!!) }
        }

        fun onBind(user: ResultNameData) {
            userNameTextView.text = user.first
            userTypeTextView.text = user.email
            val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide.with(itemView.context).load(user.medium).apply(requestOptions)
                .into(imageView)
        }
    }

    interface OnItemClickListener {
        fun updateUser(user: ResultNameData)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ResultNameData>() {
            override fun areItemsTheSame(oldItem: ResultNameData, newItem: ResultNameData): Boolean {
                return oldItem.email === newItem.email
            }

            override fun areContentsTheSame(oldItem: ResultNameData, newItem: ResultNameData): Boolean {
                return oldItem.city.equals(newItem.city) && oldItem.medium.equals(
                    newItem.medium
                )
            }
        }
    }

}
