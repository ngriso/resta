package ng.resta;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.Argument;
import com.jayway.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;

import java.util.List;
import java.util.Map;

public interface Expectation {
    void applyExpectation(ResponseSpecification responseSpecification);

    public static class Builder {

        public static Expectation content(final Matcher<?> matcher, final Matcher<?>... additionalMatchers) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.content(matcher, additionalMatchers);
                }
            };
        }

        public static Expectation content(final String key, final Matcher<?> matcher, final Object... additionalKeyMatcherPairs) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.content(key, matcher, additionalKeyMatcherPairs);
                }
            };
        }

        public static Expectation body(final String key, final List<Argument> arguments, final Matcher matcher, final Object... additionalKeyMatcherPairs) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.body(key, arguments, matcher, additionalKeyMatcherPairs);
                }
            };
        }

        public static Expectation statusCode(final Matcher<? super Integer> expectedStatusCode) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.statusCode(expectedStatusCode);
                }
            };
        }

        public static Expectation statusCode(final int expectedStatusCode) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.statusCode(expectedStatusCode);
                }
            };
        }

        public static Expectation statusLine(final Matcher<? super String> expectedStatusLine) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.statusLine(expectedStatusLine);
                }
            };
        }

        public static Expectation statusLine(final String expectedStatusLine) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.statusLine(expectedStatusLine);
                }
            };
        }

        public static Expectation headers(final Map<String, ?> expectedHeaders) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.headers(expectedHeaders);
                }
            };
        }

        public static Expectation headers(final String firstExpectedHeaderName, final Object firstExpectedHeaderValue, final Object... expectedHeaders) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.headers(firstExpectedHeaderName, firstExpectedHeaderValue, expectedHeaders);
                }
            };
        }

        public static Expectation header(final String headerName, final Matcher<?> expectedValueMatcher) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.header(headerName, expectedValueMatcher);
                }
            };
        }

        public static Expectation header(final String headerName, final String expectedValue) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.header(headerName, expectedValue);
                }
            };
        }

        public static Expectation cookies(final Map<String, ?> expectedCookies) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.cookies(expectedCookies);
                }
            };
        }

        public static Expectation cookie(final String cookieName) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.cookie(cookieName);
                }
            };
        }

        public static Expectation cookies(final String firstExpectedCookieName, final Object firstExpectedCookieValue, final Object... expectedCookieNameValuePairs) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.cookies(firstExpectedCookieName, firstExpectedCookieValue, expectedCookieNameValuePairs);
                }
            };
        }

        public static Expectation cookie(final String cookieName, final Matcher<?> expectedValueMatcher) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.cookie(cookieName, expectedValueMatcher);
                }
            };
        }

        public static Expectation cookie(final String cookieName, final Object expectedValue) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.cookie(cookieName, expectedValue);
                }
            };
        }

        public static Expectation contentType(final ContentType contentType) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.contentType(contentType);
                }
            };
        }

        public static Expectation contentType(final String contentType) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.contentType(contentType);
                }
            };
        }

        public static Expectation contentType(final Matcher<? super String> contentType) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.contentType(contentType);
                }
            };
        }

        public static Expectation body(final Matcher<?> matcher, final Matcher<?>... additionalMatchers) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.body(matcher, additionalMatchers);
                }
            };
        }

        public static Expectation body(final String path, final Matcher<?> matcher, final Object... additionalKeyMatcherPairs) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.body(path, matcher, additionalKeyMatcherPairs);
                }
            };
        }

        public static Expectation content(final String path, final List<Argument> arguments, final Matcher matcher, final Object... additionalKeyMatcherPairs) {
            return new Expectation() {
                @Override
                public void applyExpectation(ResponseSpecification responseSpecification) {
                    responseSpecification.content(path, arguments, matcher, additionalKeyMatcherPairs);
                }
            };
        }
    }
}
