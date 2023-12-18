package umc.spring.apiPayload.Exception.handler;

import umc.spring.apiPayload.Exception.GeneralException;
import umc.spring.apiPayload.code.BaseErrorCode;

public class FoodTypeHandler extends GeneralException {
    public FoodTypeHandler(BaseErrorCode errorCode) {super(errorCode);}
}
