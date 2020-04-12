# bazel-grpc-services
Examples of gRPC services built with Bazel.

To build artifacts from this repository, the following is needed:
* C++ compiler
* Java JDK
* Bazel

## Echo server (C++)

To run the C++ echo server, `cd` into the `bazel-grpc-services` directory and run `bazel run //echoserver:echo_server_cc`.  
This will run the server at port 50051. To change the listening IP/port, run with following command: `bazel run //echoserver:echo_server_cc -- --server_address=$IP:$PORT` (replace `$IP` and `$PORT` with custom parameters).

## Echo client program (Java)

To target the server above, run the Java client program with the following command: `bazel run //java/popovicu/bazel/grpc/services/echo:echo_client_program -- --server_address=$SERVER_ADDRESS --payload=$PAYLOAD --repetitions=$REPETITIONS`. `$SERVER_ADDRESS` should be in the form of `MACHINE:PORT`, `$PAYLOAD` can be any string that will be echoed back, and `$REPETITIONS` is the number of times the payload will be echoed back.
