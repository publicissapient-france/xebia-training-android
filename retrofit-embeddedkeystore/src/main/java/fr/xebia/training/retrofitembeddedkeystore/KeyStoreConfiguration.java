package fr.xebia.training.retrofitembeddedkeystore;

/**
 * User: mounirboudraa
 * Date: 14/02/2014
 * Time: 05:00
 */
public class KeyStoreConfiguration {

    private int res;
    private String password;

    public KeyStoreConfiguration(int res, String password) {
        this.res = res;
        this.password = password;
    }

    public int getRes() {
        return res;
    }

    public String getPassword() {
        return password;
    }
}
