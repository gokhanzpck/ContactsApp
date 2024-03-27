package com.gokhanzopcuk.contactsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.gokhanzopcuk.contactsapp.Adapter.KisiAdapter
import com.gokhanzopcuk.contactsapp.DataBase.Kisiler
import com.gokhanzopcuk.contactsapp.DataBase.KisilerDao
import com.gokhanzopcuk.contactsapp.DataBase.VeriTabani
import com.gokhanzopcuk.contactsapp.R
import com.gokhanzopcuk.contactsapp.databinding.FragmentHomePageBinding
import com.gokhanzopcuk.contactsapp.databinding.FragmentKayitBinding


class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private val kisilerListesi = ArrayList<Kisiler>()
    private lateinit var adapter: KisiAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding= FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vo=VeriTabani(requireContext())
        val kisilerDao = KisilerDao().kisileriOku(vo)





        binding.button.setOnClickListener {
          Navigation.findNavController(it).navigate(R.id.homeKayitGecis)
        }
        binding.rv.layoutManager = LinearLayoutManager(requireContext())


        for (i in kisilerDao ){
            kisilerListesi.add(i)
        }
        adapter = KisiAdapter(requireContext(),kisilerListesi)
        binding.rv.adapter = adapter
}




}