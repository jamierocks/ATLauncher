//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Pack {

    private final int id;
    private final String slug;
    private final String name;
    private final String synopsis;
    private final String description;
    private final boolean featured;
    private final String type;
    private final Instant updated;
    private final Map<String, Art> art;
    private final List<Author> authors;
    private final List<VersionInfo> versions;
    private final List<Tag> tags;
    private final Map<String, String> links;

    public Pack(final int id, final String slug, final String name, final String synopsis,
                final String description, final boolean featured, final String type,
                final Instant updated, final Map<String, Art> art, final List<Author> authors,
                final List<VersionInfo> versions, final List<Tag> tags, final Map<String, String> links) {
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.synopsis = synopsis;
        this.description = description;
        this.featured = featured;
        this.type = type;
        this.updated = updated;
        this.art = art;
        this.authors = authors;
        this.versions = versions;
        this.tags = tags;
        this.links = links;
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

    public String getDescription() {
        return this.description;
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

    public Map<String, Art> getArt() {
        return this.art;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public List<VersionInfo> getVersions() {
        return this.versions;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public Map<String, String> getLinks() {
        return this.links;
    }

}
