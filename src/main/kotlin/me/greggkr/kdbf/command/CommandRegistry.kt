package me.greggkr.kdbf.command

import org.reflections.Reflections

val commands = HashSet<Command>()

fun registerCommands(vararg toRegister: Command) {
    commands.addAll(toRegister)
}

fun findCommand(trigger: String): Command? {
    return commands.find { it.triggers.contains(trigger) }
}

fun discoverCommands(pckg: String) {
    val reflections = Reflections(pckg)
    val classes = reflections.getSubTypesOf(Command::class.java)

    registerCommands(*classes.map { it.newInstance() }.toTypedArray())
}