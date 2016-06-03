package com.qcloud.component.publicservice;

public interface PayClient {

    WeiXinPayClient getWeiXinPayClient();

    int getPayMinutes();
    //
    public static class PayReqData {

        private String orderName      = "";

        private String orderNumber    = "";

        private int    fee            = 0;

        private String spbillCreateIp = "";

        private String time_expire    = "";

        private String auth_code      = "";

        public String getOrderName() {

            return orderName;
        }

        public void setOrderName(String orderName) {

            this.orderName = orderName;
        }

        public String getOrderNumber() {

            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {

            this.orderNumber = orderNumber;
        }

        public int getFee() {

            return fee;
        }

        public void setFee(int fee) {

            this.fee = fee;
        }

        public String getSpbillCreateIp() {

            return spbillCreateIp;
        }

        public void setSpbillCreateIp(String spbillCreateIp) {

            this.spbillCreateIp = spbillCreateIp;
        }

        public String getTime_expire() {

            return time_expire;
        }

        public void setTime_expire(String time_expire) {

            this.time_expire = time_expire;
        }

        public String getAuth_code() {

            return auth_code;
        }

        public void setAuth_code(String auth_code) {

            this.auth_code = auth_code;
        }
    }
}
