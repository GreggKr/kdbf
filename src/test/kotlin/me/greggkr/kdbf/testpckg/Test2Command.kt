package me.greggkr.kdbf.testpckg

import com.google.gson.GsonBuilder
import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData("test2")
class Test2Command : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
    }
}