package me.greggkr.kdbf.command

val commands = HashSet<Command>()

fun registerCommands(vararg toRegister: Command) {
    commands.addAll(toRegister)
}

fun findCommand(trigger: String): Command? {
    return commands.find { it.triggers.contains(trigger) }
}