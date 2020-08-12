package com.instoriestest.task.ui.camera

import com.instoriestest.task.R
import com.instoriestest.task.ui.base.BaseFragment
import com.instoriestest.task.ui.camera.mvp.CameraMvpView
import com.instoriestest.task.ui.camera.mvp.CameraPresenter
import kotlinx.android.synthetic.main.fragment_camera.*
import moxy.presenter.InjectPresenter

class CameraFragment: BaseFragment(R.layout.fragment_camera), CameraMvpView {

    @InjectPresenter
    lateinit var presenter: CameraPresenter

    override fun onInitView() {
        presenter.initCamera(requireContext(), previewView, this)
    }
}