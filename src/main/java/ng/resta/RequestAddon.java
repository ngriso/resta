package ng.resta;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface RequestAddon {
    void apply(RequestSpecification requestSpecification);

    public static class Builder {
        public static RequestAddon basicAuth(final String username) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.auth().basic(username, "");
                }
            };
        }

        public static RequestAddon cookies(final String firstCookieName, final Object firstCookieValue, final Object... cookieNameValuePairs) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.cookies(firstCookieName, firstCookieValue, cookieNameValuePairs);
                }
            };
        }

        public static RequestAddon cookies(final Map<String, ?> cookies) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.cookies(cookies);
                }
            };
        }

        public static RequestAddon cookies(final Cookies cookies) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.cookies(cookies);
                }
            };
        }

        public static RequestAddon cookie(final String cookieName, final Object value, final Object... additionalValues) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.cookie(cookieName, value, additionalValues);
                }
            };
        }

        public static RequestAddon cookie(final String cookieName) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.cookie(cookieName);
                }
            };
        }

        public static RequestAddon cookie(final Cookie cookie) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.cookie(cookie);
                }
            };
        }

        public static RequestAddon queryParams(final String firstParameterName, final Object firstParameterValue, final Object... parameterNameValuePairs) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.queryParams(firstParameterName, firstParameterValue, parameterNameValuePairs);
                }
            };
        }

        public static RequestAddon queryParams(final Map<String, ?> parametersMap) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.queryParams(parametersMap);
                }
            };
        }

        public static RequestAddon queryParam(final String parameterName, final Object... parameterValues) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.queryParam(parameterName, parameterValues);
                }
            };
        }

        public static RequestAddon queryParam(final String parameterName, final List<?> parameterValues) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.queryParam(parameterName, parameterValues);
                }
            };
        }

        public static RequestAddon formParams(final String firstParameterName, final Object firstParameterValue, final Object... parameterNameValuePairs) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.formParams(firstParameterName, firstParameterValue, parameterNameValuePairs);
                }
            };
        }

        public static RequestAddon formParams(final Map<String, ?> parametersMap) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.formParams(parametersMap);
                }
            };
        }

        public static RequestAddon formParam(final String parameterName, final Object... parameterValues) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.formParam(parameterName, parameterValues);
                }
            };
        }

        public static RequestAddon formParam(final String parameterName, final List<?> parameterValues) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.formParam(parameterName, parameterValues);
                }
            };
        }

        public static RequestAddon headers(final String firstHeaderName, final Object firstHeaderValue, final Object... headerNameValuePairs) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.headers(firstHeaderName, firstHeaderValue, headerNameValuePairs);
                }
            };
        }

        public static RequestAddon headers(final Map<String, ?> headers) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.headers(headers);
                }
            };
        }

        public static RequestAddon headers(final Headers headers) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.headers(headers);
                }
            };
        }

        public static RequestAddon header(final String headerName, final Object headerValue, final Object... additionalHeaderValues) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.header(headerName, headerValue, additionalHeaderValues);
                }
            };
        }

        public static RequestAddon header(final Header header) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.header(header);
                }
            };
        }

        public static RequestAddon contentType(final ContentType contentType) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.contentType(contentType);
                }
            };
        }

        public static RequestAddon contentType(final String contentType) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.contentType(contentType);
                }
            };
        }

        public static RequestAddon multiPart(final File file) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(file);
                }
            };
        }

        public static RequestAddon multiPart(final String controlName, final File file) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(controlName, file);
                }
            };
        }

        public static RequestAddon multiPart(final String controlName, final File file, final String mimeType) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(controlName, file, mimeType);
                }
            };
        }

        public static RequestAddon multiPart(final String controlName, final String fileName, final byte[] bytes) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(controlName, fileName, bytes);
                }
            };
        }

        public static RequestAddon multiPart(final String controlName, final String fileName, final byte[] bytes, final String mimeType) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(controlName, fileName, bytes, mimeType);
                }
            };
        }

        public static RequestAddon multiPart(final String controlName, final String fileName, final InputStream stream) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(controlName, fileName, stream);
                }
            };
        }

        public static RequestAddon multiPart(final String controlName, final String fileName, final InputStream stream, final String mimeType) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(controlName, fileName, stream, mimeType);
                }
            };
        }

        public static RequestAddon multiPart(final String controlName, final String contentBody) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(controlName, contentBody);
                }
            };
        }

        public static RequestAddon multiPart(final String controlName, final String contentBody, final String mimeType) {
            return new RequestAddon() {
                @Override
                public void apply(RequestSpecification requestSpecification) {
                    requestSpecification.multiPart(controlName, contentBody, mimeType);
                }
            };
        }
    }
}
