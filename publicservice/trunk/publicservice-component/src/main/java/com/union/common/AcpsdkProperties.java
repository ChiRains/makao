package com.union.common;

import java.util.Properties;
import com.unionpay.acp.sdk.SDKConfig;

public class AcpsdkProperties {

    private static final String frontTransUrl   = "https://gateway.95516.com/gateway/api/frontTransReq.do";

    private static final String backTransUrl    = "https://gateway.95516.com/gateway/api/cardTransReq.do";

    private static final String singleQueryUrl  = "https://gateway.95516.com/gateway/api/queryTrans.do";

    private static final String batchTransUrl   = "https://gateway.95516.com/gateway/api/batchTrans.do";

    private static final String fileTransUrl    = "https://filedownload.95516.com/";

    private static final String appTransUrl     = "https://gateway.95516.com/gateway/api/appTransReq.do";

    /**
     * -------------------------------分割线------------------------------------
     */
    private String              signCertType    = "";

    private String              signCertPath    = "";

    private String              signCertPwd     = "";

    private String              encryptCertPath = "";

    private String              validateCertDir = "";

    public String               merId           = "";

    public Properties           properties      = new Properties();

    public AcpsdkProperties() {

    }

    public AcpsdkProperties(String signCertType, String signCertPath, String signCertPwd, String encryptCertPath, String validateCertDir, String merId) {

        this.signCertType = signCertType;
        this.signCertPath = signCertPath;
        this.signCertPwd = signCertPwd;
        this.encryptCertPath = encryptCertPath;
        this.validateCertDir = validateCertDir;
        this.merId = merId;
    }

    public Properties getProperties() {

        properties.put(SDKConfig.SDK_FRONT_URL, frontTransUrl);
        properties.put(SDKConfig.SDK_BACK_URL, backTransUrl);
        properties.put(SDKConfig.SDK_SIGNQ_URL, singleQueryUrl);
        properties.put(SDKConfig.SDK_BATTRANS_URL, batchTransUrl);
        properties.put(SDKConfig.SDK_FILETRANS_URL, fileTransUrl);
        properties.put(SDKConfig.SDK_APP_URL, appTransUrl);
        properties.put(SDKConfig.SDK_SIGNCERT_PATH, signCertPath);
        properties.put(SDKConfig.SDK_SIGNCERT_PWD, signCertPwd);
        properties.put(SDKConfig.SDK_SIGNCERT_TYPE, signCertType);
        properties.put(SDKConfig.SDK_VALIDATECERT_DIR, validateCertDir);
        properties.put(SDKConfig.SDK_ENCRYPTCERT_PATH, encryptCertPath);
        return properties;
    }

    public String getSignCertType() {

        return signCertType;
    }

    public void setSignCertType(String signCertType) {

        this.signCertType = signCertType;
    }

    public String getSignCertPath() {

        return signCertPath;
    }

    public void setSignCertPath(String signCertPath) {

        this.signCertPath = signCertPath;
    }

    public String getSignCertPwd() {

        return signCertPwd;
    }

    public void setSignCertPwd(String signCertPwd) {

        this.signCertPwd = signCertPwd;
    }

    public String getValidateCertDir() {

        return validateCertDir;
    }

    public void setValidateCertDir(String validateCertDir) {

        this.validateCertDir = validateCertDir;
    }

    public String getEncryptCertPath() {

        return encryptCertPath;
    }

    public void setEncryptCertPath(String encryptCertPath) {

        this.encryptCertPath = encryptCertPath;
    }

    public String getMerId() {

        return merId;
    }

    public void setMerId(String merId) {

        this.merId = merId;
    }
}
