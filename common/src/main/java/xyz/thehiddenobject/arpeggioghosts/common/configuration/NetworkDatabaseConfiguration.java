package xyz.thehiddenobject.arpeggioghosts.common.configuration;

import eu.okaeri.configs.OkaeriConfig;

public class NetworkDatabaseConfiguration extends OkaeriConfig {
    private String host = "localhost";

    private int port = 3306;

    private String database = "arpeggio-ghosts";

    private String username = "root";

    private String password = "password";

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}