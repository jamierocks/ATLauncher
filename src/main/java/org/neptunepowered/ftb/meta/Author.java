//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

import java.time.Instant;

public class Author {

    private final int id;
    private final String name;
    private final String type;
    private final String website;
    private final Instant updated;

    public Author(final int id, final String name, final String type,
                  final String website, final Instant updated) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.website = website;
        this.updated = updated;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getWebsite() {
        return this.website;
    }

    public Instant getUpdated() {
        return this.updated;
    }

}
