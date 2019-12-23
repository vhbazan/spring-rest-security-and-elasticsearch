package com.vhbazanm.exception;

import com.vhbazanm.constant.Constants;

public class PostNotFoundException extends RuntimeException  {

    public PostNotFoundException() {
        super(Constants.ALERT_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}
