package me.greggkr.kdbf

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.greggkr.kdbf.command.CommandHandler
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import java.io.File

var config = mutableMapOf<String, Any>()
lateinit var jda: JDA

@Suppress("UNCHECKED_CAST")
fun startBot(configFile: File) {
    loadConfiguration(configFile)
    if (config.isNotEmpty()) {
        val jdaBuilder = JDABuilder()
            .addEventListeners(CommandHandler(config["prefixes"] as List<String>))
            .setToken(config["token"] as String)

        // Do stuff with builder

        jda = jdaBuilder.build()

        config["token"] = "hidden"
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