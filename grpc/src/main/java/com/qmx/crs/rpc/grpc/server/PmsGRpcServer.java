package com.qmx.crs.rpc.grpc.server;

import com.qmx.crs.rpc.pms.service.HelloWorldServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class PmsGRpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        final PmsGRpcServer server = new PmsGRpcServer();
        server.start();
        server.blockUntilShutdown();
    }

    private static final Logger logger = Logger.getLogger(PmsGRpcServer.class.getName());

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder
                .forPort(port)
                .addService(new PmsGRpcImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            PmsGRpcServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
