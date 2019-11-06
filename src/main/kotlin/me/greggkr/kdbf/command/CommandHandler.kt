package me.greggkr.kdbf.command

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

val commands = HashSet<Command>()

fun registerCommands(vararg toRegister: Command) {
    commands.addAll(toRegister)
}

fun findCommand(trigger: String): Command? {
    return commands.find { it.triggers.contains(trigger) }
}

class CommandHandler(private val prefixes: List<String>, commands: List<Command>) : ListenerAdapter() {
    init {
        registerCommands(*commands.toTypedArray())
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val text = event.message.contentStripped
        val prefix = prefixes.find { text.startsWith(it, true) } ?: return

        if (prefix.isEmpty()) return

        val body = text.substringAfter(prefix)
        val command = findCommand(body.split(Regex("\\s+"))[0])

        command?.execute(event)
    }
}