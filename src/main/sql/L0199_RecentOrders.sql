SELECT name as customer_name,
    customer_id,
    order_id,
    order_date
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id
WHERE (customer_id, order_date) IN (
    SELECT customer_id, MAX(order_date)
    FROM Orders
    GROUP BY customer_id
)
ORDER BY name ASC 