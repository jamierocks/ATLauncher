//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

public class VersionFile {

    private final int id;
    private final String type;
    private final String name;
    private final String version;
    private final String path;
    private final String url;
    private final String sha1;
    private final int size;
    private final boolean clientOnly;
    private final boolean serverOnly;
    private final boolean optional;

    public VersionFile(final int id, final String type, final String name, final String version,
                       final String path, final String url, final String sha1, final int size,
                       final boolean clientOnly, final boolean serverOnly, final boolean optional) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.version = version;
        this.path = path;
        this.url = url;
        this.sha1 = sha1;
        this.size = size;
        this.clientOnly = clientOnly;
        this.serverOnly = serverOnly;
        this.optional = optional;
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

    public String getPath() {
        return this.path;
    }

    public String getUrl() {
        return this.url;
    }

    public String getSha1() {
        return this.sha1;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isClientOnly() {
        return this.clientOnly;
    }

    public boolean isServerOnly() {
        return this.serverOnly;
    }

    public boolean isOptional() {
        return this.optional;
    }

}
