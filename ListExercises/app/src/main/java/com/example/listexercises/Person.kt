package com.example.listexercises

class Person (cpf: String, name: String, age:Int){
    var cpf : String;
    var name : String;
    var age : Int;

    init {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
    }

    override fun toString(): String {
        return "-CPF: $cpf " +
                "\n-Name: $name " +
                "\n-Age: $age";
    }
}