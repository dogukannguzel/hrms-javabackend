package kodlamaio.hrms.core.utilities.ımageService;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Service
public class ImageManager implements ImageService {

   private final Cloudinary cloudinary;

   @Value("${cld.access-key}")
   private String apiKey;

    @Value("${cld.secret-key}")
   private String accessKey;


    private Map<String, String> valuesMap = new HashMap<>();

    public ImageManager() {
        valuesMap.put("cloud_name", "dqjuu6nph");
        valuesMap.put("api_key", apiKey);
        valuesMap.put("api_secret", accessKey);
        cloudinary = new Cloudinary(valuesMap);
    }


    @Override
    public DataResult<?> save(MultipartFile file) throws IOException {

        try{
            Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
        } catch (IOException e){

        }
        return new ErrorDataResult<Map>();
    }
}
