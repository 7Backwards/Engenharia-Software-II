package com.es2.bridge;

import java.util.LinkedHashMap;
import java.util.Map;

public class APIMoodle implements APIServiceInterface {

    protected java.util.LinkedHashMap<String, String> content;

    public APIMoodle() {
        content = new LinkedHashMap<>();
    }

    public String getContent(String contentId) {

        String contents = "";

        if ("0".equals(contentId)) {

            if (content.size() == 0) {

                return null;
            }
            for (Map.Entry<String, String> entry : content.entrySet()) {

                String key = entry.getKey();
                String value = entry.getValue();
                contents = contents.concat(value);
            }

            return contents;
        } else {
            for (Map.Entry<String, String> entry : content.entrySet()) {

                String key = entry.getKey();
                String value = entry.getValue();
                if (key.equals(contentId)) {

                    return value;
                }
            }
            return null;
        }
    }

    public String setContent(String content) {

        int contentID = this.content.size() + 1;
        this.content.put(String.valueOf(contentID), content);
        return String.valueOf(contentID);

    }


}
