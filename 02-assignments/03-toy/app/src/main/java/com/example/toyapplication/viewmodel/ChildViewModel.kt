package com.example.toyapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toyapplication.data.Child
import com.example.toyapplication.repository.ChildRepository
import kotlinx.coroutines.launch

class ChildViewModel(private val repository: ChildRepository) : ViewModel() {
    fun insert(child: Child){
        viewModelScope.launch {
            repository.insert(child)
        }
    }

    fun update(child: Child){
        viewModelScope.launch {
            repository.update(child)
        }
    }

    fun delete(child: Child){
        viewModelScope.launch {
            repository.delete(child)
        }
    }

    fun findByChildCpf(cpf: String, callback: (Child?) -> Unit){
        viewModelScope.launch {
            val child = repository.findByChildCpf(cpf)
            callback(child)
        }
    }

    fun findByGuardianCpf(cpf: String, callback: (List<Child>) -> Unit){
        viewModelScope.launch {
            val guardian = repository.findByGuardianCpf(cpf)
            callback(guardian)
        }
    }

    fun countChildren(callback: (Int) -> Unit){
        viewModelScope.launch {
            val count = repository.countChildren()
            callback(count)
        }
    }

    fun averageAge(callback: (Double?) -> Unit){
        viewModelScope.launch {
            callback(repository.averageAge())
        }
    }
}