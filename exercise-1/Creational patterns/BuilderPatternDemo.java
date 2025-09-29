import java.util.HashMap;
import java.util.Map;

/**
 * BuilderPatternDemo
 * Simple demonstration of Builderpattern using simplehttprequest builder
 * 
 */

// Request class
class SimpleHttpRequest {

    private String url;
    private String method;
    private Map<String, String> headers;
    private String queryParams;
    private String body;

    private SimpleHttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.queryParams = builder.queryParams.toString();
        this.body = builder.body;
    }

    @Override
    public String toString() {

        return "SimpleHttpRequest{\n" + "url=\"" + url + queryParams + "\",\nmethod=\"" + method + "\",\nheaders="
                + headers
                + ",\nbody=\""
                + body + "\"\n}";
    }

    public void makeCall() {
        System.out.print(this);
    }

    // builder class
    static class Builder {

        private String url;
        private String method;
        private Map<String, String> headers;
        private StringBuilder queryParams;
        private String body;

        Builder() {
            headers = new HashMap<>();
            queryParams = new StringBuilder();
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder addQuery(String key, String value) {
            if (queryParams.isEmpty())
                queryParams.append("?");
            else
                queryParams.append("&");
            queryParams.append(key + "=" + value);
            return this;
        }

        public Builder addHeader(String key, String value) {
            headers.putIfAbsent(key, value);
            return this;
        }

        public Builder setBody(String content) {
            body = content;
            return this;
        }

        public SimpleHttpRequest build() {
            return new SimpleHttpRequest(this);
        }

    }

}

// client
public class BuilderPatternDemo {

    public static void main(String[] args) {
        SimpleHttpRequest req1 = new SimpleHttpRequest.Builder()
                .setUrl("localhost/ei/home.html")
                .setMethod("GET")
                .addHeader("authorization", "token")
                .addQuery("sort", "desc")
                .addQuery("filterby", "date")
                .setBody("raw data")
                .build();

        req1.makeCall();

        /*
         * Sample output
         * SimpleHttpRequest
         * {
         * url="localhost/ei/home.html?sort=desc&filterby=date",
         * method="GET",
         * headers={authorization=token},
         * body="raw data"
         * }
         */
    }

}
