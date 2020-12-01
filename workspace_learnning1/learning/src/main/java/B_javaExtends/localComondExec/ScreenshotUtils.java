package B_javaExtends.localComondExec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScreenshotUtils {
    
    private static final ExecutorService service = Executors.newFixedThreadPool(3);

    public static boolean isWindows() {
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") != -1) {
            return true;
        }
        return false;
    }
    
    public static String getTargetExePath() {
        String targetPath = "";
        if (isWindows()) {
            targetPath = "screent/windows/phantomjs.exe";
        } else {
            targetPath = "screent/linux/phantomjs";
        }
        return targetPath;
    }
    
    public static String getTargetRenderPath() {
        String targetPath = "";
        if (isWindows()) {
            targetPath = "screent/windows/render.js";
        } else {
            targetPath = "screent/linux/render.js";
        }
        return targetPath;
    }

    public static boolean exeCmd(String commandStr) {
        BufferedReader br = null;
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(commandStr);
            p.waitFor();
            String line = null;
            br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (null != p) {
                    p.destroy();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

//    public static void asyncExeCmd(String commandStr) {
    
//		java1.8 service.submit(() -> exeCmd(commandStr));
//    	
//    	service.submit(new Runnable() {
//			
//			public void run() {
//				// TODO Auto-generated method stub
//				exeCmd(commandStr);
//			}
//		});
//    }
    
    public static void main(String[] args) {
        URL url = ScreenshotUtils.class.getProtectionDomain().getCodeSource().getLocation();
        String path = url.getPath();
        if(isWindows() && path.startsWith("/")) {
            path = path.substring(1);
        }
        String exePath =  path+getTargetExePath();
        String renderPath = path + getTargetRenderPath();
        StringBuilder sb = new StringBuilder(exePath);
        sb.append(" ");
        sb.append(renderPath);
        sb.append(" http://www.baidu.com d://baidu1.png 2000 1000");
        exeCmd(sb.toString());
        System.out.println("sb = {}"+sb.toString());
        System.out.println("ok");
    }


}
