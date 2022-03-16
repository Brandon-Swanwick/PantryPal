package productPack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import productPack.myProduct;

public class jsonParser {
    public jsonParser(URL url) {
        BufferedReader br = null;
        String Data;
        ObjectMapper mapper = new ObjectMapper();

        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            StringBuilder tempData = new StringBuilder();
            while (null != (str = br.readLine())) {
                tempData.append(str);
            }
                Data = tempData.toString();
                myProduct tempProduct = mapper.readValue(Data,myProduct.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
