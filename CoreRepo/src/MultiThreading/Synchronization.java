package MultiThreading;

public class Synchronization {

    int count;

    public synchronized void addition(){

        count++;
    }
}


class Calling{

    public static void main(String[] args) throws Exception{

        Synchronization sync = new Synchronization();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=1000;i++){
                    sync.addition();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=1000;i++){
                    sync.addition();
                }

            }
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println(sync.count);

    }

}
