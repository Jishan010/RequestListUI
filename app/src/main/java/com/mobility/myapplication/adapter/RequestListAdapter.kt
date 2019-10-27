package com.mobility.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobility.myapplication.R
import com.mobility.myapplication.model.ResultNameData
import de.hdodenhof.circleimageview.CircleImageView

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

class RequestListAdapter :
    ListAdapter<ResultNameData, RequestListAdapter.MyUserViewHolder>(diffCallback) {

    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.request_list_adapter, parent, false)
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

        private val userNameTextView: TextView =
            itemView.findViewById(R.id.userNameTextView)
        private val descriptionTextView: TextView =
            itemView.findViewById(R.id.descriptionTextView)
        private var imageView: CircleImageView =
            itemView.findViewById(R.id.imageView)
        private var buttonGroup: Group =
            itemView.findViewById(R.id.buttonGroup)
        private var messageGroup: Group =
            itemView.findViewById(R.id.messageGroup)


        private var addFloatingActionButton: FloatingActionButton =
            itemView.findViewById(R.id.addFloatingActionButton)

        private var removeFloatingActionButton: FloatingActionButton =
            itemView.findViewById(R.id.removeFloatingActionButton)


        init {
            addFloatingActionButton.setOnClickListener {
                onItemClickListener!!.updateUser(
                    getUsers(
                        adapterPosition
                    )!!, R.id.addFloatingActionButton
                )
            }
            removeFloatingActionButton.setOnClickListener {
                onItemClickListener!!.updateUser(
                    getUsers(adapterPosition)!!,
                    R.id.removeFloatingActionButton
                )
            }
        }

        fun onBind(user: ResultNameData) {
            userNameTextView.text = user.first + " " + user.last
            descriptionTextView.text =
                user.age + " , " + user.email + " , " + user.city + " , " + user.state + " , " + user.country
            val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide.with(itemView.context).load(user.large).apply(requestOptions)
                .into(imageView)
        }
    }

    interface OnItemClickListener {
        fun updateUser(results: ResultNameData, viewType: Int)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ResultNameData>() {
            override fun areItemsTheSame(
                oldItem: ResultNameData,
                newItem: ResultNameData
            ): Boolean {
                return oldItem.email === newItem.email
            }

            override fun areContentsTheSame(
                oldItem: ResultNameData,
                newItem: ResultNameData
            ): Boolean {
                return oldItem.city.equals(newItem.city) && oldItem.large.equals(
                    newItem.large
                )
            }
        }
    }

}
