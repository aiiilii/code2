public class AddStrings {

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num1.equals("0")) {
            return num2;
        }
        if (num2 == null || num2.length() == 0 || num2.equals("0")) {
            return num1;
        }
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int digit1 = (int)(num1.charAt(i) - '0');
            int digit2 = (int)(num2.charAt(j) - '0');
            int digitVal = digit1 + digit2 + carry;
            sb.append(digitVal % 10);
            carry = digitVal / 10;
            i --;
            j --;
        }
        while (i >= 0) {
            int digit1 = (int)(num1.charAt(i) - '0');
            int digitVal = digit1 + carry;
            sb.append(digitVal % 10);
            carry = digitVal / 10;
            i --;
        } 
        while (j >= 0) {
            int digit2 = (int)(num2.charAt(j) - '0');
            int digitVal = digit2 + carry;
            sb.append(digitVal % 10);
            carry = digitVal / 10;
            j --;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "1";
        System.out.println(addStrings(num1, num2));
    }
}