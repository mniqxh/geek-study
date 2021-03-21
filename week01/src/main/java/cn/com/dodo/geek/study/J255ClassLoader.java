package cn.com.dodo.geek.study;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class J255ClassLoader extends ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Object hello = new J255ClassLoader().findClass("Hello").newInstance();
        Method helloMethod = hello.getClass().getMethod("hello");
        helloMethod.invoke(hello);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = new byte[8192];
        int len;
        try (InputStream is = J255ClassLoader.class.getResourceAsStream("/Hello.xlass");
             ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            while ((len = is.read(b)) != -1) {
                byte[] newb = byteConvert(b, len);
                bout.write(newb, 0, len);
            }
            bout.flush();
            return super.defineClass(name, bout.toByteArray(), 0, bout.toByteArray().length);
        } catch (IOException e) {
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }

    private byte[] byteConvert(byte[] b, int len) {
        byte[] newb = new byte[len];
        for (int i = 0; i < len; i++) {
            newb[i] = (byte) (255 - b[i]);
        }
        return newb;
    }
}