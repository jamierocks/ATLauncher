//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta.adapter;

import static me.jamiemansfield.gsonsimple.GsonObjects.getBoolean;
import static me.jamiemansfield.gsonsimple.GsonObjects.getInt;
import static me.jamiemansfield.gsonsimple.GsonObjects.getString;
import static me.jamiemansfield.gsonsimple.GsonRequirements.requireObject;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.neptunepowered.ftb.meta.VersionFile;

import java.lang.reflect.Type;

public class VersionFileAdapter implements JsonDeserializer<VersionFile> {

    @Override
    public VersionFile deserialize(final JsonElement json,
                                   final Type typeOfT,
                                   final JsonDeserializationContext context) throws JsonParseException {
        final JsonObject file = requireObject(json, "version file");
        return new VersionFile(
                getInt(file, "id"),
                getString(file, "type"),
                getString(file, "name"),
                getString(file, "version"),
                getString(file, "path"),
                getString(file, "url"),
                getString(file, "sha1"),
                getInt(file, "size"),
                getBoolean(file, "clientonly"),
                getBoolean(file, "serveronly"),
                getBoolean(file, "optional")
        );
    }

}
