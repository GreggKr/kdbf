package me.greggkr.kdbf.util

enum class Emoji(val unicode: String) {
    X("\u274C"),
    WHITE_CHECK_MARK("\u2705"),
    THUMBS_UP("\uD83D\uDC4D");

    override fun toString() = unicode
}