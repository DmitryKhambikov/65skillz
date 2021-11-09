package com.dkhambikov.android_j0

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dkhambikov.android_j0.databinding.FragmentContactDetailsBinding


private const val ID_CONTACT = "ID_CONTACT"

class ContactDetailsFragment : Fragment() {

    private var param1: Int? = null
    private lateinit var binding: FragmentContactDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ID_CONTACT)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MainActivity).supportActionBar?.title = "Список контактов"
        (activity as MainActivity).abTitle = false
    }

    companion object {



        @JvmStatic
        fun newInstance(contactId: Int) =
            ContactDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID_CONTACT, contactId)

                }
            }
    }
}