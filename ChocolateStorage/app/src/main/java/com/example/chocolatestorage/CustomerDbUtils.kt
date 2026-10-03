package com.example.chocolatestorage

class CustomerDbUtils {
    companion object{
        fun getAllCustomers(dbHelper: MyDatabaseHelper): ArrayList<Customer>{
            var customerList = ArrayList<Customer>()

            val readableDbInstance = dbHelper.readableDatabase
            var resultCursor = readableDbInstance.rawQuery(
                "SELECT * FROM ${MyDatabaseHelper.CUSTOMER_TABLE_NAME}",
                null
            )

            with(resultCursor){
                while(moveToNext()){
                    val cpf = getString(getColumnIndexOrThrow(MyDatabaseHelper.CUSTOMER_COLUMN_CPF))
                    val name = getString(getColumnIndexOrThrow(MyDatabaseHelper.CUSTOMER_COLUMN_NAME))
                    val email = getString(getColumnIndexOrThrow(MyDatabaseHelper.CUSTOMER_COLUMN_EMAIL))
                    val phoneNumber = getString(getColumnIndexOrThrow(MyDatabaseHelper.CUSTOMER_COLUMN_PHONE_NUMBER))
                    val age = getInt(getColumnIndexOrThrow(MyDatabaseHelper.CUSTOMER_COLUMN_AGE))

                    val customer = Customer(cpf, name, email, phoneNumber, age)
                    customerList.add(customer)
                }
            }

            return customerList
        }
    }
}