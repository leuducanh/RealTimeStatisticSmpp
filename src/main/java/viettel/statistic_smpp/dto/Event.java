// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package viettel.statistic_smpp.dto;

public final class Event {
  private Event() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Header_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Header_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Body_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Body_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013event.proto\022\010tutorial\"I\n\007Request\022 \n\006he" +
      "ader\030\001 \001(\0132\020.tutorial.Header\022\034\n\004body\030\002 \001" +
      "(\0132\016.tutorial.Body\".\n\006Header\022\026\n\016requestC" +
      "ommand\030\001 \001(\t\022\014\n\004cpId\030\002 \001(\t\"\027\n\004Body\022\017\n\007pa" +
      "yload\030\001 \003(\tB%\n\032viettel.statistic_smpp.dt" +
      "oB\005EventP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tutorial_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Request_descriptor,
        new java.lang.String[] { "Header", "Body", });
    internal_static_tutorial_Header_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_tutorial_Header_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Header_descriptor,
        new java.lang.String[] { "RequestCommand", "CpId", });
    internal_static_tutorial_Body_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_tutorial_Body_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Body_descriptor,
        new java.lang.String[] { "Payload", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
