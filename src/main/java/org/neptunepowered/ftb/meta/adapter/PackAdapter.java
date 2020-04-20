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
import static me.jamiemansfield.gsonsimple.GsonRequirements.requireString;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.neptunepowered.ftb.meta.Art;
import org.neptunepowered.ftb.meta.Author;
import org.neptunepowered.ftb.meta.Pack;
import org.neptunepowered.ftb.meta.Tag;
import org.neptunepowered.ftb.meta.VersionInfo;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackAdapter implements JsonDeserializer<Pack> {

    @Override
    public Pack deserialize(final JsonElement json,
                            final Type typeOfT,
                            final JsonDeserializationContext ctx) throws JsonParseException {
        final JsonObject info = requireObject(json, "pack");

        final JsonObject artJson = getObject(info, "art");
        final Map<String, Art> art = new HashMap<>();
        for (final Map.Entry<String, JsonElement> entry : artJson.entrySet()) {
            art.put(entry.getKey(), ctx.deserialize(entry.getValue(), Art.class));
        }

        final JsonArray authorsJson = getArray(info, "authors");
        final List<Author> authors = new ArrayList<>();
        for (final JsonElement author : authorsJson) {
            authors.add(ctx.deserialize(author, Author.class));
        }

        final JsonArray versionsJson = getArray(info, "versions");
        final List<VersionInfo> versions = new ArrayList<>();
        for (final JsonElement version : versionsJson) {
            versions.add(ctx.deserialize(version, VersionInfo.class));
        }

        final JsonArray tagsJson = getArray(info, "tags");
        final List<Tag> tags = new ArrayList<>();
        for (final JsonElement tag : tagsJson) {
            tags.add(ctx.deserialize(tag, Tag.class));
        }

        final JsonObject linksJson = getObject(info, "links");
        final Map<String, String> links = new HashMap<>();
        for (final Map.Entry<String, JsonElement> entry : linksJson.entrySet()) {
            links.put(entry.getKey(), requireString(entry.getValue(), "link value"));
        }

        return new Pack(
                getInt(info, "id"),
                getString(info, "slug"),
                getString(info, "name"),
                getString(info, "synopsis"),
                getString(info, "description"),
                getBoolean(info, "featured"),
                getString(info, "type"),
                Instant.ofEpochSecond(getLong(info, "updated")),
                art,
                authors,
                versions,
                tags,
                links
        );
    }

}
