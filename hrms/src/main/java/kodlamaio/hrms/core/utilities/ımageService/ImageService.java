package kodlamaio.hrms.core.utilities.ımageService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
   DataResult<?> save(MultipartFile file) throws IOException;
}
