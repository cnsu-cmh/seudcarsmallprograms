package com.xiaoshu.seudcarsmallprograms.util;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Base64Img {

    private final static String BASE64PRE ="data:image/jpg;base64,";

    public static String  getBase64ImageStr(String imgPath) {
        return  BASE64PRE + getImageStrFromPath(imgPath);
    }

    /**
     * 将一张本地图片转化成Base64字符串
     * @param imgPath
     * @return
     */
    public static String getImageStrFromPath(String imgPath) {
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        //
        try {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return new String(Base64.encodeBase64(data));
    }

}
