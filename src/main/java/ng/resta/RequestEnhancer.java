package ng.resta;

public class RequestEnhancer extends Actions {

    public RequestEnhancer(String url) {
        super(url);
    }

    public Actions with(RequestAddon... requestAddons) {
        for (RequestAddon requestAddon : requestAddons) {
            requestAddon.apply(this.requestSpecification);
        }
        return this;
    }
}
