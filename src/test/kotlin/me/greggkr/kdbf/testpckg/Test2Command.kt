package me.greggkr.kdbf.testpckg

import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import me.greggkr.kdbf.util.getUserFromString
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData("test2")
class Test2Command : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
        val user = getUserFromString(args ?: "")
        event.channel.sendMessage(user?.effectiveAvatarUrl ?: "not found").queue()
    }
}