package ua.edu.sumdu.ta.Karina.pr4.tests.full;

import org.junit.Before;
import ua.edu.sumdu.ta.Karina.pr4.*;

public class LinkedTaskListTest extends TaskListTest {

    @Before
    public void before()
    {
        tasks = new LinkedTaskList();
    }
}
