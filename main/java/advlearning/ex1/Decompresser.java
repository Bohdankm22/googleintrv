package advlearning.ex1;

public class Decompresser {

    public static String decompressString(String st) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = st.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == ']' || chArr[i] == '[') {
                // ignore
            } else if (Character.isDigit(chArr[i])) {
                sb.append(decompressString(st.substring(i + 1), Character.getNumericValue(chArr[i])));
            } else if (Character.isLetter(chArr[i])) {
                sb.append(chArr[i]);
            } else {
                throw new RuntimeException("Could not find exit from method!");
            }
        }
        return sb.toString();
    }

    private static String decompressString(String st, int numb) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = st.toCharArray();
        if (chArr[0] == '[') {
            for (int j = 0; j < numb - 1; j++) {
                sb.append(decompressInternal(st.substring(1)));
            }
            return sb.toString();
        } else if (Character.isDigit(chArr[0])) {
            return decompressString(st.substring(1), numb * 10 + Character.getNumericValue(chArr[0]));
        } else {
            throw new RuntimeException("Could not find exit from method!");
        }
    }

    private static String decompressInternal(String st) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = st.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == ']') {
                return sb.toString();
            } else if (Character.isDigit(chArr[i])) {
                sb.append(decompressString(st.substring(i + 1), Character.getNumericValue(chArr[i])));
            } else if (Character.isLetter(chArr[i])) {
                sb.append(chArr[i]);
            } else if (chArr[i] == ']') {
                // ignore
            } else {
                throw new RuntimeException("Could not find exit from method!");
            }
        }
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        String decoded = "3[a2[k]bc]4[ab]c";
        System.out.printf("Decoded string is %s, encoded is %s", decoded, Decompresser.decompressString(decoded));
    }
}
