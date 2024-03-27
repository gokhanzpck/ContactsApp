package com.gokhanzopcuk.contactsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.gokhanzopcuk.contactsapp.DataBase.KisilerDao
import com.gokhanzopcuk.contactsapp.DataBase.VeriTabani
import com.gokhanzopcuk.contactsapp.R
import com.gokhanzopcuk.contactsapp.databinding.FragmentKayitBinding

class KayitFragment : Fragment() {

private lateinit var binding: FragmentKayitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
       binding=FragmentKayitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    val vo=VeriTabani(requireContext())
        val kisilerDao=KisilerDao()
     binding.buttonsave.setOnClickListener {
         val ad=binding.editTextText.text.toString()
         val tel=binding.editTextText2.text.toString()
         kisilerDao.kisiEkle(vo,ad,tel)
         Navigation.findNavController(it).navigate(R.id.kayitHomeGecis)
     }

    }
}