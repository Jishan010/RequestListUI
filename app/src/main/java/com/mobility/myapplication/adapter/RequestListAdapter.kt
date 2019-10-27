package com.mobility.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobility.myapplication.R
import com.mobility.myapplication.model.ResultJoinData
import com.mobility.myapplication.view.MainActivity
import de.hdodenhof.circleimageview.CircleImageView

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

class RequestListAdapter :
    ListAdapter<ResultJoinData, RequestListAdapter.MyUserViewHolder>(diffCallback) {

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

    fun getUsers(position: Int): ResultJoinData? {
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

        private var view: View =
            itemView.findViewById(R.id.view)

        private var messageTextView: TextView =
            itemView.findViewById(R.id.messageTextView)

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

        fun onBind(user: ResultJoinData) {

            buttonGroup.visibility = View.VISIBLE
            messageGroup.visibility = View.GONE

            userNameTextView.text = user.first + " " + user.last
            descriptionTextView.text =
                user.age + " , " + user.email + " , " + user.city + " , " + user.state + " , " + user.country
            val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide.with(itemView.context).load(user.large).apply(requestOptions)
                .into(imageView)

            user.messageStatus?.let {
                when (it) {
                    MainActivity.ACCEPT -> {
                        buttonGroup.visibility = View.GONE
                        messageGroup.visibility = View.VISIBLE

                        messageTextView.text = itemView.context.resources.getString(R.string.accept)
                        view.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.colorGreen
                            )
                        )
                        messageTextView.setTextColor(
                            ContextCompat.getColor(
                                itemView.context,
                                android.R.color.white
                            )
                        )
                    }
                    MainActivity.REJECT -> {
                        buttonGroup.visibility = View.GONE
                        messageGroup.visibility = View.VISIBLE
                        messageTextView.text = itemView.context.resources.getString(R.string.reject)

                        view.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.colorGrey
                            )
                        )
                        messageTextView.setTextColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.greyTextColor
                            )
                        )

                    }
                    else -> {
                        buttonGroup.visibility = View.VISIBLE
                        messageGroup.visibility = View.GONE
                    }
                }
            }
        }
    }

    interface OnItemClickListener {
        fun updateUser(results: ResultJoinData, viewType: Int)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ResultJoinData>() {
            override fun areItemsTheSame(
                oldItem: ResultJoinData,
                newItem: ResultJoinData
            ): Boolean {
                return oldItem.result_id === newItem.result_id
            }

            override fun areContentsTheSame(
                oldItem: ResultJoinData,
                newItem: ResultJoinData
            ): Boolean {
                return oldItem.messageStatus.equals(newItem.messageStatus)
            }
        }
    }

}
