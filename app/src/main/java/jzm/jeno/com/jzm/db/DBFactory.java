package jzm.jeno.com.jzm.db;

/**
 * author : 宋佳
 * time   : 2018/12/07
 * desc   : 数据库操作工程类
 * version: 1.0.0
 */

public class DBFactory {

    private static DBFactory mInstance = null;


    /**
     * 获取DaoFactory的实例
     *
     * @return
     */
    public static DBFactory getInstance() {
        if (mInstance == null) {
            synchronized (DBFactory.class) {
                if (mInstance == null) {
                    mInstance = new DBFactory();
                }
            }
        }
        return mInstance;
    }



    /**
     * 得到JzmObjectBoxBean
     *
     * @return
     */
    public JzmObjectBoxDb.JzmObjectBox getJzmObjectBoxDB() {
        return new JzmObjectBoxImpl();
    }



}
