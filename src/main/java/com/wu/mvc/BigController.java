package com.wu.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

@Controller
public class BigController {
    private  String savePath =  "E:/a";
    @SuppressWarnings("rawtypes")
    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile fileData, HttpServletRequest request) throws IllegalStateException, Exception {
        // 搜素目录下是否包含有相同的MD5文件？
        String originFileName = request.getParameter("originFileName");
        int total = Integer.valueOf(request.getParameter("total"));// 总片数
        int index = Integer.valueOf(request.getParameter("index"));// 当前是第几片,第一片index必须为0
        String fileMd5 = request.getParameter("fileMd5"); // 整个文件的md5
        // 文件夹位置
        File parent = new File(savePath + File.separator + fileMd5);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        // 文件分片位置
        File file = new File(parent, fileMd5 + "_" + index);
        // 保存分片到本地
        if (file.exists()) {
            file.delete();
        }
        fileData.transferTo(file);

        // 判断所有分片是否全部上传完成，完成则合并
        File dir = new File(savePath + File.separator + fileMd5);
        File[] files = dir.listFiles();
        if (files.length == total) {// 上传完成
            FileOutputStream fileOutputStream = null;
            FileInputStream temp = null;// 文件分片
            File newFile = new File(dir, originFileName);

            fileOutputStream = new FileOutputStream(newFile, true);
            byte[] byt = new byte[10 * 1024 * 1024];
            int len;

            for (int i = 0; i < total; i++) {
                temp = new FileInputStream(new File(dir, fileMd5 + "_" + i));
                while ((len = temp.read(byt)) != -1) {
                    fileOutputStream.write(byt, 0, len);
                }
            }
            fileOutputStream.close();
            temp.close();
            // 全部完成之后，删除分片
            for (int i = 0; i < total; i++) {
                File splitFile = new File(dir, fileMd5 + "_" + i);
                if (splitFile.exists()) {
                    splitFile.delete();
                }
            }
        }


        return "1";
    }

    /**
     * 获取视频文件的MD5值，这里MD5计算算法应与前端保持一致
     */
    private String getFileMD5(File file) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        // 16进制
        return bigInt.toString(16);
    }

    /**
     * 检测整个视频是否已上传。
     * 考虑到用户效率，采用前端MD5计算算法确认文件唯一性，理论上文件不同而摘要相同的概率几近于0。
     * 对于发生hash碰撞的文件，系统认为文件相同而不会接收。
     */
    @RequestMapping("isFileExist")
    @ResponseBody
    public String isFileExist(HttpServletRequest request) {
        File pdir = new File(savePath);
        if (!pdir.exists()) {
            pdir.mkdirs();
        }
        String fileMd5 = request.getParameter("fileMd5");
        File dir = new File(savePath + File.separator + fileMd5);
        if (dir.exists()) {// 目录存在
            File file = new File(dir, fileMd5);
            if (file.exists()) {// 文件存在
                return "1";  //视频分片已上传
            } else {//

                return "-1";  //视频分片已损坏
            }
        } else {

            return "文件未上传"; //视频分片未上传
        }
    }

    /**
     * 检测视频分片是否已上传
     */
    @RequestMapping("isFileSplitExist")
    @ResponseBody
    public String isFileSplitExist(HttpServletRequest request) {

        String splitMd5 = request.getParameter("md5");// 分片Md5
        String fileMd5 = request.getParameter("fileMd5");// 文件md5
        String index = request.getParameter("index");// 第几片

        File file = new File(savePath + File.separator + fileMd5, fileMd5 + "_" + index);
        if (file.exists()) {
            if (splitMd5.equals(getFileMD5(file))) {
                return "1";//视频分片已上传
            } else {// 视频分片损坏，删除重传
                file.delete();
                return "-1"; //视频分片已损坏
            }
        } else {
            return "-1";//视频分片未上传
        }

    }
}
