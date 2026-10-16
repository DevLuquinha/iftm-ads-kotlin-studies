package com.example.learningjetpackcompose.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "MyDatabase.db"
        private const val DATABASE_VERSION = 1

        // Customer
        const val CUSTOMER_TABLE_NAME = "customer"
        const val CUSTOMER_COLUMN_CPF = "cpf"
        const val CUSTOMER_COLUMN_NAME = "name"
        const val CUSTOMER_COLUMN_EMAIL = "email"
        const val CUSTOMER_COLUMN_PHONE_NUMBER = "phone_number"
        const val CUSTOMER_COLUMN_AGE = "age"

        private const val CREATE_TABLE_CUSTOMER = """
            CREATE TABLE $CUSTOMER_TABLE_NAME (
                $CUSTOMER_COLUMN_CPF TEXT PRIMARY KEY,
                $CUSTOMER_COLUMN_NAME TEXT,
                $CUSTOMER_COLUMN_EMAIL TEXT,
                $CUSTOMER_COLUMN_PHONE_NUMBER TEXT,
                $CUSTOMER_COLUMN_AGE INTEGER
            )
        """
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_CUSTOMER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $CUSTOMER_TABLE_NAME")

        onCreate(db)
    }
}