package dev.kaato.pluginscrud.Java.entities.enums;

import java.util.Arrays;

public enum Stage {
    IN_PLANNING(0),
    IN_DEVELOPMENT(1),
    READY(2);

    private final int id;

    Stage(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Stage valueOf(int stageId) {
        return Arrays.stream(Stage.values()).filter(it -> it.getId() == stageId).findFirst().get();
    }
}
