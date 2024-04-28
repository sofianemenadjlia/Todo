document.getElementById('todoForm').addEventListener('submit', function(e) {
  e.preventDefault();
  const taskInput = document.getElementById('task');
  const descriptionInput = document.getElementById('description');

  const task = taskInput.value;
  const description = descriptionInput.value;

  if (task.trim() !== '' ) {
    addTask(task, description);
    taskInput.value = '';
    descriptionInput.value = '';
  } else {
    alert('Please enter task!');
  }
});

function addTask(task, description) {
  const todoList = document.getElementById('todoList');
  const newRow = document.createElement('tr');
  newRow.innerHTML = `
    <td><input type="checkbox" class="done-checkbox"></td>
    <td>${task}</td>
    <td>${description}</td>
  `;
  todoList.appendChild(newRow);
}


