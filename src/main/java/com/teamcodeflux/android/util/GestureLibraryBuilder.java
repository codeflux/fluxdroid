package com.teamcodeflux.android.util;

import android.gesture.Gesture;
import android.gesture.GestureLibrary;

import java.util.HashMap;
import java.util.Map;

public final class GestureLibraryBuilder implements Builder<GestureLibrary>{
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
