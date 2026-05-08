package xyz.thehiddenobject.arpeggioghosts.common.configuration;

import eu.okaeri.configs.OkaeriConfig;
import xyz.thehiddenobject.arpeggioghosts.common.infrastructure.persistence.ormlite.DatabaseType;

import java.util.HashMap;
import java.util.Map;

public class DatabaseConfiguration extends OkaeriConfig {
    private DatabaseType type = DatabaseType.H2;

    private NetworkDatabaseConfiguration network = new NetworkDatabaseConfiguration();

    private H2Configuration h2 = new H2Configuration();

    private PoolConfiguration pool = new PoolConfiguration();

    private Map<String, String> jdbcProperties = new HashMap<>();

    public DatabaseType getType() {
        return type;
    }

    public NetworkDatabaseConfiguration getNetwork() {
        return network;
    }

    public H2Configuration getH2() {
        return h2;
    }

    public PoolConfiguration getPool() {
        return pool;
    }

    public Map<String, String> getJdbcProperties() {
        return jdbcProperties;
    }
}