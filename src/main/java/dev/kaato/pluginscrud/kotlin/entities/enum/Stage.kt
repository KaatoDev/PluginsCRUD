package dev.kaato.pluginscrud.kotlin.entities.enum

enum class Stage(val id: Int) {
    IN_PLANNING(0),
    IN_DEVELOPMENT(1),
    READY(2);

    companion object {
        fun valueOf(id: Int): Stage? {
            return entries.find { it.id == id }
        }
    }
}