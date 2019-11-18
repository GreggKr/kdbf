package me.greggkr.kdbf

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.greggkr.kdbf.command.CommandHandler
import me.greggkr.kdbf.util.Configuration
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import java.io.File

var config = mutableMapOf<String, Any>()
lateinit var jda: JDA

@Suppress("UNCHECKED_CAST")
fun startBot(configuration: Configuration) {
    val file = configuration.file
    loadConfiguration(file)
    if (config.isNotEmpty()) {
        val jdaBuilder = JDABuilder()
            .addEventListeners(CommandHandler(config["prefixes"] as List<String>))
            .setToken(config["token"] as String)

        jda = jdaBuilder.build()

        for (k in configuration.toHide) {
            config[k] = "hidden"
        }
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