package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class ProductProperties {

    private JSONArray productsArray;

    public ProductProperties(String jsonFileName) {
        productsArray = ConfigReader.initJson(jsonFileName);
    }

    public String getProductName(int index) {
        return productsArray.getJSONObject(index).getString("name");
    }

    public Map<String, String> getProductVariants(int index) {
        Map<String, String> variants = new HashMap<>();
        JSONObject variantsObject = productsArray.getJSONObject(index).getJSONObject("variants");
        for (String key : variantsObject.keySet()) {
            variants.put(key, variantsObject.getString(key));
        }
        return variants;
    }

    public int getProductCount() {
        return productsArray.length();
    }
}
