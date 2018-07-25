package sz.tianhe.etc_wallet.guide.bean;

import java.io.Serializable;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/17 18:33
 */
public class RegisterBean implements Serializable{
    /**
     * 助记词
     */
    private String words;

    /**
     * 验证码
     */
    private String code;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 密码
     */
    private String pass;

    /**
     * 第二次密码
     */
    private String sencondPass;

    private String invaldCode;

    public String getInvaldCode() {
        return invaldCode;
    }

    public void setInvaldCode(String invaldCode) {
        this.invaldCode = invaldCode;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSencondPass() {
        return sencondPass;
    }

    public void setSencondPass(String sencondPass) {
        this.sencondPass = sencondPass;
    }
}
