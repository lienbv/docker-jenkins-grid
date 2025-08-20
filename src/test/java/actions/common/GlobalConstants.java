package common;

import java.io.File;

public class GlobalConstants {
    public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com";

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String OS_NAME = System.getProperty("os.name");

    //Windows / MAC / Linux
    public static final String UPLOAD_FILE_PATH = PROJECT_PATH + File.separator + "uploadFiles" +  File.separator;

    public static final long SHORT_TIMEOUT =5;
    public static final long LONG_TIMEOUT = 30;
    public static final long RETRY_TEST_FAIL = 3;

}
