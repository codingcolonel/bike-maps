package gui;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class GUIManager {
    @GetMapping("/number")
    public String getMethodName(@RequestParam Integer num) {
        return "I love the number " + num;
    }
}
