package foodDelivery.util;

public class FormatString {

    public static boolean documentFormat(String document) {
        if (document == null) return false;

        String numeric = document.replaceAll("[^\\d]", "");

        if (numeric.length() == 11) {
            return true;
        } else if (numeric.length() == 14) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean zipCodeFormat(String zipCode) {
        if (zipCode == null) return false;

        String numeric = zipCode.replaceAll("[^\\d]", "");

        if (numeric.length() == 8) {
            return true;
        } else {
            return false;
        }
    }
}
