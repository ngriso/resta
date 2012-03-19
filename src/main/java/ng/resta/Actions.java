package ng.resta;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class Actions {
    protected RequestSpecification requestSpecification;
    private final String url;

    protected Actions(String url) {
        this.url = url;
        this.requestSpecification = given().contentType(ContentType.JSON);
    }

    public Sender post() {
        return new Sender(requestSpecification, url, Sender.ActionSender.POST);
    }

    public Sender post(String body) {
        requestSpecification.body(body);
        return new Sender(requestSpecification, url, Sender.ActionSender.POST);
    }

    public Sender post(byte[] body) {
        requestSpecification.body(body);
        return new Sender(requestSpecification, url, Sender.ActionSender.POST);
    }

    public Sender post(Object object) {
        requestSpecification.body(object);
        return new Sender(requestSpecification, url, Sender.ActionSender.POST);
    }

    public Sender put() {
        return new Sender(requestSpecification, url, Sender.ActionSender.PUT);
    }

    public Sender put(String body) {
        requestSpecification.body(body);
        return new Sender(requestSpecification, url, Sender.ActionSender.PUT);
    }

    public Sender put(Object body) {
        requestSpecification.body(body);
        return new Sender(requestSpecification, url, Sender.ActionSender.PUT);
    }

    public Sender get() {
        return new Sender(requestSpecification, url, Sender.ActionSender.GET);
    }

    public Sender delete() {
        return new Sender(requestSpecification, url, Sender.ActionSender.DELETE);
    }
}
