package dev.p2tch.arpeggio.ghosts.paper.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class MiniMessageModule extends AbstractModule {
    @Provides
    public MiniMessage provideMiniMessage() {
        return MiniMessage.miniMessage();
    }
}