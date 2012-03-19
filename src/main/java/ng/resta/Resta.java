package ng.resta;

public class Resta {

    public static RequestEnhancer onURL(String url) {
        return new RequestEnhancer(url);
    }
}
