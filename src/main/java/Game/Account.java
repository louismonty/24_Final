package Game;

public class Account {

        private int balance;

        public Account()
        {
            this.balance = 30000;
        }

        public int addBalance(int addition)
        {
            return balance += addition;
        }

        public int subtractBalance(int subtraction)
        {
            return balance -= subtraction;
        }
        public int getBalance()
    {
        return balance;
    }
        public void setBalance(int balance)
    {
        this.balance = balance;
    }
}
