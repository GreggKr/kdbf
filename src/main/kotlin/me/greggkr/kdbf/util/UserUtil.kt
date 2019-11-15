package me.greggkr.kdbf.util

import me.greggkr.kdbf.jda
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User

fun User.prettyString(): String {
    return "${this.name}#${this.discriminator}"
}

// mention, name#discrim, id
fun getUserFromString(msg: Message): User? {
    val str = msg.contentRaw
    try {
        if (msg.mentionedUsers.isNotEmpty()) {
            return msg.mentionedUsers[0]
        }

        if (str.matches(Regex("\\d+"))) {
            val fromId = jda.getUserById(str)
            if (fromId != null) return fromId
        }

        val split = str.split(Regex("#"))
        if (split.size == 2) {
            val fromName = jda.getUserByTag(split[0], split[1])
            if (fromName != null) return fromName
        }
        return null
    } catch (e: Exception) {
        return null
    }
}