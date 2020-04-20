//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

import java.time.Instant;
import java.util.List;

public class PackInfo {

    private final int id;
    private final String slug;
    private final String name;
    private final String synopsis;
    private final boolean featured;
    private final String type;
    private final Instant updated;
    private final Art icon;
    private final List<Tag> tags;

    public PackInfo(final int id, final String slug, final String name,
                    final String synopsis, final boolean featured, final String type,
                    final Instant updated, final Art icon, final List<Tag> tags) {
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.synopsis = synopsis;
        this.featured = featured;
        this.type = type;
        this.updated = updated;
        this.icon = icon;
        this.tags = tags;
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

    public String getSynopsis() {
        return this.synopsis;
    }

    public boolean isFeatured() {
        return this.featured;
    }

    public String getType() {
        return this.type;
    }

    public Instant getUpdated() {
        return this.updated;
    }

    public Art getIcon() {
        return this.icon;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

}
