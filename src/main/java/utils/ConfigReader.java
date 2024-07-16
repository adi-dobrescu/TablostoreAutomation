package utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;

public class ConfigReader {
    public static Properties initProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/config/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static JSONArray initJson(String fileName) {
        JSONArray jsonArray = null;
        try (InputStream input = new FileInputStream(fileName)) {
            String jsonText = new Scanner(input, StandardCharsets.UTF_8).useDelimiter("\\A").next();
            JSONObject jsonObject = new JSONObject(jsonText);
            jsonArray = jsonObject.getJSONArray("products");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
