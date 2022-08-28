import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public abstract class AbstractTaskListener implements TaskListener {

    public void notify(DelegateTask delegateTask) {
        System.out.println("~~~~~~~~~~~~~~~~" + this.getClass().getName() + "~~~~~~~~~~~");
        System.out.println("Event received: " + delegateTask.getEventName());
        System.out.println("delegateExecution = " + delegateTask);
        System.out.println("delegateExecution = " + delegateTask.getClass());
        System.out.println("--------------------------------------------------");
    }
}
