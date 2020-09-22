package com.example.musicplayer.ui.mylibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.musicplayer.R
import kotlinx.android.synthetic.main.fragment_my_library.*

class MyLibraryFragment : Fragment() {
    private lateinit var myLibraryViewModel: MyLibraryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myLibraryViewModel = ViewModelProviders.of(this).get(MyLibraryViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myLibraryViewModel =
            ViewModelProviders.of(this).get(MyLibraryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my_library, container, false)
        myLibraryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): MyLibraryFragmentContainer {
            return MyLibraryFragmentContainer().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}