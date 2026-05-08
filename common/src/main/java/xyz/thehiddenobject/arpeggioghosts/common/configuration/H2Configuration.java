package xyz.thehiddenobject.arpeggioghosts.common.configuration;

import eu.okaeri.configs.OkaeriConfig;

public class H2Configuration extends OkaeriConfig {
    private String file = "database.db";

    public String getFile() {
        return file;
    }
}