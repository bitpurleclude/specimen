package com.specimen.www.util;

public class StingUtil {
    public static String getFileExtensionFromMimeType(String mimeType) {
        String[] parts = mimeType.split("/");
        if (parts.length == 2) {
            return parts[1];
        } else {
            throw new IllegalArgumentException("Invalid MIME type: " + mimeType);
        }
    }
}
