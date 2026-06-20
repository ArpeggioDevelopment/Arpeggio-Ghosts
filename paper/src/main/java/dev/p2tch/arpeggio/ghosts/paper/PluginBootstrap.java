package dev.p2tch.arpeggio.ghosts.paper;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dev.p2tch.arpeggio.ghosts.paper.module.MiniMessageModule;
import dev.p2tch.arpeggio.ghosts.paper.module.PluginModule;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginBootstrap extends JavaPlugin {
    private PluginInitializer pluginInitializer;

    @Override
    public void onEnable() {
        final Injector injector = Guice.createInjector(
                new PluginModule(this),
                new MiniMessageModule()
        );

        pluginInitializer = injector.getInstance(PluginInitializer.class);
        pluginInitializer.init(injector);
    }

    @Override
    public void onDisable() {
        if (pluginInitializer.liteCommands != null) pluginInitializer.liteCommands.unregister();
    }
}