import java.util.Scanner;

public class KeyEncrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int key;
        str = sc.nextLine();
        key = sc.nextInt();
        System.out.println(sString(str, key));

    }

    static String encryptor(String s, int k) {
        char[] ch = s.toCharArray();
        char[] ench = new char[ch.length];
        String encryptedWord = "";
        int diff;

        for(int i=0; i<ch.length; i++) {
            if(ch[i]>='a' && ch[i] <= 'z') {
                ench[i] = (char) (ch[i] + k);
                while (ench[i] > 'z') {
                    if (ench[i] > 'z') {
                        diff = ench[i] - 'z';
                        ench[i] = (char) ('a' + (diff - 1));
                    }
                }
            }
            else
                ench[i] = ch[i];

            encryptedWord += ench[i];
        }
        return encryptedWord;
    }

    static String sString(String s, int k) {
        String[] word = s.split("\\s");
        String[] encrypted = new String[word.length];
        String encryptedPhrase = "";

        for(int i=0; i<word.length; i++) {
            encrypted[i] = encryptor(word[i], k);
            encryptedPhrase += encrypted[i] + " ";
        }
        return encryptedPhrase;
    }


}