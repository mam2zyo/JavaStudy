package quiz;

public class Bank {

    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(int amount, int balance) {
            super("잔액 부족: " + amount +  " 요청" + balance + " 보유");
        }
    }

    public static void withdraw(int balance, int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        System.out.println("출금 완료: " + amount + "원");
    }

    public static void main(String[] args) {
        try {
            withdraw(5000, 10000);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
    }
}