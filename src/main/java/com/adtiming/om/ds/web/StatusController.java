// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * status interface
 *
 * @author wuwei
 */
@RestController
public class StatusController {

    protected static final Logger log = LogManager.getLogger();

    @RequestMapping("/check")
    public Response check() {
        return Response.build();
    }

}
