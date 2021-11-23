import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Account {

    public Account(String firstName, String lastName, String email, String password, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public Date birthday;

}