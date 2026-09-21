package com.example.passingdatabetweenscreens

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Student(
    var academicRecord: String,
    var name: String,
    var age: Int,
    var courseName: String,
    var isResidentUberaba: Boolean
) : Parcelable {

    override fun toString(): String {
        return "AR: $academicRecord | NAME: $name | AGE: $age | COURSE NAME: $courseName | IS RESIDENT UBERABA $isResidentUberaba"
    }
}