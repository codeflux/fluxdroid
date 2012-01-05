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

package com.teamcodeflux.android;

import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;

public final class GestureLibraryFactory {
    private static GestureLibrary gestureLibrary;

    private GestureLibraryFactory() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static GestureLibrary getGestureLibrary(final GestureOverlayView gestureOverlayView, final int resource) {
        if (gestureLibrary != null) {
            return gestureLibrary;
        }
        return GestureLibraries.fromRawResource(gestureOverlayView.getContext(), resource);
    }

    public static void setGestureLibrary(final GestureLibrary gestureLibrary) {
        GestureLibraryFactory.gestureLibrary = gestureLibrary;
    }
}
