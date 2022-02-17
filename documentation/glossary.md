|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | student       | Student         |
| Relationship     | student-attends-queue        | Attends          |
| Attribute       | student_email        | Student Email          |
| Attribute      | full_name        |    Full Name       |
| Attribute | ta_list       | Teaching Assistant List         |
| Attribute | is_ta       | Is TA        |

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

Entity Name: queue

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

Entity Name: course

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

Entity Name: login

Synonyms: sign-in, logon

Description: Logging into a system/account

Relationship maxima: 

Relationship minima:

Attribute maxima:

Attribute minima:

Cardinality: