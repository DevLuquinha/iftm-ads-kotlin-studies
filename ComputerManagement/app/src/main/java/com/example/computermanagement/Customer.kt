package com.example.computermanagement

class Customer (
    cpf : String,
    name : String,
    email : String,
    phoneNumber : String,
    computerModel : String,
    computerPrice : Double) {
    private var cpf : String
    private var name : String
    private var email : String
    private var phoneNumber : String
    private var computerModel : String
    private var computerPrice : Double

    init {
        this.cpf = cpf
        this.name = name
        this.email = email
        this.phoneNumber = phoneNumber
        this.computerModel = computerModel
        this.computerPrice = computerPrice
    }

    public fun getCpf() : String{
        return this.cpf
    }

    public fun setCpf(cpf : String){
        this.cpf = cpf;
    }

    public fun getName() : String{
        return this.name
    }

    public fun setName(name : String){
        this.name = name;
    }

    public fun getEmail() : String{
        return this.email
    }

    public fun setEmail(email : String){
        this.email = email;
    }

    public fun getPhoneNumber() : String{
        return this.phoneNumber
    }

    public fun setPhoneNumber(phoneNumber : String){
        this.phoneNumber = phoneNumber;
    }

    public fun getComputerModel() : String{
        return this.computerModel
    }

    public fun setComputerModel(computerModel : String){
        this.computerModel = computerModel;
    }

    public fun getComputerPrice() : Double{
        return this.computerPrice
    }

    public fun setComputerPrice(computerPrice : Double){
        this.computerPrice = computerPrice;
    }
}