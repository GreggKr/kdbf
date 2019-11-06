package me.greggkr.kdbf

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandHandler
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import java.io.File

var config = mutableMapOf<String, Any>()
lateinit var jda: JDA

@Suppress("UNCHECKED_CAST")
fun startBot(configFile: File, commands: List<Command>) {
    loadConfiguration(configFile)
    if (config.isNotEmpty()) {
        jda = JDABuilder()
            .addEventListeners(CommandHandler(config["prefixes"] as List<String>, commands))
            .setToken(config["token"] as String)
            .build()

        config["token"] = "hidden"

        println(config["token"])
    } else {
        println("There was an issue loading the configuration file. Bot not starting.")
    }
}

private fun loadConfiguration(configFile: File) {
    config = Gson()
        .newBuilder()
        .setLenient()
        .create()
        .fromJson(configFile.readText(), object : TypeToken<Map<String, Any>>() {}.type)
}