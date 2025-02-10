WITH RankedSalaries AS (
    SELECT 
        id,
        company,
        salary,
        ROW_NUMBER() OVER (PARTITION BY company ORDER BY salary ASC) as rk,
        COUNT(*) OVER (PARTITION BY company) as cnt
    FROM Employee
)
SELECT 
    company,
    ROUND(
        AVG(salary),
        0
    ) as median
FROM RankedSalaries
WHERE 
    rk IN ((cnt + 1)/2, (cnt + 2)/2) 