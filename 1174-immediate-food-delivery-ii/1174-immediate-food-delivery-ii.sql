# Write your MySQL query statement below
WITH CustomerFirstOrders AS (
    SELECT
        customer_id,
        order_date,
        customer_pref_delivery_date,
        ROW_NUMBER() OVER(PARTITION BY customer_id ORDER BY order_date) AS rn
    FROM Delivery)
SELECT
    ROUND(AVG(CASE WHEN order_date = customer_pref_delivery_date THEN 1.00 ELSE 0.00 END) * 100,2) 
    AS immediate_percentage
FROM CustomerFirstOrders
WHERE rn = 1;