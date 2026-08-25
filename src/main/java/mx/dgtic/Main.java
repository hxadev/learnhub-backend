package mx.dgtic;

import mx.dgtic.config.ApplicationConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.net.URI;

public class Main {
    public static void main(String[] args)  {
        try {
            runServer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void runServer() throws InterruptedException {
        ApplicationConfig config = new ApplicationConfig();
        URI uri = URI.create("http://localhost:8080/api/");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);

        System.out.println("Servidor corriendo en " + uri);
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));

        Thread.currentThread().join();
    }
}