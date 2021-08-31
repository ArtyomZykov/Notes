package com.example.zykov.notes.screens.new_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zykov.notes.R
import com.example.zykov.notes.databinding.FragmentAddNewNoteBinding
import com.example.zykov.notes.databinding.FragmentMainBinding
import com.example.zykov.notes.databinding.FragmentStartBinding
import com.example.zykov.notes.screens.start.StartFragmentViewModel
import com.example.zykov.notes.utilites.APP_ACTIVITY
import com.example.zykov.notes.utilites.TYPE_ROOM

class AddNewNoteFragment : Fragment() {
    private var _binding: FragmentAddNewNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewNoteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteFragmentViewModel::class.java)
        mBinding.btnAddNode.setOnClickListener {
            // fun in ViewModel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}