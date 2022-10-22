import java.util.ArrayList;
import java.util.List;

public class Week10 {
    private ArrayList<String> classNames = new ArrayList<>();
    private ArrayList<String> libNames = new ArrayList<>();
    private ArrayList<String> libPaths = new ArrayList<>();

    private final String packageString = "package";
    private final String staticString = "static";
    private final String importString = "import";

    private final String publicString = "public";
    private final String privateString = "private";
    private final String protectedString = "protected";
    private final String classString = "class";

    private final String interfaceString = "interface";

    private final String randomIntGreaterThanInt = "randomIntGreaterThan(int)";

    private final String randomPositiveInt = "randomPositiveInt()";

    private final String randomNegativeInt = "randomNegativeInt()";

    private final String javaLang = "java.lang.";

    private String packagePath = "";

    private String[] getSplit(String string, String regex) {
        return string.split(regex);
    }

    /**
     * T.
     */
    private boolean getPackage(String string) {
        String[] path = getSplit(string, " ");
        String packageTemp = path[0];
        if (!packageTemp.equals(packageString)) {
            return false;
        }
        packagePath = path[1].substring(0, path[1].length() - 1);
        return true;
    }

    /**
     * T.
     */
    private boolean getLibrary(String string) {
        String[] library = getSplit(string, " ");
        int position = -1;
        if (library.length > 1 && library[0].equals(importString)) {
            position = 1;
            if (library[1].equals(staticString)) {
                position = 2;
            }
        }
        if (position == -1) {
            return false;
        }
        String lib = library[position].substring(0, library[position].length() - 1);
        int position2 = lib.lastIndexOf('.');
        this.libNames.add(lib.substring(position2 + 1));
        this.libPaths.add(lib.substring(0, position2));
        return true;
    }

    /**
     * T.
     */
    private boolean getClass(String line) {
        String[] classTemp = getSplit(line, " ");
        if (classTemp.length < 3) {
            return false;
        }
        if (!classTemp[0].equals(publicString)
                && !classTemp[0].equals(privateString)
                && !classTemp[0].equals(protectedString)) {
            return false;
        }
        if (!classTemp[1].equals(classString)
                && !classTemp[1].equals(interfaceString)) {
            return false;
        }
        classNames.add(classTemp[2]);
        return true;
    }

    /**
     * T.
     */
    private int getPosFunction(String[] words) {
        String word = words[words.length - 1];
        if (word.length() == 0
                || word.charAt(word.length() - 1) == ';'
                || words.length < 4) {
            return -1;
        }

        if (!words[0].equals(publicString)
                && !words[0].equals(privateString)
                && !words[0].equals(protectedString)
                && !words[0].equals(staticString)) {
            return -1;
        }
        if (!words[0].equals(staticString)
                && !words[1].equals(staticString)) {
            return -1;
        }
        int position = 0;
        while (position < words.length
                && !words[position].contains("(")) {
            position++;
        }
        if (position < words.length) {
            return position;
        }
        return -1;
    }

    /*
     * T.
     * */
    private String getNameFunction(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '(') {
                result.append("(").append(getParameters(word.substring(i + 1)));
                break;
            } else {
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * T.
     */
    public List<String> getAllFunctions(String string) {
        reset();
        String[] lines = getSplit(string, "\n");

        List<String> result = new ArrayList<>();

        for (int i = 0; i < lines.length; ++i) {
            lines[i] = lines[i].trim();
        }

        for (int i = 0; i < lines.length; ++i) {
            getLibrary(lines[i]);
            getPackage(lines[i]);
            getClass(lines[i]);

            if (lines[i].length() > 0
                    && lines[i].charAt(lines[i].length() - 1) == '(') {
                lines[i] += lines[i + 1];
                lines[i + 1] = "";
            }
        }

        for (String line : lines) {
            String[] words = getSplit(line, " ");

            int position = getPosFunction(words);
            if (position == -1) {
                continue;
            }

            StringBuilder ans = new StringBuilder(getNameFunction(words[position]));
            if (!words[position].contains(")")) {
                for (int j = position + 2; j < words.length; j += 2) {
                    if (words[j - 1].contains(")")) {
                        break;
                    }
                    ans.append(",").append(getParameters(words[j]));
                    if (words[j].contains(")")) {
                        break;
                    }
                }
                ans.append(')');
            }
            result.add(ans.toString());
        }

        result.removeIf(
                e ->
                        (e.equals(randomIntGreaterThanInt)
                                || e.equals(randomPositiveInt)
                                || e.equals(randomNegativeInt)));
        List<String> finalResult = new ArrayList<>();

        for (int i = 0; i < result.size(); ++i) {
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (result.get(i).equals(result.get(j))) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                finalResult.add(result.get(i));
            }
        }
        return finalResult;
    }

    /**
     * T.
     */
    private String getParameters(String string) {
        StringBuilder parameters = new StringBuilder();
        String childTem = null;
        for (int j = 0; j < string.length(); j++) {
            if (string.charAt(j) != '.') {
                if (string.charAt(j) == '<') {
                    childTem = getParameters(string.substring(j + 1, string.length() - 1));
                    break;
                }
                parameters.append(string.charAt(j));
            }
        }

        String result = "";
        for (int j = 0; j < this.libNames.size(); j++) {
            if (parameters.toString().equals(this.libNames.get(j))) {
                result = this.libPaths.get(j) + "." + parameters;
            }
        }

        if (result.equals("")) {
            for (String className : this.classNames) {
                if (className.equals(parameters.toString())) {
                    result = packagePath + "." + parameters;
                }
            }
        }

        if (result.equals("")
                && parameters.length() > 0
                && Character.isUpperCase(parameters.charAt(0))
                && !parameters.toString().equals("T[]")
                && !parameters.toString().equals("T")) {
            result = javaLang + parameters;
        }
        if (result.equals("")) {
            result = parameters.toString();
        }
        if (childTem != null) {
            result += "<" + childTem + ">";
        }
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '{') {
                break;
            }
            finalResult.append(result.charAt(i));
        }
        return finalResult.toString();
    }

    /**
     * Reset data.
     */
    private void reset() {
        this.libNames.clear();
        this.libPaths.clear();
        this.classNames.clear();
    }
}
