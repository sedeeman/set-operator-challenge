# set-operator-challenge
You'll want to create a class that represents a Task.
It should have
an assignee.
a project name.
a task description.
a status (assigned, in progress, or not yet assigned).
a priority, High, Low, or Medium.
Each of these attributes should be editable.
A task is uniquely identified by its project name and description.
The task should implement Comparable, so that tasks are sorted by project name and description.

The TaskData class will be used to set up, and return some test data.
If you want to use my data, it can be found in a csv file in the resources folder of this section, and consists of the following:
All tasks identified by the manager.
Tasks identified by Ann, that she's working on or plans to work on.
Tasks which Bob says have been assigned to him.
Tasks Carol is doing, as reported by herself.
This class should have a getData method, that returns a Set of Task.   This method should take a String, either the name of one of the employees to get a specific set, or 'all' to get the full task set.

<img width="1430" alt="image" src="https://github.com/sedeeman/set-operator-challenge/assets/119731054/d227b7ee-f861-4aa6-8fdc-146cea7b411f">


You'll be using that data, to answer the following questions.
What is the full task list? This is the list of all tasks described by your manager or boss, and any additional tasks the employees have, that may not be on that list.
* Which tasks are assigned to at least one of your 3 team members?
* Which tasks still need to be assigned? 
* Which tasks are assigned to multiple employees?
To do some of this work, create three methods on your Main class.
