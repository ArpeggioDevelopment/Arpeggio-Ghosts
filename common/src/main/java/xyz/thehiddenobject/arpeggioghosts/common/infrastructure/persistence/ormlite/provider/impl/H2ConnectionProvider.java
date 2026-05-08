package xyz.thehiddenobject.arpeggioghosts.common.infrastructure.persistence.ormlite.provider.impl;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.jetbrains.annotations.NotNull;
import xyz.thehiddenobject.arpeggioghosts.common.configuration.DatabaseConfiguration;
import xyz.thehiddenobject.arpeggioghosts.common.configuration.H2Configuration;
import xyz.thehiddenobject.arpeggioghosts.common.infrastructure.persistence.ormlite.provider.ConnectionProvider;

import java.io.File;
import java.sql.SQLException;

public class H2ConnectionProvider implements ConnectionProvider {
    @Override
    public ConnectionSource create(final @NotNull DatabaseConfiguration config, final @NotNull File dataFolder) {
        final H2Configuration h2 = config.getH2();

        final File dbFile = new File(dataFolder, h2.getFile());

        try {
            return new JdbcConnectionSource(dbFile.getAbsolutePath());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}