public class AddBinary {

    public static String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while (i >= 0 && j >= 0) {
            int digitVal = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            sb.append(digitVal % 2);
            carry = digitVal / 2;
            i --;
            j --;
        }
        while (i >= 0) {
            int digitVal = (a.charAt(i) - '0') + carry;
            sb.append(digitVal % 2);
            carry = digitVal / 2;
            i --;
        }
        while (j >= 0) {
            int digitVal = (b.charAt(j) - '0') + carry;
            sb.append(digitVal % 2);
            carry = digitVal / 2;
            j --;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}