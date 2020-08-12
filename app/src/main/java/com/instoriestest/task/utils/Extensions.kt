package com.instoriestest.task.utils

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.instoriestest.task.ui.base.BaseFragment

fun BaseFragment.toast(any: Any) = Toast.makeText(context, any.toString(), Toast.LENGTH_SHORT).show()

fun AppCompatActivity.toast(any: Any) = Toast.makeText(applicationContext, any.toString(), Toast.LENGTH_SHORT).show()