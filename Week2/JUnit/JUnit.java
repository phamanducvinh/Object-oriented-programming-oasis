public class JUnit {
    public static int max2Int(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * get min value in array.
     * param arr
     */
    public static int minArray(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; ++i) {
            result = Math.min(array[i], result);
        }
        return result;
    }

    /**
     * get BMI.
     * param weight: in kg
     * param height: in m
     */

    public static String calculateBMI(double weight, double height) {
        double bmi = Math.round((weight / (height * height)) * 10.0) / 10.0;
        if (bmi < 18.5) {
            return "Thiếu cân";
        }
        if (bmi <= 22.9) {
            return "Bình thường";
        }
        if (bmi <= 24.9) {
            return "Thừa cân";
        }
        return "Béo phì";
    }
}
 