package dmitry.melnik.actionClasses.workWithArrays;

import dmitry.melnik.actionClasses.Count;
import dmitry.melnik.myExeptions.LengthOfArrayNull;
import dmitry.melnik.myExeptions.NullLink;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WorkWithArraysOfNums extends WorkWithArrays {

    private ArrayList<Double> arrayOfElements;

    public WorkWithArraysOfNums(ArrayList<Double> arrayOfElements) throws NullLink, LengthOfArrayNull {
        if (arrayOfElements == null) {
            throw new NullLink();
        }
        if (arrayOfElements.size() == 0) {
            throw new LengthOfArrayNull();
        }
        this.arrayOfElements = arrayOfElements;
    }

    public double searchMinInArray() {
        Count minNum = arrayOfNums -> Collections.min(arrayOfNums);
        return minNum.count(arrayOfElements);
    }

    public double searchMaxInArray() {
        Count maxNum = arrayOfNums -> {
            double max = arrayOfNums.get(0);
            for (double i : arrayOfNums) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        };
        return maxNum.count(arrayOfElements);
    }

    public double sumOfArray() {
        Count sum = arrayOfNums -> {
            double summa = 0;
            for (double i : arrayOfElements) {
                summa += i;
            }
            return summa;
        };
        return sum.count(arrayOfElements);
    }

    public double averageOfArray() {
        Count average = arrayOfNums -> {
            double averageNum = 0;
            for (double i : arrayOfNums) {
                averageNum +=  i;
            }
            return averageNum / arrayOfNums.size();
        };
        return average.count(arrayOfElements);
    }

    public void changeElementLessParametr(Double parametr) {
        arrayOfElements.trimToSize();
        for (int i = 0; i < arrayOfElements.size(); i++) {
            if (arrayOfElements.get(i) < parametr) {
                arrayOfElements.set(i, parametr);
            }
        }
    }

    public void sortArrayFromMinToMax() {
        Comparator<Double> comArray = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1 == o2) {
                    return 0;
                }
                if (o1 > o2) {
                    return 1;
                }
                if (o1 < o2) {
                    return -1;
                }
                return 0;
            }
        };
        arrayOfElements.sort(comArray);
    }
}