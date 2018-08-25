package sz.tianhe.etc_wallet.home.bean;

public class SetPassVo {
    private String phone;
    private String passwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public SetPassVo(String phone, String passwd) {
        this.phone = phone;
        this.passwd = passwd;
    }
}
