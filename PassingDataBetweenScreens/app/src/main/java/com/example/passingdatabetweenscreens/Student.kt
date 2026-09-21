package com.example.passingdatabetweenscreens

class Student (
    academicRecord : String,
    name : String,
    age : Int,
    courseName : String,
    isResidentUberaba : Boolean){

    var academicRecord : String
    var name : String
    var age : Int
    var courseName : String
    var isResidentUberaba : Boolean

    init {
        this.academicRecord = academicRecord
        this.name = name
        this.age = age
        this.courseName = courseName
        this.isResidentUberaba = isResidentUberaba
    }

    override fun toString(): String {
        return "AR: $academicRecord | NAME: $name | AGE: $age | COURSE NAME: $courseName | IS RESIDENT UBERABA $isResidentUberaba"
    }
}