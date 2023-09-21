package com.minecraft.rpgplugin;

import org.bukkit.plugin.java.JavaPlugin;

public interface SubPlugin {
    void onEnable(JavaPlugin plugin);
    void onDisable();
}
