package com.ctc.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping(value={"/lmsscs0100", "/lmsscs0200", "/lmsscs0220"})
    public String index() {
        return "index.html";
    }

}
