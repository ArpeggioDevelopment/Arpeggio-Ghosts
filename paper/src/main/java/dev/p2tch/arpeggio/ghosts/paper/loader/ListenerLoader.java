package dev.p2tch.arpeggio.ghosts.paper.loader;

import com.google.inject.Inject;
import dev.p2tch.arpeggio.ghosts.common.annotation.RegisteredListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.notkris.aaapi.loader.ClassTypeLoader;

import java.lang.annotation.Annotation;

public class ListenerLoader extends ClassTypeLoader {
    private final JavaPlugin javaPlugin;

    @Inject
    public ListenerLoader(final @NotNull JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    @Override
    public Class<? extends Annotation> type() {
        return RegisteredListener.class;
    }

    @Override
    public void process(final @NotNull Class<?> clazz, final @NotNull Object instance) {
        javaPlugin.getServer().getPluginManager().registerEvents(
                (Listener) instance, javaPlugin
        );
    }
}
