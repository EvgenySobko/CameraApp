package com.instoriestest.task.ui.chat

import android.view.inputmethod.EditorInfo
import com.instoriestest.task.R
import com.instoriestest.task.entities.Chat
import com.instoriestest.task.entities.ChatMessage
import com.instoriestest.task.ui.base.BaseFragment
import com.instoriestest.task.ui.chat.adapter.SelectedChatAdapter
import com.instoriestest.task.ui.chat.mvp.SelectedChatMvpView
import com.instoriestest.task.ui.chat.mvp.SelectedChatPresenter
import kotlinx.android.synthetic.main.fragment_selected_chat.*
import moxy.presenter.InjectPresenter

class SelectedChatFragment: BaseFragment(R.layout.fragment_selected_chat), SelectedChatMvpView {

    @InjectPresenter
    lateinit var presenter: SelectedChatPresenter

    private val chatAdapter = SelectedChatAdapter()

    override fun onInitView() {
        chatName.text = (arguments?.getSerializable("chat") as Chat).user.name
        selectedChatRV.adapter = chatAdapter
        myMessage.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                presenter.addItem(chatAdapter, ChatMessage(myMessage.text.toString(), true))
                myMessage.text?.clear()
            }
            true
        }
    }
}