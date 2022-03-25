package productPack;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class EntryInfo {

    private String commit;
    private String data ="";
    private RootObject value;

    public EntryInfo(String apiCall) {
        addEntry(apiCall);
    }

    public class Store {
        public String name;
        public String price;
        public String link;
        public String currency;
        public String currency_symbol;
    }

    public class Review {
        public String name;
        public String rating;
        public String title;
        public String review;
        public String date;
    }

    public class Product {
        public String barcode_number;
        public String barcode_formats;
        public String mpn;
        public String model;
        public String asin;
        public String title;
        public String category;
        public String manufacturer;
        public String brand;
        public String[] contributors;
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
        public Store[] stores;
        public Review[] reviews;

        public Product(String barcode_number, String barcode_formats, String mpn, String model,
                       String asin, String title, String category, String manufacturer,
                       String brand, String[] contributors, String age_group, String ingredients,
                       String nutrition_facts, String color, String format, String multipack,
                       String size, String length, String width, String height, String weight,
                       String release_date, String description, Object[] features, String[] images,
                       Store[] stores, Review[] reviews) {

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
            this.stores = stores;
            this.reviews = reviews;
        }
    }

    public class RootObject {
        public Product[] products;
    }

    public RootObject getDataObj() {
        return value;
    }


    public void addEntry(String apiCall) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    String dataTemp = "{\n" +
                            "    \"products\": [\n" +
                            "        {\n" +
                            "            \"barcode_number\": \"811660022826\",\n" +
                            "            \"barcode_formats\": \"UPC-A 811660022826, EAN-13 0811660022826\",\n" +
                            "            \"mpn\": \"811660022826\",\n" +
                            "            \"model\": \"\",\n" +
                            "            \"asin\": \"\",\n" +
                            "            \"title\": \"Nuun - Energy Effervescent Caffeine Supplement Ginger Lime Zing - 10 Tablets\",\n" +
                            "            \"category\": \"Health & Beauty > Personal Care > Hair Care > Shampoo & Conditioner\",\n" +
                            "            \"manufacturer\": \"Nuun\",\n" +
                            "            \"brand\": \"Nuun\",\n" +
                            "            \"contributors\": [],\n" +
                            "            \"age_group\": \"adult\",\n" +
                            "            \"ingredients\": \"\",\n" +
                            "            \"nutrition_facts\": \"\",\n" +
                            "            \"energy_efficiency_class\": \"\",\n" +
                            "            \"color\": \"\",\n" +
                            "            \"gender\": \"unisex\",\n" +
                            "            \"material\": \"\",\n" +
                            "            \"pattern\": \"\",\n" +
                            "            \"format\": \"\",\n" +
                            "            \"multipack\": \"\",\n" +
                            "            \"size\": \"\",\n" +
                            "            \"length\": \"\",\n" +
                            "            \"width\": \"\",\n" +
                            "            \"height\": \"\",\n" +
                            "            \"weight\": \"0.15 lb\",\n" +
                            "            \"release_date\": \"\",\n" +
                            "            \"description\": \"Nuun - Energy Effervescent Caffeine Supplement Ginger Lime Zing - 10 TabletsJumpstart your day with Nuun Energy a crafted blend designed to deliver a lift that lasts. Contains 80 mg of caffeine per serving. Energizing ingredients with a lasting lift. Extra oomph for any adventure. This innovativ.\",\n" +
                            "            \"features\": [],\n" +
                            "            \"images\": [\n" +
                            "                \"https://images.barcodelookup.com/25568/255680406-1.jpg\"\n" +
                            "            ],\n" +
                            "            \"last_update\": \"2022-03-11 01:21:09\",\n" +
                            "            \"stores\": [\n" +
                            "                {\n" +
                            "                    \"name\": \"LuckyVitamin.com\",\n" +
                            "                    \"country\": \"US\",\n" +
                            "                    \"currency\": \"USD\",\n" +
                            "                    \"currency_symbol\": \"$\",\n" +
                            "                    \"price\": \"5.25\",\n" +
                            "                    \"sale_price\": \"\",\n" +
                            "                    \"tax\": [],\n" +
                            "                    \"link\": \"https://www.luckyvitamin.com/p-9947144-nuun-energy-effervescent-caffeine-supplement-ginger-lime-zing-10-tablets?site=google_base\",\n" +
                            "                    \"item_group_id\": \"\",\n" +
                            "                    \"availability\": \"in stock\",\n" +
                            "                    \"condition\": \"new\",\n" +
                            "                    \"shipping\": [],\n" +
                            "                    \"last_update\": \"2022-03-11 01:21:09\"\n" +
                            "                },\n" +
                            "                {\n" +
                            "                    \"name\": \"Fleet Feet\",\n" +
                            "                    \"country\": \"US\",\n" +
                            "                    \"currency\": \"USD\",\n" +
                            "                    \"currency_symbol\": \"$\",\n" +
                            "                    \"price\": \"8.00\",\n" +
                            "                    \"sale_price\": \"\",\n" +
                            "                    \"tax\": [],\n" +
                            "                    \"link\": \"https://www.fleetfeet.com/products/nuun-energy-1?upc=811660022826\",\n" +
                            "                    \"item_group_id\": \"\",\n" +
                            "                    \"availability\": \"\",\n" +
                            "                    \"condition\": \"\",\n" +
                            "                    \"shipping\": [],\n" +
                            "                    \"last_update\": \"2021-06-22 06:53:51\"\n" +
                            "                },\n" +
                            "                {\n" +
                            "                    \"name\": \"Academy Sports + Outdoor\",\n" +
                            "                    \"country\": \"US\",\n" +
                            "                    \"currency\": \"USD\",\n" +
                            "                    \"currency_symbol\": \"$\",\n" +
                            "                    \"price\": \"7.99\",\n" +
                            "                    \"sale_price\": \"5.99\",\n" +
                            "                    \"tax\": [],\n" +
                            "                    \"link\": \"https://www.academy.com/shop/pdp/nuun-energy-watermelon-hydration-tablets-10-pack#repChildCatid=10275035\",\n" +
                            "                    \"item_group_id\": \"\",\n" +
                            "                    \"availability\": \"\",\n" +
                            "                    \"condition\": \"new\",\n" +
                            "                    \"shipping\": [],\n" +
                            "                    \"last_update\": \"2021-09-17 20:17:47\"\n" +
                            "                },\n" +
                            "                {\n" +
                            "                    \"name\": \"UnbeatableSale.com\",\n" +
                            "                    \"country\": \"US\",\n" +
                            "                    \"currency\": \"USD\",\n" +
                            "                    \"currency_symbol\": \"$\",\n" +
                            "                    \"price\": \"75.45\",\n" +
                            "                    \"sale_price\": \"58.04\",\n" +
                            "                    \"tax\": [],\n" +
                            "                    \"link\": \"http://www.boncui.com/imsm47737.html\",\n" +
                            "                    \"item_group_id\": \"\",\n" +
                            "                    \"availability\": \"\",\n" +
                            "                    \"condition\": \"new\",\n" +
                            "                    \"shipping\": [\n" +
                            "                        {\n" +
                            "                            \"country\": \"US\",\n" +
                            "                            \"region\": \"\",\n" +
                            "                            \"service\": \"\",\n" +
                            "                            \"price\": \"6.52 USD\"\n" +
                            "                        }\n" +
                            "                    ],\n" +
                            "                    \"last_update\": \"2022-01-28 14:34:26\"\n" +
                            "                }\n" +
                            "            ],\n" +
                            "            \"reviews\": []\n" +
                            "        }\n" +
                            "    ]\n" +
                            "}";

                    URL url = new URL(apiCall);
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                    String str = "";

                    while (null != (str = br.readLine())) {
                        data += str;
                    }

                    Log.d("dataT", "1.__Imported List" + data);
//                    br.close();

                    Gson g = new Gson();
                    value = g.fromJson(data, RootObject.class);

//                    int maxLogSize = 10000;
//                    for (int i = 0; i <= data.length() / maxLogSize; i++) {
//                        int start = i * maxLogSize;
//                        int end = (i + 1) * maxLogSize;
//                        end = end > data.length() ? data.length() : end;
//                        android.util.Log.d("DataT1", data.substring(start, end));
//                    }

//                    String barcode = value.products[0].barcode_number;
//                    System.out.print("Barcode Number: ");
//                    System.out.println(barcode);
//
//                    String name = value.products[0].title;
//                    System.out.print("Title: ");
//                    System.out.println(name);
//
//                    System.out.println("Entire Response:");
//                    System.out.println(data);

                    br.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.d("tried", "Failed try catch");
                }

//                Log.d("titleC",value.products[0].title);
//                Log.d("colorc", value.products[0].color);
            }
        });
        thread.start();
    }
}



