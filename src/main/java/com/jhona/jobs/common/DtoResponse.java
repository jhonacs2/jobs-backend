package com.jhona.jobs.common;

import constants.ResponseConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoResponse<T> extends CommonResponse {
    private T content;

    public DtoResponse() {
        super(ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
    }
}
