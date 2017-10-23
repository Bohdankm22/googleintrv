package advlearning.ex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Decompresser {

    static String decompressString(String st) {
        String result = st;
        Pattern pattern = Pattern.compile("(\\d+)\\[([A-Za-z]+)]");
        while (result.contains("[")) {
            Matcher matcher = pattern.matcher(result);
            if (matcher.find()) {
                result = result.replace(matcher.group(0), multipleString(Integer.parseInt(matcher.group(1)), matcher.group(2)));
            } else {
                throw new RuntimeException("Could not find any decompressed literals");
            }
        }
        return result;
    }

    private static CharSequence multipleString(int numb, String group) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numb; i++) {
            sb.append(group);
        }
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        String decoded = "3[a2[k]bc]";
        System.out.printf("Decoded string is %s, encoded is %s", decoded, Decompresser.decompressString(decoded));
    }
}
