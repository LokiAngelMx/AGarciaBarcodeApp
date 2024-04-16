package com.example.barcodeapp.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val SEPARATOR = "============="

fun newTopic(topic: String){
    println("\n $SEPARATOR $topic $SEPARATOR")
}

fun main(){
    newTopic("Corutinas")
    // globalScope()
    // println("Trabajando en el hilo principal")
//    GlobalScope.launch {
//        suspendFun()
//    }
    newTopic("Constructores")
    // cRunBlocking()
    // cLaunch()
    // cAsync()
    job()
    readln()
}

fun globalScope(){
    newTopic("GlobalScope")
    GlobalScope.launch {
        println("Mi primera corutina")
        delay(2000)
        println("Trabajando en otra cosa")
    }
}

suspend fun suspendFun(){
    newTopic("Suspend fun")
    println("Estamos recopilando datos")
    delay(5000)
    println("Terminé de recopilar datos")
}

fun cRunBlocking(){
    newTopic("RunBlocking")
    runBlocking {
        println("Iniciando consulta API")
        delay(1000)
        println("Terminó")
    }
}

fun cLaunch(){
    newTopic("Launch")
    runBlocking {
        launch {
            println("Launch")
            delay(2000)
            println("Trabajando en otra cosa")
        }
    }
}

fun cAsync(){
    newTopic("Async")
    runBlocking {
        val result = async {
            println("Consultando base de datos")
            delay(1000)
            "Datos"
        }
        println("El resultado es ${result.await()}")
    }
}

fun job(){
    newTopic("Job")
    runBlocking {
        val job = launch {
            println("Iniciando peticion API")
            delay(1000)
            println("Datos traidos")
            println("Terminando job")
        }

        delay(500)
        println("IsActive: ${job.isActive}")
        println("IsCompleted: ${job.isCompleted}")
        println("IsCancelled: ${job.isCancelled}")

        println("Tarea cancelada")
        job.cancel()

        println("IsActive: ${job.isActive}")
        println("IsCompleted: ${job.isCompleted}")
        println("IsCancelled: ${job.isCancelled}")
    }
}