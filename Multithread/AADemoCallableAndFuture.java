package Basic.Multithread;

import java.util.concurrent.*;
import java.util.*;

public class AADemoCallableAndFuture {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();//ExecutorService automatically provides a pool of threads and API for assigning tasks to it.
		
		//Future<String> future = executor.submit(callableTask);
		//List<Future<String>> futures = executor.invokeAll(callableTasks);
		
		//Callable<T> parametrized class.
		
		Future<Integer> future = executor.submit(new Callable<Integer>(){

			@Override
			public Integer call(){
				Random random = new Random();
				int duration = random.nextInt(4000);
				if (duration > 2000){
					throw new RuntimeException("Sleeping for too long.");
				}
				System.out.println("Starting...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished.");
				
				return duration;
			}
			
		});
		
		executor.shutdown();//ExecutorService will not be automatically destroyed when there is not task to process. It will stay alive and wait for new work to do.
		//The shutdown() method doesn't cause an immediate destruction of the ExecutorService. It will make the ExecutorService stop accepting new tasks and shut down after all running threads finish their current work.
	
		try {
			System.out.println("Result is:" +future.get());
			//The Future interface provides a special "blocking method" get() which returns an actual result of the Callable task's execution or null in the case of Runnable task. 
			//Calling the get() method while the task is still running will cause execution to block until the task is properly executed and the result is available.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			//System.out.println(e.getMessage());
			RuntimeException ex = (RuntimeException) e.getCause();
			System.out.println(ex.getMessage());
		}
	
	}

}
