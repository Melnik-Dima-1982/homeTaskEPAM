package dmitry.melnik.actionClasses.makeArray;

import dmitry.melnik.validationClasses.CheckIsDouble;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static dmitry.melnik.Run.logger;

public class MakeArrayOfDouble implements MakeArray {
    private static final String SPLIT_PATTERN = "\\t| |\r|\n";

    public ArrayList<Double> makeArrayFromFile() {
        String stringFromFile = readStringFromFile("src/dmitry/melnik/DataFile.txt");
        String[] stringsAfterSplit = splitFromString(stringFromFile);
        ArrayList<Double> arrayOfNums = new ArrayList<>();
        CheckIsDouble checkIsDouble = new CheckIsDouble();

        for (String s : stringsAfterSplit) {
            if (checkIsDouble.checkStringIsDouble(s)) {
                arrayOfNums.add(Double.parseDouble(s));
            }
        }
        return arrayOfNums;
    }

    private String readStringFromFile(String fileName) {
        StringBuilder stringFromFile = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            int count;
            while ((count = fileInputStream.read()) != -1) {
                stringFromFile.append((char) count);
            }
        } catch (FileNotFoundException e) {
            logger.warn(e);
            e.printStackTrace();
        } catch (IOException e) {
            logger.warn(e);
            e.printStackTrace();
        }
        return stringFromFile.toString();
    }

    private String[] splitFromString(String s) {
        return s.split(SPLIT_PATTERN);
    }
}
