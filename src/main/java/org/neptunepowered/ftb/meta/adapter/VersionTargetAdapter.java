//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta.adapter;

import static me.jamiemansfield.gsonsimple.GsonObjects.getInt;
import static me.jamiemansfield.gsonsimple.GsonObjects.getString;
import static me.jamiemansfield.gsonsimple.GsonRequirements.requireObject;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.neptunepowered.ftb.meta.VersionTarget;

import java.lang.reflect.Type;

public class VersionTargetAdapter implements JsonDeserializer<VersionTarget> {

    @Override
    public VersionTarget deserialize(final JsonElement json,
                             final Type typeOfT,
                             final JsonDeserializationContext context) throws JsonParseException {
        final JsonObject target = requireObject(json, "version target");
        return new VersionTarget(
                getInt(target, "id"),
                getString(target, "type"),
                getString(target, "name"),
                getString(target, "version")
        );
    }

}
