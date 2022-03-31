use office_hour_queue;

-- simple queries
SELECT * FROM course
WHERE course_number > 300
ORDER BY course_number;

SELECT * FROM office_hour
WHERE meetup_date >= '2022-04-01'
ORDER BY id_office_hour;

-- aggregate queries
-- numeric
SELECT COUNT(*) AS number_of_tas FROM student
WHERE is_ta = 'Yes';

-- string
SELECT UPPER(full_name) from student
WHERE is_ta = 'No';

-- group by and having
SELECT course_number FROM office_hour
GROUP BY course_number
HAVING COUNT(*) >= 1;

-- date
SELECT full_name from queue
WHERE DATE(queue_date) >= '2022-03-01';

-- complex

-- any kind of join
select course_number from course
INNER JOIN ta_list
ON course.course_number = ta_list.ta_course_number;

-- correlated subquery without EXIST
SELECT teaching_assistant from course
WHERE course_number = (SELECT MIN(course_number) FROM office_hour);

-- correlated subquery with EXIST
SELECT professor from course
WHERE EXISTS (SELECT * from office_hour WHERE course.course_number = office_hour.course_number);