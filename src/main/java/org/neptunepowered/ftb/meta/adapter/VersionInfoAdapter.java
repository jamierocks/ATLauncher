//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta.adapter;

import static me.jamiemansfield.gsonsimple.GsonObjects.getInt;
import static me.jamiemansfield.gsonsimple.GsonObjects.getLong;
import static me.jamiemansfield.gsonsimple.GsonObjects.getObject;
import static me.jamiemansfield.gsonsimple.GsonObjects.getString;
import static me.jamiemansfield.gsonsimple.GsonRequirements.requireObject;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.neptunepowered.ftb.meta.Specs;
import org.neptunepowered.ftb.meta.VersionInfo;

import java.lang.reflect.Type;
import java.time.Instant;

public class VersionInfoAdapter implements JsonDeserializer<VersionInfo> {

    @Override
    public VersionInfo deserialize(final JsonElement json,
                                   final Type typeOfT,
                                   final JsonDeserializationContext ctx) throws JsonParseException {
        final JsonObject version = requireObject(json, "version info");
        return new VersionInfo(
                getInt(version, "id"),
                getString(version, "slug"),
                getString(version, "name"),
                getString(version, "type"),
                Instant.ofEpochSecond(getLong(version, "updated")),
                ctx.deserialize(getObject(version, "specs"), Specs.class)
        );
    }

}
