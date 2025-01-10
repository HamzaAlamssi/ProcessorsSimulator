The processor simulation project aims to emulate a multi
processor environment where tasks are assigned to processors 
based on specific scheduling algorithms. Key features include: 

1.Fixed number of processors. 

2.Synchronization of processors via a common clock. 

3.Task creation and execution based on predefined 
parameters. 

4.Priority-based scheduling of tasks.

Design Patterns: 
Several design patterns were employed to enhance the flexibility, 
scalability, and maintainability of the code: 

1.Factory Pattern: Used for creating instances of processors and 
tasks, encapsulating the instantiation logic. 

2.Singleton Pattern: Applied to the Configuration class to ensure a 
single instance manages global settings. 

3.Strategy Pattern: Implemented different scheduling algorithms, 
allowing the scheduler to use various strategies at runtime.
 
4.Observer Pattern: Used to notify components about clock ticks 
and task completions, promoting decoupled interaction between 
objects.
