# TIRA/DSA-2024

This repository contains the exercises and course projects of the Data Structures and Algorithms (TIRA, Tietorakenteet ja algoritmit in Finnish) course.

You as a student should copy this repository by creating a fork into your own gitlab account. You then clone that for to your own personal computer (PC). You will then work on that forked private repository and use it do deliver your course work to the course teachers for evaluation.

How this is done, is explained in this and other instructions of this repository. In addition, the course material contain instructional videos regarding how this is done (some in Finnish, English versions will be uploaded as soon as they are available). The first exercise task of the course, `00-init`, is intended to test that all tools and your own repository is properly set up.

All course work is individual work, so no groups of any size but one.

**IMPORTANT note**: in the exercises and course projects, you are **not allowed** to use Java Collection classes nor algorithms (classes like `Collections`, `Arrays`, `ArrayList`, `LinkedList`, `Stack`, `Vector`, `Queue`, `Set`, any implementation of `Map`, `Arrays.sort`, `Collections.sort`, etc.) unless _explicitly_ mentioned in a specific exercise/course project.

You **are allowed** to use `String` class as well as basic data types int, long, short, double, float, char, and plain arrays (e.g. String [] arrayOfStrings) and the "class" version of these (like `Integer`). When you are required to implement a **hash function**, you must **not** use ready made hash functions, e.g. `String.hashCode` but you must implement hash functions yourself using the basic data types and loops.

## Tools

The tools that are used in this course and you need to install, are listed in [TOOLS.md](TOOLS.md).

**Install the tools first** and then continue reading forward.

## How to set up your workspace

The instructions in [SETUP.md](SETUP.md) instruct you how to get the course repository forked and cloned to your own PC. You will then do the exercises and course projects on your own PC. When you get things done, you will use git to

1. add changes and new code to your PC's local git repository,
1. push the code to your private git repository in GitLab,
1. from where the teachers can see your progress, help you out with problems, and finally clone your project to grade your work in the course.

So, follow the instructions in [SETUP.md](SETUP.md) -- you need to do the setup only _once_ in the beginning of the course.

**IMPORTANT note**: in the exercises and course projects, you are **not allowed** to use Java Collection classes nor algorithms (classes like Collections, Arrays, ArrayList, LinkedList, Stack, Vector, Queue, Arrays.sort, Collections.sort, etc.) unless _explicitly_ mentioned in a specific exercise/course project. Using String class as well as basic data types int, long, short, double, float, char, and plain arrays (e.g. String [] arrayOfStrings) is allowed.

## Timing and deadlines

The table below describes the timing of the course in Fall 2024.

> Note that if you want and are able to, **you may proceed faster** than the schedule indicates.

Each subdirectory contains detailed instructions in `README.md` files for that specific exercise or course project. As you go along to those exercises, view the readme files in each subdirectory for exercise / course project specific instructions.

When the course deadline comes, teachers will use automatic scripts that will clone all student repositories for evaluation and grading. The version on that date & time will be evaluated. Late deliveries are _not_ taken into account.

### Excercises

**Exercises** are scheduled so that you _start_ working on them the week indicated. You may take a week or two to work on an exercise task depending on your load. Note the deadlines (DL) for the difference exercise tasks in the table below. But do not push the work too far ahead, then you have many unfinished exercises to work with, overloading you. It's a recipe for losing points. Rather start working on the exercises _before_ the actual exercise sessions.

> Hint: You can keep track of your work by removing each `TODO` comment in the code for each exercise and project. When you cannot find any `TODO` items using the IDE search tool, and tests pass, you should be done. Note though that even though tests pass, your code may not be perfect or even acceptable if your implementation has faults not exposed by the tests.

| Week | Topic                 | Exercise task                      | Notes / Deadline |
| ---- | --------------------- | ---------------------------------- | ---------------- |
| 44   | 00 Course intro       | [00-init](00-init)                 | Non-graded task  |
|      | 01 Topic intro        | [01-arrays](01-arrays)             | Until DL 1       |
|      | 02 Time complexity    | [02-mode](02-mode)                 | Until DL 1       |
| 45   | 03 Analysis           | [03-draw](03-draw)                 | Until DL 1       |
|      | 03 Analysis           |                                    |                  |
|      | 04-1 Stack            | [04-1-stack](04-1-stack)           | Until DL 1       |
|      | 04-2/3 Queue + list   |                                    |                  |
| 46   | 05 Sorting algorithms | [04-2-queue](04-2-queue)           | Until DL 2       |
|      | 05 Sorting algorithms | [04-3-linkedlist](04-3-linkedlist) | Until DL 2       |
|      | 06 Hash tables        |                                    |                  |
|      | 06 Hash tables        |                                    |                  |
| 47   | 07 Binary search tree | [05-binsearch](05-binsearch)       | Until DL 2       |
|      | 07 Binary search tree | [05-invoices](05-invoices)         | Until DL 3       |
|      | 08 Graphs part 1      |                                    |                  |
|      | 08 Graphs part 1      |                                    | **DL 1: Nov 20** |
| 48   | 08 Graphs part 2      | [67-phonebook](67-phonebook)       | Until DL 3       |
|      | 08 Graphs part 2      |                                    |                  |
|      | 09 Design & Dynamic   |                                    |                  |
|      | 09 Design & Dynamic   |                                    |                  |
| 49   |                       |                                    | **DL 2: Dec 05** |
| 50   |                       |                                    |                  |
|      |                       |                                    | **DL 3: Jan 05** |

Time of deadline is always 23.59.59 EET of the relevant day.

## Grading

The course is graded with the following rules:

1. Exercise `00-init`is not graded. The purpose is to test that the tools are properly installed and to refresh your programming skills.
2. Teachers check that exercises solutions are at acceptable at the time of **deadline**. If not, the student has one week to improve the solution. If the solution(s) of that deadline is(are) still not acceptable, **10 points will be deducted** from those tasks. It is possible to compensate for lost points with the help of the optional exercise tasks.
3. 6 out of 8 exercises must be acceptable (at least 1 point).
4. Exercise `67-phonebook`is worth 10 points.
5. Optional exercise task `xx-braille`is worth 7.5 points (if acceptable).
6. Also `Books&Words`is optional and is worth 7.5 points (if acceptable).
7. The optional exam must be passed with minimum of 10 points from the total of 20 pts.
8. Code quality affects the evaluation. See list below.
9. The fact that test are passed, does not mean an acceptable or good solution (tests do not reveal everything).
10. Java Collection classes or algorithms are not allowed in `Books&Words`either. You _may_, and _are expected_, to use classes, data structures, and algorithms that you have constructed in the previous exercise tasks. In `xx-braille`, on the other hand, you may _not use_ data structures created in previous exercise tasks. More information on these from the teachers.

Remember that functionally correct course project _is not enough_. The course projects must be implemented with _time complexity_ in mind. If your project is not _fast_ enough with _large_ data sets, it may be graded failed even though it may be functionally correct, i.e. produces the correct result. This is explained in detail in the course introductory lectures.

Also note that here you will learn how to implement data structures and algorithms to be used in also other contexts and by other developers. The code must not therefore do anything else than what is is supposed to do. Examples of what the code should _not include or do_ are (what the submitted solutions should not contain):

- A data structure contains a `main()` method. (If you have created a main() method for own testing, remove it and make an own class (.java file) for your own tests in the same directory as the data structure classes, not test directory.)
- Code compiles with warnings.
- TODO comments created by the teacher. Remove these once the code is complete.
- Code includes code commented out, left there for some reason. Remove these. Exceptions are if you want to leave an alternative solution to a problem together with an explanation.
- Code includes unused classes, methods, variables, parmaeters, or constants. Remove these.
- Code includes experimental, "trying this stuff out" kind of code, not part of the actual data structure or algorithm implementation. Remove these.
- Code prints out something to the console (System.out.println or such), when not instructed to do so. _I/O is slow_ and it slows down the execution of the code. This has effect especially if tests measure running time. If not required byt the task, remove extra prints.
- The data structure or algoritm uses more memory, than what is necessary to implement it. The rule of thumb is to implement the algorithm in place, like for example, Quicksort or Heap sort. Some algorithms are designed to use additinal memory, such as Merge sort, this is allowed.
- Code is not readable or it is incomprehensible. Use correct indentations, follow Java naming conventions, use meaningful names for variables and methods, so that the code is easy to understand. Use the IDE's formating tool (in VS Code: right mouse click in the code editor > Format Document). Classes start with capital letters (`FastHashTable`), methods, variablse, parameters with lower case letters following `smallCamelCase`naming style, constants, like `CAPITALIZED_CONSTANT`, should be entirely capitalized.

The above points do not mean a task has failed, but may reduce points.

In the table below, optional tasks are marked with a $ sign.

|  Course task    | Min points     | Max Points      |
| --------------- | -------------- | --------------- |
| Exercises (8)   | 8 \* 1 = 8 pts | 8 \* 3 = 24 pts |
| **Optional**    |                |                 |
| $ xx-braille    |                | 7.5 pts         |
| $ Books&Words   |                | 7.5 pts         |
| $ 67-phoneboook |                | 10 pts          |
| $ Exam          | 10 pts         | 20 pts          |

Possible decimals (e.g., from Moodle exam) are rounded upwards to the next whole number before final grading.

Grade is determined from the points following the table below:

| Points | < 23 | 23-29 | 30-37 | 38-45 | 46-51 | >= 52 |
| ------ | ---- | ----- | ----- | ----- | ----- | ----- |
| Grade  | Fail | 1     | 2     | 3     | 4     | 5     |

**Note**: There is a cutoff point at score 45. Meaning if you do all the optional and mandatory tasks, your points will go beyond 45, so you'll get 45 points at max if you don't take the exam. On the other hand, if you take the exam, you have to get at least 10 from the exam in order to pass it.​

## Copying and plagiarizing

All code delivered as course work must be written by the student him/herself taking part in the course. Copying code from others and from the internet in this course is **forbidden**. You may work together with a student friend or small group, but each of you must write **each and every line** of code to your project by yourself. You may do pair programming, for example, so that you work together on the problem to solve and _both of you_ write your _own_ code in your _own_ repository to solve the tasks. _You yourself alone_ are responsible for your code and receive the course grade from work done with your project.

You may use the course demonstrations and other course material for inspiration for your implementations in the exercises and course projects. You may -- and it is also recommended -- also search the internet for help. This is actually an important developer skill to have. But again, **each and every line of code** must be written by yourself, not copy-pasted.

If you use any code from others as inspiration, you **must** acknowledge that in your code in the comments. Add the source of the inspiration in the comments and provide the URL to the inspiration.

If copying or plagiarizing is suspected, teachers will follow the [University of Oulu procedures (pdf)](https://www.oulu.fi/external/Ohje-vilppitapausten-ehkaisemiseen-ja-kasittelemiseen-Oulun-yliopistossa-2018.pdf) in handling these cases (will try to find the English version of the document). An interview with the student is arranged with course teachers. After hearing the student, teachers will decide if the issue should be taken forward. The minimum consequence is the immediate termination of the course for the student with a failed grade. If the case is serious, the matter will also be handed over to the Dean of the Faculty of Information Technology and Electrical Engineering.

## About

- Data structures and algorithms 2024.
- Study Program for Information Processing Science, Department of Information Technology and Electrical Engineering, University of Oulu.
