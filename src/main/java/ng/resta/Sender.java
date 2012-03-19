package ng.resta;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSender;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    private final RequestSpecification requestSpecification;
    private final String url;
    private final ActionSender actionSender;

    public Sender(RequestSpecification requestSpecification, String url, ActionSender actionSender) {
        this.requestSpecification = requestSpecification;
        this.url = url;
        this.actionSender = actionSender;
    }

    public Response send() {
        return sendAndExpect();
    }

    public Response sendAndExpect(Expectation... expectations) {
        LOGGER.debug("======= [START] {} ===========", actionSender.description);
        ResponseSpecification responseSpecification = this.requestSpecification.expect();
        responseSpecification.statusCode(actionSender.defaultStatusCode);
        for (Expectation expectation : expectations) {
            expectation.applyExpectation(responseSpecification);
        }
        Response response = actionSender.sendRequest(responseSpecification, url);
        LOGGER.debug("======= [END] {} ===========", actionSender.description);
        return response;
    }

    public static enum ActionSender {
        GET(200, "GET RESOURCE") {
            @Override
            protected Response sendRequest(RequestSender requestSender, String url) {
                return requestSender.get(url);
            }
        },
        DELETE(204, "DELETE RESOURCE") {
            @Override
            protected Response sendRequest(RequestSender requestSender, String url) {
                return requestSender.delete(url);
            }
        },
        PUT(204, "PUT RESOURCE") {
            @Override
            protected Response sendRequest(RequestSender requestSender, String url) {
                return requestSender.put(url);
            }
        },
        POST(204, "POST RESOURCE") {
            @Override
            protected Response sendRequest(RequestSender requestSender, String url) {
                return requestSender.post(url);
            }
        };

        public final int defaultStatusCode;
        public final String description;

        private ActionSender(int defaultStatusCode, String description) {
            this.defaultStatusCode = defaultStatusCode;
            this.description = description;
        }

        protected abstract Response sendRequest(RequestSender requestSender, String url);

    }
}
