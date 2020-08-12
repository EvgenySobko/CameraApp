package com.instoriestest.task.ui.chats

import android.os.Handler
import com.instoriestest.task.R
import com.instoriestest.task.entities.Chat
import com.instoriestest.task.entities.ChatMessage
import com.instoriestest.task.entities.User
import com.instoriestest.task.ui.base.BaseFragment
import com.instoriestest.task.ui.chats.adapter.ChatsAdapter
import com.instoriestest.task.ui.chats.mvp.ChatsMvpView
import com.instoriestest.task.ui.chats.mvp.ChatsPresenter
import kotlinx.android.synthetic.main.fragment_chats.*
import moxy.presenter.InjectPresenter

class ChatsFragment: BaseFragment(R.layout.fragment_chats), ChatsMvpView {

    @InjectPresenter
    lateinit var chatsPresenter: ChatsPresenter

    private val chatClick: (item: Chat) -> Unit = {
        val action = ChatsFragmentDirections.actionNavigationChatsToNavigationSelectedChat(it)
        getNavController().navigate(action)
    }

    private val chatsAdapter = ChatsAdapter { chatClick.invoke(it) }

    override fun onInitView() {
        if (chatsAdapter.itemCount == 0) {
            chatsPresenter.addItem(chatsAdapter, requireContext())
        }
        chatsRV.adapter = chatsAdapter
    }
}