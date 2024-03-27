package com.gokhanzopcuk.contactsapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gokhanzopcuk.contactsapp.Adapter.KisiAdapter.cardTasarim
import com.gokhanzopcuk.contactsapp.DataBase.Kisiler
import com.gokhanzopcuk.contactsapp.Fragment.HomePageFragmentDirections
import com.gokhanzopcuk.contactsapp.databinding.CardTasarimBinding
import com.gokhanzopcuk.contactsapp.databinding.FragmentUpdateBinding

class KisiAdapter(var  mContext:Context,var kisilerListesi:List<Kisiler>):RecyclerView.Adapter<cardTasarim>(){
   inner class cardTasarim(var binding:CardTasarimBinding):RecyclerView.ViewHolder(binding.root)

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarim {
     val binding=CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
      return cardTasarim(binding)
   }

   override fun getItemCount(): Int {
      return kisilerListesi.size
   }

   override fun onBindViewHolder(holder: cardTasarim, position: Int) {
      val kisi=kisilerListesi.get(position)
      val t=holder.binding
      t.textView.text=kisi.kisiAd
      t.textView2.text=kisi.kisiTel
      t.cardView.setOnClickListener {
         val gecis=HomePageFragmentDirections.homeUpdateGecis(kisi=kisi)
         Navigation.findNavController(it).navigate(gecis)
      }
   }


}