package com.dkhambikov.android_j0

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout

class ContactListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactList: ConstraintLayout  = view.findViewById(R.id.contactListLayout)
        contactList.setOnClickListener {

            parentFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragmentLayout, ContactDetailsFragment.newInstance(contactId = 1234)).commit()
            (activity as MainActivity).supportActionBar?.title = "Детали контактов"
            (activity as MainActivity).abTitle = true

        }
    }
    companion object {
        @JvmStatic
        private val ID_CONTACT = "ID_CONTACT"

        @JvmStatic
        fun newInstance() =
            ContactListFragment()

    }


}