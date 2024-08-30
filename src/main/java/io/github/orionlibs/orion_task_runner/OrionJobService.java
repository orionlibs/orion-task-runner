package io.github.orionlibs.orion_task_runner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class OrionJobService<RESULT_TYPE>
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


    public <RESULT_TYPE> RESULT_TYPE runJobAndGetResult(Supplier<RESULT_TYPE> runnable) throws ExecutionException, InterruptedException
    {
        CompletableFuture<RESULT_TYPE> futureResult = CompletableFuture.<RESULT_TYPE>supplyAsync(() -> runnable.get());
        return futureResult.get();
    }
}