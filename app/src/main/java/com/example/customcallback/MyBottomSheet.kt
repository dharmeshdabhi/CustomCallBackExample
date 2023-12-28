package com.example.customcallback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.customcallback.databinding.MyBottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheet : BottomSheetDialogFragment() {

    private lateinit var mBinding: MyBottomsheetBinding
    private var listener: MyListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.my_bottomsheet,
            container,
            false
        )
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Business logic will be here

        mBinding.btnSubmit.setOnClickListener {
            val result = mBinding.myEditText.text.toString()

            //Send result to previous screen (Host screen)
            listener?.onValueChange(result)
            dismiss()
        }
    }


    /**
     * this method will set MyListener object to global variable so we can send data
     */
    public fun setListener(myListener: MyListener) {
        this.listener = myListener
    }
}