package todo.list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
@RestController
@CrossOrigin
@RequestMapping("/api/todo")
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	private final TaskRepository taskRepository;

	public TodoApplication(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@GetMapping
	public List<Task> getTodoList(){
		return taskRepository.findAll();
	}

	record NewTaskRequest(String task, String description, Integer done){}

	@PostMapping
	public void addTask(@RequestBody NewTaskRequest request ){
		Task task = new Task();
		task.setTask(request.task);
		task.setDescription(request.description);
		task.setDone(request.done);
		taskRepository.save(task);
	}

	@PutMapping("{taskId}")
	public void updateTask(@RequestBody NewTaskRequest request, @PathVariable("taskId") Integer id){
		Task task = taskRepository.getReferenceById(id);
		task.setTask(request.task);
		task.setDescription(request.description);
		task.setDone(request.done);
		taskRepository.save(task);
	}

	@DeleteMapping("{taskId}")
	public void deleteTask(@PathVariable("taskId") Integer id){
		taskRepository.deleteById(id);
	}

}
