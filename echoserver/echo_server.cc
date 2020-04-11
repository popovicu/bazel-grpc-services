#include <iostream>
#include <memory>
#include <string>

#include <grpcpp/grpcpp.h>
#include <grpcpp/health_check_service_interface.h>
#include <grpcpp/ext/proto_server_reflection_plugin.h>

#include "absl/flags/flag.h"
#include "absl/flags/parse.h"
#include "echoserver/echo_service.h"

ABSL_FLAG(std::string, server_address, "0.0.0.0:50051",
          "Address where the server should listen.");

namespace popovicu {
namespace bazel {
namespace grpc {
namespace services {
namespace echo {

namespace {
  
void RunServer(const std::string& server_address) {
  EchoServiceImpl echo_service;

  ::grpc::EnableDefaultHealthCheckService(true);
  ::grpc::reflection::InitProtoReflectionServerBuilderPlugin();

  ::grpc::ServerBuilder builder;

  // Listens on the given address without any authentication mechanism.
  builder.AddListeningPort(server_address, ::grpc::InsecureServerCredentials());

  // Blocking service.
  builder.RegisterService(&echo_service);

  std::unique_ptr<::grpc::Server> server(builder.BuildAndStart());
  std::cout << "Server listening on " << server_address << std::endl;
  server->Wait();
}
  
}
  
}
}
}
}
}

int main(int argc, char **argv) {
  absl::ParseCommandLine(argc, argv);
    
  const auto server_address = absl::GetFlag(FLAGS_server_address);
  popovicu::bazel::grpc::services::echo::RunServer(server_address);
  return 0;
}
