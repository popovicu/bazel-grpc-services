# bazel-grpc-services
Examples of gRPC services built with Bazel.

To build artifacts from this repository, the following is needed:
* C++ compiler
* Java JDK
* Bazel

## Echo server (C++)

To run the C++ echo server, `cd` into the `bazel-grpc-services` directory and run `bazel run //echoserver:echo_server_cc`.  
This will run the server at port 50051. To change the listening IP/port, run with following command: `bazel run //echoserver:echo_server_cc -- --server_address=$IP:$PORT` (replace `$IP` and `$PORT` with custom parameters).
