import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// sort tasks with dependencies correctly
interface Task {
    int id();
    List<Task> dependencies();
  //  void run(TaskContext context);
}
class Vertex{
    String Task;
}
class DependencyGraph{
    private Map<Vertex,List<Vertex>> dependencyTask;
}
// test test
// example:
// a->b (a is b's dependency)
// a->c
// b->d
// c->d
// d->e
// input: e, d, c, b, a
// sorted output: a, b, c, d, e
class TaskExecutor {
    private List<Task> sortedTasks;
    DependencyGraph g=new DependencyGraph();
    //initializeGraph(tasks);
    /*TaskExecutor(List<Task> tasks) {
        //this.sortedTasks = sort(tasks);
    }*/

  /*  List<Task> sort(List<Task> tasks) {
        // TODO

        for(Task t:tasks){

        }
    }*/

    void execute(TaskContext context) {
        for (Task task : sortedTasks) {
          //  task.run(context);
        }
    }

   class  TaskContext{

   }
}

