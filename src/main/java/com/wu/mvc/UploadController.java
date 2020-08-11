package com.wu.mvc;

import com.wu.util.ExcelUtil;
import com.wu.util.po.A;
import com.wu.util.po.DummyPhantomConfigBean;
import com.wu.util.po.LenovoFRUBOMFilePo;
import com.wu.util.po.LenovoFruBomFileConfigBean;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("/up")
public class UploadController {

    @Autowired
    private  ExcelUtil excelUtil;
    @RequestMapping("/fileTypeCheck")
    public String upload(String fileType){
        //return MappingService.validateExcel(fileType);
        return "";
    }
    @RequestMapping("/resolveFileGenerateData")
    public String readExcelFile(){
        return "";
    }
    @RequestMapping(value = "/yu")
    @ResponseBody
    public Object includeExcel(@RequestParam(value="upFile") MultipartFile file,String description, HttpServletRequest request){
        // MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // MultipartFile file = multipartRequest.getFile("upfile");
        //System.out.println(description);
        excelUtil.y();
        if(file==null){
            System.out.println("file null..");
            return  null;
        }
        try {
            List<LenovoFruBomFileConfigBean> LenovoFruBomFileConfigBean = excelUtil.excelToListT(com.wu.util.po.LenovoFruBomFileConfigBean.class, file.getOriginalFilename(), 0, file.getInputStream());
            return LenovoFruBomFileConfigBean;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
        // return description;

    }


    @RequestMapping(value = "/yu1")
    @ResponseBody
    public Object includeExcel1(@RequestParam(value="upFile",required = false) MultipartFile file,@RequestParam(value="map")String map, HttpServletRequest request){
        // MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // MultipartFile file = multipartRequest.getFile("upfile");
        //System.out.println(description);
        if(file==null){
            System.out.println("file null..");
            return  null;
        }
        try {
            List<LenovoFRUBOMFilePo> lenovoFRUBOMFilePos = excelUtil.excelToListT(LenovoFRUBOMFilePo.class, file.getOriginalFilename(), 0, file.getInputStream());
            return lenovoFRUBOMFilePos;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
        // return description;

    }



    @RequestMapping(value = "/yu2")
    @ResponseBody
    public Object includeExcel2(@RequestBody Map<String,Object> map, HttpServletRequest request){
        // MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // MultipartFile file = multipartRequest.getFile("upfile");
        //System.out.println(description);
       /* if(file==null){
            System.out.println("file null..");
            return  null;
        }
        try {
            List<LenovoFRUBOMFilePo> lenovoFRUBOMFilePos = excelUtil.excelToListT(LenovoFRUBOMFilePo.class, file.getOriginalFilename(), 0, file.getInputStream());
            return lenovoFRUBOMFilePos;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;*/
        System.out.println("-------");
        return null;
        // return description;

    }
    /*@RequestMapping(value = "/yu")
    @ResponseBody
    public Object includeExcel( HttpServletRequest request){
        
         MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
         MultipartFile file = multipartRequest.getFile("upFile");
        String description = multipartRequest.getParameter("description");
        //System.out.println(description);
        if(file==null){
            return null;
        }
        try {
           return excelUtil.readExcelData(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // return description;


    }*/

    @RequestMapping(value = "/yu3")
    @ResponseBody
    public Object b(String map ,HttpServletRequest request){
        System.out.println(map);
       return "";
    }
    @RequestMapping(value = "/export")
    public void export(HttpServletResponse response,String fileName){
        response.setContentType("application/binary;charset=utf-8");
        List<LenovoFruBomFileConfigBean> data = new ArrayList<>();
        try {
            response.setHeader("content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            LenovoFruBomFileConfigBean s = new LenovoFruBomFileConfigBean();
            s.setChangeType("Create"+i);
            s.setEcDocName("i don't know"+i);
            s.setEcDocNo("aaaaa"+i);
            s.setIgnoreComponent(true);
            s.setProceedTime(new Timestamp(System.currentTimeMillis()));
            data.add(s);
        }
        try {
            excelUtil.export(LenovoFruBomFileConfigBean.class,data,fileName,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportExcelFile(HttpServletResponse response, String model) {
        try {
            List<String> list = new ArrayList<>();
            list.add("test.txt");
            list.add("test2.txt");
            //压缩后的文件
            String resourcesName = "test.zip";

            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("D:/"+resourcesName));
            InputStream input = null;

            for (String str : list) {
                String name = "D:/test/"+str;
                input = new FileInputStream(new File(name));
                zipOut.putNextEntry(new ZipEntry(str));
                int temp = 0;
                while((temp = input.read()) != -1){
                    zipOut.write(temp);
                }
                input.close();
            }
            zipOut.close();
            File file = new File("D:/"+resourcesName);
            HttpHeaders headers = new HttpHeaders();
            String filename = new String(resourcesName.getBytes("utf-8"),"iso-8859-1");
            headers.setContentDispositionFormData("attachment", filename);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    @RequestMapping(value = "/importZip", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<byte[]> importZip(@RequestParam(value="upFile") MultipartFile zip,HttpServletRequest re) {

       String zipDir = "D:/mytem/zip/"; //保存上传的文件
       String resolveZipDir = "D:/mytem/yu/"; //解压之后的目录
       File zipFile = new File(zipDir);
       File parentFile = zipFile.getParentFile();
       if(!parentFile.exists()){
           parentFile.mkdirs();
       }
       if(!zipFile.exists()){
           zipFile.mkdir();
       }
        try {
            zip.transferTo(new File(zipDir+zip.getOriginalFilename()));
            zipToFile(zipDir+zip.getOriginalFilename(),resolveZipDir,zip.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //File f = new File();
        /*String fileName = zip.getOriginalFilename();
        if(fileName.matches(".*\\.zip")){
            try {
                ZipInputStream zipInputStream = new ZipInputStream(zip.getInputStream());

                BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
                ZipEntry nextEntry = zipInputStream.getNextEntry();


                while(nextEntry!=null){
                    String zipIncludeFileName = nextEntry.getName();
                    byte[] extra = nextEntry.getExtra();
                    if(nextEntry.isDirectory()){
                        System.out.println("文件夹..");
                        continue;
                    }
                    byte[] buff = new byte[(int)nextEntry.getSize()];
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        return null;
    }


    private void zipToFile(String sourcePath,String targetPath,String zipFileName){
        String dirName = zipFileName.substring(0,zipFileName.lastIndexOf("."));
        File dir = new File(targetPath+dirName+"/");
        File parentFile = dir.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        if(!dir.exists()){
            dir.mkdir();
        }
        try {
            ZipFile zipfile = new ZipFile(sourcePath,Charset.forName("GBK"));
            Enumeration<? extends ZipEntry> entries = zipfile.entries();
            byte [] by = new byte[1024];
            while(entries.hasMoreElements()){
                ZipEntry zipEntry = entries.nextElement();
                String fileName  =zipEntry.getName();
                if(zipEntry.isDirectory()){
                    createDirIfNotExite(targetPath+dirName+"/"+fileName);
                    continue;
                }
                //by =  new byte[(int)zipEntry.getSize()];
                InputStream inputStream = zipfile.getInputStream(zipEntry);
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetPath+dirName+"/"+fileName));
                int count = inputStream.read(by);
                while(count!=-1){
                    outputStream.write(by,0,count);
                    outputStream.flush();
                    count = inputStream.read(by);
                }
                outputStream.close();
                inputStream.close();
            }

            zipfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createDirIfNotExite(String dir){
        File f = new File(dir);
        File parentFile = f.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        if(!f.exists()){
            f.mkdir();
        }
    }

    public static void unRarFile(String srcRarPath, String dstDirectoryPath) {
        if (!srcRarPath.toLowerCase().endsWith(".rar")) {
            System.out.println("非rar文件！");
            return;
        }

        File dir = new File(dstDirectoryPath + "/");
        File parentFile = dir.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!dir.exists()) {
            dir.mkdir();
        }
    }


}
