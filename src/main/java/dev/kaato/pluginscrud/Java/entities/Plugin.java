package dev.kaato.pluginscrud.Java.entities;

import dev.kaato.pluginscrud.Java.entities.enums.Stage;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PluginModel")
public class Plugin implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private String name, description, logo, banner, video, topics;
    private int stage;

    public Plugin() {
    }

    public Plugin(String name, String description, String logo, String banner, String video, String topics, int stage) {
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.banner = banner;
        this.video = video;
        this.topics = topics;
        this.stage = stage;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Stage getStage() {
        return Stage.valueOf(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage.getId();
    }

    public String getTopics() {
        return topics;
    }

    public List<String> getTopicsFormated() {
        List<String> topicsList = Arrays.stream(topics.split("; ")).map(it -> {
            if (it.lastIndexOf(".") == it.length() - 1)
                return it;
            else return it + ";";
        }).toList();
        return topicsList;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plugin plugin = (Plugin) o;
        return Objects.equals(getId(), plugin.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}