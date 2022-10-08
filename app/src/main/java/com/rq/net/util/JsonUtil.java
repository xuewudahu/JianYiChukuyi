package com.rq.net.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rq.net.bean.PinDuoDuoBaseResponseBean;

import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    private static Gson gson;
    private static Gson gsonField;
    private static Gson gsonNull;

    public JsonUtil() {
    }

    private static void addIndentBlank(StringBuilder var0, int var1) {
        for(int var2 = 0; var2 < var1; ++var2) {
            var0.append('\t');
        }

    }

    public static String decodeUnicode(String var0) {
        int var6 = var0.length();
        StringBuffer var8 = new StringBuffer(var6);
        int var3 = 0;

        while(true) {
            while(true) {
                while(var3 < var6) {
                    int var4 = var3 + 1;
                    char var1 = var0.charAt(var3);
                    if (var1 == '\\') {
                        var3 = var4 + 1;
                        char var2 = var0.charAt(var4);
                        if (var2 == 'u') {
                            var4 = var3;
                            int var5 = 0;

                            for(var3 = 0; var5 < 4; ++var4) {
                                char var7 = var0.charAt(var4);
                                switch(var7) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        var3 = (var3 << 4) + var7 - 48;
                                        break;
                                    default:
                                        switch(var7) {
                                            case 'A':
                                            case 'B':
                                            case 'C':
                                            case 'D':
                                            case 'E':
                                            case 'F':
                                                var3 = (var3 << 4) + 10 + var7 - 65;
                                                break;
                                            default:
                                                switch(var7) {
                                                    case 'a':
                                                    case 'b':
                                                    case 'c':
                                                    case 'd':
                                                    case 'e':
                                                    case 'f':
                                                        var3 = (var3 << 4) + 10 + var7 - 97;
                                                        break;
                                                    default:
                                                        throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                                }
                                        }
                                }

                                ++var5;
                            }

                            var8.append((char)var3);
                            var3 = var4;
                        } else {
                            if (var2 == 't') {
                                var1 = '\t';
                            } else if (var2 == 'r') {
                                var1 = '\r';
                            } else if (var2 == 'n') {
                                var1 = '\n';
                            } else {
                                var1 = var2;
                                if (var2 == 'f') {
                                    var1 = '\f';
                                }
                            }

                            var8.append(var1);
                        }
                    } else {
                        var8.append(var1);
                        var3 = var4;
                    }
                }

                return var8.toString();
            }
        }
    }

    public static String formatJson(String var0) {
        if (var0 == null) {
            return "";
        } else if ("".equals(var0)) {
            return "";
        } else {
            StringBuilder var6 = new StringBuilder();
            int var3 = 0;
            char var5 = 0;

            int var2;
            for(int var4 = 0; var3 < var0.length(); var4 = var2) {
                char var1 = var0.charAt(var3);
                if (var1 == ',') {
                    var6.append(var1);
                    var2 = var4;
                    if (var5 != '\\') {
                        var6.append('\n');
                        addIndentBlank(var6, var4);
                        var2 = var4;
                    }
                } else {
                    label48: {
                        label38: {
                            if (var1 != '[') {
                                if (var1 == ']') {
                                    break label38;
                                }

                                if (var1 != '{') {
                                    if (var1 != '}') {
                                        var6.append(var1);
                                        var2 = var4;
                                        break label48;
                                    }
                                    break label38;
                                }
                            }

                            var6.append(var1);
                            var6.append('\n');
                            var2 = var4 + 1;
                            addIndentBlank(var6, var2);
                            break label48;
                        }

                        var6.append('\n');
                        var2 = var4 - 1;
                        addIndentBlank(var6, var2);
                        var6.append(var1);
                    }
                }

                ++var3;
                var5 = var1;
            }

            return var6.toString();
        }
    }

    public static <T> Object getClazzByGson(String var0, Class<T> var1) {
        if (var0 != null) {
            if ("".equals(var0)) {
                return null;
            } else if (var0.startsWith("[")) {
                ArrayList var3 = new ArrayList();

                JSONException var10000;
                label46: {
                    boolean var10001;
                    JSONArray var6;
                    try {
                        var6 = new JSONArray(var0);
                    } catch (JSONException var5) {
                        var10000 = var5;
                        var10001 = false;
                        break label46;
                    }

                    int var2 = 0;

                    while(true) {
                        try {
                            if (var2 >= var6.length()) {
                                return var3;
                            }

                            var3.add(getClazzByGson(var6.get(var2).toString(), var1));
                        } catch (JSONException var4) {
                            var10000 = var4;
                            var10001 = false;
                            break;
                        }

                        ++var2;
                    }
                }

                JSONException var7 = var10000;
                var7.printStackTrace();
                return null;
            } else {
                return getGsonInstance().fromJson(var0, var1);
            }
        } else {
            return null;
        }
    }

    public static <T> T getClazzByGson(String var0, Type var1) {
        return var0 != null && !"".equals(var0) ? getGsonInstance().fromJson(var0, var1) : null;
    }

    private static Gson getGsonExcludeFieldInstance() {
        if (gsonField == null) {
            synchronized(JsonUtil.class){}

            Throwable var10000;
            boolean var10001;
            label144: {
                try {
                    if (gsonField == null) {
                        GsonBuilder var0 = new GsonBuilder();
                        var0.excludeFieldsWithoutExposeAnnotation();
                        var0.setDateFormat("yyyy-MM-dd HH:mm:ss");
                        gsonField = var0.create();
                    }
                } catch (Throwable var12) {
                    var10000 = var12;
                    var10001 = false;
                    break label144;
                }

                label141:
                try {
                    return gsonField;
                } catch (Throwable var11) {
                    var10000 = var11;
                    var10001 = false;
                    break label141;
                }
            }

            while(true) {
                Throwable var13 = var10000;

                try {
                    throw var13;
                } catch (Throwable var10) {
                    var10000 = var10;
                    var10001 = false;
                    continue;
                }
            }
        } else {
            return gsonField;
        }
    }

    private static Gson getGsonInstance() {
        if (gson == null) {
            synchronized(JsonUtil.class){}

            Throwable var10000;
            boolean var10001;
            label144: {
                try {
                    if (gson == null) {
                        GsonBuilder var0 = new GsonBuilder();
                        var0.setDateFormat("yyyy-MM-dd HH:mm:ss");
                        gson = var0.create();
                    }
                } catch (Throwable var12) {
                    var10000 = var12;
                    var10001 = false;
                    break label144;
                }

                label141:
                try {
                    return gson;
                } catch (Throwable var11) {
                    var10000 = var11;
                    var10001 = false;
                    break label141;
                }
            }

            while(true) {
                Throwable var13 = var10000;

                try {
                    throw var13;
                } catch (Throwable var10) {
                    var10000 = var10;
                    var10001 = false;
                    continue;
                }
            }
        } else {
            return gson;
        }
    }

    private static Gson getGsonNullInstance() {
        if (gsonNull == null) {
            synchronized(JsonUtil.class){}

            Throwable var10000;
            boolean var10001;
            label144: {
                try {
                    if (gsonNull == null) {
                        GsonBuilder var0 = new GsonBuilder();
                        var0.serializeNulls();
                        var0.setDateFormat("yyyy-MM-dd HH:mm:ss");
                        gsonNull = var0.create();
                    }
                } catch (Throwable var12) {
                    var10000 = var12;
                    var10001 = false;
                    break label144;
                }

                label141:
                try {
                    return gsonNull;
                } catch (Throwable var11) {
                    var10000 = var11;
                    var10001 = false;
                    break label141;
                }
            }

            while(true) {
                Throwable var13 = var10000;

                try {
                    throw var13;
                } catch (Throwable var10) {
                    var10000 = var10;
                    var10001 = false;
                    continue;
                }
            }
        } else {
            return gsonNull;
        }
    }

    public static String getJsonExcludeFieldStringByGson(Object var0) {
        return getGsonExcludeFieldInstance().toJson(var0);
    }

    public static String getJsonStringByGson(Object var0) {
        return getGsonInstance().toJson(var0);
    }

    public static String getJsonStringNull(Object var0) {
        return getGsonNullInstance().toJson(var0);
    }

    public static String getStringGson(String var0, String var1) {
        try {
            JSONObject var3 = new JSONObject(var0);
            var3.put(var1, var3);
            var0 = var3.toString();
            return var0;
        } catch (JSONException var2) {
            var2.printStackTrace();
            return "";
        }
    }

    public static String parserJsonString(String var0, String var1) {
        try {
            var0 = (new JSONObject(var0)).getString(var1);
            return var0;
        } catch (JSONException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static String parserJsonString(String var0, String var1, String... var2) {
        if (var2 != null) {
            JSONException var10000;
            label40: {
                boolean var10001;
                if (var2.length <= 0) {
                    return null;
                }

                int var3 = 0;

                while(true) {
                    try {
                        if (var3 >= var2.length) {
                            break;
                        }

                        var0 = (new JSONObject(var0)).getString(var2[var3]);
                    } catch (JSONException var5) {
                        var10000 = var5;
                        var10001 = false;
                        break label40;
                    }

                    ++var3;
                }

                try {
                    var0 = (new JSONObject(var0)).getString(var1);
                    return var0;
                } catch (JSONException var4) {
                    var10000 = var4;
                    var10001 = false;
                }
            }

            JSONException var7 = var10000;
            var7.printStackTrace();
        }

        return null;
    }

    public static String toPrettyFormat(String var0) {
        JsonObject var1 = (new JsonParser()).parse(var0).getAsJsonObject();
        return (new GsonBuilder()).setPrettyPrinting().create().toJson(var1);
    }

}