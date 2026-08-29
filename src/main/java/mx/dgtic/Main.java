package mx.dgtic;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import mx.dgtic.config.ApplicationConfig;
import mx.dgtic.dao.*;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.net.URI;

public class Main {
                // Application Program Interface = API = Exposicion a red
    private static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) {
        try {
            runServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runServer() throws InterruptedException {
        final ApplicationConfig config = new ApplicationConfig();
        final URI uri = URI.create(BASE_URI);
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);

        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  🎓 LearnHub BackEnd API v1.0");
        System.out.println("-->" + BASE_URI);
        System.out.println("══════════════════════════════════════════");
        System.out.println("  GET  /courses | /courses/{id} | /courses/category/{name}");
        System.out.println("  GET  /courses/top-popular?limit=5 | /courses/stats");
        System.out.println("  GET  /students | /students/{id}/enrollments");
        System.out.println("  GET  /enrollments/course/{id} | /enrollments/stats");
        System.out.println("  GET  /instructors | /instructors/revenue");
        System.out.println("  GET  /categories");
        System.out.println("  POST /enrollments?studentId=STU-001&courseId=3");
        System.out.println("══════════════════════════════════════════");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));

        Thread.currentThread().join();
    }
}