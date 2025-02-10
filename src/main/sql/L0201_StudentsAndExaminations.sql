-- 题目链接：https://leetcode.cn/problems/students-and-examinations/
-- 题目描述：找出所有至少有一门课程成绩小于 60 分的学生的姓名和这些课程的成绩。结果按照学生姓名和课程名称升序排列。

SELECT s.student_name, 
    e.course_name, 
    e.score
FROM Students s
JOIN Examinations e ON s.student_id = e.student_id
WHERE e.score < 60
ORDER BY s.student_name ASC, e.course_name ASC 