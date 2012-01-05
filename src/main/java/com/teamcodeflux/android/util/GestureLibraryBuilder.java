package com.teamcodeflux.android.util;

import android.gesture.Gesture;
import android.gesture.GestureLibrary;

public final class GestureLibraryBuilder implements Builder<GestureLibrary>{
    private GestureLibrary gestureLibrary;

    public GestureLibraryBuilder() {
        gestureLibrary = new GestureLibrary() {
            @Override
            public boolean save() {
                return true;
            }

            @Override
            public boolean load() {
                return true;
            }
        };
    }

    public static GestureLibraryBuilder newInstance() {
        return new GestureLibraryBuilder();
    }

    public GestureLibraryBuilder addGesture(String key, Gesture gesture) {
        this.gestureLibrary.addGesture(key, gesture);

        return this;
    }

    @Override
    public GestureLibrary build() {
        return this.gestureLibrary;
    }
}
