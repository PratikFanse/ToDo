package com.app.toDoApp.tasks;

import com.app.toDoApp.ToDoAppApplication;
import com.app.toDoApp.admin.graphReport.GraphDataService;
import com.app.toDoApp.auth.dao.UserDao;
import com.app.toDoApp.auth.model.DAOUser;
//import com.app.toDoApp.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@CrossOrigin("http://localhost:4200")
public class TaskListContoller {

    @Autowired
    private TaskListService taskListService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GraphDataService graphDataService;
    @RequestMapping(value = "/toDoTaskGet", method = RequestMethod.GET)
    public List<Task> getAllTasks(){
        DAOUser u=userDao.findByUsername(ToDoAppApplication.reqUser);
        return  taskListService.findAllTask(u.getId());
    }
//    @CrossOrigin
    @RequestMapping(value = "/toDoTaskPut", method = RequestMethod.POST)
        public List<Task> putTask(@RequestBody Task task){
        DAOUser u=userDao.findByUsername(ToDoAppApplication.reqUser);
        task.setUserid(u.getId());
        System.out.println(task.getUserid()+" "+ task.getTask()+" "+u.getId());
        return  taskListService.newTask(task);
        }


    @RequestMapping(value = "/toDoTask/{id}", method = RequestMethod.GET)
    public List<Task> getAllTasks(@PathVariable int id){
        return  taskListService.findAllTask(id);
    }

    @RequestMapping(value = "/toDoTask", method = RequestMethod.PUT)
    public List<Task> updateTask(@RequestBody Task task){
        return  taskListService.updateTask(task);
    }

    @RequestMapping(value = "/toDoTask", method = RequestMethod.DELETE)
    public List<Task> geleteTask(@RequestBody Task task){
        return  taskListService.deleteTask(task);
    }




}
