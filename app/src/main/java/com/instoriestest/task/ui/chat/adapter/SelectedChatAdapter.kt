package com.instoriestest.task.ui.chat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.instoriestest.task.R
import com.instoriestest.task.entities.ChatMessage
import kotlinx.android.synthetic.main.item_message_from_another.view.*
import kotlinx.android.synthetic.main.item_message_from_me.view.*

class SelectedChatAdapter: RecyclerView.Adapter<SelectedChatAdapter.SelectedChatViewHolder>() {

    private val items = mutableListOf<ChatMessage>()

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return if (items[position].fromMe) 0
        else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedChatViewHolder {
        return when (viewType) {
            0 -> SelectedChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_message_from_me, parent, false), viewType)
            else -> SelectedChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_message_from_another, parent, false), viewType)
        }
    }

    override fun onBindViewHolder(holder: SelectedChatViewHolder, position: Int) {
        holder.bind(items[position])
    }
    
    fun addItem(item: ChatMessage) {
        items.add(item)
        notifyDataSetChanged()
    }

    inner class SelectedChatViewHolder(view: View, private val viewType: Int): RecyclerView.ViewHolder(view) {

        fun bind(item: ChatMessage) {
            when (viewType) {
                0 -> itemView.messageFromMe.text = item.message
                else -> itemView.messageFromAnother.text = item.message
            }

        }
    }
}