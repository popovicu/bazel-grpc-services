load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#--------------------------------------------------------------------------------------------------------------------
# Protocol Buffer functionality.
#--------------------------------------------------------------------------------------------------------------------
http_archive(
    name = "rules_proto",
    sha256 = "602e7161d9195e50246177e7c55b2f39950a9cf7366f74ed5f22fd45750cd208",
    strip_prefix = "rules_proto-97d8af4dc474595af3900dd85cb3a29ad28cc313",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
        "https://github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
    ],
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()
#--------------------------------------------------------------------------------------------------------------------

#--------------------------------------------------------------------------------------------------------------------
# gRPC (C++ based) repository.
#--------------------------------------------------------------------------------------------------------------------
http_archive(
    name = "com_github_grpc_grpc",
    strip_prefix = "grpc-4d91e531ab0f8cb7fc1e4ee3dcf7e8685d2da5c3",
    urls = [
        "https://github.com/grpc/grpc/archive/4d91e531ab0f8cb7fc1e4ee3dcf7e8685d2da5c3.tar.gz",
    ],
)

load("@com_github_grpc_grpc//bazel:grpc_deps.bzl", "grpc_deps")

grpc_deps()

load("@com_github_grpc_grpc//bazel:grpc_extra_deps.bzl", "grpc_extra_deps")

grpc_extra_deps()
#--------------------------------------------------------------------------------------------------------------------

#--------------------------------------------------------------------------------------------------------------------
# gRPC (Java based) repository + Maven remote dependencies.
#--------------------------------------------------------------------------------------------------------------------
http_archive(
    name = "com_github_grpc_grpc_java",
    strip_prefix = "grpc-java-1ee322cc1545762e253e9f950ef3f0f083dacb77",
    urls = [
        "https://github.com/grpc/grpc-java/archive/1ee322cc1545762e253e9f950ef3f0f083dacb77.tar.gz",
    ],
)

http_archive(
    name = "rules_jvm_external",
    sha256 = "62133c125bf4109dfd9d2af64830208356ce4ef8b165a6ef15bbff7460b35c3a",
    strip_prefix = "rules_jvm_external-3.0",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/3.0.zip",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@com_github_grpc_grpc_java//:repositories.bzl", "IO_GRPC_GRPC_JAVA_ARTIFACTS")
load("@com_github_grpc_grpc_java//:repositories.bzl", "IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS")

maven_install(
    artifacts = IO_GRPC_GRPC_JAVA_ARTIFACTS,
    generate_compat_repositories = True,
    override_targets = IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS,
    repositories = [
        "https://repo.maven.apache.org/maven2/",
    ],
)

load("@maven//:compat.bzl", "compat_repositories")

compat_repositories()

load("@com_github_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()
#--------------------------------------------------------------------------------------------------------------------
