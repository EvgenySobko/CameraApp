package com.instoriestest.task.ui.chat.mvp

import android.os.Handler
import com.instoriestest.task.entities.ChatMessage
import com.instoriestest.task.ui.base.BasePresenter
import com.instoriestest.task.ui.chat.adapter.SelectedChatAdapter
import moxy.InjectViewState

@InjectViewState
class SelectedChatPresenter : BasePresenter<SelectedChatMvpView>() {

    fun addItem(adapter: SelectedChatAdapter, message: ChatMessage) {
        Handler().post {
            if (message.fromMe) {
                adapter.addItem(message)
                adapter.addItem(ChatMessage("Hello!", false))
            }
        }
    }
}
