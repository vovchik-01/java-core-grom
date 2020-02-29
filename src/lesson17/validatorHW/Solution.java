package lesson17.validatorHW;

public class Solution {
    public static void main(String[] args) {
        String adress = "http://http://hjlsa1lgjhklfk.com";
        System.out.println(validate(adress));

    }

//    адрес должен начинаться с названия протокола, допустимые - http:// или https://
//    www не обязательно
//    доменная зона должна разделяться точкой, допустимые - com, org, net
//    другие точки в названии адреса а так же спецчимволы не допускаются

    public static boolean validate(String address) {
        if (address == null) {
            return false;
        }

        String[] protocols = {"http://", "https://"};
        String[] domens = {".com", ".org", ".net"};

        if (!address.contains("http://") && !address.contains("https://")) {
            return false;
        } else
            address = address.replace("https://", " ");
        address = address.replace("http://", " ");

        if (!address.contains(".com") && !address.contains(".org") && !address.contains(".net")) {
            return false;
        } else
            address = address.replaceAll(".com", " ");
        address = address.replaceAll(".org", " ");
        address = address.replaceAll(".net", " ");
        address = address.trim();
        System.out.println(address);
        if (!isLetterOrDigit(address)) {
            return false;
        }
        return true;
    }


    private static boolean isLetterOrDigit(String sentence) {
        char[] chars = sentence.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

}
