package xyz.thehiddenobject.arpeggioghosts.common.infrastructure.persistence.ormlite.provider;

import com.j256.ormlite.support.ConnectionSource;
import xyz.thehiddenobject.arpeggioghosts.common.configuration.DatabaseConfiguration;

import java.io.File;

public interface ConnectionProvider {
    ConnectionSource create(DatabaseConfiguration config, File dataFolder);
}
