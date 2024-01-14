package carneiro.bruno.jsonparser;

import com.google.gson.*;

import java.time.Instant;

/**
 * Hello world!
 *
 */
public class JsonParser<T> {
    private final Gson gson;
    private final Class<T> classOfT;

    public JsonParser(Class<T> classOfT) {
        this.classOfT = classOfT;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.registerTypeAdapter(Instant.class, new InstantDeserializer());
        this.gson = gsonBuilder.create();
    }

    public T parse(String jsonResponse) {
        return gson.fromJson(jsonResponse, classOfT);
    }

    public String serialize(Object obj) {
        return gson.toJson(obj);
    }
}