public class PlusOne {

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] ++;
            return digits;
        }
        
        int last = digits.length - 1;
        while (last >= 0 && digits[last] == 9) {
            digits[last] = 0;
            last --;
            if (last >= 0 && digits[last] < 9) {
                digits[last] ++;
                break;
            }
        }
        if (digits[0] != 0) {
            return digits;
        } else {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
    }

    public static void main(String[] args) {
        int[] digits = new int[] {8, 9, 9, 9};
        int[] newDigits = plusOne(digits);
        for (int i = 0; i < newDigits.length; i++) {
            System.out.print(newDigits[i] + " ");
        }
    }
}