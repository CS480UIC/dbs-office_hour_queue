|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | student       | Student         |
| Relationship     | student-attends-queue        | Attends          |
| Attribute       | student_email        | Student Email          |
| Attribute      | full_name        |    Full Name       |
| Attribute | ta_list       | Teaching Assistant List         |
| Attribute | is_ta       | Is TA        |

| student |
| ----------- |
| student_email 1-1 (1)  |
| full_name     M-1 (1) |
| note     1-1 (0)  |
| ta_list     M-M (0) |
| is_ta     M-1 (0) |


Entity Name: Student

Synonyms: undergraduate, scholar

Description: A person studying at a school or college

Relationship maxima: 

Relationship minima:

Attribute maxima:

Attribute minima:

Cardinality:


|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | queue       | Queue         |
| Attribute       | student_email        | Student Email          |
| Attribute      | full_name        | Student Name          |
| Attribute | follow_up       | Follow up notes         |

<<<<<<< HEAD
Entity Name: queue
=======

| queue |
| ----------- |
| student_email 1-M (1)  |
| full_name     M-M (1) |
| follow_up     1-M (0)  |

Entity Name: Student
>>>>>>> 57ab6a9127ed5fe755891ec68f71a6e37b9081cf

Synonyms: line, row

Description: A sequence of people waiting for turn to be attended to.

Relationship maxima: 

Relationship minima:

Attribute maxima:

Attribute minima:

Cardinality:


|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity   | office_hour     | Office Hour |
| Relationship   | office_hour-hosts-queue  | Office Hour Hosts Queue          |
| Attribute |  course_number |  Course Number   |
| Attribute |  ta_email      |  Teaching Assistant Email   |
| Attribute |  meetup_time   |  Meeting Time  |
| Attribute |  meetup_date   |  Meeting Date   |

| office_hour |
| ----------- |
| course_number 1-1 (1)  |
| ta_email     1-M (1) |
| meetup_time     1-1 (1)  |
| meetup_date     1-1 (1)  |

Entity Name: office_hour

Synonyms: tutoring

Description: Time dedicatied by a teacher assistant with class work.

Relationship maxima: 

Relationship minima:

Attribute maxima:

Attribute minima:

Cardinality:

|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | course         | Course        |
| Relationship | course-creates-office_hour | Course Number |
| Attribute    | course_number        | Course Number       |
| Attribute    | teaching_assistant   | Teaching Assistant  |
| Attribute    | professor       | Professor         |

<<<<<<< HEAD
Entity Name: course
=======
| course |
| ----------- |
| course_number 1-1 (1)  |
| teaching_assistant     1-M (1) |
| professor     1-1 (1)  |


Entity Name: Student
>>>>>>> 57ab6a9127ed5fe755891ec68f71a6e37b9081cf

Synonyms: subject, lecture

Description: A specific curriculum taught by a professor.

Relationship maxima: 

Relationship minima:

Attribute maxima:

Attribute minima:

Cardinality:

|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | login       | Login         |
| Attribute    | email       | Email         |
| Attribute    | username    | Username      |
| Attribute    | password    | Paassword     |

<<<<<<< HEAD
Entity Name: login
=======

| login |
| -------------------- |
| email        1-1 (1) |
| username     1-1 (1) |
| password     1-1 (1) |


Entity Name: Student
>>>>>>> 57ab6a9127ed5fe755891ec68f71a6e37b9081cf

Synonyms: sign-in, logon

Description: Logging into a system/account

Relationship maxima: 

Relationship minima:

Attribute maxima:

Attribute minima:

Cardinality:
