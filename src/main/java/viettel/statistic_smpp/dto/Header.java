// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package viettel.statistic_smpp.dto;

/**
 * Protobuf type {@code tutorial.Header}
 */
public final class Header extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tutorial.Header)
    HeaderOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Header.newBuilder() to construct.
  private Header(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Header() {
    requestCommand_ = "";
    cpId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Header();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Header(
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
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000001;
            requestCommand_ = bs;
            break;
          }
          case 18: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000002;
            cpId_ = bs;
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
    return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Header_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Header_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            viettel.statistic_smpp.dto.Header.class, viettel.statistic_smpp.dto.Header.Builder.class);
  }

  private int bitField0_;
  public static final int REQUESTCOMMAND_FIELD_NUMBER = 1;
  private volatile java.lang.Object requestCommand_;
  /**
   * <code>optional string requestCommand = 1;</code>
   * @return Whether the requestCommand field is set.
   */
  @java.lang.Override
  public boolean hasRequestCommand() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string requestCommand = 1;</code>
   * @return The requestCommand.
   */
  @java.lang.Override
  public java.lang.String getRequestCommand() {
    java.lang.Object ref = requestCommand_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        requestCommand_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string requestCommand = 1;</code>
   * @return The bytes for requestCommand.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getRequestCommandBytes() {
    java.lang.Object ref = requestCommand_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      requestCommand_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CPID_FIELD_NUMBER = 2;
  private volatile java.lang.Object cpId_;
  /**
   * <code>optional string cpId = 2;</code>
   * @return Whether the cpId field is set.
   */
  @java.lang.Override
  public boolean hasCpId() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional string cpId = 2;</code>
   * @return The cpId.
   */
  @java.lang.Override
  public java.lang.String getCpId() {
    java.lang.Object ref = cpId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        cpId_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string cpId = 2;</code>
   * @return The bytes for cpId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCpIdBytes() {
    java.lang.Object ref = cpId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cpId_ = b;
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
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, requestCommand_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, cpId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, requestCommand_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, cpId_);
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
    if (!(obj instanceof viettel.statistic_smpp.dto.Header)) {
      return super.equals(obj);
    }
    viettel.statistic_smpp.dto.Header other = (viettel.statistic_smpp.dto.Header) obj;

    if (hasRequestCommand() != other.hasRequestCommand()) return false;
    if (hasRequestCommand()) {
      if (!getRequestCommand()
          .equals(other.getRequestCommand())) return false;
    }
    if (hasCpId() != other.hasCpId()) return false;
    if (hasCpId()) {
      if (!getCpId()
          .equals(other.getCpId())) return false;
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
    if (hasRequestCommand()) {
      hash = (37 * hash) + REQUESTCOMMAND_FIELD_NUMBER;
      hash = (53 * hash) + getRequestCommand().hashCode();
    }
    if (hasCpId()) {
      hash = (37 * hash) + CPID_FIELD_NUMBER;
      hash = (53 * hash) + getCpId().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static viettel.statistic_smpp.dto.Header parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Header parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static viettel.statistic_smpp.dto.Header parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static viettel.statistic_smpp.dto.Header parseFrom(
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
  public static Builder newBuilder(viettel.statistic_smpp.dto.Header prototype) {
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
   * Protobuf type {@code tutorial.Header}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tutorial.Header)
      viettel.statistic_smpp.dto.HeaderOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Header_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Header_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              viettel.statistic_smpp.dto.Header.class, viettel.statistic_smpp.dto.Header.Builder.class);
    }

    // Construct using viettel.statistic_smpp.dto.Header.newBuilder()
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
      requestCommand_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      cpId_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return viettel.statistic_smpp.dto.Event.internal_static_tutorial_Header_descriptor;
    }

    @java.lang.Override
    public viettel.statistic_smpp.dto.Header getDefaultInstanceForType() {
      return viettel.statistic_smpp.dto.Header.getDefaultInstance();
    }

    @java.lang.Override
    public viettel.statistic_smpp.dto.Header build() {
      viettel.statistic_smpp.dto.Header result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public viettel.statistic_smpp.dto.Header buildPartial() {
      viettel.statistic_smpp.dto.Header result = new viettel.statistic_smpp.dto.Header(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.requestCommand_ = requestCommand_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000002;
      }
      result.cpId_ = cpId_;
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
      if (other instanceof viettel.statistic_smpp.dto.Header) {
        return mergeFrom((viettel.statistic_smpp.dto.Header)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(viettel.statistic_smpp.dto.Header other) {
      if (other == viettel.statistic_smpp.dto.Header.getDefaultInstance()) return this;
      if (other.hasRequestCommand()) {
        bitField0_ |= 0x00000001;
        requestCommand_ = other.requestCommand_;
        onChanged();
      }
      if (other.hasCpId()) {
        bitField0_ |= 0x00000002;
        cpId_ = other.cpId_;
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
      viettel.statistic_smpp.dto.Header parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (viettel.statistic_smpp.dto.Header) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object requestCommand_ = "";
    /**
     * <code>optional string requestCommand = 1;</code>
     * @return Whether the requestCommand field is set.
     */
    public boolean hasRequestCommand() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional string requestCommand = 1;</code>
     * @return The requestCommand.
     */
    public java.lang.String getRequestCommand() {
      java.lang.Object ref = requestCommand_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          requestCommand_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string requestCommand = 1;</code>
     * @return The bytes for requestCommand.
     */
    public com.google.protobuf.ByteString
        getRequestCommandBytes() {
      java.lang.Object ref = requestCommand_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        requestCommand_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string requestCommand = 1;</code>
     * @param value The requestCommand to set.
     * @return This builder for chaining.
     */
    public Builder setRequestCommand(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      requestCommand_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string requestCommand = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearRequestCommand() {
      bitField0_ = (bitField0_ & ~0x00000001);
      requestCommand_ = getDefaultInstance().getRequestCommand();
      onChanged();
      return this;
    }
    /**
     * <code>optional string requestCommand = 1;</code>
     * @param value The bytes for requestCommand to set.
     * @return This builder for chaining.
     */
    public Builder setRequestCommandBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      requestCommand_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object cpId_ = "";
    /**
     * <code>optional string cpId = 2;</code>
     * @return Whether the cpId field is set.
     */
    public boolean hasCpId() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional string cpId = 2;</code>
     * @return The cpId.
     */
    public java.lang.String getCpId() {
      java.lang.Object ref = cpId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          cpId_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string cpId = 2;</code>
     * @return The bytes for cpId.
     */
    public com.google.protobuf.ByteString
        getCpIdBytes() {
      java.lang.Object ref = cpId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cpId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string cpId = 2;</code>
     * @param value The cpId to set.
     * @return This builder for chaining.
     */
    public Builder setCpId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      cpId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string cpId = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCpId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      cpId_ = getDefaultInstance().getCpId();
      onChanged();
      return this;
    }
    /**
     * <code>optional string cpId = 2;</code>
     * @param value The bytes for cpId to set.
     * @return This builder for chaining.
     */
    public Builder setCpIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      cpId_ = value;
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


    // @@protoc_insertion_point(builder_scope:tutorial.Header)
  }

  // @@protoc_insertion_point(class_scope:tutorial.Header)
  private static final viettel.statistic_smpp.dto.Header DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new viettel.statistic_smpp.dto.Header();
  }

  public static viettel.statistic_smpp.dto.Header getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<Header>
      PARSER = new com.google.protobuf.AbstractParser<Header>() {
    @java.lang.Override
    public Header parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Header(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Header> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Header> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public viettel.statistic_smpp.dto.Header getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

