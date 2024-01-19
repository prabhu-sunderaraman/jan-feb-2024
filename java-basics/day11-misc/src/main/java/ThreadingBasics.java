public class ThreadingBasics {
    public static void main(String[] args) {
        //We don't work with threads like these anymore
        //we use the ExecutorService
        Thread walkingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("Walking");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        walkingThread.start();
        Thread talkingThread = new Thread(() -> {
            while(true) {
                System.out.println("Talking");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        talkingThread.start();
    }
}
