public class VigenereCipher {
    private String key;
    private String alphabet;

    public VigenereCipher(String key) {
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }

    public String getKey() {
        return key;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private char shiftLetter(char letter, int shift) {
        char newLetter;

        if ((letter <=90 && letter >=65)) {
            int temp = (char) (((int) letter - 65 + shift + (26 * 10)) % 26);
            newLetter = (char) (temp + 'a');
        } else if ((letter <=122 && letter >=97)) {
            int temp = (((int) letter - 97 + shift + (26 * 10)) %26);
            newLetter = (char) (temp + 'a');
        } else {
            newLetter = letter;
        }
        return newLetter;
    }

    public String encode(String text) {
        int keyIndex = 0;
        String encodedString = "";
        for (int i = 0; i < text.length(); ++i) {
            encodedString = encodedString + shiftLetter(text.charAt(i), key.charAt(keyIndex % key.length()) - 97);
            keyIndex++;
        }
        return encodedString.toLowerCase();
    }


    public String decode(String text) {
        int keyIndex = 0;
        String decodedString = "";
        for (int i = 0; i < text.length(); ++i) {
            decodedString = decodedString + shiftLetter(text.charAt(i), -1 * (key.charAt(keyIndex % key.length()) - 97));
            keyIndex++;
        }
        return decodedString.toLowerCase();
    }

}