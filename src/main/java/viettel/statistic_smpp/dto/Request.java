// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package viettel.statistic_smpp.dto;

/**
 * Protobuf type {@code tutorial.Request}
 */
public final class Request extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tutorial.Request)
    RequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Request.newBuilder() to construct.
  private Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Request() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Request();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Request(
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
          case 10: {
            viettel.statistic_smpp.dto.Header.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) != 0)) {
              subBuilder = header_.toBuilder();
            }
            header_ = input.readMessage(viettel.statistic_smpp.dto.Header.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(header_);
              header_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 18: {
            viettel.statistic_smpp.dto.Body.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) != 0)) {
              subBuilder = body_.toBuilder();
            }
            body_ = input.readMessage(viettel.statistic_smpp.dto.Body.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(body_);
              body_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
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
    return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Request_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Request_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            viettel.statistic_smpp.dto.Request.class, viettel.statistic_smpp.dto.Request.Builder.class);
  }

  private int bitField0_;
  public static final int HEADER_FIELD_NUMBER = 1;
  private viettel.statistic_smpp.dto.Header header_;
  /**
   * <code>optional .tutorial.Header header = 1;</code>
   * @return Whether the header field is set.
   */
  @java.lang.Override
  public boolean hasHeader() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .tutorial.Header header = 1;</code>
   * @return The header.
   */
  @java.lang.Override
  public viettel.statistic_smpp.dto.Header getHeader() {
    return header_ == null ? viettel.statistic_smpp.dto.Header.getDefaultInstance() : header_;
  }
  /**
   * <code>optional .tutorial.Header header = 1;</code>
   */
  @java.lang.Override
  public viettel.statistic_smpp.dto.HeaderOrBuilder getHeaderOrBuilder() {
    return header_ == null ? viettel.statistic_smpp.dto.Header.getDefaultInstance() : header_;
  }

  public static final int BODY_FIELD_NUMBER = 2;
  private viettel.statistic_smpp.dto.Body body_;
  /**
   * <code>optional .tutorial.Body body = 2;</code>
   * @return Whether the body field is set.
   */
  @java.lang.Override
  public boolean hasBody() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional .tutorial.Body body = 2;</code>
   * @return The body.
   */
  @java.lang.Override
  public viettel.statistic_smpp.dto.Body getBody() {
    return body_ == null ? viettel.statistic_smpp.dto.Body.getDefaultInstance() : body_;
  }
  /**
   * <code>optional .tutorial.Body body = 2;</code>
   */
  @java.lang.Override
  public viettel.statistic_smpp.dto.BodyOrBuilder getBodyOrBuilder() {
    return body_ == null ? viettel.statistic_smpp.dto.Body.getDefaultInstance() : body_;
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
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getHeader());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(2, getBody());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getHeader());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getBody());
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
    if (!(obj instanceof viettel.statistic_smpp.dto.Request)) {
      return super.equals(obj);
    }
    viettel.statistic_smpp.dto.Request other = (viettel.statistic_smpp.dto.Request) obj;

    if (hasHeader() != other.hasHeader()) return false;
    if (hasHeader()) {
      if (!getHeader()
          .equals(other.getHeader())) return false;
    }
    if (hasBody() != other.hasBody()) return false;
    if (hasBody()) {
      if (!getBody()
          .equals(other.getBody())) return false;
    }
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
    if (hasHeader()) {
      hash = (37 * hash) + HEADER_FIELD_NUMBER;
      hash = (53 * hash) + getHeader().hashCode();
    }
    if (hasBody()) {
      hash = (37 * hash) + BODY_FIELD_NUMBER;
      hash = (53 * hash) + getBody().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static viettel.statistic_smpp.dto.Request parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Request parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static viettel.statistic_smpp.dto.Request parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static viettel.statistic_smpp.dto.Request parseFrom(
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
  public static Builder newBuilder(viettel.statistic_smpp.dto.Request prototype) {
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
   * Protobuf type {@code tutorial.Request}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tutorial.Request)
      viettel.statistic_smpp.dto.RequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Request_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              viettel.statistic_smpp.dto.Request.class, viettel.statistic_smpp.dto.Request.Builder.class);
    }

    // Construct using viettel.statistic_smpp.dto.Request.newBuilder()
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
        getHeaderFieldBuilder();
        getBodyFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (headerBuilder_ == null) {
        header_ = null;
      } else {
        headerBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      if (bodyBuilder_ == null) {
        body_ = null;
      } else {
        bodyBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Request_descriptor;
    }

    @java.lang.Override
    public viettel.statistic_smpp.dto.Request getDefaultInstanceForType() {
      return viettel.statistic_smpp.dto.Request.getDefaultInstance();
    }

    @java.lang.Override
    public viettel.statistic_smpp.dto.Request build() {
      viettel.statistic_smpp.dto.Request result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public viettel.statistic_smpp.dto.Request buildPartial() {
      viettel.statistic_smpp.dto.Request result = new viettel.statistic_smpp.dto.Request(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (headerBuilder_ == null) {
          result.header_ = header_;
        } else {
          result.header_ = headerBuilder_.build();
        }
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        if (bodyBuilder_ == null) {
          result.body_ = body_;
        } else {
          result.body_ = bodyBuilder_.build();
        }
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof viettel.statistic_smpp.dto.Request) {
        return mergeFrom((viettel.statistic_smpp.dto.Request)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(viettel.statistic_smpp.dto.Request other) {
      if (other == viettel.statistic_smpp.dto.Request.getDefaultInstance()) return this;
      if (other.hasHeader()) {
        mergeHeader(other.getHeader());
      }
      if (other.hasBody()) {
        mergeBody(other.getBody());
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
      viettel.statistic_smpp.dto.Request parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (viettel.statistic_smpp.dto.Request) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private viettel.statistic_smpp.dto.Header header_;
    private com.google.protobuf.SingleFieldBuilderV3<
        viettel.statistic_smpp.dto.Header, viettel.statistic_smpp.dto.Header.Builder, viettel.statistic_smpp.dto.HeaderOrBuilder> headerBuilder_;
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     * @return Whether the header field is set.
     */
    public boolean hasHeader() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     * @return The header.
     */
    public viettel.statistic_smpp.dto.Header getHeader() {
      if (headerBuilder_ == null) {
        return header_ == null ? viettel.statistic_smpp.dto.Header.getDefaultInstance() : header_;
      } else {
        return headerBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     */
    public Builder setHeader(viettel.statistic_smpp.dto.Header value) {
      if (headerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        header_ = value;
        onChanged();
      } else {
        headerBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     */
    public Builder setHeader(
        viettel.statistic_smpp.dto.Header.Builder builderForValue) {
      if (headerBuilder_ == null) {
        header_ = builderForValue.build();
        onChanged();
      } else {
        headerBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     */
    public Builder mergeHeader(viettel.statistic_smpp.dto.Header value) {
      if (headerBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            header_ != null &&
            header_ != viettel.statistic_smpp.dto.Header.getDefaultInstance()) {
          header_ =
            viettel.statistic_smpp.dto.Header.newBuilder(header_).mergeFrom(value).buildPartial();
        } else {
          header_ = value;
        }
        onChanged();
      } else {
        headerBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     */
    public Builder clearHeader() {
      if (headerBuilder_ == null) {
        header_ = null;
        onChanged();
      } else {
        headerBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     */
    public viettel.statistic_smpp.dto.Header.Builder getHeaderBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getHeaderFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     */
    public viettel.statistic_smpp.dto.HeaderOrBuilder getHeaderOrBuilder() {
      if (headerBuilder_ != null) {
        return headerBuilder_.getMessageOrBuilder();
      } else {
        return header_ == null ?
            viettel.statistic_smpp.dto.Header.getDefaultInstance() : header_;
      }
    }
    /**
     * <code>optional .tutorial.Header header = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        viettel.statistic_smpp.dto.Header, viettel.statistic_smpp.dto.Header.Builder, viettel.statistic_smpp.dto.HeaderOrBuilder> 
        getHeaderFieldBuilder() {
      if (headerBuilder_ == null) {
        headerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            viettel.statistic_smpp.dto.Header, viettel.statistic_smpp.dto.Header.Builder, viettel.statistic_smpp.dto.HeaderOrBuilder>(
                getHeader(),
                getParentForChildren(),
                isClean());
        header_ = null;
      }
      return headerBuilder_;
    }

    private viettel.statistic_smpp.dto.Body body_;
    private com.google.protobuf.SingleFieldBuilderV3<
        viettel.statistic_smpp.dto.Body, viettel.statistic_smpp.dto.Body.Builder, viettel.statistic_smpp.dto.BodyOrBuilder> bodyBuilder_;
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     * @return Whether the body field is set.
     */
    public boolean hasBody() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     * @return The body.
     */
    public viettel.statistic_smpp.dto.Body getBody() {
      if (bodyBuilder_ == null) {
        return body_ == null ? viettel.statistic_smpp.dto.Body.getDefaultInstance() : body_;
      } else {
        return bodyBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     */
    public Builder setBody(viettel.statistic_smpp.dto.Body value) {
      if (bodyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        body_ = value;
        onChanged();
      } else {
        bodyBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     */
    public Builder setBody(
        viettel.statistic_smpp.dto.Body.Builder builderForValue) {
      if (bodyBuilder_ == null) {
        body_ = builderForValue.build();
        onChanged();
      } else {
        bodyBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     */
    public Builder mergeBody(viettel.statistic_smpp.dto.Body value) {
      if (bodyBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
            body_ != null &&
            body_ != viettel.statistic_smpp.dto.Body.getDefaultInstance()) {
          body_ =
            viettel.statistic_smpp.dto.Body.newBuilder(body_).mergeFrom(value).buildPartial();
        } else {
          body_ = value;
        }
        onChanged();
      } else {
        bodyBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     */
    public Builder clearBody() {
      if (bodyBuilder_ == null) {
        body_ = null;
        onChanged();
      } else {
        bodyBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     */
    public viettel.statistic_smpp.dto.Body.Builder getBodyBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getBodyFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     */
    public viettel.statistic_smpp.dto.BodyOrBuilder getBodyOrBuilder() {
      if (bodyBuilder_ != null) {
        return bodyBuilder_.getMessageOrBuilder();
      } else {
        return body_ == null ?
            viettel.statistic_smpp.dto.Body.getDefaultInstance() : body_;
      }
    }
    /**
     * <code>optional .tutorial.Body body = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        viettel.statistic_smpp.dto.Body, viettel.statistic_smpp.dto.Body.Builder, viettel.statistic_smpp.dto.BodyOrBuilder> 
        getBodyFieldBuilder() {
      if (bodyBuilder_ == null) {
        bodyBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            viettel.statistic_smpp.dto.Body, viettel.statistic_smpp.dto.Body.Builder, viettel.statistic_smpp.dto.BodyOrBuilder>(
                getBody(),
                getParentForChildren(),
                isClean());
        body_ = null;
      }
      return bodyBuilder_;
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


    // @@protoc_insertion_point(builder_scope:tutorial.Request)
  }

  // @@protoc_insertion_point(class_scope:tutorial.Request)
  private static final viettel.statistic_smpp.dto.Request DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new viettel.statistic_smpp.dto.Request();
  }

  public static viettel.statistic_smpp.dto.Request getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<Request>
      PARSER = new com.google.protobuf.AbstractParser<Request>() {
    @java.lang.Override
    public Request parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Request(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Request> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Request> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public viettel.statistic_smpp.dto.Request getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
