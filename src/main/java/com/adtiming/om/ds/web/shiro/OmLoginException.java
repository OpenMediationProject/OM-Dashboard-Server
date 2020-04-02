// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web.shiro;

public class OmLoginException extends RuntimeException {
    public OmLoginException() {
        super();
    }

    public OmLoginException(String message) {
        super(message);
    }

    public OmLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
