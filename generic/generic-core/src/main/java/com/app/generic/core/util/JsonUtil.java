package com.app.generic.core.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@Component
public class JsonUtil {
	
	public static final Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
		
		@Override
		public boolean shouldSkipField(FieldAttributes f) {
			return f.getAnnotation(JsonIgnoreProperties.class)!=null;
		}
		
		@Override
		public boolean shouldSkipClass(Class<?> clazz) {
			return false;
		}
	}).setPrettyPrinting().create();

	public static String toJsonString(Object src) {
		return gson.toJson(src);
	}
	
	public static <S> String toJsonString(S src, boolean isPrettyPrinting) {
		Gson gson = isPrettyPrinting ? JsonUtil.gson : new Gson();
		return gson.toJson(src);
	}
	
	public static String toPrettyFormat(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonString).getAsJsonObject();
		
		String prettyJson = gson.toJson(json);
		return prettyJson;
	}
	
	public static String toJsonString(Object src, Type type) {
		Gson gson = new Gson();
		return gson.toJson(src, type);
	}
	
	public static <S> void toJsonFile(String filename, S src) throws JsonIOException, IOException {
		FileWriter writer = new FileWriter(filename);
		gson.toJson(src, writer);
		writer.flush();
		writer.close();
	}
	
	public static <S> void toJsonFile(String filename, S src, Type type) throws JsonIOException, IOException {
		FileWriter writer = new FileWriter(filename);
		gson.toJson(src, type, writer);
		writer.flush();
		writer.close();
	}
	
	public static <T> T fromJsonString(String json, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(json, clazz);
	}
	
	public static <T> T fromJsonString(String json, Type type) {
		return gson.fromJson(json, type);
	}
	
	public static <T> T fromJsonFile(String filename, Class<T> clazz) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		T res = null;
		FileReader reader = new FileReader(filename);
		res = gson.fromJson(reader, clazz);
		try {
			reader.close();
		} catch (IOException e) {
		}
		return res;
	}
	
	public static <T> T fromJsonFile(String filename, Type type) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		T res = null;
		FileReader reader = new FileReader(filename);
		res = gson.fromJson(reader, type);
		try {
			reader.close();
		} catch (IOException e) {
		}
		return res;
	}
	
	public static JsonElement toJsonElement(String json) {
		return new JsonParser().parse(json);
	}
	
	public static String addData(String json, Map<String, Object> datas) {
		if (datas != null) {
			JsonElement jsonElement = toJsonElement(json);
			for (Map.Entry<String, Object> entry : datas.entrySet()) {
				Object value = entry.getValue();
				String key = entry.getKey();
				if (value instanceof JsonElement) {
					jsonElement.getAsJsonObject().add(key, (JsonElement) value);
				} else if (value instanceof Boolean) {
					jsonElement.getAsJsonObject().addProperty(key, Boolean.valueOf(String.valueOf(value)));
				} else if (value instanceof Integer) {
					jsonElement.getAsJsonObject().addProperty(key, Integer.valueOf(String.valueOf(value)));
				} else {
					jsonElement.getAsJsonObject().addProperty(key, String.valueOf(value));
				}
			}
			json = gson.toJson(jsonElement);
		}
		return json;
	}
	
	public static JsonObject toJsonObject(String json) {
		JsonElement res = toJsonElement(json);
		return (res.isJsonObject() ? res.getAsJsonObject() : null);
	}
	
	public static JsonArray toJsonArray(String json) {
		JsonElement res = new JsonParser().parse(json);
		return (res.isJsonArray() ? res.getAsJsonArray() : null);
	}
	
	public static <T,F> T castClass(Class<T> to,F from){
		return fromJsonString(toJsonString(from), to);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(String json) {
		Map<String, Object> res = null;
		res = (Map<String, Object>) fromJsonString(json, new TypeToken<Map<String, Object>>(){}.getType());
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object> toList(String json) {
		List<Object> res = null;
		res = (List<Object>) fromJsonString(json, new TypeToken<List<Object>>(){}.getType());
		return res;
	}
	
	public static String toFlatJson(String json) {
		return JsonFlattener.flatten(json);
	}
	
	public static Map<String, Object> toFlatJsonMap(String json) {
		return JsonFlattener.flattenAsMap(json);
	}
	
	public static Object convertFromByteJsonToObject(byte[] object) {

		StringBuilder sb = new StringBuilder("");
		for (byte b : object) {
			sb.append(Character.toString((char) b));
		}
		System.out.println(sb.toString());

		Object result = gson.fromJson(sb.toString(), Object.class);
		return result;
	}
}
