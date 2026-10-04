package com.example.chocolatestorage

class ChocolateDbUtils {
    companion object{
        fun getAllChocolates(dbHelper: MyDatabaseHelper): ArrayList<Chocolate>{
            var chocolateList = ArrayList<Chocolate>()

            val readableDbInstance = dbHelper.readableDatabase
            var resultCursor = readableDbInstance.rawQuery(
                "SELECT * FROM ${MyDatabaseHelper.CHOCOLATE_TABLE_NAME}",
                null
            )

            with(resultCursor){
                while(moveToNext()){
                    val id = getString(getColumnIndexOrThrow(MyDatabaseHelper.CHOCOLATE_COLUMN_ID))
                    val amountCocoa = getInt(getColumnIndexOrThrow(MyDatabaseHelper.CHOCOLATE_COLUMN_AMOUNT_COCOA))
                    val color = getString(getColumnIndexOrThrow(MyDatabaseHelper.CHOCOLATE_COLUMN_COLOR))
                    val price = getDouble(getColumnIndexOrThrow(MyDatabaseHelper.CHOCOLATE_COLUMN_PRICE))
                    val customerCpf = getString(getColumnIndexOrThrow(MyDatabaseHelper.CHOCOLATE_COLUMN_CUSTOMER_CPF))

                    val chocolate = Chocolate(id, amountCocoa, color, price, customerCpf)
                    chocolateList.add(chocolate)
                }
            }

            return chocolateList
        }
    }
}