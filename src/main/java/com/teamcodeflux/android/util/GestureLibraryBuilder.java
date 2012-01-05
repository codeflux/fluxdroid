/*
 * Copyright 2011 CodeFlux, Inc <info@teamcodeflux.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teamcodeflux.android.util;

import android.gesture.Gesture;
import android.gesture.GestureLibrary;

import java.util.HashMap;
import java.util.Map;

public final class GestureLibraryBuilder implements Builder<GestureLibrary> {
    private Map<String, Gesture> gestureMap;

    private GestureLibraryBuilder() {
        gestureMap = new HashMap<String, Gesture>();
    }

    public static GestureLibraryBuilder newInstance() {
        return new GestureLibraryBuilder();
    }

    public GestureLibraryBuilder addGesture(String key, Gesture gesture) {
        this.gestureMap.put(key, gesture);

        return this;
    }

    @Override
    public GestureLibrary build() {
        GestureLibrary gestureLibrary = new GestureLibrary() {
            @Override
            public boolean save() {
                return true;
            }

            @Override
            public boolean load() {
                return true;
            }
        };

        for (String key : gestureMap.keySet()) {
            gestureLibrary.addGesture(key, gestureMap.get(key));
        }

        return gestureLibrary;
    }
}
