# Write your MySQL query statement below
SELECT d.Name as Department, 
e.Name AS Employee,
Salary FROM Department AS d 
JOIN Employee AS e
ON e.DepartmentId = d.Id
WHERE (e.Salary, e.DepartmentId) 
IN (SELECT MAX(e2.Salary), e2.DepartmentId 
FROM Employee e2 
GROUP BY e2.DepartmentId);