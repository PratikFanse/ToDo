package com.app.toDoApp.tasks;

import com.app.toDoApp.admin.graphReport.GraphDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private GraphDataService graphDataService;

    public List<Task> newTask(Task task){
        taskRepository.save(task);
        graphDataService.updateTaskCount();
        return findAllTask(task.getUserid());
    }

    public List<Task> findAllTask(int userId){
        return taskRepository.findByUserid(userId);
    }

    public List<Task> deleteTask(Task task){
        taskRepository.delete(task);
        return taskRepository.findByUserid(task.getUserid());
    }

    public List<Task> updateTask(Task task){
        taskRepository.save(task);
        return taskRepository.findByUserid(task.getUserid());
    }


}
