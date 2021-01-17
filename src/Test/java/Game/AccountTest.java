package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account = new Account();

    @Test
    void getBalance() {
        assertEquals(30000,account.getBalance());
    }

    @Test
    void addBalance() {
        account.addBalance(1000);
        assertEquals(31000,account.getBalance());
    }

    @Test
    void subtractBalance() {
        account.subtractBalance(1000);
        assertEquals(29000,account.getBalance());
    }



    @Test
    void setBalance() {
        account.setBalance(0);
        assertEquals(0,account.getBalance());
    }
}