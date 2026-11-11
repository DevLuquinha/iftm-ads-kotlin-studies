package com.example.toyapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ChildDao {
    @Insert
    suspend fun insert(child: Child)

    @Update
    suspend fun update(child: Child)

    @Delete
    suspend fun delete(child: Child)

    @Query("SELECT * FROM children")
    suspend fun findAll(): List<Child>

    // Search by the child's CPF (primary key): returns at most one child
    @Query("SELECT * FROM children WHERE childCpf = :cpf")
    suspend fun findByChildCpf(cpf: String): Child?

    // Search by the guardian's CPF: one guardian can have more than one child
    @Query("SELECT * FROM children WHERE guardianCpf = :cpf")
    suspend fun findByGuardianCpf(cpf: String): List<Child>

    // How many children are registered
    @Query("SELECT COUNT(*) FROM children")
    suspend fun countChildren(): Int

    // Average age of the children (null when the table is empty)
    @Query("SELECT AVG(childAge) FROM children")
    suspend fun averageAge(): Double?
}
