package com.demo.splitwiseapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T> {
    private ResponseStatus responseStatus;
    private T data;
}
