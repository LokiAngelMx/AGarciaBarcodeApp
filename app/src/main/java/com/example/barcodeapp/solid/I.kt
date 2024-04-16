package com.example.barcodeapp.solid

interface IAnimal {
    fun comer()
}

interface IAnimalAndador{
    fun caminar()
}

interface IAnimalVolador{
    fun volar()
}

interface IAnimalNadador{
    fun nadar()
}

class Perro: IAnimal, IAnimalAndador, IAnimalNadador{
    override fun comer() {
        TODO("Not yet implemented")
    }

    override fun caminar() {
        TODO("Not yet implemented")
    }

    override fun nadar() {
        TODO("Not yet implemented")
    }

}