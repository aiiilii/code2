public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int l1 = num1.length();
        int l2 = num2.length();
        
        int[] products = new int[l1 + l2];
        
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                
                products[i + j + 1] += digit1 * digit2;
            }
        }
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int k = products.length - 1; k >= 0; k --) {
            int digitVal = products[k] + carry;
            sb.append(digitVal % 10);
            carry = digitVal / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        String res = sb.reverse().toString();
        
        int index = 0;
        while (index < res.length() && res.charAt(index) == '0') {
            index ++;
        }
        
        return res.substring(index);
    }

    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        System.out.println(multiply(num1, num2));
    }
}