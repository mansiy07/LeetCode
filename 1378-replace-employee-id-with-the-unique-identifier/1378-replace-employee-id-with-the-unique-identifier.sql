# Write your MySQL query statement below
SELECT unique_id, name
FROM Employees AS emp
LEFT JOIN EmployeeUNI AS uni
ON emp.id = uni.id; 