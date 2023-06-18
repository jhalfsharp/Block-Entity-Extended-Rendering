package net.jimbot6000.blockentityextendedrendering.gui;

import net.fabricmc.loader.api.FabricLoader;
import net.jimbot6000.blockentityextendedrendering.BlockEntityExtendedRendering;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class BEERConfig {
    public static final String BLOCK_ENTITY_RENDER_DISTANCE_KEY = "block_entity_render_distance";

    public int BLOCK_ENTITY_RENDER_DISTANCE = 256;

    public void writeTo(Properties properties) {
        properties.setProperty(BLOCK_ENTITY_RENDER_DISTANCE_KEY, Integer.toString(BLOCK_ENTITY_RENDER_DISTANCE));
    }

    public void readFrom(Properties properties) {
        this.BLOCK_ENTITY_RENDER_DISTANCE = Integer.parseInt(properties.getProperty(BLOCK_ENTITY_RENDER_DISTANCE_KEY));
    }

    public void save() {
        Properties properties = new Properties();
        writeTo(properties);
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("block_entity_extended_rendering.properties");
        if(!Files.exists(configPath)) {
            try {
                Files.createFile(configPath);
            } catch (IOException e) {
                BlockEntityExtendedRendering.LOGGER.error("Failed to create configuration file!");
                e.printStackTrace();
                return;
            }
        }
        try {
            properties.store(Files.newOutputStream(configPath), "Configuration file for BEER");
        } catch (IOException e) {
            BlockEntityExtendedRendering.LOGGER.error("Failed to write to configuration file!");
            e.printStackTrace();
        }
    }

    public void load() {
        Properties properties = new Properties();
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("block_entity_extended_rendering.properties");
        if(!Files.exists(configPath)) {
            try {
                Files.createFile(configPath);
                save();
            } catch (IOException e) {
                BlockEntityExtendedRendering.LOGGER.error("Failed to create configuration file!");
                e.printStackTrace();
                return;
            }
        }
        try {
            properties.load(Files.newInputStream(configPath));
        } catch (IOException e) {
            BlockEntityExtendedRendering.LOGGER.error("Failed to read configuration file!");
            e.printStackTrace();
            return;
        }
        readFrom(properties);
    }
}
