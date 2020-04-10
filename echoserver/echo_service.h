#ifndef ECHOSERVER_H
#define ECHOSERVER_H

#include <grpcpp/grpcpp.h>

#include "echoserver/echoservice.grpc.pb.h"

namespace popovicu {
namespace bazel {
namespace grpc {
namespace services {
namespace echo {
    
class EchoServiceImpl final : public EchoService::Service {
  ::grpc::Status DoEcho(::grpc::ServerContext* ctx,
			const EchoRequest* request,
			EchoResponse* response) override;
};

}
}
}
}
}

#endif
