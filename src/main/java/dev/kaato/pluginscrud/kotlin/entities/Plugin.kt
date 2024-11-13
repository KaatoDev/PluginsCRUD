package dev.kaato.pluginscrud.kotlin.entities

import dev.kaato.pluginscrud.kotlin.entities.enum.Stage
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "PluginModel")
class Plugin() : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    lateinit var name: String
    lateinit var description: String
    lateinit var logo: String
    lateinit var banner: String
    lateinit var video: String
    lateinit var topics: String
    private lateinit var stage: Integer

    constructor(name: String, description: String, logo: String, banner: String, video: String, topics: String, stage: Int = 0) : this() {
        this.name = name
        this.description = description
        this.logo = logo
        this.banner = banner
        this.video = video
        this.topics = topics
        this.stage = stage as Integer
    }

    fun getStage(): Stage {
        return Stage.valueOf(stage as Int) ?: Stage.IN_PLANNING
    }

    fun setStage(stage: Stage) {
        this.stage = stage.id as Integer
    }

    fun getTopicsFormated(): List<String> {
        return topics.split("; ").map { "$it${if (it.last() != '.') ";" else ""}" }
    }
}