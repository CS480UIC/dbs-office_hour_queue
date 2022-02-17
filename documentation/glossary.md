|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | student       | Student         |
| Relationship     | student-attends-queue        | Attends          |
| Attribute       | student_email        | Student Email          |
| Attribute      | full_name        |    Full Name       |
| Attribute | ta_list       | Teaching Assistant List         |
| Attribute | is_ta       | Is TA        |


|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | queue       | Queue         |
| Attribute       | student_email        | Student Email          |
| Attribute      | full_name        | Student Name          |
| Attribute | follow_up       | Follow up notes         |


|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity   | office_hour     | Office Hour |
| Relationship   | office_hour-hosts-queue  | Office Hour Hosts Queue          |
| Attribute |  course_number |  Course Number   |
| Attribute |  ta_email      |  Teaching Assistant Email   |
| Attribute |  meetup_time   |  Meeting Time  |
| Attribute |  meetup_date   |  Meeting Date   |


|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | course         | Course        |
| Relationship | course-creates-office_hour | Course Number |
| Attribute    | course_number        | Course Number       |
| Attribute    | teaching_assistant   | Teaching Assistant  |
| Attribute    | professor       | Professor         |


|             | Formal Name | Informal Name |
| ----------- | ----------- | ------------- |
| Entity       | login       | Login         |
| Attribute    | email       | Email         |
| Attribute    | username    | Username      |
| Attribute    | password    | Paassword     |
