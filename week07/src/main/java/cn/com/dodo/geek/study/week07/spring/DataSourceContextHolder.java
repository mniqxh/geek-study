package cn.com.dodo.geek.study.week07.spring;

/**
 * 线程数据库标识
 */
public class DataSourceContextHolder {
	private static final ThreadLocal<String> contextKey = new ThreadLocal<>();

	/**
	 * 设置数据库类型标识
	 * 
	 * @param dsType
	 */
	public static void setDataSourceType(String dsType) {
		contextKey.set(dsType);
	}

	/**
	 * 获取数据库类型标识
	 * 
	 * @return 数据库类型
	 */
	public static String getDataSourceType() {
		return contextKey.get();
	}

	/**
	 * 清除数据库类型标识
	 */
	public static void clearDataSourceType() {
		contextKey.remove();
	}

}
