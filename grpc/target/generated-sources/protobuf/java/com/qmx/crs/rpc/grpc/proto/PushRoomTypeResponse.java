// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pms.proto

package com.qmx.crs.rpc.grpc.proto;

/**
 * <pre>
 *请求房型的响应参数
 * </pre>
 *
 * Protobuf type {@code PushRoomTypeResponse}
 */
public final class PushRoomTypeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:PushRoomTypeResponse)
    PushRoomTypeResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PushRoomTypeResponse.newBuilder() to construct.
  private PushRoomTypeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PushRoomTypeResponse() {
    target_ = 0;
    resultStatusCode_ = 0;
    errors_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PushRoomTypeResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PushRoomTypeResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {

            version_ = input.readDouble();
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            target_ = rawValue;
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            resultStatusCode_ = rawValue;
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              errors_ = new java.util.ArrayList<com.qmx.crs.rpc.grpc.proto.Error>();
              mutable_bitField0_ |= 0x00000001;
            }
            errors_.add(
                input.readMessage(com.qmx.crs.rpc.grpc.proto.Error.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        errors_ = java.util.Collections.unmodifiableList(errors_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_PushRoomTypeResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_PushRoomTypeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse.class, com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse.Builder.class);
  }

  public static final int VERSION_FIELD_NUMBER = 1;
  private double version_;
  /**
   * <pre>
   *消息版本
   * </pre>
   *
   * <code>double version = 1;</code>
   * @return The version.
   */
  @java.lang.Override
  public double getVersion() {
    return version_;
  }

  public static final int TARGET_FIELD_NUMBER = 2;
  private int target_;
  /**
   * <pre>
   *环境
   * </pre>
   *
   * <code>.Target target = 2;</code>
   * @return The enum numeric value on the wire for target.
   */
  @java.lang.Override public int getTargetValue() {
    return target_;
  }
  /**
   * <pre>
   *环境
   * </pre>
   *
   * <code>.Target target = 2;</code>
   * @return The target.
   */
  @java.lang.Override public com.qmx.crs.rpc.grpc.proto.Target getTarget() {
    @SuppressWarnings("deprecation")
    com.qmx.crs.rpc.grpc.proto.Target result = com.qmx.crs.rpc.grpc.proto.Target.valueOf(target_);
    return result == null ? com.qmx.crs.rpc.grpc.proto.Target.UNRECOGNIZED : result;
  }

  public static final int RESULTSTATUSCODE_FIELD_NUMBER = 3;
  private int resultStatusCode_;
  /**
   * <pre>
   *结果代码
   * </pre>
   *
   * <code>.ResultStatusCode resultStatusCode = 3;</code>
   * @return The enum numeric value on the wire for resultStatusCode.
   */
  @java.lang.Override public int getResultStatusCodeValue() {
    return resultStatusCode_;
  }
  /**
   * <pre>
   *结果代码
   * </pre>
   *
   * <code>.ResultStatusCode resultStatusCode = 3;</code>
   * @return The resultStatusCode.
   */
  @java.lang.Override public com.qmx.crs.rpc.grpc.proto.ResultStatusCode getResultStatusCode() {
    @SuppressWarnings("deprecation")
    com.qmx.crs.rpc.grpc.proto.ResultStatusCode result = com.qmx.crs.rpc.grpc.proto.ResultStatusCode.valueOf(resultStatusCode_);
    return result == null ? com.qmx.crs.rpc.grpc.proto.ResultStatusCode.UNRECOGNIZED : result;
  }

  public static final int ERRORS_FIELD_NUMBER = 4;
  private java.util.List<com.qmx.crs.rpc.grpc.proto.Error> errors_;
  /**
   * <pre>
   *错误信息列表
   * </pre>
   *
   * <code>repeated .Error errors = 4;</code>
   */
  @java.lang.Override
  public java.util.List<com.qmx.crs.rpc.grpc.proto.Error> getErrorsList() {
    return errors_;
  }
  /**
   * <pre>
   *错误信息列表
   * </pre>
   *
   * <code>repeated .Error errors = 4;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.qmx.crs.rpc.grpc.proto.ErrorOrBuilder> 
      getErrorsOrBuilderList() {
    return errors_;
  }
  /**
   * <pre>
   *错误信息列表
   * </pre>
   *
   * <code>repeated .Error errors = 4;</code>
   */
  @java.lang.Override
  public int getErrorsCount() {
    return errors_.size();
  }
  /**
   * <pre>
   *错误信息列表
   * </pre>
   *
   * <code>repeated .Error errors = 4;</code>
   */
  @java.lang.Override
  public com.qmx.crs.rpc.grpc.proto.Error getErrors(int index) {
    return errors_.get(index);
  }
  /**
   * <pre>
   *错误信息列表
   * </pre>
   *
   * <code>repeated .Error errors = 4;</code>
   */
  @java.lang.Override
  public com.qmx.crs.rpc.grpc.proto.ErrorOrBuilder getErrorsOrBuilder(
      int index) {
    return errors_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (version_ != 0D) {
      output.writeDouble(1, version_);
    }
    if (target_ != com.qmx.crs.rpc.grpc.proto.Target.Production.getNumber()) {
      output.writeEnum(2, target_);
    }
    if (resultStatusCode_ != com.qmx.crs.rpc.grpc.proto.ResultStatusCode.Success.getNumber()) {
      output.writeEnum(3, resultStatusCode_);
    }
    for (int i = 0; i < errors_.size(); i++) {
      output.writeMessage(4, errors_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (version_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, version_);
    }
    if (target_ != com.qmx.crs.rpc.grpc.proto.Target.Production.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, target_);
    }
    if (resultStatusCode_ != com.qmx.crs.rpc.grpc.proto.ResultStatusCode.Success.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, resultStatusCode_);
    }
    for (int i = 0; i < errors_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, errors_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse)) {
      return super.equals(obj);
    }
    com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse other = (com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse) obj;

    if (java.lang.Double.doubleToLongBits(getVersion())
        != java.lang.Double.doubleToLongBits(
            other.getVersion())) return false;
    if (target_ != other.target_) return false;
    if (resultStatusCode_ != other.resultStatusCode_) return false;
    if (!getErrorsList()
        .equals(other.getErrorsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getVersion()));
    hash = (37 * hash) + TARGET_FIELD_NUMBER;
    hash = (53 * hash) + target_;
    hash = (37 * hash) + RESULTSTATUSCODE_FIELD_NUMBER;
    hash = (53 * hash) + resultStatusCode_;
    if (getErrorsCount() > 0) {
      hash = (37 * hash) + ERRORS_FIELD_NUMBER;
      hash = (53 * hash) + getErrorsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *请求房型的响应参数
   * </pre>
   *
   * Protobuf type {@code PushRoomTypeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:PushRoomTypeResponse)
      com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_PushRoomTypeResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_PushRoomTypeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse.class, com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse.Builder.class);
    }

    // Construct using com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getErrorsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      version_ = 0D;

      target_ = 0;

      resultStatusCode_ = 0;

      if (errorsBuilder_ == null) {
        errors_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        errorsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_PushRoomTypeResponse_descriptor;
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse getDefaultInstanceForType() {
      return com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse build() {
      com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse buildPartial() {
      com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse result = new com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse(this);
      int from_bitField0_ = bitField0_;
      result.version_ = version_;
      result.target_ = target_;
      result.resultStatusCode_ = resultStatusCode_;
      if (errorsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          errors_ = java.util.Collections.unmodifiableList(errors_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.errors_ = errors_;
      } else {
        result.errors_ = errorsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse) {
        return mergeFrom((com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse other) {
      if (other == com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse.getDefaultInstance()) return this;
      if (other.getVersion() != 0D) {
        setVersion(other.getVersion());
      }
      if (other.target_ != 0) {
        setTargetValue(other.getTargetValue());
      }
      if (other.resultStatusCode_ != 0) {
        setResultStatusCodeValue(other.getResultStatusCodeValue());
      }
      if (errorsBuilder_ == null) {
        if (!other.errors_.isEmpty()) {
          if (errors_.isEmpty()) {
            errors_ = other.errors_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureErrorsIsMutable();
            errors_.addAll(other.errors_);
          }
          onChanged();
        }
      } else {
        if (!other.errors_.isEmpty()) {
          if (errorsBuilder_.isEmpty()) {
            errorsBuilder_.dispose();
            errorsBuilder_ = null;
            errors_ = other.errors_;
            bitField0_ = (bitField0_ & ~0x00000001);
            errorsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getErrorsFieldBuilder() : null;
          } else {
            errorsBuilder_.addAllMessages(other.errors_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private double version_ ;
    /**
     * <pre>
     *消息版本
     * </pre>
     *
     * <code>double version = 1;</code>
     * @return The version.
     */
    @java.lang.Override
    public double getVersion() {
      return version_;
    }
    /**
     * <pre>
     *消息版本
     * </pre>
     *
     * <code>double version = 1;</code>
     * @param value The version to set.
     * @return This builder for chaining.
     */
    public Builder setVersion(double value) {
      
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *消息版本
     * </pre>
     *
     * <code>double version = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearVersion() {
      
      version_ = 0D;
      onChanged();
      return this;
    }

    private int target_ = 0;
    /**
     * <pre>
     *环境
     * </pre>
     *
     * <code>.Target target = 2;</code>
     * @return The enum numeric value on the wire for target.
     */
    @java.lang.Override public int getTargetValue() {
      return target_;
    }
    /**
     * <pre>
     *环境
     * </pre>
     *
     * <code>.Target target = 2;</code>
     * @param value The enum numeric value on the wire for target to set.
     * @return This builder for chaining.
     */
    public Builder setTargetValue(int value) {
      
      target_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *环境
     * </pre>
     *
     * <code>.Target target = 2;</code>
     * @return The target.
     */
    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.Target getTarget() {
      @SuppressWarnings("deprecation")
      com.qmx.crs.rpc.grpc.proto.Target result = com.qmx.crs.rpc.grpc.proto.Target.valueOf(target_);
      return result == null ? com.qmx.crs.rpc.grpc.proto.Target.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     *环境
     * </pre>
     *
     * <code>.Target target = 2;</code>
     * @param value The target to set.
     * @return This builder for chaining.
     */
    public Builder setTarget(com.qmx.crs.rpc.grpc.proto.Target value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      target_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *环境
     * </pre>
     *
     * <code>.Target target = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTarget() {
      
      target_ = 0;
      onChanged();
      return this;
    }

    private int resultStatusCode_ = 0;
    /**
     * <pre>
     *结果代码
     * </pre>
     *
     * <code>.ResultStatusCode resultStatusCode = 3;</code>
     * @return The enum numeric value on the wire for resultStatusCode.
     */
    @java.lang.Override public int getResultStatusCodeValue() {
      return resultStatusCode_;
    }
    /**
     * <pre>
     *结果代码
     * </pre>
     *
     * <code>.ResultStatusCode resultStatusCode = 3;</code>
     * @param value The enum numeric value on the wire for resultStatusCode to set.
     * @return This builder for chaining.
     */
    public Builder setResultStatusCodeValue(int value) {
      
      resultStatusCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *结果代码
     * </pre>
     *
     * <code>.ResultStatusCode resultStatusCode = 3;</code>
     * @return The resultStatusCode.
     */
    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.ResultStatusCode getResultStatusCode() {
      @SuppressWarnings("deprecation")
      com.qmx.crs.rpc.grpc.proto.ResultStatusCode result = com.qmx.crs.rpc.grpc.proto.ResultStatusCode.valueOf(resultStatusCode_);
      return result == null ? com.qmx.crs.rpc.grpc.proto.ResultStatusCode.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     *结果代码
     * </pre>
     *
     * <code>.ResultStatusCode resultStatusCode = 3;</code>
     * @param value The resultStatusCode to set.
     * @return This builder for chaining.
     */
    public Builder setResultStatusCode(com.qmx.crs.rpc.grpc.proto.ResultStatusCode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      resultStatusCode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *结果代码
     * </pre>
     *
     * <code>.ResultStatusCode resultStatusCode = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearResultStatusCode() {
      
      resultStatusCode_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<com.qmx.crs.rpc.grpc.proto.Error> errors_ =
      java.util.Collections.emptyList();
    private void ensureErrorsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        errors_ = new java.util.ArrayList<com.qmx.crs.rpc.grpc.proto.Error>(errors_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.qmx.crs.rpc.grpc.proto.Error, com.qmx.crs.rpc.grpc.proto.Error.Builder, com.qmx.crs.rpc.grpc.proto.ErrorOrBuilder> errorsBuilder_;

    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public java.util.List<com.qmx.crs.rpc.grpc.proto.Error> getErrorsList() {
      if (errorsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(errors_);
      } else {
        return errorsBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public int getErrorsCount() {
      if (errorsBuilder_ == null) {
        return errors_.size();
      } else {
        return errorsBuilder_.getCount();
      }
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public com.qmx.crs.rpc.grpc.proto.Error getErrors(int index) {
      if (errorsBuilder_ == null) {
        return errors_.get(index);
      } else {
        return errorsBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder setErrors(
        int index, com.qmx.crs.rpc.grpc.proto.Error value) {
      if (errorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureErrorsIsMutable();
        errors_.set(index, value);
        onChanged();
      } else {
        errorsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder setErrors(
        int index, com.qmx.crs.rpc.grpc.proto.Error.Builder builderForValue) {
      if (errorsBuilder_ == null) {
        ensureErrorsIsMutable();
        errors_.set(index, builderForValue.build());
        onChanged();
      } else {
        errorsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder addErrors(com.qmx.crs.rpc.grpc.proto.Error value) {
      if (errorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureErrorsIsMutable();
        errors_.add(value);
        onChanged();
      } else {
        errorsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder addErrors(
        int index, com.qmx.crs.rpc.grpc.proto.Error value) {
      if (errorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureErrorsIsMutable();
        errors_.add(index, value);
        onChanged();
      } else {
        errorsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder addErrors(
        com.qmx.crs.rpc.grpc.proto.Error.Builder builderForValue) {
      if (errorsBuilder_ == null) {
        ensureErrorsIsMutable();
        errors_.add(builderForValue.build());
        onChanged();
      } else {
        errorsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder addErrors(
        int index, com.qmx.crs.rpc.grpc.proto.Error.Builder builderForValue) {
      if (errorsBuilder_ == null) {
        ensureErrorsIsMutable();
        errors_.add(index, builderForValue.build());
        onChanged();
      } else {
        errorsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder addAllErrors(
        java.lang.Iterable<? extends com.qmx.crs.rpc.grpc.proto.Error> values) {
      if (errorsBuilder_ == null) {
        ensureErrorsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, errors_);
        onChanged();
      } else {
        errorsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder clearErrors() {
      if (errorsBuilder_ == null) {
        errors_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        errorsBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public Builder removeErrors(int index) {
      if (errorsBuilder_ == null) {
        ensureErrorsIsMutable();
        errors_.remove(index);
        onChanged();
      } else {
        errorsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public com.qmx.crs.rpc.grpc.proto.Error.Builder getErrorsBuilder(
        int index) {
      return getErrorsFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public com.qmx.crs.rpc.grpc.proto.ErrorOrBuilder getErrorsOrBuilder(
        int index) {
      if (errorsBuilder_ == null) {
        return errors_.get(index);  } else {
        return errorsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public java.util.List<? extends com.qmx.crs.rpc.grpc.proto.ErrorOrBuilder> 
         getErrorsOrBuilderList() {
      if (errorsBuilder_ != null) {
        return errorsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(errors_);
      }
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public com.qmx.crs.rpc.grpc.proto.Error.Builder addErrorsBuilder() {
      return getErrorsFieldBuilder().addBuilder(
          com.qmx.crs.rpc.grpc.proto.Error.getDefaultInstance());
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public com.qmx.crs.rpc.grpc.proto.Error.Builder addErrorsBuilder(
        int index) {
      return getErrorsFieldBuilder().addBuilder(
          index, com.qmx.crs.rpc.grpc.proto.Error.getDefaultInstance());
    }
    /**
     * <pre>
     *错误信息列表
     * </pre>
     *
     * <code>repeated .Error errors = 4;</code>
     */
    public java.util.List<com.qmx.crs.rpc.grpc.proto.Error.Builder> 
         getErrorsBuilderList() {
      return getErrorsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.qmx.crs.rpc.grpc.proto.Error, com.qmx.crs.rpc.grpc.proto.Error.Builder, com.qmx.crs.rpc.grpc.proto.ErrorOrBuilder> 
        getErrorsFieldBuilder() {
      if (errorsBuilder_ == null) {
        errorsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.qmx.crs.rpc.grpc.proto.Error, com.qmx.crs.rpc.grpc.proto.Error.Builder, com.qmx.crs.rpc.grpc.proto.ErrorOrBuilder>(
                errors_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        errors_ = null;
      }
      return errorsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:PushRoomTypeResponse)
  }

  // @@protoc_insertion_point(class_scope:PushRoomTypeResponse)
  private static final com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse();
  }

  public static com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PushRoomTypeResponse>
      PARSER = new com.google.protobuf.AbstractParser<PushRoomTypeResponse>() {
    @java.lang.Override
    public PushRoomTypeResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PushRoomTypeResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PushRoomTypeResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PushRoomTypeResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.qmx.crs.rpc.grpc.proto.PushRoomTypeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
