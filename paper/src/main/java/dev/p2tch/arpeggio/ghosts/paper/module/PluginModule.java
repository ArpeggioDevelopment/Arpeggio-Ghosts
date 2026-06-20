package dev.p2tch.arpeggio.ghosts.paper.module;

import com.google.inject.AbstractModule;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class PluginModule extends AbstractModule {
    private final JavaPlugin javaPlugin;

    public PluginModule(final @NotNull JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    @Override
    protected void configure() {
        bind(JavaPlugin.class).toInstance(javaPlugin);
    }
}