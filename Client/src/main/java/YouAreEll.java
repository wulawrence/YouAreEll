import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

public class YouAreEll {

    private String url = "http://zipcode.rocks:8085";
    OkHttpClient client;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    ObjectMapper objectMapper;

    YouAreEll() {
        objectMapper = new ObjectMapper();
         client = new OkHttpClient();
    }

    public static void main(String[] args) throws IOException {
        YouAreEll urlhandler = new YouAreEll();
        ObjectMapper mapper = new ObjectMapper();
        UserId me = new UserId("Larry", "wulawrence");
        String payload = mapper.writeValueAsString(me);
//        urlhandler.MakeURLCall("/ids", "POST", payload);
        Message message = new Message("wulawrence", "JoeHendricks415", "Look behind you");
        String messageload = mapper.writeValueAsString(message);
//        urlhandler.MakeURLCall("/ids/wulawrence/messages", "POST", messageload);

        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }
    public String get_ids() throws IOException {
        return MakeURLCall("/ids", "GET", "");
    }
    public String get_messages() throws IOException {
        return MakeURLCall("/messages", "GET", "");
    }
    public String postName(String payload) throws IOException {
        return MakeURLCall("/ids", "POST", payload);
    }
    public String postMessage(String payload) throws IOException {
        return MakeURLCall("/ids/wulawrence/messages", "POST", payload);
    }
    public String putName(String payload) throws IOException {
        return MakeURLCall("/ids", "PUT", payload);
    }
    public String putMessage(String payload) throws IOException {
        return MakeURLCall("/ids/wulawrence/messages", "PUT", payload);
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) throws IOException{
        String fullUrl = url + mainurl;


        if (method.equalsIgnoreCase("GET")){
            RequestBody body = RequestBody.create(JSON, jpayload);
            Request request = new Request.Builder().url(fullUrl).build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
        if (method.equalsIgnoreCase("POST")){
            RequestBody body = RequestBody.create(JSON, jpayload);
            Request request = new Request.Builder().url(fullUrl).post(body).build();
            Response response = client.newCall(request).execute();
            return response.body().string();

        }

        if (method.equalsIgnoreCase("PUT")){
            RequestBody body = RequestBody.create(JSON, jpayload);
            Request request = new Request.Builder().url(fullUrl).put(body).build();
            Response response = client.newCall(request).execute();
            return response.body().string();

        }
        return "invald method: " + method;
    }
}
