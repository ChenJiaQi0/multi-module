package top.chen.book.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author mqxu
 * @Date 2023/2/17
 * @Description JDBC 工具类
 **/
public class JdbcUtil {
    private static final DataSource ds;

    private static JdbcUtil jdbcUtil = null;

    static {
        // 加载配置文件
        Properties properties = new Properties();
        InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(is);
            // 初始化连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }


    private JdbcUtil() {
        System.out.println("执行构造方法");
    }

}
