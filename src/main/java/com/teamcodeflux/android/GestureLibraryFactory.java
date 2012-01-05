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
