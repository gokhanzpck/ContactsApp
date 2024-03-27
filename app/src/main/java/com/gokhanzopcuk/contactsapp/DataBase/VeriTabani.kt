package com.gokhanzopcuk.contactsapp.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeriTabani(context: Context):SQLiteOpenHelper(context,"rehber",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
      db?.execSQL("CREATE TABLE kisiler(kisiNo INTEGER PRIMARY KEY AUTOINCREMENT ,kisiAd TEXT,kisiTel TEXT);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
     db?.execSQL("DROP TABLE IF EXISTS kisiler")
        onCreate(db)
    }


}