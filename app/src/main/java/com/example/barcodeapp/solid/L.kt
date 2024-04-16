package com.example.barcodeapp.solid

open class Figura{
    open fun calcularArea(): Double = 0.0
}

class Circulo(private val radio: Double): Figura(){
    override fun calcularArea(): Double{
        return Math.PI * radio * radio
    }
}

class Triangulo: Figura(){

}