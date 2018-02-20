package core.helpers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ImageMagick {
    private final int DEFAULT_FUZZ = 20;

    public boolean isSimilar(String firstFileName, String secondFileName) {
        return isSimilar(firstFileName, secondFileName, DEFAULT_FUZZ);
    }

    public boolean isSimilar(String firstFileName, String secondFileName, int fuzz) {
        if (fuzz < 0 || fuzz > 100) throw new RuntimeException("Incorrect fuzz value: " + fuzz);

        String[] commandAndArgs = {"C:\\Program Files\\ImageMagick-7.0.6-Q16\\compare.exe", "-metric", "ae", "-fuzz", fuzz + "%", firstFileName, secondFileName, "difference.png"};

        return parseCompareResult(executeCommand(commandAndArgs)) == 0;
    }

    private List<String> executeCommand(String[] commandAndArgs) {
        List<String> commandOutput = new LinkedList<String>();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(commandAndArgs);
            InputStream errorStream = process.getErrorStream();
            InputStreamReader streamReader = new InputStreamReader(errorStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null)
                commandOutput.add(line);
            process.waitFor();
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute command", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Command execution have been interrupted", e);
        }
        return commandOutput;
    }

    private int parseCompareResult(List<String> commandOutput) {
        int result;
        if (commandOutput.size() > 1 | commandOutput.size() == 0) {
            throw new RuntimeException("Unexpected command output: " + commandOutput.toString());
        } else {
            try {
                result = Integer.parseInt(commandOutput.get(0));
            } catch (Throwable t) {
                throw new RuntimeException("Failed to parse integer from command output: " + commandOutput.toString());
            }
        }
        return result;
    }
}
