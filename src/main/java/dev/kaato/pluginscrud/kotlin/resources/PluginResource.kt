package dev.kaato.pluginscrud.kotlin.resources

import dev.kaato.pluginscrud.kotlin.entities.Plugin
import dev.kaato.pluginscrud.kotlin.services.PluginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.Optional

@RestController
@RequestMapping("/plugins")
//@CrossOrigin("http://localhost:3000")
class PluginResource @Autowired constructor(val service: PluginService) {

    @GetMapping
    fun getPlugins(): ResponseEntity<List<Plugin?>?> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun getPluginById(@PathVariable id: Long): ResponseEntity<Optional<Plugin?>?> {
        val plugin = service.findById(id)
        return ResponseEntity.ok().body(plugin)
    }

    @PostMapping
    fun updatePlugin(@RequestBody plugin2: Plugin): ResponseEntity<Plugin?> {
        val plugin = service.insert(plugin2)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plugin.id).toUri()
        return ResponseEntity.created(uri).body(plugin)
    }

    @DeleteMapping("/{id}")
    fun deletePlugin(@PathVariable id: Long): ResponseEntity<Plugin> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updatePlugin(@PathVariable id: Long, @RequestBody newPlugin: Plugin): ResponseEntity<Plugin> {
        val plugin = service.update(id, newPlugin)
        return ResponseEntity.ok().body(plugin)
    }
}