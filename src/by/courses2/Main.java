package by.courses2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread factoryThread = new Thread(new Factory());
        Thread americaThread = new Thread(new America());
        Thread japanThread = new Thread(new Japan());
        factoryThread.start();
        americaThread.start();
        japanThread.start();
        while (WarStatus.isWarOver == false) {
            Thread.sleep(1000);
        }
        System.out.println("Winner " + WarStatus.winner);
    }
}
