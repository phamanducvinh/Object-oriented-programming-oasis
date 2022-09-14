public class StudentManagement {

    private Student[] students = new Student[100];
    private Integer countStudent = 0;

    public static boolean sameGroup(Student s1, Student s2) {
        return (s1.getGroup().equals(s2.getGroup()));
    }

    public void addStudent(Student newStudent) {
        students[countStudent++] = newStudent;
    }

    /**
     * get group classes.
     * param all of students
     */
    public String studentsByGroup() {
        boolean[] isDone = new boolean[countStudent];
        for (int i = 0; i < countStudent; ++i) {
            isDone[i] = false;
        }

        String result = "";

        for (int i = 0; i < countStudent; ++i) {
            if (!isDone[i]) {
                if (i == 0) {
                    result = result + students[i].getGroup();
                } else {
                    result = result + "\n" + students[i].getGroup();
                }

                for (int j = i; j < countStudent; ++j) {
                    if (sameGroup(students[i], students[j])) {
                        isDone[j] = true;
                        result = result + "\n" + students[j].getInfo();
                    }
                }
            }
        }

        return result;
    }

    /**
     * remove student.
     * */
    public void removeStudent(String id) {
        for (int i = 0; i < countStudent; ++i) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < countStudent - 1; ++j) {
                    students[j] = students[j + 1];
                }
                countStudent--;
                break;
            }
        }
    }
    /**
     * process test.
     * */

    public static void main(String[] args) {
    }

}
 