package com.example.employeemanagement.data

data class Employee(
    var cpf: String = "",
    var name: String = "",
    var age: Int = 0,
    var salary: Double = 0.0,
    var sector: String = ""
)