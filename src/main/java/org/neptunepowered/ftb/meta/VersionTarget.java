//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

public class VersionTarget {

    private final int id;
    private final String type;
    private final String name;
    private final String version;

    public VersionTarget(final int id, final String type, final String name, final String version) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.version = version;
    }

    public int getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

}
