package dmitry.melnik;

import dmitry.melnik.actionClasses.makeArray.MakeArrayOfDouble;
import dmitry.melnik.actionClasses.workWithArrays.WorkWithArraysOfNums;
import dmitry.melnik.myExeptions.LengthOfArrayNull;
import dmitry.melnik.myExeptions.NullLink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class Run {
        public static final Logger logger = LogManager.getLogger(Run.class.getName());

    public static void main(String[] args) {
        logger.info("Start Application");
        runClassWorkWithArray();
        logger.info("Final");
    }

    public static void runClassWorkWithArray() {
        ArrayList<Double> elements = new MakeArrayOfDouble().makeArrayFromFile();
//        ArrayList<Double> elements = null;
//        ArrayList<Double> elements = new ArrayList<>();
        try {
            WorkWithArraysOfNums workWithArrays = new WorkWithArraysOfNums(elements);
            System.out.println("Start array - " + Arrays.toString(elements.toArray()));

            System.out.println("Min in array - " + workWithArrays.searchMinInArray());
            System.out.println("Max  in array - " + workWithArrays.searchMaxInArray());
            System.out.println("Sum of array - " + workWithArrays.sumOfArray());
            System.out.println("Average in array - " + workWithArrays.averageOfArray());

            workWithArrays.sortArrayFromMinToMax();
            System.out.println("Array after sort - " + Arrays.toString(elements.toArray()));

            workWithArrays.changeElementLessParametr(new Double(50));
            System.out.println("Array after change elements - " + Arrays.toString(elements.toArray()));
        } catch (NullLink nullLink) {
            logger.warn(nullLink);
            System.out.println(nullLink.toString());
        } catch (LengthOfArrayNull lengthOfArrayNull) {
            logger.warn(lengthOfArrayNull);
            System.out.println(lengthOfArrayNull.toString());
        }
    }
}
