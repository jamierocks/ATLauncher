//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta.adapter;

import static me.jamiemansfield.gsonsimple.GsonObjects.getInt;
import static me.jamiemansfield.gsonsimple.GsonObjects.getLong;
import static me.jamiemansfield.gsonsimple.GsonObjects.getString;
import static me.jamiemansfield.gsonsimple.GsonRequirements.requireObject;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.neptunepowered.ftb.meta.Author;

import java.lang.reflect.Type;
import java.time.Instant;

public class AuthorAdapter implements JsonDeserializer<Author> {

    @Override
    public Author deserialize(final JsonElement json,
                              final Type typeOfT,
                              final JsonDeserializationContext ctx) throws JsonParseException {
        final JsonObject author = requireObject(json, "author");
        return new Author(
                getInt(author, "id"),
                getString(author, "name"),
                getString(author, "type"),
                getString(author, "website"),
                Instant.ofEpochSecond(getLong(author, "updated"))
        );
    }

}
