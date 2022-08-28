import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DeadlineDelegate implements JavaDelegate {

    public void execute(DelegateExecution execution)  {
        System.out.println("++++++++++++++++" + this.getClass().getName() + "+++++++++");
        System.out.println("Event received: " + execution.getEventName());
        System.out.println("delegateExecution = " + execution);
        System.out.println("delegateExecution = " + execution.getClass());
        System.out.println("Variables = " + execution.getVariables());
        System.out.println("--------------------------------------------------");

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            execution.setVariable("deadline", dateFormat.parse("01.11.2022"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
