package Threads;

public class ClaculatorThread extends Thread 
{

    private long result = 1;
    private final int maxValue;
    
    

    public long getResult() 
    {
        return this.result;
    }

    public ClaculatorThread(int minValue, int maxValue) 
    {
        this.maxValue = maxValue;
        
        
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println( threadName + " starting " );
        for (int i = 1; i <= this.maxValue; i++) 
        {
            if (i % 4 == 0)
            	
                this.result *= i;
            System.out.print(i + " ");

        }
        
        
    }
    

}