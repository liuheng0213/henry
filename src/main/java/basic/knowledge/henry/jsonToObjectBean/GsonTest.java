package basic.knowledge.henry.jsonToObjectBean;

import basic.knowledge.henry.jsonToObjectBean.param.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;
import java.util.Date;

public class GsonTest {
    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yyyy HH:mm:ss");
        gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
        Gson GSON = gsonBuilder.create();
        String json1 = GSON.toJson(new Timestamp((new Date()).getTime()));


        String json = "{\n" +
                "\t\"type\" : \"blood\",\n" +
                "\t\"name\" :\"heng\",\n" +
                "\t\"dates\" : {\n" +
                "\t\t\"startDate\" : \"13/02/1988 12:05:45\",\n" +
                "\t\t\"endDate\" : \"13/02/2988 12:05:45\"\n" +
                "\t}\n" +
                "}";

        Parameter parameter = GSON.fromJson(json, Parameter.class);

        System.out.println(parameter);
    }
}
