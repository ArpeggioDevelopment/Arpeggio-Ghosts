package xyz.thehiddenobject.arpeggioghosts.plugin.loader;

import pl.notkris.aaapi.loader.ClassTypeLoader;
import xyz.thehiddenobject.arpeggioghosts.plugin.annotation.RegisteredCommand;

import java.lang.annotation.*;
import java.util.*;

public final class CommandLoader extends ClassTypeLoader {
    private final Set<Object> commands = new HashSet<>();

    @Override
    public Class<? extends Annotation> type() {
        return RegisteredCommand.class;
    }

    @Override
    public void process(Class<?> clazz, Object instance) {
        commands.add(instance);
    }

    public Collection<Object> getCommands() {
        return Collections.unmodifiableSet(commands);
    }
}
