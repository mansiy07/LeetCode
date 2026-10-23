# Write your MySQL query statement below
SELECT e.name, b.bonus 
    FROM Employee AS E 
    LEFT JOIN Bonus AS b
    ON e.empId = b.empId
    WHERE bonus < 1000 OR bonus IS null;