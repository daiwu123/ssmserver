package com.wu.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RestController
public class BigFileUploadController {

    @RequestMapping("uploadfile")
    public String upload(MultipartFile blob, HttpServletRequest request) throws  Exception {
        // 搜素目录下是否包含有相同的MD5文件？
        String savePath = "E:\\a";
        int total = Integer.valueOf(request.getParameter("count"));
        int index = Integer.valueOf(request.getParameter("index"));
        String fileName = request.getParameter("fileName");
        // 文件夹位置
        System.out.println("----");
        File file = new File(savePath + File.separator + index+".temp");
        file.createNewFile();
        blob.transferTo(file);
        if(index==total-1){
             //说明已经全部上传，开始合并
            File newFile = new File(savePath,fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(newFile,true);
            byte[] by = new byte[1024];
            for (int i = 0; i <total ; i++) {
                FileInputStream in = new FileInputStream(new File(savePath,i+".temp"));
                int read = in.read(by);
                while (read!=-1){
                    fileOutputStream.write(by,0,read);
                    fileOutputStream.flush();
                    read =in.read(by);
                }
                in.close();
            }
            fileOutputStream.close();
        }
        return "1";
    }
}
