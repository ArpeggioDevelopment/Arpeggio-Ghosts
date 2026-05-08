package xyz.thehiddenobject.arpeggioghosts.common.infrastructure.persistence.ormlite;

import com.j256.ormlite.support.ConnectionSource;
import org.jetbrains.annotations.NotNull;
import xyz.thehiddenobject.arpeggioghosts.common.configuration.DatabaseConfiguration;
import xyz.thehiddenobject.arpeggioghosts.common.infrastructure.persistence.ormlite.provider.ConnectionProvider;
import xyz.thehiddenobject.arpeggioghosts.common.infrastructure.persistence.ormlite.provider.impl.H2ConnectionProvider;

import java.io.File;
import java.util.Map;

class ConnectionFactory {
    private final File dataFolder;
    private final Map<DatabaseType, ConnectionProvider> providers;

    ConnectionFactory(final @NotNull File dataFolder) {
        this.dataFolder = dataFolder;

        this.providers = Map.of(
                DatabaseType.H2, new H2ConnectionProvider()
        );
    }

    ConnectionSource prepareConnectionSource(final @NotNull DatabaseConfiguration config) {
        final ConnectionProvider provider = providers.get(config.getType());

        if (provider == null) {
            throw new IllegalStateException("No provider for type: " + config.getType());
        }

        return provider.create(config, dataFolder);
    }
}
