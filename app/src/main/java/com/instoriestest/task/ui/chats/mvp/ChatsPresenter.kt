package com.instoriestest.task.ui.chats.mvp

import android.content.Context
import android.os.Handler
import com.instoriestest.task.R
import com.instoriestest.task.entities.Chat
import com.instoriestest.task.entities.ChatMessage
import com.instoriestest.task.entities.User
import com.instoriestest.task.ui.base.BasePresenter
import com.instoriestest.task.ui.chat.mvp.SelectedChatMvpView
import com.instoriestest.task.ui.chats.adapter.ChatsAdapter
import moxy.InjectViewState

@InjectViewState
class ChatsPresenter: BasePresenter<ChatsMvpView>() {

    fun addItem(adapter: ChatsAdapter, context: Context) {
        Handler().post {
            adapter.addItem(
                Chat(
                    user = User("Elon Musk"),
                    message = ChatMessage("Hello from TESLA", fromMe = false),
                    time = "10min",
                    image = context.resources.getDrawable(R.drawable.ic_user)
                )
            )
        }
    }
}