package dmitry.melnik.validationClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIsDouble {
    public static final String PATTERN_FOR_DOUBLE = "[0-9]*\\.[0-9]{0,}$";

    public boolean checkStringIsDouble(String checkedString) {

        Pattern doublePattern = Pattern.compile(PATTERN_FOR_DOUBLE);
        Matcher doubleMatcher = doublePattern.matcher(checkedString);

        return doubleMatcher.find() ? true : false;
    }
}
