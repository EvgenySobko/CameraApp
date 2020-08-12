package com.instoriestest.task.ui.chats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.instoriestest.task.R
import com.instoriestest.task.entities.Chat
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatsAdapter(private val click: (item: Chat) -> Unit): RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder>() {

    private val items = mutableListOf<Chat>()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        return ChatsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false))
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addItem(item: Chat) {
        items.add(item)
        notifyDataSetChanged()
    }

    inner class ChatsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: Chat) {
            with (itemView) {
                name.text = item.user.name
                messageFromMe.text = item.message.message
                time.text = item.time
                image.setImageDrawable(item.image)
                setOnClickListener { click.invoke(item) }
            }
        }
    }
}