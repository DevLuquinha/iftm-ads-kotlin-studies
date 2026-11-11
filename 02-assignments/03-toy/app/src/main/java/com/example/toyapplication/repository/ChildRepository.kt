package com.example.toyapplication.repository

import com.example.toyapplication.data.Child
import com.example.toyapplication.data.ChildDao

class ChildRepository(private val dao: ChildDao) {
    suspend fun insert(child: Child) {
        dao.insert(child)
    }

    suspend fun update(child: Child) {
        dao.update(child)
    }

    suspend fun delete(child: Child) {
        dao.delete(child)
    }

    suspend fun findAll(): List<Child> {
        return dao.findAll()
    }

    suspend fun findByChildCpf(cpf: String): Child?{
        return dao.findByChildCpf(cpf)
    }

    suspend fun findByGuardianCpf(cpf: String): List<Child>{
        return dao.findByGuardianCpf(cpf)
    }

    suspend fun countChildren(): Int{
        return dao.countChildren()
    }

    suspend fun averageAge(): Double?{
        return dao.averageAge()
    }
}