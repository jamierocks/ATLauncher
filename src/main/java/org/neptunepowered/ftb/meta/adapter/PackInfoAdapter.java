//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta.adapter;

import static me.jamiemansfield.gsonsimple.GsonObjects.getArray;
import static me.jamiemansfield.gsonsimple.GsonObjects.getBoolean;
import static me.jamiemansfield.gsonsimple.GsonObjects.getInt;
import static me.jamiemansfield.gsonsimple.GsonObjects.getLong;
import static me.jamiemansfield.gsonsimple.GsonObjects.getObject;
import static me.jamiemansfield.gsonsimple.GsonObjects.getString;
import static me.jamiemansfield.gsonsimple.GsonRequirements.requireObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.neptunepowered.ftb.meta.Art;
import org.neptunepowered.ftb.meta.PackInfo;
import org.neptunepowered.ftb.meta.Tag;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PackInfoAdapter implements JsonDeserializer<PackInfo> {

    @Override
    public PackInfo deserialize(final JsonElement json,
                                final Type typeOfT,
                                final JsonDeserializationContext ctx) throws JsonParseException {
        final JsonObject info = requireObject(json, "pack info");

        final JsonArray tagsJson = getArray(info, "tags");
        final List<Tag> tags = new ArrayList<>();
        for (final JsonElement tag : tagsJson) {
            tags.add(ctx.deserialize(tag, Tag.class));
        }

        return new PackInfo(
                getInt(info, "id"),
                getString(info, "slug"),
                getString(info, "name"),
                getString(info, "synopsis"),
                getBoolean(info, "featured"),
                getString(info, "type"),
                Instant.ofEpochSecond(getLong(info, "updated")),
                ctx.deserialize(getObject(info, "icon"), Art.class),
                tags
        );
    }

}
