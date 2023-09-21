package com.minecraft.rpgplugin;

import com.minecraft.rpgplugin.advancement.Advancement;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class RPGplugin extends JavaPlugin {
    private List<SubPlugin> subPlugins;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("======= Loading Main Plugin =======");

        subPlugins = new ArrayList<>();
        registerPlugin(new Advancement());

        Bukkit.getLogger().info("======= Main Plugin Enabled =======");
    }

    private void registerPlugin(SubPlugin plugin) {
        subPlugins.add(plugin);
        plugin.onEnable(this);
    }

    @Override
    public void onDisable() {
        for (SubPlugin subPlugin : subPlugins) {
            subPlugin.onDisable();
        }
        subPlugins.clear();

        Bukkit.getLogger().info("======= Main Plugin Disabled =======");
    }
}
