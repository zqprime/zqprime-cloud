// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pms.proto

package com.qmx.crs.rpc.grpc.proto;

/**
 * <pre>
 *登录后的jwt数据
 * </pre>
 *
 * Protobuf type {@code Token}
 */
public final class Token extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Token)
    TokenOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Token.newBuilder() to construct.
  private Token(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Token() {
    jwt_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Token();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Token(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
          case 8: {

            status_ = input.readBool();
            break;
          }
          case 18: {

            jwt_ = input.readBytes();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_Token_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_Token_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.qmx.crs.rpc.grpc.proto.Token.class, com.qmx.crs.rpc.grpc.proto.Token.Builder.class);
  }

  public static final int STATUS_FIELD_NUMBER = 1;
  private boolean status_;
  /**
   * <pre>
   *是否成功
   * </pre>
   *
   * <code>bool status = 1;</code>
   * @return The status.
   */
  @java.lang.Override
  public boolean getStatus() {
    return status_;
  }

  public static final int JWT_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString jwt_;
  /**
   * <pre>
   *登录成功后的凭证
   * </pre>
   *
   * <code>bytes jwt = 2;</code>
   * @return The jwt.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getJwt() {
    return jwt_;
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
    if (status_ != false) {
      output.writeBool(1, status_);
    }
    if (!jwt_.isEmpty()) {
      output.writeBytes(2, jwt_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, status_);
    }
    if (!jwt_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, jwt_);
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
    if (!(obj instanceof com.qmx.crs.rpc.grpc.proto.Token)) {
      return super.equals(obj);
    }
    com.qmx.crs.rpc.grpc.proto.Token other = (com.qmx.crs.rpc.grpc.proto.Token) obj;

    if (getStatus()
        != other.getStatus()) return false;
    if (!getJwt()
        .equals(other.getJwt())) return false;
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
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getStatus());
    hash = (37 * hash) + JWT_FIELD_NUMBER;
    hash = (53 * hash) + getJwt().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.Token parseFrom(
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
  public static Builder newBuilder(com.qmx.crs.rpc.grpc.proto.Token prototype) {
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
   *登录后的jwt数据
   * </pre>
   *
   * Protobuf type {@code Token}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Token)
      com.qmx.crs.rpc.grpc.proto.TokenOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_Token_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_Token_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.qmx.crs.rpc.grpc.proto.Token.class, com.qmx.crs.rpc.grpc.proto.Token.Builder.class);
    }

    // Construct using com.qmx.crs.rpc.grpc.proto.Token.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      status_ = false;

      jwt_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_Token_descriptor;
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.Token getDefaultInstanceForType() {
      return com.qmx.crs.rpc.grpc.proto.Token.getDefaultInstance();
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.Token build() {
      com.qmx.crs.rpc.grpc.proto.Token result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.Token buildPartial() {
      com.qmx.crs.rpc.grpc.proto.Token result = new com.qmx.crs.rpc.grpc.proto.Token(this);
      result.status_ = status_;
      result.jwt_ = jwt_;
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
      if (other instanceof com.qmx.crs.rpc.grpc.proto.Token) {
        return mergeFrom((com.qmx.crs.rpc.grpc.proto.Token)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.qmx.crs.rpc.grpc.proto.Token other) {
      if (other == com.qmx.crs.rpc.grpc.proto.Token.getDefaultInstance()) return this;
      if (other.getStatus() != false) {
        setStatus(other.getStatus());
      }
      if (other.getJwt() != com.google.protobuf.ByteString.EMPTY) {
        setJwt(other.getJwt());
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
      com.qmx.crs.rpc.grpc.proto.Token parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.qmx.crs.rpc.grpc.proto.Token) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean status_ ;
    /**
     * <pre>
     *是否成功
     * </pre>
     *
     * <code>bool status = 1;</code>
     * @return The status.
     */
    @java.lang.Override
    public boolean getStatus() {
      return status_;
    }
    /**
     * <pre>
     *是否成功
     * </pre>
     *
     * <code>bool status = 1;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(boolean value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *是否成功
     * </pre>
     *
     * <code>bool status = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = false;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString jwt_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     *登录成功后的凭证
     * </pre>
     *
     * <code>bytes jwt = 2;</code>
     * @return The jwt.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getJwt() {
      return jwt_;
    }
    /**
     * <pre>
     *登录成功后的凭证
     * </pre>
     *
     * <code>bytes jwt = 2;</code>
     * @param value The jwt to set.
     * @return This builder for chaining.
     */
    public Builder setJwt(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      jwt_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *登录成功后的凭证
     * </pre>
     *
     * <code>bytes jwt = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearJwt() {
      
      jwt_ = getDefaultInstance().getJwt();
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:Token)
  }

  // @@protoc_insertion_point(class_scope:Token)
  private static final com.qmx.crs.rpc.grpc.proto.Token DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.qmx.crs.rpc.grpc.proto.Token();
  }

  public static com.qmx.crs.rpc.grpc.proto.Token getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Token>
      PARSER = new com.google.protobuf.AbstractParser<Token>() {
    @java.lang.Override
    public Token parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Token(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Token> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Token> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.qmx.crs.rpc.grpc.proto.Token getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
