package NumberValid;
public class CheckIfValid  {
    public static boolean isValidPhone(String c){
        if (c.length() == 14 && c.charAt(0) == '(' && c.charAt(4) == ')' && c.charAt(5) ==  ' ' && c.charAt(9) == '-'){
            return true;
        } else if (c.length() == 12 && c.charAt(3) == '-' && c.charAt(7) == '-') {
            return true;
        }
        return false;
    }
}
