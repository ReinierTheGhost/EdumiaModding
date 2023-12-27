package com.legends.edumia.utils.cliient.models.obj;



import com.google.common.base.Charsets;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ObjTokenizer implements AutoCloseable{

    private final BufferedReader lineReader;

    public ObjTokenizer(InputStream inputStream) {
        this.lineReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8));
    }

    @Override
    public void close() throws Exception {

    }
}
