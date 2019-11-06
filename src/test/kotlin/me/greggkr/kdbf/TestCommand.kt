package me.greggkr.kdbf

import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData(
    name = "test",
    flags = ["owner", "mod", "other_flag"]
)
class TestCommand : Command {
    override fun execute(event: MessageReceivedEvent) {
        // dump commanddata
        event.channel.sendMessage(
            "Name: ${commandData.name}, " +
                    "Triggers: [${triggers.joinToString(",")}], " +
                    "Flags: [${commandData.flags.joinToString(",")}]"
        ).queue()
    }
}