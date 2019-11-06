package me.greggkr.kdbf.command

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

annotation class CommandData(
    val name: String,
    val triggers: Array<String> = [],
    val flags: Array<String> = []
)

interface Command {
    val commandData
        get() = this::class.java.annotations.find { it is CommandData } as CommandData

    val triggers: Array<String>
        get() {
            val list = commandData.triggers.toMutableList()
            list.add(commandData.name)
            return list.toTypedArray()
        }


    fun hasFlag(flag: String): Boolean {
        return commandData.flags.contains(flag)
    }

    fun execute(event: MessageReceivedEvent, args: String?)
}