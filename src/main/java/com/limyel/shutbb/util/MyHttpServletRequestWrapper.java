package com.limyel.shutbb.util;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private byte[] data = null;

    public MyHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);

        try {
            data = request.getInputStream().readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (data == null) {
            data = new byte[0];
        }

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }
}
