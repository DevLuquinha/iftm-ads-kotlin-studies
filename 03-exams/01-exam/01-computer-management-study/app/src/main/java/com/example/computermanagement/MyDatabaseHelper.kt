package com.example.computermanagement

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper (context: Context) :
 SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    companion object {
        private const val DATABASE_NAME = "MyDatabase.db"
        private const val DATABASE_VERSION = 1

        const val TABLE_NAME = "customers"
        const val COLUMN_CPF = "cpf"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PHONE_NUMBER = "phone_number"
        const val COLUMN_COMPUTER_MODEL = "computer_model"
        const val COLUMN_COMPUTER_PRICE = "computer_price"

        private const val CREATE_TABLE_CUSTOMERS = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_CPF TEXT PRIMARY KEY,
                $COLUMN_NAME TEXT,
                $COLUMN_EMAIL TEXT,
                $COLUMN_PHONE_NUMBER TEXT,
                $COLUMN_COMPUTER_MODEL TEXT,
                $COLUMN_COMPUTER_PRICE REAL
            )
        """
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_CUSTOMERS)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}