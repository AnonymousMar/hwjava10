import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import howManyWords.HowManyWordsCount;
import json.FileJsonContentUser;
import json.User;
import NumberValid.CheckIfValid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestsAllTasks {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileContentReaderImpl fileContentReader = new ScannerContentReader();


            String content = fileContentReader.read(new File("src/main/resources/files/words.txt"));
            String[] words = content.split("\\s+");
            System.out.println("This task is called:'how many words'");
            HowManyWordsCount howManyWordsCount = new HowManyWordsCount();

            List<Map.Entry<String,Integer>> listSorted = howManyWordsCount.countWords(words);

            for (Map.Entry<String, Integer> entry : listSorted) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            String contentJson =  fileContentReader.read(new File("src/main/resources/files/json.txt"));
            List<User> users = FileJsonContentUser.partsUsers(contentJson);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String json = gson.toJson(users);
            System.out.println("This task is called:'json'");
            System.out.println(json);
            try(FileOutputStream fos = new FileOutputStream("src/main/resources/files/user.json")) {
                fos.write(json.getBytes());
            }

            String contentPhones = fileContentReader.read(new File("src/main/resources/files/file.txt"));

            String[] lines = contentPhones.split("\n");
            System.out.println("This task is called:'valid phone number'");
            for (String c : lines) {
                if (CheckIfValid.isValidPhone(c)) {
                    System.out.println(c);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
