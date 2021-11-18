// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pms.proto

package com.qmx.crs.rpc.grpc.proto;

public interface RoomTypeSegmentOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RoomTypeSegment)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *房型编码 （可处理多房型数据）
   * </pre>
   *
   * <code>string roomTypeCode = 3;</code>
   * @return The roomTypeCode.
   */
  java.lang.String getRoomTypeCode();
  /**
   * <pre>
   *房型编码 （可处理多房型数据）
   * </pre>
   *
   * <code>string roomTypeCode = 3;</code>
   * @return The bytes for roomTypeCode.
   */
  com.google.protobuf.ByteString
      getRoomTypeCodeBytes();

  /**
   * <pre>
   *可用房量
   * </pre>
   *
   * <code>string roomsAvailable = 4;</code>
   * @return The roomsAvailable.
   */
  java.lang.String getRoomsAvailable();
  /**
   * <pre>
   *可用房量
   * </pre>
   *
   * <code>string roomsAvailable = 4;</code>
   * @return The bytes for roomsAvailable.
   */
  com.google.protobuf.ByteString
      getRoomsAvailableBytes();
}