package com.frank;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:22 2019-10-29
 * @ Description：RSA加解密
 * @ Modified By：
 */
public class RSAUtils {

  /**
   * 缺省的2048位密钥对,可处理245个字节(81个汉字)的数据
   */
  public static String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKI6maQOqWgep69S0FuyLkk8XoRiZfj7DppNpl9FvRIC/GhkXmEBBkdd2Ak8Ra/PUX1x/ELlCK8hdPy2alGx0r/1AyX+UsJTJkGvrWcqKlaNZaPOPSpcCPyNlUEbIDEllmajTXA8JVQgxxliGtCsW17STCnkTlxYdEJrS2B0l3JHAgMBAAECgYAHcYbhJycQtu9ctQEIZAmJpLJ1gopJPUOzQsLSdkGxlN997rUB4GkoVx71dYWBBpMnnVZEv3uBhZh3i+se6njP8QaaB/cUlOoNdgAE9AKuk2zjDOrW7MvvlC+md+Rtoi6niJ1SR+rcrPRueLKeRSNtJohXZoWGBglyXD59YYOmOQJBAOxsdmPpG68GWEcqAV61icouEirjIOvDkoZipfDtlWjiMWe0jd0zgjNd9j77IdpaHMsq1oW4+avdFpPiihhNq1UCQQCvqWkmBirFRe9c+qzhMlhKB/AnfXdg36VxFfH0ve3XEjiHuE7P5/qjKgQjHbo/xPU9Z3t6xQOziBGPp1uuWv8rAkEAqs21Pnsjr/ACiO807Cp1MKbWIzvSBeJWElZkkkninlKD5OtRblSPJPMmOtwN2gUuNi1trFA1uE9Sx2Zr5CEAvQJAXj5c7IqYfdiEkHTpNbUGC0nw/a7h0naK0347ntwbc60R6TboCcFjBhEvwQtc9oOcM4KGjBqRXsvc6B6ZIJUvmwJBALjGGBf02+jUoon6EItHr2Q9w/HyfmQERXeIT5bITn40oHm/8LRf+lYxqGm+BkPiN53qAJNP2WoqdVjZf+LUw1w=";

  public static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiOpmkDqloHqevUtBbsi5JPF6EYmX4+w6aTaZfRb0SAvxoZF5hAQZHXdgJPEWvz1F9cfxC5QivIXT8tmpRsdK/9QMl/lLCUyZBr61nKipWjWWjzj0qXAj8jZVBGyAxJZZmo01wPCVUIMcZYhrQrFte0kwp5E5cWHRCa0tgdJdyRwIDAQAB";

  /**
   * 字符集
   */
  public static String CHARSET = "utf-8";

  /**
   * 签名算法
   */
  public static final String SIGNATURE_INSTANCE = "SHA1WithRSA";

  /**
   * 生成密钥对
   * @param keyLength
   * @return
   * @throws Exception
   */
  public static KeyPair getKeyPair(int keyLength) throws Exception {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(keyLength);
    return keyPairGenerator.generateKeyPair();
  }

  /**
   * 公钥字符串转PublicKey实例
   * @param publicKey
   * @return
   * @throws Exception
   */
  public static PublicKey getPublicKey(String publicKey) throws Exception {
    byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey.getBytes());
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePublic(keySpec);
  }

  /**
   * 私钥字符串转PrivateKey实例
   * @param privateKey
   * @return
   * @throws Exception
   */
  public static PrivateKey getPrivateKey(String privateKey) throws Exception {
    byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey.getBytes());
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePrivate(keySpec);
  }

  /**
   * 公钥加密
   * @param content
   * @param publicKey
   * @return
   * @throws Exception
   */
  public static byte[] encryptByPublicKey(byte[] content, PublicKey publicKey) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    return cipher.doFinal(content);
  }

  public static byte[] encryptByPublicKey(byte[] content) throws Exception {
    return encryptByPublicKey(content, getPublicKey(PUBLIC_KEY));
  }

  public static String encryptByPublicKey(String content, String publicKey) throws Exception {
    return new String(Base64.getEncoder().encode(encryptByPublicKey(content.getBytes(CHARSET), getPublicKey(publicKey))));

  }

  public static String encryptByPublicKey(String content) throws Exception {
    return new String(Base64.getEncoder().encode(encryptByPublicKey(content.getBytes(CHARSET))));
  }

  /**
   * 私钥解密
   * @param content
   * @param privateKey
   * @return
   * @throws Exception
   */
  public static byte[] decryptByPrivateKey(byte[] content, PrivateKey privateKey) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    return cipher.doFinal(content);
  }

  public static byte[] decryptByPrivateKey(byte[] content) throws Exception {
    return decryptByPrivateKey(content, getPrivateKey(PRIVATE_KEY));
  }

  public static String decryptByPrivateKey(String content, String privateKey) throws Exception {
    return new String(decryptByPrivateKey(Base64.getDecoder().decode(content), getPrivateKey(privateKey)), CHARSET);

  }

  public static String decryptByPrivateKey(String content) throws Exception {
    return new String(decryptByPrivateKey(Base64.getDecoder().decode(content)), CHARSET);
  }

  /**
   * 私钥加密
   * @param content
   * @param privateKey
   * @return
   * @throws Exception
   */
  public static byte[] encryptByPrivateKey(byte[] content, PrivateKey privateKey) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.ENCRYPT_MODE, privateKey);
    return cipher.doFinal(content);
  }

  public static byte[] encryptByPrivateKey(byte[] content) throws Exception {
    return encryptByPrivateKey(content, getPrivateKey(PRIVATE_KEY));
  }

  public static String encryptByPrivateKey(String content, String privateKey) throws Exception {
    return new String(encryptByPrivateKey(content.getBytes(CHARSET), getPrivateKey(privateKey)), CHARSET);
  }

  public static String encryptByPrivateKey(String content) throws Exception {
    return new String(encryptByPrivateKey(content.getBytes(CHARSET)), CHARSET);
  }

  /**
   * 公钥解密
   * @param content
   * @param publicKey
   * @return
   * @throws Exception
   */
  public static byte[] decrypByPublicKey(byte[] content, PublicKey publicKey) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, publicKey);
    return cipher.doFinal(content);
  }

  public static byte[] decrypByPublicKey(byte[] content) throws Exception {
    return decrypByPublicKey(content, getPublicKey(PUBLIC_KEY));
  }

  public static String decrypByPublicKey(String content, String publicKey) throws Exception {
    return new String(decrypByPublicKey(Base64.getDecoder().decode(content), getPublicKey(publicKey)), CHARSET);

  }

  public static String decrypByPublicKey(String content) throws Exception {
    return new String(decrypByPublicKey(Base64.getDecoder().decode(content)), CHARSET);
  }

  /**
   * 签名
   * @param content
   * @param privateKey
   * @return
   * @throws Exception
   */
  public static byte[] sign(byte[] content, PrivateKey privateKey) throws Exception {
    Signature signature = Signature.getInstance(SIGNATURE_INSTANCE);
    signature.initSign(privateKey);
    signature.update(content);
    return signature.sign();
  }

  public static byte[] sign(byte[] content) throws Exception {
    return sign(content, getPrivateKey(PRIVATE_KEY));
  }

  public static String sign(String content, String privateKey) throws Exception {
    return new String(Base64.getEncoder().encode(sign(content.getBytes(CHARSET), getPrivateKey(privateKey))), CHARSET);
  }

  public static String sign(String content) throws Exception {
    return new String(Base64.getEncoder().encode(sign(content.getBytes(CHARSET))), CHARSET);
  }

  /**
   * 验签
   * @param content
   * @param sign
   * @param publicKey
   * @return
   * @throws Exception
   */
  public static boolean verify(byte[] content, byte[] sign,  PublicKey publicKey) throws Exception {
    Signature signature = Signature.getInstance(SIGNATURE_INSTANCE);
    signature.initVerify(publicKey);
    signature.update(content);
    return signature.verify(sign);
  }

  public static boolean verify(byte[] content, byte[] sign) throws Exception {
    return verify(content, sign, getPublicKey(PUBLIC_KEY));
  }

  public static boolean verify(String content, String sign, String publicKey) throws Exception {
    return verify(content.getBytes(CHARSET), Base64.getDecoder().decode(sign), getPublicKey(publicKey));
  }

  public static boolean verify(String content, String sign) throws Exception {
    return verify(content.getBytes(CHARSET), Base64.getDecoder().decode(sign), getPublicKey(PUBLIC_KEY));
  }

  public static void main(String[] args){
    try {
      KeyPair keyPair = RSAUtils.getKeyPair(1024);
      PublicKey publicKey = keyPair.getPublic();
      PrivateKey privateKey = keyPair.getPrivate();
      System.out.println(new String(Base64.getEncoder().encode(publicKey.getEncoded())));
      System.out.println(new String(Base64.getEncoder().encode(privateKey.getEncoded())));
      String enCode = encryptByPublicKey("test");
      System.out.println("enCode:"+enCode);
      String deCode = decryptByPrivateKey(enCode);
      System.out.println("deCode:"+deCode);
      System.out.println("PRIVATE_KEY:"+PRIVATE_KEY);
      System.out.println("PUBLIC_KEY:"+PUBLIC_KEY);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
