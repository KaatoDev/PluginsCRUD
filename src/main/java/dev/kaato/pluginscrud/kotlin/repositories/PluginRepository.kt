package dev.kaato.pluginscrud.kotlin.repositories

import dev.kaato.pluginscrud.kotlin.entities.Plugin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PluginRepository : JpaRepository<Plugin, Long>