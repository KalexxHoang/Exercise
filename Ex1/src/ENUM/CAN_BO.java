package ENUM;

public enum CAN_BO {
    NHAN_VIEN,
    KY_SU,
    CONG_NHAN;

    public static CAN_BO getEnumCanBo(int ordinal){
        for (CAN_BO canBo : CAN_BO.values()){
            if (canBo.ordinal() == (ordinal - 1))
                return canBo;
        }
        throw new RuntimeException();
    }
}
