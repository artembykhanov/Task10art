package ru.vsu.cs.art;

import java.util.List;
import java.util.ArrayList;

public class Task {

    public static List<Student> searchTheBestStudent(ArrayList<Student> list, int n) {
        int max = 0;
        int maxIndex = 0;
        int copyN = n;
        List<Student> copyList = new ArrayList<>();
        List<Student> best = new ArrayList<>();
        for (int numCourse = 1; numCourse <= 4; numCourse++) {
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);
                if (student.numCourse == numCourse) {
                    if (student.middleScore > max) {
                        max = student.middleScore;
                        maxIndex = i;
                    }
                }
            }
            for (int h = 0; h < list.size(); h++) {
                Student student4 = list.get(h);
                if (student4.numCourse == numCourse && h != maxIndex) {
                    copyList.add(list.get(h));
                }
            }
            if (max > 0) {
                Student student5 = list.get(maxIndex);
                best.add(student5);
            }
            max = 0;
            maxIndex = 0;
        }

        for (int j = 0; j < copyList.size(); j++) {
            for (int k = 0; k < copyList.size() - 1; k++) {
                Student student1 = copyList.get(k);
                Student student2 = copyList.get(k + 1);
                if (student2.middleScore > student1.middleScore) {
                    copyList.remove(student1);
                    copyList.remove(student2);
                    copyList.add(k, student2);
                    copyList.add(k + 1, student1);
                }
            }
        }

        for (int s = 0; s < copyList.size(); s++) {
            Student student4 = copyList.get(s);
            if (student4.middleScore >= 0) {
                best.add(copyList.get(s));
            }
        }

        for (int u = best.size(); u > copyN; u--) {
            if (copyN != best.size()) {
                best.remove(u - 1);
            }
        }

        return best;
    }
}

