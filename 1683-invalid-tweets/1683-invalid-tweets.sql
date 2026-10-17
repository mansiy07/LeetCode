# Write your MySQL query statement below
SELECT DISTINCT tweet_id
FROM Tweets WHERE length(content)>15;