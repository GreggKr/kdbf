package me.greggkr.kdbf.util

import net.dv8tion.jda.api.entities.User

fun User.prettyString(): String {
    return "${this.name}#${this.discriminator}"
}