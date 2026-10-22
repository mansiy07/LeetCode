# Write your MySQL query statement below
SELECT DISTINCT a1.machine_id, round(AVG(a1.timestamp-a2.timestamp),3) AS processing_time 
FROM Activity AS a1
JOIN Activity AS a2
ON a1.machine_id = a2.machine_id AND a1.process_id = a2.process_id
WHERE a1.activity_type = 'end' AND a2.activity_type = 'start'
GROUP BY a1.machine_id;