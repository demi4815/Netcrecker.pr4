package ua.edu.sumdu.ta.Karina.pr4;

public class LinkedTaskList extends AbstractTaskList
{


    public LinkedTaskList(Task task)
    {
        this.task = task;
    }

    @Override
    public void add(Task task)
    {
        assert(task != null);

        task.title = startOfTitle + " " + task.title;

        LinkedTaskList node = new LinkedTaskList(task);

        if (head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }

        count++;
    }

    @Override
    public void remove(Task task)
    {
        assert(task != null);

        LinkedTaskList previous = null;
        LinkedTaskList current = head;

        while (current != null)
        {
            if (current.task.equals(task))
            {
                if (previous != null)
                {
                    previous.next = current.next;

                    if (current.next == null)
                    {
                        tail = previous;
                    }
                }
                else
                {
                    head = head.next;

                    if (head == null)
                    {
                        tail = null;
                    }
                }

                count--;
                break;
            }

            previous = current;
            current = current.next;
        }
    }

    @Override
    public Task getTask(int index)
    {
        assert(index >= 0 && index < count);

        if(index == 0) return head.task;

        if(index == count - 1) return tail.task;

        LinkedTaskList current = head;

        int k = 0;
        while (k < index)
        {
            current = current.next;
            k++;
        }

        return current.task;
    }

    public Task[] incoming(int from, int to)
    {
        Task[] data = new Task[count];

        int k = 0;

        LinkedTaskList current = head;

        for (int i = 0; i < count; i++)
        {
            if(current.task.isActive())
            {
                if(current.task.isRepeated())
                {
                    for(int j =current.task.start; j <= current.task.end; j += current.task.repeat)
                    {
                        if(j > from && j <= to)
                        {
                            data[k] = current.task;
                            k++;
                            break;
                        }
                    }
                }
                else
                {
                    if (current.task.time > from && current.task.time <= to)
                    {
                        data[k] = current.task;
                        k++;
                    }
                }
            }
            current = current.next;
        }

        Task[] incoming = new Task[k];
        if(k > 0)
        {
            System.arraycopy(data, 0, incoming, 0, k);
        }
        return incoming;
    }


    public LinkedTaskList()
    {
        count = 0;
        numberOfLists++;
    }

    private Task task;
    private LinkedTaskList next;
    private LinkedTaskList head;
    private LinkedTaskList tail;

}
