import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckingAccountTest {
    private CheckingAccount account;

    @BeforeEach
    void setUpAccount() throws IllegalArgumentException {
        account = new CheckingAccount("SA00002", 1000, -100);
    }

    @Test
    @DisplayName("Podemos depositar dinero")
    void successfulDeposit() throws IllegalArgumentException {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    @DisplayName("Depósito con cantidad negativa lanza una excepción")
    void depositNegativeAmountException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    @DisplayName("Debe saltar error si retiramos más dinero del que tenemos contabilizando el sobregiro")
    void withdrawMoreThanBalance() throws InsufficientFundsException {
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(1101));
    }


}
