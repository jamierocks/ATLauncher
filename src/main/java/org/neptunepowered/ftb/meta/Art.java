//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

import java.time.Instant;

public class Art {

    private final String url;
    private final int width;
    private final int height;
    private final String sha1;
    private final int size;
    private final Instant updated;

    public Art(final String url, final int width, final int height,
               final String sha1, final int size, final Instant updated) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.sha1 = sha1;
        this.size = size;
        this.updated = updated;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getSha1() {
        return this.sha1;
    }

    public int getSize() {
        return this.size;
    }

    public Instant getUpdated() {
        return this.updated;
    }

}
