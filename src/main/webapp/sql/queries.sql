use office_hour_queue;

-- simple query #1
CREATE VIEW course_view AS
SELECT * FROM course
WHERE course_number > 300
ORDER BY course_number;

-- simple query #2
CREATE VIEW office_hour_view AS
SELECT * FROM office_hour
WHERE meetup_date >= '2022-04-01'
ORDER BY id_office_hour;

-- aggregate queries
-- AGGREGATE QUERY #2
-- numeric
CREATE VIEW number_of_tas_view AS
SELECT COUNT(*) AS number_of_tas FROM student
WHERE is_ta = 'Yes';

-- AGGREGATE QUERY #1
-- string
CREATE VIEW upper_name_view AS
SELECT UPPER(full_name) from student
WHERE is_ta = 'No';

-- group by and having
CREATE VIEW course_number_view AS
SELECT course_number FROM office_hour
GROUP BY course_number
HAVING COUNT(*) >= 1;

-- date
CREATE VIEW date_function_view AS
SELECT full_name from queue
WHERE DATE(queue_date) >= '2022-03-01';

-- complex
-- COMPLEX QUERY #1
-- any kind of join
CREATE VIEW inner_join_view AS
select course_number from course
INNER JOIN ta_list
ON course.course_number = ta_list.ta_course_number;

-- correlated subquery without EXIST
-- COMPLEX QUERY #2
CREATE VIEW ta_view AS
SELECT teaching_assistant from course
WHERE course_number = (SELECT MIN(course_number) FROM office_hour);

-- correlated subquery with EXIST
CREATE VIEW professor_view AS
SELECT professor from course
WHERE EXISTS (SELECT * from office_hour WHERE course.course_number = office_hour.course_number);