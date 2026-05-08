package xyz.thehiddenobject.arpeggioghosts.common.configuration;

import eu.okaeri.configs.OkaeriConfig;

public class PoolConfiguration extends OkaeriConfig {
    private int maximumPoolSize = 10;

    private int minimumIdle = 2;

    private long connectionTimeout = 30000;

    private long maxLifetime = 1800000;

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public int getMinimumIdle() {
        return minimumIdle;
    }

    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    public long getMaxLifetime() {
        return maxLifetime;
    }
}