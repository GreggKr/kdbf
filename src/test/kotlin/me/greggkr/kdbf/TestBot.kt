package me.greggkr.kdbf

import java.io.File

fun main() {
    val file = File("src/test/resources/config.json")
    startBot(file, listOf(TestCommand()))
}