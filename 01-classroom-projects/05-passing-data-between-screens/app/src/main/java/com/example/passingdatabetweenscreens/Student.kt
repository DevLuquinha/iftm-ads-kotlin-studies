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
        return "- AR: $academicRecord " +
                "\n- NAME: $name " +
                "\n- AGE: $age " +
                "\n- COURSE NAME: $courseName " +
                "\n- ${if (isResidentUberaba) "LIVES IN UBERABA " else "NOT LIVES IN UBERABA"}"
    }
}