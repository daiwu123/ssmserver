package com.wu.mvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@RestController
public class WuUploaderController {
    private static String rootPath = "E:\\a";


    @RequestMapping("isFirstUpload")
    public Object isFirstUpload(String md5dirname,String originName,Long size) throws IOException, NoSuchAlgorithmException {
        File file = new File(rootPath+File.separator+md5dirname);
        if(!file.exists()){
            file.mkdir();
        }
        File result = new File(rootPath+File.separator+md5dirname,originName);
        if(result.exists()){
            if(result.length() == size){
                //已经上传成功了
                return "1";
            }else{
                //删除，重新上传
                result.delete();
                return "-1";
            }
        }else{
            return "-1";
        }
    }
   /* private String getCurMD5FileStr(File file) throws FileNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
        randomAccessFile.seek();
    }*/


    private String getMD5Str(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream(file);
        long fileSize =  file.length();
        byte by [] = new byte[(int)fileSize];
        int read = in.read(by);

        if(read>1024){
            digest.update(by,0,1024);
            digest.update(by,(int)(fileSize-1024),1024);
        }else{
            digest.update(by,0,read);
        }
        in.close();
        byte[] digest1 = digest.digest();
        BigInteger integer = new BigInteger(1,digest1);
        String  blobName= integer.toString(16);
        return blobName;
    }
    @RequestMapping("cru_upload")
    public Object isSheetFileUpload(MultipartFile fileData,HttpServletRequest request) throws IOException, NoSuchAlgorithmException {
        String fileMD5Name = request.getParameter("fileMD5Name");
        Integer index= Integer.parseInt(request.getParameter("index"));
        String curBolbMD5Name = request.getParameter("curBolbMD5Name");
        Integer total = Integer.parseInt(request.getParameter("total"));
        String originFileName = request.getParameter("originFileName");
        File file = new File(rootPath+File.separator+fileMD5Name,fileMD5Name+"_"+index);
        if(file.exists()){
            //表示已经上传-
            if(curBolbMD5Name.equalsIgnoreCase(getMD5Str(file))){
                //表示上传，且正确，无需再次上传
                System.out.println("已经上传"+index);
            }else{
                file.delete();
                //File newFile = new File(rootPath+File.separator+fileMD5Name,curBolbMD5Name+"_"+index);
                fileData.transferTo(file);
                //上传了，但是已经损坏了;
                //删除，重新上传
            }

        }else{
            //没有上传，请上传
            try {
                fileData.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(index==total-1){
            //说明文件已经全部上传完毕，开始整合
            File fileParent = new File(rootPath+File.separator+fileMD5Name);
            File[] files = fileParent.listFiles();
            byte[] b = new byte[1024];
            FileInputStream fileIn = null;
            FileOutputStream fileOut = new FileOutputStream(rootPath+File.separator+fileMD5Name+File.separator+originFileName);
            for (int i = 0; i <files.length ; i++) {
               File curFile =  files[i];
                fileIn = new FileInputStream(curFile);
                int count  = fileIn.read(b);
                while(count!=-1){
                    fileOut.write(b,0,count);
                    fileOut.flush();
                    count  = fileIn.read(b);
                }
                fileIn.close();
                curFile.delete();
            }
            fileOut.close();

        }
        return null;
    }


}
