package us.fok.lenzenslijper.util;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class WebDigest {

    private WebDigest() {}

    private static HashFunction md5Factory = Hashing.md5();

    public static String digest(byte[] input) {
        Hasher md5 = md5Factory.newHasher();
        md5.putBytes(input);
        return md5.hash().toString();
    }

    public static String digest64(byte[] bytes) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(bytes);
        return DatatypeConverter.printBase64Binary(md.digest());
    }

}
