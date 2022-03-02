# ----- student -----

|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | student       | Student         |
| Relationship     | student-attends-queue        | Attends          |
| Attribute       | student_email        | Student Email          |
| Attribute      | full_name        |    Full Name       |
| Attribute | is_ta       | Is TA        |
| Attribute | queueID       | Queue ID         |

| student |
| ----------- |
| student_email 1-1 (1) NOT NULL |
| full_name     M-1 (1) NOT NULL |
| note     1-1 (0) NULL |
| is_ta     M-1 (0) NULL |
| queueID M-1 (0) NULL |

Entity Name: student

Synonyms: undergraduate, scholar

Description: A person studying at a school or college

# ----- queue -----

|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | queue       | Queue         |
| Attribute       | id_queue        | Queue ID          |
| Attribute       | student_email        | Student Email          |
| Attribute      | full_name        | Student Name          |
| Attribute | follow_up       | Follow up notes         |
| Attribute | queue_date       | Queue Date         |
| Attribute | office_hour_id      | ID of Office Hour        |

| queue |
| ----------- |
| id_queue M-1 (1) NOT NULL |
| full_name     M-M (1) NOT NULL |
| follow_up     1-M (0)  NULL |
| queue_date     1-M (0)  NOT NULL |
| office_hour_id     M-1 (0)  NOT NULL |

Entity Name: queue

Synonyms: line, row

Description: A sequence of people waiting for turn to be attended to.

# ----- office_hour -----

|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity   | office_hour     | Office Hour |
| Relationship   | office_hour-hosts-queue  | Office Hour Hosts Queue          |
| Attribute |  id_office_hour |  Office Hour ID   |
| Attribute |  course_number |  Course Number   |
| Attribute |  ta_email      |  Teaching Assistant Email   |
| Attribute |  meetup_time   |  Meeting Time  |
| Attribute |  meetup_date   |  Meeting Date   |

| office_hour |
| ----------- |
| course_number 1-1 (1) NOT NULL |
| course_number 1-1 (1) NOT NULL |
| ta_email     1-M (1) NOT NULL |
| meetup_time     1-1 (1) NOT NULL |
| meetup_date     1-1 (1)  NOT NULL |

Entity Name: office_hour

Synonyms: tutoring

Description: Time dedicatied by a teacher assistant with class work.

# ----- course -----

|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | course         | Course        |
| Relationship | course-creates-office_hour | Course Number |
| Attribute    | course_number        | Course Number       |
| Attribute    | teaching_assistant   | Teaching Assistant  |
| Attribute    | professor       | Professor         |

| course |
| ----------- |
| course_number 1-1 (1)  NOT NULL |
| teaching_assistant     1-M (1) |
| professor     1-1 (1)  NOT NULL |

Entity Name: course

Synonyms: subject, lecture

Description: A specific curriculum taught by a professor.

# ----- Login -----

|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | login       | Login         |
| Attribute    | email       | Email         |
| Attribute    | username    | Username      |
| Attribute    | password    | Password     |
| Attribute    | student_id    | Student ID     |

| login |
| -------------------- |
| email        1-1 (1) NOT NULL |
| username     1-1 (1) NOT NULL |
| password     1-1 (1) NOT NULL |
| student_id    1-1 (1) NOT NULL |

Entity Name: login

Synonyms: sign-in, logon

Description: Logging into a system/account

# PD5
Independent Entities: student, course

Dependent Entities: login, ta_list, queue, office_hour

Foreign Key constraint: You cannot create a login for a student that doesn't exist. You cannot create an office hour for a course that doesn't exist. You cannot create a queue for an office hour that doesn't exist.

Cascade: 
- ON DELETE: By deleting an office hour you also delete the queue. By deleting a student you also delete their login, ta_list and entry in queue.


We implemented the plural attribute ta_list by creating a separate table for it that has the PK ta_email. The FK in student table is student_email that refers to the ta_list PK. The relationship is M-1.


