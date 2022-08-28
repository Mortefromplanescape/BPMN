import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.form.FormData;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.impl.form.DateFormType;
import org.activiti.engine.impl.form.StringFormType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SetResponsiblePersonListener extends UserTaskListener {

    public void notify(DelegateTask delegateTask) {
        System.out.println("~~~~~~~~~~~~~~~~" + this.getClass().getName() + "~~~~~~~~~~~");
        System.out.println("Event received: " + delegateTask.getEventName());
        String taskId = delegateTask.getId();
        System.out.println("taskId = " + taskId);
        ProcessEngine processEngine = ProcessEngines.getProcessEngine("TaskProcessEngine");


        FormService formService = processEngine.getFormService();
        Map<String, Object> variables = new HashMap<String, Object>();
        FormData formData = formService.getTaskFormData(taskId);
        Scanner scanner = new Scanner(System.in);
        try {
            for (FormProperty formProperty : formData.getFormProperties()) {
                if (formProperty.getType() instanceof StringFormType) {
                    System.out.println(formProperty.getName() + "?");
                    String value = scanner.nextLine();
                    variables.put(formProperty.getId(), value);
                } else if (formProperty.getType() instanceof DateFormType) {
                    System.out.println(formProperty.getName() + "? (dd.MM.yyyy или путое)");
                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    String s = scanner.nextLine();
                    if (s != null && s.length() > 0) {
                        Date value = dateFormat.parse(s);
                        variables.put(formProperty.getId(), value);
                    } else {
                        variables.put(formProperty.getId(), null);
                    }
                } else {
                    System.out.println("<form type not supported>" + formProperty.getType());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        TaskService taskService = processEngine.getTaskService();
        taskService.complete(taskId, variables);
        System.out.println("--------------------------------------------------");
    }
}
