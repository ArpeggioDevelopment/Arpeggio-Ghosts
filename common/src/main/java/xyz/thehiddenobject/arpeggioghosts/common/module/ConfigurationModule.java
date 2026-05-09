package xyz.thehiddenobject.arpeggioghosts.common.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import org.jetbrains.annotations.NotNull;
import xyz.thehiddenobject.arpeggioghosts.common.configuration.DatabaseConfiguration;

import java.io.File;

public class ConfigurationModule extends AbstractModule {
    private final File dataFolder;

    public ConfigurationModule(final @NotNull File dataFolder) {
        this.dataFolder = dataFolder;
    }

    @Override
    protected void configure() {
        bind(DatabaseConfiguration.class).toInstance(
                createConfiguration(DatabaseConfiguration.class, "database.yml")
        );
    }

    <T extends OkaeriConfig> T createConfiguration(
            final @NotNull Class<T> clazz,
            final @NotNull String fileName
    ) {
        return ConfigManager.create(clazz, it -> {
           it.configure(opt -> {
               opt.configurer(new YamlSnakeYamlConfigurer());
               opt.bindFile(
                       new File(dataFolder, fileName)
               );
           });

           it.saveDefaults();
           it.load(true);
        });
    }
}
