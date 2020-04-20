//******************************************************************************
// Copyright (c) Jamie Mansfield <https://jamiemansfield.me/>
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//******************************************************************************

package org.neptunepowered.ftb.meta;

public class Specs {

    private final int minimum;
    private final int recommended;

    public Specs(final int minimum, final int recommended) {
        this.minimum = minimum;
        this.recommended = recommended;
    }

    public int getMinimum() {
        return this.minimum;
    }

    public int getRecommended() {
        return this.recommended;
    }

}
