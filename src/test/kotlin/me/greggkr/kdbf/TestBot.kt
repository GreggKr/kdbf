package me.greggkr.kdbf

import me.greggkr.kdbf.command.discoverCommands
import java.io.File

fun main() {
    discoverCommands("me.greggkr.kdbf")
    val file = File("src/test/resources/config.json")
    startBot(file)
}