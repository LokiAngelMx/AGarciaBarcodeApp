package com.example.barcodeapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barcodeapp.domain.use_cases.GetProducts
import com.example.barcodeapp.presentation.events.ProductsEvent
import com.example.barcodeapp.presentation.states.ProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val prueba: String,
    private val getProducts: GetProducts
): ViewModel() {
    private val _state = MutableStateFlow(ProductState())
    val state = _state.asStateFlow()
    private val _uiEvent = Channel<String>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getString() = prueba
    init {
        loadProducts()
    }

    private fun loadProducts(){
        viewModelScope.launch {
            try {
                getProducts().collect {
                    _state.value = ProductState(products = it)
                }
            } catch (e: Exception) {
                Log.i("Error", "Falló el método getProducts")
            }
        }
    }

    fun onEvent(event: ProductsEvent){
        when(event){
            ProductsEvent.OnDelete -> {

            }
            is ProductsEvent.OnScan -> {
                val barcode = event.barcode
                val product = _state.value.products.find { it.barcode == barcode }
                if(product != null){
                    val updateList = _state.value.shoppingCartProduct.toMutableList()
                    updateList.add(product)
                    _state.value = _state.value.copy(shoppingCartProduct = updateList)
                }
                else{
                    // Mostrar que el producto no existe
                    viewModelScope.launch {
                        _uiEvent.send("Producto no encontrado")
                    }
                }
            }
        }
    }
}