# Write your MySQL query statement below
SELECT
    p.product_id,
    COALESCE(latest.new_price, 10) AS price
FROM (
    SELECT DISTINCT product_id
    FROM Products
) AS p
LEFT JOIN (
    SELECT product_id, new_price
    FROM (
        SELECT
            product_id,
            new_price,
            ROW_NUMBER() OVER (
                PARTITION BY product_id
                ORDER BY change_date DESC
            ) AS rn
        FROM Products
        WHERE change_date <= '2019-08-16'
    ) AS ranked
    WHERE rn = 1
) AS latest
    ON p.product_id = latest.product_id;