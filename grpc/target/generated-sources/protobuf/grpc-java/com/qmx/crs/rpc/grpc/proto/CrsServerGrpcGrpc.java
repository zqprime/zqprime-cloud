package com.qmx.crs.rpc.grpc.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 *中央预订系统接受推送参数的接口服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: pms.proto")
public final class CrsServerGrpcGrpc {

  private CrsServerGrpcGrpc() {}

  public static final String SERVICE_NAME = "CrsServerGrpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.qmx.crs.rpc.grpc.proto.PublicKey> METHOD_GET_PUBLIC_KEY =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.qmx.crs.rpc.grpc.proto.PublicKey>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "CrsServerGrpc", "GetPublicKey"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.qmx.crs.rpc.grpc.proto.PublicKey.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.qmx.crs.rpc.grpc.proto.LoginParams,
      com.qmx.crs.rpc.grpc.proto.Token> METHOD_LOGIN =
      io.grpc.MethodDescriptor.<com.qmx.crs.rpc.grpc.proto.LoginParams, com.qmx.crs.rpc.grpc.proto.Token>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "CrsServerGrpc", "Login"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.qmx.crs.rpc.grpc.proto.LoginParams.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.qmx.crs.rpc.grpc.proto.Token.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest,
      com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse> METHOD_PUSH_ROOM_TYPE =
      io.grpc.MethodDescriptor.<com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest, com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "CrsServerGrpc", "PushRoomType"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest,
      com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse> METHOD_PUSH_ROOM_VOLUMES =
      io.grpc.MethodDescriptor.<com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest, com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "CrsServerGrpc", "PushRoomVolumes"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CrsServerGrpcStub newStub(io.grpc.Channel channel) {
    return new CrsServerGrpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CrsServerGrpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CrsServerGrpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CrsServerGrpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CrsServerGrpcFutureStub(channel);
  }

  /**
   * <pre>
   *中央预订系统接受推送参数的接口服务
   * </pre>
   */
  public static abstract class CrsServerGrpcImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *获取公钥的接口
     * </pre>
     */
    public void getPublicKey(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PublicKey> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PUBLIC_KEY, responseObserver);
    }

    /**
     * <pre>
     *登录接口
     * </pre>
     */
    public void login(com.qmx.crs.rpc.grpc.proto.LoginParams request,
        io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.Token> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN, responseObserver);
    }

    /**
     * <pre>
     *请求房型的远程接口
     * </pre>
     */
    public void pushRoomType(com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest request,
        io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PUSH_ROOM_TYPE, responseObserver);
    }

    /**
     * <pre>
     *推送房量的远程接口
     * </pre>
     */
    public void pushRoomVolumes(com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest request,
        io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PUSH_ROOM_VOLUMES, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_PUBLIC_KEY,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.qmx.crs.rpc.grpc.proto.PublicKey>(
                  this, METHODID_GET_PUBLIC_KEY)))
          .addMethod(
            METHOD_LOGIN,
            asyncUnaryCall(
              new MethodHandlers<
                com.qmx.crs.rpc.grpc.proto.LoginParams,
                com.qmx.crs.rpc.grpc.proto.Token>(
                  this, METHODID_LOGIN)))
          .addMethod(
            METHOD_PUSH_ROOM_TYPE,
            asyncUnaryCall(
              new MethodHandlers<
                com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest,
                com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse>(
                  this, METHODID_PUSH_ROOM_TYPE)))
          .addMethod(
            METHOD_PUSH_ROOM_VOLUMES,
            asyncUnaryCall(
              new MethodHandlers<
                com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest,
                com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse>(
                  this, METHODID_PUSH_ROOM_VOLUMES)))
          .build();
    }
  }

  /**
   * <pre>
   *中央预订系统接受推送参数的接口服务
   * </pre>
   */
  public static final class CrsServerGrpcStub extends io.grpc.stub.AbstractStub<CrsServerGrpcStub> {
    private CrsServerGrpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CrsServerGrpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrsServerGrpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CrsServerGrpcStub(channel, callOptions);
    }

    /**
     * <pre>
     *获取公钥的接口
     * </pre>
     */
    public void getPublicKey(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PublicKey> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PUBLIC_KEY, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *登录接口
     * </pre>
     */
    public void login(com.qmx.crs.rpc.grpc.proto.LoginParams request,
        io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.Token> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *请求房型的远程接口
     * </pre>
     */
    public void pushRoomType(com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest request,
        io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUSH_ROOM_TYPE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *推送房量的远程接口
     * </pre>
     */
    public void pushRoomVolumes(com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest request,
        io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUSH_ROOM_VOLUMES, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *中央预订系统接受推送参数的接口服务
   * </pre>
   */
  public static final class CrsServerGrpcBlockingStub extends io.grpc.stub.AbstractStub<CrsServerGrpcBlockingStub> {
    private CrsServerGrpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CrsServerGrpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrsServerGrpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CrsServerGrpcBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *获取公钥的接口
     * </pre>
     */
    public com.qmx.crs.rpc.grpc.proto.PublicKey getPublicKey(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PUBLIC_KEY, getCallOptions(), request);
    }

    /**
     * <pre>
     *登录接口
     * </pre>
     */
    public com.qmx.crs.rpc.grpc.proto.Token login(com.qmx.crs.rpc.grpc.proto.LoginParams request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN, getCallOptions(), request);
    }

    /**
     * <pre>
     *请求房型的远程接口
     * </pre>
     */
    public com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse pushRoomType(com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PUSH_ROOM_TYPE, getCallOptions(), request);
    }

    /**
     * <pre>
     *推送房量的远程接口
     * </pre>
     */
    public com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse pushRoomVolumes(com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PUSH_ROOM_VOLUMES, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *中央预订系统接受推送参数的接口服务
   * </pre>
   */
  public static final class CrsServerGrpcFutureStub extends io.grpc.stub.AbstractStub<CrsServerGrpcFutureStub> {
    private CrsServerGrpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CrsServerGrpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrsServerGrpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CrsServerGrpcFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *获取公钥的接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qmx.crs.rpc.grpc.proto.PublicKey> getPublicKey(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PUBLIC_KEY, getCallOptions()), request);
    }

    /**
     * <pre>
     *登录接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qmx.crs.rpc.grpc.proto.Token> login(
        com.qmx.crs.rpc.grpc.proto.LoginParams request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request);
    }

    /**
     * <pre>
     *请求房型的远程接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse> pushRoomType(
        com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PUSH_ROOM_TYPE, getCallOptions()), request);
    }

    /**
     * <pre>
     *推送房量的远程接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse> pushRoomVolumes(
        com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PUSH_ROOM_VOLUMES, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PUBLIC_KEY = 0;
  private static final int METHODID_LOGIN = 1;
  private static final int METHODID_PUSH_ROOM_TYPE = 2;
  private static final int METHODID_PUSH_ROOM_VOLUMES = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CrsServerGrpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CrsServerGrpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PUBLIC_KEY:
          serviceImpl.getPublicKey((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PublicKey>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.qmx.crs.rpc.grpc.proto.LoginParams) request,
              (io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.Token>) responseObserver);
          break;
        case METHODID_PUSH_ROOM_TYPE:
          serviceImpl.pushRoomType((com.qmx.crs.rpc.grpc.proto.PushRoomTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse>) responseObserver);
          break;
        case METHODID_PUSH_ROOM_VOLUMES:
          serviceImpl.pushRoomVolumes((com.qmx.crs.rpc.grpc.proto.PushRoomVolumesRequest) request,
              (io.grpc.stub.StreamObserver<com.qmx.crs.rpc.grpc.proto.PushRoomVolumesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CrsServerGrpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CrsServerGrpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CrsServerGrpcDescriptorSupplier())
              .addMethod(METHOD_GET_PUBLIC_KEY)
              .addMethod(METHOD_LOGIN)
              .addMethod(METHOD_PUSH_ROOM_TYPE)
              .addMethod(METHOD_PUSH_ROOM_VOLUMES)
              .build();
        }
      }
    }
    return result;
  }
}
