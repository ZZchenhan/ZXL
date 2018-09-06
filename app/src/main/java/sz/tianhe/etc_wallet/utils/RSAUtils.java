package sz.tianhe.etc_wallet.utils;


import org.bouncycastle.util.encoders.Base64;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


/**
 * @Author ch
 * @Date Create int 2018/9/5 18:16
 * @email 869360026@qq.com
 * rsa 工具类
 */
public class RSAUtils {

    /**
     * 生成公钥和私钥文件
     * @param length 长度
     * @param publickKeyPath 公钥位置
     * @param privateKeyPath 私钥位置
     */
    public static void productKeys(int length,String publickKeyPath,String privateKeyPath){
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom secureRandom = new SecureRandom(new Date().toString().getBytes());
            keyPairGenerator.initialize(length, secureRandom);
            KeyPair keyPair = keyPairGenerator.genKeyPair();
            byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
            FileOutputStream fos = new FileOutputStream(publickKeyPath);
            fos.write(Base64.encode(publicKeyBytes));
            fos.close();
            byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
            fos = new FileOutputStream(privateKeyPath);
            fos.write(Base64.encode(privateKeyBytes));
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 加载密钥
     */
    /**
     * 获取公钥
     * @param filename
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String filename) throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);
        dis.close();
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decode(keyBytes));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    /**
     * 根据公钥字符串加密获取公钥字符
     * @param publicKey
     * @return
     */
    public static PublicKey getPublicKeyByString(String publicKey) throws Exception{
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decode(publicKey.getBytes()));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }


    /**
     * 获取私钥
     * @param filename
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String filename)throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);
        dis.close();
        PKCS8EncodedKeySpec spec =new PKCS8EncodedKeySpec(Base64.decode(keyBytes));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }


    /**
     * 根据私钥字符串获取私钥
     * @param privateKey 私钥字符串
     * @return
     */
    public static PrivateKey getPrivateKeyByString(String privateKey) throws Exception {
        PKCS8EncodedKeySpec spec =new PKCS8EncodedKeySpec(Base64.decode(privateKey.getBytes()));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }



    /**
     * 加密数据
     * @param srcData
     * @param key
     * @param mode
     * @return
     */
    private static byte[] processData(byte[] srcData, Key key,int mode){
        //用来保存处理结果
        byte[] resultBytes = null;

        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            //构建Cipher对象，需要传入一个字符串，格式必须为"algorithm/mode/padding"或者"algorithm/",意为"算法/加密模式/填充方式"
            Cipher cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
            //初始化Cipher，mode指定是加密还是解密，key为公钥或私钥
            cipher.init(mode,key);
            //处理数据
            resultBytes = cipher.doFinal(srcData);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        return resultBytes;
    }

        /*
        使用公钥加密数据，结果用Base64转码
     */
    public static String encryptDataByPublicKey(byte[] srcData, PublicKey publicKey){
        byte[] resultBytes = processData(srcData,publicKey,Cipher.ENCRYPT_MODE);
        return new String(Base64.encode(resultBytes));
    }

    /*
       使用私钥解密，返回解码数据
    */
    public static byte[] decryptDataByPrivate(String encryptedData, PrivateKey privateKey){
        byte[] bytes = Base64.decode(encryptedData);
        return processData(bytes,privateKey,Cipher.DECRYPT_MODE);
    }

    /*
    使用私钥进行解密，解密数据转换为字符串，使用utf-8编码格式
 */
    public static String decryptedToStrByPrivate(String encryptedData, PrivateKey privateKey){
        return new String(decryptDataByPrivate(encryptedData,privateKey));
    }


    public static void main(String[] avgs) throws Exception {
        //productKeys(2048,"E:\\keys\\publick","E:\\keys\\private");
        PrivateKey privateKey = getPrivateKey("E:\\keys\\private");
        PublicKey publicKey = getPublicKey("E:\\keys\\publick");
        System.out.println(encryptDataByPublicKey("10132456".getBytes(),publicKey));

        System.out.println(
                decryptedToStrByPrivate("Byb00N0NJECTUlOXpZt0vTanAV16zRD8KwgC+q9cAIAdIVrHnnrc7H7yCw5XIqV88g9axYm0j3Fj8krg+c567Q+xeh/NWmMkzU7dIxyDrHi9qc2/s6hQ2hwy9t5faFLnru1ViMM8+V9YSc4LKKQiwrOKRwtHx3XDxKfvdVeQ9khZpeeHkW20vOgR2MyRbPPDwvkji2J9+EG4sj+9ikc6QXjWkVunlbl4cjIVKibxz+v17Fx5CJyEB+Dc4LZ07fLMqj2W9WMrnmnx+1RQGVeUK/N4T0iJcX2SLVyw80+yJu+HqWBA/F4H5/q7YDTHZgiBmXwm0R0ZppiibOFS9TVnCg==",privateKey));  }
}
