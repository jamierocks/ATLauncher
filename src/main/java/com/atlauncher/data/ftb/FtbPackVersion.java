package com.atlauncher.data.ftb;

import org.neptunepowered.ftb.meta.Pack;
import org.neptunepowered.ftb.meta.Version;

/**
 * A wrapper around a FTB {@link Pack pack} and
 * {@link Version version}.
 *
 * @author Jamie Mansfield
 */
public class FtbPackVersion {

    private final Pack pack;
    private final Version version;

    public FtbPackVersion(final Pack pack, final Version version) {
        this.pack = pack;
        this.version = version;
    }

    public Pack getPack() {
        return this.pack;
    }

    public Version getVersion() {
        return this.version;
    }

}
