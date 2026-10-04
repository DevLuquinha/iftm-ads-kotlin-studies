package com.example.chocolatestorage

class Chocolate (id: String, amountCocoa: Int, color: String, price: Double, customerCpf: String) {
    var id: String
    var amountCocoa: Int
    var color: String
    var price: Double
    var customerCpf: String

    init {
        this.id = id
        this.amountCocoa = amountCocoa
        this.color = color
        this.price = price
        this.customerCpf = customerCpf
    }

    override fun toString(): String {
        return  "-ID: $id -AMOUNT OF COCOA (%): $amountCocoa " +
                "\n-COLOR: $color -PRICE: $price"
    }
}