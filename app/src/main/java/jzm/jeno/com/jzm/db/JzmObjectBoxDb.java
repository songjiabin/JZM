package jzm.jeno.com.jzm.db;

import jzm.jeno.com.jzm.bean.JzmLoginBean;

/**
 * author : 宋佳
 * time   : 2018/12/07
 * desc   :
 * version: 1.0.0
 */

public interface JzmObjectBoxDb {


    /**
     * demo
     */
    interface JzmObjectBox {
        /**
         * 插入单个数据
         *
         * @param bean
         */
        void insert(JzmLoginBean bean);
    }


}
