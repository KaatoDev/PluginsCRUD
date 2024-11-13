package dev.kaato.pluginscrud.Java.services;

import dev.kaato.pluginscrud.Java.entities.Plugin;
import dev.kaato.pluginscrud.Java.repositories.PluginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PluginService {
    @Autowired
    private PluginRepository repo;

    public List<Plugin> findAll() {
        return repo.findAll();
    }

    public Plugin findById(long id) {
        Optional<Plugin> obj = repo.findById(id);
        return obj.get();
    }

    public Plugin insert(Plugin plugin) {
        return repo.save(plugin);
    }

    public void delete(long id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Plugin update(long id, Plugin newPlugin) {
        try {
            Plugin plugin = repo.getReferenceById(id);
            updateData(plugin, newPlugin);
            return repo.save(plugin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateData(Plugin plugin, Plugin newPlugin) {
        plugin.setName(newPlugin.getName());
        plugin.setDescription(newPlugin.getDescription());
        plugin.setBanner(newPlugin.getBanner());
        plugin.setLogo(newPlugin.getLogo());
        plugin.setVideo(newPlugin.getVideo());
        plugin.setTopics(newPlugin.getTopics());
        plugin.setStage(newPlugin.getStage());
    }
}
