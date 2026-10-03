package com.example.chocolatestorage

class Customer (cpf: String, name: String, email: String, phoneNumber: String, age: Int) {

    var cpf: String

    var name: String
    var email: String
    var phoneNumber: String
    var age: Int

    init {
        this.cpf = cpf
        this.name = name
        this.email = email
        this.phoneNumber = phoneNumber
        this.age = age
    }

    override fun toString(): String {
        return  "-CPF: $cpf -NAME: $name " +
                "\n-EMAIL: $email -PHONE: $phoneNumber -AGE: $age"
    }
}