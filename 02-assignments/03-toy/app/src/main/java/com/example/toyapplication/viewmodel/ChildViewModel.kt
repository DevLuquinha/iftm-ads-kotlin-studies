package com.example.toyapplication.viewmodel

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toyapplication.data.Child
import com.example.toyapplication.repository.ChildRepository
import kotlinx.coroutines.launch

class ChildViewModel(private val repository: ChildRepository) : ViewModel() {
    fun insert(child: Child, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                repository.insert(child)
                callback(true)
            } catch (e: SQLiteConstraintException) {
                callback(false)
            }
        }
    }

    fun update(child: Child, callback: () -> Unit) {
        viewModelScope.launch {
            repository.update(child)
            callback()
        }
    }

    fun delete(child: Child, callback: () -> Unit) {
        viewModelScope.launch {
            repository.delete(child)
            callback()
        }
    }

    fun findAll(callback: (List<Child>) -> Unit) {
        viewModelScope.launch {
            callback(repository.findAll())
        }
    }

    fun findByChildCpf(cpf: String, callback: (Child?) -> Unit) {
        viewModelScope.launch {
            val child = repository.findByChildCpf(cpf)
            callback(child)
        }
    }

    fun findByGuardianCpf(cpf: String, callback: (List<Child>) -> Unit) {
        viewModelScope.launch {
            val children = repository.findByGuardianCpf(cpf)
            callback(children)
        }
    }

    fun countChildren(callback: (Int) -> Unit) {
        viewModelScope.launch {
            val count = repository.countChildren()
            callback(count)
        }
    }

    fun averageAge(callback: (Double?) -> Unit) {
        viewModelScope.launch {
            callback(repository.averageAge())
        }
    }
}