package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.routes;

import java.util.HashMap;
import java.util.Map;

interface RequestHandler {
    void handle(String path);
}

// Router class
class Router {
    private Map<String, RequestHandler> routes;

    public Router() {
        this.routes = new HashMap<>();
    }

    // Add a route to the router
    public void addRoute(String method, String path, RequestHandler handler) {
        String key = method + ":" + path;
        routes.put(key, handler);
    }

    // Handle a request based on method and path
    public void handleRequest(String method, String path) {
        String key = method + ":" + path;
        RequestHandler handler = routes.get(key);

        if (handler != null) {
            handler.handle(path);
        } else {
            System.out.println("404 Not Found");
        }
    }
}

// Example usage
public class RouterTest {
    public static void main(String[] args) {
        // Instantiate the router
        Router router = new Router();

        // Define routes
        router.addRoute("GET", "/users", path -> System.out.println("Handling GET /users"));
        router.addRoute("GET", "/users/:userId", path -> {
            String userId = extractParameter(path, "userId");
            System.out.println("Handling GET /users/:userId with userId=" + userId);
        });
        router.addRoute("POST", "/users", path -> System.out.println("Handling POST /users"));
        router.addRoute("PUT", "/users/:userId", path -> {
            String userId = extractParameter(path, "userId");
            System.out.println("Handling PUT /users/:userId with userId=" + userId);
        });
        router.addRoute("DELETE", "/users/:userId", path -> {
            String userId = extractParameter(path, "userId");
            System.out.println("Handling DELETE /users/:userId with userId=" + userId);
        });

        // Handle requests
        router.handleRequest("GET", "/users");
        router.handleRequest("GET", "/users/123");
        router.handleRequest("POST", "/users");
        router.handleRequest("PUT", "/users/456");
        router.handleRequest("DELETE", "/users/789");
        router.handleRequest("GET", "/posts"); // Should return a "404 Not Found"
    }

    // Helper method to extract parameter values from path
    private static String extractParameter(String path, String paramName) {
        String[] parts = path.split("/");
        for (int i = 0; i < parts.length - 1; i++) {
            if (parts[i].equals(paramName)) {
                return parts[i + 1];
            }
        }
        return null;
    }
}