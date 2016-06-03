package com.qcloud.project.macaovehicle.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.codec.binary.Base64;

public class Base64PicUtil {

    public static void main(String[] args) throws IOException {

        String picSourcePath = "C:" + File.separator + "Users" + File.separator + "Mark.Li" + File.separator + "Desktop" + File.separator + "test.jpg";
        String picTargetPath = "C:" + File.separator + "Users" + File.separator + "Mark.Li" + File.separator + "Desktop" + File.separator + "testTarget.jpg";
        /*
         * String strImg = GetImageStr(picSourcePath); System.out.println(strImg);
         */
        // String strImg = FileUtil.readFileByLines("C:" + File.separator + "Users" + File.separator + "Mark.Li" + File.separator + "Desktop" + File.separator + "1458100207741.txt");
        // System.out.println(strImg);
        // GenerateImage(strImg,picTargetPath);
    }

    // 图片转化成base64字符串
    @SuppressWarnings("static-access")
    public static String GetImageStr(String picPath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理

        // String imgFile = "d://test.jpg";// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(picPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        Base64 base64 = new Base64();
        byte[] enbytes = base64.encodeBase64Chunked(data);
        return new String(enbytes);// 返回Base64编码过的字节数组字符串
    }

    // base64字符串转化成图片
    @SuppressWarnings("static-access")
    public static boolean GenerateImage(String imgStr, String picPath) { // 对字节数组字符串进行Base64解码并生成图片

        if (imgStr == null) // 图像数据为空
            return false;
        try {
            // Base64解码
            Base64 base64 = new Base64();
            byte[] b = base64.decodeBase64(imgStr.getBytes());
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            // String imgFilePath = "d://222.jpg";// 新生成的图片
            OutputStream out = new FileOutputStream(picPath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}