package com.instoriestest.task.ui.camera.mvp

import android.content.Context
import androidx.camera.core.AspectRatio
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import com.instoriestest.task.ui.base.BasePresenter
import moxy.InjectViewState

@InjectViewState
class CameraPresenter: BasePresenter<CameraMvpView>() {

    private lateinit var imagePreview: Preview
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>

    fun initCamera(context: Context, previewView: PreviewView, lifecycleOwner: LifecycleOwner) {
        cameraProviderFuture = ProcessCameraProvider.getInstance(context)

        imagePreview = Preview.Builder().apply {
            setTargetAspectRatio(AspectRatio.RATIO_16_9)
        }.build()

        val cameraSelector = CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_FRONT).build()
        cameraProviderFuture.addListener(Runnable {
            val cameraProvider = cameraProviderFuture.get()
            cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, imagePreview)
            previewView.preferredImplementationMode = PreviewView.ImplementationMode.TEXTURE_VIEW
            imagePreview.setSurfaceProvider(previewView.createSurfaceProvider())
        }, ContextCompat.getMainExecutor(context))
    }
}