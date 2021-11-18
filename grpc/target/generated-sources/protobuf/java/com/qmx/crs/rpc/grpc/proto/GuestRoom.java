// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pms.proto

package com.qmx.crs.rpc.grpc.proto;

/**
 * Protobuf type {@code GuestRoom}
 */
public final class GuestRoom extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GuestRoom)
    GuestRoomOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GuestRoom.newBuilder() to construct.
  private GuestRoom(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GuestRoom() {
    code_ = "";
    descriptiveText_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GuestRoom();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GuestRoom(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            code_ = s;
            break;
          }
          case 16: {

            quantity_ = input.readInt32();
            break;
          }
          case 24: {

            maxOccupancy_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            descriptiveText_ = s;
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
    return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_GuestRoom_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_GuestRoom_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.qmx.crs.rpc.grpc.proto.GuestRoom.class, com.qmx.crs.rpc.grpc.proto.GuestRoom.Builder.class);
  }

  public static final int CODE_FIELD_NUMBER = 1;
  private volatile java.lang.Object code_;
  /**
   * <pre>
   *房型代码
   * </pre>
   *
   * <code>string code = 1;</code>
   * @return The code.
   */
  @java.lang.Override
  public java.lang.String getCode() {
    java.lang.Object ref = code_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      code_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *房型代码
   * </pre>
   *
   * <code>string code = 1;</code>
   * @return The bytes for code.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCodeBytes() {
    java.lang.Object ref = code_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      code_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QUANTITY_FIELD_NUMBER = 2;
  private int quantity_;
  /**
   * <pre>
   *改房型房间数量
   * </pre>
   *
   * <code>int32 quantity = 2;</code>
   * @return The quantity.
   */
  @java.lang.Override
  public int getQuantity() {
    return quantity_;
  }

  public static final int MAXOCCUPANCY_FIELD_NUMBER = 3;
  private int maxOccupancy_;
  /**
   * <pre>
   *最大入住人数
   * </pre>
   *
   * <code>int32 maxOccupancy = 3;</code>
   * @return The maxOccupancy.
   */
  @java.lang.Override
  public int getMaxOccupancy() {
    return maxOccupancy_;
  }

  public static final int DESCRIPTIVETEXT_FIELD_NUMBER = 4;
  private volatile java.lang.Object descriptiveText_;
  /**
   * <pre>
   *房型描述
   * </pre>
   *
   * <code>string descriptiveText = 4;</code>
   * @return The descriptiveText.
   */
  @java.lang.Override
  public java.lang.String getDescriptiveText() {
    java.lang.Object ref = descriptiveText_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      descriptiveText_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *房型描述
   * </pre>
   *
   * <code>string descriptiveText = 4;</code>
   * @return The bytes for descriptiveText.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDescriptiveTextBytes() {
    java.lang.Object ref = descriptiveText_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      descriptiveText_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(code_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, code_);
    }
    if (quantity_ != 0) {
      output.writeInt32(2, quantity_);
    }
    if (maxOccupancy_ != 0) {
      output.writeInt32(3, maxOccupancy_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(descriptiveText_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, descriptiveText_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(code_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, code_);
    }
    if (quantity_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, quantity_);
    }
    if (maxOccupancy_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, maxOccupancy_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(descriptiveText_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, descriptiveText_);
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
    if (!(obj instanceof com.qmx.crs.rpc.grpc.proto.GuestRoom)) {
      return super.equals(obj);
    }
    com.qmx.crs.rpc.grpc.proto.GuestRoom other = (com.qmx.crs.rpc.grpc.proto.GuestRoom) obj;

    if (!getCode()
        .equals(other.getCode())) return false;
    if (getQuantity()
        != other.getQuantity()) return false;
    if (getMaxOccupancy()
        != other.getMaxOccupancy()) return false;
    if (!getDescriptiveText()
        .equals(other.getDescriptiveText())) return false;
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
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode().hashCode();
    hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
    hash = (53 * hash) + getQuantity();
    hash = (37 * hash) + MAXOCCUPANCY_FIELD_NUMBER;
    hash = (53 * hash) + getMaxOccupancy();
    hash = (37 * hash) + DESCRIPTIVETEXT_FIELD_NUMBER;
    hash = (53 * hash) + getDescriptiveText().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.qmx.crs.rpc.grpc.proto.GuestRoom parseFrom(
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
  public static Builder newBuilder(com.qmx.crs.rpc.grpc.proto.GuestRoom prototype) {
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
   * Protobuf type {@code GuestRoom}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GuestRoom)
      com.qmx.crs.rpc.grpc.proto.GuestRoomOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_GuestRoom_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_GuestRoom_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.qmx.crs.rpc.grpc.proto.GuestRoom.class, com.qmx.crs.rpc.grpc.proto.GuestRoom.Builder.class);
    }

    // Construct using com.qmx.crs.rpc.grpc.proto.GuestRoom.newBuilder()
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
      code_ = "";

      quantity_ = 0;

      maxOccupancy_ = 0;

      descriptiveText_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.qmx.crs.rpc.grpc.proto.CrsService.internal_static_GuestRoom_descriptor;
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.GuestRoom getDefaultInstanceForType() {
      return com.qmx.crs.rpc.grpc.proto.GuestRoom.getDefaultInstance();
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.GuestRoom build() {
      com.qmx.crs.rpc.grpc.proto.GuestRoom result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.qmx.crs.rpc.grpc.proto.GuestRoom buildPartial() {
      com.qmx.crs.rpc.grpc.proto.GuestRoom result = new com.qmx.crs.rpc.grpc.proto.GuestRoom(this);
      result.code_ = code_;
      result.quantity_ = quantity_;
      result.maxOccupancy_ = maxOccupancy_;
      result.descriptiveText_ = descriptiveText_;
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
      if (other instanceof com.qmx.crs.rpc.grpc.proto.GuestRoom) {
        return mergeFrom((com.qmx.crs.rpc.grpc.proto.GuestRoom)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.qmx.crs.rpc.grpc.proto.GuestRoom other) {
      if (other == com.qmx.crs.rpc.grpc.proto.GuestRoom.getDefaultInstance()) return this;
      if (!other.getCode().isEmpty()) {
        code_ = other.code_;
        onChanged();
      }
      if (other.getQuantity() != 0) {
        setQuantity(other.getQuantity());
      }
      if (other.getMaxOccupancy() != 0) {
        setMaxOccupancy(other.getMaxOccupancy());
      }
      if (!other.getDescriptiveText().isEmpty()) {
        descriptiveText_ = other.descriptiveText_;
        onChanged();
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
      com.qmx.crs.rpc.grpc.proto.GuestRoom parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.qmx.crs.rpc.grpc.proto.GuestRoom) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object code_ = "";
    /**
     * <pre>
     *房型代码
     * </pre>
     *
     * <code>string code = 1;</code>
     * @return The code.
     */
    public java.lang.String getCode() {
      java.lang.Object ref = code_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        code_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *房型代码
     * </pre>
     *
     * <code>string code = 1;</code>
     * @return The bytes for code.
     */
    public com.google.protobuf.ByteString
        getCodeBytes() {
      java.lang.Object ref = code_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        code_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *房型代码
     * </pre>
     *
     * <code>string code = 1;</code>
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *房型代码
     * </pre>
     *
     * <code>string code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCode() {
      
      code_ = getDefaultInstance().getCode();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *房型代码
     * </pre>
     *
     * <code>string code = 1;</code>
     * @param value The bytes for code to set.
     * @return This builder for chaining.
     */
    public Builder setCodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      code_ = value;
      onChanged();
      return this;
    }

    private int quantity_ ;
    /**
     * <pre>
     *改房型房间数量
     * </pre>
     *
     * <code>int32 quantity = 2;</code>
     * @return The quantity.
     */
    @java.lang.Override
    public int getQuantity() {
      return quantity_;
    }
    /**
     * <pre>
     *改房型房间数量
     * </pre>
     *
     * <code>int32 quantity = 2;</code>
     * @param value The quantity to set.
     * @return This builder for chaining.
     */
    public Builder setQuantity(int value) {
      
      quantity_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *改房型房间数量
     * </pre>
     *
     * <code>int32 quantity = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearQuantity() {
      
      quantity_ = 0;
      onChanged();
      return this;
    }

    private int maxOccupancy_ ;
    /**
     * <pre>
     *最大入住人数
     * </pre>
     *
     * <code>int32 maxOccupancy = 3;</code>
     * @return The maxOccupancy.
     */
    @java.lang.Override
    public int getMaxOccupancy() {
      return maxOccupancy_;
    }
    /**
     * <pre>
     *最大入住人数
     * </pre>
     *
     * <code>int32 maxOccupancy = 3;</code>
     * @param value The maxOccupancy to set.
     * @return This builder for chaining.
     */
    public Builder setMaxOccupancy(int value) {
      
      maxOccupancy_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *最大入住人数
     * </pre>
     *
     * <code>int32 maxOccupancy = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearMaxOccupancy() {
      
      maxOccupancy_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object descriptiveText_ = "";
    /**
     * <pre>
     *房型描述
     * </pre>
     *
     * <code>string descriptiveText = 4;</code>
     * @return The descriptiveText.
     */
    public java.lang.String getDescriptiveText() {
      java.lang.Object ref = descriptiveText_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        descriptiveText_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *房型描述
     * </pre>
     *
     * <code>string descriptiveText = 4;</code>
     * @return The bytes for descriptiveText.
     */
    public com.google.protobuf.ByteString
        getDescriptiveTextBytes() {
      java.lang.Object ref = descriptiveText_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        descriptiveText_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *房型描述
     * </pre>
     *
     * <code>string descriptiveText = 4;</code>
     * @param value The descriptiveText to set.
     * @return This builder for chaining.
     */
    public Builder setDescriptiveText(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      descriptiveText_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *房型描述
     * </pre>
     *
     * <code>string descriptiveText = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearDescriptiveText() {
      
      descriptiveText_ = getDefaultInstance().getDescriptiveText();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *房型描述
     * </pre>
     *
     * <code>string descriptiveText = 4;</code>
     * @param value The bytes for descriptiveText to set.
     * @return This builder for chaining.
     */
    public Builder setDescriptiveTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      descriptiveText_ = value;
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


    // @@protoc_insertion_point(builder_scope:GuestRoom)
  }

  // @@protoc_insertion_point(class_scope:GuestRoom)
  private static final com.qmx.crs.rpc.grpc.proto.GuestRoom DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.qmx.crs.rpc.grpc.proto.GuestRoom();
  }

  public static com.qmx.crs.rpc.grpc.proto.GuestRoom getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GuestRoom>
      PARSER = new com.google.protobuf.AbstractParser<GuestRoom>() {
    @java.lang.Override
    public GuestRoom parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GuestRoom(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GuestRoom> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GuestRoom> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.qmx.crs.rpc.grpc.proto.GuestRoom getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
