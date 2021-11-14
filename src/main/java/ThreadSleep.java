public class ThreadSleep {

    int TimeMillis;

    public void ThreadSleep(int TimeMillis) {
        // запоминаем текущее время в миллисекундах
        long start = System.currentTimeMillis();
        // останавливаем основной поток программы на 2000 миллисекунд (2 секунды)
        try {
            Thread.sleep(TimeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Выполнение программы приостановлено на = " + (System.currentTimeMillis() - start));

    }

}