package dev.p2tch.arpeggio.ghosts.paper.loader;

import dev.p2tch.arpeggio.ghosts.common.annotation.RegisteredCommand;
import pl.notkris.aaapi.loader.ClassTypeLoader;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CommandLoader extends ClassTypeLoader {
    private final Set<Object> instances = new HashSet<>();

    @Override
    public Class<? extends Annotation> type() {
        return RegisteredCommand.class;
    }

    @Override
    public void process(Class<?> clazz, Object instance) {
        instances.add(instance);
    }

    public Set<Object> getInstances() {
        return Collections.unmodifiableSet(instances);
    }
}
