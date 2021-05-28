package kodlamaio.hrms.core.utilities.businessEngine;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRun {

    public static Result run(Result... logics){
        for (Result logic:logics) {
            if (!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
    }


}
