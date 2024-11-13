package dev.kaato.pluginscrud.kotlin.services

import dev.kaato.pluginscrud.kotlin.entities.Plugin
import dev.kaato.pluginscrud.kotlin.repositories.PluginRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class PluginService @Autowired constructor(val repo: PluginRepository) {
    fun findAll(): List<Plugin?> {
        return repo.findAll()
    }

    fun findById(id: Long): Optional<Plugin?> {
        return repo.findById(id)
    }

    fun insert(plugin: Plugin): Plugin {
        return repo.save(plugin)
    }

    fun delete(id: Long) {
        try {
            return repo.deleteById(id)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun update(id: Long, newPlugin: Plugin): Plugin {
        try {
            val plugin = repo.getReferenceById(id)
            updateData(plugin, newPlugin)
            return repo.save(plugin)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun updateData(plugin: Plugin, newPlugin: Plugin) {
        plugin.name = newPlugin.name
        plugin.description = newPlugin.description
        plugin.topics = newPlugin.topics
        plugin.banner = newPlugin.banner
        plugin.logo = newPlugin.logo
        plugin.video = newPlugin.video
        plugin.setStage(newPlugin.getStage())
    }
}