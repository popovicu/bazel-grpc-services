java_library(
    name = "echo_client",
    srcs = ["EchoClient.java"],
    deps = [
        "//echoserver:echo_service_java_grpc",
        "//echoserver:echo_service_java_proto",
        "@com_github_grpc_grpc_java//api",
        "@com_github_grpc_grpc_java//netty",
    ],
)

java_binary(
  name = "echo_client_program",
  main_class = "popovicu.bazel.grpc.services.echo.EchoClientProgram",
  srcs = ["EchoClientProgram.java"],
  deps = [
    ":echo_client",
    "@com_github_grpc_grpc_java//api",
    "@maven//:commons_cli_commons_cli_1_4", # TODO(popovicu): better alias
  ],
)