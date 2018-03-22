import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class YouAreEll {

    private String url = "http://zipcode.rocks:8085";

    YouAreEll() {
    }

    public static void main(String[] args) {
        YouAreEll urlhandler = new YouAreEll();
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {
        return MakeURLCall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        String fullUrl = url + mainurl;

        if (method.equalsIgnoreCase("get")){
            try {
                return String.valueOf(Unirest.get(fullUrl).asString());
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        if (method.equalsIgnoreCase("put")){

        }
        return "nada";
    }
}
