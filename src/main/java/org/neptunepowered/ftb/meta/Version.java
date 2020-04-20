//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

import java.time.Instant;
import java.util.List;

public class Version {

    private final int id;
    private final int parent;
    private final String slug;
    private final String name;
    private final String changelog;
    private final String type;
    private final Instant updated;
    private final Specs specs;
    private final List<VersionTarget> targets;
    private final List<VersionFile> files;

    public Version(final int id, final int parent, final String slug, final String name,
                   final String changelog, final String type, final Instant updated,
                   final Specs specs, final List<VersionTarget> targets, final List<VersionFile> files) {
        this.id = id;
        this.parent = parent;
        this.slug = slug;
        this.name = name;
        this.changelog = changelog;
        this.type = type;
        this.updated = updated;
        this.specs = specs;
        this.targets = targets;
        this.files = files;
    }

    public int getId() {
        return this.id;
    }

    public int getParent() {
        return this.parent;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getName() {
        return this.name;
    }

    public String getChangelog() {
        return this.changelog;
    }

    public String getType() {
        return this.type;
    }

    public Instant getUpdated() {
        return this.updated;
    }

    public Specs getSpecs() {
        return this.specs;
    }

    public List<VersionTarget> getTargets() {
        return this.targets;
    }

    public List<VersionFile> getFiles() {
        return this.files;
    }

}
