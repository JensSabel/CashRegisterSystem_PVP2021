package com.example.demo.service;

import java.io.IOException;

public class JarOpener {

    public void openJar() throws IOException {
        Runtime.getRuntime().exec("java -jar ProductCatalog.jar");
        Runtime.getRuntime().exec("java -jar CashBox.jar");
        Runtime.getRuntime().exec("java -jar CardReader.jar");
    }
}
