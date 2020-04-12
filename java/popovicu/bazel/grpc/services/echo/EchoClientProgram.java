package popovicu.bazel.grpc.services.echo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.concurrent.TimeUnit;

final class EchoClientProgram {

  private static final String SERVER_ADDRESS_CMD_LINE = "server_address";
  private static final String PAYLOAD_CMD_LINE = "payload";
  private static final String REPETITIONS_CMD_LINE = "repetitions";

  public static void main(String[] args) throws Exception {
    CommandLine cmd_line = processCommandLine(args);

    ManagedChannel channel =
        ManagedChannelBuilder.forTarget(cmd_line.getOptionValue(SERVER_ADDRESS_CMD_LINE)).usePlaintext().build();
    String payload = cmd_line.getOptionValue(PAYLOAD_CMD_LINE);
    int repetitions = Integer.parseInt(cmd_line.getOptionValue(REPETITIONS_CMD_LINE));

    try {
      EchoClient client = new EchoClient(channel);
      System.out.println("Sending payload '" + payload + "' " + repetitions + " times.");
      System.out.println("Server response: '" + client.doEcho(payload, repetitions) + "'");
    } finally {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }

  private static CommandLine processCommandLine(String[] args) throws ParseException {
    Option serverAddressOption =
        Option.builder("s")
            .required()
            .hasArg()
            .longOpt(SERVER_ADDRESS_CMD_LINE)
            .desc("Address where the echo server listens.")
            .build();
    Option payloadOption =
        Option.builder("p")
            .required()
            .hasArg()
            .longOpt(PAYLOAD_CMD_LINE)
            .desc("Payload to be sent to the echo server.")
            .build();
    Option repetitionsOption =
        Option.builder("r")
            .required()
            .hasArg()
            .longOpt(REPETITIONS_CMD_LINE)
            .desc("Payload to be sent to the echo server.")
            .build();

    Options options = new Options();
    options.addOption(serverAddressOption);
    options.addOption(payloadOption);
    options.addOption(repetitionsOption);

    CommandLineParser parser = new DefaultParser();
    return parser.parse(options, args);
  }
}
