import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class ScannerContentReader implements FileContentReaderImpl {


    @Override
    public String read(File file) {
        StringJoiner result = new StringJoiner("\n");

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                 result.add(scanner.nextLine());
            }

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }
}
