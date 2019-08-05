package com.schoolofnet.SpringGradle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloWorld {

    @GetMapping
    public String sayHello() {
        return "Hello from SpringBoot by School of net";
    }

//    @GetMapping("/subpath")
//    public String subPath() {
//        return "This is one subPath of endpoint /";
//    }

//    @GetMapping("/subpath")
//    public String subPath(@RequestParam("name") String name) {
//        return "This is one subPath of endpoint /" + name;
//    }

//    @GetMapping("/subpath")
//    public String subPath(final WebRequest webRequest) {
//        String name = webRequest.getParameter("name");
//
//        if (name != null) { return "This is one subPath of endpoint /" + name; }
//
//        return "No query params";
//    }

    @GetMapping("/subpath")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String subPath(@RequestParam(value = "name", required = false) String name) {
        return "This is one subPath of endpoint /" + name;
    }

    @GetMapping("/{dynamic}")
    public String dynamicSubPath(@PathVariable("dynamic") String name) {
        return "Hello " + name + " this is my route dynamic...";
    }

    @PostMapping("/post")
    public String sayHelloPost(@RequestBody Map<String, Object> payload) {
        return payload.get("name").toString();
    }

}