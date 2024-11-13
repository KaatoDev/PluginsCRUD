package dev.kaato.pluginscrud.Java.resources;

import dev.kaato.pluginscrud.Java.entities.Plugin;
import dev.kaato.pluginscrud.Java.services.PluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/plugins")
//@CrossOrigin(origins = "http://localhost:3000")
public class PluginResource {
    @Autowired
    private PluginService service = new PluginService();

    @GetMapping
    public ResponseEntity<List<Plugin>> getPlugins() {
        List<Plugin> plugins = service.findAll();
        return ResponseEntity.ok().body(plugins);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Plugin> getPluginById(@PathVariable long id) {
        Plugin plugin = service.findById(id);
        return ResponseEntity.ok().body(plugin);
    }

    @PostMapping
    public ResponseEntity<Plugin> insert(@RequestBody Plugin plugin2) {
        Plugin plugin = service.insert(plugin2);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plugin.getId()).toUri();
        return ResponseEntity.created(uri).body(plugin);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Plugin> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Plugin> update(@PathVariable long id, @RequestBody Plugin plugin) {
        plugin = service.update(id, plugin);
        return ResponseEntity.ok().body(plugin);
    }
}