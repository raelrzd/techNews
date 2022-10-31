package br.com.alura.technews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.repository.NoticiaRepository

class ListaNoticiasViewModel(private val repository: NoticiaRepository) : ViewModel() {

//    init {
//        Log.i("viewmodel", "criando viewModel ")
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        Log.i("viewmodel", "destruindo viewModel")
//    }

    fun buscaTodos(): LiveData<List<Noticia>> {
        val liveData = MutableLiveData<List<Noticia>>()
        repository.buscaTodos(quandoSucesso = { noticiasNovas ->
            liveData.value = noticiasNovas
        }, quandoFalha = {})
        return liveData
    }

}