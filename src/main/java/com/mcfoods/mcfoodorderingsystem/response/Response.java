package com.mcfoods.mcfoodorderingsystem.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

/*
   A wrapper class fo standard responses
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private   String message;
    private   T data;
    private   int status;
    private LocalDateTime timestamp;

    public static <T> Response<T> success(T data, String message, int statusCode) {

        return Response.<T>builder()
                .status(statusCode)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();

    }

    public static <T> Response<T> error(String message, int statusCode) {

        return  Response.<T>builder()
                .status(statusCode)
                .message(message)
                .data(null)
                .timestamp(LocalDateTime.now())
                .build();
    }

}
