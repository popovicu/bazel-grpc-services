load("@rules_proto//proto:defs.bzl", "proto_library")
load("@com_github_grpc_grpc//bazel:cc_grpc_library.bzl", "cc_grpc_library")
load("@com_github_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")

proto_library(
    name = "echo_service_proto",
    srcs = ["echoservice.proto"],
)

cc_proto_library(
    name = "echo_service_cc_proto",
    deps = [":echo_service_proto"],
)

java_proto_library(
  name = "echo_service_java_proto",
  deps = [":echo_service_proto"],
)

cc_grpc_library(
    name = "echo_service_cc_grpc",
    srcs = [":echo_service_proto"],
    grpc_only = True,
    deps = [":echo_service_cc_proto"],
    visibility = ["//visibility:public"],
)

java_grpc_library(
  name = "echo_service_java_grpc",
  srcs = [":echo_service_proto"],
  deps = [":echo_service_java_proto"],
  visibility = ["//visibility:public"],
)

cc_library(
    name = "echo_service_cc",
    srcs = ["echo_service.cc"],
    hdrs = ["echo_service.h"],
    deps = [
        ":echo_service_cc_grpc",
        "@com_github_grpc_grpc//:grpc++",
    ],
)

cc_binary(
    name = "echo_server_cc",
    srcs = ["echo_server.cc"],
    deps = [
        "@com_github_grpc_grpc//:grpc++",
        "@com_github_grpc_grpc//:grpc++_reflection",
        "@com_github_abseil_abseil_cpp//absl/flags:flag",
        "@com_github_abseil_abseil_cpp//absl/flags:parse",
        ":echo_service_cc",
    ],
)