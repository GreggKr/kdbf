package me.greggkr.kdbf.command

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class CommandHandler(private val prefixes: List<String>, commands: List<Command>) : ListenerAdapter() {
    init {
        registerCommands(*commands.toTypedArray())
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val text = event.message.contentStripped
        val prefix = prefixes.find { text.startsWith(it, true) } ?: return

        if (prefix.isEmpty()) return

        val body = text.substringAfter(prefix)
        val args = body.split(Regex("\\s+"), 2)

        val command = findCommand(body.split(Regex("\\s+"))[0])

        command?.execute(event, if (args.size > 1) args[1] else null)
    }
}