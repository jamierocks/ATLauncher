/*
 * ATLauncher - https://github.com/ATLauncher/ATLauncher
 * Copyright (C) 2013-2019 ATLauncher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.atlauncher.utils;

import com.atlauncher.exceptions.FaultyFtbVersion;
import org.neptunepowered.ftb.meta.Version;
import org.neptunepowered.ftb.meta.VersionTarget;

/**
 * Utilities for working with modpacks from Feed The Beast.
 * <p>
 * Since CreeperHost's API doesn't expose a list of packs, we use
 * The Neptune FTB Meta Service to get pack information.
 *
 * @author Jamie Mansfield
 */
public final class FtbPackUtils {

    public static String getMinecraftVersion(final Version version) throws FaultyFtbVersion {
        for (final VersionTarget target : version.getTargets()) {
            if ("game".equals(target.getType())) {
                return target.getVersion();
            }
        }

        throw new FaultyFtbVersion(version.getName() + " has no Minecraft version!");
    }

    private FtbPackUtils() {
    }

}
