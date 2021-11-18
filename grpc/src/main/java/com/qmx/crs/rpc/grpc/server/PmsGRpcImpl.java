package com.qmx.crs.rpc.grpc.server;

import com.google.protobuf.Empty;
import com.qmx.crs.rpc.grpc.proto.*;
import io.grpc.stub.StreamObserver;

public class PmsGRpcImpl extends CrsServerGrpcGrpc.CrsServerGrpcImplBase {

    @Override
    public void getPublicKey(Empty request, StreamObserver<PublicKey> responseObserver) {
        super.getPublicKey(request, responseObserver);
    }

    @Override
    public void login(LoginParams request, StreamObserver<Token> responseObserver) {
        super.login(request, responseObserver);
    }

    @Override
    public void pushRoomType(PushRoomTypeRequest request, StreamObserver<PushRoomTypeResponse> responseObserver) {
        super.pushRoomType(request, responseObserver);
        System.out.println("发布房型："+request);

        PushRoomTypeResponse response = PushRoomTypeResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void pushRoomVolumes(PushRoomVolumesRequest request, StreamObserver<PushRoomVolumesResponse> responseObserver) {
        super.pushRoomVolumes(request, responseObserver);
    }
}
