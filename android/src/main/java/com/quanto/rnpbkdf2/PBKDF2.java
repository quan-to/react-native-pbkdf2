package rnpbkdf2;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PBKDF2 extends ReactContextBaseJavaModule {

    private static final Integer SHA512_DIGEST_LENGTH = 512;

    public PBKDF2(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static String derivationKey(String pwd, String salt, Integer cost, Integer length)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS5S2ParametersGenerator gen = new PKCS5S2ParametersGenerator(new SHA512Digest());
        gen.init(pwd.getBytes(StandardCharsets.UTF_8), salt.getBytes(StandardCharsets.UTF_8), cost);
        byte[] key = ((KeyParameter) gen.generateDerivedParameters(length)).getKey();
        return bytesToHex(key);
    }

    @Override
    public String getName() {
        return "PBKDF2";
    }

    @ReactMethod
    public void derivationKey(String pwd, String salt, Integer iterations, Promise promise) {
        try {
            String strs = derivationKey(pwd, salt, iterations, SHA512_DIGEST_LENGTH);
            promise.resolve(strs);
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }
}