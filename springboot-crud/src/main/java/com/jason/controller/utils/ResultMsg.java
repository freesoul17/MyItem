package com.jason.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultMsg {
    private Boolean flag;
    private Object data;
    private String msg;

    public ResultMsg(Boolean flag) {
        this.flag = flag;
    }

    public ResultMsg(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultMsg(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public ResultMsg(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
