//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta.client;

import static me.jamiemansfield.gsonsimple.GsonRequirements.requireArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.neptunepowered.ftb.meta.Art;
import org.neptunepowered.ftb.meta.Author;
import org.neptunepowered.ftb.meta.Pack;
import org.neptunepowered.ftb.meta.PackInfo;
import org.neptunepowered.ftb.meta.Specs;
import org.neptunepowered.ftb.meta.Tag;
import org.neptunepowered.ftb.meta.Version;
import org.neptunepowered.ftb.meta.VersionFile;
import org.neptunepowered.ftb.meta.VersionInfo;
import org.neptunepowered.ftb.meta.VersionTarget;
import org.neptunepowered.ftb.meta.adapter.ArtAdapter;
import org.neptunepowered.ftb.meta.adapter.AuthorAdapter;
import org.neptunepowered.ftb.meta.adapter.PackAdapter;
import org.neptunepowered.ftb.meta.adapter.PackInfoAdapter;
import org.neptunepowered.ftb.meta.adapter.SpecsAdapter;
import org.neptunepowered.ftb.meta.adapter.TagAdapter;
import org.neptunepowered.ftb.meta.adapter.VersionAdapter;
import org.neptunepowered.ftb.meta.adapter.VersionFileAdapter;
import org.neptunepowered.ftb.meta.adapter.VersionInfoAdapter;
import org.neptunepowered.ftb.meta.adapter.VersionTargetAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FTBMetaClient {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Art.class, new ArtAdapter())
            .registerTypeAdapter(Author.class, new AuthorAdapter())
            .registerTypeAdapter(Pack.class, new PackAdapter())
            .registerTypeAdapter(PackInfo.class, new PackInfoAdapter())
            .registerTypeAdapter(Specs.class, new SpecsAdapter())
            .registerTypeAdapter(Tag.class, new TagAdapter())
            .registerTypeAdapter(Version.class, new VersionAdapter())
            .registerTypeAdapter(VersionFile.class, new VersionFileAdapter())
            .registerTypeAdapter(VersionTarget.class, new VersionTargetAdapter())
            .registerTypeAdapter(VersionInfo.class, new VersionInfoAdapter())
            .create();

    private final OkHttpClient client;
    private String apiRoot = "https://meta.ftb.neptunepowered.org";

    public FTBMetaClient() {
        this(new OkHttpClient());
    }

    public FTBMetaClient(final OkHttpClient client) {
        this.client = client;
    }

    public FTBMetaClient apiRoot(final String apiRoot) {
        this.apiRoot = apiRoot;
        return this;
    }

    public List<PackInfo> getPacks() throws IOException {
        try (final Response response = this.client.newCall(new Request.Builder()
                .addHeader("Accept", "application/json")
                .addHeader("User-Agent", "java-ftbmeta")
                .url(this.apiRoot + "/packs/")
                .build()).execute()) {
            final ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            final JsonArray root = requireArray(JsonParser.parseReader(body.charStream()), "packs");
            final List<PackInfo> packs = new ArrayList<>();
            for (final JsonElement pack : root) {
                packs.add(GSON.fromJson(pack, PackInfo.class));
            }
            return packs;
        }
    }

    public Pack getPack(final String packSlug) throws IOException {
        try (final Response response = this.client.newCall(new Request.Builder()
                .addHeader("Accept", "application/json")
                .addHeader("User-Agent", "java-ftbmeta")
                .url(this.apiRoot + "/pack/" + packSlug + "/")
                .build()).execute()) {
            final ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            return GSON.fromJson(body.charStream(), Pack.class);
        }
    }

    public Version getVersion(final String packSlug, final String versionSlug) throws IOException {
        try (final Response response = this.client.newCall(new Request.Builder()
                .addHeader("Accept", "application/json")
                .addHeader("User-Agent", "java-ftbmeta")
                .url(this.apiRoot + "/pack/" + packSlug + "/" + versionSlug + "/")
                .build()).execute()) {
            final ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            return GSON.fromJson(body.charStream(), Version.class);
        }
    }

}
