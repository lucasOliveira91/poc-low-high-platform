package com.example.poc.lowhighIntegratePlatform.util;

public class StringBuilderUtil {

    private StringBuilder sb = new StringBuilder();

    public void add(String content, int length) {
        buildString(content, length, ' ', false);
    }

    public void add(Number content, int length) {
        buildString(content.toString().replace(".",""), length, '0', true);
    }

    public void add(Object content, int length, char pad) {
        buildString(content.toString(), length, pad, false);
    }

    private void buildString(String content, int length, char pad, boolean antes) {

        int padding = length - content.length();

        if (padding <= 0) {
            if (padding == 0)
                sb.append(content);
            else
                sb.append(content, 0, content.length() - padding - 1);
        } else {

            if (!antes)
                sb.append(content);

            for (int i = 0; i < padding; i++) {
                sb.append(pad);
            }

            if (antes)
                sb.append(content);

        }

    }

    public String getString() {
        return sb.toString();
    }

    public void reset() {
        sb = new StringBuilder();
    }
}
