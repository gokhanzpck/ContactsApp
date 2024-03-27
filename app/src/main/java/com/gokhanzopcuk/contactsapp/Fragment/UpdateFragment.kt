package com.gokhanzopcuk.contactsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.gokhanzopcuk.contactsapp.DataBase.KisilerDao
import com.gokhanzopcuk.contactsapp.DataBase.VeriTabani
import com.gokhanzopcuk.contactsapp.R
import com.gokhanzopcuk.contactsapp.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {
private lateinit var binding: FragmentUpdateBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding= FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    val vo=VeriTabani(requireContext())
        val kisilerDao=KisilerDao()
        val bundle:UpdateFragmentArgs by navArgs()
        val gelenKisi=bundle.kisi
        val kisi_id=gelenKisi.kisiNo
        binding.editTextText3.setText(gelenKisi.kisiAd)
        binding.editTextText4.setText(gelenKisi.kisiTel)
        binding.buttonGNcelle.setOnClickListener {
            val kisiAd=binding.editTextText3.text.toString()
            val kisiTel=binding.editTextText4.text.toString()
           kisilerDao.kisiGuncelle(vo,kisi_id,kisiAd,kisiTel)
        Navigation.findNavController(it).navigate(R.id.updateHomeGecis)
        }
        binding.buttonSil.setOnClickListener {
            kisilerDao.kisiSil(vo,kisi_id)
            Navigation.findNavController(it).navigate(R.id.updateHomeGecis)
        }
        binding.buttonGNcelle2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.updateHomeGecis)
        }





    }


}