package com.gokhanzopcuk.contactsapp.DataBase

import android.annotation.SuppressLint
import android.content.ContentValues

class KisilerDao {
    fun kisiEkle(vo:VeriTabani,kisiAd:String,kisiTel:String){
        val db=vo.writableDatabase
        val values=ContentValues()
        values.put("kisiAd",kisiAd)
        values.put("kisiTel",kisiTel)
        db.insertOrThrow("kisiler",null,values)
        db.close()
    }
    @SuppressLint("Range")
    fun kisileriOku(vo : VeriTabani):ArrayList<Kisiler>{
        val kisilerListesi=ArrayList<Kisiler>()
        val db=vo.writableDatabase
        val cursor=db.rawQuery("SELECT * FROM kisiler",null)
        while (cursor.moveToNext()){
            val kisi=Kisiler(cursor.getInt(cursor.getColumnIndex("kisiNo"))
            ,cursor.getString(cursor.getColumnIndex("kisiAd"))
            ,cursor.getString(cursor.getColumnIndex("kisiTel")))
            kisilerListesi.add(kisi)
        }
        return kisilerListesi
    }
    fun kisiSil(vo: VeriTabani,kisiNo:Int){
        val db=vo.writableDatabase
        db.delete("kisiler","kisiNo=?", arrayOf(kisiNo.toString()))
        db.close()
    }
    fun kisiGuncelle(vo: VeriTabani,kisiNo: Int,kisiAd: String,kisiTel: String){
        val db=vo.writableDatabase
        val values=ContentValues()
        values.put("kisiNo",kisiNo)
        values.put("kisiAd",kisiAd)
        values.put("kisiTel",kisiTel)
        db.update("kisiler",values,"kisiNo=?", arrayOf(kisiNo.toString()))
        db.close()
    }




}