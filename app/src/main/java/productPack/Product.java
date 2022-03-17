package productPack;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class Product implements Serializable {
    public String getBarcode_number() {
        return barcode_number;
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

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getManufacturer() {
        return manufacturer;
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

    public String barcode_number;
    public String barcode_formats;
    public String mpn;
    public String model;
    public String asin;
    public String title;
    public String category;
    public String manufacturer;
    public String brand;
    public String contributors;
    public String age_group;
    public String ingredients;
    public String nutrition_facts;
    public String color;
    public String format;
    public String multipack;
    public String size;
    public String length;
    public String width;
    public String height;
    public String weight;
    public String release_date;
    public String description;
    public Object[] features;
    public String[] images;

    public Product(String barcode_number, String barcode_formats, String mpn, String model,
                   String asin, String title, String category, String manufacturer, String brand,
                   String contributors, String age_group, String ingredients,
                   String nutrition_facts, String color, String format, String multipack,
                   String size, String length, String width, String height, String weight,
                   String release_date, String description, Object[] features, String[] images) {
        this.barcode_number = barcode_number;
        this.barcode_formats = barcode_formats;
        this.mpn = mpn;
        this.model = model;
        this.asin = asin;
        this.title = title;
        this.category = category;
        this.manufacturer = manufacturer;
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

    public Product getProduct(){
        return this;
    }

    public Product(String strUrl) {
        try {
            URL url = new URL("https://api.barcodelookup.com/v3/products?barcode=077341125112&formatted=y&key=ENTER_YOUR_API_KEY_HERE");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            String data = "";
            while (null != (str = br.readLine())) {
                data += str;
            }

            Gson g = new Gson();

            Product entry = g.fromJson(data.toString(), Product.class);

            String barcode = entry.getBarcode_number();
            System.out.print("Barcode Number: ");
            System.out.println(barcode);

            String name = entry.getTitle();
            System.out.print("Title: ");
            System.out.println(name);

            System.out.println("Entire Response:");
            System.out.println(data);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



