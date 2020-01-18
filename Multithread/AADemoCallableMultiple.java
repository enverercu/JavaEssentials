package Basic.Multithread;
import java.util.concurrent.*;
import java.util.*;
class Result{
	private int result;
	
	public Result(int result){
		this.result = result;
	}	
	public int getResult(){
		return this.result;
	}
}
class Task implements Callable<Result>{

	@Override
	public Result call() throws Exception {
		Thread.sleep(1000);
		Random random = new Random();
		int result = random.nextInt(100);
		return new Result(result);
	}
	
}
public class AADemoCallableMultiple {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<Task> taskList = new ArrayList<Task>();
		for(int i=0;i<5;i++){
			taskList.add(new Task());
		}
		
		List<Future<Result>> resultList = null;
		
		try {
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		
		for(Future<Result> ftr:resultList){
			try {
				Result result = ftr.get();
				System.out.println("Result:" + result.getResult());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
