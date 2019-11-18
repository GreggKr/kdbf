package me.greggkr.kdbf

import me.greggkr.kdbf.command.discoverCommands
import me.greggkr.kdbf.util.Configuration
import java.io.File

fun main() {
    discoverCommands("me.greggkr.kdbf")
    val configuration = Configuration(
        File("src/test/resources/config.json"),
        listOf("token", "test_hidden_value")
    )
    startBot(configuration)
}