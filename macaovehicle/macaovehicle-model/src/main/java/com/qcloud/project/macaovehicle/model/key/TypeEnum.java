package com.qcloud.project.macaovehicle.model.key;

public class TypeEnum {

    public static final int    STATE_CONSTANT            = 5000;

    public static final String EXCEL_TEMPLATE_DIR        = "/excel";

    public static final String EXCEL_TEMPLATE_DIR_SOURCE = "/exportExcel";

    public static final String EXCEL_TEMPLATE_DIR_EXPORT = "/zipExport";
    public enum EnableType {
        ENABLE(1, "启用"), DISABLE(0, "禁用");

        private final int    key;

        private final String name;

        private EnableType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum OwnerType {
        PERSON(1, "个人"), BUSINESS(2, "企业");

        private final int    key;

        private final String name;

        private OwnerType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            OwnerType ownerType[] = OwnerType.values();
            for (OwnerType type : ownerType) {
                if (type.getKey() == key) {
                    return type.getName();
                }
            }
            return "";
        }
    }
    public enum UserType {
        WORKERS(1, "务工"), HOUSERS(2, "购房"), ENTERPRISERS(3, "投资"), TALENT(4, "高级人才"), ACQUISITION(5, "购地");

        private final int    key;

        private final String name;

        private UserType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            UserType ownerType[] = UserType.values();
            for (UserType type : ownerType) {
                if (type.getKey() == key) {
                    return type.getName();
                }
            }
            return "";
        }
    }
    /**
     * 只针对接口流程
     */
    public enum ApprovalResultState {
        APPLY_SUCCESS(1, "申请成功"), APPLY_FOR_CARDNUMBER(2, "申请卡号"), TAKE_CARD(3, "已取卡"),
        //
        CIQ_RECORD(4, "国检确定备案"), CUSTOMS_RECORD(5, "海关确定备案"),
        //
        RECORD_SUCCESS(51, "备案成功"), RECORD_FAILED(52, "备案失败"), RECORD_INPUT_SUCCESS(53, "数据录入成功"), RECORD_INPUT_FAILED(54, "数据录入失败"),
        //
        APPOINTMENT(61, "预约装卡"),
        //
        CANCEL_SET_CARD(62, "取消装卡"), APPOINTMENT_SET_CARD_SUCCESS(7, "预约装卡成功"),
        // FIRST_SET_CARD_SUCCESS(8, "初装卡成功"),
        SET_CARD_SUCCESS(9, "安装卡成功");

        private final int    key;

        private final String name;

        private ApprovalResultState(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            ApprovalResultState list[] = ApprovalResultState.values();
            for (ApprovalResultState temp : list) {
                if (temp.getKey() == key) {
                    return temp.getName();
                }
            }
            return "";
        }
    }
    public enum ApprovalCardType {
        DRIVER(1, "司机卡"), CAR(2, "车卡");

        private final int    key;

        private final String name;

        private ApprovalCardType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            ApprovalCardType list[] = ApprovalCardType.values();
            for (ApprovalCardType temp : list) {
                if (temp.getKey() == key) {
                    return temp.getName();
                }
            }
            return "";
        }
    }
    public enum RecordStateType {
        country(100, "国家"), border(10, "边境"), haikwan(1, "海关");

        private final int    key;

        private final String name;

        private RecordStateType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            RecordStateType list[] = RecordStateType.values();
            for (RecordStateType temp : list) {
                if (temp.getKey() == key) {
                    return temp.getName();
                }
            }
            return "";
        }
    }
    public enum CarModels {
        A1(1, "大型客车"), A2(2, "牵引车"), A3(3, "城市公交车"), B1(4, "中型客车"), B2(5, "大型货车"), C1(6, "小型汽车"), C2(7, "小型自动挡汽车"), C3(8, "低速载货汽车"), C5(9, "三轮汽车");

        private final int    key;

        private final String name;

        private CarModels(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            CarModels list[] = CarModels.values();
            for (CarModels temp : list) {
                if (temp.getKey() == key) {
                    return temp.getName();
                }
            }
            return "";
        }
    }
    public enum FuelType {
        Gasoline(1, "汽油"), Diesel(2, "柴油");

        private final int    key;

        private final String name;

        private FuelType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            FuelType list[] = FuelType.values();
            for (FuelType temp : list) {
                if (temp.getKey() == key) {
                    return temp.getName();
                }
            }
            return "";
        }
    }
    public enum SteeringWheel {
        Left(1, "左边"), Right(2, "右边");

        private final int    key;

        private final String name;

        private SteeringWheel(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            SteeringWheel list[] = SteeringWheel.values();
            for (SteeringWheel temp : list) {
                if (temp.getKey() == key) {
                    return temp.getName();
                }
            }
            return "";
        }
    }
    public enum DayStatistic {
        one(2, "00:00:00,01:59:59"), two(4, "02:00:00,03:59:59"), three(6, "04:00:00,05:59:59"), four(8, "06:00:00,07:59:59"), five(10, "08:00:00,09:59:59"), six(12, "10:00:00,11:59:59"), seven(14, "12:00:00,13:59:59"), eight(16, "14:00:00,15:59:59"), nine(18, "16:00:00,17:59:59"), ten(20, "18:00:00,19:59:59"), eleven(22, "20:00:00,21:59:59"), twelve(24, "22:00:00,23:59:59");

        private final int    key;

        private final String name;

        private DayStatistic(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum MonthStatistic {
        one(2, "01 00:00:00,02 23:59:59"), two(4, "03 00:00:00,04 23:59:59"), three(6, "05 00:00:00,06 23:59:59"), four(8, "07 00:00:00,08 23:59:59"), five(10, "09 00:00:00,10 23:59:59"), six(12, "11 00:00:00,12 23:59:59"), seven(14, "13 00:00:00,14 23:59:59"), eight(16, "15 00:00:00,16 23:59:59"), nine(18, "17 00:00:00,18 23:59:59"), ten(20, "19 00:00:00,20 23:59:59"), eleven(22, "21 00:00:00,22 23:59:59"), twelve(24, "23 00:00:00,24 23:59:59"), thirth(26, "25 00:00:00,26 23:59:59"), fourth(28, "27 00:00:00,28 23:59:59"), fiveth(30, "29 00:00:00,30 23:59:59"), sixth(31, "31 00:00:00,31 23:59:59");

        private final int    key;

        private final String name;

        private MonthStatistic(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum YearStatistic {
        one(1, "01-01 00:00:00,01-31 23:59:59"), two(2, "02-01 00:00:00,02-31 23:59:59"), three(3, "03-01 00:00:00,03-31 23:59:59"), four(4, "04-01 00:00:00,04-31 23:59:59"), five(5, "05-01 00:00:00,05-31 23:59:59"), six(6, "06-01 00:00:00,06-31 23:59:59"), seven(7, "07-01 00:00:00,07-31 23:59:59"), eight(8, "08-01 00:00:00,08-31 23:59:59"), nine(9, "09-01 00:00:00,09-31 23:59:59"), ten(10, "10-01 00:00:00,10-31 23:59:59"), eleven(11, "11-01 00:00:00,11-31 23:59:59"), twelve(12, "12-01 00:00:00,12-31 23:59:59");

        private final int    key;

        private final String name;

        private YearStatistic(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum OnestopCarRecordType {
        ENTER(1, "入境"), OUT(2, "出境");

        private final int    key;

        private final String name;

        private OnestopCarRecordType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum StatusType {
        DISABLE(0, "禁用"), NOTDO(1, "未处理"), REJECT(2, "未通过"), PASSED(3, "已通过");

        private final int    key;

        private final String name;

        private StatusType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            StatusType list[] = StatusType.values();
            for (StatusType temp : list) {
                if (temp.getKey() == key) {
                    return temp.getName();
                }
            }
            return "";
        }
    }
    public enum ProgressState {
        SHENGQIN(1, "申请"), GWHYSTG(2, "管委会预审通过"), YCTG(3, "验车通过"), GWHHSYJ(4, "管委会核实原件"),
        //
        JJHSYJ(5, "交警核实原件"), BEIAN(6, "备案"), PQZK(7, "排期装卡"), TZZK(8, "通知装卡"), WANCHENG(9, "完成");

        private final int    key;

        private final String name;

        private ProgressState(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public String getValue(int key) {

            StatusType list[] = StatusType.values();
            for (StatusType temp : list) {
                if (temp.getKey() == key) {
                    return temp.getName();
                }
            }
            return "";
        }
    }
    public enum VehicleStateType {
        NONAPPLY(0, "未申请"), APPLYING(1, "正在审批"), PASS(2, "可入境"), NOTPASS(3, "审批不通过");

        private final int    key;

        private final String name;

        private VehicleStateType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum ProgressType {
        APPLY(1, "入境申请"), TJJSY(2, "添加驾驶员"), ZXCL(3, "注销车辆"), BBDZCK(4, "补办电子车卡"), BBSJK(5, "补办司机卡"),
        //
        BBLSHP(6, "补办临时号牌"), XQSQ(7, "续期申请"), ZXJSY(8, "注销驾驶员");

        private final int    key;

        private final String name;

        private ProgressType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum ApplyType {
        PASS(1, "通过"), REJECT(2, "拒绝");

        private final int    key;

        private final String name;

        private ApplyType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum MessageType {
        YCTZ(1, "验车通知"), ZWCJ(2, "指纹采集"), PQJG(3, "排期结果"), GWH(4, "管委会审批"), CJSP(5, "澳门车检审批"), GWHXC(6, "管委会现场审批"), JJSP(7, "交警审批"), BASP(8, "备案结果");

        private final int    key;

        private final String name;

        private MessageType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum LossType {
        GS(1, "挂失"), BB(2, "补办"), DONE(3, "已处理");

        private final int    key;

        private final String name;

        private LossType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
    public enum CancelType {
        UNDO(1, "未标记"), DONE(2, "已标记");

        private final int    key;

        private final String name;

        private CancelType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }
    }
}
