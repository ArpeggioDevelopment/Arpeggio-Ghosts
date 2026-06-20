package dev.p2tch.arpeggio.ghosts.paper;

import com.google.inject.Inject;
import com.google.inject.Injector;
import dev.p2tch.arpeggio.ghosts.paper.loader.CommandLoader;
import dev.p2tch.arpeggio.ghosts.paper.loader.ListenerLoader;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.notkris.aaapi.guice.GuiceInstanceProvider;
import pl.notkris.aaapi.registry.LoaderRegistry;

class PluginInitializer {
    private final JavaPlugin javaPlugin;
    private final CommandLoader commandLoader;
    private final ListenerLoader listenerLoader;

    public LiteCommands<CommandSender> liteCommands;

    @Inject
    PluginInitializer(
            final @NotNull JavaPlugin javaPlugin,
            final @NotNull CommandLoader commandLoader,
            final @NotNull ListenerLoader listenerLoader
    ) {
        this.javaPlugin = javaPlugin;
        this.commandLoader = commandLoader;
        this.listenerLoader = listenerLoader;
    }

    public void init(final @NotNull Injector injector) {
        prepareLoaders(injector);

        registerCommands();
    }

    private void prepareLoaders(final @NotNull Injector injector) {
        final LoaderRegistry loaderRegistry = new LoaderRegistry(
                javaPlugin.getClass().getPackageName(),
                javaPlugin.getClass().getClassLoader(),
                new GuiceInstanceProvider(injector)
        );

        loaderRegistry.register(commandLoader);
        loaderRegistry.register(listenerLoader);

        loaderRegistry.loadAll();
    }

    private void registerCommands() {
        this.liteCommands = LiteBukkitFactory.builder(javaPlugin)
                .commands(
                        commandLoader.getInstances()
                )
                .build();
    }
}