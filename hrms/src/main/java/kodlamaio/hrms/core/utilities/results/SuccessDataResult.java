package kodlamaio.hrms.core.utilities.results;

import kodlamaio.hrms.entities.dtos.CandidateGetDto;

import java.util.List;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult() {
        super(null,true);
    }

    public SuccessDataResult(T data, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(String message) {
        super(null,true,message);
    }

    public SuccessDataResult(T data){
        super(data,true);
    }

    public SuccessDataResult(List<T> data) {
        super((T) data,true);
    }
}
