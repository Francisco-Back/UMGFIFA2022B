package com.umg.edu.UMGFIFA2022B.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();
    public CloudinaryService(){
        valuesMap.put("cloud_name", "dy67idmht");
        valuesMap.put("api_key", "152274397644752");
        valuesMap.put("api_secret", "tLigYy3mhwLQdcMFkOX3fFyd-TI");
        cloudinary = new Cloudinary(valuesMap);
    }

public Map upload(MultipartFile multipart) throws IOException{
    File file = convert(multipart);
    Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    file.delete();
    return result;
}

public Map delete(String id) throws IOException{
    Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    return result;
}

private File convert (MultipartFile multipart) throws IOException{
    File file = new File(multipart.getOriginalFilename());
    FileOutputStream fo = new FileOutputStream(file);
    fo.write(multipart.getBytes());
    fo.close();
    return file;
}
}
