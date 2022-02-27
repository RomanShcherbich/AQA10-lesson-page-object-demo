package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;

public class JsonUtils {

    private static String getEntryRaw(String key, String value) {
        String wrappedKey = StringUtils.wrap(key,"\"");
        String wrappedValue = StringUtils.wrap(value,"\"");
        return StringUtils.joinWith(":", wrappedKey, wrappedValue);
    }

    public static String load(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder jsonBuilder = new StringBuilder("{");
        Iterator mapIter = map.entrySet().iterator();
        while (mapIter.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) mapIter.next();
            if (entry.getValue() instanceof String) {
                jsonBuilder.append(getEntryRaw(entry.getKey(), String.valueOf(entry.getValue())));
            } else if (entry.getValue() instanceof Map) {
                jsonBuilder.append(load((Map<String, Object>) entry.getValue()));
            }
            if (mapIter.hasNext()) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    public static String load(String key, String value) {
        StringBuilder jsonBuilder = new StringBuilder("{");
        jsonBuilder.append(getEntryRaw(key, value));
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

}
