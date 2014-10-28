package us.fok.lenzenslijper.util;

import javax.xml.bind.DatatypeConverter;

public class StringUtilities {

    public static boolean stringIsPresent(String str) {
        return (str != null) && !str.trim().isEmpty();
    }

    public static byte[] readBase64Bytes(String str) {
        return DatatypeConverter.parseBase64Binary(str);
    }

}


