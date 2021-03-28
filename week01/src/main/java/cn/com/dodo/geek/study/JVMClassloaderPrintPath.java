package cn.com.dodo.geek.study;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class JVMClassloaderPrintPath {

	public static void main(String[] args) {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		System.out.println("启动类加载器");
		for (URL url : urls) {
			System.out.println(url.toExternalForm());
		}
		printClassloder("拓展类加载器", JVMClassloaderPrintPath.class.getClassLoader().getParent());
		printClassloder("应用类加载器", JVMClassloaderPrintPath.class.getClassLoader());
	}

	private static void printClassloder(String name, ClassLoader CL) {
		if (null != CL) {
			System.out.println(name + " Classerloader ==> " + CL.toString());
			printURLForClassloader(CL);
		} else {
			System.out.println(name + " Classerloader ==> null");
		}
	}

	private static void printURLForClassloader(ClassLoader CL) {
		Object ucp = insightField(CL, "ucp");
		Object path = insightField(ucp, "path");
		ArrayList<URL> ps = (ArrayList<URL>) path;
		for (int i = 0; i < ps.size(); i++) {
			System.out.println(ps.get(i).toExternalForm());
		}
	}

	private static Object insightField(Object obj, String fName) {
		try {
			Field field;
			if (obj instanceof URLClassLoader) {
				field = URLClassLoader.class.getDeclaredField(fName);
			} else {
				field = obj.getClass().getDeclaredField(fName);
			}
			field.setAccessible(true);
			return field.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
