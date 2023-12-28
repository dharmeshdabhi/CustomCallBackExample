package com.example.customcallback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.customcallback.databinding.ActivityMainBinding


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.showBottomSheet.setOnClickListener {
            val myBottomSheet = MyBottomSheet()

            //Set my listener to listen new changes
            //Here we passed MyListener to get new update value

            myBottomSheet.setListener(object : MyListener {

                //this method will be called when we change value in bottom sheet and submit
                override fun onValueChange(value: String) {
                    mBinding.showBottomSheet.text = value
                }

            })
            myBottomSheet.show(supportFragmentManager, "mybottomSheet")
        }
    }
}


/**
 * This is an custom interface to listen value change
 * onValueChange method will be called when specific action will happen
 */
interface MyListener {
    /***
     * this method will be called when value will be chenge
     * @param value new value
     */
    fun onValueChange(value: String)
}