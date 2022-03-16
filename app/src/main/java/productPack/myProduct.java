package productPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;

public class myProduct implements Serializable, myProductInterface {


    public String getBarcode_number() {
        return barcode_number;
    }

    public String getTitle() {
        return title;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public String getBarcode_formats() {
        return barcode_formats;
    }

    public String getMpn() {
        return mpn;
    }

    public String getModel() {
        return model;
    }

    public String getAsin() {
        return asin;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getContributors() {
        return contributors;
    }

    public String getAge_group() {
        return age_group;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getNutrition_facts() {
        return nutrition_facts;
    }

    public String getColor() {
        return color;
    }

    public String getFormat() {
        return format;
    }

    public String getMultipack() {
        return multipack;
    }

    public String getSize() {
        return size;
    }

    public String getLength() {
        return length;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getDescription() {
        return description;
    }

    public Object[] getFeatures() {
        return features;
    }

    public String[] getImages() {
        return images;
    }

    private String manufacturer;
    private String barcode_number;
    private String title;
    private String barcode_formats;
    private String mpn;
    private String model;
    private String asin;
    private String category;
    private String brand;
    private String contributors;
    private String age_group;
    private String ingredients;
    private String nutrition_facts;
    private String color;
    private String format;
    private String multipack;
    private String size;
    private String length;
    private String width;
    private String height;
    private String weight;
    private String release_date;
    private String description;
    private Object[] features;
    private String[] images;

    public myProduct(){
        super();
    }
    public myProduct(String manufacturer, String barcode_number, String title,
                     String barcode_formats, String mpn, String model, String asin,
                     String category, String brand, String contributors, String age_group,
                     String ingredients, String nutrition_facts, String color, String format,
                     String multipack, String size, String length, String width, String height,
                     String weight, String release_date, String description, Object[] features,
                     String[] images) {

        this.manufacturer = manufacturer;
        this.barcode_number = barcode_number;
        this.title = title;
        this.barcode_formats = barcode_formats;
        this.mpn = mpn;
        this.model = model;
        this.asin = asin;
        this.category = category;
        this.brand = brand;
        this.contributors = contributors;
        this.age_group = age_group;
        this.ingredients = ingredients;
        this.nutrition_facts = nutrition_facts;
        this.color = color;
        this.format = format;
        this.multipack = multipack;
        this.size = size;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.release_date = release_date;
        this.description = description;
        this.features = features;
        this.images = images;
    }
}

