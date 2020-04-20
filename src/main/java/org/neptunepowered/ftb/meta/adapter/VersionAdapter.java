//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta.adapter;

import static me.jamiemansfield.gsonsimple.GsonObjects.get;
import static me.jamiemansfield.gsonsimple.GsonObjects.getArray;
import static me.jamiemansfield.gsonsimple.GsonObjects.getInt;
import static me.jamiemansfield.gsonsimple.GsonObjects.getLong;
import static me.jamiemansfield.gsonsimple.GsonObjects.getString;
import static me.jamiemansfield.gsonsimple.GsonRequirements.requireObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.neptunepowered.ftb.meta.Specs;
import org.neptunepowered.ftb.meta.Version;
import org.neptunepowered.ftb.meta.VersionFile;
import org.neptunepowered.ftb.meta.VersionTarget;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class VersionAdapter implements JsonDeserializer<Version> {

    @Override
    public Version deserialize(final JsonElement json,
                               final Type typeOfT,
                               final JsonDeserializationContext ctx) throws JsonParseException {
        final JsonObject version = requireObject(json, "version");

        final JsonArray targetsJson = getArray(version, "targets");
        final List<VersionTarget> targets = new ArrayList<>();
        for (final JsonElement targetJson : targetsJson) {
            targets.add(ctx.deserialize(targetJson, VersionTarget.class));
        }

        final JsonArray filesJson = getArray(version, "files");
        final List<VersionFile> files = new ArrayList<>();
        for (final JsonElement fileJson : filesJson) {
            files.add(ctx.deserialize(fileJson, VersionFile.class));
        }

        return new Version(
                getInt(version, "id"),
                getInt(version, "parent"),
                getString(version, "slug"),
                getString(version, "name"),
                getString(version, "changelog"),
                getString(version, "type"),
                Instant.ofEpochSecond(getLong(version, "updated")),
                ctx.deserialize(get(version, "specs"), Specs.class),
                targets,
                files
        );
    }

}
