package popovicu.bazel.grpc.services.echo;

import io.grpc.Channel;
import popovicu.bazel.grpc.services.echo.Echo.EchoRequest;
import popovicu.bazel.grpc.services.echo.Echo.EchoResponse;

import java.util.List;

final class EchoClient {

  private final EchoServiceGrpc.EchoServiceBlockingStub stub;

  EchoClient(Channel channel) {
    this.stub = EchoServiceGrpc.newBlockingStub(channel);
  }

  /**
   * Makes an RPC to the echo server asking for repetitions of a payload and returns the repeated
   * payload.
   */
  // TODO(popovicu): use Guava ImmutableList once collector issue is resolved.
  List<String> doEcho(String payload, int repetitions) {
    EchoRequest request =
        EchoRequest.newBuilder().setPayload(payload).setRepetitions(repetitions).build();
    EchoResponse response = stub.doEcho(request);
    return response.getPayloadsList();
  }
}
