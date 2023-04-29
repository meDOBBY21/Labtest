package com.mycompany.app;
/*
 Commented parts are used for individual running without spring 
 */

public class StringOperation {
    String data;
    String[] options;

    // StringOperation(String data, String[] options) {
    //     this.data = data;
    //     this.options = options;
    // }

    private String caseConverstion() {
        String output = "";
        int i, alphabet;
        for (i = 0; i < this.data.length(); i++) {
            alphabet = (int) (this.data.charAt(i));
            if (this.options[1].equals("upper")) {
                if (alphabet >= 97 && alphabet <= 122) {
                    alphabet -= 32;
                    output += (char) (alphabet);
                } else
                    output += (char) (alphabet);
            } else {
                if (alphabet >= 65 && alphabet <= 90) {
                    alphabet += 32;
                    output += (char) (alphabet);
                } else
                    output += (char) (alphabet);
            }
        }
        // if(this.options[1].equals("upper")){
        // for(i=0;i<this.data.length();i++){
        // alphabet=(int)(this.data.charAt(i));
        // if(alphabet>=97 && alphabet<=122){
        // alphabet-=32;
        // output+=(char)(alphabet);
        // }
        // else
        // output+=(char)(alphabet);
        // }
        // }
        // else{
        // for(i=0;i<this.data.length();i++){
        // alphabet=(int)(this.data.charAt(i));
        // if(alphabet>=65 && alphabet<=90){
        // alphabet+=32;
        // output+=(char)(alphabet);
        // }
        // else
        // output+=(char)(alphabet);

        // }
        // }
        return output;
    }

    private String encodeShiftAmount() {
        String output = "", option = options[1];
        int i, j, shift = 0, alphabet, original;
        for (i = option.length() - 1, j = 0; i >= 0; i--, j++) {
            if (i == 1)
                shift += ((int) (option.charAt(i)) - 48);
            else
                shift += ((int) (option.charAt(i)) - 48) * (10 * j);
        }
        for (i = 0; i < this.data.length(); i++) {
            alphabet = (int) (this.data.charAt(i));
            original = alphabet;
            alphabet += shift;
            if (alphabet > 122)
                alphabet = (alphabet - 122) + 96;
            else if (alphabet > 90 && (original < 91 && original > 64))
                alphabet = (alphabet - 90) + 64;
            output += (char) (alphabet);
        }
        return output;
    }

    private String encodeASCII() {
        String output = "";
        int i, alphabet;
        for (i = 0; i < this.data.length(); i++) {
            alphabet = (int) (this.data.charAt(i));
            output += String.valueOf(alphabet) + " ";
        }
        return output;
    }

    private String prefix() {
        String output = options[1] + " ";
        int i;
        for (i = 0; i < this.data.length(); i++) {
            output += this.data.charAt(i);
            if (this.data.charAt(i) == '\n') {
                output += options[1];
            }

        }
        return output;
    }

    private String exclude() {
        String output = "", word = "", checker = options[1];
        int i, j, count = 1, flag = 1, k;
        for (i = 0; i < this.data.length(); i++) {
            if (this.data.charAt(i) == '\n')
                count++;
        }
        String[] words = new String[count];
        count = 0;
        for (i = 0; i < this.data.length(); i++) {
            if (this.data.charAt(i) == '\n') {
                words[count++] = word;
                word = "";
            } else
                word += this.data.charAt(i);
        }
        words[count] = word;

        for (i = 0; i < words.length; i++) {
            word = words[i];
            for (j = 0; j < word.length(); j++) {
                if (word.charAt(j) == checker.charAt(0)) {
                    flag = 1;
                    for (k = 0; k < checker.length(); k++) {
                        if (word.charAt(j + k) != checker.charAt(k)) {
                            flag = 0;
                            break;
                        }
                    }
                    if (flag == 1)
                        break;
                }
            }
            if (flag == 0){
                if(i!=words.length-1)
                    output += word + "\n";
                else
                    output += word;
            }
        }
        return output;
    }

    public String stringOperations() {
        String output = "";

        switch (this.options[0]) {
            case "-c":
                output = caseConverstion();
                break;
            case "-e":
                output = encodeShiftAmount();
                break;
            case "-a":
                output = encodeASCII();
                break;
            case "-p":
                output = prefix();
                break;
            case "-x":
                output = exclude();
                break;
        }
        return output;
    }

    // public static void main(String[] args) {
    //     String[] options = { "-x", "abc" };
    //     StringOperation so = new StringOperation("SaiRam \n abcsairam \n cdeSairam", options);
    //     String output = so.stringOperations();
    //     System.out.println(output);
    // }
}
