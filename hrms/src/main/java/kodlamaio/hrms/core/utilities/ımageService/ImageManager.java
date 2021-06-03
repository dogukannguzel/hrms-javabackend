package kodlamaio.hrms.core.utilities.ımageService;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Service
public class ImageManager implements ImageService {

   private final Cloudinary cloudinary;

    private Map<String, String> valuesMap = new HashMap<>();

    public ImageManager() {
        valuesMap.put("cloud_name", "dqjuu6nph");
        valuesMap.put("api_key", "526186952178517");
        valuesMap.put("api_secret", "EeJpC1Z3gxol6XLrrRKI4JYzgW0");
        cloudinary = new Cloudinary(valuesMap);
    }



    public DataResult<?> save(MultipartFile file) throws IOException {


        try{
            Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
        } catch (IOException e){

        }
        return new ErrorDataResult<Map>();



    }




}
