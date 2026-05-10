package xyz.thehiddenobject.arpeggioghosts.plugin.bootstrap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import pl.notkris.aaapi.guice.GuiceInstanceProvider;
import pl.notkris.aaapi.registry.LoaderRegistry;
import xyz.thehiddenobject.arpeggioghosts.common.module.ConfigurationModule;
import xyz.thehiddenobject.arpeggioghosts.plugin.loader.CommandLoader;

public class PluginBootstrap extends JavaPlugin {
    private static final String BASE_PACKAGE = "xyz.thehiddenobject.arpeggioghosts.plugin";
    private LiteCommands<CommandSender> liteCommands;
    private Injector injector;

    @Override
    public void onEnable() {
        injector = Guice.createInjector(
                new ConfigurationModule(getDataFolder())
        );

        initializeCommands();
    }

    @Override
    public void onDisable() {
        if (liteCommands != null) liteCommands.unregister();
    }

    private void initializeCommands() {
        final LoaderRegistry loaderRegistry = new LoaderRegistry(
                BASE_PACKAGE,
                getClassLoader(),
                new GuiceInstanceProvider(injector)
        );

        final CommandLoader commandLoader = new CommandLoader();

        loaderRegistry.register(commandLoader);
        loaderRegistry.loadAll();

        liteCommands = LiteBukkitFactory.builder(this)
                .commands(
                        commandLoader.getCommands()
                ).build();
    }
}
