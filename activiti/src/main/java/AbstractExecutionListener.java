import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public abstract class AbstractExecutionListener implements ExecutionListener {

    public void notify(DelegateExecution delegateExecution) {
        System.out.println("++++++++++++++++" + this.getClass().getName() + "+++++++++");
        System.out.println("Event received: " + delegateExecution.getEventName());
        System.out.println("delegateExecution = " + delegateExecution);
        System.out.println("delegateExecution = " + delegateExecution.getClass());
        System.out.println("--------------------------------------------------");
    }
}
