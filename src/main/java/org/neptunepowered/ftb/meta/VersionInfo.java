//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

import java.time.Instant;

public class VersionInfo {

    private final int id;
    private final String slug;
    private final String name;
    private final String type;
    private final Instant updated;
    private final Specs specs;

    public VersionInfo(final int id, final String slug, final String name,
                       final String type, final Instant updated, final Specs specs) {
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.type = type;
        this.updated = updated;
        this.specs = specs;
    }

    public int getId() {
        return this.id;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getName() {
        return this.name;
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

}
