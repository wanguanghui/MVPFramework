package com.wgh.mvpframework.common.arouter

/**
 * Create by wgh on 2018/5/15.
 * Description:
 */
object RouterUtils {

    interface ModuleApp {
        companion object {

        }
    }

    interface ModulePublic {
        companion object {
            /***
             * 登录页
             */
            const val ROUTER_PUBLIC_LOGIN = "/mpublic/LoginActivity"
        }
    }

    interface ModuleTest {
        companion object {
            const val ROUTER_TEST_MAIN = "/testmodule1/MainActivity"
        }
    }

}