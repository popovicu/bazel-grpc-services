#include "echoserver/echo_service.h"

#include <grpcpp/grpcpp.h>

namespace popovicu {
namespace bazel {
namespace grpc {
namespace services {
namespace echo {

using ::grpc::ServerBuilder;
using ::grpc::ServerContext;
using ::grpc::Status;

Status EchoServiceImpl::DoEcho(ServerContext* ctx,
			       const EchoRequest* request,
			       EchoResponse* response) {
  for (int i = 0; i < request->repetitions(); ++i) {
    response->add_payloads(request->payload());
  }
  
  return Status::OK;
}

}
}
}
}
}
