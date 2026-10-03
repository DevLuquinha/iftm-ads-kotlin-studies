package com.example.chocolatestorage

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


        // Chocolate
        const val CHOCOLATE_TABLE_NAME = "chocolate"
        const val CHOCOLATE_COLUMN_ID = "id"
        const val CHOCOLATE_COLUMN_AMOUNT_COCOA = "amount_cocoa"
        const val CHOCOLATE_COLUMN_COLOR = "chocolate_color"
        const val CHOCOLATE_COLUMN_PRICE = "price"
        const val CHOCOLATE_COLUMN_CUSTOMER_CPF = "customer_cpf"

        private const val CREATE_TABLE_CUSTOMER = """
            CREATE TABLE $CUSTOMER_TABLE_NAME (
                $CUSTOMER_COLUMN_CPF TEXT PRIMARY KEY,
                $CUSTOMER_COLUMN_NAME TEXT,
                $CUSTOMER_COLUMN_EMAIL TEXT,
                $CUSTOMER_COLUMN_PHONE_NUMBER TEXT,
                $CUSTOMER_COLUMN_AGE INTEGER
            )
        """

        private const val CREATE_TABLE_CHOCOLATE = """
            CREATE TABLE $CHOCOLATE_TABLE_NAME (
                $CHOCOLATE_COLUMN_ID TEXT PRIMARY KEY,
                $CHOCOLATE_COLUMN_AMOUNT_COCOA INTEGER,
                $CHOCOLATE_COLUMN_COLOR TEXT,
                $CHOCOLATE_COLUMN_PRICE REAL,
                $CHOCOLATE_COLUMN_CUSTOMER_CPF TEXT NOT NULL,

                FOREIGN KEY ($CHOCOLATE_COLUMN_CUSTOMER_CPF) 
                  REFERENCES $CUSTOMER_TABLE_NAME($CUSTOMER_COLUMN_CPF)
            )
        """
    }

    override fun onConfigure(db: SQLiteDatabase?) {
        super.onConfigure(db)

        db?.execSQL("PRAGMA foreign_keys = ON")
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_CUSTOMER)
        db?.execSQL(CREATE_TABLE_CHOCOLATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $CHOCOLATE_TABLE_NAME")
        db?.execSQL("DROP TABLE IF EXISTS $CUSTOMER_TABLE_NAME")

        onCreate(db)
    }
}