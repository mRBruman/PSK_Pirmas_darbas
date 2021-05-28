package vu.lt.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.*;
import java.text.SimpleDateFormat;

@LoggedInvocation
@Interceptor
public class MethodLogger {
    @AroundInvoke
    public Object logMethod(InvocationContext ctx) throws Exception {

        System.out.println("MethodLogger called.");

        String fileName = "D:\\Program Files\\IntelliJ IDEA 2020.3.2\\PSK Pirmas darbas\\src\\main\\java\\vu\\lt\\interceptors\\MethodLogs.txt";
        File loggingFile = new File(fileName);

        if (!loggingFile.exists()) {
            try {
                loggingFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String className = ctx.getTarget().getClass().getSuperclass().getName();
        String methodName = ctx.getMethod().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new java.util.Date());

        try (FileWriter writer = new FileWriter(loggingFile, true)) {
            writer.write("Class name: " + className + "\n");
            writer.write("Method name: " + methodName + "\n");
            writer.write("Method was called at: " + timeStamp + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object obj = ctx.proceed();

        return obj;
    }
}
