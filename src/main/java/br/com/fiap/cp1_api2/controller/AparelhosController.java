package br.com.fiap.cp1_api2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aparelhos")
public class AparelhosController {
    @GetMapping()
    public String GetAparelhos() {
        return "Iphone 17, Samsumg Galaxy 21, Huawei Ultra";
    }

    @GetMapping("maisVendido")
    public String GetAparelhoMaisVendido() {
        return "Iphone 17";
    }
}
