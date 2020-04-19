package com.dheeraj.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dheeraj.viewmodel.R.layout
import com.dheeraj.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        activityMainBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, null, false)
        activityMainBinding.apply {
            viewModel = this@MainActivity.viewModel
            setContentView(this.root)
        }
        initViews()
        initObservers()
        Log.d("onCreate", "${viewModel.count.value}")
    }

    private fun initViews() {
        activityMainBinding.textView.text = "${viewModel.count.value}"
    }

    private fun initObservers() {
        viewModel.count.observe(this, Observer {
            activityMainBinding.textView.text = "$it"
        })

        viewModel.finishEvent.observe(this, Observer {
            finish()
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart", "${viewModel.count.value}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume", "${viewModel.count.value}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause", "${viewModel.count.value}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop", "${viewModel.count.value}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy", "${viewModel.count.value}")
    }
}
