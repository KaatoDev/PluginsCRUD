package dev.kaato.pluginscrud.Java.repositories;

import dev.kaato.pluginscrud.Java.entities.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PluginRepository extends JpaRepository<Plugin, Long> {
}
