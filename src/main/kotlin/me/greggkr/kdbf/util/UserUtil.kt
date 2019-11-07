package me.greggkr.kdbf.util

import me.greggkr.kdbf.jda
import net.dv8tion.jda.api.entities.User
import java.lang.Exception
import java.util.*

fun User.prettyString(): String {
    return "${this.name}#${this.discriminator}"
}

// name#discrim, id
fun getUserFromString(str: String): User? {
    try {
        if (str.matches(Regex("\\d+"))) {
            val fromId = jda.getUserById(str)
            println(fromId)
            if (fromId != null) return fromId
        }
        println("test")

        val split = str.split(Regex("#"))
        println(Arrays.toString(split.toTypedArray()))
        if (split.size == 2) {
            val fromName = jda.getUserByTag(split[0], split[1])
            if (fromName != null) return fromName
        }
        return null
    } catch (e: Exception) {
        return null
    }
}