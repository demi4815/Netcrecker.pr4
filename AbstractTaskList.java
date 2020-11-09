package ua.edu.sumdu.ta.Karina.pr4;

public abstract class AbstractTaskList
{
    abstract void add(Task task);
    abstract void remove(Task task);
    abstract Task getTask(int index);
    abstract Task[] incoming(int from, int to);

    public int size()
    {
        return count;
    }

    protected Task[] mTask; //array for tasks
    protected int mLength; //array length
    protected int count; //the number of tasks in the array

    static int numberOfLists = 0; // actual number of created task lists
    static String startOfTitle = "[EDUCTR][TA]"; //Title of each task from the list

    final int value = 10; // the number of elements by which the array will expand


}
