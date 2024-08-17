package io.github.orionlibs.orion_task_runner;

public class OrionJobService
{
    public static boolean runJob(OrionJob job)
    {
        new Thread(job).start();
        return true;
    }


    public static void runJobWithCurrentThreadName(OrionJob job)
    {
        Thread thread = new Thread(job);
        thread.setName(Thread.currentThread().getName());
        thread.start();
    }
}